package app.model.entity.geography;

import app.model.entity.base.AbstractEntity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


//Район
public class District extends AbstractEntity {
    private String name;
    private Region region;
    private Set<City> cities;


    public City addCity(final String nameNewCity) {
        Objects.requireNonNull(nameNewCity, "'nameNewCity' parameter is not initialized");
        if (cities == null) {
            cities = new HashSet<City>();
        }
        City city = new City(nameNewCity, this);
        cities.add(city);
        return city;
    }

    public void removeCity(City nameDelCity){
        Objects.requireNonNull(nameDelCity, "'nameDelCity' parameter is not initialized");
        if (cities == null) {
            return;
        }
        cities.remove(nameDelCity);
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
