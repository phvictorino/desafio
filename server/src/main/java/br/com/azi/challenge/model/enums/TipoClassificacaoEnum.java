package br.com.azi.challenge.model.enums;

public enum TipoClassificacaoEnum {
    MENOR_PRECO(0),
    NOTA_PRECO(1);

    private int tipo;

    TipoClassificacaoEnum(int tipo) {
        this.tipo = tipo;
    }
}
