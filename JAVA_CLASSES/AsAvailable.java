package tasks;

import java.applet.Applet;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class AsAvailable 
{
	public class AWTDrawPage extends Applet
	{
		private Panel cPanel;
		private Panel buttonPane;
//		int intOption=JOptionPane.YES_NO_CANCEL_OPTION;
		public void init()
		{
			int intOption=JOptionPane.showConfirmDialog(null, "test","title",0, 0, null);
			buildCpanel();
			buildButtonPanel();
			setLayout(new GridLayout(3,1));
			add(cPanel);
//			add(buttonPanel);
		}
		private void buildCpanel()
		{
			cPanel = new Panel();
			cPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		}
		private void buildButtonPanel()
		{
//			buttonPanel = new Panel();
//			Button convButton = new Button("SUPPLIER");
//			convButton.addActionListener(new ButtonListener());
//			buttonPanel.add(convButton);
		}
		private class ButtonListener implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				double ftemp, ctemp;
				
			}
		}
	}
}
