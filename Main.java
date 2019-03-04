/**
 * A program that accepts input from the user as either a military time or a standard time.
 * The user is allowed to manipulate their time in many ways, and change the type between
 * the two.
 * 
 * UNCOMMENT RUNTESTCASES() TO SEE TESTCASES AND COMMENT EVERYTHING ELSE, DO OPPOSITE TO RUN USER
 * CODE
 * 
 * 
 * @author Antonia Nunley
 *
 */
import java.io.IOException;
import java.util.*;

class Main 
{

 private static Scanner scan = new Scanner (System.in);
  
 //The hour and minute of each time
 private static int userHour;
 private static int userMinute;
 //To be used as input for which type of time the user is inputting
 private static String type;
 private static String inputCommand;
 //Increment changes variables
 private static int userAddHour;
 private static int userAddMinute;
 //Decrement changes variables
 private static int userSubHour;
 private static int userSubMinute;
 //A handler to check if the type is aacceptable
 private static String tryAgain;
 //Create an array with all enum values
 Commands[] commands = Commands.values();
 
 public static void Welcome() throws InterruptedException{
   System.out.println("Enter a time, will it be military or standard? [\"military\"/\"standard\"]");
   type = scan.nextLine();
   if (type.equals("military") || type.equals("standard")) {
	   getInput();
   	} else {
   	 System.out.println ("Incorrect input, try again? [Y/N]");
	   tryAgain = scan.nextLine().toLowerCase();
	   if (tryAgain.equals("y")){
	       Welcome();
	   } else {
	       System.out.println("ENDING PROGRAM");
	       System.exit(0);
	   }
   	}
   
  }
 
 public static void showOptions(){
    System.out.println("______________\nCOMMANDS\n________________");
    System.out.println("INCREASE: increases the time by one minute, or designated hour and minute"
    		+ "\nDECREASE: decreases the time by one minute, or designated hour and minute"
    		+ "\nCONVERT: changes the type of time to the other"
    		+ "\nGETTIME: shows the time"
    		+ "\nGETMINUTE: shows the minute"
    		+ "\nSETHOUR: changes the hour to the number given"
    		+ "\nSETMINUTE: changes the minute to the number given"
    		+ "\nGETHOUR: shows the hour"
    		+ "\nHELP: show options"
    		+ "\nEXIT: exits program");
  }
    
 public static void getInput(){
    /*Do the same with hour and minutes, so that you can create an instance using
    * the user's requests
    */
   System.out.println("Enter the hour.");
   userHour = scan.nextInt();
   System.out.println("enter minutes.");
   userMinute = scan.nextInt();
 } 
 
 public static String getInputCommand() {
    	 return inputCommand; 
 }
 
 public static void setInputCommand() {
  	System.out.print("COMMAND: ");
  	inputCommand = scan.nextLine().toLowerCase();	
  }

 public static boolean checkCommand(String input) {
	 boolean exists = false;
	 //input = getInputCommand();
	 //Debug
	 //System.out.println("the boolean is " + exists + " Before checking");
     for(Commands command : Commands.values()) {
    	 	// Allow it to be null for the first time because theres nothing in it
         if(input.equalsIgnoreCase(command.name())) {
             //Debug
        	 	 //System.out.println("I have found the command:");
        	  	 exists = true;
             break;
          }
      }
     
     //Debug
     //System.out.println("After checking: the boolean is " + exists);
      //In case the command doesn't exist, allow them to try again
     if (!exists) {
         System.out.println("Command does not exist. Try again");
         getInputCommand();
     }
     //check if the command exists and return true if it does
     if (exists) {
    	 	return true;
     } else {
    	 	return false;
     }
 }

