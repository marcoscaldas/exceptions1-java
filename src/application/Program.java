package application;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {// adiciona throws parseException devido o sdf.parse
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
		
		System.out.print("Room numer: ");
		int number = sc.nextInt();
		System.out.println("Check-in date (dd/mm/yyy)");
		Date checkIn = (Date) sdf.parse(sc.next()); //entra com um string e o sdf.parser converte
		System.out.println("Check-out date (dd/mm/yyy)");
		Date checkOut = (Date) sdf.parse(sc.next());
		
		if (!checkOut.after(checkIn)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		}
		else {
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);	
			
			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			System.out.println("Check-in date (dd/mm/yyy)");
			checkIn = (Date) sdf.parse(sc.next()); //entra com um string e o sdf.parser converte
			System.out.println("Check-out date (dd/mm/yyy)");
			checkOut = (Date) sdf.parse(sc.next());
			
			
			String error = reservation.updateDates(checkIn, checkOut);	
			if (error != null) {
				System.out.println("Error in reservation: " + error);
			}
			else {
				
			System.out.println("Reservation: " + reservation);
			}
		}
		
		
		
		
		sc.close();

	}

}
