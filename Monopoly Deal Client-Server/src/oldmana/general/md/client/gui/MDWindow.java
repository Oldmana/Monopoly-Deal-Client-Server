package oldmana.general.md.client.gui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import oldmana.general.md.client.Utils;
import oldmana.general.md.client.gui.component.JCard;
import oldmana.general.md.client.gui.component.JDeck;
import oldmana.general.md.client.gui.component.JSet;
import oldmana.general.md.universal.card.Card;
import oldmana.general.md.universal.card.CardSet;
import oldmana.general.md.universal.card.PropertyCard;
import oldmana.general.md.universal.card.PropertyCard.PropertyType;
import oldmana.general.md.universal.gui.MainMenuGUI;

public class MDWindow extends JFrame
{
	private static final long serialVersionUID = 5662091446552269705L;
	
	private static MenuGUI menu;
	private static MainMenuGUI mainMenu;
	private static TableGUI table;
	
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
		menu.setVisible(false);
		add(menu);
		
		table = new TableGUI(null);
		table.setSize(1600, 900);
		table.setLocation(0, 0);
		table.setVisible(false);
		add(table);
		
		mainMenu = new MainMenuGUI();
		mainMenu.setSize(1600, 900);
		mainMenu.setLocation(0, 0);
		mainMenu.setVisible(true);
		add(mainMenu);
		
		final TestGUI test = new TestGUI();
		test.setSize(1600, 900);
		test.setLocation(0, 0);
		test.setVisible(false);
		add(test);
		
		this.addComponentListener(new ComponentAdapter()
		{
			@Override
			public void componentResized(ComponentEvent event)
			{
				table.setSize(getContentPane().getSize());
				table.validate();
				
				test.setSize(getContentPane().getSize());
			}
		});
	}
	
	public static void showMenu()
	{
		menu.setVisible(true);
		table.setVisible(false);
	}
	
	public static void showTable()
	{
		menu.setVisible(false);
		mainMenu.setVisible(false);
		table.setVisible(true);
	}
}
