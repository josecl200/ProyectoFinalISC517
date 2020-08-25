package edu.pucmm.josecl200.finalavanzada.compramicro.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity @NoArgsConstructor @AllArgsConstructor @Data
public class Evento implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    @OneToMany
    private List<Producto> productosIncluidos;
    private Float precio;
}
