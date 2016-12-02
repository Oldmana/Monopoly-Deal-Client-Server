package oldmana.general.md.client.gui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.Timer;

import oldmana.general.md.client.Utils;
import oldmana.general.md.client.gui.component.JCard;
import oldmana.general.md.client.gui.component.JDeck;
import oldmana.general.md.client.gui.component.JSet;
import oldmana.general.md.universal.card.Card;
import oldmana.general.md.universal.card.CardSet;
import oldmana.general.md.universal.card.PropertyCard;
import oldmana.general.md.universal.card.PropertyCard.PropertyType;

public class MDWindow extends JFrame
{
	private static final long serialVersionUID = 5662091446552269705L;
	
	private MenuGUI menu;
	private TableGUI table;
	
	public MDWindow()
	{
		super("Monopoly Deal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		getContentPane().setPreferredSize(new Dimension(1600, 900));
		pack();
		setLocation((int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() - getWidth()) / 2, 
				(int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() - getHeight()) / 2);
		
		menu = new MenuGUI(this);
		menu.setSize(1600, 900);
		menu.setLocation(0, 0);
		add(menu);
		
		table = new TableGUI(null);
		table.setSize(1600, 900);
		table.setLocation(0, 0);
		table.setVisible(false);
		add(table);
	}
	
	public void showMenu()
	{
		menu.setVisible(true);
		table.setVisible(false);
	}
	
	public void showTable()
	{
		menu.setVisible(false);
		table.setVisible(true);
	}
}
