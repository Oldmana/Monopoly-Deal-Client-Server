package oldmana.general.md.universal;

import javax.swing.SwingUtilities;

import oldmana.general.md.client.ClientGame;
import oldmana.general.md.server.ServerGame;

public class Universal
{
	/**This method checks if the code is currently executing the event dispatch thread.
	 * 
	 * @return Returns true if the current thread is the client
	 */
	public static boolean isClient()
	{
		return SwingUtilities.isEventDispatchThread();
	}
	
	/**This method checks if the code is currently executing on the MD server networking thread or MD scheduler.
	 * 
	 * @return Returns true if the current thread is related to the MD server
	 */
	public static boolean isServer()
	{
		return false; // TODO: Implement when server thread is created
	}
	
	public static UniversalGame getGame()
	{
		if (isClient())
		{
			return ClientGame.getGameInstance();
		}
		else if (isServer())
		{
			return ServerGame.getGameInstance();
		}
		return null;
	}
}
