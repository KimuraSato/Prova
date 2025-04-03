package com.prova.models;

import com.prova.enums.Classificacao;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "movimentos")
public class Movimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date data_movimento;

    private Long valor;

    @Enumerated(EnumType.STRING)
    private Classificacao classificacao;

    private String observacao;

    public Movimento() {}

    public Movimento(Long id, Date data_movimento, Long valor, List<Classificacao> classificacoes, String observacao) {
        this.id = id;
        this.data_movimento = data_movimento;
        this.valor = valor;
        this.classificacao = classificacao;
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
        return classificacao;
    }

    public void setClassificacao(Classificacao classificacao) {
        this.classificacao = classificacao;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}
