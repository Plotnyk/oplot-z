package app.model.entity.geography;

import app.infra.util.CommonUtil;
import app.model.entity.base.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Table(name = "COUNTRY")
@Entity
public class Country extends AbstractEntity {
    private String name;
    private String codePhone;
    private Coordinate coordinate;
    private Set<Region> regions;

    public Region addRegion(final String nameNewRegion) {
        Objects.requireNonNull(nameNewRegion, "'nameNewRegion' parameter is not initialized");
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

    public Country(final String name) {
        this.name = name;
    }

    public Country() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Country country = (Country) o;
        return Objects.equals(name, country.name) &&
                Objects.equals(codePhone, country.codePhone) &&
                Objects.equals(coordinate, country.coordinate) &&
                Objects.equals(regions, country.regions);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), name, codePhone);
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

    public Set<Region> getRegions() {
        return CommonUtil.getSafeSet(regions);
    }
}
