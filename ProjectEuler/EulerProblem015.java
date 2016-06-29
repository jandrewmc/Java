
public class LatticePaths4
{
	public static void main(String[] args)
	{
		long time = System.currentTimeMillis();
		//create array to store pascales triangle
		long[][] array = new long[41][40];
		
		//set all values in the first column to 1
		for(int i = 0; i < 40; i++)
		{
			array[i][0] = 1;
		}
		
		for(int i = 1; i < 41; i++)
		{
			for(int j = 1; j < 40; j++)
			{
				array[i][j] = array[i - 1][j - 1] + array[i - 1][j];
			}
		}
		
		System.out.println(array[40][40-20]);
		System.out.println((System.currentTimeMillis() - time) / 1000.0 + " seconds");
	}
}
