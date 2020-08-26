package edu.pucmm.josecl200.finalavanzada.notificacionesmicro.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor @Data @NoArgsConstructor
public class Usuario {
    private String username;
    private String correo;
    private String nombre;
    private String password;
    private boolean empleado;
    private boolean admin;
}
