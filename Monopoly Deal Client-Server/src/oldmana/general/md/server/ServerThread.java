package oldmana.general.md.server;

import java.util.Stack;

public class ServerThread extends Thread
{
	private static Stack<Runnable> tasks = new Stack<Runnable>();
	
	public ServerThread()
	{
		
	}
	
	@Override
	public void run()
	{
		synchronized (tasks)
		{
			while (!tasks.empty())
			{
				tasks.pop().run();
			}
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
	
	public static void schedule(Runnable runnable)
	{
		synchronized (tasks)
		{
			tasks.push(runnable);
		}
	}
}
