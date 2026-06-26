package com.ficticia.mybar.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.math.BigDecimal;

@Entity
@Table(name = "configuracao")
public class Configuracao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ingresso_masculino", nullable = false)
    private BigDecimal ingressoMasculino;

    @Column(name = "ingresso_feminino", nullable = false)
    private BigDecimal ingressoFeminino;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "modo", nullable = false)
    private ModoSistema modo;

    @Column(name = "data_liberacao")
    private LocalDateTime dataLiberacao;

    @Column(name = "data_fechamento")
    private LocalDateTime dataFechamento;

    public enum ModoSistema {
        GESTAO, ATENDIMENTO
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getIngressoMasculino() {
		return ingressoMasculino;
	}

	public void setIngressoMasculino(BigDecimal ingressoMasculino) {
		this.ingressoMasculino = ingressoMasculino;
	}

	public BigDecimal getIngressoFeminino() {
		return ingressoFeminino;
	}

	public void setIngressoFeminino(BigDecimal ingressoFeminino) {
		this.ingressoFeminino = ingressoFeminino;
	}

	public ModoSistema getModo() {
		return modo;
	}

	public void setModo(ModoSistema modo) {
		this.modo = modo;
	}

	public LocalDateTime getDataLiberacao() {
		return dataLiberacao;
	}

	public void setDataLiberacao(LocalDateTime dataLiberacao) {
		this.dataLiberacao = dataLiberacao;
	}

	public LocalDateTime getDataFechamento() {
		return dataFechamento;
	}

	public void setDataFechamento(LocalDateTime dataFechamento) {
		this.dataFechamento = dataFechamento;
	}
}