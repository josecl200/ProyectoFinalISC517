package edu.pucmm.josecl200.finalavanzada.compramicro.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class Login {
    private String username;
    private String nombre;
    private String password;
    private String correo;
    private boolean empleado;
    private boolean admin;
}
