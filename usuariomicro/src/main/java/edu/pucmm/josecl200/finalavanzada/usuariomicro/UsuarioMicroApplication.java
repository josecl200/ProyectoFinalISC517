package edu.pucmm.josecl200.finalavanzada.usuariomicro;

import edu.pucmm.josecl200.finalavanzada.usuariomicro.servicios.UsuarioServices;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ApplicationContext;

@SpringBootApplication @EnableDiscoveryClient
public class UsuarioMicroApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(UsuarioMicroApplication.class, args);
        UsuarioServices usuarioServicios = (UsuarioServices) applicationContext.getBean("usuarioServices");
        usuarioServicios.crearUsuarioAdmin();
    }

}
