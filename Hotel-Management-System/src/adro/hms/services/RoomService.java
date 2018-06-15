package adro.hms.services;

import java.util.List;

import adro.hms.entity.Room;

/**
 * It's a service part of Service Facade Pattern. Suppling useful services to Room Controller and implementing the business logic
 * @author ADRO
 *
 */

public interface RoomService {
	
	/**
	 * Returns the room object from DB with a given id. The occupants list field is acquired with eager fetch
	 * @return room with a given id
	 */
	public Room getRoomById(int id) ;
	
	/**
	 * The method returns List of vacant rooms in the hotel
	 * @return, list o vacant rooms in the hotel
	 */
	public List<Room> getVacantRooms ();
	
	/**
	 * The method returns List of occupied rooms in the hotel
	 * @return, list o occupied rooms in the hotel
	 */
	public List<Room> getOccupiedRooms ();
	
	/**
	 * The method allow to save a new room in the DB or update existing one
	 * @param room to be saved or updated
	 */
	void saveUpdateRoom(Room theRoom);
}
