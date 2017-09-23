package oldmana.general.md.universal.packet;

import net.teambrimis.brett.MJNetworkingAPI.MJDataBuffer;
import net.teambrimis.brett.MJNetworkingAPI.packet.Packet;
import oldmana.general.md.universal.card.ActionCard.ActionCardType;
import oldmana.general.md.universal.card.PropertyCard.PropertyType;

public class PacketCardData extends Packet
{
	public static int ID = 10; // TODO: assign real ID
	
	private int cardID;
	private String name;
	private int value;
	
	private ActionCardType actionType;
	private PropertyType propertyType;
	
	
	
	public PacketCardData() {}
	
	public PacketCardData(int cardID, String name, int value)
	{
		this.cardID = cardID;
		this.name = name;
		this.value = value;
	}
	
	public PacketCardData(int cardID, String name, int value, ActionCardType actionType)
	{
		this.cardID = cardID;
		this.name = name;
		this.value = value;
		
		this.actionType = actionType;
	}
	
	public PacketCardData(int cardID, String name, int value, PropertyType propertyType)
	{
		this.cardID = cardID;
		this.name = name;
		this.value = value;
		
		this.propertyType = propertyType;
	}
	
	public void setCardID(int cardID)
	{
		this.cardID = cardID;
	}
	
	public int getCardID()
	{
		return cardID;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setValue(int value)
	{
		this.value = value;
	}
	
	public int getValue()
	{
		return value;
	}
	
	public void setActionCardType(ActionCardType type)
	{
		this.actionType = type;
	}
	
	public ActionCardType getActionCardType()
	{
		return actionType;
	}
	
	public boolean isActionCard()
	{
		return actionType != null;
	}
	
	public void setPropertyType(PropertyType type)
	{
		this.propertyType = type;
	}
	
	public PropertyType getPropertyType()
	{
		return propertyType;
	}
	
	public boolean isPropertyCard()
	{
		return propertyType != null;
	}
	
	public boolean isMoneyCard()
	{
		return actionType == null && propertyType == null;
	}
	
	@Override
	public void fromBytes(MJDataBuffer data)
	{
		setCardID(data.getInt());
		setName(data.getString());
		setValue(data.getInt());
		byte type = data.getByte();
		if (type == 1)
		{
			setActionCardType(ActionCardType.typeOf(data.getInt()));
		}
		else if (type == 2)
		{
			setPropertyType(PropertyType.typeOf(data.getInt()));
		}
	}
	
	@Override
	public byte[] toBytes()
	{
		MJDataBuffer data = new MJDataBuffer(16 + 2 * getName().length() + 1);
		data.addShort((short) ID);
		data.addInt(getCardID());
		data.addString(getName());
		data.addInt(getValue());
		if (isMoneyCard())
		{
			data.addByte((byte) 0);
		}
		else if (isActionCard())
		{
			data.addByte((byte) 1);
			data.addInt(getActionCardType().hashCode());
		}
		else if (isPropertyCard())
		{
			data.addByte((byte) 2);
			data.addInt(getPropertyType().hashCode());
		}
		data.finalizeData();
		return data.getByteArray();
	}
}
