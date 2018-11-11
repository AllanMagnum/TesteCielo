package com.cielo.extratolancamento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cielo.extratolancamento.service.ExtratoLancamentoService;

@RestController
public class ExtratoLancamentoController {
	
	private ExtratoLancamentoService extratoLancamentoService;

	@Autowired	
	public ExtratoLancamentoController(ExtratoLancamentoService extratoLancamentoService) {
		this.extratoLancamentoService = extratoLancamentoService;
	}

	@GetMapping(value="/api/extrato", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getExtratoLancamento(){
		return ResponseEntity.ok(extratoLancamentoService.recuperaInformacoesLegado());
	}
}
