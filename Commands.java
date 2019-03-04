/**
 * An enum to hold all commands the user can enter. This is used to make it
 * easier to access, and not have to use many if statements. 
 */
public enum Commands
{
    INCREASE, DECREASE, CONVERT, GETTIME, GETMINUTE, SETHOUR, SETMINUTE, GETHOUR, HELP, EXIT
}
/*
 * Increase: increases the time by one minute, or designated hour and minute
 * 		-increment() or increment(hr, min)
 * Decrease: decreases the time by one minute, or designated hour and minute
 * 		-decrement() or decrement(hr, min)
 * Convert: changes the type of time to the other
 * 		-convert()
 * GetTime: shows the time 
 * 		-toString()
 * GetHour: shows the hour
 * 		-getHour()
 * GetMinute: shows the minute
 * 		-getMinute()
 * SetHour: changes the hour to the number given
 * 		-setHour(hr)
 * SetMinute: changes the minute to the number given	
 * 		-setMinute(min)
 * Help: displays the rules and commands 
 * 		-showMilitaryOpeions() or showStandardOptions()
 * Exit: exit program
 * 		- System.exit(0)
 */
