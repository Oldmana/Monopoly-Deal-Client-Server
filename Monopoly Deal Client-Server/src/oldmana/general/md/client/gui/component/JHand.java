package oldmana.general.md.client.gui.component;

import java.awt.Color;

import java.awt.Graphics;

import javax.swing.JComponent;

public class JHand extends JComponent
{
	@Override
	public void paintComponent(Graphics g)
	{
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, getWidth(), getHeight());
	}
}
