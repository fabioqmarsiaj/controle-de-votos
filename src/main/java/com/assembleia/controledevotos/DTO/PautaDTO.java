package com.assembleia.controledevotos.DTO;

import com.assembleia.controledevotos.domain.Associado;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;

@Data
@AllArgsConstructor
public class PautaDTO {

    private String id;
    private String nome;
    private HashMap<String, Associado> votacao;

}
