package adro.hms.DAO;

/**
 * This class models a Data Access Object for Guest Entity
 * 
 * @see guest
 */
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
	private SessionFactory sessionFactory;
	
	/**
	 * The method returns all checked in guests
	 */
	@Override
	public List<Guest> getActualGuests() {
	
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("select g from Guest g where g.isCheckedout=0 order by lastName", Guest.class); 
		List<Guest> guests = query.getResultList();
		
		return guests;
	}

	/**
	 * The method returns all checked out guests
	 */
	@Override
	public List<Guest> getCheckedoutGuests() {
	
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("select g from Guest g where g.isCheckedout=1 order by lastName", Guest.class); 
		List<Guest> guests = query.getResultList();
		
		return guests;
	}
	/**
	 * The method saves the new guest to the Data Base or updates it if already exists in the DB
	 * @param theGuest, Guest to be save / updated
	 */
	@Override
	public void saveUpdateGuest(Guest theGuest) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(theGuest);
		
	}
	/**
	 * The method returns the guest with a given id or null if not found
	 */
	@Override
	public Guest getGuestById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Guest theGuest = session.get(Guest.class, id);
		return theGuest;
	}

	/**
	 * Returns the list of guests which are about to check out tomorrow, today or overstayed
	 */
	@Override
	public List<Guest> getCommingCheckouts() {
		
		LocalDate tomorrow = LocalDate.now();
		tomorrow.plusDays(2);
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("select g from Guest g where g.checkoutDate <= :tomorrow and g.isCheckedout = 1 order by checkoutDate", Guest.class); 
		query.setParameter("tomorrow", tomorrow);
		List<Guest> guests = query.getResultList();
		
		return guests;
	}

}
