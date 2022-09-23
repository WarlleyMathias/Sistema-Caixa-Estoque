package Control;


import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import Configuracao.ProdutoTableNome;
import DAO.EstoqueDAO;
import View.BuscarProduto;
import View.Venda;

public class ControlBuscarProduto {
	
	private BuscarProduto view;
	
	public ControlBuscarProduto(BuscarProduto view) {
		this.view = view;
	}

	public void buscarProdutosEstoque(JTextField textBuscar, ProdutoTableNome ptModel, JTable table){

		if(!textBuscar.getText().equals("")) {
		EstoqueDAO estoqueDAO = new EstoqueDAO();
		ptModel = new ProdutoTableNome();
		
		for(int i = 0; i < estoqueDAO.buscarProdutosEstoque(textBuscar.getText()).size(); i++ )
			ptModel.addRow(estoqueDAO.buscarProdutosEstoque(textBuscar.getText()).get(i));

		table.setModel(ptModel);
		}else {
			JOptionPane.showMessageDialog(null,"Digte algo no campo de pesquisa.","Campo Vazio",JOptionPane.INFORMATION_MESSAGE);
		}

	}
	
	public void getProduto(Venda view2, JTable table) {
		if(table.getSelectedRow() != -1) {
			ControlVenda c = new ControlVenda(view2);
			c.inserirCod(table.getValueAt(table.getSelectedRow(), 0).toString());
			view.dispose();
		}else {
			JOptionPane.showMessageDialog(null,"Selecione um item.","Nenhum Item Selecionado",JOptionPane.INFORMATION_MESSAGE);
		}
	}

}
