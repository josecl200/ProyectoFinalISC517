package edu.pucmm.josecl200.finalavanzada.compramicro.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity @NoArgsConstructor @AllArgsConstructor @Data
public class Evento implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private Float precio;
}
