package edu.pucmm.josecl200.finalavanzada.microdiscovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class MicroDiscoveryApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroDiscoveryApplication.class, args);
    }
}
