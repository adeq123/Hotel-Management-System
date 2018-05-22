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
	public List<Guest> getGuests() {
		return guestDAO.getGuests();
	}

	@Override
	@Transactional
	public List<Room> getVacantRooms() {
		return roomDAO.getRooms();
	}

	@Override
	@Transactional
	public void addGuest(Guest theGuest) {
		guestDAO.addGuest(theGuest);
		
	}

	@Override
	@Transactional
	public Room getRoomById(int id) {
		return roomDAO.getRoomById(id);
	}


}
