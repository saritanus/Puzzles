package techolutions;

import java.util.Scanner;
/***
 * This class solves Psychometric Testing puzzle
 * @author Sarita Sethy
 *
 */
public class PsychometricTesting {
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int noApplicants = sc.nextInt();
		int[] scores = new int[noApplicants];
		
		//Gets scores of the applicants
		for(int i=0 ; i<noApplicants;i++)
		{
			int score = sc.nextInt();
			scores[i] = score;
		}
		
		int noLowerLimits = sc.nextInt();
		int[] lowerLimits = new int[noLowerLimits];
		for(int i=0 ; i<noLowerLimits;i++)
		{
			int lowerLimit = sc.nextInt();
			lowerLimits[i] = lowerLimit;
		}
		
		int noUpperLimits = sc.nextInt();
		int[] upperLimits = new int[noUpperLimits];
		for(int i=0 ; i<noUpperLimits;i++)
		{
			int upperLimit = sc.nextInt();
			upperLimits[i] = upperLimit;
		}
		
		int[] results = jobOffers( scores,  lowerLimits, upperLimits);
		for(int i=0;i<results.length;i++)
		{
			System.out.print(results[i]);
			System.out.print(" ");
		}
		
	}
	/***
	 * Finds the applicants who falls in the range of lower and upper limits
	 * @param scores : Score of each applicant
	 * @param lowerLimits : Lower limits
	 * @param upperLimits : Upper Limits
	 * @return
	 */
	static int[] jobOffers(int[] scores, int[] lowerLimits, int[]upperLimits)
	{
		//Gets the minimum length between two arrays
		int length = Math.min(lowerLimits.length, upperLimits.length);
		int[] result = new int[lowerLimits.length];	
		
		for(int index=0;index<length; index++)
		{
			int count=0;
			int lowerLimit = lowerLimits[index];
			int upperLimit = upperLimits[index];
			
			for(int score : scores)
			{
				//If score of the applicants falls in the below ranges, increase the counter
				if(score>=lowerLimit && score<=upperLimit)
				{
					count++;
				}
			}
			result[index] = count;
		}
		return result;
	}

}
