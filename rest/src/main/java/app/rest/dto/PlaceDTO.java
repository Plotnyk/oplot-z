package app.rest.dto;

import app.model.entity.geography.District;
import app.model.entity.geography.Place;
import app.model.entity.geography.Region;
import app.rest.dto.base.BaseDTO;

/**
 * Holds city state for the client-server communication
 * @author Plotnyk
 *
 */
public class PlaceDTO extends BaseDTO<Place>{
    private String name;

    /**
     * Name of the district where city is placed
     */
    private District district;

    /**
     * Name of the region where district is located.
     * Region is top-level area in the country
     */
    private Region region;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    @Override
    public String toString() {
        return "PlaceDTO{" +
                "name='" + name + '\'' +
                ", district=" + district +
                ", region=" + region +
                '}';
    }
}
