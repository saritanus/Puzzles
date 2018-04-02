package techolutions;

import java.util.Scanner;
/***
 * Calculates the number of ways to represent a number as a sum of two or more consecutive positive integers.
 * @author Sarita Sethy
 *
 */
public class ConsecutiveSum {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		long input = sc.nextLong();
		sc.close();
		int result = consecutive(input);
		System.out.println("No of consecutive ways are "+result);
	}
	
	/***
	 * Calculates the no of ways of consecutive sums of a number
	 * @param number
	 * @return
	 */
	static int consecutive(long number) {
		
		int start = 1, end = 1;
	    int sum = 1;
	    int result=0;
	    
	    while (start <= number/2)
	    {
	        if (sum < number)
	        {
	            end += 1;
	            sum += end;
	        }
	        else if (sum > number)
	        {
	            sum -= start;
	            start += 1;
	        }
	        else if (sum == number)
	        {
	            for (int i = start; i <= end; ++i)
	                System.out.print(" "+ i);
	            System.out.println(" ");
	           result++;
	            sum -= start;
	            start += 1;
	        }
	    }
		
		
		return result;
	}

}
