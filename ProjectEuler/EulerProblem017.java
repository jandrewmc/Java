
public class NumberLetterCount//this program is off by 53?
{
	public static void main(String[] args)
	{
		calculateNumberOfLetters();
	}
	public static void calculateNumberOfLetters()
	{
		String[] ones = {"","one","two","three","four","five","six","seven","eight","nine"};
		String[] teens = {"","ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"};
		String[] tens = {"","twenty","thirty","forty","fifty","sixty","seventy","eighty","ninty"};
		String[] hundred = {"","onehundredand","twohundredand","threehundredand","fourhundredand","fivehundredand","sixhundredand","sevenhundredand","eighthundredand","ninehundredand"};
		String[] thousand = {"","onethousand"};
		String totalString = "";
		
		
	for(int g = 0; g < thousand.length; g++)
	{
		for(int i = 0; i < hundred.length; i++)
		{
			for(int j = 0; j < tens.length; j++)
			{
				for(int l = 0; l < ones.length; l++)
				{
					totalString += thousand[g] + hundred[i] + tens[j] + ones[l];
					if(g == 1) calculateTotalNumber(totalString); 
					//System.out.println(totalString);
				}	
				if(j == 0)
				{
					for(int k = 0; k < teens.length; k++)
					{
								totalString += thousand[g] + hundred[i] + teens[k];
					}
				}
			}
		}
	}
	}
	public static void calculateTotalNumber(String totalString)
	{
		long length = totalString.length();
		System.out.print(length);
		System.exit(0);
	}
} 