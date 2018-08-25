package app.service.impl;

import app.model.entity.geography.Place;
import app.model.entity.organization.Company;
import app.model.search.criteria.CompanyCriteria;
import app.model.search.criteria.range.RangeCriteria;
import app.service.GeographicService;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

/**
 * Contain unit-tests for {@link GeographicServiceImpl}
 * @author Plotnyk
 */
public class GeographicServiceImplTest {
    /*private static final int DEFAULT_CITY_ID = 1;
    private GeographicService service;

    @Before
    public void setup() {
        service = new GeographicServiceImpl();
    }

    @Test
    public void testNoDataReturnedAtStart() {
        List<Place> cities = service.findCities();
        assertTrue(cities.isEmpty());
    }

    @Test
    public void testSaveNewCitySuccess() {
        Place place = new Place("Kyiv");
        service.saveCity(place);

        List<Place> cities = service.findCities();
        assertEquals(cities.size(), 1);
        assertEquals(cities.get(0).getName(), "Kyiv");
    }

    @Test(expected = NullPointerException.class)
    public void testSaveNullCityFailure() {
        service.saveCity(null);

        assertTrue(false);
    }

    @Test
    public void testFindCityByIdSuccess() {
        Place place = new Place("Odessa");
        service.saveCity(place);

        Optional<Place> foundCity = service.findCitiyById(DEFAULT_CITY_ID);
        assertTrue(foundCity.isPresent());
        assertEquals(foundCity.get().getId(), DEFAULT_CITY_ID);
    }

    @Test
    public void testFindCityByIdNotFound() {
        Optional<Place> foundCity = service.findCitiyById(DEFAULT_CITY_ID);
        assertFalse(foundCity.isPresent());
    }

    @Test
    @Ignore
    public void testSearchCompaniesByNameSuccess() {
        Place place = new Place("Odessa");
        place.setId(DEFAULT_CITY_ID);
        Company company_a = place.addCompany("Best_1");
        Company company_b = place.addCompany("Best_2");
        service.saveCity(place);

        List<Company> companies = service.searchCompanies(CompanyCriteria.byName("Odessa"), new RangeCriteria(1, 5));
        assertNotNull(companies);
        assertEquals(companies.size(), 2);
        assertEquals(companies.get(0).getPlace(), place);
    }

    @Test
    public void testSearchCompaniesByNameNotFound() {
        List<Company> companies = service.searchCompanies(CompanyCriteria.byName("Odessa"), new RangeCriteria(1, 5));
        assertNotNull(companies);
        assertTrue(companies.isEmpty());
    }


    @Test
    @Ignore
    public void testSearchBranchesByTransportTypeSuccess() {
        *//*Place city = new Place("Odessa");
        city.addCompany(TransportType.AUTO);
        service.saveCity(city);
        Place city2 = new Place("Kiev");
        city2.setId(2);
        city2.addStation(TransportType.AUTO);
        service.saveCity(city2);

        List<Station> stations = service.searchStations(new StationCriteria(TransportType.AUTO), new RangeCriteria(1, 5));
        assertNotNull(stations);
        assertEquals(stations.size(), 2);*//*
    }


    @Test
    @Ignore
    public void testSearchStationsByTransportTypeNotFound() {
        *//*Place city = new Place("Odessa");
        city.addStation(TransportType.AUTO);
        service.saveCity(city);
        Place city2 = new Place("Kiev");
        city2.setId(2);
        city2.addStation(TransportType.RAILWAY);
        service.saveCity(city2);

        List<Station> stations = service.searchStations(new StationCriteria(TransportType.AVIA), new RangeCriteria(1, 5));
        assertNotNull(stations);
        assertTrue(stations.isEmpty());*//*
    }*/
}