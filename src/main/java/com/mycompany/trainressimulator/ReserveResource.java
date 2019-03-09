/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.trainressimulator;

import com.mycompany.trainressimulator.Presentation.ReserveResponse;
import com.mycompany.trainressimulator.business.Reserve;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Akshay
 */
@Path("reserve")
public class ReserveResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ReserveResource
     */
    public ReserveResource() {
    }

    /**
     * Retrieves representation of an instance of com.mycompany.trainressimulator.ReserveResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ReserveResponse getJson(@QueryParam("userID") String userID,
                          @QueryParam("trainID") String trainID,
                          @QueryParam("coachID") String coachID,
                          @QueryParam("noOfSeats") String noOfSeats,
                          @QueryParam("date") String date) {
        //TODO return proper representation object
        //throw new UnsupportedOperationException();
        Reserve r = new Reserve(userID, trainID, coachID, noOfSeats, date);
        ReserveResponse response = r.reserveSeats();
        return response;
    }

    /**
     * PUT method for updating or creating an instance of ReserveResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
