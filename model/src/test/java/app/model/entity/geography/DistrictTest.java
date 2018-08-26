package app.model.entity.geography;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DistrictTest {

    private District district;

    @Before
    public void setUp() {
        Country country = new Country("Україна");
        Region region = new Region("Тернопыльський", country);
        district = region.addDistrict("Карпатський");

    }

    @Test
    public void testAddPlaceSuccess() {
        Place place = district.addPlace("Озерне");
        district.addPlace("Тернопіль");

        assertTrue(containsPlace(district, place));
        assertEquals(district, place.getDistrict());
        assertEquals(2, district.getPlaces().size());
    }

    @Test
    public void testAddDublicatePlaceSuccess() {
        district.addPlace("Тернопіль");
        district.addPlace("Тернопіль");

        assertEquals(district.getPlaces().size(), 1);
    }

    @Test(expected = NullPointerException.class)
    public void testAddNullPlaceSuccess() {
        district.addPlace(null);
        fail();
    }

    @Test
    public void testRemovePlaceSuccess() {
        Place place = district.addPlace("Тернопіль");
        district.removePlace(place);
        assertTrue(district.getPlaces().isEmpty());
    }

    @Test(expected=NullPointerException.class)
    public void testRemoveNullPlaceSuccess() {
        district.removePlace(null);
        fail();
    }

    @Test
    public void testEqualPlaceSuccess() {
        Place place = district.addPlace("Тернопіль");
        Place place1 = district.addPlace("Тернопіль");
        Place place2 = district.addPlace("Дубровка");

        assertEquals(place, place1);
        assertNotEquals(place, place2);
    }

    @Test
    public void testEqualPlaceFail() {
        Place place = district.addPlace("Тернопіль");
        Place place1 = district.addPlace("Дубровка");
        District district1 = new District("Карпатський", new Region("Тернопыльський", new Country("Белорусь")));
        Place place2 = district1.addPlace("Київська");
        Place place3 = district1.addPlace("Тернопіль");

        assertNotEquals(place, place1);
        assertNotEquals(place, place2);
        assertNotEquals(place, place3);
    }

    @Test
    public void testReturnPlaceEmptySetSuccess() {
        assertTrue(district.getPlaces().isEmpty());
    }

    private boolean containsPlace(District district, Place place) {
        return district.getPlaces().contains(place);
    }
}