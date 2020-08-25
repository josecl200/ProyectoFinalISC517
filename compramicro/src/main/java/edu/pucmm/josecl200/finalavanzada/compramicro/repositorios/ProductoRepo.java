package edu.pucmm.josecl200.finalavanzada.compramicro.repositorios;

import edu.pucmm.josecl200.finalavanzada.compramicro.entidades.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepo extends JpaRepository<Producto,String> {

}
