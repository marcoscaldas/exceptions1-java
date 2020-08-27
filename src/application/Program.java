package application;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


import model.entities.Reservation;
import model.exceptions.DomainException;


public class Program {

	public static void main(String[] args) {// adiciona throws parseException devido o sdf.parse
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
		
		
		try {
			System.out.print("Room numer: ");
			int number = sc.nextInt();
			System.out.println("Check-in date (dd/mm/yyy)");
			Date checkIn = (Date) sdf.parse(sc.next()); //entra com um string e o sdf.parser converte
			System.out.println("Check-out date (dd/mm/yyy)");
			Date checkOut = (Date) sdf.parse(sc.next());
			
			
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);	
			
			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			System.out.println("Check-in date (dd/mm/yyy)");
			checkIn = (Date) sdf.parse(sc.next()); //entra com um string e o sdf.parser converte
			System.out.println("Check-out date (dd/mm/yyy)");
			checkOut = (Date) sdf.parse(sc.next());
			
			
			reservation.updateDates(checkIn, checkOut);	
			System.out.println("Reservation: " + reservation);
		}
		catch(ParseException apelido) {
			System.out.println("Invalid date format");
		}
		catch(DomainException apelido) {
			System.out.println("Error in reservation: " + apelido.getMessage());
		}
		catch (RuntimeException apelido) {
			System.out.println("Unexpected error");
		}
		
		
		sc.close();

	}

}
