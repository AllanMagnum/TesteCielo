package com.cielo.extratolancamento.controller.dto;

import java.util.ArrayList;
import java.util.List;

public class LancamentoContaLegadoDto {
	private TotalControleLancamentoDto totalControleLancamentoDto;
	private List<ControleLancamentoDto> listaControleLancamento = new ArrayList<>();
	private Long indice;
	private Long tamanhoPagina;
	private Long totalElements;
	
	public LancamentoContaLegadoDto(TotalControleLancamentoDto totalControleLancamentoDto,
			List<ControleLancamentoDto> listaControleLancamento, Long indice, Long tamanhoPagina, Long totalElements) {
		this.totalControleLancamentoDto = totalControleLancamentoDto;
		this.listaControleLancamento = listaControleLancamento;
		this.indice = indice;
		this.tamanhoPagina = tamanhoPagina;
		this.totalElements = totalElements;
	}
	public TotalControleLancamentoDto getTotalControleLancamento() {
		return totalControleLancamentoDto;
	}
	public void setTotalControleLancamento(TotalControleLancamentoDto totalControleLancamentoDto) {
		this.totalControleLancamentoDto = totalControleLancamentoDto;
	}
	public List<ControleLancamentoDto> getListaControleLancamento() {
		return listaControleLancamento;
	}
	public void setListaControleLancamento(List<ControleLancamentoDto> listaControleLancamento) {
		this.listaControleLancamento = listaControleLancamento;
	}
	public Long getIndice() {
		return indice;
	}
	public void setIndice(Long indice) {
		this.indice = indice;
	}
	public Long getTamanhoPagina() {
		return tamanhoPagina;
	}
	public void setTamanhoPagina(Long tamanhoPagina) {
		this.tamanhoPagina = tamanhoPagina;
	}
	public Long getTotalElements() {
		return totalElements;
	}
	public void setTotalElements(Long totalElements) {
		this.totalElements = totalElements;
	}
	
	
	
}
