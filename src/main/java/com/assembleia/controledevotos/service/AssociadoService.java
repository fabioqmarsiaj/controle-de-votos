package com.assembleia.controledevotos.service;

import com.assembleia.controledevotos.DTO.AssociadoDTO;
import com.assembleia.controledevotos.domain.Associado;
import com.assembleia.controledevotos.domain.Pauta;
import com.assembleia.controledevotos.domain.Voto;
import com.assembleia.controledevotos.exception.AssociadoNotFoundException;
import com.assembleia.controledevotos.repository.AssociadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AssociadoService {

    @Autowired
    private AssociadoRepository repository;
    @Autowired
    private PautaService pautaService;

    public Associado fromDTO(AssociadoDTO associadoDTO) {
        return new Associado(null, associadoDTO.getCpf(), associadoDTO.getVoto());
    }

    public Associado cadastrar(Associado associado){
        return repository.insert(associado);
    }

    public Associado votar(Associado associado, Pauta pauta) {
        pautaService.adicionarVotoNaPauta(pauta, associado);
        return repository.save(associado);
    }

    public Associado find(String id) throws AssociadoNotFoundException {
        Optional<Associado> associado = repository.findById(id);
        if(associado.isPresent()){
            return associado.get();
        }
        else{
            throw new AssociadoNotFoundException();
        }
    }

    public Associado findByCpf(String cpf){
        return repository.findByCpf(cpf);
    }
}
