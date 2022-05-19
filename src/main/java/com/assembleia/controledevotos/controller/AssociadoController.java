package com.assembleia.controledevotos.controller;

import com.assembleia.controledevotos.domain.Associado;
import com.assembleia.controledevotos.domain.Pauta;
import com.assembleia.controledevotos.domain.Voto;
import com.assembleia.controledevotos.exception.AssociadoCadastradoException;
import com.assembleia.controledevotos.exception.PautaNotFoundException;
import com.assembleia.controledevotos.service.AssociadoService;
import com.assembleia.controledevotos.service.PautaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/associado")
public class AssociadoController {

    @Autowired
    private AssociadoService service;
    @Autowired
    private PautaService pautaService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Associado> cadastrar(@Valid @RequestParam String cpf) throws AssociadoCadastradoException {
        Associado associado = service.findByCpf(cpf);

        if (associado == null) {
            Associado novoAssociado = new Associado(null, cpf, null);
            return ResponseEntity.ok(service.cadastrar(novoAssociado));
        } else {
            throw new AssociadoCadastradoException();
        }
    }

    @RequestMapping(path = "/votar", method = RequestMethod.POST)
    public ResponseEntity<Associado> votar(@Valid @RequestParam String cpf, @Valid @RequestParam String voto, @RequestParam String nomePauta) throws PautaNotFoundException {

        Pauta pauta = pautaService.findByNome(nomePauta.toUpperCase());

        if (pauta != null) {
            //TODO: Associado não pode votar 2x e deve poder votar pela API
            Associado associadoCadastrado = service.findByCpf(cpf);
            associadoCadastrado.setVoto(Voto.valueOf(voto.toUpperCase()));
            service.votar(associadoCadastrado, pauta);

            return ResponseEntity.ok(associadoCadastrado);
        } else {
            throw new PautaNotFoundException();
        }
    }
}
