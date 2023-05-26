package Control;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import com.toedter.calendar.JDateChooser;

import Configuracao.TableRelatorio;
import DAO.EstoqueDAO;
import DAO.VendaDAO;
import View.Menu;
import View.Relatorio;
import model.Login;

public class ControlRelatorio {
	
	private Relatorio view;
		
		public ControlRelatorio(Relatorio view) {
			this.view = view;
			
		}
		
		public void buscar(TableRelatorio trModel, JTable table, JDateChooser dateChooser1,  JDateChooser dateChooser2, JLabel TotalValor, JLabel TotalInvestidoValor, JLabel TotalLiquidoValor) {
			try {
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				
				Date date1 = dateChooser1.getDate();
				Date date2 = dateChooser2.getDate();
				
				String strDateChoose1 = formatter.format(date1);
				String strDateChoose2 = formatter.format(date2);
				
				if(date1.compareTo(date2) < 0) {
					VendaDAO vendaDAO = new VendaDAO();
					
						trModel.removeAllRow();
						
						List <model.Relatorio> Vendas = vendaDAO.buscarVendas(strDateChoose1, strDateChoose2);
					
					Float total = (float) 0;
					Float totalInvestido = (float) 0;
					Float totalLiquido = (float) 0;
					String totalStr = "";
					String totalCompStr = "";
					String totalLiquidoStr = "";
					
					for(int i = 0; i < Vendas.size(); i++ ) {
						trModel.addRow(Vendas.get(i));

						total = total + Float.valueOf(Vendas.get(i).getValor().replace("R$", "").replace(",", "."));
						totalInvestido = totalInvestido + Float.valueOf(Vendas.get(i).getValorComprado().replace("R$", "").replace(",", "."));
					}
					
					table.setModel(trModel);
					
					totalLiquido = total - totalInvestido;
					
					if(total.toString().contains(".") == false && totalInvestido.toString().contains(".") == false && totalLiquido.toString().contains(".") == false) {
						totalStr = "R$" + total + ",00";
						totalCompStr = "R$" + totalInvestido + ",00";
						totalLiquidoStr = "R$" + totalLiquido + ",00";
					}else {
						totalStr = "R$" + total.toString().replace(".", ",");
						totalCompStr = "R$" + totalInvestido.toString().replace(".", ",");
						totalLiquidoStr = "R$" + totalLiquido.toString().replace(".", ",");
						
						if(totalStr.codePointCount(totalStr.indexOf(","), totalStr.length()-1) < 2) {
							totalStr += "0";
						}
						if(totalCompStr.codePointCount(totalCompStr.indexOf(","), totalCompStr.length()-1) < 2) {
							totalCompStr += "0";
						}
						if(totalLiquidoStr.codePointCount(totalLiquidoStr.indexOf(","), totalLiquidoStr.length()-1) < 2) {
							totalLiquidoStr += "0";
						}
						
					}
					TotalValor.setText(totalStr);
					TotalInvestidoValor.setText(totalCompStr);
					TotalLiquidoValor.setText(totalLiquidoStr);
				}else
				JOptionPane.showMessageDialog(null,"Selecione uma data válida.","Data Inválida",JOptionPane.INFORMATION_MESSAGE);
				
			}catch(Exception e) {
				JOptionPane.showMessageDialog(null,"Selecione uma data válida.","Data Inválida",JOptionPane.INFORMATION_MESSAGE);
			}
		}
		
//		public void ajustarTabelas() {
//			VendaDAO vDAO = new VendaDAO();
//			vDAO.todasVendas();
//		}
		
		public void voltar(Login usuarioLogado) {
			view.dispose();
			Menu.setUsuarioLogado(usuarioLogado);
			Menu.main(null);
		}

}
