package Control;

import java.util.List;

import javax.swing.JTable;

import Configuracao.PeliculaTableModel;
import DAO.EstoqueDAO;
import View.Pelicula;
import View.Venda;
import model.Login;
import model.Produto;

public class ControlPelicula {
	
	private Pelicula view;
	
	public ControlPelicula(Pelicula view) {
		this.view = view;
	}
	
	public void carregarTabelas(PeliculaTableModel ptModel,  JTable table){
		EstoqueDAO estoqueDAO = new EstoqueDAO();
		String str = "PELICULA";
		List <Produto> produtos = estoqueDAO.buscarProdutosEstoque(str);
		for(int i = 0; i < produtos.size(); i++ )
			ptModel.addRow(produtos.get(i));

		table.setModel(ptModel);
	}
	public void abrirVenda(Login usuario) {
		view.dispose();
		Venda.setUsuarioLogado(usuario);
		Venda.main(null);
	}

}
