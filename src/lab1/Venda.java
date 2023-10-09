package lab1;
import java.util.ArrayList;

public class Venda {

	private Cliente cliente;
	private ArrayList<CachorroQuente> cachorrosQuentes;
	
	
	public Venda(Cliente cliente) {
		this.cliente = cliente;
		cachorrosQuentes = new ArrayList<CachorroQuente>();
	}
	
	public void realizarVenda(CachorroQuente c) {
		cachorrosQuentes.add(c);
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public ArrayList<CachorroQuente> getCachorrosQuentes() {
		return cachorrosQuentes;
	}
	
	//Adicionado:
	public int qtdCachorroQuente() {
		return cachorrosQuentes.size();
	}
	
	
}
