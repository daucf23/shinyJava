package javaApp;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;


public class fileReadWrite {
	
	public static String[] shinyList;	
	
	public static void createFile() throws IOException
	{
		File shinyFile = new File("shiny.txt");

		if (shinyFile.createNewFile())
			System.out.println("Success!");
		else
			System.out.println("Error, file already exists.");

		shinyFile.delete();

	}

	public static void writeFile() throws IOException {
		
		if (GuiApp1.operation == 1) {
			final BufferedWriter out = new BufferedWriter(new FileWriter("shiny.txt", true));
			final Scanner scanny = new Scanner("shiny.txt");
			String input = new String(scanny.nextLine());

			while (scanny.hasNextLine()) {
				input = scanny.nextLine();
				out.write(input);

			}
			out.write(GuiApp1.pokemonName + "\n");
			out.write(GuiApp1.pokemonDexNumber + "\n");
			// out.
			out.close();
			scanny.close();
			System.out.println("added poke successfully");
		}
		if (GuiApp1.operation == -1) {
			File shinyFile = new File("shiny.txt");
			File tempFile = new File("temp.txt");
			final BufferedReader in = new BufferedReader(new FileReader(shinyFile));
			final BufferedWriter out = new BufferedWriter(new FileWriter(tempFile));
			final Scanner scanny = new Scanner(shinyFile);
			final String input = new String(scanny.nextLine());
			String currentLine;
			System.out.println(GuiApp1.pokemonName + " " + GuiApp1.pokemonDexNumber);

			while ((currentLine = in.readLine()) != null) {
				final String trimmedLine = currentLine.trim();
				if (trimmedLine.equals(GuiApp1.pokemonName)) {
					continue;
				} else if (trimmedLine.equals(GuiApp1.pokemonDexNumber)) {
					continue;
				} else {
					out.write(currentLine + System.getProperty("line.separator"));
				}
			}
			shinyFile.delete();
			tempFile.delete();
			if(tempFile.renameTo(shinyFile))
			{
				System.out.println("File renamed");
			}

			// out.
			out.close();
			System.out.println("removed poke successfully");
			scanny.close();
			in.close();
		}

	}

	public static void readFile() throws IOException {
		File shinyFile = new File("shiny.txt");
		final Scanner scanny = new Scanner(shinyFile);
		final List<String> list = new ArrayList<String>();
		while(scanny.hasNext())
		{
			list.add(scanny.next());
			System.out.println("reading file");
			//builder.append(scanny.nextLine());
			//builder.append("\n");
		}
		System.out.println("almost displaying");
		shinyList = list.toArray(new String[0]);
		System.out.println(Arrays.toString(shinyList));
		
		
		//CreateDisplaybox.shinyList = builder.toString().split(regex);
		shinyFile.delete();

		scanny.close();
	}
	
}
