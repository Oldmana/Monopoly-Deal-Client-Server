package oldmana.general.md.client.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.SwingUtilities;

public class TestGUI extends JLayeredPane
{
	public TestGUI()
	{
		super();
		this.setLayout(new GridBagLayout());
		SwingUtilities.invokeLater(new Runnable()
		{
			@Override
			public void run()
			{
				GridBagConstraints c = new GridBagConstraints();
				c.insets = new Insets(20, 20, 20, 20);
				c.fill = GridBagConstraints.HORIZONTAL;
				c.anchor = GridBagConstraints.CENTER;
				c.gridx = 0;
				c.gridy = 0;
				c.weighty = 0.2;
				c.weightx = 0.1;
				
				
				JButton b1 = new JButton("Retardation");
				//b1.setPreferredSize(new Dimension(500, 500));
				TestGUI.this.add(b1, c);
				c.gridx = 1;
				c.gridy = 1;
				c.weighty = 0.9;
				TestGUI.this.add(new JButton("Retardation2"), c);
			}
		});
	}
}
