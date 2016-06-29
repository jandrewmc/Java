public class Euler_Problem_2
{
	//Sum of the even fibonacci numbers less that 4 million
	public static void main(String[] args)
	{
		long firstFib = 1, secondFib = 1, nextFib = 0, total = 0;
		
		while(nextFib < 4000000)
		{
			nextFib = firstFib + secondFib;
			
			if(nextFib % 2 == 0) total += nextFib;
			
			firstFib = secondFib;
			secondFib = nextFib;
		}		
		
		System.out.println("The sum of all the even Fibonacci numbers less than 4 million is: " + total);
	}//end main
}//end class