package org.acme.service;

import static java.util.concurrent.TimeUnit.SECONDS;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import org.acme.transaction.TransactionIdentifier;
import org.acme.dto.FruitFormDTO;
import org.acme.model.Fruit;

import io.quarkus.arc.Lock;
import io.quarkus.arc.Lock.Type;

@ApplicationScoped
@Lock
public final class FruitService {

    @Inject
    TransactionIdentifier transactionIdentifier;
    
    @Lock(value = Type.READ, time =1 , unit = SECONDS)
    public List<Fruit> allFruits() {
        System.out.println(transactionIdentifier.getIdTransaction());
        return Fruit.listAll();
    }

    @Transactional
    public Fruit create(FruitFormDTO fruitForm) {
        System.out.println(transactionIdentifier.getIdTransaction());
        Fruit newFruit = new Fruit();
        newFruit.name = fruitForm.getName();
        newFruit.quantity = fruitForm.getQuantity();

        newFruit.persist();

        return newFruit;
    }
}