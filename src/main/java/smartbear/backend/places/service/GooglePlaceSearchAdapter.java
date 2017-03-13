package smartbear.backend.places.service;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import smartbear.backend.places.framework.Source;
import smartbear.backend.places.framework.StaticContent;
import smartbear.backend.places.model.SearchPlaceJsonData;

/**
 * Take care of Google place search API calls
 */
@Service
public class GooglePlaceSearchAdapter {

    private final RestTemplate restTemplate;

    public GooglePlaceSearchAdapter(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    /**
     *  does Get call to Google place search and maps response data to SearchPlaceJsonData
     */
    public SearchPlaceJsonData getPositionPlaces(String lat, String lng) {
        // form new source
        Source source = StaticContent.getGooglePlaceSearchSource(lat, lng);
        return restTemplate.getForObject(source.getCompleteUrl(), SearchPlaceJsonData.class);
    }
}
