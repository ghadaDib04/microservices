package com.microservices.Product.service;

import com.microservices.Product.service.ProductSer.ProductEntity;
import com.microservices.Product.service.ProductSer.ProductRepository;
import com.microservices.Product.service.ProductSer.ProductRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservices.Product.service.ProductSer.ProductResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.shaded.org.hamcrest.Matchers;
import static org.hamcrest.Matchers.*;
import org.testcontainers.utility.DockerImageName;
import io.restassured.RestAssured;
import java.math.BigDecimal;
import java.util.List;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@Testcontainers
//@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductServiceApplicationTests {
//
//    @Container
//    @ServiceConnection
//    static MongoDBContainer mongoDBContainer = new MongoDBContainer(DockerImageName.parse("mongo:7.0"));
//    @Autowired
//    private ProductRepository  productRepository;
//    private MockMvc mockMvc;
//    @Autowired
//    private WebApplicationContext webApplicationContext;
//    private ObjectMapper objectMapper = new ObjectMapper();
//
//    @BeforeEach
//    void setUp() {
//        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
//    }
//
//    @DynamicPropertySource
//    static void setProperties(DynamicPropertyRegistry dynamicPropertyRegistry) {
//        dynamicPropertyRegistry.add("spring.data.mongodb.uri", mongoDBContainer::getReplicaSetUrl);
//    }
//
//    @Test
//    void shouldCreateProduct() throws Exception {
//        ProductRequest productRequest = getProductRequest();
//        String productRequestString = objectMapper.writeValueAsString(productRequest);
//        mockMvc.perform(MockMvcRequestBuilders.post("/service/product/add")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(productRequestString))
//                .andExpect(status().isCreated());
//        Assertions.assertEquals(1, productRepository.findAll().size());
//    }
//
//    private ProductRequest getProductRequest() {
//        return ProductRequest.builder()
//                .name("iphone 13")
//                .price(BigDecimal.valueOf(100.00))
//                .description("new iphone 13")
//                .build();
//    }
//
//
//    @Test
//    void shouldGetAllProducts() throws Exception {
//        // Create a product first
//        ProductRequest productRequest = getProductRequest();
//        String productRequestString = objectMapper.writeValueAsString(productRequest);
//
//        mockMvc.perform(MockMvcRequestBuilders.post("/service/product/add")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(productRequestString))
//                .andExpect(status().isCreated());
//
//        // Get all products
//        mockMvc.perform(MockMvcRequestBuilders.get("/service/product")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(result -> {
//                    String content = result.getResponse().getContentAsString();
//                    assert !content.isEmpty();
//                    assert content.contains("iphone 13");
//                });
//    }
//
//
//
//
//
//    public List<ProductResponse> getProducts(){
//        List<ProductEntity> products = productRepository.findAll();
//        return products.stream().map(this::mapToProductResponse).toList();
//    }
//
//    private ProductResponse mapToProductResponse(ProductEntity productEntity){
//        return ProductResponse.builder()
//                .id(productEntity.getId())
//                .name(productEntity.getName())
//                .description(productEntity.getDescription())
//                .price(productEntity.getPrice())
//                .build();
//    }


    @Container
    @ServiceConnection
    static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:7.0.5");

    @LocalServerPort
    private Integer port;

    @BeforeEach
    void setup() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = port;
    }
    @Test
    void shouldCreateProduct() {
        String requestBody = """
                {
                    "name": "iphone 13",
                    "price": 1000.00,
                    "description": "new iphone 13"
                }
                """;

        RestAssured.given()
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post("/service/product/add")
                .then()
                .statusCode(201);
    }

        }