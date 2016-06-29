/**
 * Created by jandrewmc on 2/1/15.
 */
public class EulerProblem030
{
    public static void main(String[] args)
    {
        EulerProblem030 problem = new EulerProblem030();
        problem.calculate();
    }
    public void calculate()
    {
        int totalSum = 0;

        for(int i = 2; i < 1000000; i++)
        {
            int first = i % 10;
            int second = (i % 100) / 10;
            int third = (i % 1000) / 100;
            int fourth = (i % 10000) / 1000;
            int fifth = (i % 100000) / 10000;
            int sixth = (i % 1000000) / 100000;
            int seventh = (i % 10000000) / 1000000;

            first = first * first * first * first * first;
            second = second * second * second * second * second;
            third = third * third * third * third * third;
            fourth = fourth * fourth * fourth * fourth * fourth;
            fifth = fifth * fifth * fifth * fifth * fifth;
            sixth = sixth * sixth * sixth * sixth * sixth;
            seventh = seventh * seventh * seventh * seventh * seventh;

            int total = first + second + third + fourth + fifth + sixth + seventh;

            if(i == total)
                totalSum += total;
        }
        System.out.println(totalSum);
    }
}
