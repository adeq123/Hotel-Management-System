package adro.hms.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
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

import adro.hms.entity.User;
import adro.hms.services.AdministrationService;
/**
 * This is a  Controller part of Spring MVC framework based application. It is responsible for Administration tab in the app
 * 
 * @author ADRO
 *
 */
@Controller
@RequestMapping("/administration")
public class AdministrationController {

	@Autowired
	private AdministrationService adminService;

	/**
	 * Default mapping. This method checks if the logged in user is and Administrator or not.
	 * If administrator then you will see user list and can modify it. If not 
	 * you are not allowed to enter and you will be warned 
	 * @param session, Provides a way to identify a user across 
	 * @param theModel, Model to be send to the view
	 * @return view name
	 */
	@GetMapping("/")
	public String checkAdminAndShow(HttpSession session, Model theModel) {
		User loggedInUser = (User) session.getAttribute("loggedInUser");
		if(loggedInUser != null && loggedInUser.getFirstName().equals("admin")) {

			List<User> userList = adminService.getAllUsers();
			theModel.addAttribute("userList", userList);
			return "userList";

		}else {

			theModel.addAttribute("noAdminLoggedIn","You must be logged in as an admin to use administration tab");
			return "hotelStatus";

		}
	}

	/**
	 * The method creates empty User object (shell) which then
	 * is send to the view. Where it will be filled in with the form.
	 * @param theModel, Model to be send to the view
	 * @return view name - register form name in this case
	 */
	@GetMapping("/registerUser")
	public String showRegisterForm(Model theModel) {
		User user = new User();
		theModel.addAttribute("user", user);
		return "register";
	}

	/**
	 * The method will get user attribute from the form. If
	 * the data binding went without errors new user will be
	 * added to the DB and you will be redirected to the
	 * administration page. Otherwise, you will be redirected back to
	 * the registration form with error stated. The method will validate 
	 * the input as specified in User class
	 * @see User
	 * @param newUser, user that was binded in the form and send here
	 * @param bindingResult, contains the information whether the binding was successful or not
	 * @param theModel, 
	 * @return redirect to user list if successful. Back to registration form otherwise.
	 */
	@PostMapping("/registerUser")
	public String registerNewUser(@Valid @ModelAttribute("user") User newUser, BindingResult bindingResult, Model theModel) {
		if(bindingResult.hasErrors()) {

			theModel.addAttribute("user", newUser);
			return "register";

		}else {
			adminService.registerUser(newUser);
			return "redirect:/administration/";
		}
	}

	/**
	 * The method is used to delete selected user
	 * @param id, id of the user to be deleted
	 * @return redirect to user list
	 */
	@GetMapping("/delete")
	public String deleteUser(@RequestParam("tempUserId") int id) {
		adminService.deleteUser(id);
		return "redirect:/administration/";
	}

	/**
	 * The method is used to update selected user
	 * @param id, id of the user to be updated
	 * @return registration form with prefilled info
	 */
	@GetMapping("/updateUser")
	public String updateUser(@RequestParam("tempUserId") int id, Model theModel) {
		User user = adminService.getUser(id);
		theModel.addAttribute("user", user);
		return "register";
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
