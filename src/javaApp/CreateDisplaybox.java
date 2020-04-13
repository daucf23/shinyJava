package javaApp;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class CreateDisplaybox extends JFrame implements ActionListener{
     
      JTextField pokeName, pokeDex, output, output2;
      JButton enter;
      
      public CreateDisplaybox(){
          
    	  	  GuiApp1.operation = 0;
    	  	  final JPanel listPanel = new JPanel();
            final JList shiniesList = new JList(fileReadWrite.shinyList);
            final JScrollPane scrollShiny = new JScrollPane(shiniesList);
            final JLabel pokemonNameLbl = new JLabel("Pokemon:");

            setLayout(null);
            // set label position and content

            pokemonNameLbl.setBounds(10, 20, 150, 20);
            scrollShiny.setBounds(100, 50, 100, 150);
            // shiniesList.setLayoutOrientation(JList.VERTICAL_WRAP);

            add(pokemonNameLbl);
            add(scrollShiny);

      }

      public void actionPerformed(final ActionEvent e) 
      {
    	  		//records action of enter button on popup window
             if(e.getSource()== enter )
             {
                	
                	
                	
             }
      }

}