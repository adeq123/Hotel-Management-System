package adro.hms.services;

import java.util.List;

import javax.mail.MessagingException;

import adro.hms.entity.Guest;
import adro.hms.entity.Room;

/**
 * It's a service part of Service Facade Pattern. Suppling useful services to Guest Controller and implementing the business logic
 * @author ADRO
 *
 */

public interface GuestService {

	public List<Guest> getActualGuests ();
	public List<Guest> getArchivedGuests ();
	public List<Room> getVacantRooms();
	public List<Room> getOccupiedRooms();
	public void saveUpdateGuest(Guest theGuest);
	public void saveUpdateRoom(Room theRoom);
	public Room getRoomById(int id);
	public Guest getGuestById(int id);
	public int getNightsNumber(Guest guest);
	public void saveBillPDF(Guest guest);
	public void sendBillByMail(Guest guest, String email) throws MessagingException;
}
