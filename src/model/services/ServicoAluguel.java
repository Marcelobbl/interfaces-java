package model.services;

import model.entities.AluguelCarro;
import model.entities.Fatura;

public class ServicoAluguel {
	
	private Double precoPorDia;
	private Double precoPorHora;
	
	private TaxaServico taxaServico;

	public ServicoAluguel(Double precoPorDia, Double precoPorHora, TaxaServico taxaServico) {
		this.precoPorDia = precoPorDia;
		this.precoPorHora = precoPorHora;
		this.taxaServico = taxaServico;
	}
	
	public void processoFatura(AluguelCarro aluguelCarro) {
		double tempo = (double)((aluguelCarro.getFim().getTime()) - (aluguelCarro.getComeco().getTime()))/1000/60/60;
		
		double basicoPagamento;
		if (tempo <= 12.0) {
			basicoPagamento = Math.ceil(tempo) * precoPorHora;
		}
		else {
			basicoPagamento = Math.ceil(tempo / 24) * precoPorDia;
		}
		
		double taxa = taxaServico.taxa(basicoPagamento);
		
		aluguelCarro.setFatura(new Fatura(basicoPagamento, taxa));
	}
	

}
