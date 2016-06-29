
public class HighlyDivisibleTriangularNumber
{

	public static long time = 0;
	
	public static void main(String[] args)
	{
		time = System.currentTimeMillis();
		triangularNumber();
	}

	public static void triangularNumber()
	{
		long count = 0;
		long whatTriangleNumber = 3;
		long bigTriangleNumber = 6;
		
		long TERMINATE_VALUE = 500;
		
		for(long triangleNumber = 4; triangleNumber < 9223372036854775807L; triangleNumber++)
		{
			count = 2; 
			whatTriangleNumber++;
			bigTriangleNumber += triangleNumber;
			
			long numberLimit = (long) Math.sqrt(bigTriangleNumber);
			
			for(long i = 2; i < numberLimit; i++)
			{
				if(bigTriangleNumber % i == 0)
				{
					count++;
					count++;
				}
				if(count == TERMINATE_VALUE)
					break;
			}
			if(count == TERMINATE_VALUE)
				break;
		}
		
		if(count == TERMINATE_VALUE)
		{
			System.out.println("The number is: " + bigTriangleNumber);
			System.out.println((System.currentTimeMillis() - time) / 1000.0 + " seconds.");
		}
	}
}
