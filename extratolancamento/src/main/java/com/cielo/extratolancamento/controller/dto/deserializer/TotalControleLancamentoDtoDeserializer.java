package com.cielo.extratolancamento.controller.dto.deserializer;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.cielo.extratolancamento.controller.dto.TotalControleLancamentoDto;
import com.fasterxml.jackson.databind.JsonNode;

@Component
public class TotalControleLancamentoDtoDeserializer extends AbstractDeserializer<TotalControleLancamentoDto>  {

	@Override
	public TotalControleLancamentoDto deserialize(JsonNode jsonNode) {
		Long quantidadeLancamentos = getLongField(jsonNode, Field.QUANTIDADE_LANCAMENTOS);
		Long quantidadeRemessas = getLongField(jsonNode, Field.QUANTIDADE_REMESSAS);
		BigDecimal valorLancamentos = getBigDecimalField(jsonNode, Field.VALOR_LANCAMENTO);
		return new TotalControleLancamentoDto(quantidadeLancamentos, quantidadeRemessas, valorLancamentos);
	}

}