 public static void militaryTimeHandler(String command) {
	 /*Create an instance of the class with all of the input from the user*/
	 Time userTime = new MilitaryTime (type, userHour, userMinute);
     
	 if (command.equals("increase")){
         System.out.println("Would you like to increase by 1 minute, or more? \n To increase by one minute enter 0 1. To increase by more, type hours, then minutes.");
         userAddHour = scan.nextInt();
         userAddMinute = scan.nextInt();
         if (userAddHour == 0 && userAddMinute == 1){
             userTime.increment();
             //userTime.toString();
      	     //System.out.println ("This is where we would increment 1 minute");
          } else {
             userTime.increment(userAddHour, userAddMinute);
             //System.out.println ("This is where we would increment by " + userAddHour + " hours, and " + userAddMinute + " minutes.");
          }
      } else if (command.equals("decrease")){
         System.out.println("Would you like to decrease by 1 minute, or more? \n To decrease by one minute enter 0 1. To decrease by more, type hours, then minutes.");
         userSubHour = scan.nextInt();
         userSubMinute = scan.nextInt();
         if (userSubHour == 0 && userSubMinute == 0){
        	 	//System.out.println ("This is where we would decrement 1 minute");
             userTime.decrement();
          } else {
        		 //System.out.println ("This is where we would decrement by " + userSubHour + " hours, and " + userSubMinute + " minutes.");
             userTime.decrement(userSubHour, userSubMinute);
          }
      } else if (command.equals("convert")){
      		userTime.convert();
      		type = "standard";
      } else if (command.equals("gettime")){
      		System.out.println(userTime.toString());
      } else if (command.equals("gethour")) {
    	  		System.out.println(userTime.getHour());
      } else if (command.equals("getminute")) {
    	  	System.out.println(userTime.getMinute());
      } else if (command.equals("sethour")) {
    	  	System.out.print("Hour: ");
    	  	userTime.setHour(scan.nextInt());
      } else if (command.equals("setminute")) {
    	  	System.out.print("Minute: ");
    	  	userTime.setMinute(scan.nextInt());
      } else if (command.equals("help")){
      		showOptions();
      } else if (command.equals("exit")){
      		System.exit(0);
      }
 }
 
 public static void standardTimeHandler(String command) {
	 /*Create an instance of the class with all of the input from the user*/
	 Time userTime = new StandardTime (type, userHour, userMinute);
	 
	 if (command.equals("increase")){
         System.out.println("Would you like to increase by 1 minute, or more? \n To increase by one minute enter 0 1. To increase by more, type hours, then minutes.");
         userAddHour = scan.nextInt();
         userAddMinute = scan.nextInt();
         if (userAddHour == 0 && userAddMinute == 1){
             userTime.increment();
      	     //System.out.println ("This is where we would increment 1 minute");
          } else {
             userTime.increment(userAddHour, userAddMinute);
             //System.out.println ("This is where we would increment by " + userAddHour + " hours, and " + userAddMinute + " minutes.");
          }
      } else if (command.equals("decrease")){
         System.out.println("Would you like to decrease by 1 minute, or more? \n To decrease by one minute enter 0 1. To decrease by more, type hours, then minutes.");
         userSubHour = scan.nextInt();
         userSubMinute = scan.nextInt();
         if (userSubHour == 0 && userSubMinute == 0){
        	 	//System.out.println ("This is where we would decrement 1 minute");
             userTime.decrement();
          } else {
        		 //System.out.println ("This is where we would decrement by " + userSubHour + " hours, and " + userSubMinute + " minutes.");
             userTime.decrement(userSubHour, userSubMinute);
          }
      } else if (command.equals("convert")){
      		userTime.convert();
      		type = "military";
      } else if (command.equals("gettime")){
      		System.out.println(userTime.toString());
      }  else if (command.equals("gethour")) {
	  		System.out.println(userTime.getHour());
	  } else if (command.equals("getminute")) {
		  	System.out.println(userTime.getMinute());
	  } else if (command.equals("sethour")) {
		  	System.out.print("Hour: ");
		  	userTime.setHour(scan.nextInt());
	  } else if (command.equals("setminute")) {
		  	System.out.print("Minute: ");
		  	userTime.setMinute(scan.nextInt());
      }	else if (command.equals("help")){
      		showOptions();
      } else if (command.equals("exit")){
      		System.exit(0);
      }
 }

