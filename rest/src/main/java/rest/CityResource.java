/*
package rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

*/
/**
 * {@link CityResource} is REST web-service that handles city-related requests
 * @author Plotnyk
 *//*

@Controller
public class CityResource {

    */
/** look to mvc-config.xml for <mvc:message-converters>. It can produce 'pretty' json response. *//*

    @RequestMapping(value = "/rest/getAllDBLogsJSON", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    List<String> findCities() {
        ArrayList<String> result = new ArrayList<>();
        result.add("Odessa");
        result.add("Kiyv");
        return result;
    }
}
*/
