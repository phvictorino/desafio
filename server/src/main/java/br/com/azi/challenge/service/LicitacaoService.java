package br.com.azi.challenge.service;

import br.com.azi.challenge.model.Licitacao;
import br.com.azi.challenge.model.Proposta;
import br.com.azi.challenge.model.enums.TipoClassificacaoEnum;
import br.com.azi.challenge.utils.GeradorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

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
        Licitacao licitacao = new Licitacao(GeradorUtils.getIdLicitacao(), "Compra de canetas", TipoClassificacaoEnum.NOTA_PRECO);
        licitacoes.add(licitacao);
    }

    private List<Licitacao> licitacoes = new ArrayList<>();

    public List<Licitacao> listarTodas() {
        return licitacoes;
    }

    public Licitacao incluir(Licitacao licitacao) {
        licitacao.setId(GeradorUtils.getIdLicitacao());
        licitacoes.add(licitacao);
        return licitacao;
    }

    public void excluir(Integer idLicitacao) {
        Licitacao resultado = licitacoes.stream().filter(licitacaoFilter ->  licitacaoFilter.getId().intValue() == idLicitacao.intValue()).findAny().orElse(null);
        if (resultado != null) {
            licitacoes.remove(resultado);
        }
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
        Licitacao resultado = licitacoes.stream().filter(licitacaoFilter ->  licitacaoFilter.getId().intValue() == id.intValue()).findFirst().orElse(null);
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