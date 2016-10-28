package oldmana.general.md.server;

import java.io.IOException;

import net.teambrimis.brett.MJNetworkingAPI.server.MJServer;
import net.teambrimis.brett.MJNetworkingAPI.server.MJServer.MJConnectAttempt;

public class ServerIncomingConnectionsThread extends Thread
{
	private MJServer server;
	
	public ServerIncomingConnectionsThread() throws IOException
	{
		server = new MJServer(209);
		
		start();
	}
	
	@Override
	public void run()
	{
		while (true)
		{
			MJConnectAttempt attempt = server.listen();
			if (attempt.successful())
			{
				
			}
			else
			{
				attempt.getError().printStackTrace();
			}
		}
	}
}
