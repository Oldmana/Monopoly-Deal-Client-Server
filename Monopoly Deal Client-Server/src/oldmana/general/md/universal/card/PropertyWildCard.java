package oldmana.general.md.universal.card;

public class PropertyWildCard extends PropertyCard
{
	private PropertyType[] types;
	
	public PropertyWildCard(int ID, PropertyType[] types)
	{
		super(ID, PropertyType.WILD);
		
		this.types = types;
	}
	
	public boolean isCompatibleWith(Card card)
	{
		if (card instanceof PropertyWildCard)
		{
			PropertyWildCard wild = (PropertyWildCard) card;
			for (PropertyType type1 : wild.getTypes())
			{
				for (PropertyType type2 : getTypes())
				{
					if (type1.equals(type2))
					{
						return true;
					}
				}
			}
		}
		else if (card instanceof PropertyCard)
		{
			PropertyCard property = (PropertyCard) card;
			for (PropertyType type : getTypes())
			{
				if (type.equals(property.getType()))
				{
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean isMulticolor()
	{
		return types[0] == PropertyType.MULTICOLOR_WILD;
	}
	
	public PropertyType[] getTypes()
	{
		return types;
	}
}
