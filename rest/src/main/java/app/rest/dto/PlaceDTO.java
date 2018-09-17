package app.rest.dto;

import app.model.entity.geography.Place;
import app.rest.dto.base.BaseDTO;

/**
 * Holds place state for the client-server communication
 * @author Plotnyk
 *
 */
public class PlaceDTO extends BaseDTO<Place>{
    private String name;

    /**
     * Name of the district where city is placed
     */
    private String districtName;

    /**
     * Name of the region where district is located.
     * Region is top-level area in the country
     */
    private String regionName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    @Override
    public String toString() {
        return "PlaceDTO{" +
                "name='" + name + '\'' +
                ", district=" + districtName +
                ", region=" + regionName +
                '}';
    }
}
