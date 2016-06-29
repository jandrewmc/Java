/*
 * J Andrew McCormick
 * 1/11/15
 * Project Euler 
 * Problem 18
 * Maximum Path Sum I
 * The purpose of this problem is to find the largest sum path through the following
 * triangle of numbers.
 */

import java.util.*;
import java.io.*;

public class Problem18 {
	int MAX_ROW = 100;
	int MAX_COLUMN = 100;

	public static void main(String[] args) {
		Problem18 problem = new Problem18();
		
		File file = new File("p067_triangle.txt");

		Scanner input = new Scanner(System.in);
		
		try
		{
			input = new Scanner(file);
		
		} catch(FileNotFoundException fnfe){System.out.println("FileNotFound");}
				
		int currentColumnCount = 1;
		int[][] bigArray = new int[problem.MAX_ROW][problem.MAX_COLUMN];
		
		while(input.hasNext())
		{
			for(int row = 0; row < problem.MAX_ROW; row++)
			{
				for(int column = 0; column < currentColumnCount; column++)
				{
					bigArray[row][column] = input.nextInt();
				}
				currentColumnCount++;
			}
		}
/*		
		int[][] array = { 	{75},
							{95, 64},
							{17, 47, 82},
							{18, 35, 87, 10},
							{20, 04, 82, 47, 65},
							{19, 01, 23, 75, 03, 34},
							{88, 02, 77, 73, 07, 63, 67},
							{99, 65, 04, 28, 06, 16, 70, 92},
							{41, 41, 26, 56, 83, 40, 80, 70, 33},
							{41, 48, 72, 33, 47, 32, 37, 16, 94, 29},
							{53, 71, 44, 65, 25, 43, 91, 52, 97, 51, 14},
							{70, 11, 33, 28, 77, 73, 17, 78, 39, 68, 17, 57},
							{91, 71, 52, 38, 17, 14, 91, 43, 58, 50, 27, 29, 48},
							{63, 66, 04, 68, 89, 53, 67, 30, 73, 16, 69, 87, 40, 31},
							{04, 62, 98, 27, 23,  9, 70, 98, 73, 93, 38, 53, 60, 04, 23}};
*/		
		System.out.println(problem.calculateSumDynamic(bigArray));
		
	}
	public long calculateSumDynamic(int[][] array)
	{
		int currentRow = MAX_ROW - 2;
		int currentColumn = 0;
		int currentNumberOfColumnsInRow = MAX_COLUMN - 2;
		
		while(currentRow != -1)
		{
			currentColumn = 0;
			while(currentColumn <= currentNumberOfColumnsInRow)
			{
				if(array[currentRow + 1][currentColumn] >= array[currentRow + 1][currentColumn + 1])
				{
					array[currentRow][currentColumn] += array[currentRow + 1][currentColumn];
				}
				else
				{
					array[currentRow][currentColumn] += array[currentRow + 1][currentColumn + 1];
				}
				currentColumn++;
			}
			currentNumberOfColumnsInRow--;
			currentRow--;
		}
		System.out.println(array[0][0]);
		System.out.println(array[1][0]);
		System.out.println(array[1][1]);
		return array[0][0];
	}
	
	
	
	
	
	public long calculateSum(int[][] array){
		long sum = 0;
		int currentRow = 0;
		int currentColumn = 0;
		
		sum += array[currentRow][currentColumn];
		
		while(currentRow < array.length - 1)
		{	
			int nextRowOneLess, nextRowSame, nextRowOneMore;
			currentRow++;
		
			if(currentColumn - 1 > 0)
			{
				nextRowOneLess = array[currentRow][currentColumn - 1];
			}
			else nextRowOneLess = 0;
			nextRowSame = array[currentRow][currentColumn];
			nextRowOneMore = array[currentRow][currentColumn + 1];
			
			if(nextRowOneLess >= nextRowSame && nextRowOneLess >= nextRowOneMore)
			{
				currentColumn--;
			}
			else if(nextRowOneMore >= nextRowOneLess && nextRowOneMore >= nextRowSame)
			{
				currentColumn++;
			}
			
			sum += array[currentRow][currentColumn];
			
		}
		
		return sum;
	}
}
