package oldmana.general.md.universal;

import javax.swing.SwingUtilities;

public class Universal
{
	public static boolean isClient()
	{
		return SwingUtilities.isEventDispatchThread();
	}
	
	public static boolean isServer()
	{
		return false; // TODO: Implement when server thread is created
	}
}
