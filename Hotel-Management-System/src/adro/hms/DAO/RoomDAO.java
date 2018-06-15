package adro.hms.DAO;

import java.util.List;

import adro.hms.entity.Guest;
import adro.hms.entity.Room;
/**
 * The interface models a Data Access object for Room entities stored in the Database
 * @author ADRO
 *
 */
public interface RoomDAO {

	/**
	 * The method returns all of the rooms in the hotel
	 * @return, list of rooms in the hotel
	 */
	public List<Room> getAllRooms();
	
	/**
	 * The method returns List of vacant rooms in the hotel
	 * @return, list o vacant rooms in the hotel
	 */
	public List<Room> getVacantRooms();
	
	/**
	 * Returns the room object from DB with a given id. The occupants list field is acquired with eager fetch
	 * @return room with a given id
	 */
	public Room getRoomById(int id);
	
	/**
	 * The method allow to save a new room in the DB or update existing one
	 * @param room to be saved or updated
	 */
	public void saveUpdateRoom(Room room);
	
	/**
	 * The method returns List of occupied rooms in the hotel
	 * @return, list o occupied rooms in the hotel
	 */
	public List<Room> getOccupiedRooms();

}
