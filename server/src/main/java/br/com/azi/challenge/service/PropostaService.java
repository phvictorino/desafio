package br.com.azi.challenge.service;

import br.com.azi.challenge.model.Licitacao;
import br.com.azi.challenge.model.Proposta;
import br.com.azi.challenge.model.enums.TipoClassificacaoEnum;
import br.com.azi.challenge.utils.GeradorUtils;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class PropostaService {

    public PropostaService() {
        Proposta proposta1 = new Proposta();
        proposta1.setId(GeradorUtils.getIdProposta());
        proposta1.setFornecedor("BIC");
        proposta1.setLicitacao(1);
        proposta1.setNota(new BigDecimal(8.0));
        proposta1.setPreco(new BigDecimal(1000.0));
        proposta1.setDataCadastro(LocalDate.of(2019, 10, 11));
        propostas.add(proposta1);

        Proposta proposta2 = new Proposta();
        proposta2.setId(GeradorUtils.getIdProposta());
        proposta2.setFornecedor("Cristal");
        proposta2.setLicitacao(1);
        proposta2.setNota(new BigDecimal(9.0));
        proposta2.setPreco(new BigDecimal(1100.0));
        proposta2.setDataCadastro(LocalDate.of(2019, 10, 10));
        propostas.add(proposta2);
    }

    private List<Proposta> propostas = new ArrayList<>();

    public List<Proposta> listarTodas() {
        return propostas;
    }

    public Proposta incluir(Proposta proposta) {
        proposta.setId(GeradorUtils.getIdProposta());
        if (proposta.getDataCadastro() == null) {
            proposta.setDataCadastro(LocalDate.now());
        }
        propostas.add(proposta);
        return proposta;
    }

    public void excluir(Integer idProposta) {
        Proposta resultado = propostas.stream().filter(propostaFilter ->  propostaFilter.getId().intValue() == idProposta.intValue()).findAny().orElse(null);
        if (resultado != null) {
            propostas.remove(resultado);
        }
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
