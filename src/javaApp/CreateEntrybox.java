package javaApp;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class CreateEntrybox extends JFrame implements ActionListener{
     
      JTextField pokeName, pokeDex, output, output2;
      JButton enter;
     
     
      public CreateEntrybox(){
           
              setLayout(null);
              //set label position and content
              JLabel pokemonNameLbl = new JLabel("Pokemon Name:");
              pokemonNameLbl.setBounds(10, 20, 150, 20);
              
              //add textfield for pokemon name
              pokeName = new JTextField(5);
              pokeName.setBounds(150,20,100,20);
              
              //add label and textfield
              add(pokemonNameLbl);
              add(pokeName);
              
              //set label position and content
              JLabel pokeDexNumLbl = new JLabel("Pokedex Number:");
              pokeDexNumLbl.setBounds(10,50,150,20);
              
              //add textfield for pokemon dex number
              pokeDex = new JTextField(5);
              pokeDex.setBounds(150, 50, 100, 20);
             
              //add label and textfield.
              add(pokeDex);
              add(pokeDexNumLbl);
             
              /*
              output = new JTextField(5);
              output.setBounds(180,200,100,20);
              add(output);
              
              output2 = new JTextField(5);
              output2.setBounds(180,240,100,20);
              add(output2);
             */
             
              enter = new JButton("Enter");
              enter.setBounds(100,200,100,25);
              enter.addActionListener(this);
              add(enter);
              
           
      }
     
      public void actionPerformed(ActionEvent e) 
      {
    	  		//records action of enter button on popup window
             if(e.getSource()== enter )
             {
            	 
            	 	
            	 	//output.setText(pokeName.getText());
                   	//output2.setText(pokeDex.getText());
                   
                   	//pass global variable name and number input into textfield
                	GuiApp1.pokemonName = pokeName.getText();
                	GuiApp1.pokemonDexNumber = pokeDex.getText();
                	
                	
                	//if adding poke, write to file.
                	if (GuiApp1.operation == 1)
					{
						try {
							fileReadWrite.writeFile();
							System.out.println("Printed poke into file");
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
                	
                	
                	
             }
      }
     
      /*public static void main (String[] args)
    {
            CreateEntrybox me = new CreateEntrybox();
         me.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         me.setVisible(true);
         me.setLocation(550, 500);
         me.setSize(300, 300);
         me.setTitle("Enter new Shiny");

    }*/

}