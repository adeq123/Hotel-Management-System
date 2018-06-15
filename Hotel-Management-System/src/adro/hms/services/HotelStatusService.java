package adro.hms.services;

import java.util.List;

import adro.hms.entity.Guest;
import adro.hms.entity.Room;

/**
 * It's a service part of Service Facade Pattern. Suppling useful services to Guest Controller and implementing the business logic
 * @author ADRO
 *
 */

public interface HotelStatusService {
	
	public List<Room> getAllRooms();
	public List<Guest> getActualGuests();
}
