package com.cielo.extratolancamento.controller.dto.output;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ExtratoLancamentoOutputDto {
	private LocalDateTime dataLancamento; 
	private String Descricao;
	private Long numero;
	private String situcao;
	private LocalDateTime dataConfirmacao;
	private String dadosBancarios;
	private BigDecimal valorFinal;
	
	public ExtratoLancamentoOutputDto() {
		super();
	}

	public ExtratoLancamentoOutputDto(LocalDateTime dataLancamento, String descricao, Long numero, String situcao,
			LocalDateTime dataConfirmacao, String dadosBancarios, BigDecimal valorFinal) {
		this.dataLancamento = dataLancamento;
		Descricao = descricao;
		this.numero = numero;
		this.situcao = situcao;
		this.dataConfirmacao = dataConfirmacao;
		this.dadosBancarios = dadosBancarios;
		this.valorFinal = valorFinal;
	}
	
	public LocalDateTime getDataLancamento() {
		return dataLancamento;
	}
	public void setDataLancamento(LocalDateTime dataLancamento) {
		this.dataLancamento = dataLancamento;
	}
	public String getDescricao() {
		return Descricao;
	}
	public void setDescricao(String descricao) {
		Descricao = descricao;
	}
	public Long getNumero() {
		return numero;
	}
	public void setNumero(Long numero) {
		this.numero = numero;
	}
	public String getSitucao() {
		return situcao;
	}
	public void setSitucao(String situcao) {
		this.situcao = situcao;
	}
	public LocalDateTime getDataConfirmacao() {
		return dataConfirmacao;
	}
	public void setDataConfirmacao(LocalDateTime dataConfirmacao) {
		this.dataConfirmacao = dataConfirmacao;
	}
	public String getDadosBancarios() {
		return dadosBancarios;
	}
	public void setDadosBancarios(String dadosBancarios) {
		this.dadosBancarios = dadosBancarios;
	}
	public BigDecimal getValorFinal() {
		return valorFinal;
	}
	public void setValorFinal(BigDecimal valorFinal) {
		this.valorFinal = valorFinal;
	}
	
	
}
