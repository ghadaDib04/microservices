package com.microservecies.inventory_service.InventorySer;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryService {

    public final InventoryRepository inventoryRepository;

    public boolean isInStock(String sku_code , Integer quantity) {
        List<inventory> inventoryList = inventoryRepository.findAll();
        for(inventory inventory : inventoryList){
            if(inventory.getSku_code().equals(sku_code)){
                boolean result = inventory.getQuantity() >= quantity;
                if(result){
                    return true;
                }
            }
        }
        return false;
    }


}
