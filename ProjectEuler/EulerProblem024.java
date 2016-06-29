/*
	1. Find the largest index k such that a[k] < a[k + 1]. If no such index exists, the permutation is the last permutation.
	2. Find the largest index l greater than k such that a[k] < a[l].
	3. Swap the value of a[k] with that of a[l].
	4. Reverse the sequence from a[k + 1] up to and including the final element a[n].
 */

public class EulerProblem024 {

	public static void main(String[] args) {
	    long time = System.currentTimeMillis();
        EulerProblem024 problem = new EulerProblem024();
		problem.calculate();
        System.out.println("Total time: " + ((System.currentTimeMillis() - time) / 1000.00) + " seconds.");
	}
	
	public void calculate()
	{
		int[] a = {0,1,2,3,4,5,6,7,8,9};
		
		int count = 1;
		final int MAX_VALUE = 1000000;
		int largestIndexK = 0;
		int largestIndexL = 0;

		while(count < MAX_VALUE)
		{
			//1
			for(int k = 0; k < a.length - 1; k++){
				if(a[k] < a[k + 1]) largestIndexK = k;
			}

			//2
			for(int l = largestIndexK; l < a.length; l++){
				if(a[largestIndexK] < a[l]) largestIndexL = l; 
			}	

			//3
			int swap = a[largestIndexK];
			a[largestIndexK] = a[largestIndexL];
			a[largestIndexL] = swap;

			//4
			int n = a.length - 1;
			int kPlus1 = largestIndexK + 1;
			while(kPlus1 < n){
				swap = a[kPlus1];
				a[kPlus1] = a[n];
				a[n] = swap;
				kPlus1++;
				n--;
			}
			count++;
		}
		for(int i = 0; i < a.length; i++){
			System.out.print(a[i]);
		}
        System.out.println();
	}
}
