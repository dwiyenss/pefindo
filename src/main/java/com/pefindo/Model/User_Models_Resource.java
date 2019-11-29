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

@Path("/user_models")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class User_Models_Resource {
	
	// Methods GET
	@GET
	@Path("/get")
	public List<User_Models> getall(){
		return User_Models.listAll();
	}
	
	// Methods POST
	@POST
	@Transactional
	@Path("/post")
	public Response add(User_Models item) {
		item.persist();
		return Response.ok(item).status(201).build();
	}
	
	// Methods DELETE
	@DELETE
	@Transactional
	@Path("/delete/{id}")
	public Response delete(@PathParam("id") long id) {
		User_Models entity = User_Models.findById("id");
		entity.delete();
		return Response.status(204).build();		
	}
	
	// Methods UPDATE
	@PATCH
	@Transactional
	@Path("/update/{id}")
	public Response update(User_Models item, @PathParam("id") long id){
		User_Models entity = User_Models.findById(id);
		entity.id_model = item.id_model;
		entity.id_user = item.id_user;
		entity.active_flag = item.active_flag;
		entity.id = id;
		return Response.ok(entity).status(201).build();
	}
	
	// Methods GET BY active_flag
	@GET
    @Transactional
    @Path("/get_by/{active_flag}")
    @Produces(MediaType.APPLICATION_JSON)
    public User_Models active_flag(@PathParam String active_flag) {
    	return User_Models.findByName(active_flag);
    }
		
}
