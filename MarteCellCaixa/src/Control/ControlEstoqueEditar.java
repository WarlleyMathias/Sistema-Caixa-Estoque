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
	
	public void editar(String Cod1, JTextField textCod,
			JTextField textNome, JTextField textQuantidade, JFormattedTextField textValor, JFormattedTextField textValorComprado) {
		
		Float Valor = Float.valueOf(textValor.getText().replace(".", "").replace(",", "."));
		Float ValorComprado = Float.valueOf(textValorComprado.getText().replace(".", "").replace(",", "."));
		String Cod = textCod.getText();
		String Nome = textNome.getText();
		int Quantidade = Integer.valueOf(textQuantidade.getText());
		
		try {
			
			EstoqueDAO estoqueDAO = new EstoqueDAO();
			
			if(textCod.getText().equals("") || textNome.getText().equals("") || 
					textQuantidade.getText().equals("") || textValor.getText().equals("") || textValorComprado.getText().equals("")) {
				
				JOptionPane.showInternalMessageDialog(null, "preencha todos os campos!");
				
			}
			else {
				
				if(textCod.getText().length() >=4 && estoqueDAO.buscar(textCod.getText()) == null) {				
					
					estoqueDAO.editar(Cod1, Cod, Nome.toUpperCase(), Quantidade, Valor, ValorComprado);
					Estoque.setAtualiza(true);
					JOptionPane.showInternalMessageDialog(null, "Salvo com Sucesso!");
					view.dispose();
				
				}
				else if(Cod1.equals(textCod.getText())) {
					estoqueDAO.editar(Cod1, Cod, Nome.toUpperCase(), Quantidade, Valor, ValorComprado);
					Estoque.setAtualiza(true);
					JOptionPane.showInternalMessageDialog(null, "Salvo com Sucesso!");
					view.dispose();
				}
				else
					JOptionPane.showInternalMessageDialog(null, "Codigo inválido!");
				view.dispose();
			}
		}catch(Exception ee) {
			JOptionPane.showInternalMessageDialog(null, "preencha todos os campos!");
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
