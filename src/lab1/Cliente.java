package lab1;

public abstract class Cliente {

	protected String nome;
	
	public String getNome()
	{
		return this.nome;
	}
	
	public abstract int getID();
}
