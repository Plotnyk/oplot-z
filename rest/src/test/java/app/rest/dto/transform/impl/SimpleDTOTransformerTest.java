package app.rest.dto.transform.impl;

import app.model.entity.geography.Country;
import app.model.entity.geography.District;
import app.model.entity.geography.Place;
import app.model.entity.geography.Region;
import app.service.transform.impl.SimpleDTOTransformer;
import org.junit.Before;
import org.junit.Test;
import org.modelmapper.ModelMapper;
import app.rest.dto.PlaceDTO;

import static org.junit.Assert.*;

/**
 * Verifies functionality of the {@link SimpleDTOTransformer}
 * unit
 * @author Plotnyk
 *
 */
public class SimpleDTOTransformerTest {
    private ModelMapper transformer;
    private Place city;

    @Before
    public void setup() {
        transformer = new ModelMapper();
        city = new Place("Ирпень"
                , new District("Киев-Святошинский"
                , new Region("Киевская область"
                , new Country("Украина"))));
    }

    @Test
    public void testTransformCitySuccess() {
        city.setId(1);

        PlaceDTO dto = transformer.map(city, PlaceDTO.class);
        assertNotNull(dto);
        assertEquals(dto.getId(), city.getId());
        assertEquals(dto.getName(), city.getName());
        assertEquals(dto.getDistrict(), city.getDistrict());
        assertEquals(dto.getRegion(), city.getRegion());
    }

    @Test(expected=java.lang.IllegalArgumentException.class)
    public void testTransformNullCityFailure() {
        transformer.map(null, PlaceDTO.class);
    }

    @Test(expected=java.lang.IllegalArgumentException.class)
    public void testTransformNullDTOClassFailure() {
        transformer.map(city, (Class<PlaceDTO>)null);
    }

    @Test
    public void testUnTransformCitySuccess() {
        PlaceDTO dto = new PlaceDTO();
        dto.setId(1);
        dto.setRegion(new Region("Киевская область", new Country("Украина")));
        dto.setDistrict(new District("Киев-Святошинский",new Region("Киевская область", new Country("Украина"))));
        dto.setName("Ирпень");

        Place city = transformer.map(dto, Place.class);
        assertNotNull(city);
        assertEquals(dto.getId(), city.getId());
        assertEquals(dto.getName(), city.getName());
        assertEquals(dto.getDistrict(), city.getDistrict());
        assertEquals(dto.getRegion(), city.getRegion());
    }

    @Test(expected=java.lang.IllegalArgumentException.class)
    public void testUnTransformNullCityFailure() {
        transformer.map(null, Place.class);
    }

    @Test(expected=java.lang.IllegalArgumentException.class)
    public void testUnTransformNullEntityClassFailure() {
        transformer.map(new PlaceDTO(), null);
    }

}