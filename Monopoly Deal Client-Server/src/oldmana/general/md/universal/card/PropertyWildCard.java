package oldmana.general.md.universal.card;

/**Represents a bicolor wild card. Bear in mind, a multicolor wild card is NOT a PropertyWildCard.
 *
 */
public class PropertyWildCard extends PropertyCard
{
	private PropertyType[] types;
	
	public PropertyWildCard(int ID, PropertyType[] types)
	{
		super(ID, null);
		
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
}
