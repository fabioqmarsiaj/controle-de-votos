package com.assembleia.controledevotos.DTO;

import com.assembleia.controledevotos.domain.Pauta;
import lombok.Data;

import java.io.Serializable;

@Data
public class AssembleiaDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private Pauta pauta;
}
