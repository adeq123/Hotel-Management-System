package adro.hms.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import adro.hms.entity.Guest;
import adro.hms.entity.Room;
import adro.hms.services.HotelStatusService;

@Controller
@RequestMapping("/hotelStatus")
public class HotelStatusController {

	@Autowired
	private HotelStatusService hotelStatusService;

	@GetMapping("/")
	public String showHotelStatus(Model theModel) {

		List<Guest> guestList = hotelStatusService.getActualGuests();
		List<Room> roomList = hotelStatusService.getAllRooms();

		Integer numberOfRooms = 0;
		Integer numberOfOccupiedRooms = 0;
		Integer numberOfFreeRooms = 0;

		for(Room theRoom : roomList) {
			numberOfRooms ++;
			if(theRoom.getIsOccupied()) {
				numberOfOccupiedRooms ++;	
			}else {
				numberOfFreeRooms ++;
			}

		}
		
		Integer numberOfGuests = 0;
		Integer upcommingCheckOuts = 0;
		
		for(Guest theGuest : guestList) {
			if(!theGuest.isCheckedout()) {
				numberOfGuests++;
			}else {
				if(theGuest.getCheckoutDate().isEqual(LocalDate.now()) || theGuest.getCheckoutDate().isBefore(LocalDate.now())) {
					upcommingCheckOuts++;
				}
			}
		}
		theModel.addAttribute("numberOfRooms", numberOfRooms);
		theModel.addAttribute("numberOfOccupiedRooms", numberOfOccupiedRooms);
		theModel.addAttribute("numberOfFreeRooms", numberOfFreeRooms);
		theModel.addAttribute("numberOfGuests", numberOfGuests);
		theModel.addAttribute("upcommingCheckOuts", upcommingCheckOuts);
		
		return "hotelStatus";
	}
}