 public static void runTestCases() {
	 /*
	  * This method shows all test cases run
	  */
	 System.out.println("_____________________");
	 System.out.println("BEGINNING TEST CASES");
	 System.out.println("_____________________");
	 System.out.println("\nSTANDARD TIME");
	 Time time = new StandardTime("standard", 3, 45);
	 
	 System.out.println("Printing Hour: " + time.getHour());
	 System.out.println("Printing Minute: " + time.getMinute());
	 System.out.println("Incrementing 4 times" );
	 time.increment();
	 time.increment();
	 time.increment();
	 time.increment();
	 System.out.println("Printing Hour: " + time.getHour());
	 System.out.println("Printing Minute: " + time.getMinute());
	 System.out.println("Setting time back to 3:45");
	 time.setHour(3);
	 time.setMinute(45);
	 System.out.println("Printing hour: " + time.getHour());
	 System.out.println("Printing Minute: " + time.getMinute());
	 System.out.println("Decreasing time 4 times");
	 time.decrement();
	 time.decrement();
	 time.decrement();
	 time.decrement();
	 System.out.println("Printing hour: " + time.getHour());
	 System.out.println("Printing Minute: " + time.getMinute());
	 System.out.println("Incrementing by 3 hours and 5 minutes");
	 time.increment(3, 5);
	 System.out.println("Printing hour: " + time.getHour());
	 System.out.println("Printing Minute: " + time.getMinute());
	 System.out.println("Printing time: " + time.toString());
	 System.out.println("Setting time to 11:00");
	 time.setHour(11);
	 time.setMinute(0);
	 System.out.println("Time: " + time.toString());
	 System.out.println("Increasing time by 150 minutes (2.5 hours):");
	 time.increment(0, 150);
	 System.out.println("Time: " + time.toString());
	 //WRONG DOUBLES MINUTES
	 System.out.println("Making time 9:32");
	 time.setHour(9);
	 time.setMinute(32);
	 System.out.println("Increasing the time by 12 hours in minutes: ");
	 time.increment(0, 720);
	 System.out.println("Time: " + time.toString());
	 //WRONG DOUBLES MINUTES
	 System.out.println("Making time 9:32");
	 time.setHour(9);
	 time.setMinute(32);
	 System.out.println("Increasing the time by 24 hours in minutes: ");
	 time.increment(0, 1440);
	 System.out.println("Time: " + time.toString());
	 
	 System.out.println("\nMILITARY TIME");
	 
	 Time time2 = new MilitaryTime("military", 14, 55);
	 System.out.println("Printing Hour: " + time2.getHour());
	 System.out.println("Printing Minute: " + time2.getMinute());
	 System.out.println("Incrementing 4 times" );
	 time2.increment();
	 time2.increment();
	 time2.increment();
	 time2.increment();
	 System.out.println("Printing Hour: " + time2.getHour());
	 System.out.println("Printing Minute: " + time2.getMinute());
	 System.out.println("Setting time back to 1455");
	 time2.setHour(14);
	 time2.setMinute(55);
	 System.out.println("Printing hour: " + time2.getHour());
	 System.out.println("Printing Minute: " + time2.getMinute());
	 System.out.println("Decreasing time 4 times");
	 time2.decrement();
	 time2.decrement();
	 time2.decrement();
	 time2.decrement();
	 System.out.println("Printing Hour: " + time2.getHour());
	 System.out.println("Printing Minute: " + time2.getMinute());
	 System.out.println("Incrementing by 3 hours and 3 mintues");
	 time2.increment(3, 3);
	 System.out.println("Printing Hour: " + time2.getHour());
	 System.out.println("Printing Minute: " + time2.getMinute());
	 System.out.println("Setting time to complicated toString");
	 time2.setHour(7);
	 time2.setMinute(8);
	 System.out.println("Time into toString: " + time2.toString());
	 System.out.println("Setting time to 1100");
	 time2.setHour(11);
	 time2.setMinute(0);
	 System.out.println("Time: " + time2.toString());
	 System.out.println("Increasing time by 150 minutes (2.5 hours):");
	 time2.increment(0, 150);
	 System.out.println("Time: " + time2.toString());
	 //WRONG
	 System.out.println("Increasing the time by 12 hours in minutes: ");
	 time2.increment(0, 1440/2);
	 System.out.println("Time: " + time2.toString());
	 //WRONG
	 System.out.println("Increasing the time by 24 hours in minutes: ");
	 time2.increment(0, 1440);
	 System.out.println("Time: " + time2.toString());
	 
	 System.out.println("\nCOMPLICATED TEST CASES");
	 Time time3 = new MilitaryTime("military", 2, 59);
	 System.out.println("Printing Hour: " + time3.getHour());
	 System.out.println("Printing Minute: " + time3.getMinute());
	 System.out.println("Increasing time 4 times: ");
	 time3.increment();
	 time3.increment();
	 time3.increment();
	 time3.increment();
	 System.out.println("Checking if hour increased and minute increased");
	 System.out.println("Printing Hour: " + time3.getHour());
	 System.out.println("Printing Minute: " + time3.getMinute());
	 System.out.println("Setting time back to 0203");
	 time3.setHour(2);
	 time3.setMinute(3);
	 System.out.println("Printing Hour: " + time3.getHour());
	 System.out.println("Printing Minute: " + time3.getMinute());
	 System.out.println("Decreasing time 4 times: ");
	 time3.decrement();
	 time3.decrement();
	 time3.decrement();
	 time3.decrement();
	 System.out.println("Checking if hour increased and minute increased");
	 System.out.println("Printing Hour: " + time3.getHour());
	 System.out.println("Printing Minute: " + time3.getMinute());
	 System.out.println("Printing time: " + time3.toString());
	 
	 System.out.println("\nBEGINNING MILITARY EDGE TEST CASES");
	 Time time4 = new MilitaryTime("military", Integer.MAX_VALUE, Integer.MAX_VALUE);
	 System.out.println("New military time has been created with hour over 24 and minutes over 59");
	 System.out.println("Printing Hour: " + time4.getHour());
	 System.out.println("Printing Minutes: " + time4.getMinute());
	 System.out.println("Trying to change hour and minutes to negative numbers");
	 time4.setHour(Integer.MIN_VALUE);
	 time4.setHour(Integer.MIN_VALUE);
	 System.out.println("Printing Hour: " + time4.getHour());
	 System.out.println("Printing Minutes: " + time4.getMinute());
	 System.out.println("Changing time to be 0359");
	 time4.setHour(3);
	 time4.setMinute(59);
	 System.out.println("Printing Hour: " + time4.getHour());
	 System.out.println("Printing Minutes: " + time4.getMinute());
	 System.out.println("Decrementing time by 60 minutes/minute");
	 for (int i = 0; i < 60; i++) {
		 time4.decrement();
	 }
	 System.out.println("Printing Hour: " + time4.getHour());
	 System.out.println("Printing Minutes: " + time4.getMinute());
	 System.out.println("Setting time back to 0359");
	 time4.setHour(3);
	 time4.setMinute(59);
	 System.out.println("Printing Hour: " + time4.getHour());
	 System.out.println("Printing Minutes: " + time4.getMinute());
	 //WRONG HOUR AND MINUTE ARE WRONG
	 System.out.println("Decrementing time by 60 minutes");
	 time4.decrement(0, 60);
	 System.out.println("Printing Hour: " + time4.getHour());
	 System.out.println("Printing Minutes: " + time4.getMinute());
	 System.out.println("Setting time to 0200");
	 time4.setHour(2);
	 time4.setMinute(0);
	 System.out.println("Time is: " + time4.toString());
	 //WRONG NEED TO FIX METHOD
	 System.out.println("Decreasing time by 90 mintues");
	 time4.increment(0, -90);
	 System.out.println("Printing Hour: " + time4.getHour());
	 System.out.println("Printing Minutes: " + time4.getMinute());
	 
	 System.out.println("\nBEGINNING STANDARD EDGE TEST CASES");
	 Time time5 = new StandardTime("standard", Integer.MAX_VALUE, Integer.MAX_VALUE);
	 System.out.println("New standard time has been created with hour over 12 and minutes over 59");
	 System.out.println("Printing Hour: " + time5.getHour());
	 System.out.println("Printing Minutes: " + time5.getMinute());
	 System.out.println("Trying to change hour and minutes to negative numbers");
	 time5.setHour(Integer.MIN_VALUE);
	 time5.setHour(Integer.MIN_VALUE);
	 System.out.println("Printing Hour: " + time5.getHour());
	 System.out.println("Printing Minutes: " + time5.getMinute());
	 System.out.println("Changing time to be 3:59");
	 time5.setHour(3);
	 time5.setMinute(59);
	 System.out.println("Decrementing time by 60 minutes/minute");
	 for (int i = 0; i < 60; i++) {
		 time5.decrement();
	 }
	 System.out.println("Printing Hour: " + time5.getHour());
	 System.out.println("Printing Minutes: " + time5.getMinute());
	 System.out.println("Decrementing time by 60 minutes");
	 time4.decrement(0, 60);
	 System.out.println("Printing Hour: " + time5.getHour());
	 System.out.println("Printing Minutes: " + time5.getMinute());
	 System.out.println("Setting time to 2:00");
	 time5.setHour(2);
	 time5.setMinute(00);
	 //NOT WORKING BC METHOD ISNT WRITTEN
	 System.out.println("Decreasing time by hour and a half, but using 90 minutes");
	 time5.decrement(0, 90);
	 System.out.println("Printing Hour: " + time5.getHour());
	 System.out.println("Printing Minutes: " + time5.getMinute());
	 
	 
	 /*System.out.println("\nFAQ:");
	 System.out.println("User enters leading zeroes?");
	 System.out.println("Creating military time of 03 04");
	 Time time6 = new MilitaryTime("military", 03, 04);
	 System.out.println("Printing Hour: " + time6.getHour());
	 System.out.println("Printing Minutes: " + time6.getMinute());*/
 }

