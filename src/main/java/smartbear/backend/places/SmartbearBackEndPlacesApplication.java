package smartbear.backend.places;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * Spring boot application
 * Implements RESTful service back-end
 *
 * Supports 1 API call
 *
 * 1. Bundle retrieve done by call LocationController
 * (Method: GET Url: https://{host}/rest/v1/getLocation?lat={lat}&lng={lng})
 * which responds SearchPlaceJsonData in JSON format
 *
 */
@SpringBootApplication
public class SmartbearBackEndPlacesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmartbearBackEndPlacesApplication.class, args);
	}
}
