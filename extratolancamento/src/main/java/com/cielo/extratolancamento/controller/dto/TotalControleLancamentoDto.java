package com.cielo.extratolancamento.controller.dto;

import java.math.BigDecimal;

public class TotalControleLancamentoDto {
	private Long quantidadeLancamentos;
	private Long quantidadeRemessas;
	private BigDecimal valorLancamentos;
	
	public TotalControleLancamentoDto(Long quantidadeLancamentos, Long quantidadeRemessas, BigDecimal valorLancamentos) {
		this.quantidadeLancamentos = quantidadeLancamentos;
		this.quantidadeRemessas = quantidadeRemessas;
		this.valorLancamentos = valorLancamentos;
	}
	
	public Long getQuantidadeLancamentos() {
		return quantidadeLancamentos;
	}
	public void setQuantidadeLancamentos(Long quantidadeLancamentos) {
		this.quantidadeLancamentos = quantidadeLancamentos;
	}
	public Long getQuantidadeRemessas() {
		return quantidadeRemessas;
	}
	public void setQuantidadeRemessas(Long quantidadeRemessas) {
		this.quantidadeRemessas = quantidadeRemessas;
	}
	public BigDecimal getValorLancamentos() {
		return valorLancamentos;
	}
	public void setValorLancamentos(BigDecimal valorLancamentos) {
		this.valorLancamentos = valorLancamentos;
	}	
	
}
