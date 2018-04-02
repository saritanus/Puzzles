package techolutions;

import java.util.Scanner;

/**
 * 
 * This class solves the puzzle In the Future.
 * @author Sarita Sethy
 *
 */
public class InTheFuture {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//Gets all the inputs
		int a = sc.nextInt();
		int k = sc.nextInt();
		int p = sc.nextInt();
		sc.close();
		int result = minNum(a,k,p);
		System.out.println(result);
	}
	/***
	 * Calculates minimum no of days for Kelly to go ahead of Asha
	 * @param A: Asha solves A problems per day
	 * @param K: Kelly solves K problems per day
	 * @param P: Asha is P problems ahead of Kelly
	 * @return
	 */
	
	static int minNum(int A, int K, int P) {
		//Current status of the program
		int a_total = P;
		int k_total = 0;
		int min_no_days =0;
		
		//calculates minimum no of days.
		while(k_total<=a_total)
		{
			a_total = a_total+A; 
			k_total =k_total+K;
			min_no_days++;
		}
		return min_no_days;
	}

}
