package lab1;

public enum Bebida {

	COCA_COLA(0),
	DELRIO(1),
	SUCO_DO_CHAVES(2);
	
	private int id;
	
	Bebida(int id)
	{
		this.id = id;
	}
	
	public static Bebida tipoBebida(int id)
	{
		return Bebida.values()[id - 1];
	}
	
	public int getId()
	{
		return this.id;
	}
}
