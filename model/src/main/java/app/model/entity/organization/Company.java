package app.model.entity.organization;

import app.infra.util.CommonUtil;
import app.model.entity.base.AbstractEntity;
import app.model.entity.geography.Address;
import app.model.entity.geography.Place;
import app.model.search.criteria.CompanyCriteria;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 *The company that provides services
 * @author Plotnyk
 */

@Table(name = "COMPANY")
@Entity
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

    private Place place;

    private String phone;

    public Branch addBranch(final String nameNewBranch, final Place place) {
        Objects.requireNonNull(nameNewBranch, "'nameNewBranch' parameter is not initialized in Company");
        if (branches == null) {
            branches = new HashSet<>();
        }
        Branch branch = new Branch(nameNewBranch, this);
        branches.add(branch);
        return branch;
    }

    public void removeBrench(Branch branch) {
        Objects.requireNonNull(branch, "'branch' parameter is not initialized in Company");
        if (branch == null) {
            return;
        }
        branches.remove(branch);
    }

    public Performance addPerformance(final String nameNewPerformance) {
        Objects.requireNonNull(nameNewPerformance, "'nameNewPerformance' parameter is not initialized in Company");
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

    public boolean match(final CompanyCriteria companyCriteria) {
        Objects.requireNonNull(companyCriteria, "Company criteria is not initialized");
        if (!StringUtils.isEmpty(companyCriteria.getName())) {

            if (!getPlace().getName().equals(companyCriteria.getName())) {
                return false;
            }
        }
        if (!StringUtils.isEmpty(companyCriteria.getAddress())) {
            if (!getAddressLocation().equals(companyCriteria.getAddress())) {
                return false;
            }
        }
        return true;

    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((addressLocation == null) ? 0 : addressLocation.hashCode());
        result = prime * result + ((place == null) ? 0 : place.hashCode());
        result = prime * result + ((nameCompany == null) ? 0 : nameCompany.hashCode());
        result = prime * result + ((branches == null) ? 0 : branches.hashCode());
        result = prime * result + ((performances == null) ? 0 : performances.hashCode());
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
        if (place == null) {
            if (other.place != null)
                return false;
        } else if (!place.equals(other.place))
            return false;
        if(!nameCompany.equals(other.nameCompany)){
            return false;
        }
        return true;
    }

    public Company(final Place place, final String nameCompany) {
        this.place = Objects.requireNonNull(place, "'place' parameter is not initialized");
        this.nameCompany = Objects.requireNonNull(nameCompany, "'nameCompany' parameter is not initialized");
        visibleMap = true;
    }

    public String getNameCompany() {
        return nameCompany;
    }

    public void setNameCompany(String nameCompany) {
        this.nameCompany = nameCompany;
    }

    @Embedded
    public Address getAddressLocation() {
        return addressLocation;
    }

    public void setAddressLocation(Address addressLocation) {
        this.addressLocation = addressLocation;
    }

    public Set<Branch> getBranches() {
        return CommonUtil.getSafeSet(branches);
    }

    @ManyToOne(cascade = {}, fetch = FetchType.EAGER)
    @JoinColumn(name = "PLACE_ID")
    public Place getPlace() {
        return place;
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
