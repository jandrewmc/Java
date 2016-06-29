
public class Euler_Problem_5
{
	//this program finds the smallest positive number that is divisible by all the
	//numbers between 1 and 20
	public static void main(String[] args)
	{
		for(long i = 1; i <= 1000000000000000000L; i++)
		{		
			testForMultiple(i);
		}
	}
	public static void testForMultiple(long number)
	{
		for(int i = 20; i >= 10; i--)
		{
			if(number % i != 0) break;
			if(i == 10) 
			{
				System.out.println(number);
				System.exit(0);
			}
		}
	}
}
