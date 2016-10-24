package oldmana.general.md.universal.player;

import java.util.ArrayList;
import java.util.List;

import oldmana.general.md.server.ServerGame;
import oldmana.general.md.universal.card.Card;
import oldmana.general.md.universal.card.CardSet;
import oldmana.general.md.universal.card.PropertyCard.PropertyType;

public class Player
{
	private int ID;
	
	private List<CardSet> properties = new ArrayList<CardSet>();
	private CashPile cash = new CashPile();
	
	private Hand hand;
	private InvisibleHand invisibleHand;
	
	public Player(int ID)
	{
		this.ID = ID;
	}
	
	public int getID()
	{
		return ID;
	}
	
	public void addCardSet(CardSet set)
	{
		properties.add(set);
	}
	
	public List<CardSet> getSets()
	{
		return properties;
	}
	
	/**Checks if the player has a solid set of the specified property type.
	 * 
	 * @param type - The type of property
	 * @return Whether or not the player has a solid set of the property type. Does not need to be complete set to
	 * return true.
	 */
	public boolean hasSolidSet(PropertyType type)
	{
		for (CardSet set : properties)
		{
			if (set.getSetType() == type && set.isSolid())
			{
				return true;
			}
		}
		return false;
	}
	
	public CardSet getSolidSet(PropertyType type)
	{
		for (CardSet set : properties)
		{
			if (set.getSetType() == type && set.isSolid())
			{
				return set;
			}
		}
		return null;
	}
	
	public Card drawCard()
	{
		ServerGame game = ServerGame.getGameInstance();
		Card card = game.drawCard();
		hand.addCard(card);
		return card;
	}
	
	/**This method will always return something if on server. If on client, most likely will only know own hand.
	 * 
	 * @return Player's Hand, if known. If not, then returns null.
	 */
	public Hand getHand()
	{
		return hand;
	}
	
	/**Every player has an invisible hand. The invisible hand only reveals number of cards in hand.
	 * 
	 * @return The invisible hand
	 */
	public InvisibleHand getInvisibleHand()
	{
		return invisibleHand;
	}
}
