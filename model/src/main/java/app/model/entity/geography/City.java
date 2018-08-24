package app.model.entity.geography;

import app.model.entity.base.AbstractEntity;
import app.model.entity.organization.Branch;
import app.model.entity.organization.Company;
import app.infra.util.CommonUtil;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Any locality that contains company or branch
 * @author Plotnyk
 */
public class City extends AbstractEntity {

    private String name;

    /** Name of the district where city is placed (район) */
    private District district;

    /**
     * Name of the region where district is located. Region is top-level area in
     * the country (область)
     */
    private Region region;

    /** Set of companies that is linked to this locality */
    private Set<Company> companies;

    public City(final String name, final Region region) {
        Objects.requireNonNull(name, "'name' of city parameter is not initialized");
        Objects.requireNonNull(region, "'region' of city parameter is not initialized");
        this.name = name;
        this.region = region;
    }
    public City(final String name, final District district) {
        Objects.requireNonNull(name, "'name' of city parameter is not initialized");
        Objects.requireNonNull(region, "'region' of city parameter is not initialized");
        this.name = name;
        this.district = district;
        this.region = district.getRegion();
    }

    /**
     * Adds specified company to the city company list
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
     * Removes specified station from city station list
     * @param company
     * */
    public void removeCompany(Company company) {
        Objects.requireNonNull(company, "'company' parameter is not initialized");
        if (companies == null) {
            return;
        }
        companies.remove(company);
    }


    /*Getters and Setters*/
    public Set<Company> getCompanies() {
        return CommonUtil.getSafeSet(companies);
    }

    public void setCompanies(Set<Company> companies) {
        this.companies = companies;
    }

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
}
