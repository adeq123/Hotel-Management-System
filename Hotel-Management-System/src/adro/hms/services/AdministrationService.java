package adro.hms.services;

import java.util.List;

import adro.hms.entity.User;

public interface AdministrationService {

	public List<User> getAllUsers();
	public void registerUser(User user);
	public void deleteUser(int id);
	public User getUser(int id);
}
