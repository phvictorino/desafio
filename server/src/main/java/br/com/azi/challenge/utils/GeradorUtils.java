package br.com.azi.challenge.utils;

public class GeradorUtils {
    static Integer idLicitacao = 0;
    static Integer idProposta = 0;

    public static Integer getIdLicitacao() {
        idLicitacao += 1;
        return idLicitacao;
    }
    public static Integer getIdProposta() {
        idProposta += 1;
        return idProposta;
    }

}
