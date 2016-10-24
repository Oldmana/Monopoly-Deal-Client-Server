package oldmana.general.md.universal;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

import oldmana.general.md.universal.SideOnly.Side;

//@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.CONSTRUCTOR})
public @interface SideOnly
{
	public Side value();
	
	public static enum Side
	{
		CLIENT, SERVER
	}
}
