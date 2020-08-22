package edu.pucmm.josecl200.finalavanzada.usuariomicro.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity @NoArgsConstructor @AllArgsConstructor @Getter @Setter
public class Usuario implements Serializable {
    @Id
    private String username;
    private String nombre;
    private String password;
    @Column(unique = true)
    private String correo;
    private boolean empleado;
}
