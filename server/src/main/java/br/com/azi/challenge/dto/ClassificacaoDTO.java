package br.com.azi.challenge.dto;

import br.com.azi.challenge.model.Proposta;
import br.com.azi.challenge.model.enums.TipoClassificacaoEnum;

import java.util.List;

public class ClassificacaoDTO {
    public TipoClassificacaoEnum tipoClassificacao;
    public List<Proposta> propostas;

    public TipoClassificacaoEnum getTipoClassificacao() {
        return tipoClassificacao;
    }

    public void setTipoClassificacao(TipoClassificacaoEnum tipoClassificacao) {
        this.tipoClassificacao = tipoClassificacao;
    }

    public List<Proposta> getPropostas() {
        return propostas;
    }

    public void setPropostas(List<Proposta> propostas) {
        this.propostas = propostas;
    }
}
