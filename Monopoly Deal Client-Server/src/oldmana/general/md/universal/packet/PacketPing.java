package oldmana.general.md.universal.packet;

import net.teambrimis.brett.MJNetworkingAPI.MJDataBuffer;
import net.teambrimis.brett.MJNetworkingAPI.packet.Packet;

/**<b>ID: 1</b><br>
 * <b>Client -> Server</b><br><br>
 * 
 * Tells the server the client version; will expect a PacketPingResponse back
 *
 */
public class PacketPing extends Packet
{
	public static int ID = 1;
	
	private double clientVersion;
	
	public PacketPing() {}
	
	public PacketPing(double clientVersion)
	{
		setClientVersion(clientVersion);
	}
	
	public void setClientVersion(double clientVersion)
	{
		this.clientVersion = clientVersion;
	}
	
	public double getClientVersion()
	{
		return clientVersion;
	}

	@Override
	public void fromBytes(MJDataBuffer bytes)
	{
		setClientVersion(bytes.getDouble());
	}

	@Override
	public byte[] toBytes()
	{
		MJDataBuffer buffer = new MJDataBuffer(8); // ID(2) + Client Version(4) + Finalize(2)
		buffer.addShort((short) ID);
		buffer.addDouble(getClientVersion());
		buffer.finalizeData();
		return buffer.getByteArray();
	}
	
}
