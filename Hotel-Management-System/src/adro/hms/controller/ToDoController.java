package adro.hms.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import adro.hms.entity.ToDo;
import adro.hms.services.ToDoService;
/**
 * This is a  Controller part of Spring MVC framework based application. It is responsible for To Do tab in the app
 * 
 * @author ADRO
 *
 */
@Controller
@RequestMapping("/toDo")
public class ToDoController {

	@Autowired	
	private ToDoService toDoService;

	/**
	 * The method fetch the list of actions to do and sends it over to the view
	 * @param theModel, data to be send to the view
	 * @return, the view to be displayed
	 */
	@GetMapping("/")
	public String list (Model theModel) {
		theModel.addAttribute("todo", new ToDo());
		return "toDoList";
	}
	/**
	 * The method allows to delete the action (to do) with a given id
	 * @return, the view to be displayed
	 */
	@PostMapping("/delete")
	public String deleteToDo(@RequestParam("id") int id) {
		toDoService.deleteToDo(id);
		return "redirect:/toDo/";
	}
	/**
	 * The method allows to add the action (to do) to the list
	 * @param newToDo
	 * @return, the view to be displayed
	 */
	@PostMapping("/add")
	public String addToDo(@Valid @ModelAttribute("newToDo") ToDo newToDo)  {
		toDoService.addToDo(newToDo);
		return "redirect:/toDo/";
	}
}
