package adro.hms.DAO;

import java.util.List;

import adro.hms.entity.ToDo;

public interface ToDoListDAO {
	
public void addToDo(ToDo toDo);
public void deleteToDo(ToDo toDo);
public void deleteToDo(int id);
public List<ToDo> getToDo();

}
