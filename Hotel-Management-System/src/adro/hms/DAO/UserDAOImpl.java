package adro.hms.DAO;
/**
 * The class models a Data Access object for Users entities stored in the Database
 */

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import adro.hms.entity.User;

@Repository
public class UserDAOImpl implements LoginDAO{

	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * The method returns a User object from the database with a given login or null if not found
	 * @param login, String, login of the searched user
	 * @return, a User object from the database with a given login or null if not found
	 */
	@Override
	public User getUser(String login) {
		Session session = sessionFactory.getCurrentSession();
		User theUser = null;
		Query query = session.createQuery("select u from User u where u.login =:login", User.class);
		query.setParameter("login", login);
		theUser = (User) query.getSingleResult();
		return theUser;
	}

	/**
	 * The method returns all of the users in the database
	 * @return  all of the users in the database
	 */
	@Override
	public List<User> getAllUsers() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from User", User.class);
		List<User> userList = query.getResultList();
		return userList;
	}

	/**
	 * The method allows to save a new user or update the existing one
	 * @param, User, user to be saved or updated
	 */
	@Override
	public void saveOrUpdateUser(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(user);
	}

	/**
	 * The method allows to delete the user with a given id
	 * @param id, id of the user to be deleted 
	 */
	@Override
	public void deleteUser(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("delete from User where id=:userId");
		query.setParameter("userId", id);	
		query.executeUpdate();

	}

	/**
	 * The method return the User with a given id
	 * @param id, int, id of the user in the database
	 * @return, user with a given id to be returned
	 */
	@Override
	public User getUser(int id) {
		Session session = sessionFactory.getCurrentSession();
		User user = session.get(User.class, id);
		return user;

	}

}
