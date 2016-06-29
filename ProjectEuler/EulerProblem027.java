/**
 * Created by jandrewmc on 2/1/15.
 */
import java.math.*;
public class EulerProblem027
{
    public static void main(String[] args)
    {
        EulerProblem027 problem = new EulerProblem027();

        problem.calculate();
    }
    public void calculate()
    {
        final int MAX_A = 1000;
        final int MAX_B = 1000;
        final int MIN_A = -999;
        final int MIN_B = -999;

        int maxN = 0;
        long productOfAAndB = 0;

        for(int a = MIN_A; a < MAX_A; a++)
        {
            for(int b = MIN_B; b < MAX_B; b++)
            {
                int certainty = 100;
                int n = 0;
                while(true)
                {
                    BigInteger number = new BigInteger(Integer.toString((n * n) + (a * n) + b));

                    if (!isProbablyPrime(number, certainty))
                    {
                        break;
                    }
                    n++;
                }
                if(n >= maxN)
                {
                    productOfAAndB = a * b;
                    maxN = n;
                }
            }
        }
        System.out.println(maxN + " " + productOfAAndB);
    }
    public boolean isProbablyPrime(BigInteger number, int certainty)
    {
        return number.isProbablePrime(certainty);
    }
}
