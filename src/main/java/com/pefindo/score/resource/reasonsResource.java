package com.pefindo.score.resource;

import java.util.List;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.pefindo.score.model.reasons;

import org.jboss.resteasy.annotations.jaxrs.PathParam;
/**
 * ReasonsResource
 */
@Path("/Reasons")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class reasonsResource {

    @GET
    @Path("/get")
    public List<reasons> getall(){
        return reasons.listAll();
    }

    @POST
    @Transactional
    @Path("/post")
    public Response add(reasons item) {
        item.persist();
        return Response.ok(item).status(201).build();
    }


    @DELETE
    @Transactional
    @Path("/{id}")
    public Response deleteOne(@PathParam("id") Long id) {
        reasons entity = reasons.findById(id);
        entity.delete();
        return Response.status(204).build();
    }

    @PATCH
    @Transactional
    @Path("/{id}")
    public Response update(reasons item, @PathParam("id") Long id) {
        reasons entity = reasons.findById(id);
        entity.code = item.code;
        entity.description = item.description;
        entity.id=id;
        return Response.ok(entity).status(200).build();
    }

}