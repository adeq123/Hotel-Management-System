package adro.hms.services;


import java.util.List;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import adro.hms.DAO.GuestDAO;
import adro.hms.DAO.RoomDAO;
import adro.hms.entity.Guest;
import adro.hms.entity.Room;

@Service
public class GuestServiceImpl implements GuestService{

	@Autowired
	private GuestDAO guestDAO;
	
	@Autowired
	private RoomDAO roomDAO;
	
	@Override
	@Transactional
	public List<Guest> getActualGuests() {
		return guestDAO.getActualGuests();
	}
	
	@Override
	@Transactional
	public Guest getGuestById(int id) {
		return guestDAO.getGuestById(id);
	}

	@Override
	@Transactional
	public List<Room> getVacantRooms() {
		return roomDAO.getVacantRooms();
	}

	@Override
	@Transactional
	public void saveUpdateGuest(Guest theGuest) {
		guestDAO.saveUpdateGuest(theGuest);
		
	}

	@Override
	@Transactional
	public Room getRoomById(int id) {
		return roomDAO.getRoomById(id);
	}

	@Override
	@Transactional
	public void saveUpdateRoom(Room theRoom) {
		roomDAO.saveUpdateRoom(theRoom);
		
	}

	@Override
	@Transactional
	public List<Guest> getArchivedGuests() {
		
		return guestDAO.getCheckedoutGuests();
	}

	@Override
	@Transactional
	public List<Room> getOccupiedRooms() {
		return roomDAO.getOccupiedRooms();
	}

	

}
