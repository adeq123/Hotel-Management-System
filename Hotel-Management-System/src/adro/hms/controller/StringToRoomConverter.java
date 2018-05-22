package adro.hms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import adro.hms.entity.Room;
import adro.hms.services.GuestService;
import adro.hms.services.GuestServiceImpl;
/**
 * Custom Converter to convert the Room class to the String representation and register it in the Spring.
 * @author Anna
 *
 */
public class StringToRoomConverter implements  Converter<String,Room>{
	
	@Autowired
	GuestService guestService;
	
	@Override
	public Room convert(String id) {
		 Room room = guestService.getRoomById(Integer.parseInt(id));
		 return room;
	}

}
