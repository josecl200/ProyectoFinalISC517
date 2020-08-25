package edu.pucmm.josecl200.finalavanzada.usuariomicro.controladoras;

import edu.pucmm.josecl200.finalavanzada.usuariomicro.entidades.Login;
import edu.pucmm.josecl200.finalavanzada.usuariomicro.entidades.Usuario;
import edu.pucmm.josecl200.finalavanzada.usuariomicro.servicios.UsuarioServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

@RestController @RequestMapping("/")
public class RestControladora {
    private String llaveSecreta="bruhmomentobruhmomentobruhmomentobruhmomentobruhmomentobruhmomentobruhmomentobruhmomentobruhmomentobruhmomentobruhmomentobruhmomentobruhmomentobruhmomentobruhmomentobruhmomentobruhmomentobruhmomentobruhmomentobruhmomentobruhmomentobruhmomentobruhmomentobruhmomentobruhmomentobruhmomentobruhmomentobruhmomentobruhmomento";

    @Autowired
    private UsuarioServices usuarioServices;

    @PostMapping("/")
    public Usuario crearUsuario(@RequestBody Usuario usuario){
        usuario.setPassword(org.apache.commons.codec.digest.DigestUtils.sha256Hex(usuario.getPassword()));
        usuarioServices.createUsuario(usuario);
        usuarioServices.sendRegistrationEmail(usuario);
        return usuario;
    }

    @GetMapping("/")
    public Object getUsuarios(@RequestParam(required = false) String usuario){
        if (usuario==null)
            return usuarioServices.getAllUsers();
        else
            return usuarioServices.getUser(usuario);
    }

    @DeleteMapping("/{usuario}")
    public Usuario deleteUsuario(@PathVariable("usuario") String idUsuario){
        Usuario user=usuarioServices.getUser(idUsuario);
        if(user!=null){
            usuarioServices.deleteUsuario(idUsuario);
        }
        return user;
    }

    @PutMapping("/{usuario}")
    public Usuario updateUsuario(@PathVariable("usuario") String idUsuario, @RequestBody Usuario usuario){
        Usuario user=usuarioServices.getUser(idUsuario);
        if(user!=null){
            usuarioServices.editUsuario(usuario);
        }
        return usuarioServices.getUser(idUsuario);
    }

    @PostMapping("/auth")
    public ResponseEntity<?> auth(@RequestBody Login username){
        String token;
        Usuario usuario = usuarioServices.getUser(username.getUsername());
        System.out.println(username);
        if(usuario==null && !usuario.getPassword().equals(org.apache.commons.codec.digest.DigestUtils.sha256Hex(username.getPassword()))){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        token = generarToken(usuario);
        return ResponseEntity.ok(token);
    }

    private String generarToken(Usuario usuario) {
        String token = Jwts
                .builder()
                .setId("estimadoWT")
                .setSubject(usuario.getUsername())
                .claim("empleado",usuario.isEmpleado())
                .claim("admin",usuario.isEmpleado())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 600000))
                .signWith(SignatureAlgorithm.HS512,
                        llaveSecreta.getBytes()).compact();

        return token;
    }

}
