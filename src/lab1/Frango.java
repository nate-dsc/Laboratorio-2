package lab1;

public class Frango extends CachorroQuente{

	public Frango(Queijo queijo) {
		super(queijo);
	}
	
	//Adicionado:
	private double valor = 2.50;
		
	public double valorComDesconto(int qtd)
	{
		if(qtd > 3)
		{
			return (qtd*valor)*0.87;
		}
		else
		{
			return qtd*valor;
		}
	}
}
