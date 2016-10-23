package oldmana.general.md.universal.packet;

import net.teambrimis.brett.MJNetworkingAPI.MJDataBuffer;
import net.teambrimis.brett.MJNetworkingAPI.packet.Packet;

/**<b>ID: 2</b><br>
 * <b>Server->Client</b><br><br>
 * 
 * Tells the client the server version and if the client is compatible with the server
 *
 */
public class PacketPingResponse extends Packet
{
	public static int ID = 2;
	
	private boolean compatible;
	private double serverVersion;
	
	public PacketPingResponse() {}
	
	public PacketPingResponse(boolean compatible, double serverVersion)
	{
		this.compatible = compatible;
		this.serverVersion = serverVersion;
	}
	
	public void setCompatible(boolean compatible)
	{
		this.compatible = compatible;
	}
	
	public boolean isCompatible()
	{
		return compatible;
	}
	
	public void setServerVersion(double serverVersion)
	{
		this.serverVersion = serverVersion;
	}
	
	public double getServerVersion()
	{
		return serverVersion;
	}
	
	@Override
	public void fromBytes(MJDataBuffer data)
	{
		setCompatible(data.getBoolean());
		setServerVersion(data.getDouble());
	}

	@Override
	public byte[] toBytes()
	{
		MJDataBuffer buffer = new MJDataBuffer(9); // ID(2) + Compatible(1) + Server Version(4) + Finalize(2)
		buffer.addShort((short) ID);
		buffer.addBoolean(isCompatible());
		buffer.addDouble(getServerVersion());
		buffer.finalizeData();
		return buffer.getByteArray();
	}
	
}
