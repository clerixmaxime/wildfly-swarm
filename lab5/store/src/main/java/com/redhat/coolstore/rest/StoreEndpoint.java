package com.redhat.coolstore.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import com.redhat.coolstore.model.Store;
import org.wildfly.swarm.topology.Advertise;

@Advertise("store")
@Path("/store")
public class StoreEndpoint {

    public static final String id = " === " + "STORE INSTANCE:"+Math.round(Math.random() * 10000) + " === ";

    @Context
    UriInfo uri;

    @Context
    HttpHeaders headers;

    @GET
    @Path("/{location}")
    @Produces(MediaType.APPLICATION_JSON)
    public Store getAvailability(@PathParam("location") String location) {

        // close the stores in Raleigh
        return new Store(location, !location.equalsIgnoreCase("raleigh"), id);

    }
}
