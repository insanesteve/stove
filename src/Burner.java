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
		timer = 0;		
	}

	public Temperature getTemperature(){
		return myTemperature;
	}

	public void plusButton(){
		timer = TIME_DURATION;
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
		timer = TIME_DURATION;
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

	public void updateTemperature(){
		if (timer > 0) timer --;

		else if (timer == 0){
			switch (myTemperature){
			case COLD: 
				if (mySetting == Setting.LOW){
					myTemperature = Temperature.WARM;
				}
				else if (mySetting == Setting.MEDIUM || mySetting == Setting.HIGH){
					myTemperature = Temperature.WARM;
					timer = TIME_DURATION;
				}
				break;
			case WARM: 
				if (mySetting == Setting.MEDIUM ){
					myTemperature = Temperature.HOT;
				}
				else if (mySetting == Setting.HIGH){
					myTemperature = Temperature.HOT;
					timer = TIME_DURATION;
				}
				else if (mySetting == Setting.OFF){
					myTemperature = Temperature.COLD;
				}
				break;
			case HOT:
				if (mySetting == Setting.HIGH){
					myTemperature = Temperature.BLAZING;
				}
				else if (mySetting == Setting.LOW){
					myTemperature = Temperature.WARM;
				}
				else if (mySetting == Setting.OFF){
					myTemperature = Temperature.WARM;
					timer = TIME_DURATION;
				}
				break;
			case BLAZING:
				if (mySetting == Setting.MEDIUM){
					myTemperature = Temperature.HOT;
				}
				else if (mySetting == Setting.LOW || mySetting == Setting.OFF){
					myTemperature = Temperature.HOT;
					timer = TIME_DURATION;
				}
				break;
			default:
				break;
			}

		}

	}

}
