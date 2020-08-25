package edu.pucmm.josecl200.finalavanzada.compramicro.entidades;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity @Data @AllArgsConstructor @NoArgsConstructor
public class Parametro implements Serializable {
    @Id
    Integer codigo;
    String nombre;
    String valor;
}