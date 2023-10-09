package lab1;

public class Salsicha extends CachorroQuente{

	public Salsicha(Queijo queijo) {
		super(queijo);
	}
	
	//Adicionado:
	private double valor = 2.00;
	
	public double getValor()
	{
		return valor;
	}
	
	public double valorComDesconto(int qtd)
	{
		if(qtd > 2)
		{
			return (qtd*valor)*0.9;
		}
		else
		{
			return qtd*valor;
		}
	}
}
