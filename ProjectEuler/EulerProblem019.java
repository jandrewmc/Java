
public class CountingSundays
{
	public static void main(String[] args)
	{
		boolean isLeapYear = false;
		
		int[] daysInMonth = {31,28,31,30,31,30,31,31,30,31,30,31};		
		
		int currentDay = 1;
		int count = 0;
		for(int currentYear = 1900; currentYear <= 2000; currentYear++)
		{
			//leap year calculation
			isLeapYear = false;
			if(currentYear % 100 == 0)
			{	
				if(currentYear % 400 == 0) isLeapYear = true;
			}
			else if(currentYear % 4 == 0) isLeapYear = true;
			
			if(isLeapYear) daysInMonth[1] = 29;
			else daysInMonth[1] = 28;
			
			if(currentYear == 2000)
			{
				for(int i = 0; i < 11; i++)
				{
					currentDay += daysInMonth[i];
					
					if(currentDay % 7 == 0 && currentYear > 1900) ++count;
				}
				break;
			}
			
			for(int i = 0; i < 12; i++)
			{
				currentDay += daysInMonth[i];
				
				if(currentDay % 7 == 0 && currentYear > 1900) ++count;
			}//end for			
		}//end for	
		System.out.println(count);
	}//end main
}//end class
