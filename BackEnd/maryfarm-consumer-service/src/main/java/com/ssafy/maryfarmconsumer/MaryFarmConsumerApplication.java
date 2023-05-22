package com.ssafy.maryfarmconsumer;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@OpenAPIDefinition
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
@EnableScheduling
public class MaryFarmConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MaryFarmConsumerApplication.class, args);
    }

}
