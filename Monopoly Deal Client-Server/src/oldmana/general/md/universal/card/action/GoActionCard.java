package oldmana.general.md.universal.card.action;

import oldmana.general.md.universal.Universal;
import oldmana.general.md.universal.card.ActionCard;
import oldmana.general.md.universal.player.Player;

public class GoActionCard extends ActionCard
{
	
	
	public GoActionCard(int ID, String name, int value)
	{
		super(ID, name, value);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void playOn(Player owner, Player target)
	{
		if (Universal.isClient())
		{
			// TODO: Send packet to server
		}
		else if (Universal.isServer())
		{
			owner.drawCard();
			owner.drawCard();
			// TODO: Send packets to clients
		}
	}

}
