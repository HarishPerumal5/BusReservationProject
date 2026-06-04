package BusResPac;
import java.util.*;
import java.sql.SQLException;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Booking {
	 String passengerName;
	 int busNo;
	 Date date;

	public Booking() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your name:");
		passengerName=sc.next();

		System.out.println("Enter bus number:");
		busNo=sc.nextInt();

		System.out.println("Enter date DD-MM-YYYY :");
		String inputDate=sc.next();

		SimpleDateFormat dateFormate=new SimpleDateFormat("dd-MM-yyyy");
		try {
			date=dateFormate.parse(inputDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public boolean isAvailable()throws SQLException { 
		BusDAO busdao=new BusDAO();
		BookingDAO bookingdao=new BookingDAO();
		
		int capacity=busdao.getCapacity(busNo);
		
		int booked=bookingdao.getBookedCount(busNo,date);
		
		return booked<capacity;

	}
}

