package com.microservecies.order_service.Client;



import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.GetExchange;

// @FeignClient(value = "inventory-service" , url = "http://localhost:8085")

//HTTP INTERFACE
public interface inventoryClient {

    //@RequestMapping(method = RequestMethod.GET , value = "/service/inventory/exists" )
    @GetExchange("/service/inventory/exists")
    boolean IsinStock(@RequestParam String sku_code , @RequestParam Integer quantity);
}
