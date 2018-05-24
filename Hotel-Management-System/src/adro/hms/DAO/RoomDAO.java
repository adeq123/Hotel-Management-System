package adro.hms.DAO;

import java.util.List;

import adro.hms.entity.Guest;
import adro.hms.entity.Room;

public interface RoomDAO {

	public List<Room> getRooms();
	public List<Room> getVacantRooms();
	public Room getRoomById(int id);
	public void saveUpdateRoom(Room room);
	public List<Room> getOccupiedRooms();

}
