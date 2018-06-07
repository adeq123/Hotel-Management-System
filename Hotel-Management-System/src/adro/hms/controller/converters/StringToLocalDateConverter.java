package adro.hms.controller.converters;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.core.convert.converter.Converter;

public class StringToLocalDateConverter implements Converter<String, LocalDate>{

	@Override
	public LocalDate convert(String dateString) {
		return LocalDate.parse(dateString, DateTimeFormatter.ISO_DATE);
	}

}
