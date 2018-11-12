	package com.cielo.extratolancamento.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
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
			extratoLancamentoOutputDto.setSituacao(lancamento.getLancamentoContaCorrenteClienteDto().getNomeSituacaoRemessa());
			extratoLancamentoOutputDto.setValorFinal(this.formatarValor(lancamento.getValorLancamentoRemessa()) );
						
			lancamentos.add(extratoLancamentoOutputDto);
		});
		
		return lancamentos;
	}	
	
	private String getDadosBancarios(ControleLancamentoDto controleLancamentoDto) {
		return controleLancamentoDto.getNomeBanco() + " Ag " +
				controleLancamentoDto.getLancamentoContaCorrenteClienteDto().getDadosDomicilioBancario().getNumeroAgencia() + " CC " + 
				controleLancamentoDto.getLancamentoContaCorrenteClienteDto().getDadosDomicilioBancario().getNumeroContaCorrente();
					
	}	
	
	private String formatarValor(BigDecimal modelVal) {
		
		BigDecimal displayVal = modelVal.setScale(2, RoundingMode.HALF_EVEN);
		
		Locale meuLocal = new Locale( "pt", "BR" ); 
		
		NumberFormat usdCostFormat = NumberFormat.getCurrencyInstance(meuLocal);
		usdCostFormat.setMinimumFractionDigits( 1 );
		usdCostFormat.setMaximumFractionDigits( 2 );
		return usdCostFormat.format(displayVal.doubleValue()); 
	}
}
