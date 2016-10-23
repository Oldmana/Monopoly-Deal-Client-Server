package oldmana.general.md.client;

import net.teambrimis.brett.MJNetworkingAPI.MJConnection;

public class ClientNetworkingThread extends Thread
{
	private MJConnection connection = new MJConnection();
	
	public ClientNetworkingThread()
	{
		super("Client Networking Thread");
		start();
	}
	
	@Override
	public void run()
	{
		
	}
}
