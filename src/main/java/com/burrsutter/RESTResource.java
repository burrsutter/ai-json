package com.burrsutter;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/")
public class RESTResource {

    @Inject AIGreetingService aigreeter;
    @Inject AIJSONService aijsongreeter;

    @GET
    @Path("/hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello from Quarkus REST";
    }

    @GET
    @Path("/helloai")
    @Produces(MediaType.TEXT_PLAIN)
    public String helloai() {
        return aigreeter.greet("Burr");
    }

    @GET
    @Path("/helloaijson")
    @Produces(MediaType.APPLICATION_JSON)
    public JSONResponse helloaijson() {
        return aijsongreeter.greet("Burr");
    }


    @GET
    @Path("/bye")
    @Produces(MediaType.TEXT_PLAIN)
    public String bye() {
        return "Aloha";
    }

}
