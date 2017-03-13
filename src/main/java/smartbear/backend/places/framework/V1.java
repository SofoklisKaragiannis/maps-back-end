package smartbear.backend.places.framework;

/**
 * Back-end URI collection
 */
public class V1 {

    private static final String URI_BASE = "/rest/v1/";

    private static final String URI_GET_LOCATION = "getLocation";
    public static final String URI_RETRIEVE_ABSOLUTE = URI_BASE + URI_GET_LOCATION;

    private V1() {
    }
}
