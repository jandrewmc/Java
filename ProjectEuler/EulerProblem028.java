/**
 * Created by jandrewmc on 2/1/15.
 */
public class EulerProblem028
{
    final int MAX_SPIRAL_SIZE = 1003;
    int[][] array = new int[MAX_SPIRAL_SIZE][MAX_SPIRAL_SIZE];


    public static void main(String[] args)
    {
        EulerProblem028 problem = new EulerProblem028();
        problem.generateSpiral();
    }
    public void generateSpiral()
    {
        //starting point
        int row = MAX_SPIRAL_SIZE / 2;
        int column = MAX_SPIRAL_SIZE / 2;

        int count = 1;

        array[row][column] = count;
        count++;

        int n = 1;
        while(true)
        {
            //right
            for (int i = 1; i <= n; i++)
            {
                column += 1;
                array[row][column] = count;
                count++;
            }
            if(n == 1001)
                countDiagonals();

            //down
            for (int i = 1; i <= n; i++)
            {
                row += 1;
                array[row][column] = count;
                count++;
            }
            n++;

            //left
            for (int i = 1; i <= n; i++)
            {
                column -= 1;
                array[row][column] = count;
                count++;
            }

            //up
            for (int i = 1; i <= n; i++)
            {
                row -= 1;
                array[row][column] = count;
                count++;
            }
            n++;
        }
    }
    public void countDiagonals()
    {
        long LTRTotal = 0;

        //left to right diagonal
        for(int i = 0; i < MAX_SPIRAL_SIZE; i++)
        {
            LTRTotal += array[i][i];
        }

        long RTLTotal = 0;
        for(int i = 0; i < MAX_SPIRAL_SIZE; i++)
        {
            RTLTotal += array[i][MAX_SPIRAL_SIZE - i - 1];
        }

        System.out.println(LTRTotal + RTLTotal);
        System.exit(0);
    }
}
