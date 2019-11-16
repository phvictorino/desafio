package br.com.azi.challenge.controller;

import br.com.azi.challenge.model.Proposta;
import br.com.azi.challenge.model.enums.TipoClassificacaoEnum;
import br.com.azi.challenge.service.PropostaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/propostas")
@CrossOrigin(origins = "http://localhost:8080")
public class PropostaController {

    @Autowired
    PropostaService propostaService;

    @GetMapping()
    public List listarTodas() {
        return propostaService.listarTodas();
    }

    @PostMapping()
    public Proposta salvar(@RequestBody Proposta proposta) {
        return propostaService.incluir(proposta);
    }

    @PutMapping()
    public Proposta atualizar(@RequestBody Proposta proposta) {
        return propostaService.atualizar(proposta);
    }

    @DeleteMapping()
    public void excluir(@RequestBody() Proposta proposta) {
        propostaService.excluir(proposta);
    }

    @GetMapping("/classificar")
    public List<Proposta> classificar(@RequestParam TipoClassificacaoEnum tipoClassificacao) {
        return propostaService.classificar(tipoClassificacao);
    }


}
