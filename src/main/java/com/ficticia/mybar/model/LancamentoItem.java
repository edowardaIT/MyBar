package com.ficticia.mybar.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.math.BigDecimal;


@Entity
@Table(name = "lancamento_item")
public class LancamentoItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "conta_numero", nullable = false)
    private Conta conta;

    @ManyToOne
    @JoinColumn(name = "item_id", nullable = false)
    private ItemCardapio item;

    @Column(name = "quantidade", nullable = false)
    private Integer quantidade;

    @Column(name = "valor", nullable = false)
    private BigDecimal valor;

    @ManyToOne
    @JoinColumn(name = "garcom_id", nullable = false)
    private Usuario garcom;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private StatusPedido status = StatusPedido.SOLICITADO;

    @Column(name = "data_hora_solicitacao", nullable = false)
    private LocalDateTime dataHoraSolicitacao;

    @Column(name = "data_hora_recebimento")
    private LocalDateTime dataHoraRecebimento;

    @Column(name = "data_hora_entrega")
    private LocalDateTime dataHoraEntrega;

    @ManyToOne
    @JoinColumn(name = "garcom_entrega_id")
    private Usuario garcomEntrega;

    public enum StatusPedido {
        SOLICITADO, EM_PREPARACAO, ENTREGUE
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public ItemCardapio getItem() {
		return item;
	}

	public void setItem(ItemCardapio item) {
		this.item = item;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Usuario getGarcom() {
		return garcom;
	}

	public void setGarcom(Usuario garcom) {
		this.garcom = garcom;
	}

	public StatusPedido getStatus() {
		return status;
	}

	public void setStatus(StatusPedido status) {
		this.status = status;
	}

	public LocalDateTime getDataHoraSolicitacao() {
		return dataHoraSolicitacao;
	}

	public void setDataHoraSolicitacao(LocalDateTime dataHoraSolicitacao) {
		this.dataHoraSolicitacao = dataHoraSolicitacao;
	}

	public LocalDateTime getDataHoraRecebimento() {
		return dataHoraRecebimento;
	}

	public void setDataHoraRecebimento(LocalDateTime dataHoraRecebimento) {
		this.dataHoraRecebimento = dataHoraRecebimento;
	}

	public LocalDateTime getDataHoraEntrega() {
		return dataHoraEntrega;
	}

	public void setDataHoraEntrega(LocalDateTime dataHoraEntrega) {
		this.dataHoraEntrega = dataHoraEntrega;
	}

	public Usuario getGarcomEntrega() {
		return garcomEntrega;
	}

	public void setGarcomEntrega(Usuario garcomEntrega) {
		this.garcomEntrega = garcomEntrega;
	}
}