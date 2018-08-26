package app.model.entity.organization;

import app.infra.util.CommonUtil;
import app.model.entity.base.AbstractEntity;
import app.model.entity.geography.Address;
import app.model.entity.geography.Place;
import app.model.entity.geography.Coordinate;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Branch of the company where services will be provided
 * @author Plotnyk
 */
public class Branch extends AbstractEntity {
    /**Name Branch */
    private String nameBranch;

    private Place place;

    /**Location of the branch office */
    private Address addressLocation;

    /**Parent company of the branch */
    private Company parentCompany;

    private Branch parentBranch;

    private Set<Branch> branches;

    private Set<Performance> performances;

    private Coordinate coordinate;

    /** Branch phone number*/
    private String phone;


    public Branch addBranch(final String nameNewBranch) {
        Objects.requireNonNull(nameNewBranch, "'nameNewBranch' parameter is not initialized");
        if (branches == null) {
            branches = new HashSet<>();
        }
        Branch branch = new Branch(nameNewBranch, this);
        branches.add(branch);
        return branch;
    }

    public void removeBrench(Branch branch) {
        Objects.requireNonNull(branch, "'branch' parameter is not initialized");
        if (branch == null) {
            return;
        }
        branches.remove(branch);
    }

    public Performance addPerformance(final String nameNewPerformance) {
        Objects.requireNonNull(nameNewPerformance, "'nameNewPerformance' parameter is not initialized");
        if (performances == null) {
            performances = new HashSet<>();
        }
        Performance performance = new Performance(nameNewPerformance, this);
        performances.add(performance);
        return performance;
    }

    public void removePerformance(Performance delPerformance) {
        Objects.requireNonNull(delPerformance, "'delPerformance' parameter is not initialized");
        if (performances == null) {
            return;
        }
        performances.remove(delPerformance);
    }


    public Branch(String nameBranch, Company parentCompany) {
        this.nameBranch = Objects.requireNonNull(nameBranch, "'nameBranch' parameter is not initialized");
        this.parentCompany = Objects.requireNonNull(parentCompany, "'parentCompany' parameter is not initialized");
        this.place = parentCompany.getPlace();
    }
    public Branch(String nameBranch, Company parentCompany, Place place) {
        this.nameBranch = Objects.requireNonNull(nameBranch, "'nameBranch' parameter is not initialized");
        this.parentCompany = Objects.requireNonNull(parentCompany, "'parentCompany' parameter is not initialized");
        this.place = parentCompany.getPlace();
    }
    public Branch(String nameBranch, Branch parentBranch) {
        this.nameBranch = Objects.requireNonNull(nameBranch, "'nameBranch' parameter is not initialized");
        this.parentBranch = Objects.requireNonNull(parentBranch, "'parentBranch' parameter is not initialized");
        this.parentCompany = parentBranch.getParentCompany();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((parentCompany == null) ? 0 : parentCompany.hashCode());
        result = prime * result + ((addressLocation == null) ? 0 : addressLocation.hashCode());
        result = prime * result + ((place == null) ? 0 : place.hashCode());
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
        if (place == null) {
            if (other.place != null)
                return false;
        } else if (!place.equals(other.place))
            return false;
        return true;
    }

    public String getNameBranch() {
        return nameBranch;
    }

    public void setNameBranch(String nameBranch) {
        this.nameBranch = nameBranch;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
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

    public Set<Branch> getBranches() {
        return CommonUtil.getSafeSet(branches);
    }

    public Set<Performance> getPerformances() {
        return CommonUtil.getSafeSet(performances);
    }
}
