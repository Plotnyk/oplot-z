package app.service.impl;

import app.model.entity.geography.Country;
import app.model.entity.geography.Place;
import app.infra.util.CommonUtil;
import app.model.entity.organization.Company;
import app.model.search.criteria.CompanyCriteria;
import app.model.search.criteria.range.RangeCriteria;
import app.service.GeographicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import persistence.repository.PlaceRepository;
import persistence.repository.inmemory.InMemoryPlaceRepository;


import java.util.*;
import java.util.stream.Collectors;


/**
 * Default implementation of the {@link GeographicService}
 * @author Plotnyk
 */
public class GeographicServiceImpl implements GeographicService{
    private static final Logger LOGGER = LoggerFactory.getLogger(GeographicServiceImpl.class);
    /**Internal list of places*/
    private final PlaceRepository placeRepository;
    private final List<Country> countries;

    /**Auto-increment counter for entity id generation */
    private int counter = 0;

    public GeographicServiceImpl() {
        this.placeRepository = new InMemoryPlaceRepository();
        this.countries = new ArrayList<Country>();
    }


    @Override
    public List<Place> findPlaces() {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("<-----------------Find all places---------------->");
        }
        return placeRepository.findAll();
    }

    @Override
    public Optional<Place> findPlaceById(int id) {
        return Optional.ofNullable(placeRepository.findById(id));
    }

    @Override
    public List<Company> searchCompanies(CompanyCriteria criteria, RangeCriteria rangeCriteria) {
        Objects.requireNonNull(criteria, "'branchCriteria' parameter is not initialized");
        Objects.requireNonNull(rangeCriteria, "'rangeCriteria' parameter is not initialized");
        Set<Company> companies = new HashSet<>();
        placeRepository.findAll().forEach(place -> companies.addAll(place.getCompanies()));
        return companies.stream().filter(company -> company.match(criteria)).collect(Collectors.toList());
    }

    @Override
    public void savePlace(Place place) {
        placeRepository.save(place);
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
