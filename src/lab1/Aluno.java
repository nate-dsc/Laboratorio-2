package lab1;

public class Aluno extends Cliente {

	private String nome;
	private int matricula;
	
	public Aluno(String nome, int matricula) {
		this.nome = nome;
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public int getMatricula() {
		return matricula;
	}	
	
	public int getID()
	{
		return this.matricula;
	}
	
}
