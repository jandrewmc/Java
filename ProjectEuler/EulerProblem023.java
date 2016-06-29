import java.lang.*;
public class EulerProblem023
{
	public static void main(String[] args)
	{
	    EulerProblem023 problem = new EulerProblem023();
        problem.nonAbundantNumber();
	}
	public void nonAbundantNumber()
	{
        int MAX_VALUE = 28124;

        boolean[] abundantNumbers = new boolean[MAX_VALUE];
	    
        for(int i = 0; i < abundantNumbers.length; i++)
        {
            abundantNumbers[i] = true;
        }

        abundantNumbers[0] = false;
        abundantNumbers[1] = false;
        
        //start at 2
        for(int i = 2; i < MAX_VALUE; i++)
        {
            if(!isAbundant(i)) abundantNumbers[i] = false ;
        }
        int[] arrayOfAbundantNumbers = new int[totalAbundantNumbersCount(abundantNumbers)];
        
        int count = 0;
        for(int i = 0; i < abundantNumbers.length; i++)
        {
            if(abundantNumbers[i] == true)
            {
                arrayOfAbundantNumbers[count] = i;
                count++;
            }
        }
        
        boolean[] array = new boolean[MAX_VALUE];
        for(int i = 0; i < array.length; i++)
        {
            array[i] = true;
        }
        
        
        
        array[0] = false;



        for(int first = 0; first < arrayOfAbundantNumbers.length; first++)
        {
            for(int incrementing = 0; incrementing < arrayOfAbundantNumbers.length; incrementing++)
            {
                int total = arrayOfAbundantNumbers[first] + arrayOfAbundantNumbers[incrementing];
                
                if(total < array.length) array[total] = false;
            }
        }

        

        int sum = 0;
        for(int i = 0; i < abundantNumbers.length; i++)
        {
            if(array[i] == true) sum += i; 
        }

        System.out.println(sum);



/*
        for(int i = 0; i < arrayOfAbundantNumbers.length; i++)
        {
            System.out.println(arrayOfAbundantNumbers[i]);
        }
*/
    }
    public int totalAbundantNumbersCount(boolean[] abundantNumbers)
    {
        int count = 0;
        for(int i = 0; i < abundantNumbers.length; i++)
        {
        if(abundantNumbers[i] == true) count++; 
        }
        return count;
    }
    public boolean isAbundant(int number)
    {
        int total = 0;
        for(int i = 1; i <= number / 2; i++)
        {
            if(number % i == 0) total += i;
        }
        return total > number; 
    }
}
