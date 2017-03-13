package smartbear.backend.places.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * supports Viewport json contents
 * northeast - southwest
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Viewport {

    @JsonProperty("northeast")
    private Location northeast;

    @JsonProperty("southwest")
    private Location southwest;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Viewport that = (Viewport) o;
        return Objects.equals(northeast, that.northeast) &&
                Objects.equals(southwest, that.southwest);
    }

    @Override
    public int hashCode() {
        return Objects.hash(northeast , southwest);
    }
}
