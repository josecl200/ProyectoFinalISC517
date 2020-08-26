package edu.pucmm.josecl200.finalavanzada.notificacionesmicro.repositorios;

import edu.pucmm.josecl200.finalavanzada.notificacionesmicro.entidades.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FacturaRepo extends JpaRepository<Factura,Long> {

    List<Factura> findAllByUsername(String username);
}
