package adro.hms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import adro.hms.entity.ToDo;
import adro.hms.services.GlobalAdviceService;

@ControllerAdvice
public class GlobalControllerAdvice {

	@Autowired
	GlobalAdviceService globalAdviceService;

	@ModelAttribute
	public void addToDoListModel(Model model) {

		List<ToDo> toDo = globalAdviceService.getToDo();
				model.addAttribute("toDo", toDo);

	}
}
