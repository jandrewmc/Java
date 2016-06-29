//J Andrew McCormick
//EECS 1510
//Dr. Thomas
//2/27/2014
//Project 1:  Connect4
//This program implements the classic game of connect 4.  Typically
//two players play on a 6x7 board.  Player 1 will 'place' pieces of
//letter A and player 2 of letter B.  The first person to connect 4
//like lettered pieces in a row wins.

import java.util.Scanner;

public class ConnectFour
{
	boolean continuePlaying = true;
	boolean isInputValid = false;
	boolean isWinner = false;
	
	final int ROWS = 20;
	final int COLUMNS = 20;
	final int CONNECT_HOW_MANY = 4;
	final int NUMBER_OF_PLAYERS = 7;
	final int STARTING_CHAR = 64;
		
	int turnCount = 1;
	int currentPlayer = 0;

	int startCheckingVictoryCondition = (CONNECT_HOW_MANY * NUMBER_OF_PLAYERS) - 1;

	int columnNumber = 0;
	int rowNumber = 0;
		
	char[][] gameBoard = new char[ROWS][COLUMNS];

	char playerChar;

	public static void main(String[] args)
	{		
		ConnectFour game = new ConnectFour();
		game.startGame();
	}

	public void startGame()
	{
		Scanner input= new Scanner(System.in); 
		
		System.out.println("Welcome to Connect " + CONNECT_HOW_MANY + " for " + NUMBER_OF_PLAYERS + " players!");
		
		do
		{
			continuePlaying = true;
			isInputValid = false;
			isWinner = false;
			
			currentPlayer = ((turnCount + NUMBER_OF_PLAYERS - 1) % NUMBER_OF_PLAYERS) + 1;
			
			playerChar = (char) (currentPlayer + STARTING_CHAR);
			
			printGameBoard(gameBoard);
			
			do
			{	
				isInputValid = false;
		
				System.out.println("Player " + currentPlayer + ", please select a column from 1 to " + COLUMNS);
				System.out.print("followed by the enter key (-1 to end game early): ");
				
				do
				{
					columnNumber = -1;

					if(input.hasNextInt()) 
					{
						if((columnNumber = (input.nextInt() - 1)) == -1)
							columnNumber = -3;
					}
					else
					{	
						input.next();
						System.out.println("You entered an invalid value!");
						System.out.println("Player " + currentPlayer + ", please select a column from 1 to " + COLUMNS);
						System.out.print("followed by the enter key (-1 to end game early): ");
					}
				}while(columnNumber == -1);
				
				if(columnNumber == -2) System.exit(0);
			
				if(columnNumber < 0 || columnNumber > COLUMNS - 1) 
				{
					System.out.println("You selected a column that does not exist!");
					continue;
				}
				
				rowNumber = placePiece(playerChar, columnNumber, gameBoard);
				
				if(rowNumber == -1) 
				{
					System.out.println("You selected a column that is full!");
					continue;
				}
				else isInputValid = true; 
			
			}while(!isInputValid);
			
			if(turnCount >= startCheckingVictoryCondition) 
				isWinner = isVictoryConditionMet(CONNECT_HOW_MANY, ROWS, COLUMNS, rowNumber, columnNumber, playerChar, gameBoard);
			
			if(isWinner) 
			{
				printGameBoard(gameBoard);
				
				System.out.println("Congratulations player " + currentPlayer + ", you have won!");
				System.out.println("Would you like to play again? (1 followed by enter for yes,");
				System.out.print("any other key followed by enter to quit): ");

				if(input.next().equals("1")) 
				{
					continuePlaying = true;	
					
					turnCount = 0;
					
					for(int i = 0; i < gameBoard.length; i++)
					{
						for(int j = 0; j < gameBoard[i].length; j++)
						{
							gameBoard[i][j] = 0;
						}
					}
				}
				else continuePlaying = false;
			}
			
			if(turnCount == ROWS * COLUMNS)
			{
				printGameBoard(gameBoard);
				
				System.out.println("The game is a tie game.");
				System.out.print("Would you like to play again? (1 followed by enter for yes,");
				System.out.print("any other key followed by enter to quit): ");
				
				if(input.next().equals("1")) 
				{
					continuePlaying = true;	
					
					turnCount = 0;
					
					for(int i = 0; i < gameBoard.length; i++)
					{
						for(int j = 0; j < gameBoard[i].length; j++)
						{
							gameBoard[i][j] = 0;
						}
					}
				}
				else continuePlaying = false;
			}
			turnCount++;
			
		}while(continuePlaying);
		
		input.close();

	}
	

