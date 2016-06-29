
public class Euler_Problem_4
{
	
	//This program finds the largest product of two 3-digit numbers
	public static void main(String[] args) 
	{
	   System.out.println(largestPalindromeProduct(3));
	}
   
	public static int largestPalindromeProduct(int numDigits) 
	{
		int prod;
		int max = 0;
		int limit = (int)Math.pow(10, numDigits) - 1;
		
		for(int i=limit;i>0;i--)
			for(int j=limit;j>0;j--)
			{
				prod = i*j;
				if(isPalindrome(prod) && prod > max)
				max = prod;
			}
		System.out.println((System.currentTimeMillis() - time) / 1000.0 + " seconds");
		return max;
	}
   
	public static boolean isPalindrome(int p) 
	{
		int orig = p;
		int reverse = 0;
		while(p > 0)
		{
			reverse *= 10;
			reverse += p%10;
			p = p/10;
		}
      
		if(orig == reverse) return true;
      
		return false;
	}

}