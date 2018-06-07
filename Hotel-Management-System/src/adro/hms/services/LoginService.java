package adro.hms.services;

import adro.hms.entity.User;

public interface LoginService {

	public User getUser (String login);
	public User loginUser(String login, String password);
}
