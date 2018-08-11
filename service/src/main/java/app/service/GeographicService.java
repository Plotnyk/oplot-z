package app.service;

import app.model.entity.geography.City;
import app.model.entity.organization.Branch;
import app.model.entity.organization.Company;
import app.model.search.criteria.BranchCriteria;
import app.model.search.criteria.CompanyCriteria;
import app.model.search.criteria.range.RangeCriteria;

import java.util.List;
import java.util.Optional;

/**
 * Entry point to perform operations
 * over geographic entities
 * @author Plotnyk
 */
public interface GeographicService {

    /**
     * Returns list of existing cities
     * @return
     */
    List<City> findCities();

    /**
     * Returns city with specified identifier. If no city is found then empty optional is
     * returned
     *
     * @param id
     * @return
     */
    Optional<City> findCitiyById(int id);

    /**
     * Returns all the stations that match specified criteria
     * @param criteria
     * @param rangeCriteria
     * @return
     */
    List<Company> searchCompanies(CompanyCriteria criteria, RangeCriteria rangeCriteria);


    /**
     * Saves specified city instance
     * @param city
     */
    void saveCity(City city);
}