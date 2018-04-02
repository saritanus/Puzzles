package techolutions;

import java.util.Scanner;
/**
 *  
 * This class solves Buying Show Tickets puzzle
 * @author Sarita Sethy
 *
 */
public class BuyingShowTickets {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int inputs = sc.nextInt();
		
		int[] tickets = new int[inputs];
		for(int i=0;i<inputs;i++)
		{
			int ticket = sc.nextInt();
			tickets[i]=ticket;
		}
		
		int position = sc.nextInt();
		sc.close();
		
		//Prints the result
		long waiting_time = waitingTime(tickets,position);
		System.out.println("Total waiting time: "+waiting_time);

	}
	
	/***
	 * Calculates the waiting time for a person in a certain position
	 * @param tickets
	 * @param p
	 * @return
	 */
	
	static long waitingTime(int[] tickets, int p) {
		long total = 0;
		if(tickets.length>0 && p>=0)
		{
			int queueLenghth = tickets.length;
			int required_tickets =tickets[p] ;
			
			//Checks if the no of tickets is greater then one then calculates the waiting time
			if(required_tickets>1)
			{
				while(required_tickets>1)
				{
				total= total+queueLenghth;
				required_tickets--;
				}
			}
			else
			//If no of tickets equals to 1, then it calculates the waiting time			
			total = required_tickets+p;
		}
		return total;
	}

}
