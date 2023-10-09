package lab1;

public class Servidor extends Cliente {

	
	private int SIAPE;
	
	Servidor(String nome, int SIAPE)
	{
		this.nome = nome;
		this.SIAPE = SIAPE;
	}
	
	public int getID()
	{
		return this.SIAPE;
	}
	
}
