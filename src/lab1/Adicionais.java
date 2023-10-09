package lab1;

public enum Adicionais {

	MAIONESE(0),
	KETCHUP(1),
	OVO(2),
	BATATA_PALHA(3);
	
	private int id;
	
	Adicionais(int id)
	{
		this.id = id;
	}
	
	public static Adicionais tipoAdicional(int id)
	{
		return Adicionais.values()[id - 1];
	}
	
	public int getId()
	{
		return this.id;
	}
}
