/**
 * Created by jandrewmc on 2/2/15.
 */
import java.math.BigInteger;
import java.util.ArrayList;
public class EulerProblem32
{
    ArrayList array = new ArrayList();

    public static void main(String[] args)
    {
        EulerProblem32 problem = new EulerProblem32();
        problem.calculate();
    }
    public void calculate()
    {
        final int MAX = 9999;
        BigInteger totalSum = new BigInteger("0");
        for(int multiplicand = 0; multiplicand < MAX; multiplicand++)
        {
            for(int multiplier = 0; multiplier < MAX; multiplier++)
            {
                int product = multiplicand * multiplier;
                String number = product + "" + multiplicand + "" + multiplier;
                if(number.length() == 9)
                {
                    if(isPandigital(number, product))
                    {
                        totalSum = totalSum.add(BigInteger.valueOf(product));
                    }
                }
            }
        }
        System.out.println(totalSum);
    }
    public boolean isPandigital(String number, int product)
    {
        if(number.contains("1") && number.contains("2") && number.contains("3") && number.contains("4") && number.contains("5")
                && number.contains("6")  && number.contains("7") && number.contains("8") && number.contains("9"))
        {
            if(!array.contains(product))
            {
                array.add(product);
                return true;
            }
        }
        return false;
    }
}
