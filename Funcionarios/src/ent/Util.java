package ent;

public class Util {
	private Integer matricula;
	private String nome;
	private Double salario;
	
	public Util() {
	}

	public Util(Integer matricula, String nome, Double salario) {
		this.matricula = matricula;
		this.nome = nome;
		this.salario = salario;
	}

	public Integer getMatricula() {
		return matricula;
	}

	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}
	
	public void aumento_Salario(double percentual) {
		salario += (salario * percentual/100.0);
	}
	
	public String toString(){
		return matricula + ", " + nome + ", " + String.format("%.2f", salario);
	}
	
	
}
