package lab1;

import java.util.ArrayList;

public abstract class CachorroQuente {

	protected Queijo queijo;
	protected ArrayList<Adicionais> adicionais;
	protected Bebida bebida;
	
	public CachorroQuente(Queijo queijo) {
		this.queijo = queijo;
		this.adicionais = new ArrayList<Adicionais>();
	}
	
	public void adicionarIngredientes(Adicionais adicional) {
		
		adicionais.add(adicional);
	}
	
	public void adicionarBebida(Bebida bebida)
	{
		this.bebida = bebida;
	}
	
	public ArrayList<Adicionais> getIngredientes()
	{
		return adicionais;
	}
	
	public Queijo getQueijo()
	{
		return queijo;
	}
	
	public Bebida getBebida()
	{
		return bebida;
	}
}
