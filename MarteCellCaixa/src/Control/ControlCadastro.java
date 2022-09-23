package Control;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import DAO.LoginDAO;
import View.Cadastro;
import model.Login;

public class ControlCadastro {
	
@SuppressWarnings("unused")
private Cadastro view;
	
	public ControlCadastro(Cadastro view) {
		this.view = view;
		
	}
	
	public void cadastrarFuncionario(JTextField textLogin, JPasswordField textSenha) {
		LoginDAO loginDAO = new LoginDAO();
		int loginVerificado = loginDAO.verificarLoginExistente(textLogin.getText());
		
		if(loginVerificado == 0) {
			JOptionPane.showMessageDialog(null,"Login já cadastrado.","Login Inválido",JOptionPane.INFORMATION_MESSAGE);
		}
		
		if(textLogin.getText().equals(null)) {
			JOptionPane.showMessageDialog(null,"O login deve conter pelo menos 1 digto.","Login Inválido",JOptionPane.INFORMATION_MESSAGE);
			
		}
		if(textSenha.getPassword().equals(null) || textSenha.getPassword().toString().length() != 4) {
			JOptionPane.showMessageDialog(null,"A senha deve conter 4 digtos.","Senha Inválida",JOptionPane.INFORMATION_MESSAGE);
		}

		if(!textLogin.getText().equals(null) && !textSenha.getPassword().equals(null) && textSenha.getPassword().toString().length() == 4) {
			Login usuario = new Login(textLogin.getText(), String.valueOf(textSenha.getPassword()), "FUNCIONARIO");
			loginDAO.cadastrarFuncionario(usuario);
			JOptionPane.showMessageDialog(null,"Cadastro realizado com sucesso.","Funcionario Cadastrado",JOptionPane.INFORMATION_MESSAGE);
		}

	}

}
