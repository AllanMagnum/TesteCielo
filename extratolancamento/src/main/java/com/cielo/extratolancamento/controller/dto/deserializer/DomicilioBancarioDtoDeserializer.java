package com.cielo.extratolancamento.controller.dto.deserializer;

import org.springframework.stereotype.Component;

import com.cielo.extratolancamento.controller.dto.DomicilioBancarioDto;
import com.fasterxml.jackson.databind.JsonNode;

@Component
public class DomicilioBancarioDtoDeserializer extends AbstractDeserializer<DomicilioBancarioDto> {
	
	@Override
	public DomicilioBancarioDto deserialize(JsonNode jsonNode) {
		String codigoBanco = getTextField(jsonNode, Field.CODIGO_BANCO);
		String numeroAgencia = getTextField(jsonNode, Field.NUMERO_AGENCIA);
		String numeroContaCorrente = getTextField(jsonNode, Field.NUMERO_CONTA_CORRENTE);		
		
		return new DomicilioBancarioDto(codigoBanco, numeroAgencia, numeroContaCorrente);
	}	
}
