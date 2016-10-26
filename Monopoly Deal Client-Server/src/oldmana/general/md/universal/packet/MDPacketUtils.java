package oldmana.general.md.universal.packet;

import oldmana.general.md.universal.card.ActionCard;
import oldmana.general.md.universal.card.Card;
import oldmana.general.md.universal.card.PropertyCard;
import oldmana.general.md.universal.card.PropertyWildCard;
import net.teambrimis.brett.MJNetworkingAPI.packet.Packet;

public class MDPacketUtils
{
	public static Packet constructCardDataPacket(Card card)
	{
		if (card instanceof ActionCard)
		{
			return new PacketActionCardData((ActionCard) card);
		}
		else if (card instanceof PropertyWildCard)
		{
			return new PacketPropertyWildCardData((PropertyWildCard) card);
		}
		else if (card instanceof PropertyCard)
		{
			return new PacketPropertyCardData((PropertyCard) card);
		}
		return null;
	}
}
