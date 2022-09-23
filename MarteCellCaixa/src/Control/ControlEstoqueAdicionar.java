package Control;

import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import DAO.EstoqueDAO;
import View.Estoque;
import View.EstoqueAdicionar;

public class ControlEstoqueAdicionar {

@SuppressWarnings("unused")
private EstoqueAdicionar view;
	
	public ControlEstoqueAdicionar(EstoqueAdicionar view) {
		this.view = view;
		
	}
	
	public void adicionar(JTextField textCod, JTextField textNome, JTextField textQuantidade, JFormattedTextField textValor, JFormattedTextField textValorComprado) {
		EstoqueDAO estoqueDAO = new EstoqueDAO();
		
		if(estoqueDAO.buscar(textCod.getText()) != null) {
			JOptionPane.showInternalMessageDialog(null, "Já existe outro produto cadastrado com o mesmo codigo.");
		}
		else if(textCod.getText().equals("") || textNome.getText().equals("") || 
				textQuantidade.getText().equals("") || textValor.getText().equals("") || textValorComprado.getText().equals("")) {
			
			JOptionPane.showInternalMessageDialog(null, "preencha todos os campos!");
			
		}
		else {
			Float Valor  = Float.valueOf(textValor.getText().replace(".", "").replace(",", "."));
			Float ValorComprado = Float.valueOf(textValorComprado.getText().replace(".", "").replace(",", "."));
			String Cod        = textCod.getText();
			String Nome       = textNome.getText().toUpperCase();
			Integer Quantidade = Integer.valueOf(textQuantidade.getText());	
			estoqueDAO.adicionar(Cod, Nome, Quantidade, Valor, ValorComprado);
			Estoque.setAtualiza(true);
			}
			
		}
	
}
