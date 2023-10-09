package lab1;

public enum Queijo {

	MUSSARELA(0),
	PRATO(1),
	PARMESAO(2),
	COALHO(3);
	
	private int id;
	
	Queijo(int id)
	{
		this.id = id;
	}
	
	public static Queijo tipoQueijo(int id)
	{
		return Queijo.values()[id - 1];
	}
	
	public int getId()
	{
		return this.id;
	}
}