	public int placePiece(char playerChar, int columnNum, char[][] gameBoard)
	{
		int row;
		
		for(row = (gameBoard.length - 1); row >=  0; row--)
		{
			if(gameBoard[row][columnNum] == 0)
			{
				gameBoard[row][columnNum] = playerChar;
				return row;
			}
		}
		
		return -1;
	}
	
	public boolean isVictoryConditionMet(final int CONNECT_HOW_MANY, final int ROWS, final int COLUMNS, int rowNum, int columnNum, char playerChar, char[][] gameBoard)
	{
		int count = 1;

		boolean continueLeftOrUp = true;		
		boolean continueRightOrDown = true;
			
		for(int i = 1; i <= CONNECT_HOW_MANY - 1; i++)
		{
			if(columnNum - i < 0) continueLeftOrUp = false;

			if(continueLeftOrUp)
			{
				if(gameBoard[rowNum][columnNum - i] == playerChar) count++;
				else continueLeftOrUp = false;
			}
			
			if(columnNum + i > COLUMNS - 1) continueRightOrDown = false;
			
			if(continueRightOrDown)
			{
				if(gameBoard[rowNum][columnNum + i] == playerChar) count++;
				else continueRightOrDown = false;
			} 
		}
		
		if(count >= CONNECT_HOW_MANY) return true;
		else 
		{
			count = 1;
			continueLeftOrUp = true;
			continueRightOrDown = true;
		}
		
		for(int i = 1; i <= CONNECT_HOW_MANY - 1; i++)
		{
			if(rowNum + i > ROWS - 1) continueRightOrDown = false;
			
			if(continueRightOrDown)
			{
				if(gameBoard[rowNum + i][columnNum] == playerChar) count++;
				else continueRightOrDown = false;
			}
		}
		
		if(count >= CONNECT_HOW_MANY) return true;
		else 
		{
			count = 1;
			continueLeftOrUp = true;
			continueRightOrDown = true;
		}
		
		for(int i = 1; i <= CONNECT_HOW_MANY - 1; i++)
		{
			if(rowNum - i < 0 || columnNum - i < 0) continueLeftOrUp = false;
			
			if(continueLeftOrUp)
			{
				if(gameBoard[rowNum - i][columnNum - i] == playerChar) count++;
				else continueLeftOrUp = false;
			}
			
			if(rowNum + i > ROWS - 1 || columnNum + i > COLUMNS - 1) continueRightOrDown = false;
			
			if(continueRightOrDown)
			{
				if(gameBoard[rowNum + i][columnNum + i] == playerChar) count++;
				else continueRightOrDown = false;
			}
		}
		
		if(count >= CONNECT_HOW_MANY) return true;
		else 
		{
			count = 1;
			continueLeftOrUp = true;
			continueRightOrDown = true;
		}
		
		for(int i = 1; i <= CONNECT_HOW_MANY - 1; i++)
		{
			if(rowNum - i < 0 || columnNum + i > COLUMNS - 1) continueLeftOrUp = false;
		
			if(continueLeftOrUp)
			{
				if(gameBoard[rowNum - i][columnNum + i] == playerChar) count++;
				else continueLeftOrUp = false;
			}
			
			if(rowNum + i > ROWS - 1 || columnNum - i < 0) continueRightOrDown = false;
			
			if(continueRightOrDown)
			{
				if(gameBoard[rowNum + i][columnNum - i] == playerChar) count++;
				else continueRightOrDown = false;
			}
		}
		
		if(count >= CONNECT_HOW_MANY) return true;
		
		return false;
	}
	
	public void printGameBoard(char[][] gameBoard)
	{
		char verticalLine = '|';
		char space = ' ';
		char dash = '-';
		
		for(int i = 0; i < gameBoard.length; i++)
		{
			System.out.print(verticalLine);
			
			for(int j = 0; j < gameBoard[i].length; j++)
			{
				if(gameBoard[0].length <= 10)
				{	
					if(gameBoard[i][j] == 0) System.out.print(space + "" + verticalLine);
					else System.out.print(gameBoard[i][j] + "" + verticalLine);
					continue;
				}
				
				if(gameBoard[0].length > 10)
				{
					if(gameBoard[i][j] == 0) System.out.print(space + "" + space + space + verticalLine);
					else System.out.print(space + "" + gameBoard[i][j] + space  + verticalLine);	
				}
			}
			System.out.println();
		}
		
		System.out.print(dash);
		for(int i = 1; i <= gameBoard[0].length; i++)
		{
			if(gameBoard[0].length > 10)
			{
				if(i < 10)
				{	
					System.out.print(dash + "" + i + dash + dash);
				}
				if(i >= 10 && i < 100)
				{	
					System.out.print(i + "" + dash + dash);
				}
				if(i >= 100)
				{	
					System.out.print(i + "" + dash);
				}
			}
			else System.out.print(i + "" + dash);
		}
		System.out.println();
	}
}
