package app.service.impl;

import app.model.entity.geography.City;
import app.model.entity.organization.Branch;
import app.model.entity.organization.Company;
import app.model.search.criteria.BranchCriteria;
import app.model.search.criteria.CompanyCriteria;
import app.model.search.criteria.range.RangeCriteria;
import app.service.GeographicService;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;
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

    @Before
    public void setup() {
        service = new GeographicServiceImpl();
    }

    @Test
    public void testNoDataReturnedAtStart() {
        List<City> cities = service.findCities();
        assertTrue(cities.isEmpty());
    }

    @Test
    public void testSaveNewCitySuccess() {
        City city = new City("Kyiv");
        service.saveCity(city);

        List<City> cities = service.findCities();
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
        City city = new City("Odessa");
        service.saveCity(city);

        Optional<City> foundCity = service.findCitiyById(DEFAULT_CITY_ID);
        assertTrue(foundCity.isPresent());
        assertEquals(foundCity.get().getId(), DEFAULT_CITY_ID);
    }

    @Test
    public void testFindCityByIdNotFound() {
        Optional<City> foundCity = service.findCitiyById(DEFAULT_CITY_ID);
        assertFalse(foundCity.isPresent());
    }

    @Test
    public void testSearchCompaniesByNameSuccess() {
        City city = new City("Odessa");
        city.setId(DEFAULT_CITY_ID);
        Company company_a = city.addCompany("Best_1");
        Company company_b = city.addCompany("Best_2");
        service.saveCity(city);

        List<Company> companies = service.searchCompanies(CompanyCriteria.byName("Odessa"), new RangeCriteria(1, 5));
        assertNotNull(companies);
        assertEquals(companies.size(), 2);
        assertEquals(companies.get(0).getCity(), city);
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
        /*City city = new City("Odessa");
        city.addCompany(TransportType.AUTO);
        service.saveCity(city);
        City city2 = new City("Kiev");
        city2.setId(2);
        city2.addStation(TransportType.AUTO);
        service.saveCity(city2);

        List<Station> stations = service.searchStations(new StationCriteria(TransportType.AUTO), new RangeCriteria(1, 5));
        assertNotNull(stations);
        assertEquals(stations.size(), 2);*/
    }


    @Test
    @Ignore
    public void testSearchStationsByTransportTypeNotFound() {
        /*City city = new City("Odessa");
        city.addStation(TransportType.AUTO);
        service.saveCity(city);
        City city2 = new City("Kiev");
        city2.setId(2);
        city2.addStation(TransportType.RAILWAY);
        service.saveCity(city2);

        List<Station> stations = service.searchStations(new StationCriteria(TransportType.AVIA), new RangeCriteria(1, 5));
        assertNotNull(stations);
        assertTrue(stations.isEmpty());*/
    }
}