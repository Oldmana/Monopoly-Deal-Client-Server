package oldmana.general.md.client.gui.component;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;

import oldmana.general.md.client.Utils;
import oldmana.general.md.client.gui.utils.TextPainter;
import oldmana.general.md.client.gui.utils.TextPainter.Alignment;
import oldmana.general.md.universal.card.Card;
import oldmana.general.md.universal.card.PropertyCard;

public class JCard extends JComponent implements PixelRatio
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
	public void paintComponent(Graphics cg)
	{
		BufferedImage img = Utils.createCompatibleImage(getWidth(), getHeight());
		Graphics2D g = img.createGraphics();
		g.setColor(valueColors[card.getValue() - 1]);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		if (card instanceof PropertyCard)
		{
			g.setColor(((PropertyCard) card).getType().getColor());
			g.fillRect(0, 0, getWidth() - 1, getHeight() / 8);
		}
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
		g.setColor(Color.BLACK);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		
		TextPainter valueTL = new TextPainter("$" + card.getValue() + "M", Utils.getFont(Font.PLAIN, (int) (getHeight() * 0.1)), new Rectangle(0, 0, getWidth(), getHeight()), false, false);
		valueTL.setHorizontalAlignment(Alignment.LEFT);
		valueTL.setVerticalAlignment(Alignment.TOP);
		TextPainter valueRB = new TextPainter("$" + card.getValue() + "M", Utils.getFont(Font.PLAIN, (int) (getHeight() * 0.1)), new Rectangle(0, 0, getWidth(), getHeight()), false, false);
		valueRB.setHorizontalAlignment(Alignment.RIGHT);
		valueRB.setVerticalAlignment(Alignment.BOTTOM);
		valueTL.paint((Graphics2D) g);
		valueRB.paint((Graphics2D) g);
		TextPainter name = new TextPainter(card.getName(), Utils.getFont(Font.PLAIN, (int) (getHeight() * 0.1)), new Rectangle(0, 0, getWidth(), getHeight()), false, false);
		name.setHorizontalAlignment(Alignment.CENTER);
		name.setVerticalAlignment(Alignment.CENTER);
		name.paint((Graphics2D) g);
		cg.drawImage(img, 0, 0, getWidth() - 1, getHeight() - 1, this);
		//g.drawString("$" + card.getValue() + "M", 2, getHeight() / 2);
	}

	@Override
	public double getXToYRatio()
	{
		return 1.0 / 1.4;
	}
}
