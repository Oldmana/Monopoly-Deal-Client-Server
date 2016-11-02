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
		while (!tasks.isEmpty())
		{
			tasks.get(0).run();
			tasks.remove(0);
		}
		
		try
		{
			Thread.sleep(1);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
	
	public void schedule(Runnable runnable)
	{
		synchronized (this)
		{
			tasks.add(runnable);
		}
	}
}
