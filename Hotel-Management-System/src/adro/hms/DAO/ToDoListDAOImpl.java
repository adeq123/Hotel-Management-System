package adro.hms.DAO;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import adro.hms.entity.ToDo;

/**
 * The class models a Data Access object for ToDo entities stored in the Database
 * @author ADRO
 *
 */

@Repository
public class ToDoListDAOImpl implements ToDoListDAO {

	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * The method allows to add a new ToDo to the db or update existing one
	 * @param ToDo to be saved or updated
	 */
	@Override
	public void addToDo(ToDo toDo) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(toDo);

	}
	/**
	 * Method returns all ToDos from the db
	 * @return, List of all ToDos in the database
	 */
	@Override
	public List<ToDo> getToDo() {

		Session session = sessionFactory.getCurrentSession();
		Query querry = session.createQuery("from ToDo");
		List <ToDo> toDoList = querry.getResultList();
		return toDoList;
	}

	/**
	 * Method allows to delete the given toDo from DB
	 * @param, ToDo to be delted
	 */
	@Override
	public void deleteToDo(ToDo toDo) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(toDo);

	}

	/**
	 * Method allows to delete the ToDo with a given id
	 * @param id, id of the ToDo to be deleted
	 */
	@Override
	public void deleteToDo(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("delete from ToDo where id=:toDoId");
		query.setParameter("toDoId", id);	
		query.executeUpdate();

	}

}