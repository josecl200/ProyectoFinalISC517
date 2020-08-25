package edu.pucmm.josecl200.finalavanzada.compramicro.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity @Data @AllArgsConstructor @NoArgsConstructor
public class Producto implements Serializable {
    @Id
    private String nombreProducto;
}
