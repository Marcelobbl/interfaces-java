package model.entities;

import java.util.Date;

public class AluguelCarro {
	
	private Date comeco;
	private Date fim;
	
	private Veiculos veiculo;
	private Fatura fatura;
	
	public AluguelCarro() {
		}

	public AluguelCarro(Date comeco, Date fim) {
		this.comeco = comeco;
		this.fim = fim;
	}

	public AluguelCarro(Date comeco, Date fim, Veiculos veiculo) {
		this.comeco = comeco;
		this.fim = fim;
		this.veiculo = veiculo;
	}

	public Date getComeco() {
		return comeco;
	}

	public void setComeco(Date comeco) {
		this.comeco = comeco;
	}

	public Date getFim() {
		return fim;
	}

	public void setFim(Date fim) {
		this.fim = fim;
	}

	public Veiculos getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculos veiculo) {
		this.veiculo = veiculo;
	}

	public Fatura getFatura() {
		return fatura;
	}

	public void setFatura(Fatura fatura) {
		this.fatura = fatura;
	}
	
	
	
	

}
