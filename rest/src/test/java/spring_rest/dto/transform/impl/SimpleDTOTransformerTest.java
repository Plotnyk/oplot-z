package spring_rest.dto.transform.impl;


import app.infra.exception.flow.InvalidParameterException;
import app.model.entity.geography.Country;
import app.model.entity.geography.District;
import app.model.entity.geography.Place;
import app.model.entity.geography.Region;
import app.service.transform.Transformer;
import app.service.transform.impl.SimpleDTOTransformer;
import org.junit.Before;
import org.junit.Test;
import spring_rest.dto.PlaceDTO;

import static org.junit.Assert.*;

/**
 * Verifies functionality of the {@link SimpleDTOTransformer}
 * unit
 * @author Plotnyk
 *
 */
public class SimpleDTOTransformerTest {
    private Transformer transformer;
    private Place city;

    @Before
    public void setup() {
        transformer = new SimpleDTOTransformer();
        city = new Place("Ирпень"
                , new District("Киев-Святошинский"
                , new Region("Киевская область"
                , new Country("Украина"))));
    }

    @Test
    public void testTransformCitySuccess() {
        city.setId(1);

        PlaceDTO dto = transformer.transform(city, PlaceDTO.class);
        assertNotNull(dto);
        assertEquals(dto.getId(), city.getId());
        assertEquals(dto.getName(), city.getName());
        assertEquals(dto.getDistrict(), city.getDistrict());
        assertEquals(dto.getRegion(), city.getRegion());
    }

    @Test(expected=InvalidParameterException.class)
    public void testTransformNullCityFailure() {
        transformer.transform(null, PlaceDTO.class);
    }

    @Test(expected=InvalidParameterException.class)
    public void testTransformNullDTOClassFailure() {
        transformer.transform(city, (Class<PlaceDTO>)null);
    }

    @Test
    public void testUnTransformCitySuccess() {
        PlaceDTO dto = new PlaceDTO();
        dto.setId(1);
        dto.setRegion(new Region("Киевская область", new Country("Украина")));
        dto.setDistrict(new District("Киев-Святошинский",new Region("Киевская область", new Country("Украина"))));
        dto.setName("Ирпень");

        Place city = transformer.untransform(dto, Place.class);
        assertNotNull(city);
        assertEquals(dto.getId(), city.getId());
        assertEquals(dto.getName(), city.getName());
        assertEquals(dto.getDistrict(), city.getDistrict());
        assertEquals(dto.getRegion(), city.getRegion());
    }

    @Test(expected=InvalidParameterException.class)
    public void testUnTransformNullCityFailure() {
        transformer.untransform(null, Place.class);
    }

    @Test(expected=InvalidParameterException.class)
    public void testUnTransformNullEntityClassFailure() {
        transformer.untransform(new PlaceDTO(), null);
    }
}