package app.service.impl;

import app.model.entity.geography.Country;
import app.model.entity.geography.Place;
import app.infra.util.CommonUtil;
import app.model.entity.organization.Company;
import app.model.search.criteria.CompanyCriteria;
import app.model.search.criteria.range.RangeCriteria;
import app.service.GeographicService;

import java.util.*;
import java.util.stream.Collectors;


/**
 * Default implementation of the {@link GeographicService}
 * @author Plotnyk
 */

//@Service("userService")
//@Transactional
public class GeographicServiceImpl implements GeographicService{
    /**Internal list of places*/
    private final List<Place> places;
    private final List<Country> countries;

    /**Auto-increment counter for entity id generation */
    private int counter = 0;

    public GeographicServiceImpl() {
        this.places = new ArrayList<Place>();
        this.countries = new ArrayList<Country>();
    }

    @Override
    public List<Place> findPlaces() {
        return CommonUtil.getSafeList(places);
    }

    @Override
    public Optional<Place> findPlaceById(int id) {
        return places.stream().filter(place -> place.getId()==id).findFirst();
    }

    @Override
    public List<Company> searchCompanies(CompanyCriteria criteria, RangeCriteria rangeCriteria) {
        Objects.requireNonNull(criteria, "'branchCriteria' parameter is not initialized");
        Objects.requireNonNull(rangeCriteria, "'rangeCriteria' parameter is not initialized");
        Set<Company> companies = new HashSet<>();

        for (Place place : places) {
            companies.addAll(place.getCompanies());
        }
        return companies.stream().filter(company -> company.match(criteria)).collect(Collectors.toList());
    }

    @Override
    public void savePlace(Place place) {
        Objects.requireNonNull(place, "'place' parameter is ont initialized");
        if (!places.contains(place)) {
            place.setId(++counter);
            places.add(place);
        }


    }


    /*СТРАНЫ*/
    @Override
    public List<Country> findCountry() {
        return CommonUtil.getSafeList(countries);
    }

    @Override
    public Optional<Country> findCountryById(int id) {
        return countries.stream().filter(country -> country.getId()==id).findFirst();
    }

    @Override
    public void saveCountry(Country country) {
        Objects.requireNonNull(country, "'country' parameter is ont initialized");
        if (!countries.contains(country)) {
            country.setId(++counter);
            countries.add(country);
        }
    }

}
