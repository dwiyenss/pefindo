package com.pefindo.score.resource;

import com.pefindo.score.model.parameterDetails;
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
@Path("/parameterDetails")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class parameterDetailsResource {
	
	@GET
    @Path("/get")
    public List<parameterDetails> getall(){
        return parameterDetails.listAll();
    }

    @POST
    @Transactional
    @Path("/post")
    public Response add(parameterDetails item){
        item.persist();
        return Response.ok(item).status(201).build();
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    public Response deleteOne(@PathParam("id") Long id){
    	parameterDetails entity = parameterDetails.findById(id);
        entity.delete();
        return Response.status(204).build();
    }

    @PATCH
    @Transactional
    @Path("/{id}")
    public Response update(parameterDetails item, @PathParam("id") Long id){
    	parameterDetails entity = parameterDetails.findById(id);
        entity.sequence=item.sequence;
        entity.operator=item.operator;
        entity.startValue=item.startValue;
        entity.endValue=item.endValue;
        entity.likeValue=item.likeValue;
        entity.weight=item.weight;
        entity.reasonCode=item.reasonCode;
        entity.idModelParameter=item.idModelParameter;
        entity.idReasonCode=item.idReasonCode;
        entity.id=id;
        return Response.ok(entity).status(200).build();
    }
    
    @GET
    @Transactional
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public parameterDetails id(@PathParam Long id){
        return parameterDetails.findById(id);
    }
    
    // Methods GET BY active_flag
 	@GET
    @Transactional
    @Path("/get_by/{operator}")
    @Produces(MediaType.APPLICATION_JSON)
    public parameterDetails operator(@PathParam String operator) {
     	return parameterDetails.findByName(operator);
     }
}
