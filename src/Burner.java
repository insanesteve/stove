/*	CSCI306: CO6 - Stove Exercise
 *	AUTHORS: Stephen Agee and Easton Bornemeier
 *	PURPOSE: This class defines a single burner, which contains various settings and attributes. Multiple burners can be used to model a stove.
 */

public class Burner {
	//Define enum for temperature of burner
	public enum Temperature {
		BLAZING, HOT, WARM, COLD
	}
	//define constant for duration of time it takes to heat/cool the burner
	public static final int TIME_DURATION = 2;
	
	
	private Temperature myTemperature;
	private Setting mySetting;
	private int timer;

	Burner (){
		//burners are initially cold, off, and the timer is reset.
		myTemperature = Temperature.COLD;
		mySetting = Setting.OFF;
		timer = 0;		
	}

	public Temperature getTemperature(){
		return myTemperature;
	}

	
	public void plusButton(){
		//start the timer when set point changed
		timer = TIME_DURATION;
		//switch statement to set the burner to the proper next setting if turning the burner up
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
		//start the timer when set point changed
		timer = TIME_DURATION;
		//switch statement to set the burner to the proper next setting if turning the burner up
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
		//if the timer is above 0, we still need to wait
		if (timer > 0) timer --;
		
		//if the timer is 0, we can implement the temperature changes
		if (timer == 0){
			switch (myTemperature){
			/*
			a switch statement for each current temperature
			we also need to check to see what the setting is so the burner moves in the proper direction
			these if statements, although long, should be make sense
			*/
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

	public void printStatus() {
		//print the status using the correct format from the rubric
		System.out.print(mySetting + ".....");
		switch(myTemperature){
		case COLD:
			System.out.println("cooool");
			break;
		case WARM:
			System.out.println("warm");
			break;
		case HOT:
			System.out.println("CAREFUL");
			break;
		case BLAZING:
			System.out.println("VERY HOT! DON'T TOUCH");
			break;
		default:
			break;
		}
		
	}

}
