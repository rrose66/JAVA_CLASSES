package etl;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import sun.security.util.Debug;

public class GridLayoutChecklist 
{
		final static boolean shouldFill = true;
	    final static boolean shouldWeightX = true;
	    final static boolean RIGHT_TO_LEFT = false;
	    public static void main(String[] args) 
	    {
	        //Schedule a job for the event-dispatching thread:
	        //creating and showing this application's GUI.
	        javax.swing.SwingUtilities.invokeLater(new Runnable() {
	            public void run() {
	                createAndShowGUI();
	            }
	        });
	    }
	 
	    public static void addComponentsToPane(Container pane)
	    {
	        if (RIGHT_TO_LEFT) 
	        {
	            pane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
	        }
	 
	        JButton button;
		    pane.setLayout(new GridBagLayout());
		    GridBagConstraints c = new GridBagConstraints();
		    if (shouldFill) 
		    {
		    //natural height, maximum width
		    	c.fill = GridBagConstraints.HORIZONTAL;
		    }
		    
		    JButton btnStart = new JButton("Start");
//		    button = new JButton("Start");
		    if (shouldWeightX) 
		    {
		    	c.weightx = 0.5;
		    }
		    c.fill = GridBagConstraints.HORIZONTAL;
		    c.gridx = 0;
		    c.gridy = 0;
//		    pane.add(button, c);
		    pane.add(btnStart,c);
//		    StartButtonListener outer = new StartButtonListener();
//		    btnStart.addActionListener(outer);
//		    btnStart.addActionListener(new StartButtonListener());
//		    btnStart.addActionListener(outer.getClass(actionPerformed));
		 
		    button = new JButton("Gather Wizard Feedback");
		    c.fill = GridBagConstraints.HORIZONTAL;
		    c.weightx = 0.5;
		    c.gridx = 0;
		    c.gridy = 1;
//		    button.addActionListener(new myActionListener());
		    pane.add(button, c);
		 
	//	    button = new JButton("Long-Named Button 4");
		    button = new JButton("Create Daily IT Connect Tickets");
		    c.fill = GridBagConstraints.HORIZONTAL;
	//	    c.ipady = 40;      //make this component tall
		    c.weightx = 0.5;
	//	    c.gridwidth = 3;
		    c.gridx = 0;
		    c.gridy = 2;
		    pane.add(button, c);
		 
		    button = new JButton("CMT Emails");
		    c.fill = GridBagConstraints.HORIZONTAL;
	//	    c.ipady = 0;       //reset to default
	//	    c.weighty = 1.0;   //request any extra vertical space
	//	    c.anchor = GridBagConstraints.PAGE_END; //bottom of space
	//	    c.insets = new Insets(10,0,0,0);  //top padding
		    c.gridx = 0;       //aligned with button 2
	//	    c.gridwidth = 2;   //2 columns wide
		    c.gridy = 3;       //third row
		    pane.add(button, c);
	
		    button = new JButton("Scan IBM Processes");
		    c.fill = GridBagConstraints.HORIZONTAL;
		    c.weightx = 0.5;
		    c.gridx = 1;
		    c.gridy = 3;
		    pane.add(button, c);
		    
		    button = new JButton("Prepare to Export Rally Data");
		    c.fill = GridBagConstraints.HORIZONTAL;
		    c.weightx = 0.5;
		    c.gridx = 0;
		    c.gridy = 4;
		    pane.add(button, c);
		    
		    button = new JButton("Manually Get Rally Exports");
		    c.fill = GridBagConstraints.HORIZONTAL;
		    c.weightx = 0.5;
		    c.gridx = 1;
		    c.gridy = 4;
		    pane.add(button, c);
	
		    button = new JButton("Process the Rally Data");
		    c.fill = GridBagConstraints.HORIZONTAL;
		    c.weightx = 0.5;
		    c.gridx = 2;
		    c.gridy = 4;
		    pane.add(button, c);
	
		    button = new JButton("View the Rally Dashboard");
		    c.fill = GridBagConstraints.HORIZONTAL;
		    c.weightx = 0.5;
		    c.gridx = 3;
		    c.gridy = 4;
		    pane.add(button, c);
		    
		    button = new JButton("Open AccuRev");
		    c.fill = GridBagConstraints.HORIZONTAL;
		    c.weightx = 0.5;
		    c.gridx = 0;
		    c.gridy = 5;
		    pane.add(button, c);
		    
		    button = new JButton("Run bat to Pull AccuRev Data");
		    c.fill = GridBagConstraints.HORIZONTAL;
		    c.weightx = 0.5;
		    c.gridx = 1;
		    c.gridy = 5;
		    pane.add(button, c);
	
		    button = new JButton("Update Incoming AccuRev Files");
		    c.fill = GridBagConstraints.HORIZONTAL;
		    c.weightx = 0.5;
		    c.gridx = 2;
		    c.gridy = 5;
		    pane.add(button, c);
	
		    button = new JButton("Backup AccuRev WS folder to y drive");
		    c.fill = GridBagConstraints.HORIZONTAL;
		    c.weightx = 0.5;
		    c.gridx = 2;
		    c.gridy = 5;
		    pane.add(button, c);
	
		    button = new JButton("Delete contents from local AccuRev dir");
		    c.fill = GridBagConstraints.HORIZONTAL;
		    c.weightx = 0.5;
		    c.gridx = 3;
		    c.gridy = 5;
		    pane.add(button, c);
	
		    button = new JButton("Open AccuRev WS then populate recursive and overwrite");
		    c.fill = GridBagConstraints.HORIZONTAL;
		    c.weightx = 0.5;
		    c.gridx = 4;
		    c.gridy = 5;
		    pane.add(button, c);
	
		    button = new JButton("Copy resource zip");
		    c.fill = GridBagConstraints.HORIZONTAL;
		    c.weightx = 0.5;
		    c.gridx = 5;
		    c.gridy = 5;
		    pane.add(button, c);
	
		    button = new JButton("Run from Eclipse");
		    c.fill = GridBagConstraints.HORIZONTAL;
		    c.weightx = 0.5;
		    c.gridx = 6;
		    c.gridy = 5;
		    pane.add(button, c);
	
		    button = new JButton("View the AccuRev Dashboard");
		    c.fill = GridBagConstraints.HORIZONTAL;
		    c.weightx = 0.5;
		    c.gridx = 7;
		    c.gridy = 5;
		    pane.add(button, c);
		    
		    button = new JButton("Run D4 S2");
		    c.fill = GridBagConstraints.HORIZONTAL;
		    c.weightx = 0.5;
		    c.gridx = 0;
		    c.gridy = 6;
		    pane.add(button, c);
		    
		    button = new JButton("Run I6 S2");
		    c.fill = GridBagConstraints.HORIZONTAL;
		    c.weightx = 0.5;
		    c.gridx = 1;
		    c.gridy = 6;
		    pane.add(button, c);
	
		    button = new JButton("Run Integration");
		    c.fill = GridBagConstraints.HORIZONTAL;
		    c.weightx = 0.5;
		    c.gridx = 2;
		    c.gridy = 6;
		    pane.add(button, c);
		    
		    button = new JButton("Copy Server Logs");
		    c.fill = GridBagConstraints.HORIZONTAL;
		    c.weightx = 0.5;
		    c.gridx = 0;
		    c.gridy = 7;
		    pane.add(button, c);
		    
		    button = new JButton("Process Server Logs By Date");
		    c.fill = GridBagConstraints.HORIZONTAL;
		    c.weightx = 0.5;
		    c.gridx = 1;
		    c.gridy = 7;
		    pane.add(button, c);
	
		    button = new JButton("De-Dup Processed Server Logs");
		    c.fill = GridBagConstraints.HORIZONTAL;
		    c.weightx = 0.5;
		    c.gridx = 2;
		    c.gridy = 7;
		    pane.add(button, c);
	
		    button = new JButton("View the Server Log Dashboard");
		    c.fill = GridBagConstraints.HORIZONTAL;
		    c.weightx = 0.5;
		    c.gridx = 3;
		    c.gridy = 7;
		    pane.add(button, c);
		    
		    button = new JButton("Open ITIL Resources");
		    c.fill = GridBagConstraints.HORIZONTAL;
		    c.weightx = 0.5;
		    c.gridx = 0;
		    c.gridy = 8;
		    pane.add(button, c);
		    
		    button = new JButton("Open Time Tracking Resources");
		    c.fill = GridBagConstraints.HORIZONTAL;
		    c.weightx = 0.5;
		    c.gridx = 1;
		    c.gridy = 8;
		    pane.add(button, c);
		    
		    button = new JButton("Save the Local HelpInfo file");
		    c.fill = GridBagConstraints.HORIZONTAL;
		    c.weightx = 0.5;
		    c.gridx = 0;
		    c.gridy = 9;
		    pane.add(button, c);
		    
		    button = new JButton("Pull HelpInfo reports from email");
		    c.fill = GridBagConstraints.HORIZONTAL;
		    c.weightx = 0.5;
		    c.gridx = 1;
		    c.gridy = 9;
		    pane.add(button, c);
		    
		    button = new JButton("Process Individual HelpInfo Reports");
		    c.fill = GridBagConstraints.HORIZONTAL;
		    c.weightx = 0.5;
		    c.gridx = 2;
		    c.gridy =9;
		    pane.add(button, c);
		    
		    button = new JButton("Process HelpInfo Trends");
		    c.fill = GridBagConstraints.HORIZONTAL;
		    c.weightx = 0.5;
		    c.gridx = 3;
		    c.gridy = 9;
		    pane.add(button, c);
		    
		    button = new JButton("Get CTQ data");
		    c.fill = GridBagConstraints.HORIZONTAL;
		    c.weightx = 0.5;
		    c.gridx = 0;
		    c.gridy = 10;
		    pane.add(button, c);
		    
		    button = new JButton("Process the Knowledge Base Data");
		    c.fill = GridBagConstraints.HORIZONTAL;
		    c.weightx = 0.5;
		    c.gridx = 0;
		    c.gridy = 11;
		    pane.add(button, c);
		    
		    button = new JButton("Process the Active Citrix User Data");
		    c.fill = GridBagConstraints.HORIZONTAL;
		    c.weightx = 0.5;
		    c.gridx = 0;
		    c.gridy = 12;
		    pane.add(button, c);
		    
		    button = new JButton("Process the updates from the Software Center");
		    c.fill = GridBagConstraints.HORIZONTAL;
		    c.weightx = 0.5;
		    c.gridx = 0;
		    c.gridy = 13;
		    pane.add(button, c);
		}
	    private class StartButtonListener implements ActionListener
	    {
	    	public void actionPerformed(ActionEvent e)
	    	{
	    		JOptionPane.showConfirmDialog(null, "Hi", "there", 0);
	    	}
	    }
//	    }
	    /**
	     * Create the GUI and show it.  For thread safety,
	     * this method should be invoked from the
	     * event-dispatching thread.
	     */
	    private static void createAndShowGUI() 
	    {
	        //Create and set up the window.
	        JFrame frame = new JFrame("GridBagLayoutDemo");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 
	        //Set up the content pane.
	        addComponentsToPane(frame.getContentPane());
	 
	        //Display the window.
	        frame.pack();
	        frame.setVisible(true);
	    }
	 
	}

