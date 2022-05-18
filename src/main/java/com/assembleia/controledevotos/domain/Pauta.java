package com.assembleia.controledevotos.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.HashMap;

@Data
public class Pauta {

    @Id
    private String id;
    private HashMap<Associado, Voto> votacao;
}
