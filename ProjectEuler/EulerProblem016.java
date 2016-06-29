import java.math.*;
public class PowerDigitSum
{

	public static void main(String[] args)
	{
		calculatePowerDigitSum();	
	}
	
	public static void calculatePowerDigitSum()
	{
		BigInteger num = BigInteger.valueOf(2);
		
		num = num.pow(1000);
		
		String bigNumber = num.toString();
		
		char[] number = bigNumber.toCharArray();
		
		long sum = 0;
		for(int i = 0; i < number.length; i++)
		{
			sum += ((int) number[i]) - 48; 
		}
		System.out.println(sum);
	}
}
