package adro.hms.DAO;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import adro.hms.entity.Guest;
import adro.hms.entity.Room;

/**
 * The class models a Data Access object for Room entities stored in the Database
 * @author ADRO
 *
 */
@Repository
public class RoomDAOImpl implements RoomDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	/**
	 * The method returns all of the rooms in the hotel
	 * @return, list of rooms in the hotel
	 */
	@Override
	public List<Room> getAllRooms() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Room order by number", Room.class);
		List<Room> rooms = query.getResultList();
		return rooms;
	}

	/**
	 * The method returns List of vacant rooms in the hotel
	 * @return, list o vacant rooms in the hotel
	 */
	@Override
	public List<Room> getVacantRooms() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("select r from Room r where r.isOccupied = 0 order by r.number", Room.class);
		List<Room> rooms = query.getResultList();
		return rooms;
	}
	/**
	 * Returns the room object from DB with a given id. The occupants list field is acquired with eager fetch
	 * @return room with a given id
	 */
	@Override
	public Room getRoomById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Room room = session.get(Room.class, id);
		Hibernate.initialize(room.getOccupants()); //otherwise lazy fetch excpetion - this object would not be available outside of transaction
		return room;
	}

	/**
	 * The method allow to save a new room in the DB or update existing one
	 * @param room to be saved or updated
	 */
	@Override
	public void saveUpdateRoom(Room room) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(room);
		
	}
	
	/**
	 * The method returns List of occupied rooms in the hotel
	 * @return, list o occupied rooms in the hotel
	 */
	@Override
	public List<Room> getOccupiedRooms() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("select r from Room r where r.isOccupied = 1 order by r.number", Room.class);
		List<Room> rooms = query.getResultList();
		rooms.forEach(r -> Hibernate.initialize(r.getOccupants())); //otherwise lazy fetch excpetion - this object would not be available outside of transaction)
		return rooms;
	}


}
