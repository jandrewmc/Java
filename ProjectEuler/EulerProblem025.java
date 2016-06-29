import java.math.*;
public class EulerProblem025 {

	public static void main(String[] args) {
		EulerProblem025 problem = new EulerProblem025();
		
		problem.calculate();
	}
	
	public void calculate()
	{
		BigInteger minimumMax = new BigInteger("10");
		minimumMax = minimumMax.pow(999);
		
		BigInteger first = new BigInteger("1");
		BigInteger second = new BigInteger("1");

		int count = 2;
		
		BigInteger next = new BigInteger("0");

		while(next.compareTo(minimumMax) < 0)
		{
			next = first.add(second);
			first = second;
			second = next;
			count++;
		}
		System.out.println(count);
	}
}