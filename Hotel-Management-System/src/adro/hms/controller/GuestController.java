package adro.hms.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.List;

import javax.mail.MessagingException;
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
/**
 * This is a  Controller part of Spring MVC framework based application. It is responsible for Administration tab in the app
 * 
 * @author ADRO
 *
 */

@Controller
@RequestMapping("/guest")
public class GuestController {

	@Autowired
	private GuestService guestService;

	/**
	 * The method fetch the guest list and sends it over to the view
	 * @param theModel
	 * @return, view name to be displayed
	 */
	@GetMapping("/list")
	public String guestList(Model theModel) {

		List<Guest> guestList = guestService.getActualGuests();
		theModel.addAttribute("guestList", guestList);

		return "guestList";
	}

	/**
	 * The method creates empty Guest object (shell) and sends it over to the view
	 * Where it is meant to be filled in with data entered by data binding.
	 * @param theModel, data to be send to the view,
	 * @return. view name, add guest form in this case
	 */
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
	/**
	 * The method allows to save the guest in the database. There is a validation added according to the specification form
	 * Guest class. If binding was successful then the guest is added and we are redirected to the guest list view. Other wise
	 * the add guest form is duplayed with errors on red.
	 * @param theGuest, the guest binded, to be  added to the DB
	 * @param bindingResult, contains the information on whether binding was successful or not. 
	 * @param theModel, data to be send to the view
	 * @return, view name 
	 */
	@PostMapping("/saveGuest")
	public String saveGuest (@Valid @ModelAttribute("guest") Guest theGuest, BindingResult bindingResult, Model theModel) {

		if(bindingResult.hasErrors()) {
			List<Room> vacantRooms = guestService.getVacantRooms();
			Room firstRoomOnList = vacantRooms.get(0);
			LinkedHashMap<String, Room> vacantRoomsMap = populateRoomsMap(vacantRooms);
			theModel.addAttribute("roomsMap", vacantRoomsMap);
			theModel.addAttribute("selectedRoom", firstRoomOnList);

			return "addGuestForm";

		}else {
			theGuest.getRoom().setOccupied(true);
			theGuest.setCheckinDate(LocalDate.now());
			guestService.saveUpdateRoom(theGuest.getRoom());
			guestService.saveUpdateGuest(theGuest);
			return "redirect:/guest/list";

		}
	}
	/**
	 * The method allows to check out the guest with a given ID.
	 * The checkout contains: setting the checkout date as todays day, set current room to null, set 
	 * Last checkout room to the room during checkout, set set checkout to true and delete occupants from the room.
	 * Moreover it will put occupied field in the room object to flase if there is no more guests there
	 * @param theId, the id of the guest to be displayed
	 * @param theModel, 
	 * @return, redirect to the guest list view
	 */
	@GetMapping("/checkout")
	public String checkoutGuest(@RequestParam("guestId") int theId, Model theModel) {

		Guest theGuest = guestService.getGuestById(theId);
		Room theRoom = guestService.getRoomById(theGuest.getRoom().getId());
		LocalDate localDate = LocalDate.now();
		localDate.format(DateTimeFormatter.ISO_LOCAL_DATE);

		theGuest.setCheckoutDate(localDate);
		theGuest.setCheckedout(true);
		theGuest.setRoom(null);
		theGuest.setLastCheckedoutRoom(theRoom);
		theRoom.getOccupants().remove(theGuest);
		if(theRoom.getOccupants().size() == 0) {
			theRoom.setOccupied(false);
		}

		guestService.saveUpdateGuest(theGuest);
		guestService.saveUpdateRoom(theRoom);

		return "redirect:/guest/list";
	}
	/**
	 * The method allows to update the guest info. 
	 * @param theId, the id of the guest to be updated.
	 * @param theModel, contains the data to be send over to the view
	 * @return, view containing a form with prefiled fields according to data from the guest
	 */
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

	/**
	 * The method finds the room with a given id, and then sends it to the add guest form as selected room (it
	 * is not possible to select any other room). Then you can fill in the guest data and save it. The guest 
	 * initially created as empty. 
	 * @param theRoomId
	 * @param theModel
	 * @return
	 */
	@GetMapping("/checkin")
	public String checkinGuestToSpecificRoom(@RequestParam("roomId") int theRoomId, Model theModel) {
		Guest theGuest = new Guest();
		Room selectedRoom = guestService.getRoomById(theRoomId);
		theModel.addAttribute("guest", theGuest);
		theModel.addAttribute("selectedRoom", selectedRoom);
		return "addGuestForm";
	}

