package com.microservices.api_gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class SecurityConfig {

//    private final String[] freeResourceUrls = {
//            "/swagger-ui.html" , "swagger-ui/**" , "/v3/product-docs/**" , "/v3/api-docs/**" , "/v3/order-docs/**" , "/v3/inventory-docs/**" ,
//            "/swagger-resources/**" , "/order-docs/**" , "/product-docs/**" , "/inventory-docs/**" , "/api-docs/**" ,
//            "/aggregate/product-service/**" , "/aggregate/order-service/**" , "/aggregate/inventory-service/**" ,
//    } ;
private final String[] freeResourceUrls = {"/swagger-ui.html", "/swagger-ui/**", "/v3/api-docs/**",
        "/swagger-resources/**", "/api-docs/**", "/aggregate/**", "/actuator/prometheus"};

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(freeResourceUrls)
                        .permitAll()
                        .anyRequest()
                        .authenticated())
                        .oauth2ResourceServer(oauth2 -> oauth2.jwt(Customizer.withDefaults()))
                .build();
    }
}
