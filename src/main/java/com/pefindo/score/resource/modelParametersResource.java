package com.pefindo.score.resource;

import com.pefindo.score.model.modelParameters;
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

import org.jboss.resteasy.annotations.jaxrs.PathParam;

/**
 * ToDoResource
 */
@Path("/modelParameter")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class modelParametersResource {
    @GET
    @Path("/get")
    public List<modelParameters> getall(){
        return modelParameters.listAll();
    }

    @POST
    @Transactional
    @Path("/post")
    public Response add(modelParameters item){
        item.persist();
        return Response.ok(item).status(201).build();
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    public Response deleteOne(@PathParam("id") Long id){
        modelParameters entity = modelParameters.findById(id);
        entity.delete();
        return Response.status(204).build();
    }

    @PATCH
    @Transactional
    @Path("/{id}")
    public Response update(modelParameters item, @PathParam("id") Long id){
        modelParameters entity = modelParameters.findById(id);
        entity.parameter = item.parameter;
        entity.label = item.label;
        entity.tipeData = item.tipeData;
        entity.isWeb = item.isWeb;
        entity.idModel = item.idModel;
        entity.id = id;
        return Response.ok(entity).status(200).build();
    }

    @GET
    @Transactional
    @Path("/{label}")
    @Produces(MediaType.APPLICATION_JSON)
    public modelParameters label(@PathParam String label){
        return modelParameters.findByLabel(label);
    }

    @GET
    @Transactional
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public modelParameters id(@PathParam Long id){
        return modelParameters.findById(id);
    }
}