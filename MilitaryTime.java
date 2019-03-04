/**
 * Military time class that implements all of the methods pertaining to 
 * a military time type.
 */
public class MilitaryTime extends Time
{
    //DONE
    public MilitaryTime() {
        hour = 0;
        minute = 0;
    }
     /*
      * Input is entered as military time
      * If h is between 1 and 23 inclusive, set the hour to h. 
      * Otherwise, set the hour to 1. If m is between 0 and 59 inclusive, 
      * set the minutes to m. Otherwise, set the minutes to 0. 
      * Check if its pm or am
      */ 
    //DONE
    public MilitaryTime(String t, int h, int m) {
       
        timetype = t;
        if (h > 0 && h < 24){
            hour = h;
         }else {
            hour = 1;
         } 
        if (m >= 0 && m < 60){
            minute = m;
         }else {
            minute = 0;
         }
         
        if (hour < 13) {
            isAm = true;
        } else {
            isAm = false;
        }  
    }
    
    //DONE
    /*
     * Advances the time by one minute. 
     */ 
    public void increment()
    {
      if (minute < 59) {
         minute++;
      }else if (minute == 59 && hour == 23) {
         minute = 0;
         hour = 0;
      }else {
         minute = 0;
         hour++;
      }  
    }

    public void increment(int plusHour, int plusMinute){
    		//Create a variable that adds the requested minutes to the already minute time so you can check hour changes 
    		int changeMinutes = minute + plusMinute;
    		if (changeMinutes % 60 == changeMinutes) {
    			minute += plusMinute;
    		} else if (changeMinutes % 60 != changeMinutes) {
    			minute += changeMinutes % 60;
    			//Make sure the hour changes to 0 if it becomes 25
    			if (hour + (changeMinutes / 60) < 25) {
    				hour += changeMinutes / 60; 
    			} else {
    				//Check logic here im not sure if this is correct
    				hour = (hour + (changeMinutes / 60)) - 24;
    			}
    		}
    		//Change the hours
    		int changeHours = hour + plusHour;
    		if (changeHours < 25) {
    			hour = changeHours;
    		} else {
    			// Use modulus so that way there is no need to constantly divide
    			hour = changeHours % 24;
    		}
    }
    
    //DONE
    /*
     * Decreases the time by one minute. 
     */ 
    public void decrement(){
    		if (minute > 0) {
            minute--;
         }else if (minute == 0 && hour == 0) {
            minute = 59;
            hour = 23;
         }else {
            minute = 59;
            hour--;
         } 
    }
   
    public void decrement(int subHour, int subMinute){
    	//Create a variable that subtracts the requested minutes from the already minute time so you can check hour changes 
		int changeMinutes = minute - subMinute;
		if (changeMinutes > 0) {
			minute = changeMinutes;
		}
		//HELP IDK HOW TO FIX THIS
		else if (changeMinutes % 60 != minute) {
			minute += changeMinutes % 60;
			//Make sure the hour changes to 0 if it becomes 24
			if (hour + (changeMinutes / 60) < 24) {
				hour += changeMinutes / 60; 
			} else {
				//FIND A WAY TO SAY HOUR = 0 + THE AMOUNT OF HOURS LEFT AFTER HOURS = 24
			}
		}
		//Change the hours
		int changeHours = Math.abs(hour - subHour);
		if (changeHours > 0) {
			hour = changeHours;
		} else {
			// Use modulus so that way there is no need to constantly divide
			hour = changeHours % 24;
		}
    }
    //DONE
    public int getHour() {
		return hour;
    }
    //DONE
    public int getMinute() {
		return minute;
    }
    //DONE
    public void setHour(int hr) {
		if (hr > 0 && hr <= 24) {
			hour = hr;
		}
    }
    //DONE
    public void setMinute(int min) {
		if (min >= 0 && min < 60) {
			minute = min;
		}
    }
    //DONE
    public String toString() {
      String hourString = "" + hour;
      String minString = "" + minute;
      String returnHours;
      String returnMinutes;
     
      //System.out.println();
       if (hourString.length() == 1) {
         returnHours = "0"+hour;
       }else{
         returnHours = "" + hour;
       }
       
       if (minString.length() == 1) {
         returnMinutes = "0"+minute;
       }else{
         returnMinutes = "" + minute;
       }

       return returnHours + returnMinutes;	
    }
    
   
           
    
}
/*
 * Complicated increment and decrement still to do
 */
