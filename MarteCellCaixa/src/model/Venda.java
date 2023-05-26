package model;

import java.time.LocalDate;

public class Venda {
	
	private float Valor;
	private float ValorComprado;
	private LocalDate Data;
	private String horas;
	private String CodProdutos;
	private String CodVenda;
	private String formaDePagamento;
	private Boolean desconto;
	
	public String getCodVenda() {
		return CodVenda;
	}
	public void setCodVenda(String codVenda) {
		CodVenda = codVenda;
	}
	public float getValorComprado() {
		return ValorComprado;
	}
	public void setValorComprado(float valorComprado) {
		ValorComprado = valorComprado;
	}
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
	public String getFormaDePagamento() {
		return formaDePagamento;
	}
	public void setFormaDePagamento(String formaDePagamento) {
		this.formaDePagamento = formaDePagamento;
	}
	public Boolean getDesconto() {
		return desconto;
	}
	public void setDesconto(Boolean desconto) {
		this.desconto = desconto;
	}
	

}
