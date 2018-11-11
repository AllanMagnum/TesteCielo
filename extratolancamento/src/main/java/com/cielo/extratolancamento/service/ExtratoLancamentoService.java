	package com.cielo.extratolancamento.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cielo.extratolancamento.controller.dto.ControleLancamentoDto;
import com.cielo.extratolancamento.controller.dto.LancamentoContaLegadoDto;
import com.cielo.extratolancamento.controller.dto.output.ExtratoLancamentoOutputDto;
import com.cielo.extratolancamento.exception.ExtratoNotFoundException;

@Service
public class ExtratoLancamentoService{

	private LocalIntegracaoLegadoService integracaoLegadoService;
		
	@Autowired
	public ExtratoLancamentoService(LocalIntegracaoLegadoService integracaoLegadoService) {
		this.integracaoLegadoService = integracaoLegadoService;	
	}
	
	public List<ExtratoLancamentoOutputDto> recuperaInformacoesLegado() {
		Optional<LancamentoContaLegadoDto> lancamentos = integracaoLegadoService.recuperarInformacao();
		
		List<ExtratoLancamentoOutputDto> listExtrato = new ArrayList<>();		
		
		if(lancamentos.isPresent())
			listExtrato = this.getExtrato( lancamentos.get() );
		else
			throw new ExtratoNotFoundException("NOT FOUND");
		return listExtrato;
	}

	private List<ExtratoLancamentoOutputDto> getExtrato(LancamentoContaLegadoDto lancamentoContaLegadoDto) {
		List<ExtratoLancamentoOutputDto> lancamentos =  new ArrayList<>();
		
		lancamentoContaLegadoDto.getListaControleLancamento().forEach(lancamento ->{
			ExtratoLancamentoOutputDto extratoLancamentoOutputDto = new ExtratoLancamentoOutputDto();
			
			extratoLancamentoOutputDto.setDadosBancarios(getDadosBancarios(lancamento));
			extratoLancamentoOutputDto.setDataLancamento(lancamento.getDataEfetivaLancamento());
			extratoLancamentoOutputDto.setDataConfirmacao(lancamento.getDataLancamentoContaCorrenteCliente());
			extratoLancamentoOutputDto.setDescricao(lancamento.getLancamentoContaCorrenteClienteDto().getNomeTipoOperacao());
			extratoLancamentoOutputDto.setNumero(lancamento.getLancamentoContaCorrenteClienteDto().getNumeroRemessaBanco());
			extratoLancamentoOutputDto.setSitucao(lancamento.getLancamentoContaCorrenteClienteDto().getNomeSituacaoRemessa());
			extratoLancamentoOutputDto.setValorFinal(lancamento.getValorLancamentoRemessa());
						
			lancamentos.add(extratoLancamentoOutputDto);
		});
		
		return lancamentos;
	}	
	
	private String getDadosBancarios(ControleLancamentoDto controleLancamentoDto) {
		return controleLancamentoDto.getNomeBanco() + " Ag " +
				controleLancamentoDto.getLancamentoContaCorrenteClienteDto().getDadosDomicilioBancario().getNumeroAgencia() + " CC " + 
				controleLancamentoDto.getLancamentoContaCorrenteClienteDto().getDadosDomicilioBancario().getNumeroContaCorrente();
					
	}	
}
