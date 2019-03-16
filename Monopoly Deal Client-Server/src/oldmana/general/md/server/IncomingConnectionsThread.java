package oldmana.general.md.server;

import java.io.IOException;

import net.teambrimis.brett.MJNetworkingAPI.server.MJServer;
import net.teambrimis.brett.MJNetworkingAPI.server.MJServer.MJConnectAttempt;

public class IncomingConnectionsThread extends Thread
{
	private MJServer server;
	
	public IncomingConnectionsThread() throws IOException
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
				
				ServerThread.schedule(new Runnable()
				{
					@Override
					public void run()
					{
						
					}
				});
			}
			else
			{
				attempt.getError().printStackTrace();
			}
		}
	}
}
