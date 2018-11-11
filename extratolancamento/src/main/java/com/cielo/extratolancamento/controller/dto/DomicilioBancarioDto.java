package com.cielo.extratolancamento.controller.dto;

public class DomicilioBancarioDto {
	private String codigoBanco;
	private String numeroAgencia;
	private String numeroContaCorrente;
	
	public DomicilioBancarioDto(String codigoBanco, String numeroAgencia, String numeroContaCorrente) {
		this.codigoBanco = codigoBanco;
		this.numeroAgencia = numeroAgencia;
		this.numeroContaCorrente = numeroContaCorrente;
	}
	
	public String getCodigoBanco() {
		return codigoBanco;
	}
	public void setCodigoBanco(String codigoBanco) {
		this.codigoBanco = codigoBanco;
	}
	public String getNumeroAgencia() {
		return numeroAgencia;
	}
	public void setNumeroAgencia(String numeroAgencia) {
		this.numeroAgencia = numeroAgencia;
	}
	public String getNumeroContaCorrente() {
		return numeroContaCorrente;
	}
	public void setNumeroContaCorrente(String numeroContaCorrente) {
		this.numeroContaCorrente = numeroContaCorrente;
	}
	
	
}
