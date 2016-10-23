package oldmana.general.md.universal.card;

import java.util.ArrayList;
import java.util.List;

import oldmana.general.md.universal.card.PropertyCard.PropertyType;

public class CardSet
{
	private List<PropertyCard> properties = new ArrayList<PropertyCard>(4);
	
	private PropertyType setType;
	
	public CardSet(PropertyType setType)
	{
		this.setType = setType;
	}
	
	public PropertyType getSetType()
	{
		return setType;
	}
	
	public int getRent()
	{
		return setType.getRent(properties.size());
	}
	
	public boolean isComplete()
	{
		return setType.getMaxSet() <= properties.size(); // The size better not be greater than the max set..
	}
}
