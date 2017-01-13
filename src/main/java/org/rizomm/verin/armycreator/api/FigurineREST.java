package org.rizomm.verin.armycreator.api;

import org.rizomm.verin.armycreator.DAO.IFigurineEJB;
import org.rizomm.verin.armycreator.Model.CFigurine;

import javax.ejb.EJB;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.List;

@Path(value = "/figurines")
public class FigurineREST {

    @EJB
    private IFigurineEJB figurineEJB;
    @Context()
    private UriInfo uriInfo;

    @GET
    @Path("/all")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<CFigurine> getAllFigurine(){
        return figurineEJB.getAllFigurines();
    }


    @GET
    @Path("/{id : \\d+}")
    @Produces(MediaType.APPLICATION_XML)
    public CFigurine getFigurineById(@PathParam("id") Long id){
        return figurineEJB.findFigurineById(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public Response createFigurine(CFigurine figurine){
        figurineEJB.createFigurine(figurine);
        URI figUri = uriInfo.getAbsolutePathBuilder().path(figurine.getId().toString()).build();
        return Response.created(figUri).build();
    }

    @PUT
    @Path("/{id : \\d+}")
    public CFigurine updateFigurine(CFigurine figurine){
        return figurineEJB.updateFigurine(figurine);
    }

    @DELETE
    @Path("/{id : \\d+}")
    public Response deleteFigurineById(@PathParam("id") Long id){
        figurineEJB.deleteFigurine(figurineEJB.findFigurineById(id));
        return Response.noContent().build();
    }
}
