package oldmana.general.md.client;

import java.awt.Dimension;

public class GraphicsUtils
{
	public static Dimension adjustToDimension(Dimension d, double xyRatio)
	{
		Dimension adjusted = new Dimension();
		// .5
		// 1:2
		
		// 100:400 (100:200)
		// 400:100 (50:100)
		double w = d.getWidth();
		double h = d.getHeight();
		
		double dimRatio = w / h;
		System.out.println("DimRatio: " + dimRatio + " | xyRatio: " + xyRatio);
		if (dimRatio <= xyRatio)
		{
			adjusted.width = (int) w;
			adjusted.height = (int) (w / xyRatio);
		}
		else
		{
			adjusted.width = (int) (h * xyRatio);
			adjusted.height = (int) h;
		}
		return adjusted;
	}
}
