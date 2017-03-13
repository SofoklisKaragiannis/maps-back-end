package smartbear.backend.places.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * supports Location json contents
 * lat - lng
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Location {

    @JsonProperty("lat")
    private double lat;

    @JsonProperty("lng")
    private double lng;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Location that = (Location) o;
        return Objects.equals(lat, that.lat) &&
                Objects.equals(lng, that.lng);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lat , lng);
    }
}
