package com.cielo.extratolancamento.controller.dto.deserializer;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

public abstract class AbstractDeserializer<T> extends JsonDeserializer<T> {

    @Override
    public T deserialize(final JsonParser jsonParser, final DeserializationContext deserializationContext)
            throws IOException, JsonProcessingException {
        final ObjectCodec codec = jsonParser.getCodec();
        final JsonNode jsonNode = codec.readTree(jsonParser);
        return deserialize(jsonNode);
    }

    public abstract T deserialize(final JsonNode jsonNode);

    protected Integer getIntegerField(final JsonNode jsonNode, final Field field) {
        return jsonNode.get(field.toString()).asInt();
    }

    protected BigDecimal getBigDecimalField(final JsonNode jsonNode, final Field field) {
        final Double totalValue = jsonNode.get(field.toString()).asDouble();
        return new BigDecimal(totalValue).setScale(2, RoundingMode.HALF_EVEN);
    }

    protected LocalDate getLocalDateTimeField(final JsonNode jsonNode, final Field field) {
        final Long timeStamp = Long.parseLong( getTextField(jsonNode, field) );
		return  Instant.ofEpochMilli(timeStamp).atZone(ZoneId.systemDefault()).toLocalDate();       
    }

    protected String getTextField(final JsonNode jsonNode, final Field field){
        return jsonNode.get(field.toString()).asText();
    }

    protected JsonNode getJsonNode(final JsonNode jsonNode, final Field field) {
        return jsonNode.get(field.toString());
    }

    protected Long getLongField(final JsonNode jsonNode, final Field field) {
        return jsonNode.get(field.toString()).asLong();
    }

    protected enum Field {

        NUMERO_CONTA_CORRENTE("numeroContaCorrente"),
        NUMERO_AGENCIA("numeroAgencia"),
        DATE_LANCAMENTO_CONTA_CORRENTE_CLIENTE("dateLancamentoContaCorrenteCliente"),
        LANCAMENTO_CONTA_CORRENTE_CLIENTE("lancamentoContaCorrenteCliente"),
        NOME_BANCO("nomeBanco"),
        NUMERO_REMESSA_BANCO("numeroRemessaBanco"),
        CODIGO_BANCO("codigoBanco"),
        LISTA_CONTROLE_LANCAMENTO("listaControleLancamento"),
        DADOS_DOMICILIO_BANCARIO("dadosDomicilioBancario"),
        DESCRICAO_GRUPO_PAGAMENTO("descricaoGrupoPagamento"),
        DATE_EFETIVA_LANCAMENTO("dateEfetivaLancamento"),
        NUMERO_EVENTO("numeroEvento"),
        CODIGO_IDENTIFICAR_UNICO("codigoIdentificadorUnico"),
        NOME_TIPO_OPERACAO("nomeTipoOperacao"),
        QUANTIDADE_LANCAMENTOS("quantidadeLancamentos"),
        QUANTIDADE_REMESSAS("quantidadeRemessas"),
        NUMERO_RAIZ_CNPJ("numeroRaizCNPJ"),
        QUANTIDADE_LANCAMENTO_REMESSA("quantidadeLancamentoRemessa"),
        NUMERO_SUFIZO_CNPJ("numeroSufixoCNPJ"),
        NOME_SITUACAO_REMESSA("nomeSituacaoRemessa"),
        TOTAL_CONTROLE_LANCAMENTO("totalControleLancamento"),
        VALOR_LANCAMENTO("valorLancamentos"),
        VALOR_LANCAMENTO_REMESSA("valorLancamentoRemessa"),
    	INDICE("indice"),
    	TAMANHO_PAGINA("tamanhoPagina"),
    	TOTAL_ELEMENTS("totalElements");
    	
        private final String label;
        
        private Field(String label) {
			this.label = label;
		}
        
		public String toString() {
            return this.label;
        }       
        
    }

}


