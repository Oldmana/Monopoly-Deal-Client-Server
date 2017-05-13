package oldmana.general.md.client.gui.component;

import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JScrollPane;

import oldmana.general.md.client.GraphicsUtils;

public class JCardPileList extends JComponent
{
	private JScrollPane scrollPane;
	
	private List<JCardPile> piles = new ArrayList<JCardPile>();
	
	private int spread = 8;
	
	public JCardPileList()
	{
		scrollPane = new JScrollPane(this);
		
		scrollPane.addComponentListener(new ComponentAdapter()
		{
			@Override
			public void componentResized(ComponentEvent event)
			{
				removeAll();
				setPreferredSize(new Dimension((piles.get(0).getWidth() + spread) * piles.size(), scrollPane.getHeight() - 
						scrollPane.getVerticalScrollBar().getHeight()));
				for (int i = 0 ; i < piles.size() ; i++)
				{
					JCardPile pile = piles.get(i);
					add(pile);
					pile.setSize(GraphicsUtils.adjustToDimension(getSize(), 0.5));
					pile.setLocation((pile.getWidth() + spread) * i, 0);
				}
			}
		});
	}
	
	public void addPile(JCardPile pile)
	{
		piles.add(pile);
	}
	
	public JScrollPane getScrollPane()
	{
		return scrollPane;
	}
}
