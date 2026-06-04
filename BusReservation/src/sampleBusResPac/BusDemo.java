package sampleBusResPac;
import java.util.ArrayList;
import java.util.Scanner;

public class BusDemo {

	public static void main(String[] args) {
		
		ArrayList<Bus> buses=new ArrayList<Bus>();
		ArrayList<Booking>bookings=new ArrayList<Booking>();
		buses.add(new Bus(1,true,2));
		buses.add(new Bus(2,false,50));
		buses.add(new Bus(3,true,48));

		for(Bus b:buses) {
			b.displayBusInfo();
		}
		
		int userOption=1;
		Scanner sc=new Scanner(System.in);

		while(userOption==1) {
			System.out.println("Enter 1 for Booking and Enter 2 for Exit");
			 userOption=sc.nextInt();
			 if(userOption==1) {
				 Booking booking=new Booking();
				 if(booking.isAvailable(bookings,buses)) {
					 bookings.add(booking);
					 System.out.println("Booked Successfully.");
				 }
				 else
				 {
				  System.out.println("Sorry... bus is full.Try another bus or date idiot ");
				 }
			 }
			 
		}
		sc.close();
		
	}

}
