package adro.hms.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import adro.hms.controller.RoomToStringConverter;
import adro.hms.controller.StringToRoomConverter;

@Configuration
@EnableWebMvc
public class ConsoleConfiguration implements WebMvcConfigurer{
	
   public void addFormatters(final FormatterRegistry registry) {  
      registry.addConverter(new RoomToStringConverter());
      registry.addConverter(new StringToRoomConverter());
   }
   
}
