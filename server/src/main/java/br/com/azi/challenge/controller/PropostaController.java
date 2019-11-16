package br.com.azi.challenge.controller;

import br.com.azi.challenge.dto.ClassificacaoDTO;
import br.com.azi.challenge.model.Proposta;
import br.com.azi.challenge.model.enums.TipoClassificacaoEnum;
import br.com.azi.challenge.repository.PropostaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/propostas")
@CrossOrigin(origins = "http://localhost:8080")
public class PropostaController {

    @Autowired
    PropostaRepository propostaRepository;

    @GetMapping()
    public List listarTodas() {
        return propostaRepository.findAll();
    }

    @PostMapping()
    public Proposta salvar(@RequestBody Proposta proposta) {
        return propostaRepository.save(proposta);
    }

    @PutMapping()
    public Proposta atualizar(@RequestBody Proposta proposta) {
        return propostaRepository.save(proposta);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable() String id) {
        propostaRepository.deleteById(id);
    }

    @PostMapping("/classificar")
    public List<Proposta> classificar(@RequestBody ClassificacaoDTO dto) {

        if (dto.tipoClassificacao.equals(TipoClassificacaoEnum.NOTA_PRECO)) {
            Collections.sort(dto.propostas, Comparator.comparingDouble(Proposta::getNota).thenComparing(Proposta::getPreco).thenComparing(Proposta::getDataCadastro).reversed());
        } else {
            Collections.sort(dto.propostas, Comparator.comparingDouble(Proposta::getPreco).thenComparing(Proposta::getDataCadastro));
        }

        return dto.propostas;
    }


}
