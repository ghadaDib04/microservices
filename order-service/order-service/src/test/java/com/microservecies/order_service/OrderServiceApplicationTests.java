package com.microservecies.order_service;

import com.microservecies.order_service.Stubs.InventoryClientStub;
import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.testcontainers.mysql.MySQLContainer;

import static org.hamcrest.MatcherAssert.assertThat;
import org.springframework.cloud.contract.wiremock.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class OrderServiceApplicationTests {

    @ServiceConnection
    static MySQLContainer mySQLContainer = new MySQLContainer("mysql:5.7.22");

    @LocalServerPort
    private Integer port;

    @BeforeEach
    void setUp() throws InterruptedException {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = port ;
    }

    static {
        mySQLContainer.start();
    }

    @Test
    void shouldplaceOrder() {
        String requestBody = """
                {
                    "skuCode": "iphone_15",
                    "orderStatus": "CREATED",
                    "price": 1200.50,
                    "quantity": 150,
                    "customerName": "Ghada Dib"
                }
                """;

        InventoryClientStub.stubInventoryCall("iphone_15", 1);

        var responseBodyString = RestAssured.given()
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post("/service/order/add")
                .then()
                .log().all()
                .statusCode(201)
                .extract()
                .body().asString();

        assertThat(responseBodyString, Matchers.is("Order Placed Successfully"));
    }

}
