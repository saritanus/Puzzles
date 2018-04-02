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
		
        int ticketProcessed = 0;
        int numberOfParticipants = tickets.length;
        long noOfloops = 0;
        
        //Checks if the position exists in the line
        if(numberOfParticipants > p)
        {
        	//Process tickets if the no of tickets at a given point is more than 0
            while(tickets[p] > 0)
            {
                if(tickets[ticketProcessed] != 0)
                {
                    // ticket being processed got one ticket
                    tickets[ticketProcessed] = tickets[ticketProcessed] -1;
                    // if we have reached the end of the line
                    if(ticketProcessed == numberOfParticipants -1)
                    	ticketProcessed = 0;
                    else
                    	ticketProcessed ++;
                    noOfloops ++;
                }
                else {
                    if (ticketProcessed == numberOfParticipants - 1)
                    	ticketProcessed = 0;
                    else
                    	ticketProcessed++;
                }
               
            }
        }
        return noOfloops;

	}

}
