package com.cielo.extratolancamento.service;

import java.io.IOException;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.cielo.extratolancamento.controller.dto.LancamentoContaLegadoDto;
import com.cielo.extratolancamento.controller.dto.deserializer.LancamentoContaLegadoDtoDeserializer;
import com.cielo.extratolancamento.exception.CannotReadArchiveException;
import com.cielo.extratolancamento.service.Interface.IntegracaoLegagoService;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
@Profile({"local", "test"})
public class LocalIntegracaoLegadoService implements IntegracaoLegagoService{
	
	private static final String FILE_URI = "/json/lancamento-conta-legado.json";
	private final ObjectMapper objectMapper;
	private final LancamentoContaLegadoDtoDeserializer deserializer;

	@Autowired
	public LocalIntegracaoLegadoService(ObjectMapper objectMapper, LancamentoContaLegadoDtoDeserializer deserializer) {
		this.objectMapper = objectMapper;
		this.deserializer = deserializer;
	}

	public Optional<LancamentoContaLegadoDto> recuperarInformacao() {
		JsonNode archiveAsJsonNode = getArchiveAsJsonNode();
		return Optional.ofNullable(deserializer.deserialize(archiveAsJsonNode));
	}

	private JsonNode getArchiveAsJsonNode() {
		try {
			final JsonParser jsonParser = new JsonFactory().createParser(getJsonAsString(FILE_URI));
			jsonParser.setCodec(objectMapper);
			final ObjectCodec oc = jsonParser.getCodec();
			return oc.readTree(jsonParser);
		} catch (final IOException e) {
			throw new CannotReadArchiveException(String.format("O arquivo não pode ser lido'%s'", FILE_URI), e);
		}
	}

	private String getJsonAsString(final String uri) {
		final Scanner scanner = new Scanner(getClass().getResourceAsStream(uri));
		scanner.useDelimiter("\\A");
		final String json = scanner.next();
		scanner.close();
		return json;
	}
}
