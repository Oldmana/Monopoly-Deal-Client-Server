package oldmana.general.md.universal.card;

public class PropertyCard extends Card
{
	private PropertyType type;
	
	public PropertyCard(int ID, PropertyType type)
	{
		super(ID, "", type.getValue());
		this.type = type;
	}
	
	public PropertyType getType()
	{
		return type;
	}
	
	public enum PropertyType
	{
		WILD(0, 0, null),
		MULTICOLOR_WILD(0, 0, null),
		BROWN(1, 2, new int[] {1, 2, 3}),
		LIGHT_BLUE(1, 3, new int[] {1, 2, 3}),
		PURPLE(2, 3, new int[] {1, 2, 3});
		// TODO: Implement all properties
		
		private int value;
		private int maxSet;
		private int[] rent;
		
		PropertyType(int value, int maxSet, int[] rent)
		{
			this.value = value;
			this.maxSet = maxSet;
			this.rent = rent;
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
	}
}
