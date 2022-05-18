package com.assembleia.controledevotos.service;

import com.assembleia.controledevotos.DTO.AssembleiaDTO;
import com.assembleia.controledevotos.domain.Assembleia;
import com.assembleia.controledevotos.repository.AssembleiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssembleiaService {

    @Autowired
    private AssembleiaRepository repository;

    public Assembleia insert(Assembleia assembleia){
        return repository.save(assembleia);
    }

    public Assembleia fromDTO(AssembleiaDTO assembleiaDTO) {
        return new Assembleia(null, assembleiaDTO.getPauta());
    }
}
