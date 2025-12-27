package com.microservecies.order_service.Stubs;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class InventoryClientStub {

    public static void stubInventoryCall(String sku_code, Integer quantity) {
        if (quantity <= 100) {
            stubFor(get(urlEqualTo("/service/inventory/exists?sku_code=" + sku_code + "&quantity=" + quantity))
                    .willReturn(aResponse()
                            .withStatus(200)
                            .withHeader("Content-Type", "application/json")
                            .withBody("true")));
        } else {
            stubFor(get(urlEqualTo("/service/inventory/exists?sku_code=" + sku_code + "&quantity=" + quantity))
                    .willReturn(aResponse()
                            .withStatus(200)
                            .withHeader("Content-Type", "application/json")
                            .withBody("false")));
        }
    }
}