package br.com.azi.challenge.controller;

import br.com.azi.challenge.model.Licitacao;
import br.com.azi.challenge.service.LicitacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/licitacoes")
public class LicitacaoController {

    @Autowired
    LicitacaoService licitacaoService;

    @PostMapping()
    public Licitacao incluir(@RequestBody Licitacao licitacao) {
        return licitacaoService.incluir(licitacao);
    }

    @PutMapping()
    public Licitacao atualizar(@RequestBody Licitacao licitacao) {
        return licitacaoService.atualizar(licitacao);
    }

    @PutMapping()
    public void excluir(@RequestBody Licitacao licitacao) {
        licitacaoService.excluir(licitacao);
    }




}
