package oldmana.general.md.universal.player;

import java.util.ArrayList;
import java.util.List;

import net.teambrimis.brett.MJNetworkingAPI.MJConnection;
import oldmana.general.md.server.ServerGame;
import oldmana.general.md.universal.card.ActionCard;
import oldmana.general.md.universal.card.Card;
import oldmana.general.md.universal.card.CardSet;
import oldmana.general.md.universal.card.MoneyCard;
import oldmana.general.md.universal.card.PropertyCard;
import oldmana.general.md.universal.card.PropertyCard.PropertyType;
import oldmana.general.md.universal.card.PropertyWildCard;

public class Player
{
	private int ID;
	
	private List<CardSet> properties = new ArrayList<CardSet>();
	private CashPile cash = new CashPile();
	
	private Hand hand;
	private InvisibleHand invisibleHand;
	
	/**Only used by the server.
	 */
	private MJConnection connection;
	
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
	
	public boolean hasSafeSet(PropertyType type)
	{
		for (CardSet set : properties)
		{
			if (set.getSetType() == type && set.getCardCount() + 1 < type.getMaxSet())
			{
				return true;
			}
		}
		return false;
	}
	
	/**Intelligently places a property in a set and ensures that no monopolies are created
	 * 
	 * @param prop - Property to grant
	 */
	public void grantProperty(PropertyCard prop)
	{
		if (prop instanceof PropertyWildCard)
		{
			PropertyWildCard wild = (PropertyWildCard) prop;
			boolean success = false;
			// Attempt to place card in an existing set without creating a monopoly
			for (CardSet set : properties)
			{
				if ((set.getSetType() == wild.getTypes()[0] || set.getSetType() == wild.getTypes()[1]) &&
						set.getCardCount() + 1 < set.getSetType().getMaxSet())
				{
					set.addCard(prop);
					success = true;
					break;
				}
				else if (set.isAmbiguous() && (set.getOtherType() == wild.getTypes()[0] || 
						set.getOtherType() == wild.getTypes()[1]) && set.getCardCount() + 1 < 
						set.getOtherType().getMaxSet())
				{
					set.toggleType();
					set.addCard(prop);
					success = true;
					break;
				}
			}
			if (!success)
			{
				CardSet set = new CardSet(wild.getTypes()[0]);
				set.addCard(prop);
				properties.add(set);
			}
		}
		else
		{
			
		}
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
	
	public CashPile getCashPile()
	{
		return cash;
	}
	
	public void setConnection(MJConnection connection)
	{
		this.connection = connection;
	}
	
	/**Only used by the server. The client does not have direct connections to any players.
	 * 
	 * @return The connection to the player
	 */
	public MJConnection getConnection()
	{
		return connection;
	}
	
	public static class RentStatus
	{
		private Player renter;
		private int owed;
		
		public void setRenter(Player player)
		{
			renter = player;
		}
		
		public Player getRenter()
		{
			return renter;
		}
		
		public void setOwed(int owed)
		{
			this.owed = owed;
		}
		
		public int getOwed()
		{
			return owed;
		}
		
		public void pay(Card card)
		{
			owed -= card.getValue();
			if (card instanceof ActionCard || card instanceof MoneyCard)
			{
				// TODO: Add to cash pile
				//renter.getCashPile()
			}
			else if (card instanceof PropertyCard)
			{
				PropertyCard prop = (PropertyCard) card;
				if (card instanceof PropertyWildCard)
				{
					
				}
				else
				{
					// TODO: Better card placement logic needed
					if (renter.hasSolidSet(prop.getType()))
					{
						renter.getSolidSet(prop.getType()).addCard(prop);
					}
				}
			}
		}
	}
}
