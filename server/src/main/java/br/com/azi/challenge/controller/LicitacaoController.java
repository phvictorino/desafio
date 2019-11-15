package br.com.azi.challenge.controller;

import br.com.azi.challenge.model.Proposta;
import br.com.azi.challenge.repository.PropostaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proposta")
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

    public Proposta classificar()


}
