/**
 * Created by jandrewmc on 2/1/15.
 */
public class EulerProblem031
{
    public static void main(String[] args)
    {
        EulerProblem031 problem = new EulerProblem031();
        problem.calculate();
    }
    public void calculate()
    {
        //1p, 2p, 5p, 10p, 20p, 50p, 100p, 200p
        int count = 0;
        for(int p200 = 0; p200 <= 1; p200++)
        {
            int p200Cycle = 200 * p200;
            for(int p100 = 0; p100 <= 2; p100++)
            {
                int p100Cycle = 100 * p100;
                for(int p50 = 0; p50 <= 4; p50++)
                {
                    int p50Cycle = 50 * p50;
                    for(int p20 = 0; p20 <= 10; p20++)
                    {
                        int p20Cycle = 20 * p20;
                        for(int p10 = 0; p10 <= 20; p10++)
                        {
                            int p10Cycle = 10 * p10;
                            for(int p5 = 0; p5 <= 40; p5++)
                            {
                                int p5Cycle = 5 * p5;
                                for(int p2 = 0; p2 <= 100; p2++)
                                {
                                    int p2Cycle = 2 * p2;
                                    for(int p1 = 0; p1 <= 200; p1++)
                                    {
                                        int p1Cycle = 1 * p1;
                                        int total = p200Cycle + p100Cycle + p50Cycle + p20Cycle + p10Cycle + p5Cycle + p2Cycle + p1Cycle;
                                        if(total == 200)
                                        {
                                            count++;
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(count);
    }
}
