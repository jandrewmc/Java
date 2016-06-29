/**
 * Created by jandrewmc on 2/1/15.
 */
import java.math.BigInteger;
import java.util.ArrayList;
public class EulerProblem029
{
    public static void main(String[] args)
    {
        EulerProblem029 problem = new EulerProblem029();
        problem.calculate();
    }
    public void calculate()
    {
        final int MIN = 2;
        final int MAX = 100;

        ArrayList array = new ArrayList();

        for(int i = MIN; i <= MAX; i++)
        {
            for(int j = MIN; j <= MAX; j++)
            {
                BigInteger number = new BigInteger(Integer.toString(i));
                number = number.pow(j);

                if(!array.contains(number.toString()))
                {
                    array.add(number.toString());
                }
            }
        }
        array.trimToSize();
        System.out.println(array.size());
    }
}
