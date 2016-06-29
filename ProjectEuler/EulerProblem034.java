import java.util.LongSummaryStatistics;

/**
 * Created by jandrewmc on 2/12/15.
 */
public class EulerProblem034
{
	public static void main(String[] args)
	{
		EulerProblem034 problem = new EulerProblem034();

		problem.calculate();
	}
	public void calculate()
	{
		int totalCuriousNumbers = 0;
		int number = 3;

		while(number < 100000)
		{
			int[] arrayOfFactorialValues = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};

			int totalSum = 0;
			int newNumber = number;

			while(newNumber != 0)
			{
				totalSum += arrayOfFactorialValues[newNumber % 10];
				newNumber /= 10;
			}

			if(totalSum == number)
			{
				totalCuriousNumbers++;
				System.out.println(totalSum);
			}

			number++;

		}
		System.out.println(totalCuriousNumbers);
	}
}
