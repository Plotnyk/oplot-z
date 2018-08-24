package app.model.entity.geography;

import app.model.entity.base.AbstractEntity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

//Область
public class Region extends AbstractEntity {
    private String name;
    private Country country;
    //районы области
    private Set<District> districts;

    // города и поселки области, которые не имеют района
    private Set<City> citiesWithoutDistrict;

    public District addDistrict(final String nameNewDistrict) {
        Objects.requireNonNull(nameNewDistrict, "'nameNewDistrict' parameter is not initialized");
        if (districts == null) {
            districts = new HashSet<District>();
        }
        District district = new District(nameNewDistrict, this);
        districts.add(district);
        return district;
    }

    public void removeDistrict(City nameDelDistrict){
        Objects.requireNonNull(nameDelDistrict, "'nameDelDistrict' parameter is not initialized");
        if (districts == null) {
            return;
        }
        citiesWithoutDistrict.remove(nameDelDistrict);
    }

    public City addCityWithoutDistrict(final String nameNewCity) {
        Objects.requireNonNull(nameNewCity, "'nameNewCity' parameter is not initialized");
        if (citiesWithoutDistrict == null) {
            citiesWithoutDistrict = new HashSet<City>();
        }
        City city = new City(nameNewCity, this);
        citiesWithoutDistrict.add(city);
        return city;
    }

    public void removeCityWithoutDistrict(City nameDelCity){
        Objects.requireNonNull(nameDelCity, "'nameDelCity' parameter is not initialized");
        if (citiesWithoutDistrict == null) {
            return;
        }
        citiesWithoutDistrict.remove(nameDelCity);
    }

    public Region(String name, Country country) {
        this.name = name;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Set<District> getDistricts() {
        return districts;
    }

    public void setDistricts(Set<District> districts) {
        this.districts = districts;
    }

    public Set<City> getCitiesWithoutDistrict() {
        return citiesWithoutDistrict;
    }

    public void setCitiesWithoutDistrict(Set<City> citiesWithoutDistrict) {
        this.citiesWithoutDistrict = citiesWithoutDistrict;
    }
}
