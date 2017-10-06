package be.pxl.computerstore.util;

public class TooManyPeripheralsException extends Exception {
	
	public TooManyPeripheralsException(){
		
	}
	
	public TooManyPeripheralsException(String message){
		super(message);
	}

}
