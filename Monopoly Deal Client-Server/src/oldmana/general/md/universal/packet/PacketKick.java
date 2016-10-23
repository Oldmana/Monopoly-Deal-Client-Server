package oldmana.general.md.universal.packet;

import net.teambrimis.brett.MJNetworkingAPI.MJDataBuffer;
import net.teambrimis.brett.MJNetworkingAPI.packet.Packet;

public class PacketKick extends Packet
{
	public static int ID = 4;
	
	private String reason;
	
	public PacketKick() {}
	
	public PacketKick(String reason)
	{
		this.reason = reason;
	}
	
	public void setReason(String reason)
	{
		this.reason = reason;
	}
	
	public String getReason()
	{
		return reason;
	}
	
	@Override
	public void fromBytes(MJDataBuffer data)
	{
		setReason(data.getString());
	}

	@Override
	public byte[] toBytes()
	{
		MJDataBuffer buffer = new MJDataBuffer(4 + reason.length() * 2); // ID(2) + Reason(2 * ?) + Finalize(2)
		buffer.addShort((short) ID);
		buffer.addString(getReason());
		buffer.finalizeData();
		return buffer.getByteArray();
	}

}
