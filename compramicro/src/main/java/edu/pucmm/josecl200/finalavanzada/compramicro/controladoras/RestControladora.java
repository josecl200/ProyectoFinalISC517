package edu.pucmm.josecl200.finalavanzada.compramicro.controladoras;

import edu.pucmm.josecl200.finalavanzada.compramicro.entidades.Evento;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController @RequestMapping("/")
public class RestControladora {
    @GetMapping("/prueba")
    public String prueba(){
        return "La grasa en fundita";
    }

    @GetMapping("/")
    public Evento
}
