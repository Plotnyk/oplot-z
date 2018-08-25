package app.model.entity.geography;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CountryTest {
    Country country;

    @Before
    public void setUp() throws Exception {
        country = new Country("Україна");
    }

    @Test
    public void testAddRegionSuccess() {
        Region region = country.addRegion("Київська");
        country.addRegion("Львівська");

        assertTrue(containsRegion(country, region));
        assertEquals(country, region.getCountry());
        assertEquals(2, country.getRegions().size());
    }

    @Test
    public void testAddDublicateRegionSuccess() {
    }

    @Test(expected = NullPointerException.class)
    public void testAddNullRegionSuccess() {
    }

    @Test
    public void testRemoveRegionSuccess() {
    }

    @Test(expected=NullPointerException.class)
    public void testRemoveNullRegionSuccess() {
    }

    @Test
    public void testEqualRegionSuccess() {

    }

    @Test
    public void testEqualRegionFail() {

    }

    private boolean containsRegion(Country country, Region region) {
        return country.getRegions().contains(region);
    }
}