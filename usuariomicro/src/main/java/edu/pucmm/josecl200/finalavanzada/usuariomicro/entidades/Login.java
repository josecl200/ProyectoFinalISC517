package edu.pucmm.josecl200.finalavanzada.usuariomicro.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class Login {
    private String username;
    private String password;
}
