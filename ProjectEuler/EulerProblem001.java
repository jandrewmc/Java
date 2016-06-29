public class Euler_Problem_1
{
	//sum of multiples of 3 and 5.  remember not to count the same numbers twice, i.e. 15, 30, 
	public static void main(String[] args)
	{
		int sumOfMultiplesOf3, sumOfMultiplesOf5;
		int totalSumOf3 = 0, totalSumOf5 = 0;
		int current3 = 3, current5 = 5;
		
		//sum of multiples of three not including the multiples of 5
		while(current3 < 1000)
		{
			if(current3 % 5  != 0) totalSumOf3 += current3;
			current3 += 3;
		}
		
		//sum of multiples of five
		while(current5 < 1000)
		{
			totalSumOf5 += current5;
			current5 += 5;
		}
		
		System.out.println("The sum of the multiples of 3 and 5 are: " + (totalSumOf3 + totalSumOf5));
	}//end main
}//end class
