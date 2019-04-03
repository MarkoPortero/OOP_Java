package PartA;

import java.util.Scanner;

public class Main {
	
	private static Scanner key = new Scanner(System.in);
	public static void main(String[] args) {
		TestBooking.populate();
		TestBooking.menu();
		//TestBooking.getOption();
	}

}
