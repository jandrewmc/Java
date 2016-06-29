
public class SumOfPrimes
{
	public static long time;
	
	public static void main(String[] args)
	{
		time = System.currentTimeMillis();
		sumOfPrimeNumbers();
	}
	
	public static void sumOfPrimeNumbers()
	{
		long sum = 0;
		
		for(long i = 2; i <= 2000000; i++)
		{
			for(long j = 2; j <= i; j++)
			{
				if(i == j) 
				{
					sum += i;
					System.out.println(sum);
				}
				if(i % j == 0) break;
			}
		}
		System.out.println(sum);
		System.out.println((System.currentTimeMillis() - time) / 1000 + " seconds");
	}
}
