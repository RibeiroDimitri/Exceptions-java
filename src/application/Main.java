package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reserva;
import model.exceptions.DomainException;

public class Main {
	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.println("Numero do Quarto: ");
			int numero = sc.nextInt();
			System.out.println("Data de Check-in (dd/MM/yyyy)");
			Date checkIn = sdf.parse(sc.next());
			System.out.println(checkIn);
			System.out.println("Data de Check-out (dd/MM/yyyy)");
			Date checkOut = sdf.parse(sc.next());
			System.out.println(checkOut);
			
			Reserva reserva = new Reserva(numero, checkIn, checkOut);
			System.out.println("Reserva: " + reserva);
			
			System.out.println();
			System.out.println("Entre com a data atualizada da reserva: ");
			System.out.println("Data de Check-in (dd/MM/yyyy)");
			checkIn = sdf.parse(sc.next());
			System.out.println("Data de Check-out (dd/MM/yyyy)");
			checkOut = sdf.parse(sc.next());
			
			reserva.atualizaDatas(checkIn, checkOut);
			System.out.println("Reserva: " + reserva);
		}
		catch(ParseException e){
			System.out.println("Formato de data invalido!");
		}
		catch(DomainException e) {
			System.out.println("Erro ao fazer a reserva: " + e);
		}
		catch(RuntimeException e) {
			System.out.println("Erro inesperado!" + e);
		}
		
		sc.close();
	}
}
