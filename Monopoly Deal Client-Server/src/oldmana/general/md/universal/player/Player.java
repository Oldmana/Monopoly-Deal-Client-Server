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
	
	private List<CardSet> sets = new ArrayList<CardSet>();
	private CashPile cash = new CashPile();
	
	private RentStatus rentStatus = new RentStatus();
	
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
		sets.add(set);
	}
	
	public List<CardSet> getSets()
	{
		return sets;
	}
	
	/**Checks if the player has a solid set of the specified property type.
	 * 
	 * @param type - The type of property
	 * @return Whether or not the player has a solid set of the property type. Does not need to be complete set to
	 * return true.
	 */
	public boolean hasSolidSet(PropertyType type)
	{
		for (CardSet set : sets)
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
		for (CardSet set : sets)
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
		for (CardSet set : sets)
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
	public void grantPropertySafely(PropertyCard prop)
	{
		if (prop instanceof PropertyWildCard)
		{
			PropertyWildCard wild = (PropertyWildCard) prop;
			boolean success = false;
			// Attempt to place card in an existing set without creating a monopoly
			for (CardSet set : sets)
			{
				if ((set.getSetType() == wild.getTypes()[0] || set.getSetType() == wild.getTypes()[1]) &&
						set.canSafelyAddCard())
				{
					set.addCard(prop);
					success = true;
					break;
				}
				else if (set.isAmbiguous() && (set.getOtherType() == wild.getTypes()[0] || 
						set.getOtherType() == wild.getTypes()[1]) && set.canSafelyAddCard())
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
				sets.add(set);
			}
		}
		else
		{
			boolean success = false;
			for (CardSet set : sets)
			{
				if (set.getSetType() == prop.getType() && set.canSafelyAddCard())
				{
					set.addCard(prop);
					success = true;
				}
			}
			if (!success)
			{
				CardSet set = new CardSet(prop.getType());
				set.addCard(prop);
				sets.add(set);
			}
		}
	}
	
	/**<b>Side: Server</b><br><br>
	 * 
	 * Draws a card.
	 * 
	 * @return The drawn card
	 */
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
	
	public RentStatus getRentStatus()
	{
		return rentStatus;
	}
	
	public boolean owesMoney()
	{
		return rentStatus.getOwed() > 0;
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
	
	public class RentStatus
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
				renter.getCashPile().addCash(card);
				
			}
			else if (card instanceof PropertyCard)
			{
				grantPropertySafely((PropertyCard) card);
			}
		}
	}
}
