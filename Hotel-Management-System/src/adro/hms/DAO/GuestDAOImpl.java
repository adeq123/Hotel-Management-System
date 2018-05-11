package adro.hms.DAO;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import adro.hms.entity.Guest;

@Repository
public class GuestDAOImpl implements GuestDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public List<Guest> getGuests() {
	
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Guest order by lastName", Guest.class); //sproboj bez class
		List<Guest> guests = query.getResultList();
		
		return guests;
	}

}
