package controllers;

import javax.ws.rs.*;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Context;
import javax.servlet.http.HttpSession;
import io.dropwizard.jersey.sessions.Session;



@Path("")
@Produces(MediaType.APPLICATION_JSON)
public class NetIDController {

    @GET
    @Path("/netid")
    public String getNetID(){

        return "hz464";

    }

}
