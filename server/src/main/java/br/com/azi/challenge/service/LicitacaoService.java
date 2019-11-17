package br.com.azi.challenge.service;

import br.com.azi.challenge.model.Licitacao;
import br.com.azi.challenge.model.Proposta;
import br.com.azi.challenge.model.enums.TipoClassificacaoEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class LicitacaoService {

    @Autowired
    PropostaService propostaService;

    LicitacaoService() {
        List<Proposta> propostas = new ArrayList<>();

        Licitacao licitacao = new Licitacao(1, "Compra de canetas", TipoClassificacaoEnum.NOTA_PRECO);

        Proposta proposta = new Proposta();
        proposta.setId(1);
        proposta.setFornecedor("BIC");
        proposta.setLicitacao(licitacao.getId());
        proposta.setNota(new BigDecimal(8.0));
        proposta.setPreco(new BigDecimal(1000.0));

        proposta.setId(2);
        proposta.setFornecedor("Cristal");
        proposta.setLicitacao(licitacao.getId());
        proposta.setNota(new BigDecimal(9.0));
        proposta.setPreco(new BigDecimal(1100.0));

        propostas.add(proposta);
        licitacoes.add(licitacao);
    }

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

    public Licitacao preencherPropostas(Integer id) {
        Licitacao resultado = licitacoes.stream().filter(licitacaoFilter ->  licitacaoFilter.getId().intValue() == id).findAny().orElse(null);
        if (resultado != null) {
            List<Proposta> propostas = propostaService.buscarPropostasPorLicitacao(resultado.getId());
            List<Proposta> propostasClassificadas = classificarPropostas(propostas, resultado.getTipoClassificacao());
            resultado.setPropostas(propostasClassificadas);
            return resultado;
        }
        return null;
    }

    public List<Proposta> classificarPropostas(List<Proposta> propostas, TipoClassificacaoEnum tipoClassificacao) {

        if (tipoClassificacao.equals(TipoClassificacaoEnum.NOTA_PRECO)) {
            Collections.sort(propostas, Comparator.comparing(Proposta::getNota).thenComparing(Proposta::getPreco).thenComparing(Proposta::getDataCadastro).reversed());
        } else {
            Collections.sort(propostas, Comparator.comparing(Proposta::getPreco).thenComparing(Proposta::getDataCadastro));
        }

        for (int index = 0; index < propostas.size(); index++) {
            propostas.get(index).setClassificacao(index + 1);
        }

        return propostas;
    }

}