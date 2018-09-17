package app.model.entity.geography;

import app.model.entity.base.AbstractEntity;

import javax.persistence.Embeddable;

/**
 *Value type that stores address attributes
 * of the specific office or branch or person
 * @author Plotnyk
 */
@Embeddable
public class Address extends AbstractEntity {
    private Place place;

    private String zipCode;

    private String street;

    private String houseNo;

    /**
     * (Optional) Apartment number if it's address
     * of the apartment
     */
    private String apartment;

    @Override
    public String toString() {
        return "Address{" + "country=" + place.getRegion().getCountry() +
                "place=" + place +
                ", zipCode='" + zipCode + '\'' +
                ", street='" + street + '\'' +
                ", houseNo='" + houseNo + '\'' +
                ", apartment='" + apartment + '\'' +
                '}';
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

}
