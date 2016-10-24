package oldmana.general.md.universal.card;

import oldmana.general.md.universal.player.Player;

public abstract class ActionCard extends Card
{
	public ActionCard(int ID, String name, int value)
	{
		super(ID, name, value);
	}
	
	/**The processing on playing a card. If client, packets should be sent. If server, processing should be done.
	 * 
	 * @param owner - Player playing the card
	 * @param target - Player's target, if any
	 */
	public abstract void playOn(Player owner, Player target);
}
