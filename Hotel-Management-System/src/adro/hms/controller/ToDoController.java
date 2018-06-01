package adro.hms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	public String list () {
		return "toDoList";
	}
	@PostMapping("/delete")
	public String deleteToDo(@RequestParam("id") int id) {
		toDoService.deleteToDo(id);
		return "redirect:/";
	}

	@PostMapping("/add")
	public String addToDo(@ModelAttribute("newToDo") ToDo newToDo)  {
		toDoService.addToDo(newToDo);
		return "redirect:/";
	}
}
