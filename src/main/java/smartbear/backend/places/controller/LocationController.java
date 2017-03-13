package smartbear.backend.places.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.async.DeferredResult;
import smartbear.backend.places.framework.Source;
import smartbear.backend.places.framework.StaticContent;
import smartbear.backend.places.framework.V1;
import smartbear.backend.places.model.SearchPlaceJsonData;
import smartbear.backend.places.service.GooglePlaceSearchAdapter;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * LocationController takes care calls of type
 * Method: GET Url: https://{host}/rest/v1/getLocation?lat={lat}&lng={lng}
 *
 *  Response body of type SearchPlaceJsonData in JSON format
 *
 */
@CrossOrigin
@RestController
@RequestMapping(V1.URI_RETRIEVE_ABSOLUTE)
public class LocationController {

    @Autowired
    GooglePlaceSearchAdapter googlePlaceSearchAdapter;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public DeferredResult<ResponseEntity<SearchPlaceJsonData>> lookupLocation(@RequestParam Map<String, String> parameters,
                                                                            HttpServletRequest request) {

        DeferredResult<ResponseEntity<SearchPlaceJsonData>> deferredResult = new DeferredResult<>();
        // receive parameter values
        Map<String, String> requestParameters = new HashMap<>(parameters);
        String lat = requestParameters.get("lat");
        String lng = requestParameters.get("lng");

        SearchPlaceJsonData searchPlaceJsonData = new SearchPlaceJsonData();
        // if invalid parameters --> bad request
        if (!StaticContent.isNumeric(lat) || !StaticContent.isNumeric(lng))  {
            searchPlaceJsonData.setStatus(HttpStatus.BAD_REQUEST.name());
            searchPlaceJsonData.setMessage("Wrong parameters");
            deferredResult.setResult(new ResponseEntity<>(searchPlaceJsonData, HttpStatus.BAD_REQUEST));
            return deferredResult;
        }

        // default google service
        searchPlaceJsonData = googlePlaceSearchAdapter.getPositionPlaces(lat, lng);
        deferredResult.setResult(new ResponseEntity<>(searchPlaceJsonData, HttpStatus.OK));

        return deferredResult;
    }

}
