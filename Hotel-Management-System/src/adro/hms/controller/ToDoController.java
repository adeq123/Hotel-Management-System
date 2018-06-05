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

@Controller
@RequestMapping("/toDo")
public class ToDoController {

	@Autowired	
	private ToDoService toDoService;

	@GetMapping("/")
	public String list (Model theModel) {
		theModel.addAttribute("todo", new ToDo());
		return "toDoList";
	}
	@PostMapping("/delete")
	public String deleteToDo(@RequestParam("id") int id) {
		toDoService.deleteToDo(id);
		return "redirect:/toDo/";
	}

	@PostMapping("/add")
	public String addToDo(@Valid @ModelAttribute("newToDo") ToDo newToDo)  {
		toDoService.addToDo(newToDo);
		return "redirect:/toDo/";
	}
}
