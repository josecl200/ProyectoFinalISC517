package edu.pucmm.josecl200.finalavanzada.notificacionesmicro.entidades;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity @Data @AllArgsConstructor @NoArgsConstructor
public class Factura implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String mail;
    private Set<String> paquetes;
    private double total;
}
