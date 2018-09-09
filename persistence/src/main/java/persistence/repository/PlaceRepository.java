package persistence.repository;

import app.model.entity.geography.Place;

import java.util.List;

public interface PlaceRepository {
    void save(Place place);
    Place findById(int placeId);
    void delete(int placeId);
    List<Place> findAll();
}
