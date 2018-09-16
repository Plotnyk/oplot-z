package app.rest.controller;

import java.util.Arrays;
import java.util.List;

//@RestController
//@RequestMapping(value = "/api/countries")
public class CountryController {

    //@RequestMapping(method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public List<String> findCities() {
        return Arrays.asList("Укрина", "Белорусь");
    }
}