import java.math.BigInteger;
public class FactorialDigitSum
{
	public static void main(String[] args)
	{
		
		//char[] charArray = factorial("100").toCharArray();
		long time = System.currentTimeMillis();
		System.out.println(factorial("10000"));
		System.out.println((System.currentTimeMillis() - time) / 1000.0);
		
		/*
		long sum = 0;
		
		for(int i = 0; i < charArray.length; i++)
		{
			sum += (((int) charArray[i]) - 48); 
		}
		
		System.out.print(sum);
		*/
	}
	
	public static String factorial(String number)
	{
		int numberInInt = Integer.parseInt(number);
	
		BigInteger num1 = new BigInteger(number);
		BigInteger sum = new BigInteger("1");
	
		for(int i = numberInInt; i > 0; i--)
		{
			sum = sum.multiply(num1);
			num1 = num1.subtract(BigInteger.ONE);
		}
		
		String value = sum.toString();
		
		return value;
	}
}
