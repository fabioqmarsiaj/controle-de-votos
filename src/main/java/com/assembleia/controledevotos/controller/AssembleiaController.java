package com.assembleia.controledevotos.controller;

import com.assembleia.controledevotos.DTO.AssembleiaDTO;
import com.assembleia.controledevotos.domain.Assembleia;
import com.assembleia.controledevotos.service.AssembleiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/assembleia")
public class AssembleiaController {

    @Autowired
    private AssembleiaService service;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@RequestBody AssembleiaDTO assembleiaDTO) {
        Assembleia assembleia = service.fromDTO(assembleiaDTO);
        assembleia = service.insert(assembleia);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(assembleia.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }
}
