package adro.hms.DAO;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

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
	public List<Guest> getActualGuests() {
	
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("select g from Guest g where g.isCheckedout=0 order by lastName", Guest.class); //sproboj bez class
		List<Guest> guests = query.getResultList();
		
		return guests;
	}

	@Override
	public List<Guest> getCheckedoutGuests() {
	
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("select g from Guest g where g.isCheckedout=1 order by lastName", Guest.class); //sproboj bez class
		List<Guest> guests = query.getResultList();
		
		return guests;
	}
	
	@Override
	public void saveUpdateGuest(Guest theGuest) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(theGuest);
		
	}

	@Override
	public Guest getGuestById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Guest theGuest = session.get(Guest.class, id);
		return theGuest;
	}

	@Override
	public List<Guest> getCommingCheckouts() {
		
		LocalDate tomorrow = LocalDate.now();
		tomorrow.plusDays(2);
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("select g from Guest g where g.checkoutDate <= :tomorrow order by checkoutDate", Guest.class); //sproboj bez class
		query.setParameter("tomorrow", tomorrow);
		
		List<Guest> guests = query.getResultList();
		
		return guests;
	}

}
