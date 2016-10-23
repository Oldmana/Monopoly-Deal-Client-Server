package oldmana.general.md.universal.packet;

import net.teambrimis.brett.MJNetworkingAPI.MJDataBuffer;
import net.teambrimis.brett.MJNetworkingAPI.packet.Packet;

public class PacketLogin extends Packet
{
	public static int ID = 3;
	
	private double clientVersion;
	
	private String name;
	
	public PacketLogin() {}
	
	public PacketLogin(double clientVersion, String name)
	{
		this.clientVersion = clientVersion;
		this.name = name;
	}
	
	public void setClientVersion(double clientVersion)
	{
		this.clientVersion = clientVersion;
	}
	
	public double getClientVersion()
	{
		return clientVersion;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return name;
	}
	
	@Override
	public void fromBytes(MJDataBuffer data)
	{
		setClientVersion(data.getDouble());
		setName(data.getString());
	}

	@Override
	public byte[] toBytes()
	{
		MJDataBuffer buffer = new MJDataBuffer(8 + getName().length() * 2); // ID(2) + Client Version(4) + Name(2 * length) + Finalize(2)
		buffer.addShort((short) ID);
		buffer.addDouble(getClientVersion());
		buffer.addString(getName());
		buffer.finalizeData();
		return buffer.getByteArray();
	}
	
}
