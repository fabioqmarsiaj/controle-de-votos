package com.assembleia.controledevotos.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Associado {

    @Id
    private String id;
    private Voto voto;
}