 public static void main(String str[]) throws IOException, InterruptedException
 {
	runTestCases(); 
	
	//Welcome();
	/*My psuedocoded understanding of this: 
	 * if the user enters military, show the options, then as long as the type is military,
	 * ask for a command, check to see if that command exists. If it does, do what it says do in the method.
	 * then when your done if the type is still military ask for a command...
	 */
	/*
	 * the entire main method can be in an infinite while loop because
	 * there are handlers for commands that exit the entire program.
	 * It must be in a while loop because it is not possible to convert
	 * from a standard time to a military time withot it.
	 */
	/*while (true) {
		if (type.equals("military")) {
			System.out.println("MILITARY TIME NOW");
			showOptions();
			while (type.equals("military")) {
				setInputCommand();
				if (checkCommand(getInputCommand())) {
						militaryTimeHandler(getInputCommand());
				}
			}
		}
		
		if (type.equals("standard")) {
			System.out.println("STANDARD TIME NOW");
			showOptions();
			while (type.equals("standard")) {
				setInputCommand();
				if (checkCommand(getInputCommand())) {
					standardTimeHandler(getInputCommand());	
				}
			}
		}
	}*/
 } 
}
/*
 * Commands that are working: 
 * MILITARY:			STANDARD:
 * Help				help
 * exit				exit
 * gettime			gettime
 * gethour			gethour	
 * getminute			getminute
 * convert			cconvert
 * 
 * 
 * Questions:
 * 	How do I make it so that the command prompt doesnt run twice the first time? I have tried initializing the
 *  variable to null, an actual value, an actual command, and no value and nothing works.
 * 
 *  How do i make it so that the values are changed? the military time handler creates a new instance of the class 
 *  each time, but even when I put the entire method in the main method, the value still doesnt save. For example:
 *  if i created a time of 7:45, and did increase, then did gettime it would say 7:45 and not 7:46
 * 
 * 	I cannot figure out the logic for the decrement methods in either class. You can run the test cases to see. Pls
 *  help. 
 *  
 *  Increase method works most times, but with huge numbers, like the day in minutes it doubles the mintues for some
 *  reason.
 *  
 */
