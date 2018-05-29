package adro.hms.services;

import java.util.List;

import adro.hms.entity.Guest;
import adro.hms.entity.Room;

public interface HotelStatusService {
	
	public List<Room> getAllRooms();
	public List<Guest> getActualGuests();
}
