/**
 * Abstract class that defines all of the methods to be used in both the MilitaryTime class
 * and the StandardTime class. It also defines all variables that the classes share as 
 * public so that if the user changes the type the variables stay the same. 
 */
public abstract class Time
{
     public int hour;
     public int minute;
     public String timetype;
     public boolean isAm;
     
     
     //allow the user to increase time by 1 minute
     public abstract void increment();
     
     //allow the user to increase time by their designated hour and minute
     public abstract void increment(int plusHour, int plusMinute);
     
     //allow the user to decrease the time by 1 minute
     public abstract void decrement();
     
     //allow the user to decrease time by their designated hour and minute 
     public abstract void decrement(int subHour, int subMinute);
     
     //allow the user to access their hour or minute randomly
     public abstract int getMinute();
     public abstract int getHour();
     
     //allow the user to change the hour or minute randomly
     public abstract void setMinute(int hr);
     public abstract void setHour(int min);
     
     //allow the user to show their time as it is shown in the media
     public abstract String toString();
     
     /*
      * Returns the time as a String converted from military time 
      * to standard time. 
      */ 
     //HERE FIGURE OUT HOW TO CHANGE THE TIME TYPE SO IT GOES TO THE OPPOSITE TIME
     public String convert()
     {
       String returnHours;
       String returnMinutes;
       if (hour < 13 && hour >= 1) {
         returnHours = "" + hour;
       } else if (hour == 0) {
         returnHours = "" + 12;
       }else {
         int holdhours = hour-12;
         returnHours = "" + holdhours;
       }
       if (minute < 10) {
         returnMinutes = ":0"+minute;
       }else {
         returnMinutes = ":"+minute;
       } 
       
       return returnHours + returnMinutes;
        
     }
     //Allow the user to ask which time they are working with
     public String getTimeType (){
         return timetype;
        }

	
      
}
/*
 * Complete
*/
