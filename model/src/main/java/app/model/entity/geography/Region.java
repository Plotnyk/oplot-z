package app.model.entity.geography;

import app.infra.util.CommonUtil;
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
    private Set<Place> placesWithoutDistrict;

    public District addDistrict(final String nameNewDistrict) {
        Objects.requireNonNull(nameNewDistrict, "'nameNewDistrict' parameter is not initialized");
        if (districts == null) {
            districts = new HashSet<District>();
        }
        District district = new District(nameNewDistrict, this);
        districts.add(district);
        return district;
    }

    public void removeDistrict(District nameDelDistrict){
        Objects.requireNonNull(nameDelDistrict, "'nameDelDistrict' parameter is not initialized");
        if (districts == null) {
            return;
        }
        districts.remove(nameDelDistrict);
    }

    public Place addPlaceWithoutDistrict(final String nameNewCity) {
        Objects.requireNonNull(nameNewCity, "'nameNewCity' parameter is not initialized");
        if (placesWithoutDistrict == null) {
            placesWithoutDistrict = new HashSet<Place>();
        }
        Place place = new Place(nameNewCity, this);
        placesWithoutDistrict.add(place);
        return place;
    }

    public void removePlaceWithoutDistrict(Place nameDelPlace){
        Objects.requireNonNull(nameDelPlace, "'nameDelPlace' parameter is not initialized");
        if (placesWithoutDistrict == null) {
            return;
        }
        placesWithoutDistrict.remove(nameDelPlace);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Region region = (Region) o;
        return Objects.equals(name, region.name) &&
                Objects.equals(country, region.country) &&
                Objects.equals(districts, region.districts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, country);
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
        return CommonUtil.getSafeSet(districts);
    }

    public Set<Place> getPlacesWithoutDistrict() {
        return CommonUtil.getSafeSet(placesWithoutDistrict);
    }

}
