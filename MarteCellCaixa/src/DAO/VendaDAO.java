package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Conexao.Conexao;
import model.Produto;
import model.Relatorio;
import model.Venda;

public class VendaDAO {
	
	Conexao conexao = new Conexao("localhost", "5432", "martecell", "postgres", "root");
	public VendaDAO() {
		criarVenda();
	}
	
	public void criarVenda() {
		conexao.conect();
		ResultSet rs = null;
		try {
			rs = conexao.getStatment().executeQuery("SELECT * FROM public.venda");
		} catch (SQLException e1) {
		}
		if(rs == null) {
		String sql = "CREATE TABLE public. venda(id serial, codprodutos varchar, codvenda varchar, descricao varchar, data date, horas time without time zone, valor float, valorComprado float, formaDePagamento varchar, desconto boolean, PRIMARY KEY (id));";
		try {
			conexao.getStatment().execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		try {
			String sql = "ALTER TABLE public. venda ADD COLUMN valorComprado float, ADD COLUMN codvenda varchar;";
			conexao.getStatment().execute(sql);
		}catch(SQLException e) {
			
		}
		conexao.disconect();
	}
	
	public void deleteTodasVendas() {
		conexao.conect();
		String sql = "TRUNCATE TABLE public.venda;";
		try {
			conexao.getStatment().execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		conexao.disconect();
	}
	
	public void novaVenda(String codprodutos, String codvenda, String descricao, LocalDate data, String horas, float valor, float valorComprado, String formaDePagamento, Boolean desconto) {
		conexao.conect();
		String sql = "INSERT INTO public. venda(id, codprodutos, codvenda, descricao, data, horas, valor, valorComprado, formaDePagamento, desconto) VALUES ("+"DEFAULT"+", '"+codprodutos+"', '"+codvenda+"', '"+descricao+"', '"+data+"', '"+horas+"', "+valor+", "+valorComprado+", '"+formaDePagamento+"', "+desconto+");";
		try {
			conexao.getStatment().execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		conexao.disconect();
	}
	
	
	public int buscarUltimaVenda() {
		conexao.conect();
		String sql = "SELECT codvenda FROM public.venda order by id desc limit 1;";
		ResultSet rs = null;
		try {
			rs = conexao.getStatment().executeQuery(sql);
			while(rs.next()) {
			int codVenda =  Integer.parseInt(rs.getString("codvenda")) + 1;
			return codVenda;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		conexao.disconect();

		return 0;
	}
	
	public List <Relatorio> buscarVendas(String DataInicial,  String DataFinal) {
		conexao.conect();
		String sql = "SELECT * FROM public.venda WHERE data BETWEEN '"+DataInicial+"' AND '"+DataFinal+"';";
		ResultSet rs = null;
		try {
			rs = conexao.getStatment().executeQuery(sql);
			if(rs != null) {
				List <Relatorio> relatorios = new ArrayList<Relatorio>();
				while(rs.next()) {
				Relatorio relatorio = new Relatorio();
				
				relatorio.setData(rs.getString("data"));
				String valor = "";
				if(rs.getString("valor").contains(".") == false) {
					valor = "R$" + rs.getString("valor") + ",00";
				}else {
					valor = "R$" + rs.getString("valor").replace(".", ",");
					if(valor.codePointCount(valor.indexOf(","), valor.length()-1) < 2) {
						valor += "0";
					}
					
				}
				String valorComprado = "";
				if(rs.getString("valorcomprado").contains(".") == false) {
					valorComprado = "R$" + rs.getString("valorcomprado") + ",00";
				}else {
					valorComprado = "R$" + rs.getString("valorcomprado").replace(".", ",");
					if(valorComprado.codePointCount(valorComprado.indexOf(","), valorComprado.length()-1) < 2) {
						valorComprado += "0";
					}
					
				}
				relatorio.setValorComprado(valorComprado);
				relatorio.setValor(valor);
				relatorio.setDescricao(rs.getString("descricao"));
				
				relatorios.add(relatorio);
				}
				conexao.disconect();
				return relatorios;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			conexao.disconect();
			e.printStackTrace();
		}
		return null;
	}
	
//	public List <Venda> todasVendas() {
//		conexao.conect();
//		String sql = "SELECT * FROM public.venda;";
//		ResultSet rs = null;
//		try {
//			rs = conexao.getStatment().executeQuery(sql);
//			if(rs != null) {
//				List <Venda> todasVendas = new ArrayList<Venda>();
//				
//				EstoqueDAO eDAO = new EstoqueDAO();
//				
//				while(rs.next()) {
//				Venda venda = new Venda();
//				
//				venda.setCodProdutos(rs.getString("codprodutos"));
//				venda.setValor(rs.getFloat("valor"));
//				
//				String[] itens = venda.getCodProdutos().split(";");
//				
//				int zero = 0;
//				float valorSemServico = 0;
//				float valorServico = 0;
//				
//				for(int i = 0; i < itens.length; i++) {
//					if(itens[i] != null) {
//						if(itens[i].length() == 4) {
//							if(itens[i].equals("0000"))
//								zero++;
//							else {
//								System.out.println(itens[i]);
//								Produto p = eDAO.buscar(itens[i]);
//								if(p == null)
//									p = eDAO.buscar("0202");
//								if(rs.getBoolean("desconto") == true)
//									valorSemServico += p.getValor() - (p.getValor()/100)*10;
//								else {
//								valorSemServico += p.getValor();
//								}
//							}
//						}
//					}
//				}
//				if(zero != 0)
//					valorServico = (venda.getValor() - valorSemServico) / zero;
//
//				
//				for(int i = 0; i < itens.length; i++) {
//					if(itens[i] != null) {
//						if(itens[i].length() == 4) {
//							Produto p = eDAO.buscar(itens[i]);
//							Venda venda1 = new Venda();
//							if(p == null)
//								p = eDAO.buscar("0202");
//							venda1.setCodProdutos(p.getCod());
//							String codVenda = "" + (todasVendas.size() + 1);
//							venda1.setCodVenda(codVenda);
//							venda1.setData(rs.getDate("data").toLocalDate());
//							venda1.setDesconto(rs.getBoolean("desconto"));
//							venda1.setFormaDePagamento(rs.getString("formadepagamento"));
//							venda1.setHoras(rs.getString("horas"));
//							
//							if(!venda1.getCodProdutos().equals("0000")) {
//							if(venda1.getDesconto() == true)
//								venda1.setValor(p.getValor() - (p.getValor()/100)*10);
//							else
//								venda1.setValor(p.getValor());
//							}else
//								venda1.setValor(valorServico);
//							
//							
//							
//							if(itens[i].equals("0000"))
//								venda1.setValorComprado(0);
//							else
//							venda1.setValorComprado(p.getValorComprado());
//							
//							todasVendas.add(venda1);
//						
//						}
//					}
//				}
//				
//				
//				}
//				deleteTodasVendas();
//				
//				for(int i = 0; i < todasVendas.size(); i++) {
//					Produto p = eDAO.buscar( todasVendas.get(i).getCodProdutos());
//					
//					novaVenda(todasVendas.get(i).getCodProdutos(), todasVendas.get(i).getCodVenda(), p.getNome(), todasVendas.get(i).getData(), todasVendas.get(i).getHoras(), 
//							todasVendas.get(i).getValor(), todasVendas.get(i).getValorComprado(), todasVendas.get(i).getFormaDePagamento(), todasVendas.get(i).getDesconto());
//
//				}
//				
//				conexao.disconect();
//				return todasVendas;
//			}
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			conexao.disconect();
//			e.printStackTrace();
//		}
//		return null;
//	}

}
