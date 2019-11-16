package br.com.azi.challenge.service;

import br.com.azi.challenge.model.Proposta;
import br.com.azi.challenge.model.enums.TipoClassificacaoEnum;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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
        int index = propostas.indexOf(proposta);
        propostas.set(index, proposta);
        return proposta;
    }

    public List<Proposta> classificar(TipoClassificacaoEnum tipoClassificacao) {

        if (tipoClassificacao.equals(TipoClassificacaoEnum.NOTA_PRECO)) {
            Collections.sort(propostas, Comparator.comparingDouble(Proposta::getNota).thenComparing(Proposta::getPreco).thenComparing(Proposta::getDataCadastro).reversed());
        } else {
            Collections.sort(propostas, Comparator.comparingDouble(Proposta::getPreco).thenComparing(Proposta::getDataCadastro));
        }

        return propostas;
    }
}
