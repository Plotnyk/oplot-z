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
    private Set<Place> citiesWithoutDistrict;

    public District addDistrict(final String nameNewDistrict) {
        Objects.requireNonNull(nameNewDistrict, "'nameNewDistrict' parameter is not initialized");
        if (districts == null) {
            districts = new HashSet<District>();
        }
        District district = new District(nameNewDistrict, this);
        districts.add(district);
        return district;
    }

    public void removeDistrict(Place nameDelDistrict){
        Objects.requireNonNull(nameDelDistrict, "'nameDelDistrict' parameter is not initialized");
        if (districts == null) {
            return;
        }
        citiesWithoutDistrict.remove(nameDelDistrict);
    }

    public Place addCityWithoutDistrict(final String nameNewCity) {
        Objects.requireNonNull(nameNewCity, "'nameNewCity' parameter is not initialized");
        if (citiesWithoutDistrict == null) {
            citiesWithoutDistrict = new HashSet<Place>();
        }
        Place place = new Place(nameNewCity, this);
        citiesWithoutDistrict.add(place);
        return place;
    }

    public void removeCityWithoutDistrict(Place nameDelPlace){
        Objects.requireNonNull(nameDelPlace, "'nameDelPlace' parameter is not initialized");
        if (citiesWithoutDistrict == null) {
            return;
        }
        citiesWithoutDistrict.remove(nameDelPlace);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Region region = (Region) o;
        return Objects.equals(name, region.name) &&
                Objects.equals(country, region.country) &&
                Objects.equals(districts, region.districts) &&
                Objects.equals(citiesWithoutDistrict, region.citiesWithoutDistrict);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), name, country, districts, citiesWithoutDistrict);
    }

    /** Getter and Setter*/
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

    public Set<Place> getCitiesWithoutDistrict() {
        return citiesWithoutDistrict;
    }

    public void setCitiesWithoutDistrict(Set<Place> citiesWithoutDistrict) {
        this.citiesWithoutDistrict = citiesWithoutDistrict;
    }
}
