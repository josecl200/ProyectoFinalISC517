package edu.pucmm.josecl200.finalavanzada.notificacionesmicro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication @EnableDiscoveryClient
public class NotificacionesmicroApplication {

    public static void main(String[] args) {
        SpringApplication.run(NotificacionesmicroApplication.class, args);
    }

}
