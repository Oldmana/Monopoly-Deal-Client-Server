package oldmana.general.md.universal.card;

public enum CardType
{
	MONEY(0), ACTION(1), PROPERTY(2), EXTENSION(3), REACTIVE(4);
	
	int ID;
	
	CardType(int ID)
	{
		this.ID = ID;
	}
	
	public int getID()
	{
		return ID;
	}
	
	public static CardType getTypeByID(int ID)
	{
		for (CardType type : CardType.values())
		{
			if (type.getID() == ID)
			{
				return type;
			}
		}
		return null;
	}
}
