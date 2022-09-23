package model;

public class Produto {
	
	private String Cod;
	private String Nome;
	private int Quantidade;
	private float Valor;
	private float ValorComprado;
	
	public Produto() {

	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public int getQuantidade() {
		return Quantidade;
	}

	public void setQuantidade(int quantidade) {
		Quantidade = quantidade;
	}

	public float getValor() {
		return Valor;
	}

	public void setValor(float valor) {
		Valor = valor;
	}

	public float getValorComprado() {
		return ValorComprado;
	}

	public void setValorComprado(float valorComprado) {
		ValorComprado = valorComprado;
	}

	public String getCod() {
		return Cod;
	}

	public void setCod(String cod) {
		Cod = cod;
	}

	
}
