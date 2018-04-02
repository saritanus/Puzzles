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
        System.out.println("Please enter no of expression");
        int t = in.nextInt();
        String[] expr  = new String[t];
        int[] replacements  = new int[t];
        
        for(int a0 = 0; a0 < t; a0++){
            String s = in.next();
            expr[a0] = s;
        }
        System.out.println("Please enter maximum replacements");
        
        for(int a0 = 0; a0 < t; a0++){
            int no = in.nextInt();
            replacements[a0] = no;
        } 
       
		int[] result = balancedOrNot(expr,replacements);
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
		
		//Checks if the string starts with ">", its not balanced
		
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
				//count no of closed bracket and compare with maximum replacements
			    int count_closed = 0;
			    int count_open = 0;
		        while (!brackets.empty())
		        { 	        
		        	if(brackets.pop()=='<')
		        		count_open++;
		        	else
		        		count_closed++;
		            
		        }
		        //Check with maximum replacements for the string to become balanced
				if(maxReplacement>=count_closed && count_open<=maxReplacement)
					check=true;
				else
					check= false;
			}
				
			
		
		
	return check;
		
	}
	
}
