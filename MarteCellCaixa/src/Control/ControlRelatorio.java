package Control;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import com.toedter.calendar.JDateChooser;

import Configuracao.TableRelatorio;
import DAO.VendaDAO;
import View.Menu;
import View.Relatorio;
import model.Login;

public class ControlRelatorio {
	
	private Relatorio view;
		
		public ControlRelatorio(Relatorio view) {
			this.view = view;
			
		}
		
		public void buscar(TableRelatorio trModel, JTable table, JDateChooser dateChooser1,  JDateChooser dateChooser2, JLabel Total) {
			try {
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				
				Date date1 = dateChooser1.getDate();
				Date date2 = dateChooser2.getDate();
				
				String strDateChoose1 = formatter.format(date1);
				String strDateChoose2 = formatter.format(date2);
				
				if(date1.compareTo(date2) < 0) {
					VendaDAO vendaDAO = new VendaDAO();
					
						trModel.removeAllRow();
					
					for(int i = 0; i < vendaDAO.buscarVendas(strDateChoose1, strDateChoose2).size(); i++ )
						trModel.addRow(vendaDAO.buscarVendas(strDateChoose1, strDateChoose2).get(i));
		
					table.setModel(trModel);
					
					Float total = (float) 0;
					String totalStr = "";
					for(int i=0; i < table.getRowCount(); i++) {
						total = total + Float.valueOf(table.getValueAt(i, 2).toString().replace("R$", "").replace(",", "."));
					}
					if(total.toString().contains(".") == false) {
						totalStr = "R$" + total + ",00";
					}else {
						totalStr = "R$" + total.toString().replace(".", ",");
						if(totalStr.codePointCount(totalStr.indexOf(","), totalStr.length()-1) < 2) {
							totalStr += "0";
						}
						
					}
					Total.setText(totalStr);
				}else
				JOptionPane.showMessageDialog(null,"Selecione uma data válida.","Data Inválida",JOptionPane.INFORMATION_MESSAGE);
				
			}catch(Exception e) {
				JOptionPane.showMessageDialog(null,"Selecione uma data válida.","Data Inválida",JOptionPane.INFORMATION_MESSAGE);
			}
		}
		
		public void voltar(Login usuarioLogado) {
			view.dispose();
			Menu.setUsuarioLogado(usuarioLogado);
			Menu.main(null);
		}

}
