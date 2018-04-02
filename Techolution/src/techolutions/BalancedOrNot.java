package techolutions;
import java.util.Scanner;
import java.util.Stack;
/***
 * This class has the logic to check is balanced or not
 * @author Sarita Sethy
 *
 */
public class BalancedOrNot {

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        
        String[] expressions  = new String[size];
               
        for(int i = 0; i < size; i++){
            String s = in.next();
            expressions[i] = s;
        }
        
        int sizeMaxReplacements = in.nextInt();
        int[] replacements  = new int[sizeMaxReplacements];        
        for(int j = 0; j < sizeMaxReplacements; j++){
            int no = in.nextInt();
            replacements[j] = no;  }       
       

		int[] result = balancedOrNot(expressions,replacements);
		for(int i=0;i<result.length;i++)
			System.out.print(result[i] + " ");             
        
        in.close();
    }

	/***
	 * Checks for all input strings 
	 * @param expressions
	 * @param maxReplacements
	 * @return
	 */
	static int[] balancedOrNot(String[] expressions, int[]maxReplacements)
	{
		int[] result = new int[expressions.length];
		
		for(int i=0;i<expressions.length;i++)
		{
			if(isBalanced(expressions[i],maxReplacements[i]))
					result[i]=1;
			else
					result[i]=0;
			
		}
		return result;
    }
	/***
	 * Checks the string is balanced or not
	 * @param expression
	 * @param maxReplacement
	 * @return
	 */
	
	static boolean isBalanced(String expression, int maxReplacement)
	{
		Stack<Character> brackets = new Stack<>();
		boolean check = true;
		
		
			for(int index=0;index<expression.length();index++)
			{		
				Character current = expression.charAt(index);
				  if (current =='>' && !brackets.empty())
		          {
		                if (brackets.peek()=='<')
		                	brackets.pop();
		                else
		                	brackets.push(current);
		          }else
		        	  brackets.push(current);		  
				
			 }
			
			//Stack should be empty to become balance
			if(brackets.empty())
				check= true;
			else
			{
				  for (int rCount = 0; rCount < maxReplacement; rCount++) 
				  {
                    if (!brackets.isEmpty()) 
                    {
                        char stackChar = brackets.peek();
                        if (stackChar == '>') {
                        	brackets.pop();
                        }
                    }

				  }

                if (brackets.isEmpty())
                    check = true;
                else
                    check = false;
			}
				
			
		
		
	return check;
		
	}
	
}
