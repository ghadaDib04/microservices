package com.microservecies.order_service.Config;

import com.microservecies.order_service.Client.inventoryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class RestClientConfig {

    @Bean
    public inventoryClient InventoryClient() {
        RestClient restClient =  RestClient.builder()
                .baseUrl("http//localhost:8085")
                .build() ;
        var restClientAdapter = RestClientAdapter.create(restClient) ;
        var httpServiceProxyFactory = HttpServiceProxyFactory.builderFor(restClientAdapter).build();
        return httpServiceProxyFactory.createClient(inventoryClient.class);

    }
}
