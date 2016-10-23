package oldmana.general.md.client.card;

/**Client-specific representation of a deck. The client only knows the size of the deck.
 *
 */
public class ClientDeck
{
	private int size;
	
	public ClientDeck(int size)
	{
		this.size = size;
	}
	
	public int decrement()
	{
		return --size;
	}
	
	public void setSize(int size)
	{
		this.size = size;
	}
	
	public int getSize()
	{
		return size;
	}
}
