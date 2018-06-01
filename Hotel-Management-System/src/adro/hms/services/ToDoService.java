package adro.hms.services;

import adro.hms.entity.ToDo;

public interface ToDoService {
public void deleteToDo(ToDo theToDo);
public void deleteToDo(int id);
public void addToDo(ToDo theToDo);
}
