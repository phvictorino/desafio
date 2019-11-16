package br.com.azi.challenge.service;

import br.com.azi.challenge.model.Licitacao;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component()
public class LicitacaoService {

    private List<Licitacao> licitacoes = new ArrayList<>();

    public Licitacao incluir(Licitacao licitacao) {
        licitacoes.add(licitacao);
        return licitacao;
    }

    public void excluir(Licitacao licitacao) {
        licitacoes.remove(licitacao);
    }

    public Licitacao atualizar(Licitacao licitacao) {
        int index = licitacoes.indexOf(licitacao);
        licitacoes.set(index, licitacao);
        return licitacao;
    }

}