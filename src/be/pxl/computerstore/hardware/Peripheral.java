package be.pxl.computerstore.hardware;

public abstract class Peripheral extends ComputerHardware{
	

	public Peripheral(String vendor, String name, double price){
		super(vendor,name,price);
	}
	
	public String getShortDescription(){
		return getArticleNumber() + " * "+ getClass().getSimpleName() + " * " + getName() + " * " + getPrice()+"€";
	}
	
}
