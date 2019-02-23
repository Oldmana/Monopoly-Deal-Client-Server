package oldmana.general.md.server.card;

import oldmana.general.md.universal.card.CardType;

public class Card
{
	private int ID;
	private CardType type;
	private String name;
	private int value;
	
	private String description;
	
	public Card(CardType type, String name, int value, String description)
	{
		this.ID = CardRegistry.generateCardID();
		this.type = type;
		this.name = name;
		this.value = value;
		
		this.description = description;
	}
	
	public Card(CardType type, String name, int value)
	{
		this.ID = CardRegistry.generateCardID();
		this.type = type;
		this.name = name;
		this.value = value;
	}
	
	public Card(CardType type, int value)
	{
		this.ID = CardRegistry.generateCardID();
		this.type = type;
		this.value = value;
	}
	
	public int getID()
	{
		return ID;
	}
	
	public CardType getType()
	{
		return type;
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getValue()
	{
		return value;
	}
	
	public String getDescription()
	{
		return description;
	}
}
