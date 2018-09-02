package spring_rest.controller;

import app.model.entity.geography.Place;
import app.service.GeographicService;
import app.service.impl.GeographicServiceImpl;
import app.service.transform.Transformer;
import app.service.transform.impl.SimpleDTOTransformer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;


@RestController
@RequestMapping(value = "/api/places")
public class PlaceController {
    /**
     * Underlying source of data
     */
    private final GeographicService service;
    /**
     * DTO <-> Entity transformer
     */
    private final Transformer transformer;

    public PlaceController() {
        transformer = new SimpleDTOTransformer();

        service = new GeographicServiceImpl();
        Place place = new Place("Odessa");
        place.addCompany("STO");
        //service.saveCity(city);
    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public List<String> findCities() {
        return Arrays.asList("Odessa", "Kiyv");
    }

    /*@GET
	@Produces(MediaType.APPLICATION_JSON)
	/**
	 * Returns all the existing cities
	 * @return
	 */
  //  public List<CityDTO> findCities() {
    //    return service.findCities().stream().map((city) -> transformer.transform(city, CityDTO.class))
      //          .collect(Collectors.toList());
    //}

   // @POST
    //@Consumes(MediaType.APPLICATION_JSON)
    /**
     * Saves new city instance
     * @return
     */
   // public void saveCity(CityDTO cityDTO) {
      //  service.saveCity(transformer.untransform(cityDTO, City.class));
    //}

   // @Path("/{cityId}")
    //@GET
    //@Produces(MediaType.APPLICATION_JSON)
    /**
     * Returns city with specified identifier
     * @return
     */
    //public Response findCityById(@PathParam("cityId") final String cityId) {
      //  if(!NumberUtils.isNumber(cityId)) {
        //    return BAD_REQUEST;
        //}

        //Optional<City> city = service.findCitiyById(NumberUtils.toInt(cityId));
        //if (!city.isPresent()) {
          //  return NOT_FOUND;
        //}
        //return ok(transformer.transform(city.get(), CityDTO.class));
    //}

}
