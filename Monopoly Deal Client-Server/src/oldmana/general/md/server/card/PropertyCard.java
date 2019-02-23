package oldmana.general.md.server.card;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import oldmana.general.md.universal.card.CardType;
import oldmana.general.md.universal.card.PropertyType;

public class PropertyCard extends Card
{
	private List<PropertyType> types;
	
	private PropertyType activeType;
	
	public PropertyCard(String name, int value, PropertyType... types)
	{
		super(CardType.PROPERTY, name, value);
		this.types = new ArrayList<PropertyType>(Arrays.asList(types));
		
		activeType = types[0];
	}
	
	public boolean isSolid()
	{
		return types.size() == 1;
	}
	
	public PropertyType getActivePropertyType()
	{
		return activeType;
	}
	
	public void setActivePropertyType(PropertyType type)
	{
		activeType = type;
	}
	
	public boolean isBi()
	{
		return types.size() == 2;
	}
	
	public boolean isPropertyWildCard()
	{
		return types.size() == 9;
	}
	
	public List<PropertyType> getPropertyTypes()
	{
		return types;
	}
}
