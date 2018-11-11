package com.cielo.extratolancamento.controller.dto.deserializer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cielo.extratolancamento.controller.dto.DomicilioBancarioDto;
import com.cielo.extratolancamento.controller.dto.LancamentoContaCorrenteClienteDto;
import com.fasterxml.jackson.databind.JsonNode;

@Component
public class LancamentoContaCorrenteClienteDtoDeserialize extends AbstractDeserializer<LancamentoContaCorrenteClienteDto>{

	private DomicilioBancarioDtoDeserializer domicilioBancarioDtoDeserializer;
	
	@Autowired
	public LancamentoContaCorrenteClienteDtoDeserialize(DomicilioBancarioDtoDeserializer domicilioBancarioDtoDeserializer) {
		this.domicilioBancarioDtoDeserializer = domicilioBancarioDtoDeserializer;
	}
	
	@Override
	public LancamentoContaCorrenteClienteDto deserialize(JsonNode jsonNode) {
		Long numeroRemessaBanco = getLongField(jsonNode, Field.NUMERO_REMESSA_BANCO);
		String nomeSituacaoRemessa = getTextField(jsonNode, Field.NOME_SITUACAO_REMESSA);
		DomicilioBancarioDto dadosDomicilioBancario = this.deserializeDocimicilioBancarioDto(jsonNode);
		String nomeTipoOperacao = getTextField(jsonNode, Field.NOME_TIPO_OPERACAO);
		
		return new LancamentoContaCorrenteClienteDto(numeroRemessaBanco, nomeSituacaoRemessa, dadosDomicilioBancario, nomeTipoOperacao);
	}
	
	private DomicilioBancarioDto deserializeDocimicilioBancarioDto(JsonNode jsonNode) {
		 JsonNode domicilioBancarioDtoJsonNode = getJsonNode(jsonNode, Field.DADOS_DOMICILIO_BANCARIO);
	     return domicilioBancarioDtoDeserializer.deserialize(domicilioBancarioDtoJsonNode);
	}

}
