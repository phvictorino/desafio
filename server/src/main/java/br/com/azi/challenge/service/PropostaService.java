package br.com.azi.challenge.service;

import br.com.azi.challenge.model.Licitacao;
import br.com.azi.challenge.model.Proposta;
import br.com.azi.challenge.model.enums.TipoClassificacaoEnum;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class PropostaService {

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

    public List<Proposta> classificar(TipoClassificacaoEnum tipoClassificacao) {

        if (tipoClassificacao.equals(TipoClassificacaoEnum.NOTA_PRECO)) {
            Collections.sort(propostas, Comparator.comparingDouble(Proposta::getNota).thenComparing(Proposta::getPreco).thenComparing(Proposta::getDataCadastro).reversed());
        } else {
            Collections.sort(propostas, Comparator.comparingDouble(Proposta::getPreco).thenComparing(Proposta::getDataCadastro));
        }

        for (int index = 0; index < propostas.size(); index++) {
            propostas.get(index).setClassificacao(index + 1);
        }

        return propostas;
    }

    public List<Proposta> buscarPropostasPorLicitacao (Integer idLicitacao) {
        return propostas.stream().filter(p -> p.getLicitacao().equals(idLicitacao)).collect(Collectors.toList());
    }
}
