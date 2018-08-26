package app.service.impl;

import app.model.entity.geography.Place;
import app.infra.util.CommonUtil;
import app.model.entity.organization.Company;
import app.model.search.criteria.CompanyCriteria;
import app.model.search.criteria.range.RangeCriteria;
import app.service.GeographicService;
import org.apache.commons.lang3.StringUtils;

import java.util.*;
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
        Stream<Place> streamCity = places.stream().filter(place -> StringUtils.isEmpty(criteria.getName()) || place.getName().equals(criteria.getName()));


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
    public void savePlace(Place place) {
        Objects.requireNonNull(place, "'place' parameter is ont initialized");
        if (!places.contains(place)) {
            place.setId(++counter);
            places.add(place);
        }


    }

}
