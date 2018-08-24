package app.model.entity.geography;

import app.model.entity.base.AbstractEntity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Country extends AbstractEntity {
    private String name;
    private String codePhone;
    private Coordinate coordinate;
    private Set<Region> regions;

    public Region addRegion(final String nameNewRegion) {
        Objects.requireNonNull(nameNewRegion, "'nameNewCity' parameter is not initialized");
        if (regions == null) {
            regions = new HashSet<Region>();
        }
        Region region = new Region(nameNewRegion, this);
        regions.add(region);
        return region;
    }

    public void removeRegion(Region nameDelRegion){
        Objects.requireNonNull(nameDelRegion, "'nameDelRegion' parameter is not initialized");
        if (regions == null) {
            return;
        }
        regions.remove(nameDelRegion);
    }

    public Country(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public String getCodePhone() {
        return codePhone;
    }

    public void setCodePhone(String codePhone) {
        this.codePhone = codePhone;
    }
}
