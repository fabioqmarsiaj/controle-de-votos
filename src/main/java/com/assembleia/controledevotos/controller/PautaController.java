package com.assembleia.controledevotos.controller;

import com.assembleia.controledevotos.DTO.PautaDTO;
import com.assembleia.controledevotos.domain.Pauta;
import com.assembleia.controledevotos.exception.PautaNotFoundException;
import com.assembleia.controledevotos.service.PautaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.HashMap;

@RestController
@RequestMapping(value = "/cadastrar")
public class PautaController {

    @Autowired
    private PautaService service;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Void> cadastrar(@Valid @RequestParam String nome) {
        PautaDTO pautaDTO = new PautaDTO(null, nome.toUpperCase(), new HashMap<>());
        Pauta pauta = service.fromDTO(pautaDTO);
        pauta = service.cadastrar(pauta);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(pauta.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<String> contagemDeVotos(@Valid @RequestParam String nome) throws PautaNotFoundException {
        Pauta pauta = service.findByNome(nome.toUpperCase());

        if (pauta != null) {
            return ResponseEntity.ok(service.contagemDeVotos(pauta));
        } else {
            throw new PautaNotFoundException();
        }
    }
}
