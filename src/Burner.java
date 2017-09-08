public class Burner {
	private enum Temperature {
		BLAZING, HOT, WARM, COLD
	}
	
	public static final int TIME_DURATION = 2;
	private Temperature myTemperature;
	private Setting mySetting;
	private int timer;
	
	Burner (){
		myTemperature = Temperature.COLD;
		mySetting = Setting.OFF;
				
	}
	public Temperature getTemperature(){
		return myTemperature;
	}
	
	public void plusButton(){
		switch (mySetting){
		case OFF:
			mySetting = Setting.LOW;
			break;
		case LOW:
			mySetting = Setting.MEDIUM;
			break;
		case MEDIUM:
			mySetting = Setting.HIGH;
			break;
		default:
			break;
		}
	}
	
	public void minusButton(){
		switch (mySetting){
		case LOW:
			mySetting = Setting.OFF;
			break;
		case MEDIUM:
			mySetting = Setting.LOW;
			break;
		case HIGH:
			mySetting = Setting.MEDIUM;
			break;
		default:
			break;
		}
	}
	
	public void updateTemperture(){
		
		
	}
}
