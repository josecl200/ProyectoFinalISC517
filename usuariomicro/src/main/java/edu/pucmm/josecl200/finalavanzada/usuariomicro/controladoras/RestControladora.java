package edu.pucmm.josecl200.finalavanzada.usuariomicro.controladoras;

import edu.pucmm.josecl200.finalavanzada.usuariomicro.entidades.Usuario;
import edu.pucmm.josecl200.finalavanzada.usuariomicro.servicios.UsuarioServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController @RequestMapping("/")
public class RestControladora {
    @Autowired
    private UsuarioServices usuarioServices;

    @PostMapping("/")
    public Usuario crearUsuario(@RequestBody Usuario usuario){
        usuarioServices.createUsuario(usuario);
        usuarioServices.sendRegistrationEmail(usuario);
        return usuario;
    }

    @GetMapping("/")
    public Object getUsuarios(@RequestParam String idUsuario){
        if (idUsuario==null || idUsuario=="")
            return usuarioServices.getAllUsers();
        else
            return usuarioServices.getUser(idUsuario);
    }

}
