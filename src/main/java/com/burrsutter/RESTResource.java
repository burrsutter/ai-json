package com.burrsutter;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import com.fasterxml.jackson.databind.ObjectMapper;

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
    public String helloaijson() {
        ObjectMapper mapper = new ObjectMapper();
        
        JSONResponse response = aijsongreeter.greet("Burr");

        String json = null;
        
        try {
            json = mapper.writeValueAsString(response);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n" + json + "\n");

        System.out.println("score: " + response.score());

        // String stringresult = response.toString();
        
        return json;
    }


    @GET
    @Path("/bye")
    @Produces(MediaType.TEXT_PLAIN)
    public String bye() {
        return "Aloha";
    }

}
