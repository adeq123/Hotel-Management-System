package adro.hms.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import adro.hms.DAO.ToDoListDAO;
import adro.hms.entity.ToDo;

@Service
public class GlobalAdviceServiceImpl implements GlobalAdviceService{

	@Autowired
	private ToDoListDAO toDoDAO;
	
	@Override
	@Transactional
	public void addToDo(ToDo toDo) {
		toDoDAO.addToDo(toDo);
		
	}

	@Override
	@Transactional
	public List<ToDo> getToDo() {
		// TODO Auto-generated method stub
		return toDoDAO.getToDo();
	}

}
