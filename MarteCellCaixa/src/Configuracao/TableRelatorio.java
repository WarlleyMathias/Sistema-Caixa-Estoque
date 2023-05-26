package Configuracao;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;
import model.Relatorio;

/**
 *
 * @author Samuelson
 */
@SuppressWarnings("serial")
public class TableRelatorio extends AbstractTableModel{

    private List<Relatorio> dados = new ArrayList<>();
    
    private String[] colunas = {"Data", "Descrição", "Valor"};

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
                return dados.get(linha).getData();
            case 1:
                return dados.get(linha).getDescricao();
            case 2:
                return dados.get(linha).getValor();
        }
        
        return null;
        
    }
    
    public void addRow(Relatorio r){
        this.dados.add(r);
        this.fireTableDataChanged();
    }
    
    public void removeRow(int linha){
        this.dados.remove(linha);
        this.fireTableRowsDeleted(linha, linha);
    }
    
    public void removeAllRow(){
        this.dados.removeAll(dados);
        this.fireTableDataChanged();
    }
    
    
}

