package br.com.azi.challenge.model;

import org.springframework.data.annotation.Id;

import java.math.BigDecimal;

public class Proposta {

    @Id
    public String id;

    public String fornecedor;
    public BigDecimal nota;
    public BigDecimal preco;
    public String dataCadastro;
    public Integer classificacao;
    public Licitacao licitacao;
}
