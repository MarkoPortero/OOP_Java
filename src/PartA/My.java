package PartA;

import java.util.Scanner;
public class My {

	static Scanner key= new Scanner(System.in);
	
	public static void p(String s){
		System.out.print(s);
	}
	
	public static void menu(){
		p("\n\n\t\t\t  Menu for Guitar Hero Music Store");
		p("\n\t\t\t1:  Add Stock"); 
		p("\n\t\t\t2:  Stock Value");  
		p("\n\t\t\t3:  Display all"); 
		p("\n\t\t\t4:  Display Category");
		p("\n\t\t\t5:  Price Amplifier Delivery");
		p("\n\t\t\t6:  Exit");
		p("\n\n\t\t\tEnter option  :");
	}
	
	public static int getOpt(int min, int max){
		int opt=0;
		while(opt<min || opt>max){
			opt= key.nextInt();
			if(opt<min || opt >max )
			{	p("\t Must be between" + min + " - "+ max);
				p("\n\t\t\tPlease reenter");
			}
		}
		
		return opt;
	}
	
	public static char getYN(){
		String s;
		char ch;
		
		do{
		p("\n\t\t\tEnter Y/N   or y/n");
		s= key.next();
		ch= s.toUpperCase().charAt(0);
		}while(ch!='Y' && ch!='N' );
		
		return ch;
	}
	
	public static void pressKey(){
		String s;
		p("\n\t\t\tPress any key to continue  :");
		s= key.next();
					
		}
	
}
