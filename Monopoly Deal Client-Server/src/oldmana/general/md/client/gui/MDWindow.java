package oldmana.general.md.client.gui;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;

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
		menu.setSize(1500, 800);
		menu.setLocation(0, 0);
		add(menu);
		
		table = new TableGUI(null);
		table.setSize(1500, 800);
		table.setLocation(0, 0);
		table.setVisible(false);
		add(table);
		
		
		JDeck deck = new JDeck(null);
		table.add(deck);
		Utils.setSizeOf(deck, 0.08, 0.2);
		Utils.setLocationOfCentered(deck, 0.45, 0.5);
		
		Card c = new Card(0, "Test Card", 3);
		JCard card = new JCard(c);
		table.add(card);
		Utils.setSizeOf(card, 0.08, 0.2);
		Utils.setLocationOfCentered(card, 0.1, 0.1);
		
		CardSet set = new CardSet(PropertyType.BROWN);
		PropertyCard p1 = new PropertyCard(1, PropertyType.BROWN);
		PropertyCard p2 = new PropertyCard(2, PropertyType.BROWN);
		PropertyCard p3 = new PropertyCard(3, PropertyType.BROWN);
		set.addCard(p1);
		set.addCard(p2);
		set.addCard(p3);
		JSet jset = new JSet(set);
		jset.setRealBounds(200, 200, (int) (getWidth() * 0.08), (int) (getHeight() * 0.4));
		table.add(jset);
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
