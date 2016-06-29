
public class Euler_Problem_3
{
	//this program is suppose to find the largest prime factor of 600851475143
	public static void generateLargestPrimeFactor(long number)
	{
		//if you divide a number by its smallest factor, then find its next
		//smallest factor, the resultant prime number will be the largest
		//prime factor.
		for(long i = 2; i < (long) Math.sqrt(number); i++)
		{
			if(number % i == 0) number = number / i;
		}
		System.out.println(number);
	}
	public static void main(String[] args)
	{
		generateLargestPrimeFactor(600851475143L);
	}
}
