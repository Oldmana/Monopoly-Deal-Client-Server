package oldmana.general.md.server.player;

import net.teambrimis.brett.MJNetworkingAPI.MJConnection;
import oldmana.general.md.server.PacketListenerThread;

public class Client
{
	private PacketListenerThread listener;
	
	private boolean login = false;
	private String name;
	private long UUID;
	
	public Client(MJConnection connection)
	{
		listener = new PacketListenerThread(connection);
	}
	
	
}
