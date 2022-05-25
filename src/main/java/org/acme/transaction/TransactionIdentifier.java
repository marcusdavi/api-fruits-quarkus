package org.acme.transaction;

import java.time.Instant;
import java.util.Random;

public class TransactionIdentifier {

    private String prefix;
    private int id;
    private Instant begin;
    

    public TransactionIdentifier(String prefix) {
        super();
        this.id = new Random().nextInt();
        this.begin = Instant.now();
        this.prefix = prefix;
    }

    public String getIdTransaction(){
        return String.format("%s - %d - %s", prefix, id, begin);
    }


    

    
}
