package app.model.entity.organization;

import app.model.entity.geography.Country;
import app.model.entity.geography.District;
import app.model.entity.geography.Place;
import app.model.entity.geography.Region;
import app.model.search.criteria.CompanyCriteria;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CompanyTest {

    private Place place;
    @Before
    public void setUp() throws Exception {
        place = new Place("Ирпень"
                , new District("Киев-Святошинский"
                , new Region("Киевская область"
                , new Country("Украина"))));
    }

    @Test
    public void addBranch() {
    }

    @Test
    public void removeBrench() {
    }

    @Test
    public void addPerformance() {
    }

    @Test
    public void removePerformance() {
    }

    @Test(expected=NullPointerException.class)
    public void testMatchCriteriaNotInitialized() {
        Company company = new Company(place, "Best1");

        company.match(null);

        fail();
    }

    @Test
    public void testMatchByNameSuccess() {
        Company company = new Company(place, "Best1");

        assertTrue(company.match(CompanyCriteria.byName("Ирпень")));
    }

    @Test
    public void testMatchByNameNotFound() {
        Company company = new Company(place, "Best1");

        assertFalse(company.match(CompanyCriteria.byName("Житомир")));
    }
}