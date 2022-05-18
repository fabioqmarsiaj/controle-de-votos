package com.assembleia.controledevotos.domain;

import lombok.Data;

import java.util.HashMap;

@Data
public class Pauta {

    private String id;
    private HashMap<Associado, Voto> votacao;
}
