package br.com.azi.challenge.controller;

import br.com.azi.challenge.model.Licitacao;
import br.com.azi.challenge.service.LicitacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/licitacoes")
@CrossOrigin(origins = "http://localhost:8080")
public class LicitacaoController {

    @Autowired
    LicitacaoService licitacaoService;

    @GetMapping()
    public List<Licitacao> listarTodas() {
        return licitacaoService.listarTodas();
    }

    @PostMapping()
    public Licitacao incluir(@RequestBody Licitacao licitacao) {
        return licitacaoService.incluir(licitacao);
    }

    @PutMapping()
    public Licitacao atualizar(@RequestBody Licitacao licitacao) {
        return licitacaoService.atualizar(licitacao);
    }

    @DeleteMapping()
    public void excluir(@RequestBody Licitacao licitacao) {
        licitacaoService.excluir(licitacao);
    }




}
