package adro.hms.services;

import java.util.List;

import adro.hms.entity.ToDo;

public interface GlobalAdviceService {
	
	public void addToDo(ToDo toDo);
	public List<ToDo> getToDo();
}
