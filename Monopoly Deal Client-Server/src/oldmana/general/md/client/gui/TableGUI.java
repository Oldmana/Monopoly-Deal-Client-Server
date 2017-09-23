package oldmana.general.md.client.gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import oldmana.general.md.client.ClientGame;
import oldmana.general.md.client.GraphicsUtils;
import oldmana.general.md.client.Utils;
import oldmana.general.md.client.gui.component.JCard;
import oldmana.general.md.client.gui.component.JCardPile;
import oldmana.general.md.client.gui.component.JDeck;
import oldmana.general.md.client.gui.component.JInterface;
import oldmana.general.md.client.gui.component.JInterface.InterfaceType;
import oldmana.general.md.client.gui.component.JMDButton;
import oldmana.general.md.client.gui.component.JPlayerTable;
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
				GridBagLayout l = new GridBagLayout();
				//l.columnWidths = new int[] {0, 0, 0, 0, 0};
				//l.rowHeights = new int[] {0, 0, 0};
				
				setLayout(l);
				
				GridBagConstraints c = new GridBagConstraints();
				
				c.insets = new Insets(5, 5, 5, 5);
				
				c.gridx = 0;
				c.gridy = 0;
				c.gridheight = 3;
				c.fill = GridBagConstraints.BOTH;
				//c.anchor = GridBagConstraints.LINE_START;
				c.weightx = 0.4;
				c.weighty = 1;
				JPlayerTable t1 = new JPlayerTable();
				add(t1, c);
				c.gridx = 3;
				c.gridy = 0;
				JPlayerTable t2 = new JPlayerTable();
				add(t2, c);
				
				
				c.gridx = 1;
				c.gridy = 0;
				c.gridheight = 1;
				c.gridwidth = 2;
				c.weightx = 1;
				c.weighty = 0.2;
				JPlayerTable t3 = new JPlayerTable();
				add(t3, c);
				c.gridx = 1;
				c.gridy = 2;
				JPlayerTable t4 = new JPlayerTable();
				add(t4, c);
				
				
				c.fill = GridBagConstraints.BOTH;
				c.weightx = 0.1;
				c.weighty = 0.14;
				c.gridx = 1;
				c.gridy = 1;
				c.gridwidth = 2;
				c.gridheight = 1;
				c.anchor = GridBagConstraints.LINE_START;
				//add(new JCard(new PropertyCard(1, PropertyType.BROWN)), c);
				final JCardPile pile = new JCardPile(4, 2);
				pile.putCard(new JCard(new PropertyCard(2, PropertyType.BROWN)));
				pile.putCard(new JCard(new PropertyCard(3, PropertyType.PURPLE)));
				pile.putCard(new JCard(new PropertyCard(4, PropertyType.LIGHT_BLUE)));
				pile.putCard(new JCard(new PropertyCard(5, PropertyType.PURPLE)));
				
				//final JCard deck = new JCard(new PropertyCard(1, PropertyType.BROWN));
				final JCard discard = new JCard(new PropertyCard(2, PropertyType.PURPLE));
				JPanel center = new JPanel()
				{
					@Override
					public void repaint()
					{
						super.repaint();
						int w = getWidth();
						int h = getHeight();
						//deck.setSize(GraphicsUtils.adjustToDimension(getSize(), deck.getXToYRatio()));
						//deck.setSize(new Dimension((int) (h / 1.4), h));
						//deck.setLocation((int) ((w / 2) - (h / 1.4)), 0);
						//deck.setLocation(0, 0);
						pile.setSize(GraphicsUtils.adjustToDimension(getSize(), 2));
						pile.setLocation(0, 0);
						discard.setSize(new Dimension((int) (h / 1.4), h));
						discard.setLocation((int) (w) / 2, 0);
					}
				};
				add(center, c);
				
				JCardPile hand = new JCardPile(11, 5);
				hand.putCard(new JCard(new PropertyCard(6, PropertyType.BROWN)));
				hand.putCard(new JCard(new PropertyCard(7, PropertyType.RED)));
				hand.putCard(new JCard(new PropertyCard(8, PropertyType.LIGHT_BLUE)));
				hand.putCard(new JCard(new PropertyCard(9, PropertyType.BLUE)));
				hand.putCard(new JCard(new PropertyCard(10, PropertyType.PURPLE)));
				c.gridx = 0;
				c.gridy = 4;
				c.gridheight = 2;
				c.gridwidth = 4;
				c.weightx = 1;
				c.weighty = 0.3;
				add(hand, c);
				
				center.setLayout(null);
				int w = center.getWidth();
				int h = center.getHeight();
				//deck.setSize(new Dimension((int) (h / 1.4), h));
				//deck.setLocation((int) (w - (h / 1.4)) / 2, 0);
				//center.add(deck);
				
				center.add(pile);
				
				discard.setSize(new Dimension((int) (h / 1.4), h));
				discard.setLocation((int) (w) / 2, 0);
				center.add(discard);
			}
		});
		
		/**
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
		**/
	}
	
	public ClientGame getGame()
	{
		return game;
	}
}
