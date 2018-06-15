package adro.hms.services;

import java.util.List;

import adro.hms.entity.Guest;

/**
 * It's a service part of Service Facade Pattern. Suppling useful services to CommingCheckouts Controller and implementing the business logic
 * @author ADRO
 *
 */

public interface CommingCheckoutsService {

	/**
	 * The method returns List of guests which should checkout today, tomorrow or overstayed
	 * @return
	 */
	public List<Guest> getCommingCheckouts();
}
