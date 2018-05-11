package adro.hms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import adro.hms.entity.Guest;
import adro.hms.services.GuestService;
import adro.hms.services.GuestServiceImpl;

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
		theModel.addAttribute(guest);
		return "addGuestForm";
	}
}
