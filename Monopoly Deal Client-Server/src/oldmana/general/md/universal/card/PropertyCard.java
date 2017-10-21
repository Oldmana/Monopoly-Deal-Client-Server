package oldmana.general.md.universal.card;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class PropertyCard extends Card
{
	private List<PropertyType> types;
	
	public PropertyCard(int ID, PropertyType type)
	{
		super(ID, type.name(), type.getValue());
		types = new ArrayList<PropertyType>();
		types.add(type);
	}
	
	public PropertyCard(int ID, String name, int value, List<PropertyType> types)
	{
		super(ID, name, value);
		this.types = types;
	}
	
	public PropertyType getType()
	{
		return types.get(0);
	}
	
	public List<PropertyType> getTypes()
	{
		return types;
	}
	
	public List<PropertyType> getCommonTypes(PropertyCard... otherCards)
	{
		List<PropertyType> commonTypes = new ArrayList<PropertyType>();
		for (PropertyType type : getTypes())
		{
			boolean compatible = true;
			for (PropertyCard otherCard : otherCards)
			{
				if (!otherCard.getTypes().contains(type))
				{
					compatible = false;
					break;
				}
			}
			if (compatible)
			{
				commonTypes.add(type);
			}
		}
		return commonTypes;
	}
	
	public boolean isSolid()
	{
		return types.size() == 1;
	}
	
	public boolean isBi()
	{
		return types.size() == 2;
	}
	
	public boolean isMulti()
	{
		return types.size() > 2;
	}
	
	public enum PropertyType
	{
		BROWN(1, 2, new int[] {1, 2}, new Color(139, 69, 19)),
		LIGHT_BLUE(1, 3, new int[] {1, 2, 3}, new Color(0, 191, 255)),
		PURPLE(2, 3, new int[] {1, 2, 3}, new Color(106, 90, 205)),
		ORANGE(2, 3, new int[] {1, 2, 3}, Color.ORANGE),
		RED(3, 3, new int[] {1, 2, 3}, Color.RED),
		YELLOW(3, 3, new int[] {1, 2, 3}, Color.YELLOW),
		GREEN(4, 3, new int[] {1, 2, 3}, Color.GREEN),
		BLUE(4, 2, new int[] {3, 8}, Color.BLUE),
		RAILROAD(2, 4, new int[] {1, 2, 3, 4}, Color.BLACK);
		
		
		private int value;
		private int maxSet;
		private int[] rent;
		
		private Color color;
		
		PropertyType(int value, int maxSet, int[] rent, Color color)
		{
			this.value = value;
			this.maxSet = maxSet;
			this.rent = rent;
			
			this.color = color;
		}
		
		public int getValue()
		{
			return value;
		}
		
		public int getMaxSet()
		{
			return maxSet;
		}
		
		public int getRent(int setCount)
		{
			return rent[setCount - 1];
		}
		
		public Color getColor()
		{
			return color;
		}
		
		/**Method is here solely for easy identification when sending property types through packets.
		 * 
		 * @param hashCode - The type's hash code.
		 * @return The PropertyType with the corresponding hash code.
		 */
		public static PropertyType typeOf(int hashCode)
		{
			for (PropertyType type : values())
			{
				if (type.hashCode() == hashCode)
				{
					return type;
				}
			}
			return null;
		}
	}
}
