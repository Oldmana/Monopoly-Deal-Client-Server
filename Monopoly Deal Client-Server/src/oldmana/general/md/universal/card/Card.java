package oldmana.general.md.universal.card;

import java.util.ArrayList;
import java.util.List;

import oldmana.general.md.universal.Universal;
import oldmana.general.md.universal.player.Player;

public class Card
{
	private int ID;
	private String name;
	private int value;
	
	private String description;
	
	private List<Player> concealedTo = new ArrayList<Player>();
	
	public Card()
	{
		for (Player p : Universal.getGame().getPlayers())
		{
			concealedTo.add(p);
		}
	}
	
	/**A card. The server dictates most of the functionality of cards.
	 * 
	 * @param ID - Card ID
	 * @param name - Card Name
	 * @param value - Card's Monetary Value
	 */
	public Card(int ID, String name, int value)
	{
		this.ID = ID;
		this.name = name;
		this.value = value;
	}
	
	/**Get the card ID.
	 * 
	 * @return Card ID
	 */
	public int getID()
	{
		return ID;
	}
	
	/**Get the name of the card. The name does not dictate any properties of the card.
	 * 
	 * @return The card's name
	 */
	public String getName()
	{
		return name;
	}
	
	public int getValue()
	{
		return value;
	}
	
	/**Sets the description of the card
	 * 
	 * @param description
	 */
	public void setDescription(String description)
	{
		this.description = description;
	}
	
	public String getDescription()
	{
		return description;
	}
	
	public void setConcealedTo(List<Player> players)
	{
		concealedTo = players;
	}
	
	public void concealedTo(Player player)
	{
		concealedTo.add(player);
	}
	
	public void revealTo(Player player)
	{
		concealedTo.remove(player);
	}
	
	/**
	 * 
	 * @return Whether or not the card is concealed from the player
	 */
	public boolean isConcealedTo(Player player)
	{
		return concealedTo.contains(player);
	}
}
