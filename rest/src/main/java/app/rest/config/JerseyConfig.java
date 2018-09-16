package app.rest.config;

import app.config.ComponentBinder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;

import javax.ws.rs.ApplicationPath;

import static app.rest.controller.Endpoints.APPLICATIONS_URL;

@ApplicationPath(APPLICATIONS_URL)
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
       // super(ComponentFeature.class);
        packages("app.rest");
        register(new ComponentBinder());
        property(ServerProperties.RESPONSE_SET_STATUS_OVER_SEND_ERROR, true);

    }
}
