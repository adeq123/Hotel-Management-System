package adro.hms.DAO;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import adro.hms.entity.Room;

@Repository
public class RoomDAOImpl implements RoomDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public List<Room> getRooms() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Room order by number", Room.class);
		List<Room> rooms = query.getResultList();
		return rooms;
	}

	@Override
	public List<Room> getVacantRooms() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Room r where r.isOccupied = 0 order by number", Room.class);
		List<Room> rooms = query.getResultList();
		return rooms;
	}

	@Override
	public Room getRoomById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Room room = session.get(Room.class, id);
		return room;
	}

}
