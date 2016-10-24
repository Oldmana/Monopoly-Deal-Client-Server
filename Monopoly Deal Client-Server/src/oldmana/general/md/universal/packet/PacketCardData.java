package oldmana.general.md.universal.packet;

import net.teambrimis.brett.MJNetworkingAPI.MJDataBuffer;
import net.teambrimis.brett.MJNetworkingAPI.packet.Packet;

public class PacketCardData extends Packet
{
	public static int ID = 5;
	
	public static byte TYPE_MONEY = (byte) 0;
	public static byte TYPE_PROPERTY = (byte) 1;
	public static byte TYPE_ACTION = (byte) 2;
	
	private int cardID;
	private String name;
	private int value;
	private byte type;
	
	public PacketCardData() {}
	
	public PacketCardData(int cardID, String name, int value, byte type)
	{
		
	}
	
	@Override
	public void fromBytes(MJDataBuffer data)
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
