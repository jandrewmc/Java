/**
 * Created by jandrewmc on 2/12/15.
 */
import java.math.BigInteger;

public class EulerProblem033
{
	public static void main(String[] args)
	{
		EulerProblem033 problem = new EulerProblem033();

		problem.calculate();
	}
	public void calculate()
	{
		int totalNumerator = 1;
		int totalDenominator = 1;

		for(int d = 10; d < 100; d++)
		{
			for(int n = 10; n < d; n++)
			{
				String numerator = Integer.toString(n);
				String denominator = Integer.toString(d);

				char[] numeratorToCharArray = numerator.toCharArray();
				char[] denominatorToCharArray = denominator.toCharArray();

				if((numerator.contains("0") && denominator.contains("0")))
				{
					continue;
				}

				if((numeratorToCharArray[0] == denominatorToCharArray[0]) && denominatorToCharArray[1] != '0')
				{
					double currentFraction = Double.parseDouble(numeratorToCharArray[1] + "") / Double.parseDouble(denominatorToCharArray[1] + "");
					double originalFraction = Double.parseDouble(numerator) / Double.parseDouble(denominator);

					if(currentFraction == originalFraction)
					{
						totalNumerator *= Double.parseDouble(numerator);
						totalDenominator *= Double.parseDouble(denominator);
						continue;
					}
				}
				else if((numeratorToCharArray[0] == denominatorToCharArray[1]) && denominatorToCharArray[0] != '0')
				{
					double currentFraction = Double.parseDouble(numeratorToCharArray[1] + "") / Double.parseDouble(denominatorToCharArray[0] + "");
					double originalFraction = Double.parseDouble(numerator) / Double.parseDouble(denominator);

					if(currentFraction == originalFraction)
					{
						totalNumerator *= Double.parseDouble(numerator);
						totalDenominator *= Double.parseDouble(denominator);
						continue;
					}
				}
				else if((numeratorToCharArray[1] == denominatorToCharArray[0]) && denominatorToCharArray[1] != '0')
				{
					double currentFraction = Double.parseDouble(numeratorToCharArray[0] + "") / Double.parseDouble(denominatorToCharArray[1] + "");
					double originalFraction = Double.parseDouble(numerator) / Double.parseDouble(denominator);

					if(currentFraction == originalFraction)
					{
						totalNumerator *= Double.parseDouble(numerator);
						totalDenominator *= Double.parseDouble(denominator);
						continue;
					}
				}
				else if((numeratorToCharArray[1] == denominatorToCharArray[1]) && denominatorToCharArray[0] != '0')
				{
					double currentFraction = Double.parseDouble(numeratorToCharArray[0] + "") / Double.parseDouble(denominatorToCharArray[0] + "");
					double originalFraction = Double.parseDouble(numerator) / Double.parseDouble(denominator);

					if(currentFraction == originalFraction)
					{
						totalNumerator *= Double.parseDouble(numerator);
						totalDenominator *= Double.parseDouble(denominator);
						continue;
					}
				}
			}
		}

		BigInteger bNumerator = new BigInteger(totalNumerator + "");
		BigInteger bDenominator = new BigInteger(totalDenominator + "");

		BigInteger gcdItem = bNumerator.gcd(bDenominator);

		System.out.println(bDenominator.divide(gcdItem));
	}
}