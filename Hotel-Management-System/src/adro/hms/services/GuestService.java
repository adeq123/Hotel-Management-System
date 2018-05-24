package adro.hms.services;

import java.util.List;
import adro.hms.entity.Guest;
import adro.hms.entity.Room;

public interface GuestService {

	public List<Guest> getActualGuests ();
	public List<Guest> getArchivedGuests ();
	public List<Room> getVacantRooms();
	public List<Room> getOccupiedRooms();
	public void saveUpdateGuest(Guest theGuest);
	public void saveUpdateRoom(Room theRoom);
	public Room getRoomById(int id);
	public Guest getGuestById(int id);
}
