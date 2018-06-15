package adro.hms.DAO;
/**
 * This interface models a Data Access Object for Guest Entity
 * 
 * @see guest
 */
import java.util.List;

import adro.hms.entity.Guest;

public interface GuestDAO {
	
	/**
	 * The method returns all checked in guests
	 */
	public List<Guest> getActualGuests();
	/**
	 * The method returns all checked out guests
	 */
	public List<Guest> getCheckedoutGuests();
	/**
	 * The method saves the new guest to the Data Base or updates it if already exists in the DB
	 * @param theGuest, Guest to be save / updated
	 */
	public void saveUpdateGuest(Guest theGuest);
	/**
	 * The method returns the guest with a given id or null if not found
	 */
	public Guest getGuestById(int id);

	/**
	 * Returns the list of guests which are about to check out tomorrow, today or overstayed
	 */
	public List<Guest> getCommingCheckouts();
}
