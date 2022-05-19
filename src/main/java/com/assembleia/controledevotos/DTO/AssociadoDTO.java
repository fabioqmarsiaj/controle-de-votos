package com.assembleia.controledevotos.DTO;

import com.assembleia.controledevotos.domain.Voto;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AssociadoDTO {

    private String id;
    private String cpf;
    private Voto voto;
}
