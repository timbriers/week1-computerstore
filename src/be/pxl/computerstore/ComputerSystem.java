package be.pxl.computerstore;

import be.pxl.computerstore.hardware.*;
import be.pxl.computerstore.util.Computable;
import be.pxl.computerstore.util.TooManyPeripheralsException;

public class ComputerSystem implements Computable{
	
	private Processor processor;
	private ComputerCase computerCase;
	private Peripheral computerPeripherals []; 
	private int temp = 0;
	public static final int MAX_PERIPHERAL = 3;
	
	public ComputerSystem(){
		computerPeripherals = new Peripheral[3];
	}
	
	
	
	public Processor getProcessor() {
		return processor;
	}



	public ComputerCase getComputerCase() {
		return computerCase;
	}



	public void setProcessor(Processor processor) {
		this.processor = processor;
	}



	public void setComputerCase(ComputerCase computerCase) {
		this.computerCase = computerCase;
	}



	public void addPeripheral(Peripheral peripheral) throws TooManyPeripheralsException{
		if (temp < MAX_PERIPHERAL){
			computerPeripherals[temp] = peripheral;
			temp++;
		} else {
			throw new TooManyPeripheralsException("Peripherals reached maximum ammount of 3");
		}
	}
	/*// waarom werkt dit niet??
	public void addPeripheral(Peripheral peripheral){
		try {
		if (temp < MAX_PERIPHERAL){
			computerPeripherals[temp] = peripheral;
			temp++;
		} else {
			throw new TooManyPeripheralsException();
		}
		
	    }
		catch(TooManyPeripheralsException ex){
			System.out.println("Peripherals reached maximum ammount");
			ex.toString();
		}
	
	}
	*/
	
	public void removePeripheral(String articleNumber){
		for(int i = 0; i < computerPeripherals.length; i++){
			if(computerPeripherals[i] != null){
			if(computerPeripherals[i].getArticleNumber().equals(articleNumber)){
				computerPeripherals[i] = null;
			} else {
				System.out.println("no such articleNumber");
			}
		}
	  }
	}
	
	public int getNumberOfPeripherals(){
		temp = 0;
		for(int i = 0; i < computerPeripherals.length; i++){
			if (computerPeripherals[i] != null){
				temp++;
			}
		}
		return temp;
	}



	public Peripheral [] getPeripherals() {
		return computerPeripherals;
	}



	@Override
	public double totalPriceExcl() {
		double temp = computerCase.getPrice() + processor.getPrice();
		for(int i = 0; i<computerPeripherals.length; i++){
			if(computerPeripherals[i] != null){
				temp += computerPeripherals[i].getPrice();
			}
		}
		return temp;
	}
	
	public double totalPriceIncl() {
		return totalPriceExcl() *1.21;
	}

	public String toString(){
		String temp ="";
		for(int i=0; i<computerPeripherals.length; i++){
			if(computerPeripherals[i]!= null){
				temp+="Randapparaat"+i+1+":\n"+computerPeripherals[i].toString()+"\n";
			}
		}
		return "ComputerCase:\n" + computerCase.toString()+
				"\nProcessor:\n" + processor.toString() + temp 
				+ "Totaal EXCL.: "+ totalPriceExcl()
				+ "\nTotaal INCL.:"+ totalPriceIncl();
				
	}

}
