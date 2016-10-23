package oldmana.general.md.client.gui.component;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

import oldmana.general.md.client.ClientGame;

public class JDeck extends JComponent
{
	private static final long serialVersionUID = 5539316043808413505L;
	
	private ClientGame game;
	
	public JDeck(ClientGame game)
	{
		this.game = game;
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		g.setColor(Color.RED);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.BLACK);
		g.drawString("Deck", 1, getHeight() / 2);
	}
}
