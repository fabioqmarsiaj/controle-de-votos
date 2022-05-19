package com.assembleia.controledevotos.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.HashMap;

@Data
public class Pauta {

    @Id
    private final String id;
    private final String nome;
    private final HashMap<String, Associado> votacao;

    public Pauta(String id, String nome, HashMap<String, Associado> votacao) {
        this.id = id;
        this.nome = nome;
        this.votacao = votacao;
    }

    public void adicionarVoto(String idAssociado, Associado associado) {

        votacao.put(idAssociado, associado);
    }



}
