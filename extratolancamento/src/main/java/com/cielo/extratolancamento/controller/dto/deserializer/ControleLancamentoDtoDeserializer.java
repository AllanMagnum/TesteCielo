package com.cielo.extratolancamento.controller.dto.deserializer;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cielo.extratolancamento.controller.dto.ControleLancamentoDto;
import com.cielo.extratolancamento.controller.dto.LancamentoContaCorrenteClienteDto;
import com.fasterxml.jackson.databind.JsonNode;

@Component
public class ControleLancamentoDtoDeserializer extends AbstractDeserializer<ControleLancamentoDto> {

	private LancamentoContaCorrenteClienteDtoDeserialize lancamentoContaCorrenteClienteDtoDeserialize;

	@Autowired
	public ControleLancamentoDtoDeserializer(
			LancamentoContaCorrenteClienteDtoDeserialize lancamentoContaCorrenteClienteDtoDeserialize) {
		this.lancamentoContaCorrenteClienteDtoDeserialize = lancamentoContaCorrenteClienteDtoDeserialize;
	}

	@Override
	public ControleLancamentoDto deserialize(JsonNode jsonNode) {
		LancamentoContaCorrenteClienteDto lancamentoContaCorrenteClienteDto = this
				.deserializeLancamentoContaCorrenteClienteDto(jsonNode);

		LocalDateTime dataEfetivaLancamento = getLocalDateTimeField(jsonNode, Field.DATE_EFETIVA_LANCAMENTO);
		LocalDateTime dataLancamentoContaCorrenteCliente = getLocalDateTimeField(jsonNode, Field.DATE_LANCAMENTO_CONTA_CORRENTE_CLIENTE);
		Long numeroEvento = getLongField(jsonNode, Field.NUMERO_EVENTO);
		String descricaoGrupoPagamento = getTextField(jsonNode, Field.DESCRICAO_GRUPO_PAGAMENTO);
		String codigoIdentificadorUnico = getTextField(jsonNode, Field.CODIGO_IDENTIFICAR_UNICO);
		String nomeBanco = getTextField(jsonNode, Field.CODIGO_IDENTIFICAR_UNICO);
		String quantidadeLancamentoRemessa = getTextField(jsonNode, Field.CODIGO_IDENTIFICAR_UNICO);
		Long numeroRaizCNPJ = getLongField(jsonNode, Field.NUMERO_EVENTO);
		Long numeroSufixoCNPJ = getLongField(jsonNode, Field.NUMERO_EVENTO);
		BigDecimal valorLancamentoRemessa = getBigDecimalField(jsonNode, Field.VALOR_LANCAMENTO_REMESSA);

		return new ControleLancamentoDto(lancamentoContaCorrenteClienteDto, dataEfetivaLancamento,
				dataLancamentoContaCorrenteCliente, numeroEvento, descricaoGrupoPagamento, codigoIdentificadorUnico,
				nomeBanco, quantidadeLancamentoRemessa, numeroRaizCNPJ, numeroSufixoCNPJ, valorLancamentoRemessa);
	}

	private LancamentoContaCorrenteClienteDto deserializeLancamentoContaCorrenteClienteDto(JsonNode jsonNode) {
		JsonNode lancamentoContaCorrenteClienteDtoJsonNode = getJsonNode(jsonNode, Field.LANCAMENTO_CONTA_CORRENTE_CLIENTE);
		return lancamentoContaCorrenteClienteDtoDeserialize.deserialize(lancamentoContaCorrenteClienteDtoJsonNode);
	}
}
