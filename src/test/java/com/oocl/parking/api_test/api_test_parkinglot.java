package com.oocl.parking.api_test;

import com.oocl.parking.entities.Parkinglot;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.given;
import static org.springframework.http.ResponseEntity.status;

public class api_test_parkinglot {

    private static RequestSpecification requestSpec;

    @BeforeAll
    public static void createRequestSpecification() {

        requestSpec = new RequestSpecBuilder().
                setBaseUri("http://localhost").
                setPort(8080).
                setBasePath("/api/v1").
                build();
    }

    @Test
    public void should_get_created_status_when_save_lot(){
        Parkinglot parkinglot = new Parkinglot("lots", 10, "open");
        given()
                .spec(requestSpec)
                .body(parkinglot)
                .contentType(ContentType.JSON)
        .when()
                .post("/parkinglots")
        .then().log().all()
                .statusCode(201);

    }

    @Test
    public void should_get_bad_request_when_get_call_given_no_lots(){
        given()
            .spec(requestSpec)
        .when()
            .get("/parkinglots")
        .then()
            .statusCode(200);
    }
}
