package lab1;

import java.util.ArrayList;
import java.util.Scanner;

public class Barraquinha {

	private Scanner dados;
	private ArrayList<Venda> listaVenda;
	
	public Barraquinha()
	{
		System.out.println("Bem vindo a barraquinha de Tecnicas!\n\n");
		dados = new Scanner(System.in);
		listaVenda = new ArrayList<Venda>();
		menuOperacoes();
	}

	private void menuOperacoes()
	{
		int op = 0;
		Cliente comprador = null;
		CachorroQuente cachorroQuenteEscolhido;
		Venda venda = null;
		do
		{
			op = itensDoMenu();
			switch (op)
			{
				case 1:
					comprador = registrarCliente();
					venda = new Venda(comprador);
					break;
				case 2:
					Queijo queijo = escolherTipoQueijo();
					cachorroQuenteEscolhido = escolherCachorroQuente(queijo);
					
					Bebida bebida = escolherBebida();
					cachorroQuenteEscolhido.adicionarBebida(bebida);
					
					adicionarIngredientes(cachorroQuenteEscolhido);
					
					venda.realizarVenda(cachorroQuenteEscolhido);
					break;
				case 3:
					calcularValor(venda);
					listaVenda.add(venda);
					break;
				case 4:
					informacoesSistema();
					break;
				default:
					break;
			}

		} while (op != -1);
		System.out.println("Bye!");
	}

	private int itensDoMenu()
	{
		System.out.println("Escolha uma opcao para registra a venda ou digite -1 para sair!");
		System.out.println("1: Inserir novo comprador");
		System.out.println("2: Inserir novo cachorro quente");
		System.out.println("3: Finalizar venda e mostrar total a ser pago");
		System.out.println("4: Informacoes do sistema");
		return dados.nextInt();
	}
	//Criar e adicionar ingredientes ao cachorro quente:
	private Queijo escolherTipoQueijo()
	{
		int q = 0;
		do
		{
			System.out.println("Escolha a opcao de queijo: [1 - Mussarela, 2 - Prato, 3 - Parmesao , 4 - Coalho]");
			q = dados.nextInt();
		}while(q < 1 || q > 4);
		return Queijo.tipoQueijo(q);
	}

	private CachorroQuente escolherCachorroQuente(Queijo queijo)
	{
		System.out.println("\n Escolha a opcaode cachorro quente: [1 - Salsicha, 2 - Linguica, 3 - Frango, 4 - Bacon]");
		int tipo = dados.nextInt();
		CachorroQuente c = null;
		switch (tipo) {
		case 1:
			c = new Salsicha(queijo);
			break;
		case 2:
			c = new Linguica(queijo);
			break;
		case 3:
			c = new Frango(queijo);
			break;
		case 4:
			c = new Bacon(queijo);
			break;
		default:
			break;
		}
		return c;
	}

	private Bebida escolherBebida()
	{
		int b = 0;
		do
		{
			System.out.println("Escolha a opcao de bebida: [1 - Coca-Cola, 2 - Delrio, 3 - Suco do Chaves]");
			b = dados.nextInt();
		}while(b < 1 || b > 3);
		return Bebida.tipoBebida(b);
	}
	
	private Cliente registrarCliente()
	{
		Cliente cliente = null;
		int tipo = 0;
		do
		{
			System.out.print("\n Tipo de cliente:  [1 - Aluno, 2 - Professor, 3 - Servidor] ");
			tipo = dados.nextInt();
			if(tipo > 0 && tipo < 4)
			{
				System.out.print("\n Nome: ");
				String nome = dados.next();
				System.out.print("\n Matricula/SIAPE:");
				int id = dados.nextInt();
				switch(tipo)
				{
					case 1:
						cliente = new Aluno(nome, id);
						break;
					case 2:
						cliente = new Professor(nome, id);
						break;
					case 3:
						cliente = new Servidor(nome, id);
						break;
					default:
						break;
				}
			}
		}while(tipo < 1 && tipo > 3);
		return cliente;
	}
	
