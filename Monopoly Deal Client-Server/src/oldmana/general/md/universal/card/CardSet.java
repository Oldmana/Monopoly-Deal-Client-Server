package oldmana.general.md.universal.card;

import java.util.ArrayList;
import java.util.List;

import oldmana.general.md.universal.card.PropertyCard.PropertyType;

public class CardSet
{
	private List<PropertyCard> properties = new ArrayList<PropertyCard>(4);
	
	private PropertyType setType;
	
	public CardSet() {}
	
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
	
	public void addCard(PropertyCard card)
	{
		if (properties.size() == 0)
		{
			setType = card.getType();
		}
		properties.add(card);
	}
	
	public void removeCard(PropertyCard card)
	{
		properties.remove(card);
	}
	
	public List<PropertyCard> getCards()
	{
		return properties;
	}
	
	public int getCardCount()
	{
		return properties.size();
	}
	
	public boolean isSolid()
	{
		for (PropertyCard card : properties)
		{
			if (!card.isSolid())
			{
				return false;
			}
		}
		return true;
	}
	
	public List<PropertyType> getCommonTypes()
	{
		return properties.get(0).getCommonTypes(properties.toArray(new PropertyCard[0]));
	}
	
	// TODO: Marked for deletion
	public boolean isAmbiguous()
	{
		if (properties.size() == 1 && !properties.get(0).isSolid())
		{
			return true;
		}
		return false;
	}
	
	public boolean isCurrentlyCompatible(PropertyCard card)
	{
		if (card.getTypes().contains(getSetType()))
		{
			return true;
		}
		return false;
	}
	
	public boolean isPotentiallyCompatible(PropertyCard card)
	{
		
		return false;
	}
	
	public boolean isComplete()
	{
		return setType.getMaxSet() <= properties.size(); // The size better not be greater than the max set..
	}
	
	public boolean canSafelyAddCard()
	{
		return setType.getMaxSet() > properties.size() + 1;
	}
}
