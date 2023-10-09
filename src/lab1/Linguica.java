package lab1;

public class Linguica extends CachorroQuente{

	public Linguica(Queijo queijo) {
		super(queijo);
	}
	
	//Adicionado:
	private double valor = 3.00;
		
	public double valorComDesconto(int qtd)
	{
		if(qtd > 2)
		{
			return (qtd*valor)*0.88;
		}
		else
		{
			return qtd*valor;
		}
	}
}
