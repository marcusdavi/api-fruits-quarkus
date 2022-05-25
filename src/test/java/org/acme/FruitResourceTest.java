package org.acme;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import com.google.inject.Inject;

import org.acme.resource.FruitResource;
import org.acme.service.FruitService;
import org.junit.jupiter.api.Test;

import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
@TestHTTPEndpoint(FruitResource.class)
public class FruitResourceTest {

    private static final String BODY_GET_ALL_FRUITS = "[{\"id\":1,\"name\":\"Apple\",\"quantity\":5},{\"id\":2,\"name\":\"Orange\",\"quantity\":1},{\"id\":3,\"name\":\"Melon\",\"quantity\":3}]";

    @Inject
    FruitService fruitService;

    @Test
    public void testGetAllEndpoint() {
        given()
          .when().get()
          .then()
             .statusCode(200)
             .body(is(BODY_GET_ALL_FRUITS));
    }

}