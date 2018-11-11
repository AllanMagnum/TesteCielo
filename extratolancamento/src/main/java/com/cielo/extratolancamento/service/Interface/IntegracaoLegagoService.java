package com.cielo.extratolancamento.service.Interface;

import java.util.Optional;

import com.cielo.extratolancamento.controller.dto.LancamentoContaLegadoDto;

public interface IntegracaoLegagoService {
	Optional<LancamentoContaLegadoDto> recuperarInformacao();
}
