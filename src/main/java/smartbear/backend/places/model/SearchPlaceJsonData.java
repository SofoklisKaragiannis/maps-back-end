package smartbear.backend.places.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Objects;


/**
 * supports SearchPlaceJsonData json contents
 * results - status
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SearchPlaceJsonData {

    @JsonProperty("results")
    private List<Place> results;

    @JsonProperty("status")
    private String status;

    private String message;

    public List<Place> getResults() {
        return results;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SearchPlaceJsonData that = (SearchPlaceJsonData) o;
        return Objects.equals(results, that.results) &&
                Objects.equals(status, that.status) &&
                Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(results, status , message);
    }
}
