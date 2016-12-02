package oldmana.general.md.client.gui;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLayeredPane;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import oldmana.general.md.client.ClientGame;
import oldmana.general.md.client.Utils;
import oldmana.general.md.client.gui.component.JCard;
import oldmana.general.md.client.gui.component.JCardList;
import oldmana.general.md.client.gui.component.JDeck;
import oldmana.general.md.client.gui.component.JInterface;
import oldmana.general.md.client.gui.component.JInterface.InterfaceType;
import oldmana.general.md.client.gui.component.JMDButton;
import oldmana.general.md.client.gui.component.JSet;
import oldmana.general.md.universal.card.Card;
import oldmana.general.md.universal.card.CardSet;
import oldmana.general.md.universal.card.PropertyCard;
import oldmana.general.md.universal.card.PropertyCard.PropertyType;

public class TableGUI extends JLayeredPane
{
	private static final long serialVersionUID = 8217152667978889541L;
	
	private ClientGame game;
	
	public TableGUI(ClientGame game)
	{
		this.game = game;
		
		initializeUI();
	}
	
	public void initializeUI()
	{
		SwingUtilities.invokeLater(new Runnable()
		{
			@Override
			public void run()
			{
				JDeck deck = new JDeck(null);
				add(deck, 1);
				Utils.setSizeOf(deck, 0.08, 0.2);
				Utils.setLocationOfCentered(deck, 0.45, 0.5);
				
				Card c = new Card(0, "Test Card", 3);
				JCard card = new JCard(c);
				add(card);
				Utils.setSizeOf(card, 0.06, 0.15);
				Utils.setLocationOfCentered(card, 0.1, 0.1);
				
				CardSet set = new CardSet(PropertyType.BROWN);
				PropertyCard p1 = new PropertyCard(1, PropertyType.BROWN);
				PropertyCard p2 = new PropertyCard(2, PropertyType.BROWN);
				PropertyCard p3 = new PropertyCard(3, PropertyType.BROWN);
				set.addCard(p1);
				set.addCard(p2);
				set.addCard(p3);
				final JSet jset = new JSet(set);
				//jset.setRealBounds(200, 200, (int) (getWidth() * 0.06), (int) (getHeight() * 0.3));
				add(jset);
				Utils.setRealLocationOfCentered(jset, 0.4, 0.1);
				Utils.setRealSizeOf(jset, 0.06, 0.3);
				jset.setRotation(45);
				Timer t = new Timer(25, new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent arg0)
					{
						jset.setRotation(jset.getRotation() + 0.5);
						jset.repaint();
					}
				});
				t.setRepeats(true);
				t.start();
				
				JInterface jinterface = new JInterface(InterfaceType.CARD_SELECT);
				add(jinterface, 0);
				Utils.setSizeOf(jinterface, 1.0, 1.0);
				Utils.setLocationOf(jinterface, 0, 0);
				
				JCardList list = new JCardList();
				JCard jcard = new JCard(new PropertyCard(4, PropertyType.BROWN));
				list.addCard(jcard);
				jinterface.add(list);
				Utils.setSizeOf(list, 1, 0.2);
				Utils.setLocationOf(list, 0, 0.4);
				JMDButton jmd = new JMDButton();
				jmd.setText("JMD");
				add(jmd);
				Utils.setSizeOf(jmd, 0.1, 0.05);
				Utils.setLocationOfCentered(jmd, 0.8, 0.8);
			}
		});
	}
	
	public ClientGame getGame()
	{
		return game;
	}
}
