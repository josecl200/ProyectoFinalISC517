package edu.pucmm.josecl200.finalavanzada.notificacionesmicro.servicios;

import edu.pucmm.josecl200.finalavanzada.notificacionesmicro.entidades.Factura;
import edu.pucmm.josecl200.finalavanzada.notificacionesmicro.repositorios.FacturaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class FacturaServices {
    @Autowired
    private FacturaRepo repo;

    public List<Factura> getUserFacturas(String usuario){
        return repo.findAllByUsername(usuario);
    }

    @Transactional
    public void saveeFactura(Factura factura){
        repo.save(factura);
    }

    @Transactional
    public void deleteFactura(Long id){
        Factura factura = repo.findById(id).get();
        if(factura != null){
            repo.delete(factura);
        }
    }
}
