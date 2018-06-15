package adro.hms.services;

import java.util.List;

import adro.hms.entity.User;
/**
 * It's a service part of Service Facade Pattern. Suppling useful services to Administration Controller and implementing the business logic
 * @author ADRO
 *
 */
public interface AdministrationService {

	/**
	 * The method returns a User object from the database with a given login or null if not found
	 * @param login, String, login of the searched user
	 * @return, a User object from the database with a given login or null if not found
	 */
	public List<User> getAllUsers();
	
	/**
	 * The method allows to register new user in the application
	 * @param User, user to be registered
	 */
	public void registerUser(User user);
	
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
