package edu.pucmm.josecl200.finalavanzada.notificacionesmicro.controladora;

import edu.pucmm.josecl200.finalavanzada.notificacionesmicro.entidades.Factura;
import edu.pucmm.josecl200.finalavanzada.notificacionesmicro.entidades.Usuario;
import edu.pucmm.josecl200.finalavanzada.notificacionesmicro.servicios.CorreoServices;
import edu.pucmm.josecl200.finalavanzada.notificacionesmicro.servicios.FacturaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequestMapping("/")
public class RestControladora {
    @Autowired
    private FacturaServices facturaServices;
    @Autowired
    private CorreoServices correoServices;
    @RequestMapping("/prueba")
    public String test(){
        return "La grasa en cajita";
    }
    @PostMapping("/")
    public String createFactura(@RequestBody Factura factura){
        facturaServices.saveeFactura(factura);
        correoServices.sendEmail(factura.getUsername(), factura.getMail(), "Compra realizada!", "Aqui el resumen de su compra: ");
        return "compra realizada!";
    }

    @PostMapping("/nuevaCuenta")
    public String sendAccountNotification(@RequestParam("username") String username, @RequestParam("username_email") String username_email){
        correoServices.sendEmail(username, username_email, "Gracias por registrarse a nuestra pagina.","Un saludo.");
        return "";
    }

    @PostMapping("/correoCompra")
    public String correoCompra(@RequestBody List<Usuario> empleados)
    {
        for(int i = 0; i < empleados.size(); i++){
            correoServices.sendEmail(empleados.get(i).getNombre(), empleados.get(i).getCorreo(), "Compra realizada", "Usted realizo una compra!");
        }
        return "Correos enviados!";
    }
}
