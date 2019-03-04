/**
 * Standard time class that implements all of the methods pertaining to 
 * a standard time type.
 */

public class StandardTime extends Time
{
   
	//DONE
    public StandardTime() {
        hour = 1;
        minute = 0;
    }
    //DONE
    public StandardTime(String t, int h, int m) {
        timetype = t;
        
        if (h <= 12 && h >= 1) {
        		hour = h;
        } else {
        		hour = 1;
        }
        
        if (m < 60 && m >= 0) {
        		minute = m;
        } else {
        		minute = 0;
        }
    }
    //DONE
    public void increment(){ 
    		if (minute < 59) {
    			minute ++;
    		} else if (hour+1 < 12) {
    			hour++;
    			minute = 0;
    		} else if (hour == 12) {
    			hour = 1;
    			minute = 0;
    		}
    }
    
    public void increment(int plusHour, int plusMinute){
    		int changeMinutes = minute + plusMinute;
		if (changeMinutes % 60 == changeMinutes) {
			minute += plusMinute;
		} else if (changeMinutes % 60 != changeMinutes) {
			minute += changeMinutes % 60;
			//Make sure the hour changes to 0 if it becomes 13
			if (hour + (changeMinutes / 60) < 13) {
				hour += changeMinutes / 60; 
			} else {
				//Check logic here im not sure if this is correct
				hour = (hour + (changeMinutes / 60)) - 12;
			}
		}
		//Change the hours
		int changeHours = hour + plusHour;
		if (changeHours < 13) {
			hour = changeHours;
		} else {
			// Use modulus so that way there is no need to constantly divide
			hour = changeHours % 12;
		}
    }
    //DONE
    public void decrement(){
    		if (minute > 0) {
    			minute--;
    		} else if (hour - 1 > 0) {
    			hour--;
    			minute = 59;
    		} else if (hour == 1) {
    			hour = 12;
    			minute = 59;
    		}
    }
   
    public void decrement(int subHour, int subMinute){
    		int changeMinutes = subMinute + minute;
   
    		if (changeMinutes ==  60) {
    			minute = 0;
    		} else if (changeMinutes != 60) {
    			minute = changeMinutes % 60;
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
    		if (hr > 0 && hr <= 12) {
    			hour = hr;
    		}
    		//there is no need for an else statement because the hour is already set
    }
    //DONE
    public void setMinute(int min) {
    		if (min >= 0 && min < 60) {
    			minute = min;
    		} 
    		//there is no need for an else statement because the hour is already set
    }
	//DONE
	public String toString() {
	  String hourString = "" + hour;
      String minString = "" + minute;
      //there is no need to make a returnHour variable because standard times allow single digit hours
      String returnMinutes;
     
      //System.out.println();
       
       if (minString.length() == 1) {
         returnMinutes = ":0"+minute;
       }else{
         returnMinutes = ":" + minute;
       }
       
       
       return hourString + returnMinutes;
	
	}

}

/* 
 * complicated increment and decrement still to do
 */