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
		Integer numberOfVacantRooms = 0;
		Integer numberOfVacantStandardRooms = 0;
		Integer numberOfVacantBusinessRooms = 0;
		Integer numberOfVacantPremiumRooms = 0;

		for(Room theRoom : roomList) {
			numberOfRooms ++;
			if(theRoom.getIsOccupied()) {
				numberOfOccupiedRooms ++;	
			}else {
				numberOfVacantRooms ++;
				if(theRoom.getStandard().equals("standard")) {
					numberOfVacantStandardRooms ++;
				}else if(theRoom.getStandard().equals("business")) {
					numberOfVacantBusinessRooms ++;
				}else {
					numberOfVacantPremiumRooms ++;
				}
			}

		}

		Integer numberOfGuests = 0;
		Integer upcommingCheckOuts = 0;

		for(Guest theGuest : guestList) {
			if(!theGuest.getIsCheckedout()) {
				numberOfGuests++;
			}else {
				if(theGuest.getCheckoutDate().isEqual(LocalDate.now()) || theGuest.getCheckoutDate().isBefore(LocalDate.now())) {
					upcommingCheckOuts++;
				}
			}
		}
		theModel.addAttribute("numberOfRooms", numberOfRooms);
		theModel.addAttribute("numberOfOccupiedRooms", numberOfOccupiedRooms);
		theModel.addAttribute("numberOfVacantRooms", numberOfVacantRooms);
		theModel.addAttribute("numberOfVacantStandardRooms", numberOfVacantStandardRooms);
		theModel.addAttribute("numberOfVacantBusinessRooms", numberOfVacantBusinessRooms);
		theModel.addAttribute("numberOfVacantPremiumRooms", numberOfVacantPremiumRooms);
		theModel.addAttribute("numberOfGuests", numberOfGuests);
		theModel.addAttribute("upcommingCheckOuts", upcommingCheckOuts);

		return "hotelStatus";
	}
}
