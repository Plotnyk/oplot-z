package app.model.entity.geography;

import app.infra.util.CommonUtil;
import app.model.entity.base.AbstractEntity;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


//Район
@Table(name = "DISTRICT")
@Entity
public class District extends AbstractEntity {
    private String name;
    private Region region;
    private Set<Place> places;
    private Coordinate coordinate;

    public Place addPlace(final String nameNewCity) {
        Objects.requireNonNull(nameNewCity, "'nameNewCity' parameter is not initialized");
        if (places == null) {
            places = new HashSet<Place>();
        }
        Place place = new Place(nameNewCity, this);
        places.add(place);
        return place;
    }

    public void removePlace(Place nameDelPlace){
        Objects.requireNonNull(nameDelPlace, "'nameDelPlace' parameter is not initialized");
        if (places == null) {
            return;
        }
        places.remove(nameDelPlace);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        District district = (District) o;
        return Objects.equals(name, district.name) &&
                Objects.equals(region, district.region);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), name, region);
    }

    public District(final String name, final Region region) {
        this.name = name;
        this.region = region;
    }
    public District(final String name) {
        this.name = name;
    }

    public District() {
    }
    /** Getter and Setter*/
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

    public Set<Place> getPlaces() {
        return CommonUtil.getSafeSet(places);
    }

    @Embedded
    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }
}
