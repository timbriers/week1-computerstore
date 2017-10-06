package be.pxl.computerstore.hardware;

import java.util.Random;

public abstract class ComputerHardware {

	private String vendor;
	private String name;
	private double price;
	private String number;
	
	public ComputerHardware(String vendor, String name, double price){
		this.vendor = vendor;
		this.name = name;
		this.price = price;
		this.number = createArticleNumber();
	}

	public String getVendor() {
		return vendor;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}
	
	public String getArticleNumber(){
		return number;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public String createArticleNumber(){
		Random rand = new Random();
		String artikelNummer = vendor;
		int randomNumber;
		while (artikelNummer.length() < 3){
			artikelNummer += "X";
		}
		artikelNummer = artikelNummer.substring(0,3).toUpperCase() + "-";
		artikelNummer += rand.nextInt(90000)+10000 + "-";
		randomNumber = rand.nextInt(900)+100;
		String tempGetal = Integer.toString(randomNumber);
		while (tempGetal.contains("0")){
			randomNumber = rand.nextInt(900)+100;
			tempGetal = Integer.toString(randomNumber);
		}
		number =  artikelNummer += tempGetal;
		return number;
    }
	
	public String toString(){
		return "ArticleNumber = " + getArticleNumber() +
			   "\nVendor = " + getVendor() +
			   "\nName = " + getName() +
			   "\nPrice = " + getPrice();	
	}
	
	public String getShortDescription(){
		return getArticleNumber()+" * "+getName()+" * "+ getPrice()+"€";
	}
}