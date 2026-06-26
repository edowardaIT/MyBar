package com.ficticia.mybar.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
@Entity
@Table(name = "item_cardapio")
public class ItemCardapio {

    @Id
    @Column(name = "codigo")
    private Integer codigo;

    @Column(name = "descricao", nullable = false, length = 255)
    private String descricao;

    @Column(name = "valor", nullable = false)
    private BigDecimal valor;

    @Column(name = "gorjeta", nullable = false)
    private BigDecimal gorjeta;

    @Column(name = "ativo", nullable = false)
    private Boolean ativo = true;

    @ManyToOne
    @JoinColumn(name = "tipo_item_id", nullable = false)
    private TipoItem tipoItem;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public BigDecimal getGorjeta() {
		return gorjeta;
	}

	public void setGorjeta(BigDecimal gorjeta) {
		this.gorjeta = gorjeta;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public TipoItem getTipoItem() {
		return tipoItem;
	}

	public void setTipoItem(TipoItem tipoItem) {
		this.tipoItem = tipoItem;
	}
}