package spring_rest.dao;

import app.model.entity.geography.City;
import spring_rest.dao.base.BaseDTO;

/**
 * Holds city state for the client-server communication(ttt)
 * @author Plotnyk
 *
 */
public class CityDTO extends BaseDTO<City> {
    private String name;

    /**
     * Name of the district where city is placed
     */
    private String district;

    /**
     * Name of the region where district is located.
     * Region is top-level area in the country
     */
    private String region;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}
