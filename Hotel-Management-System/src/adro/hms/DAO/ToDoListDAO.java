package adro.hms.DAO;

import java.util.List;

import adro.hms.entity.ToDo;

/**
 * The interface models a Data Access object for ToDo entities stored in the Database
 * @author ADRO
 *
 */

public interface ToDoListDAO {

	/**
	 * The method allows to add a new ToDo to the db or update existing one
	 * @param ToDo to be saved or updated
	 */
	public void addToDo(ToDo toDo);

	/**
	 * Method returns all ToDos from the db
	 * @return, List of all ToDos in the database
	 */
	public List<ToDo> getToDo();

	/**
	 * Method allows to delete the given toDo from DB
	 * @param, ToDo to be deleted
	 */
	public void deleteToDo(ToDo toDo);

	/**
	 * Method allows to delete the ToDo with a given id
	 * @param id, id of the ToDo to be deleted
	 */
	public void deleteToDo(int id);


}
