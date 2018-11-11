package com.cielo.extratolancamento.service;

import java.util.Optional;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.cielo.extratolancamento.controller.dto.LancamentoContaLegadoDto;
import com.cielo.extratolancamento.service.Interface.IntegracaoLegagoService;

@Service
@Profile({"dev", "qa", "prd"})
public class DefaultIntegracaoLegadoService implements IntegracaoLegagoService{

	@Override
	public Optional<LancamentoContaLegadoDto> recuperarInformacao() {
		// TODO Auto-generated method stub
		return null;
	}

}
