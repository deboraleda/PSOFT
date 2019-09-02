package lab1.ufcg;

public class Disciplina implements Comparable<Disciplina>{
	private int id;
	private String nome;
	private double nota;

	public Disciplina(int id, String nome, double nota) {
		super();
		this.id = id;
		this.nome = nome;
		this.nota = nota;
	}

	@Override
	public String toString() {
		return "Disciplina [id=" + id + ", nome=" + nome + ", nota=" + nota + "]";
	}

	public double getNota() {
		return nota;
	}

	@Override
	public int compareTo(Disciplina o) {
		if(this.getNota() > o.getNota())
			return 1;
		else if(this.getNota() < o.getNota())
			return -1;
		return 0;
	}

	public String getNome() {
		return nome;
	}
	
	public int getId() {
		return id;
	}
	
	public void atualizaDisciplina(String nome) {
		this.nome = nome;
	}
	
	public void atualizaNota(double nota) {
		this.nota = nota;
	}
}
