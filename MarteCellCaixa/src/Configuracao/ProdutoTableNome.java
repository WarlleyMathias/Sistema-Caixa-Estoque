package Configuracao;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Produto;

/**
 *
 * @author Samuelson
 */
@SuppressWarnings("serial")
public class ProdutoTableNome extends AbstractTableModel{

    private List<Produto> dados = new ArrayList<>();
    private String[] colunas;
    
    public ProdutoTableNome() {
    	
    		String[] c= {"Cod.", "Nome"};
    		this.colunas = c;
    		
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