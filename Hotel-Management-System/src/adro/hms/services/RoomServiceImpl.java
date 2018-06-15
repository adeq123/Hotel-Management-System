package adro.hms.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import adro.hms.DAO.RoomDAO;
import adro.hms.entity.Room;

/**
 * It's a service part of Service Facade Pattern. Suppling useful services to Room Controller and implementing the business logic
 * @author ADRO
 *
 */

@Service
public class RoomServiceImpl implements RoomService {

	@Autowired
	private RoomDAO roomDAO;
	
	/**
	 * @see RoomDAO
	 */
	@Override
	@Transactional
	public Room getRoomById(int id) {
		return roomDAO.getRoomById(id);
	}

	/**
	 * @see RoomDAO
	 */
	@Override
	@Transactional
	public List<Room> getVacantRooms() {
		return roomDAO.getVacantRooms();
	}

	/**
	 * @see RoomDAO
	 */
	@Override
	@Transactional
	public List<Room> getOccupiedRooms() {
		return roomDAO.getOccupiedRooms();
	}

	/**
	 * @see RoomDAO
	 */
	@Override
	@Transactional
	public void saveUpdateRoom(Room theRoom) {
		roomDAO.saveUpdateRoom(theRoom);
		
	}

}
