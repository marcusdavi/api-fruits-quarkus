package org.acme.resource;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import org.acme.dto.FruitFormDTO;
import org.acme.model.Fruit;
import org.acme.service.FruitService;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

@Path("/fruits")
public class FruitResource {

    @Inject
    FruitService fruitService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Fruit> getAll() {
        return fruitService.allFruits();
    }

    @POST
    public Fruit create(FruitFormDTO fruitForm) {
        return fruitService.create(fruitForm);
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam Long id) {
        fruitService.delete(id);
    }

    @PUT
    @Path("/{id}")
    public Fruit update(@PathParam Long id,  FruitFormDTO fruitForm) {
        return fruitService.update(id, fruitForm);
    }
}