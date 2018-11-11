package com.cielo.extratolancamento.controller.dto;

public class LancamentoContaCorrenteClienteDto {
	private Long numeroRemessaBanco;
	private String nomeSituacaoRemessa;
	private DomicilioBancarioDto dadosDomicilioBancario;
	private String nomeTipoOperacao;
	
	public LancamentoContaCorrenteClienteDto(Long numeroRemessaBanco, String nomeSituacaoRemessa,
			DomicilioBancarioDto dadosDomicilioBancario, String nomeTipoOperacao) {
		this.numeroRemessaBanco = numeroRemessaBanco;
		this.nomeSituacaoRemessa = nomeSituacaoRemessa;
		this.dadosDomicilioBancario = dadosDomicilioBancario;
		this.nomeTipoOperacao = nomeTipoOperacao;
	}
	
	public Long getNumeroRemessaBanco() {
		return numeroRemessaBanco;
	}
	public void setNumeroRemessaBanco(Long numeroRemessaBanco) {
		this.numeroRemessaBanco = numeroRemessaBanco;
	}
	public String getNomeSituacaoRemessa() {
		return nomeSituacaoRemessa;
	}
	public void setNomeSituacaoRemessa(String nomeSituacaoRemessa) {
		this.nomeSituacaoRemessa = nomeSituacaoRemessa;
	}
	public DomicilioBancarioDto getDadosDomicilioBancario() {
		return dadosDomicilioBancario;
	}
	public void setDadosDomicilioBancario(DomicilioBancarioDto dadosDomicilioBancario) {
		this.dadosDomicilioBancario = dadosDomicilioBancario;
	}
	public String getNomeTipoOperacao() {
		return nomeTipoOperacao;
	}
	public void setNomeTipoOperacao(String nomeTipoOperacao) {
		this.nomeTipoOperacao = nomeTipoOperacao;
	}	
}
