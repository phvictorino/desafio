package br.com.azi.challenge.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public class Proposta {

    public Integer id;
    public String fornecedor;
    public BigDecimal nota;
    public BigDecimal preco;
    public Date dataCadastro;
    public Integer classificacao;
    public Integer licitacao;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public BigDecimal getNota() {
        return nota;
    }

    public void setNota(BigDecimal nota) {
        this.nota = nota;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Integer getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(Integer classificacao) {
        this.classificacao = classificacao;
    }

    public Integer getLicitacao() {
        return licitacao;
    }

    public void setLicitacao(Integer licitacao) {
        this.licitacao = licitacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Proposta proposta = (Proposta) o;
        return Objects.equals(getId(), proposta.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
