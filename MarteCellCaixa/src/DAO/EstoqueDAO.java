package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Conexao.Conexao;
import model.Produto;

public class EstoqueDAO {
	
	Conexao conexao = new Conexao("localhost", "5432", "martecell", "postgres", "root");
	
	public void vendaNoEstoque(String codprodutos) {
		conexao.conect();
		String sql = "UPDATE public.estoque SET quantidade=quantidade-1 WHERE cod='"+codprodutos+"';";
		try {
			conexao.getStatment().execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		conexao.disconect();
	}
	
	public void criarEstoque() {
		conexao.conect();
		ResultSet rs = null;
		try {
			rs = conexao.getStatment().executeQuery("SELECT * FROM public.estoque");
		} catch (SQLException e1) {
		}
		if(rs == null) {
		String sql = "CREATE TABLE public. Estoque(id serial, Cod varchar, Nome varchar, Quantidade integer, Valor float, ValorComprado float, PRIMARY KEY (id));";
		try {
			conexao.getStatment().execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		conexao.disconect();
	}
	
	public void adicionar(String cod, String nome, int quantidade, float valor, float valorComprado) {
		conexao.conect();
		String sql = "INSERT INTO public.estoque(id, cod, nome, quantidade, valor, valorComprado) VALUES ("+"DEFAULT"+", '"+cod+"', '"+nome+"', "+quantidade+", "+valor+", "+valorComprado+");";
		try {
			conexao.getStatment().execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		conexao.disconect();
	}
	
	public void editar(String cod1, String cod, String nome, int quantidade, float valor, float valorComprado) {
		conexao.conect();
		String sql = "UPDATE public.estoque SET cod='"+cod+"', nome='"+nome+"', quantidade="+quantidade+", valor="+valor+", valorComprado="+valorComprado+" WHERE cod='"+cod1+"'";
		try {
			conexao.getStatment().executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		conexao.disconect();
	}
	
	public void deletar(String cod) {
		conexao.conect();
		String sql = "DELETE FROM public.estoque WHERE cod='"+cod+"'";
		try {
			conexao.getStatment().executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		conexao.disconect();
	}
	
	public Produto buscar(String cod) {
		conexao.conect();
		String sql = "SELECT id, cod, nome, quantidade, valor, valorcomprado FROM public.estoque where cod='"+cod+"'";
		ResultSet rs = null;
		try {
			rs = conexao.getStatment().executeQuery(sql);
			if(rs != null) {
				while(rs.next()) {
				Produto produto = new Produto();
				
				produto.setCod(rs.getString("cod"));
				produto.setNome(rs.getString("nome"));
				produto.setQuantidade(rs.getInt("quantidade"));
				produto.setValor(rs.getFloat("valor"));
				produto.setValorComprado(rs.getFloat("valorComprado"));
				

				conexao.disconect();
				return produto;
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		conexao.disconect();
		return null;
	}
	
	public List <Produto> buscarProdutosEstoque(String substring) {
		
		conexao.conect();
		String sql = "SELECT * FROM public.estoque WHERE substring(nome,position('"+substring+"' in nome),"+substring.length()+") = '"+substring+"'";
		ResultSet rs = null;
		
		try {
			rs = conexao.getStatment().executeQuery(sql);
			if(rs != null) {
				List <Produto> produtosEstoque = new ArrayList <Produto>();
				
				while(rs.next()) {
					Produto produto = new Produto();
					
					produto.setCod(rs.getString("cod"));
					produto.setNome(rs.getString("nome"));
					produto.setQuantidade(rs.getInt("quantidade"));
					produto.setValor(rs.getFloat("valor"));
					produto.setValorComprado(rs.getFloat("valorComprado"));
					
					produtosEstoque.add(produto);
				}
				conexao.disconect();
				return produtosEstoque;
			}

		} catch (SQLException e) {
			conexao.disconect();
			e.printStackTrace();
		}	
		return null;
		
	}
	
	public List <Produto> produtosEstoque() {
		
		conexao.conect();
		String sql = "SELECT * FROM public.estoque";
		ResultSet rs = null;
		
		try {
			rs = conexao.getStatment().executeQuery(sql);
			if(rs != null) {
				List <Produto> produtosEstoque = new ArrayList <Produto>();
				
				while(rs.next()) {
					Produto produto = new Produto();
					
					produto.setCod(rs.getString("cod"));
					produto.setNome(rs.getString("nome"));
					produto.setQuantidade(rs.getInt("quantidade"));
					produto.setValor(rs.getFloat("valor"));
					produto.setValorComprado(rs.getFloat("valorComprado"));
					
					produtosEstoque.add(produto);
				}
				conexao.disconect();
				return produtosEstoque;
			}

		} catch (SQLException e) {
			conexao.disconect();
			e.printStackTrace();
		}	
		return null;
		
	}

}