	/**
	 * The method fetch the checked out guest list and sends it over to the view
	 * @param theModel
	 * @return, view name to be displayed
	 */
	@GetMapping("/archivedGuestsList")
	public String archivedGuests(Model theModel) {

		List<Guest> guestList = guestService.getArchivedGuests();
		theModel.addAttribute("guestList", guestList);

		return "archivedGuestsList";

	}

	/**
	 * The method creates the empty guest which is send to view - a form that will be used to specify the
	 * info about the guest. 
	 * @param theModel, the data send to the view
	 * @return, view name 
	 */
	@GetMapping("/checkInToOccupiedRoom")
	public String checkInToOccupiedRoom(Model theModel) {

		Room room = null;
		Guest guest = new Guest();
		LinkedHashMap<String, Room> occupiedRoomsMap = null;
		List<Room> occupiedRooms = guestService.getOccupiedRooms();
		if(!occupiedRooms.isEmpty()) {
			room = occupiedRooms.get(0);
			occupiedRoomsMap = populateRoomsMap(occupiedRooms);
		}


		theModel.addAttribute("selectedRoom", room); //the room to be shown as first on the list
		theModel.addAttribute("guest", guest);
		theModel.addAttribute("roomsMap", occupiedRoomsMap);

		return "addGuestForm";
	}

	/**
	 * The method will generate the bill info based on guest id given. Then it will be sent through  the model to the view
	 * @param id
	 * @param theModel
	 * @return
	 */
	@GetMapping("/bill")
	public String showBill(@RequestParam("guestId") int id, Model theModel) {
		Guest guest = guestService.getGuestById(id);
		Room room;
		int nightsNumber = guestService.getNightsNumber(guest);

		if(guest.getIsCheckedout()) {
			room = guest.getLastCheckedoutRoom();
		}else {
			room = guest.getRoom();
		}

		double rate = room.getRate();
		theModel.addAttribute("guest", guest);
		theModel.addAttribute("room", room);
		theModel.addAttribute("nightsNumber", nightsNumber);
		theModel.addAttribute("rate",rate);
		theModel.addAttribute("tax", Room.TAX*rate*nightsNumber);
		theModel.addAttribute("total", nightsNumber*rate*(1+Room.TAX));
		return "guestBill";
	}

	/**
	 * The method will save save the bill for the guest pointed by guestId parameter
	 * @see GuestServiceImpl
	 * @param id, id of guest used to generate the bill
	 * @param theModel, 
	 * @return, view name - redirect to guest list
	 */
	@PostMapping("bill/save")
	public String saveBill(@RequestParam("guestId") int id, Model theModel) {
		Guest guest = guestService.getGuestById(id);
		theModel.addAttribute("guestId", id);
		guestService.saveBillPDF(guest);
		return "redirect:/guest/list";
	}

	/**
	 * The method will send a generated bill for Guest (pointed by guestId) to the email address given
	 * @param id, id of the guest used for bill generation
	 * @param email, email address where the bill will be sent
	 * @param theModel, used for data transfer from controller to the view
	 * @return, view name - back to guest list
	 */
	@PostMapping("/bill/mail")
	public String sendBillByMail(@RequestParam("guestId") int id, @RequestParam("email") String email, Model theModel) {

		Guest guest = guestService.getGuestById(id);
		try {
			guestService.sendBillByMail(guest, email);
		} catch(javax.mail.internet.AddressException | javax.mail.SendFailedException e){
			theModel.addAttribute("error", "Incorrect emial adress!");
			e.printStackTrace();
		} catch (MessagingException e) {
			theModel.addAttribute("error", "Something wrong with your message! sorry...");
			e.printStackTrace();
		}
		List<Guest> guestList = guestService.getActualGuests();
		theModel.addAttribute("guestList", guestList);				

		return "guestList";
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

	/**
	 * The method is run before each request and it deletes the white spaces form the form fields.
	 * @param dataBinder
	 */
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
}
