package techolutions;

import java.util.Scanner;
/***
 * This class solves Find the winner puzzle
 * @author Sarita Sethy
 *
 */
public class FindtheWinner {
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int andrea_input = sc.nextInt();
		int[] andrea_array = new int[andrea_input];
		//Gets the inputs for Andrea
		for(int i=0;i<andrea_input;i++)
		{
			int input = sc.nextInt();
			andrea_array[i] = input;
		}
		
		int maria_input = sc.nextInt();
		int[] maria_array = new int[maria_input];
		//Gets the input for Maria
		for(int i=0;i<maria_input;i++)
		{
			int input = sc.nextInt();
			maria_array[i] = input;
		}
		
		String game = sc.next();
		sc.close();
		//Gets the result
		String result = winner(andrea_array,maria_array,game);
		System.out.println("Winner is "+result);
		
	}
	/***
	 * Finds who is the winner between Maria and Andrea
	 * @param andrea: An array of n integers denoting Andrea's array.
	 * @param maria: An array of n integers denoting Maria's array.
	 * @param s: The string Odd if the game is odd, or Even if the game is even.
	 * @return
	 */
	static String winner(int[] andrea, int[] maria, String s) {
		
		String result = null;
		int length = Math.min(andrea.length, maria.length);
		int andrea_total=0;
		int maria_total=0;
		
		//Even game logic
		if(s.equals("Even"))
		{
			int index =0;
			while(index<length)
			{
				andrea_total = andrea_total + (andrea[index]-maria[index]);
				maria_total = maria_total + (maria[index]-andrea[index]);
				index=index+2;
			}			
		}
		//Odd Game logic
		else if(s.equals("Odd"))
		{
			int index =1;
			while(index<length)
			{
				andrea_total = andrea_total + (andrea[index]-maria[index]);
				maria_total = maria_total + (maria[index]-andrea[index]);
				index=index+2;
			}			
		}
		
		//Finds the winner
		if(andrea_total>maria_total)
			result = "Andrea";
		else if(andrea_total<maria_total)
			result = "Maria";
		else if(andrea_total==maria_total)
			result="Tie";
		
		return result;
		
	}
	

}
