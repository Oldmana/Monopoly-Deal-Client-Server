package oldmana.general.md.server.card;

import oldmana.general.md.server.player.Player;
import oldmana.general.md.universal.card.CardType;

public abstract class ActionCard extends Card
{
	public ActionCard(String name, int value)
	{
		super(CardType.ACTION, name, value);
	}
	
	public abstract void play(Player owner, Player target);
}