	private void adicionarIngredientes(CachorroQuente cachorroQuenteEscolhido)
	{
		int op = 0;
		do
		{
			op = itensAdicionais();
			if(op >= 1 && op < 5)
				cachorroQuenteEscolhido.adicionarIngredientes(Adicionais.tipoAdicional(op));
		} while(op != -1);
	}

	private int itensAdicionais()
	{
		System.out.println("Escolha uma opcao ou digite -1 para sair!");
		System.out.println("1: Adicionar MAIONESE");
		System.out.println("2: Adicionar KETCHUP");
		System.out.println("3: Adicionar OVO");
		System.out.println("4: Adicionar BATATA PALHA");
		return dados.nextInt();
	}
	
	//Acessar e computar dados do sistema:
	private void informacoesSistema()
	{
		int op = 0;
		do
		{
			op = itensDoSistema();
			switch(op)
			{
				case 1:
					mostrarVenda();
					break;
				case 2:
					mostrarTiposCliente();
					break;
				case 3:
					mostrarTotalCQ();
					break;
				case 4:
					mostrarCQMaisVendido();
					break;
				case 5:
					mostrarBebidaMaisVendida();
					break;
				case 6:
					calcularValor(listaVenda);
					System.out.printf("Valor total arrecadado: %.2f%n", valorTotal);
				case 7:
					calcularValor(listaVenda);
					System.out.printf("Valor total em descontos: %.2f%n", valorDesconto);
				default:
					break;
			}
		} while(op != -1);
	}

	private int itensDoSistema() {
		System.out.println("Escolha uma opcao ou digite -1 para sair!");
		System.out.println("1: Mostrar uma venda");
		System.out.println("2: Mostrar cachorros quentes por tipo de cliente");
		System.out.println("3: Mostrar total de cachorros quentes vendidos");
		System.out.println("4: Mostrar cachorro quente mais vendido");
		System.out.println("5: Mostrar bebida mais vendida");
		System.out.println("6: Mostrar valor total arrecadado");
		System.out.println("7: Mostrar valor total em descontos");
		return dados.nextInt();
	}

	//Mostradores:
	private void mostrarVenda()
	{
		int i = 0;
		do
		{
		System.out.println("Digite o indice da venda ou digite -1 para sair!");
		i = dados.nextInt();
		Cliente cliente = null;
		Venda venda = null;
			if(i > 0 && i <= listaVenda.size())
			{
				venda = listaVenda.get(i-1);
				cliente = listaVenda.get(i-1).getCliente();
				System.out.println("Nome: " + cliente.getNome());
				System.out.println("Matricula/SIAPE: " + cliente.getID());
				int contador = 1;
				for(CachorroQuente c : venda.getCachorrosQuentes())
				{
					System.out.println(contador + ". Cachorro quente tipo " + c.getClass().getName());
					System.out.println("Queijo: " + c.getQueijo().toString());
					System.out.println("Adicionais: ");
					for(Adicionais a : c.getIngredientes())
					{
						System.out.print(a.toString() + ", ");
					}
					System.out.println("\nBebida: " + c.getBebida().toString() + "\n");
				}
			}
		} while(i != -1);
	}
	
	private void mostrarTiposCliente()
	{
		System.out.println("Foram vendidos " + qtdAlunos(listaVenda) + " cachorros quentes para alunos,");
		System.out.println(qtdProfessores(listaVenda) + " para professores e " + qtdServidores(listaVenda) + " para servidores.");
	}
	
	private void mostrarTotalCQ()
	{
		System.out.println("Foram vendidos " + qtdCQ(listaVenda) + " cachorros quentes");
	}
	
	private void mostrarCQMaisVendido()
	{
		int s = qtdSalsicha(listaVenda);
		int l = qtdLinguica(listaVenda);
		int f = qtdFrango(listaVenda);
		int b = qtdBacon(listaVenda);
		if(s > l && s > f && s > b)
		{
			System.out.println("O cachorro quente mais popular foi o de salsicha");
		} else if(l > f && l > b && l > s)
		{
			System.out.println("O cachorro quente mais popular foi o de linguica");
		} else if(f > b && f > l && f > s)
		{
			System.out.println("O cachorro quente mais popular foi o de frango");
		} else if(b > f && b > l && b > s)
		{
			System.out.println("O cachorro quente mais popular foi o de bacon");
		} else
		{
			System.out.println("Nao houve cachorro quente mais popular (todos venderam igual)");
		}
	}
	
