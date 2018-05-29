package adro.hms.services;

import java.util.List;

import adro.hms.entity.Room;

public interface RoomService {
	public Room getRoomById(int id) ;
	public List<Room> getVacantRooms ();
	public List<Room> getOccupiedRooms ();
	void saveUpdateRoom(Room theRoom);
}
