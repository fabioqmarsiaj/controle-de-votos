package com.assembleia.controledevotos.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Assembleia {

    @Id
    private  final String id;
    private final Pauta pauta;

    public Assembleia(String id, Pauta pauta) {
        this.id = id;
        this.pauta = pauta;
    }
}
