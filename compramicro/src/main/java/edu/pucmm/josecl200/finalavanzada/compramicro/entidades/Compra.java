package edu.pucmm.josecl200.finalavanzada.compramicro.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity @Data @AllArgsConstructor @NoArgsConstructor
public class Compra implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private float monto;
    private String username;
    private LocalDateTime fecha;
    @ManyToOne
    private Evento evento;
}