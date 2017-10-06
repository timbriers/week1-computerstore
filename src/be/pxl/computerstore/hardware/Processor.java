package be.pxl.computerstore.hardware;

public class Processor extends ComputerHardware{
	private double clockspeed;


	public Processor(String vendor, String name, double price, double clockspeed) {
		super(vendor,name,price);
		setClockspeed(clockspeed);
	}


	public double getClockspeed() {
		return this.clockspeed;
	}

	public void setClockspeed(double clockspeed) {
		if(clockspeed < 0.7){
			this.clockspeed = 0.7;
		} else {
			this.clockspeed = clockspeed;
			
		}
			
	}
	public String toString(){
	      return super.toString() +
	    		 "\nClock speed = " + getClockspeed()+ "GHz";
	}
}
