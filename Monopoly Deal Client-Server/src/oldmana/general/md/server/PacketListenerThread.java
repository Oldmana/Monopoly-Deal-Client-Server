package oldmana.general.md.server;

import net.teambrimis.brett.MJNetworkingAPI.MJConnection;
import net.teambrimis.brett.MJNetworkingAPI.packet.Packet;
import oldmana.general.md.server.player.Client;
import oldmana.general.md.universal.player.Player;

public class PacketListenerThread extends Thread
{
	private MJConnection connection;
	
	public PacketListenerThread(MJConnection connection)
	{
		this.connection = connection;
	}
	
	@Override
	public void run()
	{
		while (!connection.isClosed())
		{
			try
			{
				Packet packet = connection.receivePackets();
				Player p = getPlayerOfConnection();
				if (p != null)
				{
					ServerGame.getGameInstance().processPacket(packet, p);
				}
				else
				{
					ServerGame.getGameInstance().processPacket(packet, connection);
				}
			}
			catch (Exception e) {}
		}
	}
	
	private Player getPlayerOfConnection()
	{
		for (Player p : ServerGame.getGameInstance().getPlayers())
		{
			if (p.getConnection() == connection)
			{
				return p;
			}
		}
		return null;
	}
	
	private Client getClient()
	{
		return null; // TODO: Get the client
	}
}
