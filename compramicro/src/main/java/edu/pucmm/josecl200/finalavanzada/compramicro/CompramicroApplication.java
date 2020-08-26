package edu.pucmm.josecl200.finalavanzada.compramicro;

import edu.pucmm.josecl200.finalavanzada.compramicro.servicios.EventoServicios;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class CompramicroApplication {
    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(CompramicroApplication.class, args);
        EventoServicios eventoServicios = (EventoServicios) applicationContext.getBean("eventoServicios");
        eventoServicios.createEventos();
    }
}
