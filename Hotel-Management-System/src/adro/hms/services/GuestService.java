package adro.hms.services;

import java.util.List;
import adro.hms.entity.Guest;
import adro.hms.entity.Room;

public interface GuestService {

	public List<Guest> getGuests ();
	public List<Room> getVacantRooms();
	public void addGuest(Guest theGuest);
	public Room getRoomById(int id);
}
