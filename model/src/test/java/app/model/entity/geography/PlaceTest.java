package app.model.entity.geography;

import app.model.entity.organization.Company;
import org.junit.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import static org.junit.Assert.*;
/**
 * Contains unit-test to check functionality of {@link Place} class
 * @author Plotnyk
 */
public class PlaceTest {
    private Place placeA, placeB, placeC;

    @Before
    public void setup() {

        Country country = new Country("Україна");

        Region regionA = new Region("Київська", country);

        District districtAA = new District("Білоцеркісвький", regionA);
        District districtAB = new District("Бориспільський", regionA);

        placeA = new Place("Біла церква", districtAA);
        placeB = new Place("Узин", districtAA);
        placeC = new Place("Васильки", districtAB);
    }

    @Test
    public void TestAddValidCompanySuccess() {
        Company company = placeA.addCompany("CTO_1");
        placeA.addCompany("CTO_2");
        placeA.addCompany("CTO_3");
        placeA.addCompany("CTO_4");
        //placeA.getCompanies().forEach(company1 -> System.out.println(company1.hashCode()));
        assertTrue(containsCompany(placeA, company));
        assertEquals(placeA, company.getPlace());
        assertEquals(4, placeA.getCompanies().size());
    }

    @Test(expected=NullPointerException.class)
    public void testAddNullStationFailure() {
        placeA.addCompany(null);
        fail();
    }

    @Test
    public void testaddDuplicateStationFailure() {
        placeA.addCompany("CTO_1");
        placeA.addCompany("CTO_1");

        assertEquals(placeA.getCompanies().size(), 1);
    }

    @Test
    public void testRemoveStationSuccess() {
        Company company = placeA.addCompany("CTO_1");
        placeA.removeCompany(company);
        assertTrue(placeA.getCompanies().isEmpty());
    }

    @Test
    public void testRemoveOneStationSuccess() {
        Company company = placeA.addCompany("CTO_1");
        placeA.addCompany("CTO_2");
        placeA.addCompany("CTO_3");
        placeA.addCompany("CTO_4");
        placeA.removeCompany(company);

        assertFalse(containsCompany(placeA, company));
        assertEquals(placeA.getCompanies().size(), 3);
    }

    @Test(expected=NullPointerException.class)
    public void testRemoveNullStationFailure() {
        placeA.removeCompany(null);
        fail();
    }

    @Test
    public void testEqualsCompanyFalse() {
        Company company = placeA.addCompany("CTO_1");
        Company company2 = placeA.addCompany("CTO_2");
        Company company3 = placeB.addCompany("CTO_1");
        Company company4 = placeC.addCompany("CTO_1");
        assertNotEquals(company, company2);
        assertNotEquals(company, company3);
        assertNotEquals(company, company4);
    }

    @Test
    public void testEqualsCompanyTrue() {
        Company company = placeA.addCompany("CTO_1");
        Company company2 = placeA.addCompany("CTO_1");
        assertEquals(company, company2);
    }


    private boolean containsCompany(Place place, Company company) {
        return place.getCompanies().contains(company);
    }

}