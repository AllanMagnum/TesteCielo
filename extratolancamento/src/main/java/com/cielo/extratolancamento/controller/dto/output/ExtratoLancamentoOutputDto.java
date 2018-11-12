package com.cielo.extratolancamento.controller.dto.output;

import java.time.LocalDate;

public class ExtratoLancamentoOutputDto {
	private LocalDate dataLancamento; 
	private String descricao;
	private Long numero;
	private String situacao;
	private LocalDate dataConfirmacao;
	private String dadosBancarios;
	private String valorFinal;
	
	public ExtratoLancamentoOutputDto() {
		super();
	}

	public ExtratoLancamentoOutputDto(LocalDate dataLancamento, String descricao, Long numero, String situacao,
			LocalDate dataConfirmacao, String dadosBancarios, String valorFinal) {
		this.dataLancamento = dataLancamento;
		this.descricao = descricao;
		this.numero = numero;
		this.situacao = situacao;
		this.dataConfirmacao = dataConfirmacao;
		this.dadosBancarios = dadosBancarios;
		this.valorFinal = valorFinal;
	}
	
	public LocalDate getDataLancamento() {
		return dataLancamento;
	}
	public void setDataLancamento(LocalDate dataLancamento) {
		this.dataLancamento = dataLancamento;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Long getNumero() {
		return numero;
	}
	public void setNumero(Long numero) {
		this.numero = numero;
	}
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	public LocalDate getDataConfirmacao() {
		return dataConfirmacao;
	}
	public void setDataConfirmacao(LocalDate dataConfirmacao) {
		this.dataConfirmacao = dataConfirmacao;
	}
	public String getDadosBancarios() {
		return dadosBancarios;
	}
	public void setDadosBancarios(String dadosBancarios) {
		this.dadosBancarios = dadosBancarios;
	}
	public String getValorFinal() {
		return valorFinal;
	}
	public void setValorFinal(String valorFinal) {
		this.valorFinal = valorFinal;
	}
	
	
}
