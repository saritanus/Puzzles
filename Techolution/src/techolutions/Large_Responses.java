package techolutions;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * This class solves the Large Respnse puzzle
 * @author Sarita Sethy
 *
 */
public class Large_Responses {

  public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		//Gets the input file name
		String fileName = sc.nextLine();
		
		if(fileName!=null)
		{
			 findLargeReponse(fileName);
		}
		sc.close();
		
	}
	
	/***
	 * Calculates which request has large response
	 * @param inputFileName
	 * @throws IOException
	 */
	static void findLargeReponse(String inputFileName) throws IOException
	{
		Scanner sc = null;
		BufferedWriter writer = null;
		try {
			  Path p = Paths.get(inputFileName);
			  String fileName = p.getFileName().toString();
			  String directory = p.getParent().toString();
			  
			  //Define the name output file
			  String outputFileName = "bytes_"+fileName;
			  
			  sc = new Scanner(new File(inputFileName));
			  int count=0;
			  long bytesTotal = 0;
			  
			  //Read lines from the files
			  while (sc.hasNextLine()) {
		            String line = sc.nextLine();
		            long bytes = Integer.parseInt((line.substring(line.lastIndexOf(" "))).trim());
		            if(bytes>5000)
		            {
		            	count ++;
		            	bytesTotal = bytesTotal+bytes;
		            }
		        }
			  //Write into o a file
			  writer = new BufferedWriter(new FileWriter(directory+"\\"+outputFileName));
			  writer.write(String.valueOf(count));
			  writer.newLine();
			  writer.write(String.valueOf(bytesTotal));		 
			 
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}
		finally
		{
			if(sc!=null) sc.close();
			if(writer!=null) writer.close();
		}
	}
	
	

}
