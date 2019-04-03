package PartB;

public class Cash {
	static double discountRate;
	
	public static double calcDisc(int price){
		if(price <= 999){
			discountRate=0.05;
		}
		else if(price >= 1000 && price <= 1499){
			discountRate=0.1;
		}
		else if(price >= 1500){
			discountRate=0.15;
		}
		return price;
	}
	public static double finalPrice(int price){
		double discount;
		discount = price*discountRate;
		int originalPrice=price;
		
		price = (int) (price-discount);
		My.p("\n\t You saved a total of:" + discount);
		My.p("\n\t Your new price is:" + price);
		
		return price;
	
		
	}
}
