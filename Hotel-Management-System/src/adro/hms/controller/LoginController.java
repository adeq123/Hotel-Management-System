package adro.hms.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import adro.hms.entity.User;
import adro.hms.services.LoginService;

/**
 * This is a  Controller part of Spring MVC framework based application. It is responsible for Login logic for the application
 * 
 * @author ADRO
 *
 */

@Controller
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	/**
	 * Method is just returning default screen.
	 * 
	 * @return, login page name
	 */
	@GetMapping("/login")
	public String showLoginForm() {
		return "login";
	}
	
	/**
	 * The method verifies if the given credentials are correct and match the records in the DB
	 * If the login / password are not correct then the error is shown.
	 * @param login, login of the user to be logged in
	 * @param password, password of the user to be logged in
	 * @param session, Session object from servlet to store currently logged in user 
	 * @param theModel, used to send the data to the view
	 * @return, redirect to hotel status if credentials correct, login page name otherwise
	 */
	@PostMapping("/login")
	public String verifyLogin(@RequestParam String login, @RequestParam String password,
			HttpSession session,Model theModel){
		User user = loginService.loginUser(login, password);
		if(user==null) {
			theModel.addAttribute("loginError", "Error login in. Please try again");
			return "login";
		}
		session.setAttribute("loggedInUser", user);
		return "redirect:/hotelStatus/";
		
	}
	
	/**
	 * The method allows to logout the user from application by mean of removing info about him from session
	 * and redirect to default login page
	 * @param session, session object storing the infor about logged in user
	 * @return, redirect to default page
	 */
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("loggedInUser");
		return "redirect:/";
	}
}
