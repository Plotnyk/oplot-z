package app.model.entity.organization;

import app.model.entity.base.AbstractEntity;
import app.model.entity.geography.Address;
import app.model.entity.geography.City;
import app.model.entity.geography.Coordinate;

import java.util.Objects;

/**
 * Branch of the company where services will be provided
 * @author Plotnyk
 */
public class Branch extends AbstractEntity {
    /**Name Branch */
    private String nameBranch;

    private City city;

    /**Location of the branch office */
    private Address addressLocation;

    /**Parent company of the branch */
    private Company parentCompany;

    private Coordinate coordinate;

    /** Branch phone number*/
    private String phone;

    public Branch(String nameBranch, Company parentCompany) {
        this.nameBranch = Objects.requireNonNull(nameBranch, "'nameBranch' parameter is not initialized");
        this.parentCompany = Objects.requireNonNull(parentCompany, "'parentCompany' parameter is not initialized");
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((parentCompany == null) ? 0 : parentCompany.hashCode());
        result = prime * result + ((addressLocation == null) ? 0 : addressLocation.hashCode());
        result = prime * result + ((city == null) ? 0 : city.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj)) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        Branch other = (Branch)obj;
        if (addressLocation == null) {
            if (other.addressLocation != null)
                return false;
        } else if (!addressLocation.equals(other.addressLocation))
            return false;
        if (city == null) {
            if (other.city != null)
                return false;
        } else if (!city.equals(other.city))
            return false;
        return true;
    }

    public String getNameBranch() {
        return nameBranch;
    }

    public void setNameBranch(String nameBranch) {
        this.nameBranch = nameBranch;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Address getAddressLocation() {
        return addressLocation;
    }

    public void setAddressLocation(Address addressLocation) {
        this.addressLocation = addressLocation;
    }

    public Company getParentCompany() {
        return parentCompany;
    }

    public void setParentCompany(Company parentCompany) {
        this.parentCompany = parentCompany;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
