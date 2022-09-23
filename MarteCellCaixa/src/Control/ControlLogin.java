package Control;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


import DAO.LoginDAO;
import View.LoginView;
import View.Menu;
import model.Login;

public class ControlLogin {
	
private LoginView view;
	
	public ControlLogin(LoginView view) {
		this.view = view;
		
	}
	
	public void entrar(JTextField textLogin, JPasswordField textSenha) {
		LoginDAO loginDAO = new LoginDAO();
		
		int verificado = loginDAO.verificarLogin(textLogin.getText(), String.valueOf(textSenha.getPassword()));
		
		switch (verificado) {
		
			case 0:
				JOptionPane.showMessageDialog(null,"Verifique o Login, e o informe corretamente!","Login Inválido",JOptionPane.INFORMATION_MESSAGE);
				break;
			
			case 1:
				view.dispose();
				Login usuario = new Login(textLogin.getText(), String.valueOf(textSenha.getPassword()), "ADMIN");
				Menu.setUsuarioLogado(usuario);
				Menu.main(null);
				break;
				
			case 2:
				view.dispose();
				Login usuario2 = new Login(textLogin.getText(), String.valueOf(textSenha.getPassword()), "FUNCIONARIO");
				Menu.setUsuarioLogado(usuario2);
				Menu.main(null);
				break;
				
			case 3:
				JOptionPane.showMessageDialog(null,"Verifique a Senha, e a informe corretamente!","Senha Inválida",JOptionPane.INFORMATION_MESSAGE);
				break;
			
		}
	}
	
	public void criarTabelaLogin() {
		LoginDAO loginDAO = new LoginDAO();
		loginDAO.criarLogin();
	}

}
