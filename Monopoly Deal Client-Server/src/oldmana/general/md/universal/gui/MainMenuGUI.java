package oldmana.general.md.universal.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import oldmana.general.md.client.gui.MDWindow;

public class MainMenuGUI extends JPanel
{
	public MainMenuGUI()
	{
		initializeUI();
	}
	
	private void initializeUI()
	{
		SwingUtilities.invokeLater(new Runnable()
		{
			@Override
			public void run()
			{
				setLayout(new GridBagLayout());
				
				GridBagConstraints c = new GridBagConstraints();
				c.fill = GridBagConstraints.BOTH;
				c.insets = new Insets(10, 10, 10, 10);
				c.gridx = 0;
				c.gridy = 0;
				c.weightx = 0.5;
				c.weighty = 0.5;
				JButton client = new JButton("Client");
				client.addMouseListener(new MouseAdapter()
				{
					@Override
					public void mouseClicked(MouseEvent event)
					{
						MDWindow.showTable();
					}
				});
				add(client, c);
				c.gridx = 1;
				JButton server = new JButton("Server");
				add(server, c);
			}
		});
	}
}
