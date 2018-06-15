package adro.hms.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import adro.hms.DAO.ToDoListDAO;
import adro.hms.entity.ToDo;

/**
 * It's a service part of Service Facade Pattern. Suppling useful services to ToDO Controller and implementing the business logic
 * @author ADRO
 *
 */


@Service
public class ToDoServiceImpl implements ToDoService {
	
	@Autowired
	private ToDoListDAO toDoDAO;
	
	/**
	 * @see ToDoListDAO
	 */
	@Override
	@Transactional
	public void deleteToDo(ToDo theToDo) {
		toDoDAO.deleteToDo(theToDo);
	}

	/**
	 * @see ToDoListDAO
	 */
	@Override
	@Transactional
	public void addToDo(ToDo theToDo) {
		toDoDAO.addToDo(theToDo);
		
	}

	/**
	 * @see ToDoListDAO
	 */
	@Override
	@Transactional
	public void deleteToDo(int id) {
		toDoDAO.deleteToDo(id);
		
	}
	
	

}
