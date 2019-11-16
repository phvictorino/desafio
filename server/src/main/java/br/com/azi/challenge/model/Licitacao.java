package br.com.azi.challenge.model;

import br.com.azi.challenge.model.enums.TipoClassificacaoEnum;

import java.util.List;
import java.util.Objects;

public class Licitacao {

    public Licitacao(Integer id, String descricao, TipoClassificacaoEnum tipoClassificacao) {
        this.id = id;
        this.descricao = descricao;
        this.tipoClassificacao = tipoClassificacao;
    }

    public Licitacao() {
    }

    public Integer id;
    public String descricao;
    public TipoClassificacaoEnum tipoClassificacao;
    public List<Proposta> propostas;

    public Integer getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Licitacao licitacao = (Licitacao) o;
        return getId().equals(licitacao.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
