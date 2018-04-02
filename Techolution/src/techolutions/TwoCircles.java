package techolutions;

import java.util.Scanner;
/***
 * This class solves TwoCircle puzzles
 * @author Sarita Sethy
 *
 */
public class TwoCircles {
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int no_inputs = sc.nextInt();
		String[] circles = new String[no_inputs];
		sc.nextLine();
		for(int i=0;i<no_inputs;i++)
		{
			String line = sc.nextLine();
			circles[i] = line;			
		}
		
		String[] results = circles(circles);
		for(String result:results)
		{
			System.out.println(result);
		}
	}
	/***
	 * Finds the relationship between circles
	 * @param info
	 * @return
	 */
	static String[] circles(String[] info) {
		String[] result = new String[info.length];
		
			for(int i=0;i<info.length;i++)
			{
				String[] circles = info[i].split(" ");
				if(circles.length==6)
				{
					//Circle A detail
					int Xa = Integer.parseInt(circles[0]);
					int Ya = Integer.parseInt(circles[1]);
					int Ra = Integer.parseInt(circles[2]);
					
					//Circle B detail
					int Xb = Integer.parseInt(circles[3]);
					int Yb = Integer.parseInt(circles[4]);
					int Rb = Integer.parseInt(circles[5]);				
				      
				    double distance = Math.pow((Xa - Xb) * (Xa - Xb) + (Ya - Yb) * (Ya - Yb), 0.5);
				    
				    if((Xa==Xb) && (Ya==Yb))
				    {
				    	result[i] = "Concentric";
				    }
				    else if ((Rb >= Ra && distance <= (Rb - Ra))||(Ra >= Rb && distance <= (Ra - Rb)))
				    {
				    		result[i] = "Touching";
				    }
				    else if (distance > (Ra + Rb))
				    {
				        result[i] = "Disjoint Outside";
				    }
				    else if(distance < (Ra + Rb))
				    {
				    	result[i] = "Intersecting";
				    }
				    else 
				    {
				    	 result[i] = "Disjoint Inside";
				    }			   
				  
			}

		}
		return result;
	}

}
