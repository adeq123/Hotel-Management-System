package adro.hms.controller.converters;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.core.convert.converter.Converter;

/**
 *  Custom Converter to convert from String representation of date to LocalDate object. The class is regstered in Spring
 * @author ADRO
 *
 */
public class StringToLocalDateConverter implements Converter<String, LocalDate>{

	/**
	 * Converts from String to LocalDate. 
	 * String needs to be in appropriate format
	 */
	@Override
	public LocalDate convert(String dateString) {
		return LocalDate.parse(dateString, DateTimeFormatter.ISO_DATE);
	}

}
