package Control;

import java.util.List;

import javax.swing.JOptionPane;

import javax.swing.JTable;

import Configuracao.ProdutoTableModel;
import DAO.EstoqueDAO;
import View.Estoque;
import View.EstoqueAdicionar;
import View.EstoqueEditar;
import View.Menu;
import model.Login;
import model.Produto;
import View.CarregarTabelas;

public class ControlEstoque {
	
@SuppressWarnings("unused")
private Estoque view;
	
	public ControlEstoque(Estoque view) {
		this.view = view;
		
	}

	
	public void alimentarTabela(ProdutoTableModel ptModel, JTable table, Login usuarioLogado) {
		EstoqueDAO estoqueDAO = new EstoqueDAO();
		ptModel = new ProdutoTableModel(usuarioLogado);		

		int totalItens = estoqueDAO.produtosEstoque().size()/100;
		CarregarTabelas.main(null);
		List <Produto> estoque = estoqueDAO.produtosEstoque();
		for(int i = 0; i < estoque.size(); i++ ) {
			ptModel.addRow(estoque.get(i));
			CarregarTabelas.setCarregar(CarregarTabelas.getCarregar()+totalItens);
		}

		table.setModel(ptModel);
	}
	
	public void adicionar() {
		EstoqueAdicionar.main(null);
	}
	
	public void editar(JTable table, Login usuarioLogado) {
		EstoqueDAO estoqueDAO = new EstoqueDAO();
		
		if(table.getSelectedRow() != -1) {
			
			EstoqueEditar.setUsuarioLogado(usuarioLogado);
			
			EstoqueEditar e = new EstoqueEditar();
			
			Float f = estoqueDAO.buscar(table.getValueAt(table.getSelectedRow(), 0).toString()).getValorComprado();
			
			e.setCod(table.getValueAt(table.getSelectedRow(), 0).toString());
			e.getTextCod().setText(table.getValueAt(table.getSelectedRow(), 0).toString());
			e.getTextNome().setText(table.getValueAt(table.getSelectedRow(), 1).toString());
			e.getTextQuantidade().setText(table.getValueAt(table.getSelectedRow(), 2).toString());
			e.getTextValor().setText(table.getValueAt(table.getSelectedRow(), 3).toString());
			e.getTextValorComprado().setText(f.toString());
			
			e.setVisible(true);
			
		}else {
			
			JOptionPane.showMessageDialog(null, "selecione um item da tabela!");
			
		}
		
		
	}
	
	public void deletar(JTable table) {
		if(table.getSelectedRow() != -1) {

			Object[] options = { "Confirmar", "Cancelar" };
			int opc =JOptionPane.showOptionDialog(null, "Deseja realmente Deletar esse item?", "Informação", 
					JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);

			if(opc == 0) {
				EstoqueDAO estoqueDAO = new EstoqueDAO();
				estoqueDAO.deletar(table.getValueAt(table.getSelectedRow(), 0).toString());
				Estoque.setAtualiza(true);
			}
		}else {
			
			JOptionPane.showMessageDialog(null, "selecione um item da tabela!");
			
		}
	}
	
	public void criarEstoque() {
		EstoqueDAO estoqueDAO = new EstoqueDAO();
		estoqueDAO.criarEstoque();
	}
	
	public void voltar(Login usuarioLogado) {
		view.dispose();
		Menu.setUsuarioLogado(usuarioLogado);
		Menu.main(null);
	}
}
