package model;

import java.time.LocalDate;

public class Venda {
	
	private float Valor;
	private LocalDate Data;
	private String horas;
	private String CodProdutos;
	
	public float getValor() {
		return Valor;
	}
	public void setValor(float valor) {
		Valor = valor;
	}

	public String getCodProdutos() {
		return CodProdutos;
	}
	public void setCodProdutos(String codProdutos) {
		CodProdutos = codProdutos;
	}
	public String getHoras() {
		return horas;
	}
	public void setHoras(String horas) {
		this.horas = horas;
	}
	public LocalDate getData() {
		return Data;
	}
	public void setData(LocalDate data) {
		Data = data;
	}
	

}
