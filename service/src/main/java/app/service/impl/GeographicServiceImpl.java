package app.service.impl;

import app.model.entity.geography.Place;
import app.infra.util.CommonUtil;
import app.model.entity.organization.Company;
import app.model.search.criteria.CompanyCriteria;
import app.model.search.criteria.range.RangeCriteria;
import app.service.GeographicService;
import org.apache.commons.lang3.StringUtils;

//import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Stream;

/**
 * Default implementation of the {@link GeographicService}
 * @author Plotnyk
 */

//@Service("userService")
//@Transactional
public class GeographicServiceImpl implements GeographicService{
    /**Internal list of cities*/
    private final List<Place> cities;

    /**Auto-increment counter for entity id generation */
    private int counter = 0;

    public GeographicServiceImpl() {
        System.out.println("GeographicServiceImpl: " + getClass().getName());
        this.cities = new ArrayList<Place>();
    }

    @Override
    public List<Place> findCities() {
        return CommonUtil.getSafeList(cities);
    }

    @Override
    public Optional<Place> findCitiyById(int id) {
        return cities.stream().filter(city -> city.getId()==id).findFirst();
    }

    @Override
    public List<Company> searchCompanies(CompanyCriteria criteria, RangeCriteria rangeCriteria) {
        Objects.requireNonNull(criteria, "'branchCriteria' parameter is not initialized");
        Objects.requireNonNull(rangeCriteria, "'rangeCriteria' parameter is not initialized");
        Stream<Place> streamCity = cities.stream().filter(city -> StringUtils.isEmpty(criteria.getName()) || city.getName().equals(criteria.getName()));


        Optional<Set<Company>> companies = streamCity.map(Place::getCompanies).reduce((companies1, companies2) -> {
            Set<Company> newCompanies = new HashSet<>(companies2);
            newCompanies.addAll(companies1);
            return newCompanies;
        });
        if(!companies.isPresent()) {
            return Collections.emptyList();
        }
        return new ArrayList<>(companies.get());
    }

    @Override
    public void saveCity(Place place) {
        Objects.requireNonNull(place, "'place' parameter is ont initialized");
        if (!cities.contains(place)) {
            place.setId(++counter);
            cities.add(place);
        }


    }

}
