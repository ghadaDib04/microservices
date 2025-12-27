package com.microservecies.inventory_service.InventorySer;

public record InventoryRequest (Long id ,
                                String sku_code ,
                                Integer quantity) {
}
