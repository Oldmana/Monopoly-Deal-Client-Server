package oldmana.general.md.server.player;

import java.util.ArrayList;
import java.util.List;

import oldmana.general.md.server.card.CashPile;
import oldmana.general.md.server.card.PropertyCardSet;

public class PlayerBoard
{
	private List<PropertyCardSet> propertySets = new ArrayList<PropertyCardSet>();
	private CashPile cash = new CashPile();
	
	public PlayerBoard()
	{
		
	}
	
	public PropertyCardSet getPropertySetAt(int index)
	{
		return propertySets.get(index);
	}
}
