package adro.hms.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import adro.hms.DAO.LoginDAO;
import adro.hms.entity.User;

/**
 * It's a service part of Service Facade Pattern. Suppling useful services to Login Controller and implementing the business logic
 * @author ADRO
 *
 */

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private LoginDAO loginDAO;
	
	/**
	 * @see LoginDAO
	 */
	@Override
	@Transactional
	public User getUser(String login) {
		return loginDAO.getUser(login);
	}

	/**
	 * The method checks with credentials given are match
	 * @param login, login used by user
	 * @param password, password used by user
	 * @return a user with given credentials are correct. Null otherwise
	 */
	@Override
	@Transactional
	public User loginUser(String login, String password) {
		User user = null;
		
		try {
		 user = getUser(login);
		}catch (javax.persistence.NoResultException e) {
			return null;
		}
		
		if(user != null && user.getPassword().equals(password)) {
			return user;
		}
		
		return null;
	}

}
