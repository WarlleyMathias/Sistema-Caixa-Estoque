package Control;

import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import DAO.EstoqueDAO;
import View.Estoque;
import View.EstoqueEditar;
import model.Produto;

public class ControlEstoqueEditar {

@SuppressWarnings("unused")
private EstoqueEditar view;
	
	public ControlEstoqueEditar(EstoqueEditar view) {
		this.view = view;
		
	}
	
	public void editar(String Cod, String Nome, int Quantidade, float Valor, float ValorComprado, JTextField textCod,
			JTextField textNome, JTextField textQuantidade, JFormattedTextField textValor, JFormattedTextField textValorComprado) {
		if(textCod.getText().equals("") || textNome.getText().equals("") || 
				textQuantidade.getText().equals("") || textValor.getText().equals("") || textValorComprado.getText().equals("")) {
			
			JOptionPane.showInternalMessageDialog(null, "preencha todos os campos!");
			
		}
		else {
			EstoqueDAO estoqueDAO = new EstoqueDAO();
			estoqueDAO.editar(Cod, Nome.toUpperCase(), Quantidade, Valor, ValorComprado);
			Estoque.setAtualiza(true);
		}
	}
	
	public void iniciarCampos(Produto produto, JTextField textCod, JTextField textNome,
			JTextField textQuantidade, JFormattedTextField textValor, JFormattedTextField textValorComprado) {
		textCod.setText(produto.getCod() + "");
		textNome.setText(produto.getNome());
		textQuantidade.setText(produto.getQuantidade() + "");
		textValor.setText(produto.getValor() + "");
		textValor.setText(produto.getValorComprado() + "");
	}
	
}
