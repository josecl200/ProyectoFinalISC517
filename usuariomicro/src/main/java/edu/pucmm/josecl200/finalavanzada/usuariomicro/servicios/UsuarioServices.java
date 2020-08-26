package edu.pucmm.josecl200.finalavanzada.usuariomicro.servicios;

import com.sendgrid.*;
import edu.pucmm.josecl200.finalavanzada.usuariomicro.entidades.Usuario;
import edu.pucmm.josecl200.finalavanzada.usuariomicro.repositorios.UsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServices {
    @Autowired
    private UsuarioRepo repo;

    @Transactional
    public void createUsuario(Usuario usuario){
        if(repo.findByUsername(usuario.getUsername())==null)
            repo.save(usuario);
    }

    @Transactional
    public void deleteUsuario(String username){
        Usuario user = repo.findByUsername(username);
        if(user!=null)
            repo.delete(user);
    }

    @Transactional
    public void editUsuario(Usuario usuario){
        Optional<Usuario> e = Optional.ofNullable(repo.findByUsername(usuario.getUsername()));
        if(e.isPresent()){
            Usuario newUser = e.get();
            newUser.setUsername(usuario.getUsername());
            newUser.setCorreo(usuario.getCorreo());
            newUser.setPassword(usuario.getPassword());
            newUser.setNombre(usuario.getNombre());
            newUser.setEmpleado(usuario.isEmpleado());
        }
    }

    public void crearUsuarioAdmin(){
        Usuario admin = new Usuario();
        admin.setUsername("root");
        admin.setPassword(org.apache.commons.codec.digest.DigestUtils.sha256Hex("toor"));
        admin.setEmpleado(true);
        admin.setNombre("Root");
        admin.setCorreo("admin@admin.com");
        repo.save(admin);
    }

    public List<Usuario> getAllUsers(){
        return repo.findAll();
    }
    public Usuario getUser(String username){
        return repo.findByUsername(username);
    }
    public List<Usuario> getAllEmpleados(){return repo.findUsuariosByEmpleado(true);}
    public List<Usuario> getAllClientes(){return repo.findUsuariosByEmpleado(false);}


    public boolean sendRegistrationEmail(Usuario user){
        Email desdeEmail = new Email("20160138@ce.pucmm.edu.do");
        String asuntoEmail = "Creacion de cuenta";
        Email paraEmail = new Email(user.getCorreo());
        Content cuerpoEmail = new Content("text/plain", "El usuario registrado fue:: " + user.getUsername());
        Mail email = new Mail(desdeEmail, asuntoEmail, paraEmail, cuerpoEmail);
        System.out.println("APIKEY E IGUAL A "+System.getenv("SENDGRID_API_KEY"));
        SendGrid sg = new SendGrid(System.getenv("SENDGRID_API_KEY"));
        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(email.build());
            Response response = sg.api(request);
            System.out.println(response.getStatusCode());
            System.out.println(response.getBody());
            System.out.println(response.getHeaders());
        } catch (IOException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;

    }

}
