package com.pefindo.latihan;

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
@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class model_parametersResource {
    @GET
    @Path("/get")
    public List<model_parameters> getall(){
        return model_parameters.listAll();
    }

    @POST
    @Transactional
    @Path("/post")
    public Response add(model_parameters item){
        item.persist();
        return Response.ok(item).status(201).build();
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    public Response deleteOne(@PathParam("id") Long id){
        model_parameters entity = model_parameters.findById(id);
        entity.delete();
        return Response.status(204).build();
    }

    @PATCH
    @Transactional
    @Path("/{id}")
    public Response update(model_parameters item, @PathParam("id") Long id){
        model_parameters entity = model_parameters.findById(id);
        entity.parameter=item.parameter;
        entity.label=item.label;
        entity.tipe_data=item.tipe_data;
        entity.is_web=item.is_web;
        entity.id_model=item.id_model;
        entity.id=id;
        return Response.ok(entity).status(200).build();
    }

    // Only update title
    // @PATCH
    // @Transactional
    // @Path("/title/{id}")
    // public Response updateTitle(todo item, @PathParam("id") Long id){
    //     Members entity = Members.findById(id);
    //     entity.memberName=item.memberName;
    //     entity.id=id;
    //     return Response.ok(entity).status(200).build();
    // }

    @GET
    @Transactional
    @Path("/{label}")
    @Produces(MediaType.APPLICATION_JSON)
    public model_parameters label(@PathParam String label){
        return model_parameters.findByLabel(label);
    }

    @GET
    @Transactional
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public model_parameters id(@PathParam Long id){
        return model_parameters.findById(id);
    }
}