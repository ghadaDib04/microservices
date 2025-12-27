package com.microservecies.inventory_service.InventorySer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<inventory , Integer> {

   // boolean existsByskucodeAndQuantityGreaterThanEqual(String sku_code, Integer quantity);
    // boolean existsBysku_codeAndQuantityGreaterThanEqual(Integer quantity, String sku_code);


   // boolean exists(String sku_code);



}
