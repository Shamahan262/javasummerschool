/**
 * 
 */
package sef.module11.activity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * @author Bernards Gulbis
 * 
 */
public class ConsoleTextFileEditor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println("Simple Console Text File Editor");
		System.out.println();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		// input filename
		String fileName = ".\\bin\\sef\\module11\\activity\\" + args[0];
		File file = new File(fileName);	
		
		try {
			// creating a file	
			if (file .createNewFile()) {
				System.out.println("- new file created: " + file.getCanonicalPath());
			} else {
				System.out.println("- adding to existing file: " + file.getCanonicalPath());
			}
			PrintWriter writer = new PrintWriter(new FileWriter(file, true));

			// text input
			System.out.println("- enter a string or type 'END' to exit");
			String lineIn = "";
			while (!lineIn.equals("END")) {
				lineIn = in.readLine();
				writer.println(lineIn);
			}
			System.out.println("GOODBYE!");

			// saving text to file
			writer.flush();
			writer.close();
			in.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
