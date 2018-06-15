package adro.hms.DAO;
/**
 * The interface models a Data Access Object for Users entities stored in the Database
 */
import java.util.List;

import adro.hms.entity.User;

public interface LoginDAO {

	/**
	 * The method returns a User object from the database with a given login or null if not found
	 * @param login, String, login of the searched user
	 * @return, a User object from the database with a given login or null if not found
	 */
	public User getUser(String login);

	/**
	 * The method returns all of the users in the database
	 * @return  all of the users in the database
	 */
	public List<User> getAllUsers();

	/**
	 * The method allows to save a new user or update the existing one
	 * @param, User, user to be saved or updated
	 */
	public void saveOrUpdateUser(User user);

	/**
	 * The method allows to delete the user with a given id
	 * @param id, id of the user to be deleted 
	 */
	public void deleteUser(int id);

	/**
	 * The method return the User with a given id
	 * @param id, int, id of the user in the database
	 * @return, user with a given id to be returned
	 */
	public User getUser(int id);
}
