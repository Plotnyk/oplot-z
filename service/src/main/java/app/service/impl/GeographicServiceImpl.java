package app.service.impl;

import app.model.entity.geography.Place;
import app.infra.util.CommonUtil;
import app.model.entity.organization.Company;
import app.model.search.criteria.CompanyCriteria;
import app.model.search.criteria.range.RangeCriteria;
import app.service.GeographicService;
import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Default implementation of the {@link GeographicService}
 * @author Plotnyk
 */

//@Service("userService")
//@Transactional
public class GeographicServiceImpl implements GeographicService{
    /**Internal list of places*/
    private final List<Place> places;

    /**Auto-increment counter for entity id generation */
    private int counter = 0;

    public GeographicServiceImpl() {
        this.places = new ArrayList<Place>();
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

}