	private void mostrarBebidaMaisVendida()
	{
		int c = qtdCocaCola(listaVenda);
		int d = qtdDelrio(listaVenda);
		int s = qtdSucoChaves(listaVenda);
		if(c > d && c > s)
		{
			System.out.println("A bebida mais popular foi Coca-Cola");
		} else if(d > c && d > s)
		{
			System.out.println("A bebida mais popular foi Delrio");
		} else if(s > d && s > c)
		{
			System.out.println("A bebida mais popular foi Suco do Chaves");
		} else
		{
			System.out.println("Nao houve bebida mais popular foi (todas venderam igual)");
		}
	}
	
	//Contadores:
	private int qtdSalsicha(Venda venda)
	{
		int qtd = 0;
		for(CachorroQuente c : venda.getCachorrosQuentes())
		{
			if(c.getClass() == Salsicha.class)
			{
				qtd++;
			}
		}
		return qtd;
	}
	
	private int qtdSalsicha(ArrayList<Venda> vendas)
	{
		int qtd = 0;
		for(Venda v : vendas)
		{
			for(CachorroQuente c : v.getCachorrosQuentes())
			{
				if(c.getClass() == Salsicha.class)
				{
					qtd++;
				}
			}
		}
		return qtd;
	}
	
	private int qtdLinguica(Venda venda)
	{
		int qtd = 0;
		for(CachorroQuente c : venda.getCachorrosQuentes())
		{
			if(c.getClass() == Linguica.class)
			{
				qtd++;
			}
		}
		return qtd;
	}
	
	private int qtdLinguica(ArrayList<Venda> vendas)
	{
		int qtd = 0;
		for(Venda v : vendas)
		{
			for(CachorroQuente c : v.getCachorrosQuentes())
			{
				if(c.getClass() == Linguica.class)
				{
					qtd++;
				}
			}
		}
		return qtd;
	}
	
	private int qtdFrango(Venda venda)
	{
		int qtd = 0;
		for(CachorroQuente c : venda.getCachorrosQuentes())
		{
			if(c.getClass() == Frango.class)
			{
				qtd++;
			}
		}
		return qtd;
	}
	
	private int qtdFrango(ArrayList<Venda> vendas)
	{
		int qtd = 0;
		for(Venda v : vendas)
		{
			for(CachorroQuente c : v.getCachorrosQuentes())
			{
				if(c.getClass() == Frango.class)
				{
					qtd++;
				}
			}
		}
		return qtd;
	}
	
	private int qtdBacon(Venda venda)
	{
		int qtd = 0;
		for(CachorroQuente c : venda.getCachorrosQuentes())
		{
			if(c.getClass() == Bacon.class)
			{
				qtd++;
			}
		}
		return qtd;
	}
	
	private int qtdBacon(ArrayList<Venda> vendas)
	{
		int qtd = 0;
		for(Venda v : vendas)
		{
			for(CachorroQuente c : v.getCachorrosQuentes())
			{
				if(c.getClass() == Bacon.class)
				{
					qtd++;
				}
			}
		}
		return qtd;
	}
	
	private int qtdCocaCola(ArrayList<Venda> vendas)
	{
		int qtd = 0;
		for(Venda v : vendas)
		{
			for(CachorroQuente c : v.getCachorrosQuentes())
			{
				if(c.bebida == Bebida.COCA_COLA)
				{
					qtd++;
				}
			}
		}
		return qtd;
	}
	
	private int qtdDelrio(ArrayList<Venda> vendas)
	{
		int qtd = 0;
		for(Venda v : vendas)
		{
			for(CachorroQuente c : v.getCachorrosQuentes())
			{
				if(c.bebida == Bebida.DELRIO)
				{
					qtd++;
				}
			}
		}
		return qtd;
	}
	
