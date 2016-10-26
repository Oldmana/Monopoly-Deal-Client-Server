package oldmana.general.md.universal.card;

public class PropertyCard extends Card
{
	private PropertyType type;
	
	public PropertyCard(int ID, PropertyType type)
	{
		super(ID, type.name(), type.getValue());
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
