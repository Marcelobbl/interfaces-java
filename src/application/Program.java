package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.AluguelCarro;
import model.entities.Veiculos;
import model.services.BrasilTaxaServico;
import model.services.ServicoAluguel;

public class Program {

	public static void main(String[] args) throws ParseException{
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:ss");
		
		System.out.println("Entre com os dados do aluguel");
		System.out.println("Carro modelo: ");
		String marca = sc.nextLine();
		System.out.println("Retirar (dd/MM/yyyy hh:mm)");
		Date retirar = sdf.parse(sc.nextLine());
		System.out.print("Entrega (dd/MM/yyyy hh:mm)");
		Date entregar = sdf.parse(sc.nextLine());
		
		AluguelCarro aluguelCarro = new AluguelCarro(retirar, entregar, new Veiculos(marca));
		
		System.out.print("Digite o preço por hora: ");
		double valorPorHora = sc.nextDouble();
		System.out.print("Digite o preço por hora: ");
		double valorPorDia = sc.nextDouble();
		
		
		ServicoAluguel servicoAluguel = new ServicoAluguel(valorPorDia, valorPorHora, new BrasilTaxaServico());
		
		servicoAluguel.processoFatura(aluguelCarro);
		
		
		System.out.println("Fatura: ");
		System.out.println("Pagamento básico: " + String.format("%.2f" , aluguelCarro.getFatura().getPagamentoBasico()));
		System.out.println("Taxa: " + String.format("%.2f" , aluguelCarro.getFatura().getTaxa()));
		System.out.println("Total pagamento: " + String.format("%.2f" , aluguelCarro.getFatura().getPagamentoTotal()));
		
		sc.close();
	}

}
