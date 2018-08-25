package app.model.entity.geography;

import app.model.entity.base.AbstractEntity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


//Район
public class District extends AbstractEntity {
    private String name;
    private Region region;
    private Set<Place> cities;


    public Place addCity(final String nameNewCity) {
        Objects.requireNonNull(nameNewCity, "'nameNewCity' parameter is not initialized");
        if (cities == null) {
            cities = new HashSet<Place>();
        }
        Place place = new Place(nameNewCity, this);
        cities.add(place);
        return place;
    }

    public void removeCity(Place nameDelPlace){
        Objects.requireNonNull(nameDelPlace, "'nameDelPlace' parameter is not initialized");
        if (cities == null) {
            return;
        }
        cities.remove(nameDelPlace);
    }


    public District(String name, Region region) {
        this.name = name;
        this.region = region;
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
}
