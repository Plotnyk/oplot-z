package app.model.entity.geography;

import app.model.entity.organization.Company;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
/**
 * Contains unit-test to check functionality of {@link City} class
 * @author Plotnyk
 */
public class CityTest {
    private City city;

    @Before
    public void setup() {
        city = new City("Kyiv");
    }
    @Test
    public void TestAddValidCompanySuccess() {
        Company company = city.addCompany("CTO_1");

        // странно отрабатывает :(
/*        System.out.println(city.getCompanies().size());
        System.out.println(company.equals(company));
        System.out.println(containsCompany(city, company));
        System.out.println(company.hashCode());
        city.getCompanies().forEach(company1 -> System.out.println(company1.hashCode()==company.hashCode())); */

        assertTrue(containsCompany(city, company));
        assertEquals(city, company.getCity());
    }

    @Test(expected=NullPointerException.class)
    public void testAddNullStationFailure() {
        city.addCompany(null);
        assertTrue(false);
    }

    @Test
    public void testaddDuplicateStationFailure() {
        Company company_A = city.addCompany("CTO_1");
        Company company_B = city.addCompany("CTO_1");

        assertEquals(city.getCompanies().size(), 1);
    }

    @Test
    public void testRemoveStationSuccess() {
        Company company = city.addCompany("CTO_1");

        city.removeCompany(company);

        assertTrue(city.getCompanies().isEmpty());
    }

    @Test(expected=NullPointerException.class)
    public void testRemoveNullStationFailure() {
        city.removeCompany(null);

        assertTrue(false);
    }


    private boolean containsCompany(City city, Company company) {
        return city.getCompanies().contains(company);
    }

}