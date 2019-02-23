package oldmana.general.md.server.card;

import java.util.ArrayList;
import java.util.List;

import oldmana.general.md.server.card.PropertyCard;
import oldmana.general.md.universal.card.PropertyType;

public class CardSet
{
	private List<PropertyCard> properties = new ArrayList<PropertyCard>(4);
	
	private PropertyType setType;
	
	public CardSet()
	{
		
	}
	
	public PropertyType getSetType()
	{
		return setType;
	}
	
	public void setSetType(PropertyType type)
	{
		setType = type;
	}
	
	public void addProperty(PropertyCard card)
	{
		if (properties.isEmpty())
		{
			setType = card.getActivePropertyType();
		}
		properties.add(card);
	}
	
	public void removeProperty(PropertyCard card)
	{
		properties.remove(card);
	}
	
	public boolean isCompatibleWithSet(PropertyCard prop)
	{
		return prop.getPropertyTypes().contains(setType);
	}
	
	public int getRent()
	{
		return setType.getRent(properties.size());
	}
}
