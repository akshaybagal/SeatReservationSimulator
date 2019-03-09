/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.trainressimulator;

import com.mycompany.trainressimulator.Presentation.Response;
import com.mycompany.trainressimulator.business.Search;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
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
@Path("search")
public class SearchResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of SearchResource
     */
    public SearchResource() {
    }

    /**
     * Retrieves representation of an instance of com.mycompany.trainressimulator.SearchResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJson(
            @QueryParam("src") String source,
            @QueryParam("dest") String dest,
            @QueryParam("date") String date,
            @QueryParam("userId") String userId,
            @QueryParam("orig") String orig
            ) {
        //TODO return proper representation object
        //throw new UnsupportedOperationException();
        Search s = new Search(source, dest, date);
        Response r = s.getResponse();
        return r;
    }

    /**
     * PUT method for updating or creating an instance of SearchResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
