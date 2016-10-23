package oldmana.general.md.client;

import javax.swing.UIManager;

import oldmana.general.md.client.gui.MDWindow;

public class Main
{
	public static void main(String[] args)
	{
		try
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (Exception e) {}
		
		new MDWindow().setVisible(true);
		
		
	}
}
