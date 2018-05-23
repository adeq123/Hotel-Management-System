package adro.hms.controller;

import java.util.LinkedHashMap;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import adro.hms.entity.Guest;
import adro.hms.entity.Room;
import adro.hms.services.GuestService;


@Controller
@RequestMapping("/guest")
public class GuestController {

	@Autowired
	GuestService guestService;

	@GetMapping("/list")
	public String guestList(Model theModel) {

		List<Guest> guestList = guestService.getGuests();

		theModel.addAttribute("guestList", guestList);

		return "guestList";
	}

	@GetMapping("/showAddGuest")
	public String showAddGuest(Model theModel) {

		Guest guest = new Guest();
		List<Room> vacantRooms = guestService.getVacantRooms();
		LinkedHashMap<String, Room> vacantRoomsMap = populateRoomsMap(vacantRooms);

		theModel.addAttribute("guest", guest);
		theModel.addAttribute("vacantRoomsMap", vacantRoomsMap);

		return "addGuestForm";
	}

	@PostMapping("/saveGuest")
	public ModelAndView saveGuest (@Valid @ModelAttribute("guest") Guest theGuest, BindingResult binding) {

		if(binding.hasErrors()) {
			List<Room> vacantRooms = guestService.getVacantRooms();
			LinkedHashMap<String, Room> vacantRoomsMap = populateRoomsMap(vacantRooms);
			
			return new ModelAndView("addGuestForm", "vacantRoomsMap", vacantRoomsMap);

		}else {
			guestService.addGuest(theGuest);
			return new ModelAndView("redirect:/guest/list");
			
		}
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
}
