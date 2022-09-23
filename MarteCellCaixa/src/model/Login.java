package model;

public class Login {
	
	private String name;
	private String senha;
	private String role;
	
	
	
	public Login(String name, String senha, String role) {
		super();
		this.name = name;
		this.senha = senha;
		this.role = role;
	}
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	

}
