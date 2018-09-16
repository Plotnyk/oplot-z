package app.config;

import app.service.GeographicService;
import app.service.impl.GeographicServiceImpl;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import persistence.repository.PlaceRepository;
import persistence.repository.inmemory.InMemoryPlaceRepository;

import javax.inject.Singleton;

/**
 * Binds bean implementations and implemented interfaces
 * @author Plotnyk
 *
 */

public class ComponentBinder extends AbstractBinder {
    @Override
    protected void configure() {
        bind(GeographicServiceImpl.class).to(GeographicService.class).in(Singleton.class);
        bind(InMemoryPlaceRepository.class).to(PlaceRepository.class).in(Singleton.class);
    }
}
