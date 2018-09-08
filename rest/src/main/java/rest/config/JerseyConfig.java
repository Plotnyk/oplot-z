package rest.config;

import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

import static rest.controller.Endpoints.APPLICATIONS_URL;

@ApplicationPath(APPLICATIONS_URL)
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        packages("rest");
    }
}
