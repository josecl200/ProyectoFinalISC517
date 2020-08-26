package edu.pucmm.josecl200.finalavanzada.compramicro.servicios;

import com.netflix.discovery.converters.Auto;
import com.sendgrid.*;
import edu.pucmm.josecl200.finalavanzada.compramicro.entidades.Compra;
import edu.pucmm.josecl200.finalavanzada.compramicro.entidades.Evento;
import edu.pucmm.josecl200.finalavanzada.compramicro.entidades.Login;
import edu.pucmm.josecl200.finalavanzada.compramicro.repositorios.CompraRepo;
import edu.pucmm.josecl200.finalavanzada.compramicro.repositorios.EventoRepo;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CompraServicios {
    @Autowired
    private CompraRepo compraRepo;
    @Autowired
    private EventoRepo eventoRepo;
    public Compra crearVenta(Evento producto, String username) {
        LocalDateTime date = LocalDateTime.now();
        Compra venta = new Compra();
        venta.setUsername(username);
        venta.setMonto(producto.getPrecio());
        venta.setEvento(producto);
        venta.setFecha(date);
        compraRepo.save(venta);
        return venta;
    }

    public List<Compra> getAllCompras(){
        return compraRepo.findAll();
    }

    public List<Compra> getAllComprasByUser(String username){
        return compraRepo.findComprasByUsername(username);
    }

    public void enviarEmailConfirmacionVenta(Compra compra) throws IOException {
        RestTemplate restTemplate=new RestTemplate();
        Email from = new Email("20160138@ce.pucmm.edu.do");
        String subject = "Detalles de compra";
        String apiKey = System.getenv("SENDGRID_API_KEY");
        Login login = restTemplate.getForObject("http://perimetral/usuariomicro?usuario="+compra.getUsername(),Login.class);
        Email to = new Email(login.getCorreo());
        String body = "Gracias por su compra, " + login.getNombre() +
                "\n\nSu paquete " + compra.getEvento().getNombre() + " ha sido procesado." +
                "\n\nUn saludo";
        Content content = new Content("text/plain", body);
        Mail mail = new Mail(from, subject, to, content);
        SendGrid sendGrid  = new SendGrid(apiKey);
        Request request = new Request();
        request.setMethod(Method.POST);
        request.setEndpoint("mail/send");
        request.setBody(mail.build());
        Response response = sendGrid.api(request);
    }
    public void enviarCorreoEmpleados(Compra compra) {
        RestTemplate restTemplate=new RestTemplate();

        Email from = new Email("20160138@ce.pucmm.edu.do");
        String apiKey = System.getenv("SENDGRID_API_KEY");
        SendGrid sendGrid = new SendGrid(apiKey);
        String url = "http://perimetral/usuariomicro/empleados";
        Login[] responses = restTemplate.getForObject(url, Login[].class);
        assert responses != null;
        for (Login empleado : responses) {
            Email to = new Email(empleado.getCorreo());
            String subject = "Nuevo trabajo";
            String body = "El usuario: " + compra.getUsername() +
                    "\n\nA realizado una compra del paquete " + compra.getEvento().getNombre() + " que se debe trabajar en el." +
                    "\n\nUn saludo,";
            Content content = new Content("text/plain", body);
            Mail mail = new Mail(from, subject, to, content);
            Request request = new Request();
            try {
                request.setMethod(Method.POST);
                request.setEndpoint("mail/send");
                request.setBody(mail.build());
                Response response = sendGrid.api(request);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    public String exportReport(String reportFormat, HttpServletResponse response) throws IOException, JRException {
        String path = "classpath:reportes/";
        List<Compra> ventas = compraRepo.findAll();
        File file = ResourceUtils.getFile("classpath:ventas.jrxml");
        JasperReport jasperReport= JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource= new JRBeanCollectionDataSource(ventas);
        Map<String,Object> parameters = new HashMap<>();
        JasperPrint jasperPrint= JasperFillManager.fillReport(jasperReport,parameters,dataSource);
        if(reportFormat.equalsIgnoreCase("html")){
            JasperExportManager.exportReportToHtmlFile(jasperPrint,path+"/ventas.html");
        }
        if(reportFormat.equalsIgnoreCase("pdf")){
            JasperExportManager.exportReportToPdfFile(jasperPrint,path+"/ventas.pdf");
            JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
            response.setContentType("application/pdf");
            response.addHeader("Content-Disposition", "inline; filename=factura.pdf;");
        }
        return "Reporte generado en ruta: " + path;
    }
}
