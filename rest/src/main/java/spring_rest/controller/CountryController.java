package spring_rest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/api/countries")
public class CountryController {

    @RequestMapping(method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public List<String> findCities() {
        return Arrays.asList("Укрина", "Белорусь");
    }
}