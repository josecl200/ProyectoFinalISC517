package edu.pucmm.josecl200.finalavanzada.compramicro.controladoras;

import edu.pucmm.josecl200.finalavanzada.compramicro.entidades.Compra;
import edu.pucmm.josecl200.finalavanzada.compramicro.entidades.Evento;
import edu.pucmm.josecl200.finalavanzada.compramicro.servicios.CompraServicios;
import edu.pucmm.josecl200.finalavanzada.compramicro.servicios.EventoServicios;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController @RequestMapping("/")
public class RestControladora {
    @Autowired
    private CompraServicios compraServicios;
    @Autowired
    private EventoServicios eventoServicios;
    @GetMapping("/prueba")
    public String prueba(){
        return "La grasa en fundita";
    }

    @GetMapping("/eventos")
    public List<Evento> getEventos(){
        return eventoServicios.getEventos();
    }

    @GetMapping("/compras")
    public List<Compra> getAllCompras(@RequestParam(required = false) String usuario){
        if(usuario!=null)
            return compraServicios.getAllComprasByUser(usuario);
        return compraServicios.getAllCompras();
    }

    @CrossOrigin
    @PostMapping("/compras")
    public void realizarVenta(@RequestBody Evento evento,@RequestParam String usuario, HttpServletResponse response) throws IOException, JRException {
        Compra compra=compraServicios.crearVenta(evento,usuario);
        compraServicios.enviarEmailConfirmacionVenta(compra);
        compraServicios.exportReport("pdf",response);
    }
}
