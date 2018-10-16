package app.model.entity.organization;

import app.model.entity.base.AbstractEntity;
import app.model.entity.geography.Address;
import app.model.entity.geography.Coordinate;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name="PERFORMANCE")
@Entity
public class Performance extends AbstractEntity {
    private String name;
    private Address addressLocation;
    private Branch parentBranch;
    private Company parentCompany;
    private String phone;
    private Coordinate coordinate;

    public Performance(String name, Company parentCompany) {
        this.name = name;
        this.parentCompany = parentCompany;
        this.parentBranch = null;
    }

    public Performance(String name, Branch parentBranch) {
        this.name = name;
        this.parentCompany = parentBranch.getParentCompany();
        this.parentBranch = parentBranch;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddressLocation() {
        return addressLocation;
    }

    public void setAddressLocation(Address addressLocation) {
        this.addressLocation = addressLocation;
    }

    public Branch getParentBranch() {
        return parentBranch;
    }

    public void setParentBranch(Branch parentBranch) {
        this.parentBranch = parentBranch;
    }

    public Company getParentCompany() {
        return parentCompany;
    }

    public void setParentCompany(Company parentCompany) {
        this.parentCompany = parentCompany;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Embedded
    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }
}
