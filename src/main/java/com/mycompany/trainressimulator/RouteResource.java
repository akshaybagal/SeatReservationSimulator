/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.trainressimulator;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Akshay
 */
@Path("route/{trainID}")
public class RouteResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of RouteResource
     */
    public RouteResource() {
    }

    /**
     * Retrieves representation of an instance of com.mycompany.trainressimulator.RouteResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public RouteResponse getJson(@PathParam("trainID") String trainID) {
        //TODO return proper representation object
        //throw new UnsupportedOperationException();
        Route route = new Route(trainID);
        RouteResponse r = route.getResponse();
        return r;
    }

    /**
     * PUT method for updating or creating an instance of RouteResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
