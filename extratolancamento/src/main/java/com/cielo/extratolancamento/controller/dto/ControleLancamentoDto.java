package com.cielo.extratolancamento.controller.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ControleLancamentoDto {
	private LancamentoContaCorrenteClienteDto lancamentoContaCorrenteClienteDto;
	private LocalDateTime dataEfetivaLancamento;
	private LocalDateTime dataLancamentoContaCorrenteCliente;
	private Long numeroEvento;
	private String descricaoGrupoPagamento;
	private String codigoIdentificadorUnico;
	private String nomeBanco;
	private String quantidadeLancamentoRemessa;
	private Long numeroRaizCNPJ;
	private Long numeroSufixoCNPJ;
	private BigDecimal valorLancamentoRemessa;
		
	public ControleLancamentoDto(LancamentoContaCorrenteClienteDto lancamentoContaCorrenteClienteDto,
			LocalDateTime dataEfetivaLancamento, LocalDateTime dataLancamentoContaCorrenteCliente, Long numeroEvento,
			String descricaoGrupoPagamento, String codigoIdentificadorUnico, String nomeBanco,
			String quantidadeLancamentoRemessa, Long numeroRaizCNPJ, Long numeroSufixoCNPJ,
			BigDecimal valorLancamentoRemessa) {
		this.lancamentoContaCorrenteClienteDto = lancamentoContaCorrenteClienteDto;
		this.dataEfetivaLancamento = dataEfetivaLancamento;
		this.dataLancamentoContaCorrenteCliente = dataLancamentoContaCorrenteCliente;
		this.numeroEvento = numeroEvento;
		this.descricaoGrupoPagamento = descricaoGrupoPagamento;
		this.codigoIdentificadorUnico = codigoIdentificadorUnico;
		this.nomeBanco = nomeBanco;
		this.quantidadeLancamentoRemessa = quantidadeLancamentoRemessa;
		this.numeroRaizCNPJ = numeroRaizCNPJ;
		this.numeroSufixoCNPJ = numeroSufixoCNPJ;
		this.valorLancamentoRemessa = valorLancamentoRemessa;
	}
	
	public LancamentoContaCorrenteClienteDto getLancamentoContaCorrenteClienteDto() {
		return lancamentoContaCorrenteClienteDto;
	}
	public void setLancamentoContaCorrenteClienteDto(LancamentoContaCorrenteClienteDto lancamentoContaCorrenteClienteDto) {
		this.lancamentoContaCorrenteClienteDto = lancamentoContaCorrenteClienteDto;
	}
	public LocalDateTime getDataEfetivaLancamento() {
		return dataEfetivaLancamento;
	}
	public void setDataEfetivaLancamento(LocalDateTime dataEfetivaLancamento) {
		this.dataEfetivaLancamento = dataEfetivaLancamento;
	}
	public LocalDateTime getDataLancamentoContaCorrenteCliente() {
		return dataLancamentoContaCorrenteCliente;
	}

	public void setDataLancamentoContaCorrenteCliente(LocalDateTime dataLancamentoContaCorrenteCliente) {
		this.dataLancamentoContaCorrenteCliente = dataLancamentoContaCorrenteCliente;
	}

	public Long getNumeroEvento() {
		return numeroEvento;
	}
	public void setNumeroEvento(Long numeroEvento) {
		this.numeroEvento = numeroEvento;
	}
	public String getDescricaoGrupoPagamento() {
		return descricaoGrupoPagamento;
	}
	public void setDescricaoGrupoPagamento(String descricaoGrupoPagamento) {
		this.descricaoGrupoPagamento = descricaoGrupoPagamento;
	}
	public String getCodigoIdentificadorUnico() {
		return codigoIdentificadorUnico;
	}
	public void setCodigoIdentificadorUnico(String codigoIdentificadorUnico) {
		this.codigoIdentificadorUnico = codigoIdentificadorUnico;
	}
	public String getNomeBanco() {
		return nomeBanco;
	}
	public void setNomeBanco(String nomeBanco) {
		this.nomeBanco = nomeBanco;
	}
	public String getQuantidadeLancamentoRemessa() {
		return quantidadeLancamentoRemessa;
	}
	public void setQuantidadeLancamentoRemessa(String quantidadeLancamentoRemessa) {
		this.quantidadeLancamentoRemessa = quantidadeLancamentoRemessa;
	}
	public Long getNumeroRaizCNPJ() {
		return numeroRaizCNPJ;
	}
	public void setNumeroRaizCNPJ(Long numeroRaizCNPJ) {
		this.numeroRaizCNPJ = numeroRaizCNPJ;
	}
	public Long getNumeroSufixoCNPJ() {
		return numeroSufixoCNPJ;
	}
	public void setNumeroSufixoCNPJ(Long numeroSufixoCNPJ) {
		this.numeroSufixoCNPJ = numeroSufixoCNPJ;
	}
	public BigDecimal getValorLancamentoRemessa() {
		return valorLancamentoRemessa;
	}
	public void setValorLancamentoRemessa(BigDecimal valorLancamentoRemessa) {
		this.valorLancamentoRemessa = valorLancamentoRemessa;
	}	
}
