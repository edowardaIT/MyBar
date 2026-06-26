package com.ficticia.mybar.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "tipo_item")
public class TipoItem {

    @Id
    @Column(name = "codigo")
    private Integer codigo;

    @Column(name = "descricao", nullable = false, length = 255)
    private String descricao;

    @Column(name = "gorjeta", nullable = false)
    private BigDecimal gorjeta;

    @Column(name = "vai_cozinha", nullable = false)
    private Boolean vaiCozinha;

    @Column(name = "ativo", nullable = false)
    private Boolean ativo = true;

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

	public BigDecimal getGorjeta() {
		return gorjeta;
	}

	public void setGorjeta(BigDecimal gorjeta) {
		this.gorjeta = gorjeta;
	}

	public Boolean getVaiCozinha() {
		return vaiCozinha;
	}

	public void setVaiCozinha(Boolean vaiCozinha) {
		this.vaiCozinha = vaiCozinha;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
}