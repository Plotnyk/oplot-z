package app.model.entity.geography;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CountryTest {
    private Country country;

    @Before
    public void setUp() {
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
        country.addRegion("Київська");
        country.addRegion("Київська");

        assertEquals(country.getRegions().size(), 1);
    }

    @Test(expected = NullPointerException.class)
    public void testAddNullRegionSuccess() {
        country.addRegion(null);
        fail();
    }

    @Test
    public void testRemoveRegionSuccess() {
        Region region = country.addRegion("Київська");
        country.removeRegion(region);
        assertTrue(country.getRegions().isEmpty());
    }

    @Test(expected=NullPointerException.class)
    public void testRemoveNullRegionSuccess() {
        country.removeRegion(null);
        fail();
    }

    @Test
    public void testEqualRegionSuccess() {
        Region region = country.addRegion("Київська");
        Region region1 = country.addRegion("Київська");

        assertEquals(region, region1);
    }

    @Test
    public void testEqualRegionFail() {
        Region region = country.addRegion("Київська");
        Region region1 = country.addRegion("Харковская");
        Country country1 = new Country("Белорусь");
        Region region2 = country1.addRegion("Київська");

        assertNotEquals(region, region1);
        assertNotEquals(region, region2);
    }

    @Test
    public void testReturnRegionEmptySetSuccess() {
        assertTrue(country.getRegions().isEmpty());
    }

    private boolean containsRegion(Country country, Region region) {
        return country.getRegions().contains(region);
    }
}