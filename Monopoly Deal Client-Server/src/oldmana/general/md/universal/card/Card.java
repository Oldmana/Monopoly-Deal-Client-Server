package oldmana.general.md.universal.card;

public class Card
{
	private int ID;
	private String name;
	private int value;
	
	private String description;
	
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
}
