package com.prova.dtos;

import com.prova.enums.Classificacao;

import java.util.Date;

public class MovimentoDTO {

    private Long id;
    private Date data_movimento;
    private Long valor;
    private Classificacao classificacoes;
    private String observacao;

    public MovimentoDTO() {
    }

    public MovimentoDTO(Long id, Date data_movimento, Long valor, Classificacao classificacoes, String observacao) {
        this.id = id;
        this.data_movimento = data_movimento;
        this.valor = valor;
        this.classificacoes = classificacoes;
        this.observacao = observacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getData_movimento() {
        return data_movimento;
    }

    public void setData_movimento(Date data_movimento) {
        this.data_movimento = data_movimento;
    }

    public Long getValor() {
        return valor;
    }

    public void setValor(Long valor) {
        this.valor = valor;
    }

    public Classificacao getClassificacao() {
        return classificacoes;
    }

    public void setClassificacao(Classificacao classificacoes) {
        this.classificacoes = classificacoes;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}