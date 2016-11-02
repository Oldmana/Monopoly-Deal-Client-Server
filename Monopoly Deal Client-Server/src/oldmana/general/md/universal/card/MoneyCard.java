package oldmana.general.md.universal.card;

public class MoneyCard extends Card
{
	public MoneyCard(int ID, int value)
	{
		super(ID, "$" + value + "M", value);
	}
}
