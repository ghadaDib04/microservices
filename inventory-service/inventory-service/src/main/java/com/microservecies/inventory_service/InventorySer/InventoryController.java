package com.microservecies.inventory_service.InventorySer;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/service/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping("/exists")
    @ResponseStatus(HttpStatus.OK)
    public Boolean IsinStock(@RequestParam String sku_code , @RequestParam Integer quantity){

        return inventoryService.isInStock(sku_code ,quantity );
    }

}
