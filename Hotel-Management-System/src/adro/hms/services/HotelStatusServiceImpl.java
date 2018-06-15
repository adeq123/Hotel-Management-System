package adro.hms.services;

import java.util.List;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import adro.hms.DAO.GuestDAO;
import adro.hms.DAO.RoomDAO;
import adro.hms.entity.Guest;
import adro.hms.entity.Room;

/**
 * It's a service part of Service Facade Pattern. Suppling useful services to Guest Controller and implementing the business logic
 * @author ADRO
 *
 */

@Service
public class HotelStatusServiceImpl implements HotelStatusService{
	
	@Autowired
	private RoomDAO roomDAO; 
	
	@Autowired
	private GuestDAO guestDAO;
	
	/**
	 * @see RoomDAO
	 */
	@Override
	@Transactional
	public List<Room> getAllRooms() {
		return roomDAO.getAllRooms();
	}
	
	/**
	 * @see GuestDAO
	 */
	@Override
	@Transactional
	public List<Guest> getActualGuests() {
		return guestDAO.getActualGuests();
	}

}
