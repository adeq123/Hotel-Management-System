package adro.hms.DAO;

import java.util.List;

import adro.hms.entity.Guest;

public interface GuestDAO {
	public List<Guest> getGuests();

	public void addGuest(Guest theGuest);
}
