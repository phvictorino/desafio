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

    @GetMapping("/{id}/propostas")
    public Licitacao listarPropostasLicitacao(@PathVariable Integer id) { return licitacaoService.preencherPropostas(id); }

    @PostMapping()
    public Licitacao incluir(@RequestBody Licitacao licitacao) {
        return licitacaoService.incluir(licitacao);
    }

    @PutMapping()
    public Licitacao atualizar(@RequestBody Licitacao licitacao) {
        return licitacaoService.atualizar(licitacao);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Integer id) {
        licitacaoService.excluir(id);
    }




}
