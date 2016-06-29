
public class AmicableNumbers
{
	public static void main(String[] args)
	{
		long time = System.currentTimeMillis();
		final int MAX = 10000 + 1;
		boolean[] numbersToCheck = new boolean[MAX];
		int[] sumOfFactors = new int[MAX];
		
		primeSieve(numbersToCheck,MAX);
		
		//for each element that is true in the boolean array
		for(int i = 3; i < MAX; i++)
		{
			//find the factors and sum them
			for(int j = 1; j <= (int) (Math.sqrt(i)); j++)
			{
				if(numbersToCheck[i])
					if(i % j == 0) 
					{	
						sumOfFactors[i] += j; 
						if(j != i / j && j != 1)
							sumOfFactors[i] += i / j;
					}
			}
		}
		
		long sum = 0;
		
		for(int i = 0; i < MAX; i++)
		{
			if(sumOfFactors[i] == 0) continue;
			
			for(int j = 0; j < MAX; j++)
			{
				if(sumOfFactors[j] == 0 || sumOfFactors[j] == sumOfFactors[i]) continue;
				
				if(j == sumOfFactors[i] && i == sumOfFactors[j])
				{
					sum += i + j;
					sumOfFactors[i] = 0;
					sumOfFactors[j] = 0;
				}
			}
		}
		System.out.println((System.currentTimeMillis() - time) / 1000.0 + " Seconds");
		System.out.println(sum);
	}
	
	public static void primeSieve(boolean[] numbersToCheck, int limit)
	{
		//set all values to true
		for(int i = 0; i < numbersToCheck.length; i++) numbersToCheck[i] = false;
		
		int upperLimit = (int) Math.sqrt(limit);
		
		for (int i = 2; i <= upperLimit; i++)
		{
			if(!numbersToCheck[i]) //don't bother if already eliminated
				for(int j = i + i; j < limit; j += i)
					numbersToCheck[j] = true;
		}	
		numbersToCheck[0] = false;
		numbersToCheck[1] = false;
	}
}


