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
    private String nombre;
    private String factura;
    private String transaccion;
    private String estatusPago;
    private BigDecimal montoCompra;
    private BigDecimal montoFee;
    private BigDecimal montoEnvio;
    private BigDecimal montoManejo;
    private String emailComprador;
    private Date fechaCompra;
    private String vendedor;
    private String username;
    private LocalDateTime fecha;
    private String direccion;
    private String zip;
    private String estado;
    private String ciudad;
    private String user;
}