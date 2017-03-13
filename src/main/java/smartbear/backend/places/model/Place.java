package smartbear.backend.places.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Objects;


/**
 * supports Place json contents
 * geometry - icon - id - name - place_id - reference - scope - types - vicinity
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Place {

    @JsonProperty("geometry")
    private Geometry geometry;

    @JsonProperty("icon")
    private String icon;

    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("place_id")
    private String place_id;

    @JsonProperty("reference")
    private String reference;

    @JsonProperty("scope")
    private String scope;

    @JsonProperty("types")
    private List<String> types;

    @JsonProperty("vicinity")
    private String vicinity;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Place that = (Place) o;
        return Objects.equals(geometry, that.geometry) &&
                Objects.equals(icon, that.icon) &&
                Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(place_id, that.place_id) &&
                Objects.equals(reference, that.reference) &&
                Objects.equals(scope, that.scope) &&
                Objects.equals(types, that.types) &&
                Objects.equals(vicinity, that.vicinity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(geometry , icon, id, name, place_id, reference, scope, types, vicinity);
    }
}
