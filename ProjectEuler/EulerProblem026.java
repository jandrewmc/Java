import java.math.BigInteger;
import java.util.ArrayList;

/**
 * Created by jandrewmc on 1/29/15.
 */

public class EulerProblem026
{
    public static void main(String[] args)
    {
        EulerProblem026 problem = new EulerProblem026();

        problem.calculate();
    }
    public void calculate()
    {
        int MAX_VALUE = 1000;
        boolean[] array = new boolean[MAX_VALUE];

        for(int i = 0; i < MAX_VALUE; i++) array[i] = true;

        array[0] = false;
        array[1] = false;

        for(int i = 2; i < MAX_VALUE; i++)
            for(int j = i + i; j < MAX_VALUE; j += i)
                array[j] = false;

        EulerProblem026 mo = new EulerProblem026();

        int maxMO = 0;

        for(int i = 7; i < MAX_VALUE; i++)
        {
            if(array[i])
            {
                int modulo = mo.aModuloN(10, i);
                if(modulo > maxMO) maxMO = modulo;
            }
        }
        System.out.println(maxMO + 1);
    }
    public int aModuloN(int a, int n)
    {
        if(gcd(a, n) == 1)
        {
            BigInteger total = new BigInteger(Integer.toString(a));
            int count = 1;

            while(true)
            {
                total = total.multiply(new BigInteger(Integer.toString(a)));
                count++;
                if(total.mod(new BigInteger(Integer.toString(n))).equals(new BigInteger("1")))
                {
                    return count;
                }
            }
        }
        return -1;
    }

    public int gcd(int a, int b)
    {
        ArrayList arrayForA = new ArrayList();
        ArrayList arrayForB = new ArrayList();

        arrayForA.add(0, false);
        arrayForA.add(1, false);

        int smallest = 0;
        if(arrayForA.size() <= arrayForB.size())
        {
            smallest = arrayForA.size();
        }
        else
        {
            smallest = arrayForB.size();
        }

        for(int i = 2; i < smallest; i++)
        {
            if(a % i == 0)
            {
                arrayForA.add(i, true);
            }
            else
            {
                arrayForA.add(i, false);
            }
        }
        arrayForA.trimToSize();

        arrayForB.add(0, false);
        arrayForB.add(1, false);
        for(int i = 2; i < smallest; i++)
        {
            if(b % i == 0)
            {
                arrayForB.add(i, true);
            }
            else
            {
                arrayForB.add(i, false);
            }
        }
        arrayForB.trimToSize();

        int gcd = 1;
        for(int i = 0; i < smallest; i++)
        {
            if(arrayForA.get(i).equals(true) && arrayForB.get(i).equals(true))
            {
                gcd = i;
            }
        }
        return gcd;
    }

}
