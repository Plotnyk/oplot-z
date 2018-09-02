package app.service;

import app.model.entity.geography.Country;
import app.model.entity.geography.Place;
import app.model.entity.organization.Company;
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
     * Returns list of existing places
     * @return
     */
    List<Place> findPlaces();

    /**
     * Returns place with specified identifier. If no city is found then empty optional is
     * returned
     *
     * @param id
     * @return
     */
    Optional<Place> findPlaceById(int id);

    /**
     * Returns all the companies that match specified criteria
     * @param criteria
     * @param rangeCriteria
     * @return
     */
    List<Company> searchCompanies(CompanyCriteria criteria, RangeCriteria rangeCriteria);


    /**
     * Saves specified place instance
     * @param place
     */
    void savePlace(Place place);


    /*СТРАНЫ*/

    /**
     * Returns list of existing countries
     * @return
     */
    List<Country> findCountry();

    /**
     * Returns country with specified identifier. If no city is found then empty optional is
     * returned
     *
     * @param id
     * @return
     */
    Optional<Country> findCountryById(int id);

    /**
     * Returns all the regiones that match specified criteria
     * @param criteria
     * @param rangeCriteria
     * @return
     */
    //List<Company> searchRegion();


    /**
     * Saves specified country instance
     * @param country
     */
    void saveCountry (Country country);

}
