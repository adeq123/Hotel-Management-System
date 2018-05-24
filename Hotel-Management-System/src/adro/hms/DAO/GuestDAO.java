package adro.hms.DAO;

import java.util.List;

import adro.hms.entity.Guest;

public interface GuestDAO {
	
	public List<Guest> getActualGuests();
	public List<Guest> getCommingCheckouts();
	public void saveUpdateGuest(Guest theGuest);
	public Guest getGuestById(int id);
	public List<Guest> getCheckedoutGuests();
}
