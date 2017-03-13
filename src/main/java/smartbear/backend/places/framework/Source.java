package smartbear.backend.places.framework;

import java.util.HashMap;
import java.util.Map;

/**
 * Auxiliary class to form request URL
 * from {host} and parameters
 */
public class Source {

    String basic_url;

    Map<String, String> parameterMap = new HashMap<>();

    public Source (String basic_url, Map<String, String> parameterMap) {
        this.basic_url = basic_url;
        this.parameterMap = parameterMap;
    }

    public String getBasic_url() {
        return basic_url;
    }

    public Map<String, String> getParameterMap() {
        return parameterMap;
    }

    /**
     * Appends parameters to host
     * @return
     */
    public String getCompleteUrl() {
        StringBuffer url = new StringBuffer(getBasic_url());
        if (getParameterMap().size() >0) {
            url.append("?");
            getParameterMap().forEach((k, v) -> url.append(k + "=" + v + "&"));
            url.replace(url.length()-1, url.length(), "");
        }
        return url.toString();
    }
}
