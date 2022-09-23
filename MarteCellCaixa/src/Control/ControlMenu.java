package Control;

import View.Menu;
import View.Relatorio;
import View.Cadastro;
import View.Estoque;
import View.Venda;
import model.Login;

public class ControlMenu {

	private Menu view;
	
	public ControlMenu(Menu view) {
		this.view = view;
	}

	public void abrirVenda(Login usuario) {
		view.dispose();
		Venda.setUsuarioLogado(usuario);
		Venda.main(null);
	}
	
	public void abrirEstoque(Login usuario) {
		view.dispose();
		Estoque.setUsuarioLogado(usuario);
		Estoque.main(null);
	}
	
	public void abrirRelatorio(Login usuarioLogado) {
		view.dispose();
		Relatorio.setUsuarioLogado(usuarioLogado);
		Relatorio.main(null);
	}
	
	public void cadastrarVendedor() {
		Cadastro.main(null);
	}
}
