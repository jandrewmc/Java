
public class Euler_Problem_7
{
	//this program finds the 10001'st prime number
	public static void main(String[] args)
	{
		primeNumberCounter();
	}
	
	public static void primeNumberCounter()
	{
		int GOAL_PRIME = 10001;
		int primeCounter = 0;
		
		for(long i = 2; i <= 100000000000000000L; i++)
		{
			for(long j = 2; j <= i; j++)
			{
				if(j == i)
				{
					++primeCounter;
					if(primeCounter == GOAL_PRIME)
					{
						System.out.println(i + " is the " + GOAL_PRIME + "st prime number!");
						System.exit(0);
					}
					break;
				}
				if(i % j == 0) break;
			}
		}
	}
}
