package app.service.impl;

import app.model.entity.geography.Country;
import app.model.entity.geography.District;
import app.model.entity.geography.Place;
import app.model.entity.geography.Region;
import app.model.entity.organization.Company;
import app.model.search.criteria.CompanyCriteria;
import app.model.search.criteria.range.RangeCriteria;
import app.service.GeographicService;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import persistence.repository.inmemory.InMemoryPlaceRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

/**
 * Contain unit-tests for {@link GeographicServiceImpl}
 * @author Plotnyk
 */
public class GeographicServiceImplTest {
    private static final int DEFAULT_CITY_ID = 1;

    private GeographicService service;
    private Place place;

    @Before

    public void setup() {
        service= new GeographicServiceImpl(new InMemoryPlaceRepository());
        place = new Place("Ирпень"
                , new District("Киев-Святошинский"
                , new Region("Киевская область"
                , new Country("Украина"))));
    }

    @Test
    @Ignore
    public void testNoDataReturnedAtStart() {
        List<Place> places = service.findPlaces();
        assertTrue(places.isEmpty());
    }

    @Test
    @Ignore
    public void testSaveNewCitySuccess() {
        service.savePlace(place);

        List<Place> places = service.findPlaces();
        assertEquals(places.size(), 1);
        assertEquals(places.get(0).getName(), "Ирпень");
    }

    @Test(expected = NullPointerException.class)
    public void testSaveNullCityFailure() {
        service.savePlace(null);

        assertTrue(false);
    }

    @Test
    public void testFindCityByIdSuccess() {
        service.savePlace(place);

        Optional<Place> foundCity = service.findPlaceById(DEFAULT_CITY_ID);
        assertTrue(foundCity.isPresent());
        assertEquals(foundCity.get().getId(), DEFAULT_CITY_ID);
    }

    @Test
    public void testFindCityByIdNotFound() {
        Optional<Place> foundCity = service.findPlaceById(DEFAULT_CITY_ID);
        assertFalse(foundCity.isPresent());
    }

    @Test
    public void testSearchCompaniesByNameSuccess() {
        place.setId(DEFAULT_CITY_ID);
        place.addCompany("Best_1");
        place.addCompany("Best_2");
        service.savePlace(place);

        List<Company> companies = service.searchCompanies(CompanyCriteria.byName("Ирпень"), new RangeCriteria(1, 5));
        assertNotNull(companies);
        assertEquals(companies.size(), 2);
        assertEquals(companies.get(0).getPlace(), place);
    }

    @Test
    public void testSearchCompaniesByNameNotFound() {
        List<Company> companies = service.searchCompanies(CompanyCriteria.byName("Ирпень"), new RangeCriteria(1, 5));
        assertNotNull(companies);
        assertTrue(companies.isEmpty());
    }

}