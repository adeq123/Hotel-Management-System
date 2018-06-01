package adro.hms.DAO;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import adro.hms.entity.ToDo;

@Repository
public class ToDoListDAOImpl implements ToDoListDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void addToDo(ToDo toDo) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(toDo);
		
	}

	@Override
	public List<ToDo> getToDo() {
		
		Session session = sessionFactory.getCurrentSession();
		Query querry = session.createQuery("from ToDo");
		List <ToDo> toDoList = querry.getResultList();
		return toDoList;
	}

	@Override
	public void deleteToDo(ToDo toDo) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(toDo);
		
	}

	@Override
	public void deleteToDo(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("delete from ToDo where id=:toDoId");
		query.setParameter("toDoId", id);	
		query.executeUpdate();
		
	}

}