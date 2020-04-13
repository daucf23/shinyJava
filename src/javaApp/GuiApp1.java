package javaApp;

//Imports are listed in full to show what's being used
//could just import javax.swing.* and java.awt.* etc..
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
public class GuiApp1 
{
	//Note: Typically the main method will be in a
	//separate class. As this is a simple one class
	//example it's all in the one class.
	
	JTextField input,output;
    JButton print;
    public static String pokemonName;
    public static String pokemonDexNumber;
    public static int operation = 0; 
    
    // operation == 1 means writing to file..... operation == 0 means read file;
    // operation == -1 means remove from file;
	
	public static void main(final String[] args) {
		new GuiApp1();
	}

	public GuiApp1() {
		final JFrame guiFrame = new JFrame();

		// make sure the program exits when the frame closes
		guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		guiFrame.setTitle("Shiny Pokemon");
		guiFrame.setSize(300, 300);

		// This will center the JFrame in the middle of the screen
		guiFrame.setLocationRelativeTo(null);

		// Options for the JComboBox
		final String[] menuOptions = { "Create List", "Add Shiny", "List Shinies", "Remove Shinies" };

		// The first JPanel contains a JLabel and JCombobox
		final JPanel comboPanel = new JPanel();
		final JLabel comboLbl = new JLabel("Make a Selection:");
		final JComboBox dropMenu = new JComboBox(menuOptions);
		comboPanel.add(comboLbl);
		comboPanel.add(dropMenu);

		// Create the third JPanel. Add a JLabel and JList and
		// make use the JPanel is not visible.
		final JPanel listPanel = new JPanel();
		listPanel.setVisible(false);
		final JLabel listLbl = new JLabel("Shinies:");
		listPanel.add(listLbl);
		final JButton selectBut = new JButton("Select");

		// The ActionListener class is used to handle the
		// event that happens when the user clicks the button.
		// As there is not a lot that needs to happen we can
		// define an anonymous inner class to make the code simpler.
		selectBut.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(final ActionEvent event) {
				// When the fruit of veg button is pressed
				// the setVisible value of the listPanel and
				// comboPanel is switched from true to
				// value or vice versa.
				// System.out.println((String)dropMenu.getSelectedItem());
				if ("Create List" == (String) dropMenu.getSelectedItem()) {
					try {
						fileReadWrite.createFile();
					} catch (final IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else if ("Add Shiny" == (String) dropMenu.getSelectedItem()) {
					operation = 1;
					create();
				} else if ("List Shinies" == (String) dropMenu.getSelectedItem()) {
					try {
						display();
						System.out.println("Display method reached");
					} catch (final IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else if ("Remove Shinies" == (String) dropMenu.getSelectedItem()) {
					remove();
				} else {
					System.exit(0);
				}
			}
		});
		// The JFrame uses the BorderLayout layout manager.
		// Put the two JPanels and JButton in different areas.
		guiFrame.add(comboPanel, BorderLayout.NORTH);
		guiFrame.add(listPanel, BorderLayout.CENTER);
		guiFrame.add(selectBut, BorderLayout.SOUTH);
		// make sure the JFrame is visible
		guiFrame.setVisible(true);
	}

	public static void create() {

		// System.out.println("hello world");
		final CreateEntrybox me = new CreateEntrybox();

		// me.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		me.setVisible(true);
		me.setLocationRelativeTo(null);
		me.setSize(300, 300);
		me.setTitle("Enter new Shiny");

	}

	public static void display() throws IOException {
		operation = 0;
		fileReadWrite.readFile();
		// System.out.println("hello world");
		final CreateDisplaybox me = new CreateDisplaybox();

		// me.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		me.setVisible(true);
		me.setLocationRelativeTo(null);
		me.setSize(300, 300);
		me.setTitle("List of Shiny Pokemon");

	}

	public static void remove() {
		operation = -1;
		// System.out.println("hello world");
		final CreateEntrybox me = new CreateEntrybox();
			
			//me.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			me.setVisible(true);
			me.setLocationRelativeTo(null);
			me.setSize(300, 300);
			me.setTitle("Removing Shiny");
	}


	
}
