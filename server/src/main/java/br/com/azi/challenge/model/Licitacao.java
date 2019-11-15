package br.com.azi.challenge.model;

import br.com.azi.challenge.model.enums.TipoClassificacaoEnum;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Licitacao {

    @Id
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
