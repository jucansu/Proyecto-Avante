package pepe.application;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("services")
public class RESTApplication extends ResourceConfig {

  public RESTApplication () {
    packages("ws.services");
  }

}
