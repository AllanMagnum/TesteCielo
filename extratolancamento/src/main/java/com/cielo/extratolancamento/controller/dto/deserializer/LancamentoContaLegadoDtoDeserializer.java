package com.cielo.extratolancamento.controller.dto.deserializer;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cielo.extratolancamento.controller.dto.ControleLancamentoDto;
import com.cielo.extratolancamento.controller.dto.LancamentoContaLegadoDto;
import com.cielo.extratolancamento.controller.dto.TotalControleLancamentoDto;
import com.fasterxml.jackson.databind.JsonNode;

@Component
public class LancamentoContaLegadoDtoDeserializer extends AbstractDeserializer<LancamentoContaLegadoDto> {
	
	private TotalControleLancamentoDtoDeserializer totalControleLancamentoDtoDeserializer;
	private ControleLancamentoDtoDeserializer controleLancamentoDtoDeserializer;
	
	@Autowired
	public LancamentoContaLegadoDtoDeserializer(TotalControleLancamentoDtoDeserializer totalControleLancamentoDtoDeserializer, ControleLancamentoDtoDeserializer controleLancamentoDtoDeserializer) {
		this.totalControleLancamentoDtoDeserializer = totalControleLancamentoDtoDeserializer;
		this.controleLancamentoDtoDeserializer = controleLancamentoDtoDeserializer;
	}

	@Override
	public LancamentoContaLegadoDto deserialize(JsonNode jsonNode) {
		
		TotalControleLancamentoDto totalControleLancamentoDto = this.deserializeTotalControleLancamentoDto(jsonNode);
		List<ControleLancamentoDto> listaControleLancamento = this.deserializeControleLancamentoDto(jsonNode);
		Long indice = getLongField(jsonNode, Field.INDICE);
		Long tamanhoPagina = getLongField(jsonNode, Field.TAMANHO_PAGINA);
		Long totalElements = getLongField(jsonNode, Field.TOTAL_ELEMENTS);
		
		return new LancamentoContaLegadoDto(totalControleLancamentoDto, listaControleLancamento, indice, tamanhoPagina, totalElements);
	}
	
	 private TotalControleLancamentoDto deserializeTotalControleLancamentoDto(JsonNode jsonNode) {
		 JsonNode totalControleLancamentoDtoJsonNode = getJsonNode(jsonNode, Field.TOTAL_CONTROLE_LANCAMENTO);
	     return totalControleLancamentoDtoDeserializer.deserialize(totalControleLancamentoDtoJsonNode);
	 }
	 
	private List<ControleLancamentoDto> deserializeControleLancamentoDto(JsonNode jsonNode) {
		List<ControleLancamentoDto> controleLancamentoDtos = new LinkedList<>();
		JsonNode arrayJsonNode = getJsonNode(jsonNode, Field.LISTA_CONTROLE_LANCAMENTO);

		arrayJsonNode.forEach(node -> {
			final ControleLancamentoDto controleLancamentoDto = controleLancamentoDtoDeserializer.deserialize(node);
			controleLancamentoDtos.add(controleLancamentoDto);
		});

		return Collections.unmodifiableList(controleLancamentoDtos);
	}
}
