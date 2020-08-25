package edu.pucmm.josecl200.finalavanzada.compramicro.repositorios;

import edu.pucmm.josecl200.finalavanzada.compramicro.entidades.Parametro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParametroRepo extends JpaRepository<Parametro,Integer> {

}
