
public class LongestCollatzSequence
{
	public static long time = 0;
	
	public static void main(String[] args)
	{
		time = System.currentTimeMillis();
		sequence();
	}
	
	public static void sequence()
	{
		long count = 0;
		long number = 0;
		int startingNumber = 0;
		int finalNumber = 0;
		long finalCount = 0;
		
		for(int i = 1; i < 1000000; i++)
		{
			startingNumber = i; 
			number = i;
			count = 0;
			
			while(number != 1)
			{	
				if(number % 2 == 0) number = number / 2;
				else number = ((3 * number) + 1);
				
				count++;
			}
			if(count > finalCount)
			{
				finalCount = count;
				finalNumber = startingNumber;
			}
		}
		System.out.println(finalNumber);
		System.out.println((System.currentTimeMillis() - time) / 1000.0 + " seconds.");
	}
}
