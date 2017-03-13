package smartbear.backend.places.framework;

import java.util.HashMap;
import java.util.Map;

/**
 * Collection of static method
 */
public class StaticContent {

    private static final String GOOGLE_PLACE_SEARCH_URL = "https://maps.googleapis.com/maps/api/place/nearbysearch/json";
    private static final String GOOGLE_KEY = "AIzaSyBzlLYISGjL_ovJwAehh6ydhB56fCCpPQw";

    /**
     * check if a string contains only numeric characters
     * @param s
     * @return
     */
    public static boolean isNumeric(String s) {
        if (s != null) {
            return s.matches("[-+]?\\d*\\.?\\d+");
        }
        return false;
    }

    /**
     * Creates Google source by using
     * GOOGLE_PLACE_SEARCH_URL and sets parameters
     * @param lat
     * @param lng
     * @return
     */
    public static Source getGooglePlaceSearchSource(String lat, String lng) {
        Map<String, String> parameterMap = new HashMap<>();
        parameterMap.put("location", lat + "," + lng);
        parameterMap.put("radius", "100");
        parameterMap.put("key", GOOGLE_KEY);

        return new Source( GOOGLE_PLACE_SEARCH_URL, parameterMap);
    }
}
