package be.pxl.computerstore.hardware;

public class Keyboard extends Peripheral{
	
	private static String keyboardLayout;

	

	public Keyboard(String vendor, String name, double price, String keyboardLayout){
		super(vendor,name,price);
		setKeyboardLayout(keyboardLayout);
	}

	public String getKeyboardLayout() {
		return keyboardLayout;
	}

	public void setKeyboardLayout(String keyboardLayout) {
		if(keyboardLayout.toUpperCase().equals("AZERTY") || keyboardLayout.toUpperCase().equals("QWERTY")){
			this.keyboardLayout = keyboardLayout;
		} else {
			System.out.println("Only AZERTY or QWERTY is accepted");
		}
	}

}
