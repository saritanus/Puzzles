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
		Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        
        String[] circles = new String[size];

        for (int i = 0; i < size; i++) {

            circles[i] = scanner.nextLine();

        }

        String[] results = circles(circles);
        for (int i = 0; i < results.length; i++) {
            String s = results[i];
            System.out.println(s);
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
				      
				    double distanceSquare = (Xa - Xb) * (Xa - Xb) + (Ya - Yb) * (Ya - Yb);				    
				    double radiusSumSquare = (Ra +Rb)*(Ra +Rb);
				    double radiusSubSquare = (Ra -Rb)*(Ra -Rb);
				    
				    //If coordinates are same, its concentric which means both have same centre point
				    if((Xa==Xb) && (Ya==Yb))
				    {
				    	result[i] = "Concentric";
				    }
				    else if(distanceSquare == radiusSumSquare || distanceSquare ==radiusSubSquare)
				    {
				    	result[i] = "Touching";
				    }
				    else if (distanceSquare<radiusSumSquare && distanceSquare>radiusSubSquare)
				    {				    	
				    	result[i] = "Intersecting";
				    }
				    else if (distanceSquare > radiusSumSquare)
				    {
				        result[i] = "Disjoint‐Outside";
				    }
				    else if (distanceSquare<radiusSubSquare)
				    {
				    	result[i] = "Disjoint‐Inside";
				    	
				    }			   
				  
			}

		}
		return result;
	}

}
