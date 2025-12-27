package com.microservecies.order_service.OrderSer;

import com.microservecies.order_service.Client.inventoryClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final inventoryClient inventoryClient;

    public void placeOrder(OrderRequest orderRequest){
        boolean isProductInStock = inventoryClient.IsinStock(orderRequest.skuCode() , orderRequest.quantity());
        System.out.println(isProductInStock);
        if(isProductInStock){
            Order order = new Order();
            order.setOrderNumber(UUID.randomUUID().toString());
            order.setSkuCode(orderRequest.skuCode());
            order.setOrderStatus(orderRequest.orderStatus());
            order.setPrice(orderRequest.price());
            order.setQuantity(orderRequest.quantity());
            order.setCustomerName(orderRequest.customerName());
            orderRepository.save(order);
        }else{
            throw new RuntimeException("Product not found" + orderRequest.skuCode());
        }


    }
}
