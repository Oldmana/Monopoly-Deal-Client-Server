package oldmana.general.md.universal.card.action;

import oldmana.general.md.universal.Universal;
import oldmana.general.md.universal.card.ActionCard;
import oldmana.general.md.universal.player.Player;

public class DebtCollectorActionCard extends ActionCard
{
	public DebtCollectorActionCard(int ID)
	{
		super(ID, "Debt Collector", 3);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void playOn(Player owner, Player target)
	{
		if (Universal.isClient())
		{
			
		}
		else if (Universal.isServer())
		{
			
		}
	}
	
}
