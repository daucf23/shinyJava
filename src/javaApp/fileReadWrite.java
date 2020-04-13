package javaApp;

import java.io.IOException;
import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.awt.datatransfer.StringSelection;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;


public class fileReadWrite {
	
	public static String[] shinyList;	
	
	public static void createFile() throws IOException
	{
		//File shinyFile = new File("/javaShiny/output/shiny.txt");
		File shinyFile = new File("shiny.txt");

		
		if(shinyFile.createNewFile())System.out.println("Success!");
        else System.out.println ("Error, file already exists.");
	}
	
	public static void writeFile() throws IOException 
	{
		
		if(GuiApp1.operation == 1) 
		{
			BufferedWriter out = new BufferedWriter(new FileWriter("shiny.txt", true));
			Scanner scanny = new Scanner("shiny.txt");
			String input = new String(scanny.nextLine());
			
			while(scanny.hasNextLine())
			{
				input = scanny.nextLine();
				out.write(input);
				
			}
			out.write(GuiApp1.pokemonName +"\n");
	        out.write(GuiApp1.pokemonDexNumber+"\n");
	        //out.
	        out.close();
	        System.out.println("added poke successfully");
	        scanny.close();
		}
		if(GuiApp1.operation == -1) 
		{
			BufferedWriter out = new BufferedWriter(new FileWriter("shiny.txt", true));
			Scanner scanny = new Scanner("shiny.txt");
			String input = new String(scanny.nextLine());
			
			while(scanny.hasNextLine())
			{
				input = scanny.nextLine();
				out.write(input);
				
			}
			out.write(GuiApp1.pokemonName +"\n");
	        out.write(GuiApp1.pokemonDexNumber+"\n");
	        //out.
	        out.close();
	        System.out.println("added poke successfully");
	        scanny.close();
		}
		
	}
	
	public static void readFile() throws IOException 
	{
		File shinyFile = new File("shiny.txt");
		Scanner scanny = new Scanner(shinyFile);
		List<String> list = new ArrayList<String>();
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
	}
	
}
