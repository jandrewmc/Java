import java.io.*;
import java.util.*;

public class Euler_Problem_022 {
	LLNode root;
	
	long totalScore;
	
	public static void main(String[] args) {
		Euler_Problem_022 problem = new Euler_Problem_022();
		problem.processList();
	}

	public void processList()
	{
		File file = new File("p022_names.txt");
		try
		{
			Scanner input = new Scanner(file);
			input.useDelimiter(",");
			
			while(input.hasNext())
			{
				String current = input.next().replace("\"", "");
				buildTree(current);
			}
			nameScoreWithPosition(root);
			System.out.println(totalScore);
			
			input.close();
		}catch(FileNotFoundException fnfe) {System.out.println("Error!");}
	}
	
	public long nameValue(String current)
	{
		char[] array = current.toCharArray();
		long sum = 0;
		
		for(int i = 0; i < array.length; i++)
		{
			sum += array[i] - 64;
		}
		return sum;
	}

	public long currentCount = 0;
	// pass root.
	public void nameScoreWithPosition(LLNode node)
	{
		LLNode current = node;
		
		if(current.getLeftChild() != null)
		{
			nameScoreWithPosition(current.getLeftChild());
		}
		currentCount++;
		totalScore += currentCount * current.getNameScore();
		if(current.getRightChild() != null)
		{
			nameScoreWithPosition(current.getRightChild());
		}
	}
	public void buildTree(String current)
	{
		LLNode node = new LLNode(current);
		LLNode currentNode = root;
		node.setNameScore(nameValue(current));
		
		while(true)
		{
			if(root == null)
			{
				root = node;
				return;
			}
			else
			{
				if(node.getKey().compareTo(currentNode.getKey()) < 0)
				{
					if(currentNode.leftChild == null)
					{
						currentNode.setLeftChild(node);
						return;
					}
					else
					{
						currentNode = currentNode.getLeftChild();
					}
				}
				else if(node.getKey().compareTo(currentNode.getKey()) >= 0)
				{
					if(currentNode.rightChild == null)
					{
						currentNode.setRightChild(node);
						return;
					}
					else
					{
						currentNode = currentNode.getRightChild();
					}
				}
			}
		}
	}
	
	class LLNode
	{
		LLNode leftChild;
		LLNode rightChild;
		
		String key;
		
		long score;
		
		public LLNode(String key)
		{
			this.key = key;
		}
		public void setLeftChild(LLNode leftChild)
		{
			this.leftChild = leftChild;
		}
		public void setRightChild(LLNode rightChild)
		{
			this.rightChild = rightChild;
		}
		public LLNode getLeftChild()
		{
			return leftChild;
		}
		public LLNode getRightChild()
		{
			return rightChild;
		}
		public String getKey()
		{
			return key;
		}
		public void setNameScore(long score)
		{
			this.score = score;
		}
		public long getNameScore()
		{
			return score;
		}
	}
}