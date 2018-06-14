package adro.hms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import adro.hms.entity.ToDo;
import adro.hms.services.GlobalAdviceService;
/**
 * The methods of this controller are shared accross all of the controller in this SpringMVC application.
 * 
 * @author ADRO
 *
 */
@ControllerAdvice
public class GlobalControllerAdvice {

	@Autowired
	GlobalAdviceService globalAdviceService;

	/**
	 * This method gets all of the task form to do list and adds to the model,
	 * It will be returned as a response for every request to every controller method
	 * in this app and therefore available everywhere (in the views)
	 * @param model
	 */
	@ModelAttribute
	public void addToDoListModel(Model model) {

		List<ToDo> toDo = globalAdviceService.getToDo();
				model.addAttribute("toDo", toDo);

	}
}
