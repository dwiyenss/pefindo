package com.pefindo.score.resource;

import com.pefindo.score.model.members;

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
@Path("/members")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class memberResource {
    @GET
    @Path("/get")
    public List<members> getall(){
        return members.listAll();
    }

    @POST
    @Transactional
    @Path("/post")
    public Response add(members item){
        item.persist();
        return Response.ok(item).status(201).build();
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    public Response deleteOne(@PathParam("id") Long id){
        members entity = members.findById(id);
        entity.delete();
        return Response.status(204).build();
    }

    @PATCH
    @Transactional
    @Path("/{id}")
    public Response update(members item, @PathParam("id") Long id){
        members entity = members.findById(id);
        entity.memberCode=item.memberCode;
        entity.memberName=item.memberName;
        entity.activeFlag=item.activeFlag;
        entity.image=item.image;
        entity.id=id;
        return Response.ok(entity).status(200).build();
    }


    
    @GET
    @Transactional
    @Path("/get_by/{memberName}")
    @Produces(MediaType.APPLICATION_JSON)
    public members memberName(@PathParam String memberName) {
     	return members.findByMemberName(memberName);
     }

    @GET
    @Transactional
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public members id(@PathParam Long id){
        return members.findById(id);
    }
}