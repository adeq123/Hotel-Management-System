package adro.hms.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import adro.hms.DAO.ToDoListDAO;
import adro.hms.entity.ToDo;

/**
 * It's a service part of Service Facade Pattern. Suppling useful services to GlobalAdvice Controller and implementing the business logic
 * @author ADRO
 *
 */

@Service
public class GlobalAdviceServiceImpl implements GlobalAdviceService{

	@Autowired
	private ToDoListDAO toDoDAO;
	
	/**
	 * The method allows to add a new To Do action to the list
	 * @param ToDo, the action to be added to the list
	 */
	@Override
	@Transactional
	public void addToDo(ToDo toDo) {
		toDoDAO.addToDo(toDo);
		
	}
	/**
	 * The method allows to get the To Do action list
	 */
	@Override
	@Transactional
	public List<ToDo> getToDo() {
		// TODO Auto-generated method stub
		return toDoDAO.getToDo();
	}

}
