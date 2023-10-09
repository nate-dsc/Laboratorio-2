package lab1;

public class Professor extends Cliente {

	private int SIAPE;
	
	Professor(String nome, int SIAPE)
	{
		this.nome = nome;
		this.SIAPE = SIAPE;
	}
	
	public int getID()
	{
		return this.SIAPE;
	}
	
}
