
public class SpecialPythagoreanTriplet
{
	
	public static void main(String[] args)
	{
		long time = System.currentTimeMillis();
		triplet();
		System.out.println((System.currentTimeMillis() - time) / 1000.0 + " seconds");
	}
	
	public static void triplet()
	{
		for(int a = 1; a <= 1000; a++)
		{
			for(int b = 1; b <= 1000; b++)
			{
				for(int c = 1; c <=1000; c++)
				{
					if(a*a + b*b == c*c && a + b + c == 1000) 
					{
						System.out.println(a*b*c);
					}
				}
			}
		}
	}
}
