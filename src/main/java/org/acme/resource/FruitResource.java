package org.acme.resource;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.acme.dto.FruitFormDTO;
import org.acme.model.Fruit;
import org.acme.service.FruitService;

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
}