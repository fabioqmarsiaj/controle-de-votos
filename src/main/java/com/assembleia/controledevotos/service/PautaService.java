package com.assembleia.controledevotos.service;

import com.assembleia.controledevotos.DTO.PautaDTO;
import com.assembleia.controledevotos.domain.Associado;
import com.assembleia.controledevotos.domain.Pauta;
import com.assembleia.controledevotos.domain.Voto;
import com.assembleia.controledevotos.repository.PautaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PautaService {

    @Autowired
    private PautaRepository repository;

    public Pauta cadastrar(Pauta pauta) {
        return repository.save(pauta);
    }

    public Pauta findByNome(String nome) {
        return repository.findByNome(nome);
    }

    public void adicionarVotoNaPauta(Pauta pauta, Associado associado) {
        pauta.adicionarVoto(associado.getId(), associado.getVoto());
        repository.save(pauta);
    }

    public String contagemDeVotos(Pauta pauta) {

        long votosSim = pauta.getVotacao().values().stream().filter(voto -> voto.equals(Voto.SIM)).count();
        long votosNao = pauta.getVotacao().values().stream().filter(voto -> voto.equals(Voto.NAO)).count();

        return "VOTOS SIM: " + votosSim + " VOTOS NÃO: " + votosNao;
    }

    public Pauta fromDTO(PautaDTO pautaDTO) {
        return new Pauta(null, pautaDTO.getNome(), pautaDTO.getVotacao());
    }
}
