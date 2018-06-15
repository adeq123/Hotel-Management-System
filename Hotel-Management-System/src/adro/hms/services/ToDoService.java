package adro.hms.services;

import adro.hms.entity.ToDo;

/**
 * It's a service part of Service Facade Pattern. Suppling useful services to ToDO Controller and implementing the business logic
 * @author ADRO
 *
 */

public interface ToDoService {

	/**
	 * Method allows to delete the given toDo from DB
	 * @param, ToDo to be delted
	 */
	public void deleteToDo(ToDo theToDo);

	/**
	 * Method allows to delete the ToDo with a given id
	 * @param id, id of the ToDo to be deleted
	 */
	public void deleteToDo(int id);

	/**
	 * The method allows to add a new ToDo to the db or update existing one
	 * @param ToDo to be saved or updated
	 */
	public void addToDo(ToDo theToDo);
}
