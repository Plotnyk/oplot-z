package app.service.impl;

import app.model.entity.geography.City;
import app.infra.util.CommonUtil;
import app.model.entity.organization.Branch;
import app.model.entity.organization.Company;
import app.model.search.criteria.BranchCriteria;
import app.model.search.criteria.CompanyCriteria;
import app.model.search.criteria.range.RangeCriteria;
import app.service.GeographicService;
import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Default implementation of the {@link GeographicService}
 * @author Plotnyk
 */
public class GeographicServiceImpl implements GeographicService{
    /**Internal list of cities*/
    private final List<City> cities;

    /**Auto-increment counter for entity id generation */
    private int counter = 0;

    public GeographicServiceImpl() {
        this.cities = new ArrayList<City>();
    }

    @Override
    public List<City> findCities() {
        return CommonUtil.getSafeList(cities);
    }

    @Override
    public Optional<City> findCitiyById(int id) {
        return cities.stream().filter(city -> city.getId()==id).findFirst();
    }

    @Override
    public List<Company> searchCompanies(CompanyCriteria criteria, RangeCriteria rangeCriteria) {
        Objects.requireNonNull(criteria, "'branchCriteria' parameter is ont initialized");
        Objects.requireNonNull(rangeCriteria, "'rangeCriteria' parameter is ont initialized");
        Stream<City> streamCity = cities.stream().filter(city -> StringUtils.isEmpty(criteria.getName()) || city.getName().equals(criteria.getName()));


        Optional<Set<Company>> companies = streamCity.map(City::getCompanies).reduce((companies1, companies2) -> {
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
    public void saveCity(City city) {
        Objects.requireNonNull(city, "'city' parameter is ont initialized");
        if (!cities.contains(city)) {
            city.setId(++counter);
            cities.add(city);
        }


    }

}
