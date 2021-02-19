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

public class UserIO {
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		
			System.out.println("Please enter a file name for input");
			String empty = "";
			String input = "";
			String output = "";
			String current = "";
	        while (sc.hasNext()){		//input validation for the input file
		           current =  sc.next();
	        	if(current.equals("input") || current.equals("inputm"))
	        	{
	        		break;
	        	}
	            System.out.println("Please enter a valid name for an input file. Your choices are input or inputm");
	        }
	        
	        if(current.equals("input"))												
	        {
	        	input = "input.txt";
	        } else if (current.equals("inputm"))
	        {
	        	input = "inputm.txt";
	        }
	        
	        System.out.println("Input file set to " + input + "\nEnter a name for an output file!");
	        File in = new File(input);										// set the input file in accordance to the upper if/else statement
	        
	        while  (!sc.hasNext("formated"))						// input validation for the output file
	        {
	        	System.out.println("Please enter a valid name for an output file. The only output file is caled formated");
	        	sc.next();
	        }
	        
	        File out = new File("formated.txt");					// set the output file
	        System.out.println("The selected file are " + input + " and formated, for input and output respectively! \nType capital if you want your file to be printed in capital letters or anything else if you want a regular output");
	        String choice = "";
	        sc.next();
	        choice = sc.next();
			try {
					Scanner scn = new Scanner (in); 							// creating a scanner obj
					FileWriter writer = new FileWriter(out); 				//creating a filewriter obj

				while (scn.hasNextLine())											// while there is a next line in the file
				{
					int count = 0; 															// checks if the current person has a middle name
					String line = scn.nextLine();									// creating a string to be equal to the current line
					Scanner scline = new Scanner(line);						// creating a scanner object for that line
					// printing everything in capital letters
					while (scline.hasNext()) {										// loops through every token in this string
						String el = scline.next();
						String sub = el.substring(0, 1);							// a string to amend the first letter of each name
						if(choice.equalsIgnoreCase("capital"))				//checks if the user want the text to be printed/written in capital letters
						{
							if (el.length() == 1) {										// changes the middle name to capital letter followd by a dot
								writer.write(el.toUpperCase() + ". ");
								System.out.print(el.toUpperCase() + ". ");

							} else if (sub.equals("0") || sub.equals("1") || sub.equals("2") || sub.equals("3")  // checks if the next token is a digit
									|| sub.equals("4") || sub.equals("5") || sub.equals("6") || sub.equals("7")
									|| sub.equals("8") || sub.equals("9")) {
								String d = el.substring(0, 2);
								String m = el.substring(2, 4);
								String y = el.substring(4, el.length());
								String date = d + "/" + m + "/" + y;
								if(count>2) {
									writer.write(String.format("%-5s%10s",empty, date));
									System.out.printf("%-5s%10s",empty, date);				// printing the date in the format dd/mm/yyyy	
								} else {
									writer.write(String.format("%-8s%10s",empty, date));
									System.out.printf("%-8s%10s",empty, date);				// printing the date in the format dd/mm/yyyy
								}

							} else {
								writer.write(String.format("%-10S", el + " "));	//prints to the console
								System.out.printf("%-10S", el + " ");					//writes to the file

							}
						} else {																			//regular print/write
							{
								if (el.length() == 1) {											// checks for a middle name and amends it
									writer.write(el.toUpperCase() + ". ");
									System.out.printf("%-3s", el.toUpperCase() + ". ");

								} else if (sub.equals("0") || sub.equals("1") || sub.equals("2") || sub.equals("3")  // checks if the next token is a digit
										|| sub.equals("4") || sub.equals("5") || sub.equals("6") || sub.equals("7")
										|| sub.equals("8") || sub.equals("9")) {
									String d = el.substring(0, 2);
									String m = el.substring(2, 4);
									String y = el.substring(4, el.length());
									String date = d + "/" + m + "/" + y;
									if(count>2) {
										writer.write(String.format("%-5s%10s",empty, date));
										System.out.printf("%-5s%10s",empty, date);				// printing the date in the format dd/mm/yyyy	
									} else {
										writer.write(String.format("%-8s%10s",empty, date));
										System.out.printf("%-8s%10s",empty, date);				// printing the date in the format dd/mm/yyyy
									}

								} else {																				 // formating so that the first letters of the names are capital
									String n = el.substring(1, el.length());
									String first = el.substring(0, 1);
									String names = first.toUpperCase() + n + " ";
									System.out.printf("%-10s", names);							//prints to the console
									writer.write(String.format("%-10s", names));				//writes to the file

								}

							}
						}
						count++;
				}	
					writer.write("\n"); 												// writes a line in the output file
					System.out.print("\n");										//prints a line 
				}
				writer.close();
			} catch (FileNotFoundException e) {
				System.out.println("file not found");
				e.printStackTrace();
			} catch (IOException e)
			{
				System.out.println("Wrong input");
				e.printStackTrace();
			}
	}
}