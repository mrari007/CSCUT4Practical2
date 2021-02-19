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

public class FormatNamesm {
	public static void main(String[] args) {
		try {
			for (int i = 0; i < args.length; i++) 													// loops through the passed arguments to the main method from the cmd
			{
				if (args[i].equals("input.txt") || args[i].equals("inputm.txt")) {	 // checks if one of the arguments is equal to input.txt or to inputm.txt

					File current = new File(args[i]); 												// creating a new file to be equal of the file name in the current position in args

					Scanner scn = new Scanner(current); 									// creating a scanner obj to read from that file
					while (scn.hasNextLine()) 														// scans every line in the file
					{
						String line = scn.nextLine();												// creating a string to be equal to the current line
						Scanner sc = new Scanner(line);											// creating a scanner object for that line
						// printing everything in capital letters
						while (sc.hasNext()) {															// loops through every token in this string
							String el = sc.next();
							String sub = el.substring(0, 1);

							if (args[0].equals("-u")) {												// prints everything in capital leters
								if (el.length() == 1) {
									System.out.print(el.toUpperCase() + ". ");
								} else if (sub.equals("0") || sub.equals("1") || sub.equals("2") || sub.equals("3")  // checks if the next token is a digit
										|| sub.equals("4") || sub.equals("5") || sub.equals("6") || sub.equals("7")
										|| sub.equals("8") || sub.equals("9")) {
									String d = el.substring(0, 2);
									String m = el.substring(2, 4);
									String y = el.substring(4, el.length());
									String date = d + "/" + m + "/" + y;
									System.out.printf("%15S", date);		// printing the date in the format dd/mm/yyyy
								} else {
									System.out.printf("%-10S", el + " ");
								}

							} else																				// regular print
							
							{
								if (el.length() == 1) {
									System.out.print(el.toUpperCase() + ". ");
								} else if (sub.equals("0") || sub.equals("1") || sub.equals("2") || sub.equals("3")  // checks if the next token is a digit
										|| sub.equals("4") || sub.equals("5") || sub.equals("6") || sub.equals("7")
										|| sub.equals("8") || sub.equals("9")) {
									String d = el.substring(0, 2);
									String m = el.substring(2, 4);
									String y = el.substring(4, el.length());
									String date = d + "/" + m + "/" + y;
									System.out.printf("%15s", date);				// printing the date in the format dd/mm/yyyy
								} else {																			 // formating so that the first letters of the names are capital
									String n = el.substring(1, el.length());
									String first = el.substring(0, 1);
									String names = first.toUpperCase() + n + " ";
									System.out.printf("%-10s", names);
								}

							}

						}
						System.out.print("\n");
					}

				} else {

				}
				System.out.println("\n");
			}
		} catch (IOException e) {
			System.out.println("Error");
			e.printStackTrace();
		}
	}

}
	  