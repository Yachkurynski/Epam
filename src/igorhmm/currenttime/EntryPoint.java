package igorhmm.currenttime;

/**
 * Entry point to software to get current time,
 * No input parameters from CL are used
 */
public class EntryPoint{
	public static void main(String[] args){
		System.out.println("Current time is " + CurrentTime.getTime("HH:mm")); //TODO: make time format as constant value
	}
}