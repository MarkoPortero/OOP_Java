package PartA;

import java.util.Scanner;

import javax.swing.Spring;

public class TestBooking {
	private static Scanner key = new Scanner(System.in);
	private static Booking [] bookings = new Booking[25];

	int choice;
	static int section=0;
	
	public static void populate(){
		bookings[0] = new Booking(10001, 2, 0, 0, "B1", "Paul Wilson", "02871829283", "Dungiven", "12/5/2017");
		bookings[1] = new Booking(10002, 0, 3, 0, "B1", "Jackie Collin", "02871822324", "Derry", "12/5/2017");
		bookings[2] = new Booking(10003, 1, 0, 2, "B2", "William Ryker", "02871868324", "Castledawson", "13/5/2017");
		bookings[3] = new Booking(10004, 0, 3, 1, "B1", "Mark Porter", "02871355243", "Castledawson", "13/5/2017");
		bookings[4] = new Booking(10005, 1, 0, 0, "B2", "Marjorie Bennett", "02871822324", "Derry", "13/5/2017");
		bookings[5] = new Booking(10006, 0, 2, 3, "E3", "Rodney Poppin", "02871899324", "Derry", "13/5/2017");
		
		bookings[6] = new Booking(10007, 1, 1, 1, "E3", "Trafford Kelly", "02871531037", "Derry", "14/5/2017");
		bookings[7] = new Booking(10008, 0, 0, 0, "E3", "Zachary Quinto", "02871672432", "Derry", "14/5/2017");
		bookings[8] = new Booking(10009, 2, 3, 1, "D4", "Wilfred Owen", "02871492440","Derry", "14/5/2017");
		bookings[9] = new Booking(10010, 3,2, 1, "D4", "Trent Reznor", "02871776883", "Derry", "15/5/2017");
		bookings[10] = new Booking(10011, 1, 1, 0, "D4", "Blaine Anderson", "02871608981", "Derry", "15/5/2017");
		bookings[11] = new Booking(10012, 2, 0, 2, "E3", "Larrie King", "02871685707", "Derry", "15/5/2017");
		
		bookings[12] = new Booking(10013,1, 3, 0, "E3", "Barney Harwood", "02871940161","Derry", "16/5/2017");
		bookings[13] = new Booking(10014, 1, 2, 3, "B1", "Addison Russell", "02871765865", "Derry", "16/5/2017");
		bookings[14] = new Booking(10015,4, 1, 0, "B2", "Kurt Breton", "02871358259", "Derry", "16/5/2017");
		
	}
	public static void menu(){

		int choice=0;
		int search=0;
		int display=0;
		{
		My.p("\n\tBooking Menu");
		My.p("\n\t1-Add Booking Details");
		My.p("\n\t2.Display details for all bookings");
		My.p("\n\t3.Search Options");
		My.p("\n\t4.Display Options");
		My.p("\n\tSelect an option: ");
		}
		
		choice = key.nextInt();
		if(choice == 1){
			Booking newBooking = new Booking();
			int size = 0;
			for (int i = 0; i < bookings.length; i++)
			{
				if(bookings[i] != null){
					size++;
				}
			}
			int newSize;
			newSize = bookings[size-1].bookingNo;
			newBooking.bookingNo = newSize+1;
			My.p("\n\n\n\t Please enter the journey code: (B1/B2/E3/D4)");
			newBooking.journeyCode = key.next();
			My.p("\n\t Please enter a name: ");
			key.nextLine();
			newBooking.name = key.nextLine();
			int adults;
			do{
				My.p("\n\t Please enter how many adults: ");
				My.p("\n\t Please enter a digit less than 10:");
				adults = key.nextInt();
				newBooking.noAdults = adults;
			}while(adults >10);
			if(adults <= 10){
			newBooking.noAdults = adults;
			}
			My.p("\n\t Please enter how many children: ");
			
			newBooking.noChildren = key.nextInt();
			My.p("\n\t Please enter how many OAPs: ");
			newBooking.noOAPs = key.nextInt();
			My.p("\n\t Please enter a contact phone number: ");
			newBooking.telephone = key.next();
			My.p("\n\t Please enter a pickup location: ");
			newBooking.pickup = key.next();
			My.p("\n\t Please enter a travel date: dd/mm/yyyy ");
			newBooking.travelDate = key.next();
			

			
			My.p("\n\n x = " + size + "\n\n");
			bookings[size] = newBooking;
			menu();
		}
		else if(choice == 2){
			displayAll();
		}
		else if(choice == 3){
		My.p("\n\n\n\n\n\t\t\tSEARCH CHOICES");
		My.p("\n\t1.Search by Booking num");
		My.p("\n\t2.Search by Travel Date");
		My.p("\n\t3.Search by Name");
		My.p("\n\t4.Go back");
		My.p("\n\tSelect an option: ");
		search = key.nextInt();
			switch(search){
			case 1:searchByBookingNum(); break;
			case 2:searchByTravelDate(); break;
			case 3:searchByName(); break;
			case 4: menu();
			}
		}
		else if(choice==4){
		My.p("\n\n\n\n\n\t\t\tDISPLAY CHOICES");
		My.p("\n\t1.Display all non-Adults travelling on a specified date and time");
		My.p("\n\t2.Display the total income for each trip");
		My.p("\n\t3.Display the details of people being picked up at a specific pickup location");
		My.p("\n\t4.Display a breakdown of the total actual income by destination");
		My.p("\n\t5.Go back");
		My.p("\n\tSelect an option: ");
		display = key.nextInt();
			switch(display){
			case 1: displayNonAdults(); break;
			case 2: totalIncome(); break;
			case 3: pickUpInfo(); break;
			case 4: ;
			case 5: menu(); break;
			}
		}
	}
	public static void displayNonAdults(){
		int NumChildren=0;
		int NumOAPS=0;
		int size = 0;
		for (int i = 0; i < bookings.length; i++)
		{
			if(bookings[i] != null){
				size++;
			}
		}
		String travelDate;
		My.p("Please enter a travel date: dd/mm/yyyy");
		travelDate = key.next();
		for(int x=0; x<15;x++)
		{
			
			if(bookings[x].travelDate.equals(travelDate)){
				NumOAPS+=bookings[x].noOAPs;
				NumChildren+=bookings[x].noChildren;
			}
		}
		My.p("\n\nNumber of OAPs:" + NumOAPS);
		My.p("\n\nNumber of Children:" + NumChildren);
	}
	public static void displayAll(){
		int size = 0;
		for (int i = 0; i < bookings.length; i++)
		{
			if(bookings[i] != null){
				size++;
			}
		}
		for(int x=0;x<size;x++)
		{
			My.p(bookings[x].toString());
		
		}
		DoOver();
	}
	public static void DoOver(){

		My.p("\n\n\t Go back to the menu? Y/N: ");
		String Choice = key.next();
		if(Choice.contains("Y")){
			menu();
		}
		else if(Choice.contains("N")){
			System.exit(0);
		}
	}
	public static void totalIncome(){
		int total = 0;
		int numChild = 0;
		int numAdults = 0;
		int adultCharge;
		int childCharge;
		String trip;
		String date;
		My.p("\n\t Please enter a Trip ID: B1/B2/E3/D4");
		trip = key.next();
		My.p("\n\t Please enter a date: dd/mm/YYYY ");
		date = key.next();
		
		
		for(int x=0; x<15;x++)
		{	
			if(bookings[x].journeyCode.equals(trip) && bookings[x].travelDate.equals(date)){
				numChild+=bookings[x].noChildren;
				numAdults+=bookings[x].noAdults;
			}
		}
		adultCharge = numAdults*20;
		childCharge = numChild*10;
		total=childCharge+adultCharge;
		My.p("\n\n\tTHE TOTAL AMOUNT FOR THE TRIP: " + trip + "\n\ton the date: " + date
				+ " \n\t is: \t ADULTS: "+adultCharge+ " \t CHILDREN: " +childCharge + "\n\t Total: " + total);
	}
	public static void getOption(){
		
		int choice = key.nextInt();
		if(section == 0 && key.nextInt() == 3 ){
			section=1;
			
		}menu();
/*		else if(section == 0 && key.nextInt() == 4)
		{
			section=2;
			menu();
		}
		else if((section == 1 && key.nextInt() == 4) || (section == 2 && key.nextInt() == 5))
		{
			section=0;
			menu();
		}*/
		
	
	}
	public static void pickUpInfo(){
		String trip;
		String date;
		My.p("\n\t Please enter a Trip ID: B1/B2/E3/D4");
		trip = key.next();
		My.p("\n\t Please enter a date: dd/mm/YYYY ");
		date = key.next();
		My.p("\n\tBooking Details for trip: " + trip + " on " + date);
		for(int x=0; x<15;x++)
		{		
			if(bookings[x].journeyCode.equals(trip) && bookings[x].travelDate.equals(date))
			{
				My.p("\n\t "+ bookings[x].toString());
			}
		}
	}
	public static void ActualIncomeByDestination(){
		int total = 0;
		int numChild = 0;
		int numAdults = 0;
		int adultCharge;
		int childCharge;
		String trip;
		String date;
		My.p("\n\t Please enter a Trip ID: B1/B2/E3/D4 ");
		trip = key.next();
		My.p("\n\t Please enter a date: dd/mm/YYYY ");
		date = key.next();
		for(int x=0; x<15;x++)
		{	
			if(bookings[x].journeyCode.equals(trip) && bookings[x].travelDate.equals(date)){
				numChild+=bookings[x].noChildren;
				numAdults+=bookings[x].noAdults;
			}
		}
		adultCharge = numAdults*20;
		childCharge = numChild*10;
		total=childCharge+adultCharge;
		My.p("\n\n\tTHE TOTAL AMOUNT FOR THE TRIP: " + trip + "\n\ton the date: " + date
				+ " \n\t is: \t ADULTS: "+adultCharge+ " \t CHILDREN: " +childCharge + "\n\t Total: " + total);
	}
	public static void searchByBookingNum(){
		int bookingNum;
		My.p("\n\t Please enter a booking number: eg 10001 ");
		bookingNum = key.nextInt();
		for(int x=0; x<15;x++)
		{	
			if(bookings[x].bookingNo == bookingNum){
				My.p("\n\t" + bookings[x].toString());
			}
		}
	}
	public static void searchByTravelDate(){

		String date;
		My.p("\n\t Please enter a date: dd/mm/YYYY ");
		date = key.next();
		for(int x=0; x<15;x++)
		{	
			if(bookings[x].travelDate.equals(date)){
				My.p("\n\t" + bookings[x].toString());
			}
		}
	}
	public static void searchByName(){
		String name;
		My.p("\n\tPlease enter a name: ");
		key.nextLine();
		name = key.nextLine();
		for(int x=0; x<15; x++){
			if(bookings[x].name.equals(name)){
				My.p("\n\t" + bookings[x].toString());
			}
		}
	
	}
}
