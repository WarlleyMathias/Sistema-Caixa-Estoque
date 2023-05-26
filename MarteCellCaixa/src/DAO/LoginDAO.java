package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import Conexao.Conexao;
import model.Login;

public class LoginDAO {

Conexao conexao = new Conexao("localhost", "5432", "martecell", "postgres", "root");
	
	public void criarLogin() {
		conexao.conect();
		ResultSet rs = null;
		try {
			rs = conexao.getStatment().executeQuery("SELECT * FROM public.login");
		} catch (SQLException e1) {
		}
		if(rs == null) {
		String sql = "CREATE TABLE public. login(id serial, name varchar, senha varchar, role varchar, PRIMARY KEY (id));";
		try {
			conexao.getStatment().execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		conexao.disconect();
	}
	
	public void cadastrarFuncionario(Login usuario) {
		conexao.conect();
		ResultSet rs = null;
		
		try {
			rs = conexao.getStatment().executeQuery("SELECT * FROM public.login WHERE name = '"+usuario.getName()+"'");
			
			if(rs.next() == false) {
				String sql = "INSERT INTO public.login (id, name, senha, role) VALUES ("+"DEFAULT"+", '"+usuario.getName()+"', '"+usuario.getSenha()+"', '"+usuario.getRole()+"');";
				conexao.getStatment().executeUpdate(sql);
			}
		} catch (SQLException e) {
		}
		conexao.disconect();
	}
	
	public int verificarLoginExistente(String name) {
		conexao.conect();
		ResultSet rs = null;
		try {
			rs = conexao.getStatment().executeQuery("SELECT * FROM public.login WHERE name = '"+name+"'");
		} catch (SQLException e1) {
			conexao.disconect();
		}
		if(rs != null) {
			try {
				while(rs.next()) {
					if(rs.getString("name").equals(name))
						return 0;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 1;
			
	}
		
	public int verificarLogin(String name, String senha) {
		conexao.conect();
		ResultSet rs = null;
		try {
			rs = conexao.getStatment().executeQuery("SELECT * FROM public.login WHERE name = '"+name+"'");
		} catch (SQLException e1) {
			conexao.disconect();
			return 0;
		}
		if(rs != null) {
			try {
				while(rs.next()) {
					if(senha.equals(rs.getString("senha"))) {
						if(rs.getString("role").equals("ADMIN")) {
							conexao.disconect();
							return 1;
						}else {
							conexao.disconect();
							return 2;
						}
						
					}else {
						conexao.disconect();
						return 3;
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		conexao.disconect();
		return 0;
	}
	
}
