package adro.hms.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import adro.hms.entity.Guest;
import adro.hms.services.CommingCheckoutsService;
/**
 * This is a  Controller part of Spring MVC framework based application. It is responsible for Next Checkouts tab in the app
 * 
 * @author ADRO
 *
 */
@Controller
@RequestMapping("/commingCheckouts")
public class CommingCheckoutsController {

	@Autowired
	private CommingCheckoutsService commingCheckOutsService;

	/**
	 * The method returns the guests which should check out today, tomorrow or overstayed
	 * @param theModel
	 * @return, guest list view
	 */
	@GetMapping("/list")
	public String commingCheckoutsList(Model theModel) {

		List <Guest> commingCheckouts = commingCheckOutsService.getCommingCheckouts();
		
		theModel.addAttribute("guestList", commingCheckouts);
		return "guestList";

	}

}

