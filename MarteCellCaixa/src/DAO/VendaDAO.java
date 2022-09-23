package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Conexao.Conexao;
import model.Relatorio;

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
		String sql = "CREATE TABLE public. venda(id serial, codprodutos varchar, descricao varchar, data date, horas time without time zone, valor float, PRIMARY KEY (id));";
		try {
			conexao.getStatment().execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		conexao.disconect();
	}
	
	public void novaVenda(String codprodutos, String descricao, LocalDate data, String horas, float valor) {
		conexao.conect();
		String sql = "INSERT INTO public. venda(id, codprodutos, descricao, data, horas, valor) VALUES ("+"DEFAULT"+", '"+codprodutos+"', '"+descricao+"', '"+data+"', '"+horas+"', "+valor+");";
		try {
			conexao.getStatment().execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		conexao.disconect();
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

}
