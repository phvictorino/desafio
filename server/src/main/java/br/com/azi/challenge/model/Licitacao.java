package br.com.azi.challenge.model;

import br.com.azi.challenge.model.enums.TipoClassificacaoEnum;

public class Licitacao {

    public String id;
    public String descricao;
    public TipoClassificacaoEnum tipoClassificacao;

    public String getId() {
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
}
