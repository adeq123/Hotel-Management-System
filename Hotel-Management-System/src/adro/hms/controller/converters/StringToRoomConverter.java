package adro.hms.controller.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import adro.hms.entity.Room;
import adro.hms.services.GuestService;
import adro.hms.services.GuestServiceImpl;

/**
 * Custom class to Convert from String (representation of room) to Room object. The class is registered in Spring. 
 * @author ADRO
 *
 */
public class StringToRoomConverter implements  Converter<String,Room>{
	
	@Autowired
	GuestService guestService;
	
	/**
	 * Converts String (id of the room) to Room object
	 */
	@Override
	public Room convert(String id) {
		 Room room = guestService.getRoomById(Integer.parseInt(id));
		 return room;
	}

}
