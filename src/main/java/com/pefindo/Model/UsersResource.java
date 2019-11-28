package com.pefindo.Model;

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
@Path("/Users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsersResource {
    @GET
    @Path("/get")
    public List<users> getall(){
        return users.listAll();
    }

    @POST
    @Transactional
    @Path("/post")
    public Response add(users item){
        item.persist();
        return Response.ok(item).status(201).build();
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    public Response deleteOne(@PathParam("id") Long id){
        users entity = users.findById(id);
        entity.delete();
        return Response.status(204).build();
    }

    @PATCH
    @Transactional
    @Path("/{id}")
    public Response update(users item, @PathParam("id") Long id){
        users entity = users.findById(id);
        entity.nama=item.nama;
        entity.username=item.username;
        entity.password=item.password;
        entity.role_code=item.role_code;
        entity.ip_address=item.ip_address;
        entity.id_member=item.id_member;
        entity.id=id;
        return Response.ok(entity).status(200).build();
    }

    @GET
    @Transactional
    @Path("/{label}")
    @Produces(MediaType.APPLICATION_JSON)
    public users nama(@PathParam String nama){
        return users.findByNama(nama);
    }

    @GET
    @Transactional
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public users id(@PathParam Long id){
        return users.findById(id);
    }
}