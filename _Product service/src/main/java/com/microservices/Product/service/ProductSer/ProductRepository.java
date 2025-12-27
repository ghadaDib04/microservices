package com.microservices.Product.service.ProductSer;


import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
public interface ProductRepository extends MongoRepository<ProductEntity, String> {
}
