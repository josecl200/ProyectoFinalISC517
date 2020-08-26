package edu.pucmm.josecl200.finalavanzada.usuariomicro.repositorios;


import edu.pucmm.josecl200.finalavanzada.usuariomicro.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepo extends JpaRepository<Usuario,String> {
    Usuario findByUsername(String username);
    List<Usuario> findUsuariosByEmpleado(boolean empleado);
}
