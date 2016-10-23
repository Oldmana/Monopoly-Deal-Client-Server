package oldmana.general.md.client.gui;

import java.awt.Graphics;

import javax.swing.JLayeredPane;

import oldmana.general.md.client.ClientGame;
import oldmana.general.md.client.Utils;
import oldmana.general.md.client.gui.component.JDeck;

public class TableGUI extends JLayeredPane
{
	private static final long serialVersionUID = 8217152667978889541L;
	
	private ClientGame game;
	
	public TableGUI(ClientGame game)
	{
		this.game = game;
	}
	
	public ClientGame getGame()
	{
		return game;
	}
}
