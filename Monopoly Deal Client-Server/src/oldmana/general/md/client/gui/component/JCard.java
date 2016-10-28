package oldmana.general.md.client.gui.component;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JComponent;

import oldmana.general.md.client.Utils;
import oldmana.general.md.client.gui.utils.TextPainter;
import oldmana.general.md.client.gui.utils.TextPainter.Alignment;
import oldmana.general.md.universal.card.Card;

public class JCard extends JComponent
{
	/**Contains colors for 1, 2, 3, 4, 5, 10
	 */
	private Color[] valueColors = new Color[] {Color.YELLOW, Color.PINK, Color.GREEN, Color.CYAN, Color.MAGENTA, null, 
			null, null, null, Color.ORANGE};
	
	private static final long serialVersionUID = -45918382401781558L;
	
	private Card card;
	
	public JCard(Card card)
	{
		this.card = card;
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		g.setColor(valueColors[card.getValue() - 1]);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
		g.setColor(Color.BLACK);
		TextPainter valueTL = new TextPainter("$" + card.getValue() + "M", Utils.getFont(Font.PLAIN, 12), new Rectangle(0, 0, getWidth(), getHeight()), false, false);
		valueTL.setHorizontalAlignment(Alignment.LEFT);
		valueTL.setVerticalAlignment(Alignment.TOP);
		TextPainter valueRB = new TextPainter("$" + card.getValue() + "M", Utils.getFont(Font.PLAIN, 12), new Rectangle(0, 0, getWidth(), getHeight()), false, false);
		valueRB.setHorizontalAlignment(Alignment.RIGHT);
		valueRB.setVerticalAlignment(Alignment.BOTTOM);
		valueTL.paint((Graphics2D) g);
		valueRB.paint((Graphics2D) g);
		TextPainter name = new TextPainter(card.getName(), Utils.getFont(Font.PLAIN, (int) (getHeight() * 0.1)), new Rectangle(0, 0, getWidth(), getHeight()), false, false);
		name.setHorizontalAlignment(Alignment.CENTER);
		name.setVerticalAlignment(Alignment.CENTER);
		name.paint((Graphics2D) g);
		//g.drawString("$" + card.getValue() + "M", 2, getHeight() / 2);
	}
}
