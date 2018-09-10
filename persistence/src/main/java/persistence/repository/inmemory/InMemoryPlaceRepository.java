package persistence.repository.inmemory;

import app.infra.util.CommonUtil;
import app.model.entity.geography.Place;
import persistence.repository.PlaceRepository;

import java.util.ArrayList;
import java.util.List;

public class InMemoryPlaceRepository implements PlaceRepository {
    /**
     * Internal list of cities
     */
    private final List<Place> places;

    /**
     * Auto-increment counter for entity id generation
     */
    private int counter = 0;

    private int stationCounter = 0;

    public InMemoryPlaceRepository() {
        places = new ArrayList<Place>();
    }

    @Override
    public void delete(final int placeId) {
    }

    @Override
    public List<Place> findAll() {
        return CommonUtil.getSafeList(places);
    }

    @Override
    public void save(final Place place) {
        if (!places.contains(place)) {
            place.setId(++counter);
            places.add(place);
        }
        place.getCompanies().forEach((company) -> {
            if (company.getId() == 0) {
                company.setId(++stationCounter);
            }
        });
    }

    @Override
    public Place findById(final int placeId) {
        return places.stream().filter(place -> place.getId() == placeId).findFirst().orElse(null);
    }

    //@Override
    public void deleteAll() {
        places.clear();
    }

    //@Override
    public void saveAll(List<Place> places) {
        places.forEach(this::save);
    }
}
