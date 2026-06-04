package BusResPac;

import java.sql.SQLException;
//import java.util.ArrayList;
import java.util.Scanner;

public class BusDemo {

	public static void main(String[] args) throws SQLException {
		BusDAO busdao = new BusDAO();
		try {
		busdao.getBusInfo();

		int userOption = 1;
		Scanner sc = new Scanner(System.in);

		while (userOption == 1) {
			System.out.println("-----------------------------------------------");
			System.out.println("Enter 1 for Booking and Enter 2 for Exit");

			userOption = sc.nextInt();
			if (userOption == 1) {
				Booking booking = new Booking();
				if (booking.isAvailable()) {
					BookingDAO bookingdao = new BookingDAO();
					bookingdao.addBooking(booking);
					System.out.println("Booked Successfully.");
				} else {
					System.out.println("Sorry... bus is full.Try another bus or date");
				}
			}

		}
		

		sc.close();
		}
		catch(Exception e) {
			System.out.println(e);
			
		}

	}

}
