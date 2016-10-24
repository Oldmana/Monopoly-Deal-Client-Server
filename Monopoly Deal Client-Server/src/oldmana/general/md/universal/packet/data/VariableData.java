package oldmana.general.md.universal.packet.data;

public abstract class VariableData
{
	public abstract void fromBytes(byte[] data);
	
	public abstract byte[] toBytes();
}
