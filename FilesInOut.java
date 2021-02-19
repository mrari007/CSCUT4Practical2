import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.lang.Number;
import java.io.File; // Import the File class
import java.io.FileNotFoundException; // import this class to handle errors
import java.util.Scanner; // Import the class Scanner to read text files
import java.io.FileWriter;
import java.io.IOException; // import this class to handle errors

/**
 * 
 * CSCU9T4 Java strings and files exercise.
 *
 */
public class FilesInOut {

    public static void main(String[] args) {
        // Replace this with statements to set the file name (input) and file name (output).
        // Initially it will be easier to hardcode suitable file names.
    		File input = new File ("input.txt");
        // Set up a new Scanner to read the input file.
        // Processing line by line would be sensible here.
        // Initially, echo the text to System.out to check you are reading correctly.
		try {
			Scanner scn = new Scanner (input); 				// creating a scanner obj
			while (scn.hasNextLine())
			{
				System.out.println(scn.nextLine());				// printing everything that has been scanned
			}		
		} catch (FileNotFoundException e) {
			System.out.println("Error");
			e.printStackTrace();
		}
		System.out.printf("\n");										// printing a line
		
        // Then add code to modify the text to the output format.
		try {
			Scanner scn = new Scanner (input); 								// creating a scanner obj
			while (scn.hasNextLine())
			{
				String line = scn.nextLine();
				System.out.printf("%S", line + "\n"); 			// printing the names with capital letters.
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error");
			e.printStackTrace();
		}
        // Set up a new PrintWriter to write the output file.
        // Add suitable code into the above processing (because you need to do this line by line also.
        // That is, read a line, write a line, loop.
		
		try 
		{
			Scanner scn = new Scanner (input);								 // creating a scanner obj
			FileWriter writer = new FileWriter("formated.txt"); 		// creating new FileWriter obj
			while (scn.hasNextLine())
			{
				writer.write(scn.nextLine() + "\n"); 							// writes the input in the formated.txt file
			}
			writer.close();
		} catch (IOException e)
		{
			System.out.println("Error");
			e.printStackTrace();
		}
		
        // Finally, add code to read the filenames as arguments from the command line.
		System.out.println("\nPassing the files to the args through the command line \n");
		 try {
			  for(int i = 0; i <args.length; i++) 					// loops through the passed arguments to the main method from the cmd
			  {
				  if(args[i].equals("input.txt") || args[i].equals("inputm.txt")) { 					// checks if one of the arguments is equal to input.txt
					  
				  
				  	File current = new File(args[i]);				//creating a new file to be equal of the file name in the current position in args

					  Scanner scn = new Scanner (current);	//creating a scanner obj to read from that file
					  if(args[0].equals("-u"))
					  {
						  System.out.println("Printing to upper case with a flag -u");
							while (scn.hasNextLine())
							{
								String line = scn.nextLine();
								System.out.printf("%S", line + "\n"); 			// printing the names with capital letters.
							}
						  System.out.println("\n"); // printing a line
					  } else {
							 while(scn.hasNextLine()) 						// scans every line in the file
							  {
								  System.out.println(scn.nextLine()); 	// prints everything that has been scanned
							  }

							  System.out.println("\n"); // printing a line
					  }

				  }
					  else {
						  
					  }
			  }
		  } catch (IOException e) {
			  System.out.println("Error");
				e.printStackTrace();
		  }
	  
    
    } // main

} // FilesInOut
