package lab1;

public class Bacon extends CachorroQuente{

	public Bacon(Queijo queijo) {
		super(queijo);
	}
	
	//Adicionado:
	private double valor = 3.50;
		
	public double valorComDesconto(int qtd)
	{
		if(qtd > 4)
		{
			return (qtd*valor)*0.86;
		}
		else
		{
			return qtd*valor;
		}
	}

}
