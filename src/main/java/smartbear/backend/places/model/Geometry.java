package smartbear.backend.places.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;


/**
 * supports Geometry json contents
 * location - viewport
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Geometry {

    @JsonProperty("location")
    private Location location;

    @JsonProperty("viewport")
    private Viewport viewport;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Geometry that = (Geometry) o;
        return Objects.equals(location, that.location) &&
                Objects.equals(viewport, that.viewport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(location , viewport);
    }
}
