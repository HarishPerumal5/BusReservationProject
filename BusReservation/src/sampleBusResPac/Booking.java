package sampleBusResPac;
import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Booking {
	private String passangerName;
	private int busNo;
	private Date date;

	public Booking() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your name:");
		passangerName=sc.next();

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
		sc.close();

	}
	public boolean isAvailable(ArrayList<Booking> bookings,ArrayList<Bus> buses) { 
		int capacity=0;
		for(Bus bus:buses) {
			if(bus.getNO()==busNo) {
				capacity=bus.getCapacity();
			}
		}
		int booked=0;
		for(Booking b:bookings) {
			if(b.busNo==busNo && b.date.equals(date)) {
				booked++;
			}
		}
		return((booked<capacity?true:false));

	}
}