	private int qtdSucoChaves(ArrayList<Venda> vendas)
	{
		int qtd = 0;
		for(Venda v : vendas)
		{
			for(CachorroQuente c : v.getCachorrosQuentes())
			{
				if(c.bebida == Bebida.SUCO_DO_CHAVES)
				{
					qtd++;
				}
			}
		}
		return qtd;
	}
	
	private int qtdAlunos(ArrayList<Venda> vendas)
	{
		int qtd = 0;
		for(Venda v : vendas)
		{
			if(v.getCliente().getClass().equals(Aluno.class))
			{
				for(CachorroQuente cachorroQuente : v.getCachorrosQuentes())
				{
					qtd++;
				}
			}
		}
		return qtd;
	}
	
	private int qtdProfessores(ArrayList<Venda> vendas)
	{
		int qtd = 0;
		for(Venda v : vendas)
		{
			if(v.getCliente().getClass() == Professor.class)
			{
				for(CachorroQuente cachorroQuente : v.getCachorrosQuentes())
				{
					qtd++;
				}
			}
		}
		return qtd;
	}
	
	private int qtdServidores(ArrayList<Venda> vendas)
	{
		int qtd = 0;
		for(Venda v : vendas)
		{
			if(v.getCliente().getClass() == Servidor.class)
			{
				for(CachorroQuente cachorroQuente : v.getCachorrosQuentes())
				{
					qtd++;
				}
			}
		}
		return qtd;
	}
	
	private int qtdCQ(ArrayList<Venda> vendas)
	{
		int qtd = 0;
		for(Venda v : vendas)
		{
			qtd += v.qtdCachorroQuente();
		}
		return qtd;
	}
	
	//Calcular valor:
	private double valorTotal = 0;
	private double valorDesconto = 0;

	private void calcularValor(Venda venda) 
	{
		int qtdSalsicha = qtdSalsicha(venda);
		int qtdBacon = qtdBacon(venda);
		int qtdFrango = qtdFrango(venda);
		int qtdLinguica = qtdLinguica(venda);
		
		double valor = 0;
		
		if(qtdSalsicha > 2) {
			valor += (qtdSalsicha*2.0)*0.9;
			valorDesconto += (qtdSalsicha*2.0)*0.1;
		} else {
			valor += qtdSalsicha*2.0;
		}
		if(qtdLinguica > 2) {
			valor += (qtdLinguica*3.0)*0.88;
			valorDesconto += (qtdLinguica*3.0)*0.12;
		} else {
			valor += qtdLinguica*3.0;
		}
		if(qtdFrango > 3) {
			valor += (qtdFrango*2.5)*0.87;
			valorDesconto += (qtdFrango*2.5)*0.13;
		} else {
			valor += qtdFrango*2.5;
		}
		if(qtdBacon > 4) {
			valor += (qtdBacon*3.5)*0.86;
			valorDesconto += (qtdBacon*3.5)*0.14;
		} else {
			valor += qtdBacon*3.5;
		}
		
		System.out.printf("Valor total: R$ %.2f%n", valor);
	}
	
	private void calcularValor(ArrayList<Venda> vendas) 
	{
		for(Venda v : vendas)
		{
			int qtdSalsicha = qtdSalsicha(v);
			int qtdBacon = qtdBacon(v);
			int qtdFrango = qtdFrango(v);
			int qtdLinguica = qtdLinguica(v);
			
			if(qtdSalsicha > 2) {
				valorTotal += (qtdSalsicha*2.0)*0.9;
			} else {
				valorTotal += qtdSalsicha*2.0;
			}
			if(qtdLinguica > 2) {
				valorTotal += (qtdLinguica*3.0)*0.88;
			} else {
				valorTotal += qtdLinguica*3.0;
			}
			if(qtdFrango > 3) {
				valorTotal += (qtdFrango*2.5)*0.87;
			} else {
				valorTotal += qtdFrango*2.5;
			}
			if(qtdBacon > 4) {
				valorTotal += (qtdBacon*3.5)*0.86;
			} else {
				valorTotal += qtdBacon*3.5;
			}
		}
	}

}
