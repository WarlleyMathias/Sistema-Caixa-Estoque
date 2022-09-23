package Configuracao;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Login;
import model.Produto;

/**
 *
 * @author Samuelson
 */
@SuppressWarnings("serial")
public class ProdutoTableModel extends AbstractTableModel{

	@SuppressWarnings("unused")
	private Login usuario;
    private List<Produto> dados = new ArrayList<>();
    private String[] colunas;
    
    public ProdutoTableModel(Login usuario) {
    	this.usuario = usuario;
    	
    	if(usuario.getRole().equals("ADMIN")) {
    		String[] c= {"Cod.", "Nome", "Quantidade", "Valor", "Valor Comprado"};
    		this.colunas = c;
    	}else {
    		String[] c= {"Cod.", "Nome", "Quantidade", "Valor"};
    		this.colunas = c;
    	}
    		
    }

    public String[] getColunas() {
		return colunas;
	}


	@Override
    public String getColumnName(int column) {
        return colunas[column]; //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public int getRowCount() {
        return dados.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        
        switch(coluna){
            case 0:
                return dados.get(linha).getCod();
            case 1:
                return dados.get(linha).getNome();
            case 2: 
                return dados.get(linha).getQuantidade();
            case 3: 
                return dados.get(linha).getValor();
            case 4: 
                return dados.get(linha).getValorComprado();
        }
        
        return null;
        
    }
    
    public void addRow(Produto p){
        this.dados.add(p);
        this.fireTableDataChanged();
    }
    
    public void removeRow(int linha){
        this.dados.remove(linha);
        this.fireTableRowsDeleted(linha, linha);
    }
    
    
}