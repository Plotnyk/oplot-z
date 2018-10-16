package app.model.entity.geography;

import app.infra.util.CommonUtil;
import app.model.entity.base.AbstractEntity;
import app.model.entity.organization.Company;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Any locality that contains company or branch
 * @author Plotnyk
 */
@Table(name="Place")
@Entity
public class Place extends AbstractEntity {

    private String name;

    private String typePlace;

    /** Name of the district where place is placed (район) */
    private District district;

    private Coordinate coordinate;

    /**
     * Name of the region where district is located. Region is top-level area in
     * the country (область)
     */
    private Region region;

    /** Set of companies that is linked to this locality */
    private Set<Company> companies;

    public Place(final String name, final Region region) {
        Objects.requireNonNull(name, "'name' of place parameter is not initialized");
        Objects.requireNonNull(region, "'region' of place parameter is not initialized");
        this.name = name;
        this.region = region;
    }

    public Place(final String name, final District district) {
        Objects.requireNonNull(name, "'name' of place parameter is not initialized");
        Objects.requireNonNull(district, "'district' of place parameter is not initialized");
        this.name = name;
        this.district = district;
        this.region = district.getRegion();
    }

    public Place(final String name) {
        Objects.requireNonNull(name, "'name' of place parameter is not initialized");
        this.name = name;
    }
    public Place() {
    }

    /**
     * Adds specified company to the place company list
     */
    public Company addCompany(final String nameNewCompany) {
        Objects.requireNonNull(nameNewCompany, "'nameCompany' parameter is not initialized");
        if (companies == null) {
            companies = new HashSet<>();
        }
        Company company = new Company(this, nameNewCompany);
        companies.add(company);
        return company;
    }

    /**
     * Removes specified station from place station list
     * @param company
     * */
    public void removeCompany(Company company) {
        Objects.requireNonNull(company, "'company' parameter is not initialized");
        if (companies == null) {
            return;
        }
        companies.remove(company);
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((typePlace == null) ? 0 : typePlace.hashCode());
        result = prime * result + ((district == null) ? 0 : district.hashCode());
        result = prime * result + ((region == null) ? 0 : region.hashCode());
        result = prime * result + ((region.getCountry() == null) ? 0 : region.getCountry().hashCode());
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Place place = (Place) o;
        return Objects.equals(name, place.name) &&
                Objects.equals(typePlace, place.typePlace) &&
                Objects.equals(district, place.district) &&
                Objects.equals(region, place.region) &&
                Objects.equals(companies, place.companies);
    }

    /*Getters and Setters*/
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "place", orphanRemoval = true)
    public Set<Company> getCompanies() {
        return CommonUtil.getSafeSet(companies);
    }

    @Column(name = "NAME", nullable = false, length = 32)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "TYPE_PLACE")
    public String getTypePlace() {
        return typePlace;
    }

    public void setTypePlace(String typePlace) {
        this.typePlace = typePlace;
    }

    @Embedded
    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

}
