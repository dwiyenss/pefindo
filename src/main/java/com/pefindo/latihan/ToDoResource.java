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
public class ToDoResource {
    @GET
    @Path("/get")
    public List<todo> getall(){
        return todo.listAll();
    }

    @POST
    @Transactional
    @Path("/post")
    public Response add(todo item){
        item.persist();
        return Response.ok(item).status(201).build();
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    public Response deleteOne(@PathParam("id") Long id){
        todo entity = todo.findById(id);
        entity.delete();
        return Response.status(204).build();
    }

    @PATCH
    @Transactional
    @Path("/{id}")
    public Response update(todo item, @PathParam("id") Long id){
        todo entity = todo.findById(id);
        entity.completed=item.completed;
        entity.order=item.order;
        entity.title=item.title;
        entity.id=id;
        return Response.ok(entity).status(200).build();
    }

    // Only update title
    @PATCH
    @Transactional
    @Path("/title/{id}")
    public Response updateTitle(todo item, @PathParam("id") Long id){
        todo entity = todo.findById(id);
        entity.title=item.title;
        entity.id=id;
        return Response.ok(entity).status(200).build();
    }

    @GET
    @Transactional
    @Path("/{title}")
    @Produces(MediaType.APPLICATION_JSON)
    public todo title(@PathParam String title){
        return todo.findByTitle(title);
    }

    @GET
    @Transactional
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public todo id(@PathParam Long id){
        return todo.findById(id);
    }
}