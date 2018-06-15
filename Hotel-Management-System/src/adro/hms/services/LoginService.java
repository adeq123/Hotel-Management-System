package adro.hms.services;

import adro.hms.entity.User;

/**
 * It's a service part of Service Facade Pattern. Suppling useful services to Login Controller and implementing the business logic
 * @author ADRO
 *
 */

public interface LoginService {

	/**
	 * The method returns a User object from the database with a given login or null if not found
	 * @param login, String, login of the searched user
	 * @return, a User object from the database with a given login or null if not found
	 */
	public User getUser (String login);
	
	/**
	 * The method checks with credentials given are match
	 * @param login, login used by user
	 * @param password, password used by user
	 * @return a user with given credentials are correct. Null otherwise
	 */
	public User loginUser(String login, String password);
}
