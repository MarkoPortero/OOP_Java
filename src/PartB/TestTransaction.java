package PartB;

import java.util.Scanner;

import PartA.Booking;
import PartA.My;


public class TestTransaction {
	private static Transaction [] currentTransactions = new Transaction[25];
	private static Scanner key = new Scanner(System.in);
	public static void menu(){
		{
			int choice=0;
			My.p("\n\t\t\tMenu");
			My.p("\n\t1-Add Transaction");
			My.p("\n\t2.Display Transactions by Type");
			My.p("\n\t3.Display all Transactions");
			My.p("\n\t4.Exit");
			My.p("\n\tSelect an option: ");
			choice = key.nextInt();
			if(choice == 1){
				newTransaction();
			}
		}
	}
	public static void newTransaction(){
		Transaction newTransaction = new Transaction();
		int compChoice;
		int paymentOption;
		int price = 0;
		My.p("\n\n\t Thank you for choosing a computer with Moiras. Please select a computer from the list: ");
		My.p("\n\t 1. The i3 OfficeSpace");
		My.p("\n\t 2. The i5 Gamer");
		My.p("\n\t 3. The i7 Gigabuster");
		Product newProduct = new Product();
		
		compChoice = key.nextInt();
		if(compChoice == 1){
			price = 500;
			newProduct.desc = "i3 OfficeSpace";
			My.p("\n\n\t You have chosen product 1. The default price is: " + price +
					"\n\t Change price? Y/N");
			String choice = key.next().toUpperCase();
			My.p("choice = " + choice);
			if(choice.equals("Y") || choice.equals("y")){
				My.p("\n\tPlease enter a custom price: ");
				price = key.nextInt();
			}
		}
		else if(compChoice == 2){
			newProduct.desc="i5 Gamer";
			price = 1000;
			My.p("\n\n\t You have chosen product 2. The default price is: " + price +
					"\n\t Change price? Y/N");
			String choice = key.next().toUpperCase();
			My.p("choice = " + choice);
			if(choice.equals("Y") || choice.equals("y")){
				My.p("\n\tPlease enter a custom price: ");
				price = key.nextInt();
			}
		}
		else if(compChoice == 3){
			newProduct.desc="i7 Gigabuster";
			price = 1500;
			My.p("\n\n\t You have chosen product 3. The default price is: " + price +
					"\n\t Change price? Y/N");
			String choice = key.next().toUpperCase();
			My.p("choice = " + choice);
			if(choice.equals("Y") || choice.equals("y")){
				My.p("\n\tPlease enter a custom price: ");
				price = key.nextInt();
			}
		}
		else{
			My.p("I'm sorry. You did not enter a valid option of computer. Please try again.");
			newTransaction();
		}
		My.p("\n\t Thank you for making a choice.");
		My.p("\n\t Please decide how you would like to pay for your purchase:");
		My.p("\n\t 1. By Cash");
		My.p("\n\t 2. By Credit");
		paymentOption = key.nextInt();
		if(paymentOption==1){
			My.p("\n\t Thank you for choosing to pay by Cash. The price of your machine is: " + price);
			My.p("\n\t As you have chosen to pay by cash up front, you will receive a discount.");
			int originalPrice=price;
			My.p("\n\t Your original price is:" + originalPrice);
			Cash.calcDisc(price);
			double finalPrice = Cash.finalPrice(price);

			newProduct.price = finalPrice;
		
			newProduct.productNumber = compChoice;
			My.p("" + newProduct.toString());
			My.p("\n This has been saved.");

			
			Transaction transaction = null;
			transaction.qty = 1;
			transaction.myProduct = newProduct;
			transaction.transactionNo = 1;
			currentTransactions[1] = transaction;
			
			
		}
		else if(paymentOption==2){
			My.p("\n\t You have chosen to pay monthly. Please state the number of months: 12/24/36 : ");
			int months = key.nextInt();
			My.p("\n\t Your price is " + price + "\n\t Please enter your deposit amount:");
			int deposit = key.nextInt();
			double interest = FinOpt.calcInterest(price);
			
			My.p("\n\t With interest, your total price will be:" + interest);
			double monthlyPayment = FinOpt.getMonthlyPayment(months, price, deposit);
			My.p("\n\t Based on a deposit of:" + deposit + "\n\t Your total monthly cost will be:" +monthlyPayment);
		}
		
		
	}
}
