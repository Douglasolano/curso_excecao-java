package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import modelo.entidade.Reservas;

public class Programa {
	
	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Numero do quarto: ");
		int numero = sc.nextInt();
		System.out.print("Data do check-in (dd/mm/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Data do check-out (dd/mm/yyyy): ");
		Date checkOut = sdf.parse(sc.next());
		
		if (!checkOut.after(checkIn)) {
			System.out.println("Erro na reserva: check-out precisa ser ter a data posterior ao check-in");
		}
		else {
			Reservas reservas = new Reservas(numero,checkIn,checkOut);
			System.out.println("Reserva: " + reservas);
			System.out.println();
			System.out.println("Entre com a data para atualizar a reserva: ");
			System.out.print("Data do check-in (dd/mm/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Data do check-out (dd/mm/yyyy): ");
			checkOut = sdf.parse(sc.next());
			
			Date agora = new Date();
			if (checkIn.before(agora) || checkOut.before(agora)) {
				System.out.println("Erro na reserva: as datas precisam ser futuras a hoje");
			}
			else if (!checkOut.after(checkIn)) {
				System.out.println("Erro na reserva: check-out precisa ser ter a data posterior ao check-in");
			}
			else {
				reservas.atualizarDatas(checkIn, checkOut);
				System.out.println("Reserva: " + reservas);
			}
		}
		sc.close();
	}
}
