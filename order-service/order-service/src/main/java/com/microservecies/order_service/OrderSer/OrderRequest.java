package com.microservecies.order_service.OrderSer;

import java.math.BigDecimal;

public record OrderRequest (Long id ,
                            String orderNumber,
                            String skuCode ,
                            String orderStatus,
                            BigDecimal price,
                            Integer quantity,
                            String customerName ){

}
