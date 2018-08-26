package app.model.entity.geography;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RegionTest {
    private Region region;


    @Before
    public void setUp() {
        Country country  = new Country("Україна");
        region = country.addRegion("Полтавський");
    }

    @Test
    public void testAddDistrictSuccess() {
        District district = region.addDistrict("Васильковский");
        region.addDistrict("Бориспольський");

        assertTrue(containsDistrict(region, district));
        assertEquals(region, district.getRegion());
        assertEquals(2, region.getDistricts().size());
    }

    @Test
    public void testAddDublicateDistrictSuccess() {
        region.addDistrict("Одеський");
        region.addDistrict("Одеський");

        assertEquals(region.getDistricts().size(), 1);
    }

    @Test
    public void testReturnDistrictsEmptySetSuccess() {
        assertTrue(region.getDistricts().isEmpty());
    }

    @Test(expected = NullPointerException.class)
    public void testAddNullDictrictSuccess() {
        region.addDistrict(null);
        fail();
    }

    @Test
    public void testRemoveDistrictSuccess() {
        District district = region.addDistrict("Васильковский");
        region.removeDistrict(district);
        assertTrue(region.getDistricts().isEmpty());
    }

    @Test(expected=NullPointerException.class)
    public void testRemoveNullDistrictSuccess() {
        region.removeDistrict(null);
        fail();
    }

    @Test
    public void testEqualsDistrictSuccess() {
        District district = region.addDistrict("Київська");
        District district2 = region.addDistrict("Київська");

        assertEquals(district, district2);

    }

    @Test
    public void testEqualDistrictFail() {
        District district = region.addDistrict("Київська");
        District district1 = region.addDistrict("Харівська");
        Region region1 = new Region("Житомирський", new Country("Выдумынй"));
        District district2 = region1.addDistrict("Київська");
        Region region2 = new Region("Полтавський", new Country("Выдумынй2"));
        District district3 = region2.addDistrict("Київська");

        assertNotEquals(district, district1);
        assertNotEquals(district, district2);
        assertNotEquals(district, district3);
    }

    @Test
    public void testAddPlaceWithoutDistrictSuccesss() {
        Place place = region.addPlaceWithoutDistrict("Киев");
        region.addPlaceWithoutDistrict("Симфирополь");

        assertTrue(containsCityWithout(region, place));
        assertEquals(region, place.getRegion());
        assertEquals(2, region.getPlacesWithoutDistrict().size());
    }

    @Test
    public void testAddDublicatePlaceWithoutSuccess() {
        region.addPlaceWithoutDistrict("Харківський");
        region.addPlaceWithoutDistrict("Харківський");

        assertEquals(region.getPlacesWithoutDistrict().size(), 1);
    }

    @Test
    public void testReturnPlaceWithoutEmptySetSuccess() {
        assertTrue(region.getPlacesWithoutDistrict().isEmpty());
    }

    @Test(expected = NullPointerException.class)
    public void testAddNullPlaceWithoutSuccess() {
        region.addPlaceWithoutDistrict(null);
        fail();
    }

    @Test
    public void testRemovePlaceWithoutSuccess() {
        Place place = region.addPlaceWithoutDistrict("Васильков");
        region.removePlaceWithoutDistrict(place);
        assertTrue(region.getPlacesWithoutDistrict().isEmpty());
    }

    @Test(expected=NullPointerException.class)
    public void testRemoveNullPlaceWithoutSuccess() {
        region.removePlaceWithoutDistrict(null);
        fail();
    }

    @Test
    public void testEqualsPlaceWithoutSuccess() {
        Place place = region.addPlaceWithoutDistrict("Київ");
        Place place1 = region.addPlaceWithoutDistrict("Київ");

        assertEquals(place, place1);

    }

    @Test
    public void testEqualPlaceWithoutFail() {
        Place place = region.addPlaceWithoutDistrict("Київ");
        Place place1 = region.addPlaceWithoutDistrict("Харьков");
        Region region1 = new Region("Житомирський", new Country("Выдумынй"));
        Place place2 = region1.addPlaceWithoutDistrict("Київ");
        Region region2 = new Region("Полтавський", new Country("Выдумынй2"));
        Place place3 = region2.addPlaceWithoutDistrict("Київ");

        assertNotEquals(place, place1);
        assertNotEquals(place, place2);
        assertNotEquals(place, place3);
    }

    private boolean containsDistrict(Region region, District district) {
        return region.getDistricts().contains(district);
    }

    private boolean containsCityWithout(Region region, Place place) {
        return region.getPlacesWithoutDistrict().contains(place);
    }
}