package org.rizomm.verin.armycreator.api;


import org.rizomm.verin.armycreator.DAO.IArmyEJB;
import org.rizomm.verin.armycreator.Model.CArmy;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.List;

@Path(value="/armies")
public class ArmyREST {

    @EJB
    private IArmyEJB armyEJB;
    @Context
    private UriInfo uriInfo;

    @GET
    @Path("/all")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<CArmy> getAllArmies(){ return armyEJB.getAllArmies();}

    @GET
    @Path("/{id : \\d+}")
    public CArmy getArmyById(@PathParam("id") Long id){
        return armyEJB.findArmyById(id);
    }

    @POST
    public Response createArmy(CArmy army){
        armyEJB.createArmy(army);
        URI armyUri = uriInfo.getAbsolutePathBuilder().path(army.getId().toString()).build();
        return Response.created(armyUri).build();
    }

    @PUT
    @Path("/{id : \\d+}")
    public CArmy updateArmy(@PathParam("id") Long id){
        CArmy army = getArmyById(id);
        return armyEJB.updateArmy(army);
    }

    @DELETE
    @Path("/{id : \\d+}")
    public Response deleteFigurineById(@PathParam("id") Long id){
        armyEJB.deleteArmy(getArmyById(id));
        return Response.noContent().build();
    }

}
