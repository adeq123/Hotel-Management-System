package adro.hms.controller.converters;

import org.springframework.core.convert.converter.Converter;

import adro.hms.entity.Room;

/**
 * Custom class to Convert from String (representation of room) to Room class representation. The class is registered in Spring. 
 * @author ADRO
 *
 */

public class RoomToStringConverter  implements  Converter<Room,String>{

	@Override
	public String convert(Room room) {
		return String.valueOf(room.getStandard() + " " + room.getNumber());
	}

}
