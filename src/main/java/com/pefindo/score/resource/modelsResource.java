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

import com.pefindo.score.model.members;
import com.pefindo.score.model.models;

import org.jboss.resteasy.annotations.jaxrs.PathParam;
/**
 * modelsResource
 */

    
@Path("/models")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class modelsResource {

    @GET
    @Path("/get")
    public List<models> getall() {
        return models.listAll();
    }
    
    @GET
    @Transactional
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public models id(@PathParam Long id){
        return models.findById(id);
    }

    @POST
    @Transactional
    @Path("/post")
    public Response add(models item){
        item.persist();
        return Response.ok(item).status(201).build();
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    public Response deleteOne(@PathParam("id") Long id) {
        models entity = models.findById(id);
        entity.delete();
        return Response.status(204).build();
    }

    @PATCH
    @Transactional
    @Path("/{id}")
    public Response update(models item, @PathParam("id") Long id) {
        models entity = models.findById(id);
        entity.nama = item.nama;
        entity.endpointTradisional = item.endpointTradisional;
        entity.endpointAi = item.endpointAi;
        entity.endpointBre = item.endpointBre;
        entity.baseScore = item.baseScore;
        entity.icons = item.icons;
        entity.id=id;
        return Response.ok(entity).status(200).build();
    }

}
