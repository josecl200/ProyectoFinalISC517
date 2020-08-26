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

    public void saveCompra(Compra compra){
        compraRepo.save(compra);
    }

    public List<Compra> getAllCompras() {
        return compraRepo.findAll();
    }

    public List<Compra> getAllComprasByUser(String username) {
        return compraRepo.findComprasByUsername(username);
    }

}

