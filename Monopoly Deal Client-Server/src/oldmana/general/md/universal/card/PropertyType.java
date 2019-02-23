package oldmana.general.md.universal.card;

import java.awt.Color;

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
