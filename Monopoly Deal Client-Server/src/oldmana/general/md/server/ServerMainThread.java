package oldmana.general.md.server;

import java.util.ArrayList;
import java.util.List;

public class ServerMainThread extends Thread
{
	private List<Runnable> tasks = new ArrayList<Runnable>();
	
	public ServerMainThread()
	{
		
	}
	
	@Override
	public void run()
	{
		
	}
	
	public void schedule(Runnable runnable)
	{
		synchronized (this)
		{
			tasks.add(runnable);
		}
	}
}
