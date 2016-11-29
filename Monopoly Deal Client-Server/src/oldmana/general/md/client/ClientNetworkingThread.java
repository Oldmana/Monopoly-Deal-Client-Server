package oldmana.general.md.client;

import javax.swing.SwingUtilities;

import net.teambrimis.brett.MJNetworkingAPI.MJConnection;
import net.teambrimis.brett.MJNetworkingAPI.packet.Packet;

public class ClientNetworkingThread extends Thread
{
	private MJConnection connection;
	
	public ClientNetworkingThread(MJConnection connection)
	{
		super("Client Networking Thread");
		
		this.connection = connection;
		start();
	}
	
	@Override
	public void run()
	{
		while (!connection.isClosed())
		{
			try
			{
				final Packet packet = connection.receivePackets();
				SwingUtilities.invokeLater(new Runnable()
				{
					@Override
					public void run()
					{
						ClientGame.getGameInstance().processPacket(packet, connection);
					}
				});
			}
			catch (Exception e)
			{
				
			}
		}
	}
}
