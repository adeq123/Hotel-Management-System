package adro.hms.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import adro.hms.DAO.LoginDAO;
import adro.hms.entity.User;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private LoginDAO loginDAO;
	
	@Override
	@Transactional
	public User getUser(String login) {
		return loginDAO.getUser(login);
	}

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
