package adro.hms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hotelStatus")
public class HotelStatusController {

	public String showHotelStatus(Model theModel) {
		
		return "hotelStatus";
	}
}
