package edu.pucmm.josecl200.finalavanzada.compramicro.repositorios;

import edu.pucmm.josecl200.finalavanzada.compramicro.entidades.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompraRepo extends JpaRepository<Compra,Long> {

}
