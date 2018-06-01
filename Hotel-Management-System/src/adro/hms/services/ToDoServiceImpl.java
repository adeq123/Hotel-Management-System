package adro.hms.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import adro.hms.DAO.ToDoListDAO;
import adro.hms.entity.ToDo;

@Service
public class ToDoServiceImpl implements ToDoService {
	
	@Autowired
	private ToDoListDAO toDoDAO;
	
	@Override
	@Transactional
	public void deleteToDo(ToDo theToDo) {
		toDoDAO.deleteToDo(theToDo);
	}

	@Override
	@Transactional
	public void addToDo(ToDo theToDo) {
		toDoDAO.addToDo(theToDo);
		
	}

	@Override
	@Transactional
	public void deleteToDo(int id) {
		toDoDAO.deleteToDo(id);
		
	}
	
	

}
