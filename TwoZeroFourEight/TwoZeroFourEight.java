import javax.swing.*;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TwoZeroFourEight extends JFrame
{
	final static long serialVersionUID = 123123123L;

	private int score;
	
	private int BOARD_SIZE = 4;
	
	private JPanel boardPanel, infoPanel;

	private JLabel scoreLabel;
	
	private JButton[][] board;

    public static void main(String[] args)
    {
        new TwoZeroFourEight();
    }
	public TwoZeroFourEight()
	{
		final int BUTTON_SIZE = (480 / BOARD_SIZE);
		final int GAP = 10;
		final int BOARD_PANEL_SIZE = (((BOARD_SIZE + 1) * GAP) + ((BOARD_SIZE * BUTTON_SIZE)));
		final int X_GAP = 6;
		final int Y_GAP = 35;
		final int INFO_PANEL_HEIGHT = 50;
		
		setBounds(0, 0, BOARD_PANEL_SIZE + X_GAP, BOARD_PANEL_SIZE + Y_GAP + INFO_PANEL_HEIGHT + GAP);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setBackground(Color.WHITE);
		setTitle("2048 by J Andrew McCormick");
		
		boardPanel = new JPanel();
		boardPanel.setBounds(0, 0, BOARD_PANEL_SIZE, BOARD_PANEL_SIZE);
		boardPanel.setLayout(null);
		boardPanel.setBackground(Color.white);
		
		infoPanel = new JPanel();
		infoPanel.setBounds(0, GAP + BOARD_PANEL_SIZE, BOARD_PANEL_SIZE, INFO_PANEL_HEIGHT);
		infoPanel.setLayout(null);
		infoPanel.setBackground(Color.white);
	
		add(boardPanel);
		add(infoPanel);
		
		board = new JButton[BOARD_SIZE][BOARD_SIZE];

		Font font = new Font(Font.SANS_SERIF,Font.BOLD, BUTTON_SIZE / 3);
		
		scoreLabel = new JLabel();
		scoreLabel.setBounds(0, 0, 400, 60);
		scoreLabel.setFont(font);
		
		infoPanel.add(scoreLabel);
		
		updateScore();
		
		for(int row = 0; row < BOARD_SIZE; row++)
		{
			for(int column = 0; column < BOARD_SIZE; column++)
			{
				int buttonXLocation = ((column + 1) * GAP) + (column * BUTTON_SIZE);
				int buttonYLocation = ((row + 1) * GAP) + (row * BUTTON_SIZE);
				
				board[row][column] = new JButton("0");
				
				board[row][column].setFont(font);
				board[row][column].setBounds(buttonXLocation,buttonYLocation,BUTTON_SIZE,BUTTON_SIZE);
				
				
				board[row][column].setBorder(null);
				board[row][column].setHorizontalTextPosition(JButton.CENTER);
				board[row][column].setVerticalTextPosition(JButton.CENTER);
				board[row][column].setFocusable(false);
				board[row][column].setForeground(Color.black);

				boardPanel.add(board[row][column]);
			}
		}
		
		addKeyListener(new PlayWithKeyboardListener());

		randomSquareGenerator();
		changeColor();
		
		stuff();
		
		setVisible(true);
	}
	
	private void updateScore()
	{
		scoreLabel.setText("Score: " + score);
	}
	
	private boolean areAllSquaresFilled()
	{
		for(int row = 0; row < BOARD_SIZE; row++)
		{
			for(int column = 0; column < BOARD_SIZE; column++)
			{
				if(board[row][column].getText().equals("0")) return false;
			}
		}
		return true;
	}
	
	
	private void randomSquareGenerator()
	{
		boolean isBlank;
		boolean continueLoop = true;
		
		do
		{
			int row = (int) (Math.random() * BOARD_SIZE); 
			int column = (int) (Math.random() * BOARD_SIZE);
		
			isBlank = board[row][column].getText().equals(((("0"))));
		
			if(isBlank)
			{
				if((int) (Math.random() * 100) < 80) board[row][column].setText("2");
				else board[row][column].setText("4");

				continueLoop = false;
			}
			if(areAllSquaresFilled()) continueLoop = false;
		}
		while(continueLoop);
	}

	private int horizontalRow;
	private int horizontalColumn;
	
	private boolean didMove;
	
	private void moveLeft()
	{	
		for(horizontalRow = 0; horizontalRow < BOARD_SIZE; horizontalRow++)
		{
			for(horizontalColumn = 0; horizontalColumn < BOARD_SIZE - 1; horizontalColumn++)
			{
				int count = 0;
				
				while(isBlankColumn() && count != BOARD_SIZE - 1)
				{
					for(int column = horizontalColumn; column < BOARD_SIZE - 1; column++)
					{
						board[horizontalRow][column].setText(board[horizontalRow][column + 1].getText());
						board[horizontalRow][column + 1].setText(((("0"))));
					
						if(!board[horizontalRow][horizontalColumn].getText().equals("0"))
							didMove = true;
					}
					count++;
				}
			}
		}
	}

	private void moveRight()
	{
		for(horizontalRow = 0; horizontalRow < BOARD_SIZE; horizontalRow++)
		{
			for(horizontalColumn = BOARD_SIZE - 1; horizontalColumn > 0; horizontalColumn--)
			{
				int count = 0;
				
				while(isBlankColumn() && count != BOARD_SIZE - 1)
				{	
					for(int column = horizontalColumn; column > 0; column--)
					{	
						board[horizontalRow][column].setText(board[horizontalRow][column - 1].getText());
						board[horizontalRow][column - 1].setText(((("0"))));	
					
						if(!board[horizontalRow][horizontalColumn].getText().equals("0"))
							didMove = true;
					}
					count++;
				}
			}
		}
	}

	private int xRow;
	private int xCol;
	
	
	private boolean isBlankNew()
	{
		if(board[xRow][xCol].getText().equals("0"))
			return true;
		return false;
	}
	
	private void delay(double seconds)
	{
		long selectedLength = (long) (seconds * 100);
		long time = System.currentTimeMillis();
		long length = 0;
		
		do
		{
			length = System.currentTimeMillis() - time;
			
		}
		while(length < selectedLength);
	}
	/*
	private void moveRight()
	{
		for(xCol = BOARD_SIZE - 1; xCol > 0; xCol--)
		{
			for(xRow = 0; xRow < BOARD_SIZE; xRow++)
			{
				if(isBlankNew())
				{	
					if(xCol == 3)
					{
						board[xRow][xCol].setText(board[xRow][xCol - 1].getText());
						board[xRow][xCol - 1].setText("0");
						
						board[xRow][xCol - 1].setText(board[xRow][xCol - 2].getText());
						board[xRow][xCol - 2].setText("0");
						
						board[xRow][xCol - 2].setText(board[xRow][xCol - 3].getText());
						board[xRow][xCol - 3].setText("0");
						
						if(!board[xRow][xCol].getText().equals("0"))
							didMove = true;
					}
					else if(xCol == 2)
					{
						board[xRow][xCol].setText(board[xRow][xCol - 1].getText());
						board[xRow][xCol - 1].setText("0");
						
						board[xRow][xCol - 1].setText(board[xRow][xCol - 2].getText());
						board[xRow][xCol - 2].setText("0");
					}
					else if (xCol == 1)
					{
						board[xRow][xCol].setText(board[xRow][xCol - 1].getText());
						board[xRow][xCol - 1].setText("0");
					}
				}
			}
			delay(1);
		}
	}
	
	*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	private int verticalRow;
	private int verticalColumn;
	
	private void moveUp()
	{	
		for(verticalColumn = 0; verticalColumn < BOARD_SIZE; verticalColumn++)
		{
			for(verticalRow = 0; verticalRow < BOARD_SIZE - 1; verticalRow++)
			{
				int count = 0;
				
				while(isBlankRow() && count != BOARD_SIZE - 1)
				{
					for(int row = verticalRow; row < BOARD_SIZE - 1; row++)
					{		
						board[row][verticalColumn].setText(board[row + 1][verticalColumn].getText());
						board[row + 1][verticalColumn].setText(((("0"))));
					
						if(!board[verticalRow][verticalColumn].getText().equals("0"))
							didMove = true;
					}
					count++;
				}
			}
		}
	}
	private void moveDown()
	{
		for(verticalColumn = 0; verticalColumn < BOARD_SIZE; verticalColumn++)
		{
			for(verticalRow = BOARD_SIZE - 1; verticalRow > 0; verticalRow--)
			{
				int count = 0;
				
				while(isBlankRow() && count != BOARD_SIZE - 1)
				{
					for(int row = verticalRow; row > 0; row--)
					{
						board[row][verticalColumn].setText(board[row - 1][verticalColumn].getText());
						board[row - 1][verticalColumn].setText(((("0"))));
					
						if(!board[verticalRow][verticalColumn].getText().equals("0"))
							didMove = true;
					}
					count++;
				}
			}
		}
	}
	
	
	private boolean isBlankColumn()
	{
		if(board[horizontalRow][horizontalColumn].getText().equals(((("0"))))) return true;
		return false;
	}
	private boolean isBlankRow()
	{
		if(board[verticalRow][verticalColumn].getText().equals(((("0"))))) return true;
		return false;
	}
	private boolean didCombine; 
	
	private void combineLeft()
	{
		didCombine = false;
		
		for(int row = 0; row < BOARD_SIZE; row++)
		{
			for(int column = 0; column < BOARD_SIZE - 1; column++)
			{
				if(board[row][column].getText().equals(board[row][column + 1].getText()) && !board[row][column].getText().equals("0"))
				{
					board[row][column].setText((Integer.parseInt(board[row][column + 1].getText()) * 2 + ""));
					board[row][column + 1].setText(((("0"))));
					
					score += Integer.parseInt(board[row][column].getText());
					
					didCombine = true;
				}
			}
		}
	}
	private void combineRight()
	{
		didCombine = false;
		
		for(int row = 0; row < BOARD_SIZE; row++)
		{
			for(int column = BOARD_SIZE - 1; column > 0; column--)
			{
				if(board[row][column].getText().equals(board[row][column - 1].getText()) && !board[row][column].getText().equals("0"))
				{
					board[row][column].setText((Integer.parseInt(board[row][column - 1].getText()) * 2 + ""));
					board[row][column - 1].setText(((("0"))));
					
					score += Integer.parseInt(board[row][column].getText());
					
					didCombine = true;
				}
			}
		}
	}
	private void combineUp()
	{
		didCombine = false;
		
		for(int column = 0; column < BOARD_SIZE; column++)
		{
			for(int row = 0; row < BOARD_SIZE - 1; row++)
			{
				if(board[row][column].getText().equals(board[row + 1][column].getText()) && !board[row][column].getText().equals("0"))
				{
					board[row][column].setText((Integer.parseInt(board[row + 1][column].getText()) * 2 + ""));
					board[row + 1][column].setText(((("0"))));
					
					score += Integer.parseInt(board[row][column].getText());
					
					didCombine = true;
				}
			}
		}
	}
	private void combineDown()
	{
		didCombine = false;
		
		for(int column = 0; column < BOARD_SIZE; column++)
		{
			for(int row = BOARD_SIZE - 1; row > 0; row--)
			{
				if(board[row][column].getText().equals(board[row - 1][column].getText()) && !board[row][column].getText().equals("0"))
				{
					board[row][column].setText((Integer.parseInt(board[row - 1][column].getText()) * 2 + ""));
					board[row - 1][column].setText(((("0"))));
					
					score += Integer.parseInt(board[row][column].getText());
					
					didCombine = true;
				}
			}
		}
	}
	
	private void stuff()
	{
		for(int row = 0; row < BOARD_SIZE; row++)
		{
			for(int column = 0; column < BOARD_SIZE; column++)
			{
				if(board[row][column].getText().equals("0")) board[row][column].setText(" ");
				else if(board[row][column].getText().equals(" ")) board[row][column].setText("0");
			}
		}
	}

	private void changeColor()
	{
		for(int row = 0; row < BOARD_SIZE; row++)
		{
			for(int column = 0; column < BOARD_SIZE; column++)
			{
				if(board[row][column].getText().equals("0"))
				{
					board[row][column].setBackground(Color.gray);
				}
				else if(board[row][column].getText().equals("2"))
				{
					board[row][column].setBackground(Color.cyan);
				}
				else if(board[row][column].getText().equals("4"))
				{
					board[row][column].setBackground(Color.DARK_GRAY);
				}
				else if(board[row][column].getText().equals("8"))
				{
					board[row][column].setBackground(Color.green);
				}
				else if(board[row][column].getText().equals("16"))
				{
					board[row][column].setBackground(Color.LIGHT_GRAY);
				}
				else if(board[row][column].getText().equals("32"))
				{
					board[row][column].setBackground(Color.blue);
				}
				else if(board[row][column].getText().equals("64"))
				{
					board[row][column].setBackground(Color.magenta);
				}
				else if(board[row][column].getText().equals("128"))
				{
					board[row][column].setBackground(Color.orange);
				}
				else if(board[row][column].getText().equals("256"))
				{
					board[row][column].setBackground(Color.pink);
				}
				else if(board[row][column].getText().equals("512"))
				{
					board[row][column].setBackground(Color.red);
				}
				else if(board[row][column].getText().equals("1024"))
				{
					board[row][column].setBackground(Color.yellow);
				}
				else if(board[row][column].getText().equals("2048"))
				{
					board[row][column].setBackground(Color.black);
					board[row][column].setForeground(Color.white);
					JOptionPane.showMessageDialog(null, "Congrats, you have won!");
				}
			}
		}
	}
	
	private boolean isGameOver()
	{
		for(int row = 0; row < BOARD_SIZE; row++)
		{
			for(int column = 0; column < BOARD_SIZE - 1; column++)
			{
				if(board[row][column].getText().equals(board[row][column + 1].getText())) return false;
			}
		}
		for(int row = 0; row < BOARD_SIZE - 1; row++)
		{
			for(int column = 0; column < BOARD_SIZE; column++)
			{
				if(board[row][column].getText().equals(board[row + 1][column].getText())) return false;
			}
		}
		return true;
	}
	class PlayWithKeyboardListener implements KeyListener
	{
		public void keyPressed(KeyEvent e)
		{  
			if(e.getKeyCode() == KeyEvent.VK_UP)
			{
				didMove = false;
				
				stuff();
				
				moveUp();
				combineUp();
				moveUp();
				
				if(didCombine || didMove)
					randomSquareGenerator();
				
				changeColor();
				if(areAllSquaresFilled() && isGameOver()) JOptionPane.showMessageDialog(null, "Game Over, you suck!");
				
				stuff();
				
				updateScore();
			}
			else if(e.getKeyCode() == KeyEvent.VK_DOWN)
			{
				didMove = false;
				
				stuff();
				
				moveDown();
				combineDown();
				moveDown();
				
				if(didCombine || didMove)
					randomSquareGenerator();
				
				changeColor();
				if(areAllSquaresFilled() && isGameOver()) JOptionPane.showMessageDialog(null, "Game Over, you suck!");
				
				stuff();
				
				updateScore();
			}
			else if(e.getKeyCode() == KeyEvent.VK_LEFT)
			{
				didMove = false;
				
				stuff();
				
				moveLeft();
				combineLeft();
				moveLeft();
				
				if(didCombine || didMove)
					randomSquareGenerator();
				
				changeColor();
				if(areAllSquaresFilled() && isGameOver()) JOptionPane.showMessageDialog(null, "Game Over, you suck!");
				
				stuff();
				
				updateScore();
			}
			else if(e.getKeyCode() == KeyEvent.VK_RIGHT)
			{
				didMove = false;
				
				stuff();
				
				moveRight();
				combineRight();
				moveRight();
				
				if(didCombine || didMove)
					randomSquareGenerator();
				
				changeColor();				
				if(areAllSquaresFilled() && isGameOver()) JOptionPane.showMessageDialog(null, "Game Over, you suck!");
				
				stuff();
				
				updateScore();
			}
		}
		
		public void keyTyped(KeyEvent e){}
		public void keyReleased(KeyEvent e){}
	}
}

