package oldmana.general.md.universal.card.action;

import net.teambrimis.brett.MJNetworkingAPI.packet.Packet;
import oldmana.general.md.universal.Universal;
import oldmana.general.md.universal.card.ActionCard;
import oldmana.general.md.universal.card.Card;
import oldmana.general.md.universal.packet.MDPacketUtils;
import oldmana.general.md.universal.player.Player;

public class GoActionCard extends ActionCard
{
	
	
	public GoActionCard(int ID, int value)
	{
		super(ID, "Go", value);
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
			Card c1 = owner.drawCard();
			Card c2 = owner.drawCard();
			try
			{
				Packet.sendPacket(owner.getConnection(), MDPacketUtils.constructCardDataPacket(c1));
				Packet.sendPacket(owner.getConnection(), MDPacketUtils.constructCardDataPacket(c2));
			}
			catch (Exception e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
