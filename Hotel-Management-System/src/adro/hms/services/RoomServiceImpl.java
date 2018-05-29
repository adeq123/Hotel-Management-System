package adro.hms.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import adro.hms.DAO.RoomDAO;
import adro.hms.entity.Room;

@Service
public class RoomServiceImpl implements RoomService {

	@Autowired
	RoomDAO roomDAO;
	
	@Override
	@Transactional
	public Room getRoomById(int id) {
		return roomDAO.getRoomById(id);
	}

	@Override
	@Transactional
	public List<Room> getVacantRooms() {
		return roomDAO.getVacantRooms();
	}

	@Override
	@Transactional
	public List<Room> getOccupiedRooms() {
		return roomDAO.getOccupiedRooms();
	}

	@Override
	@Transactional
	public void saveUpdateRoom(Room theRoom) {
		roomDAO.saveUpdateRoom(theRoom);
		
	}

}
