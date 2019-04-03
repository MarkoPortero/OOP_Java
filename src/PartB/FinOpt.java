package PartB;

public class FinOpt {
	static double deposit;
	static double baseRate;
	int noOfYrs;
	
	public static void finalPrice(){
		
	}
	public static double calcInterestRate(int price){
		baseRate = 0.5;
		double newPrice = 0;
		int tempPrice = price;
		if(deposit<=200){
			baseRate=0.16;
		}
		else if(deposit>201 && deposit <=300){
			baseRate=0.12;
		}
		else if(deposit>=301){
			baseRate=0.08;
		}
		else if(deposit>500){
			baseRate=0.05;
		}
		newPrice = price+(tempPrice*baseRate);
		return newPrice;
	}
	public static double calcInterest(int price){
		double interest;
		calcInterestRate(price);
		interest = price*baseRate;
		
		return interest;
	}
	public static double getMonthlyPayment(int term, int price, int deposit){
		
		double monthlyPayment=0;
		
		monthlyPayment = (price-deposit)/term;
		
		return monthlyPayment;
	}
}
