public class Burner {
	private enum Temperature {
		BLAZING, HOT, WARM, COLD
	}
	public static final int TIME_DURATION = 2;
	private Temperature myTemperature;
	private Setting mySetting;
	private int timer;
	
	public Temperature getTemperature(){
		return myTemperature;
	}
	
	
}
