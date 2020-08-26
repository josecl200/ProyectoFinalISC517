package edu.pucmm.josecl200.finalavanzada.compramicro.repositorios;

import edu.pucmm.josecl200.finalavanzada.compramicro.entidades.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompraRepo extends JpaRepository<Compra,Long> {
    List<Compra> findComprasByUsername(String username);
}
