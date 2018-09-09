package rest.controller;

import app.model.entity.geography.Country;
import app.model.entity.geography.District;
import app.model.entity.geography.Place;
import app.model.entity.geography.Region;
import app.service.GeographicService;
import app.service.impl.GeographicServiceImpl;
//import app.service.transform.Transformer;
//import app.service.transform.impl.SimpleDTOTransformer;
import jersey.repackaged.com.google.common.collect.Lists;
import org.apache.commons.lang3.math.NumberUtils;
import org.modelmapper.ModelMapper;
import rest.controller.base.BaseException;
import rest.dto.PlaceDTO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static rest.controller.Endpoints.CATEGORIES_URL_1;


/**
 * {@link PlaceController} is REST web-service that handles place-related requests
 * @author Plotnyk
 *
 */
@Path(CATEGORIES_URL_1)
public class PlaceController extends BaseException {

    /**
     * Underlying source of data
     */
    private GeographicService service;
    /**
     * DTO <-> Entity transformer
     */
    private ModelMapper transformer;
    private int i = 0;

    public PlaceController() {
        Country cou = new Country("Украина");
        Region reg = new Region("Киевская", cou);
        District dis = new District("Киево-святошинский", reg);
        transformer = new ModelMapper();
        service = new GeographicServiceImpl();
        service.savePlace(new Place("Киев", dis));
        service.savePlace(new Place("Ирпень",dis));
        service.savePlace(new Place("Львов", new District("Bender", new Region("Lvovskiy", cou))));
    }


    /**
     * Returns all the existing places
     * @return
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<PlaceDTO> findCities() {
        return service.findPlaces().stream().map((place) -> transformer.map(place, PlaceDTO.class)).collect(Collectors.toList());
    }

    /**
     * Saves new place instance (проверить мапер для untransform)
     * @return
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void saveCity(PlaceDTO placeDTO) {
        service.savePlace(transformer.map(placeDTO, Place.class));
    }

    /**
     * Returns place with specified identifier
     * @return
     */
    @Path("/{placeId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findCityById(@PathParam("placeId") final String placeId) {
        if(!NumberUtils.isNumber(placeId)) {
            return BAD_REQUEST;
        }

        Optional<Place> place = service.findPlaceById(NumberUtils.toInt(placeId));
        if (!place.isPresent()) {
            return NOT_FOUND;
        }
        return ok(transformer.map(place.get(), PlaceDTO.class));
    }

}
