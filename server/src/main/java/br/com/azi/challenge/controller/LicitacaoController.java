package br.com.azi.challenge.controller;

import br.com.azi.challenge.model.Licitacao;
import br.com.azi.challenge.repository.LicitacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/licitacao")
public class LicitacaoController {

    @Autowired
    LicitacaoRepository licitacaoRepository;

    @GetMapping()
    public List test() {
        return licitacaoRepository.findAll();
    }

    @PostMapping()
    public Licitacao save(@RequestBody Licitacao licitacao) {
        return licitacaoRepository.save(licitacao);
    }

    @PutMapping()
    public Licitacao update(@RequestBody Licitacao licitacao) {
        return licitacaoRepository.save(licitacao);
    }




}
