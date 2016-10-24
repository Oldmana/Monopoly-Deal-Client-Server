package oldmana.general.md.universal.packet.data;

import oldmana.general.md.universal.card.PropertyCard.PropertyType;

public class PropertyCardData extends VariableData
{
	public static int ID = 1;
	
	private PropertyType[] types = new PropertyType[2];
	
	public PropertyCardData()
	{
		
	}
	
	public void setTypes(PropertyType[] types)
	{
		this.types = types;
	}
	
	public void setType(PropertyType type)
	{
		types[0] = type;
	}

	@Override
	public void fromBytes(byte[] data)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public byte[] toBytes()
	{
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
