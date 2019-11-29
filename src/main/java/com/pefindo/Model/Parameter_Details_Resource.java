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
@Path("/parameter_details")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class Parameter_Details_Resource {
	
	@GET
    @Path("/get")
    public List<Parameter_Details> getall(){
        return Parameter_Details.listAll();
    }

    @POST
    @Transactional
    @Path("/post")
    public Response add(Parameter_Details item){
        item.persist();
        return Response.ok(item).status(201).build();
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    public Response deleteOne(@PathParam("id") Long id){
    	Parameter_Details entity = Parameter_Details.findById(id);
        entity.delete();
        return Response.status(204).build();
    }

    @PATCH
    @Transactional
    @Path("/{id}")
    public Response update(Parameter_Details item, @PathParam("id") Long id){
    	Parameter_Details entity = Parameter_Details.findById(id);
        entity.sequence=item.sequence;
        entity.operator=item.operator;
        entity.start_value=item.start_value;
        entity.end_value=item.end_value;
        entity.like_value=item.like_value;
        entity.weight=item.weight;
        entity.reason_code=item.reason_code;
        entity.id_model_parameter=item.id_model_parameter;
        entity.id_reason_code=item.id_reason_code;
        entity.id=id;
        return Response.ok(entity).status(200).build();
    }
    
    @GET
    @Transactional
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Parameter_Details id(@PathParam Long id){
        return Parameter_Details.findById(id);
    }
    
    // Methods GET BY active_flag
 	@GET
    @Transactional
    @Path("/get_by/{operator}")
    @Produces(MediaType.APPLICATION_JSON)
    public Parameter_Details active_flag(@PathParam String operator) {
     	return Parameter_Details.findByName(operator);
     }
}
