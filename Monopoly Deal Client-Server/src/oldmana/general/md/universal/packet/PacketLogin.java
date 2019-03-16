package oldmana.general.md.universal.packet;

import net.teambrimis.brett.MJNetworkingAPI.MJDataBuffer;
import net.teambrimis.brett.MJNetworkingAPI.packet.Packet;

public class PacketLogin extends Packet
{
	public static int ID = 3;
	
	private double clientVersion;
	
	private String name;
	
	private long UUID;
	
	public PacketLogin() {}
	
	public PacketLogin(double clientVersion, String name, long UUID)
	{
		this.clientVersion = clientVersion;
		this.name = name;
		this.UUID = UUID;
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
	
	public void setUUID(long UUID)
	{
		this.UUID = UUID;
	}
	
	public long getUUID()
	{
		return UUID;
	}
	
	@Override
	public void fromBytes(MJDataBuffer data)
	{
		setClientVersion(data.getDouble());
		setName(data.getString());
		setUUID(data.getLong());
	}

	@Override
	public byte[] toBytes()
	{
		MJDataBuffer buffer = new MJDataBuffer(8 + getName().length() * 2); // ID(2) + Client Version(4) + Name(2 * length) + Finalize(2)
		buffer.addShort((short) ID);
		buffer.addDouble(getClientVersion());
		buffer.addString(getName());
		buffer.addLong(UUID);
		buffer.finalizeData();
		return buffer.getByteArray();
	}
	
}
