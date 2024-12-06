package oops;
import java.util.*;
public class RailwayReservationSystem {
	public static void main(String[] args) {
		Train train= new Train(12345,"Chennai Express",3);
		Passenger p1= new Passenger("Sasank",21,"Male");
		Passenger p2= new Passenger("Satyasri",21,"Female");
		Passenger p3=new Passenger("Ramana",21,"Male");
		
		train.bookTicket(p1);
		train.bookTicket(p2);
//		train.cancelTicket(2);
		train.bookTicket(p3);
		train.checkAvailability();
//		train.prepareChart();
		

	}
}
class Passenger{
		String name;
		int age;
		String gender;
		int seatNo;
		Passenger(String name, int age, String gender){
			this.name=name;
			this.age=age;
			this.gender=gender;
		}
}

class Train{
		int trainNo;
		String trainName;
		int totalSeats;
		int availableSeats;
		List<Passenger> passengerLst;
		 public Train(int trainNo, String trainName, int totalSeats) {
		        this.trainNo = trainNo;
		        this.trainName = trainName;
		        this.totalSeats = totalSeats;
		        this.availableSeats = totalSeats;
		        this.passengerLst = new ArrayList<>();
		    }
		 public void bookTicket(Passenger passenger) {
			 if(availableSeats>0) {
				 passenger.seatNo= totalSeats- availableSeats + 1;
				 passengerLst.add(passenger);
				 availableSeats--;
				 System.out.println("Ticket Booked Successfully for "+ passenger.name + 
						 " with seat Number " + passenger.seatNo);
			 }
			 else {
				 System.out.println("No tickets available for "+passenger.name);
			 }
		 }
		 public boolean checkAvailability() {
			 System.out.println("The number of seats that are available "+ availableSeats );
			 return availableSeats>0;
		 }
		 public void cancelTicket(int seatNum) {
			 Passenger toRemove=null;
			 for(Passenger passenger: passengerLst) {
				 if (passenger.seatNo== seatNum) {
					 toRemove= passenger;
					 break;
				 }
			 }
			 if (toRemove != null) {
				 passengerLst.remove(toRemove);
				 availableSeats++;
				 System.out.println("Ticket cancelled for seat Number "+ seatNum);
				 
			 }
			 else {
				 System.out.println("Seat Number is not found");
			 }
		 }
		 
		 public void prepareChart() {
			 System.out.println("The Passenger chart for the following train "+ trainName);
			 for(Passenger passenger: passengerLst) {
				 System.out.println("Seat Number: "+ passenger.seatNo + ", Name : "+ passenger.name
						 + ",Age : "+ passenger.age+ ",Gender : "+ passenger.gender);
			 }
		 }
 
}
	


