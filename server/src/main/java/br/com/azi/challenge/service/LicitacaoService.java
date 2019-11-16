package br.com.azi.challenge.service;

import br.com.azi.challenge.model.Licitacao;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LicitacaoService {

    private List<Licitacao> licitacoes = new ArrayList<>();

    public List<Licitacao> listarTodas() {
        return licitacoes;
    }

    public Licitacao incluir(Licitacao licitacao) {
        licitacoes.add(licitacao);
        return licitacao;
    }

    public void excluir(Licitacao licitacao) {
        licitacoes.remove(licitacao);
    }

    public Licitacao atualizar(Licitacao licitacao) {
        Licitacao resultado = licitacoes.stream().filter(licitacaoFilter ->  licitacaoFilter.getId().equals(licitacao.getId())).findAny().orElse(null);
        if (resultado != null) {
            int index = licitacoes.indexOf(resultado);
            licitacoes.set(index, licitacao);
            return licitacao;
        }
        return null;
    }

}