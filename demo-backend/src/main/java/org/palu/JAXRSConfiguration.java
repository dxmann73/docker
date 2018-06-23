package org.palu;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * Central JAXRS config
 */
@ApplicationPath(JAXRSConfiguration.API_V1)
public class JAXRSConfiguration extends Application {
    public static final String API_V1 = "api/v1";
}
