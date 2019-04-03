package PartB;

public class Product {
	int productNumber;
	String desc;
	double price;
	
	public Product(){
		this.productNumber = 0;
		this.desc = "";
		this.price=0;
	}
	
	public Product(int productNumber, String desc, double price){
		this.productNumber=productNumber;
		this.desc=desc;
		this.price=price;
	}
	public int getProductNumber() {
		return productNumber;
	}
	public void setProductNumber(int productNumber) {
		this.productNumber = productNumber;
	}
	@Override
	public String toString() {
		return "Product [productNumber=" + productNumber + ", desc=" + desc + ", price=" + price + "]";
	}

	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
}
