package app.model.entity.organization;

import app.model.entity.base.AbstractEntity;
import app.model.entity.geography.Address;
import app.model.entity.geography.City;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 *The company that provides services
 * @author Plotnyk
 */
public class Company extends AbstractEntity {
    /** Name company*/
    private String nameCompany;

    /** Location of the company office*/
    private Address addressLocation;

    /** Branches of the company*/
    private Set<Branch> branches;

    /** Branches of the performances*/
    private Set<Performance> performances;

    /** Visible labels company  on the map */
    private boolean visibleMap;

    private City city;

    private String phone;

    public Company(final City city, final String nameCompany) {
        this.city = Objects.requireNonNull(city, "'city' parameter is not initialized");
        this.nameCompany = Objects.requireNonNull(nameCompany, "'nameCompany' parameter is not initialized");
        visibleMap = true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
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
        Company other = (Company)obj;
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

    public String getNameCompany() {
        return nameCompany;
    }

    public void setNameCompany(String nameCompany) {
        this.nameCompany = nameCompany;
    }

    public Address getAddressLocation() {
        return addressLocation;
    }

    public void setAddressLocation(Address addressLocation) {
        this.addressLocation = addressLocation;
    }

    public Set<Branch> getBranches() {
        return branches;
    }

    public Branch addBranch(final String nameNewBranch, final City city) {
        Objects.requireNonNull(nameNewBranch, "'nameNewBranch' parameter is not initialized");
        if (branches == null) {
            branches = new HashSet<>();
        }
        Branch branch = new Branch(nameNewBranch, this);
        branches.add(branch);
        return branch;
    }

    public City getCity() {
        return city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isVisibleMap() {
        return visibleMap;
    }

    public void setVisibleMap(boolean visibleMap) {
        this.visibleMap = visibleMap;
    }
}
