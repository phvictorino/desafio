package br.com.azi.challenge.service;

import br.com.azi.challenge.model.Licitacao;
import br.com.azi.challenge.model.Proposta;
import br.com.azi.challenge.model.enums.TipoClassificacaoEnum;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class PropostaService {

    public PropostaService() {
        Proposta proposta1 = new Proposta();
        proposta1.setId(1);
        proposta1.setFornecedor("BIC");
        proposta1.setLicitacao(1);
        proposta1.setNota(new BigDecimal(8.0));
        proposta1.setPreco(new BigDecimal(1000.0));
        propostas.add(proposta1);

        Proposta proposta2 = new Proposta();
        proposta2.setId(2);
        proposta2.setFornecedor("Cristal");
        proposta2.setLicitacao(1);
        proposta2.setNota(new BigDecimal(9.0));
        proposta2.setPreco(new BigDecimal(1100.0));
        propostas.add(proposta2);
    }

    private List<Proposta> propostas = new ArrayList<>();

    public List<Proposta> listarTodas() {
        return propostas;
    }

    public Proposta incluir(Proposta proposta) {
        propostas.add(proposta);
        return proposta;
    }

    public void excluir(Proposta proposta) {
        propostas.remove(proposta);
    }

    public Proposta atualizar(Proposta proposta) {
        Proposta resultado = propostas.stream().filter(propostaFilter ->  propostaFilter.getId().equals(proposta.getId())).findAny().orElse(null);
        if (resultado != null) {
            int index = propostas.indexOf(resultado);
            propostas.set(index, proposta);
            return proposta;
        }
        return null;
    }

    public List<Proposta> buscarPropostasPorLicitacao (Integer idLicitacao) {
        return propostas.stream().filter(p -> p.getLicitacao().intValue() == idLicitacao.intValue()).collect(Collectors.toList());
    }
}
