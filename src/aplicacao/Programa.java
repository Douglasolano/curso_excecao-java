package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import modelo.entidade.Reservas;
import modelo.excecoes.ExcecaoDominio;

public class Programa {
	
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.print("Numero do quarto: ");
			int numero = sc.nextInt();
			System.out.print("Data do check-in (dd/mm/yyyy): ");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("Data do check-out (dd/mm/yyyy): ");
			Date checkOut = sdf.parse(sc.next());
			
			Reservas reservas = new Reservas(numero,checkIn,checkOut);
			System.out.println("Reserva: " + reservas);
			
			System.out.println();
			System.out.println("Entre com a data para atualizar a reserva: ");
			System.out.print("Data do check-in (dd/mm/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Data do check-out (dd/mm/yyyy): ");
			checkOut = sdf.parse(sc.next());
	
			reservas.atualizarDatas(checkIn, checkOut);
			System.out.println("Reserva: " + reservas);	
		}
		catch (ParseException e) {
			System.out.println("Formato de data invalido");
		}
		catch (ExcecaoDominio e) {
			System.out.println("Erro na reserva: " + e.getMessage());
		}
		catch (RuntimeException e) {
			System.out.println("Erro inesperado.");
		}
		
		sc.close();
	}
}
