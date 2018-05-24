package adro.hms.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import adro.hms.entity.Guest;
import adro.hms.entity.Room;
import adro.hms.services.GuestService;
import adro.hms.services.RoomService;


@Controller
@RequestMapping("/guest")
public class GuestController {

	@Autowired
	GuestService guestService;

	@GetMapping("/list")
	public String guestList(Model theModel) {

		List<Guest> guestList = guestService.getActualGuests();
		theModel.addAttribute("guestList", guestList);
		
		return "guestList";
	}

	@GetMapping("/showAddGuest")
	public String showAddGuest(Model theModel) {

		Guest guest = new Guest();
		List<Room> vacantRooms = guestService.getVacantRooms();
		Room firstRoomOnList = vacantRooms.get(0);
		vacantRooms.remove(firstRoomOnList);
		LinkedHashMap<String, Room> vacantRoomsMap = populateRoomsMap(vacantRooms);
		
		theModel.addAttribute("guest", guest);
		theModel.addAttribute("roomsMap", vacantRoomsMap);
		theModel.addAttribute("selectedRoom", firstRoomOnList); //the room to be shown as first on the list
		
		return "addGuestForm";
	}

	@PostMapping("/saveGuest")
	public String saveGuest (@Valid @ModelAttribute("guest") Guest theGuest, BindingResult binding, Model theModel) {

		if(binding.hasErrors()) {
			List<Room> vacantRooms = guestService.getVacantRooms();
			Room firstRoomOnList = vacantRooms.get(0);
			LinkedHashMap<String, Room> vacantRoomsMap = populateRoomsMap(vacantRooms);
			theModel.addAttribute("roomsMap", vacantRoomsMap);
			theModel.addAttribute("selectedRoom", firstRoomOnList);
			
			return "addGuestForm";

		}else {
			theGuest.getRoom().setOccupied(true);
			guestService.saveUpdateRoom(theGuest.getRoom());
			guestService.saveUpdateGuest(theGuest);
			return "redirect:/guest/list";
			
		}
	}

	@GetMapping("/checkout")
	public String checkoutGuest(@RequestParam("guestId") int theId, Model theModel) {
		
		Guest theGuest = guestService.getGuestById(theId);
		Room theRoom = guestService.getRoomById(theGuest.getRoom().getId());
		LocalDate localDate = LocalDate.now();
		localDate.format(DateTimeFormatter.ISO_LOCAL_DATE);
		
		
		theGuest.setCheckoutDate(localDate);
		theGuest.setCheckedout(true);
		theRoom.getOccupants().remove(theGuest);
		if(theRoom.getOccupants().size() == 0) {
			theRoom.setOccupied(false);
		}
		
		guestService.saveUpdateGuest(theGuest);
		guestService.saveUpdateRoom(theRoom);
		
		return "redirect:/guest/list";
	}

	@GetMapping("/update")
	public String udpateGuest(@RequestParam("guestId") int theId, Model theModel) {
		Guest theGuest = guestService.getGuestById(theId);
		
		List<Room> vacantRooms = guestService.getVacantRooms();
		Room selectedRoom = theGuest.getRoom(); //previously selected room to be shown as first on the list
		vacantRooms.remove(selectedRoom);
		LinkedHashMap<String, Room> vacantRoomsMap = populateRoomsMap(vacantRooms);
		
		

		theModel.addAttribute("guest", theGuest);
		theModel.addAttribute("roomsMap", vacantRoomsMap);
		theModel.addAttribute("selectedRoom", selectedRoom);
		return "addGuestForm";
	}
	
	@GetMapping("/archivedGuestsList")
	public String archivedGuests(Model theModel) {
		
		List<Guest> guestList = guestService.getArchivedGuests();
		theModel.addAttribute("guestList", guestList);

		return "archivedGuestsList";
		
	}
	
	@GetMapping("/checkInToOccupiedRoom")
	public String checkInToOccupiedRoom(Model theModel) {
		
		Guest guest = new Guest();
		List<Room> occupiedRooms = guestService.getOccupiedRooms();
		LinkedHashMap<String, Room> occupiedRoomsMap = populateRoomsMap(occupiedRooms);

		theModel.addAttribute("guest", guest);
		theModel.addAttribute("roomsMap", occupiedRoomsMap);
		theModel.addAttribute("selectedRoom", occupiedRoomsMap.remove(occupiedRooms.get(0))); //the room to be shown as first on the list
		return "addGuestForm";
	}
	/**
	 * Maps the rooms list to to Map where a key is the room id (from DataBase) and the value is the room itself.
	 * In that configuration, we will get an id out of the drop down in the form.
	 * @param rooms
	 * @return
	 */
	private LinkedHashMap<String, Room> populateRoomsMap(List<Room> rooms){

		if(rooms == null || rooms.size() == 0) {
			rooms.add(new Room(0, "No vacant rooms", true, null));
		}
		LinkedHashMap<String, Room> roomsMap = new LinkedHashMap<String, Room>();
		for(Room room : rooms) {
			roomsMap.put(Integer.toString(room.getId()), room);
		}
		return roomsMap;
	}
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
}
