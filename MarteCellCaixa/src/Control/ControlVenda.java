package Control;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import Configuracao.JtextNum;
import Configuracao.ProdutoTableVenda;
import Configuracao.Impressao;
import DAO.EstoqueDAO;
import DAO.VendaDAO;
import View.BuscarProduto;
import View.Menu;
import View.NovoServico;
import View.Pelicula;
import View.Venda;
import model.Login;
import model.Produto;

public class ControlVenda {
	
private Venda view;
	
	public ControlVenda(Venda view) {
		this.view = view;
		
	}
	
	public void verificaSpinner(JtextNum textCodigo, JTextField textTotal, JSpinner spinnerQuantidade) {
		if(textCodigo.getText().length() >= 4 && buscar(textCodigo.getText()) != null) {
			Produto produto = buscar(textCodigo.getText());
			textTotal.setText(String.valueOf(produto.getValor() * Integer.valueOf(spinnerQuantidade.getValue().toString()))); 
		}
	}
	
	public void verificaCodigo( JTable table, JtextNum textCodigo, JTextField textTotal, JSpinner spinnerQuantidade, JTextField textDescricao) {
		
		textTotal.setEditable(false);
		
		if(textCodigo.getText().length() >= 4 && buscar(textCodigo.getText()) != null) {
			Produto produto = buscar(textCodigo.getText());
			textDescricao.setText(produto.getNome());
			
			int qntd = 0;
			
			for(int i=0; i < table.getRowCount(); i++) {
				if(table.getValueAt(i, 0).equals(textCodigo.getText()))
				qntd -= 1;
			}
			
			qntd += produto.getQuantidade();
			
			spinnerQuantidade.setModel(new SpinnerNumberModel(0, 0, qntd, 1));
			textTotal.setText(String.valueOf(produto.getValor() * Integer.valueOf(spinnerQuantidade.getValue().toString()))); 
		}else if(!textTotal.getText().equals("")) {
			textTotal.setText("");
		}
		if(textCodigo.getText().equals("0000")) {
			spinnerQuantidade.setModel(new SpinnerNumberModel(1, 0, 1, 1));
			textTotal.setEditable(true);
		}
	}
	
	public Produto buscar(String cod) {
		EstoqueDAO estoqueDAO = new EstoqueDAO();
		return estoqueDAO.buscar(cod);
	}

	public void adicionar(JCheckBox chckbxDesconto, ProdutoTableVenda ptModel, JTable table, int Quantidade, JtextNum textCodigo, JTextField textTotal, JSpinner spinnerQuantidade,
			float total, JTextField textTotalVenda, JTextField textTotalVendaDesconto, JSpinner spinner) {
		if(!textCodigo.getText().equals("") && textCodigo.getText().length() >= 4 && buscar(textCodigo.getText()) != null && Integer.valueOf(spinnerQuantidade.getValue().toString()) != 0) {

			if(buscar(textCodigo.getText()) != null) {
				Produto produto = buscar(textCodigo.getText());
				
				for(int i = 0; i < Quantidade; i++ )
					
					if(!textCodigo.getText().equals("0000"))
						ptModel.addRow(produto);
					else {
						produto.setValor(Float.valueOf(textTotal.getText().replaceAll(",", ".")));
						ptModel.addRow(produto);
					}
				
					table.setModel(ptModel);
				
					int qntd = 0;
					
					if(!textCodigo.getText().equals("0000")) {
						for(int i=0; i < table.getRowCount(); i++) {
							if(table.getValueAt(i, 0).equals(textCodigo.getText()))
							qntd -= 1;
						}
					}
					
					qntd += produto.getQuantidade();
					
					if(!textCodigo.getText().equals("0000")) {
						spinnerQuantidade.setValue(0);
						spinnerQuantidade.setModel(new SpinnerNumberModel(0, 0, qntd, 1));
					}
						
				textTotal.setText(String.valueOf(produto.getValor() * Integer.valueOf(spinnerQuantidade.getValue().toString()))); 
			}
			total = 0;
			for(int i=0; i < table.getRowCount(); i++) {
				total = total + Float.valueOf(table.getValueAt(i, 2).toString());
			}
			if(chckbxDesconto.isSelected())
				textTotalVendaDesconto.setText(String.valueOf((float) (total - (total/100)*(int)spinner.getValue())));
				
			view.setTotal(total);
			textTotalVenda.setText(String.valueOf(total));
		}
		
		
		
	}
	
	public void remover(JSpinner spinnerQuantidade, JtextNum textCodigo, JCheckBox chckbxDesconto, ProdutoTableVenda ptModel, JTable table, 
			int row, float total, JTextField textTotalVenda, JTextField textTotalVendaDesconto, JSpinner spinner) {
		if(table.getSelectedRow() != -1) {
			
			ptModel.removeRow(row);
			table.setModel(ptModel);
			
			total = 0;
			for(int i=0; i < table.getRowCount(); i++) {
				total = total + Float.valueOf(table.getValueAt(i, 2).toString());
			}
			if(chckbxDesconto.isSelected())
				textTotalVendaDesconto.setText(String.valueOf((float) (total - (total/100)*(int)spinner.getValue())));
			
			
			if(!textCodigo.getText().equals("") && textCodigo.getText().length() == 4 && buscar(textCodigo.getText()) != null) {

				if(buscar(textCodigo.getText()) != null) {
					Produto produto = buscar(textCodigo.getText());
			
					int qntd = 0;
					
					for(int i=0; i < table.getRowCount(); i++) {
						if(table.getValueAt(i, 0).equals(textCodigo.getText()))
						qntd -= 1;
					}
			
					qntd += produto.getQuantidade();
					
					if(!textCodigo.getText().equals("0000")) {
						spinnerQuantidade.setValue(0);
						spinnerQuantidade.setModel(new SpinnerNumberModel(0, 0, qntd, 1));
					}
				}
			}
			view.setTotal(total);
			textTotalVenda.setText(String.valueOf(total));
			}
		
		
	}
	
	public void marcarCartao(JRadioButton rdbtnPix, JRadioButton rdbtnDinheiro, JRadioButton rdbtnCartao, JCheckBox chckbxDesconto, float total, JTextField textTotalVenda) {
		if(rdbtnDinheiro.isSelected() || rdbtnPix.isSelected()) {
			rdbtnDinheiro.setSelected(false);
			rdbtnPix.setSelected(false);
				if(chckbxDesconto.isSelected()) {
					chckbxDesconto.setSelected(false);
					total = (float) ((total/90.0) * 100.0) ;
					view.setTotal(total);
					textTotalVenda.setText(String.valueOf(total));
				}
			chckbxDesconto.setEnabled(false);
		}
		else
			rdbtnCartao.setSelected(true);
	}
	
	public void marcarDinheiro(JRadioButton rdbtnPix, JRadioButton rdbtnDinheiro, JRadioButton rdbtnCartao, JCheckBox chckbxDesconto) {
		if(rdbtnCartao.isSelected() || rdbtnPix.isSelected()) {
			rdbtnCartao.setSelected(false);
			rdbtnPix.setSelected(false);
			chckbxDesconto.setEnabled(true);
		}
		else
			rdbtnDinheiro.setSelected(true);
		
	}
	
	public void marcarPix(JRadioButton rdbtnPix, JRadioButton rdbtnDinheiro, JRadioButton rdbtnCartao, JCheckBox chckbxDesconto) {
		if(rdbtnCartao.isSelected() || rdbtnDinheiro.isSelected()) {
			rdbtnCartao.setSelected(false);
			rdbtnDinheiro.setSelected(false);
			chckbxDesconto.setEnabled(true);
		}
		else
			rdbtnPix.setSelected(true);
		
	}
	
	public void marcarDesconto(JTable table, JCheckBox chckbxDesconto, JSpinner spinner, float total, JTextField textTotalVenda, JTextField textTotalVendaDesconto) {
		if(table.getRowCount() != 0) {
			if(chckbxDesconto.isSelected()) {
						textTotalVendaDesconto.setText(String.valueOf((float) (total - (total/100)*(int)spinner.getValue())));
					
						
					
			}else {

				textTotalVendaDesconto.setText(String.valueOf(total));
				
			}
		}
	}
	
	
	public void criarVenda() {
		VendaDAO vendaDAO = new VendaDAO();
		vendaDAO.criarVenda();
	}
	
	public void finalizarVenda(JTable table, JTextField textTotalVenda,JTextField textTotalVendaDesconto , JRadioButton rdbtnPix, 
			JRadioButton rdbtnDinheiro, JRadioButton rdbtnCartao, JCheckBox chckbxDesconto, JSpinner spinner, LocalDate localDate) {
		
		if(table.getRowCount() > 0) {
		VendaDAO vendaDAO = new VendaDAO();
		EstoqueDAO estoqueDAO = new EstoqueDAO();
		String codProdutos = "";
		String descricao = "";
		Float valor = Float.valueOf(textTotalVenda.getText().replaceAll(",", "."));
		String formaDePagamento = "";
		Boolean desconto = null;
		int valordesconto = (int) spinner.getValue();	
		
		if(rdbtnPix.isSelected())
			formaDePagamento = "PIX";
		else if(rdbtnDinheiro.isSelected())
			formaDePagamento = "DINHEIRO";
		else if (rdbtnCartao.isSelected())
			formaDePagamento = "CARTÃO";
		
		if(chckbxDesconto.isSelected())
			desconto = true;
		else
			desconto = false;
		
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
		LocalDateTime horas = LocalDateTime.now();

		String codVenda = "" + vendaDAO.buscarUltimaVenda();
		
		String cupom = "MARTECELL "
				+ "\n"
				+ "\nR. FRANCA - JARDIM CAICARA Nº419\n"
				+ "\nTELEFONE:(22)99989-6873"
				+ "\nCNPJ: "
				+ "\n--------------------------------"
				+ "\n "+localDate+" "+dtf.format(horas)+" "+codVenda+""
				+ "\n--------------------------------"
				+ "\nITEM|CODIGO|DESCR.|VL UN.|VL TO.";
				
		

		for(int i = 0; i < table.getRowCount(); i++) {

			codProdutos += ";" + table.getValueAt(i, 0).toString();
			descricao += estoqueDAO.buscar(table.getValueAt(i, 0).toString()).getNome() + " - ";
			String codItem = table.getValueAt(i, 0).toString();
			Produto produto = buscar(codItem);
			float valorProduto = 0;
			if(produto.getCod().equals("0000"))
				valorProduto = (Float) table.getValueAt(i, 2);
			else
				valorProduto = produto.getValor()-(produto.getValor()/100)*valordesconto;
			
			cupom += "\n"+(i+1)+" "+produto.getCod()+" "+produto.getNome()+" "+produto.getValor()+" "+produto.getValor()+"";
			
			vendaDAO.novaVenda(produto.getCod(), codVenda, produto.getNome(), localDate, dtf.format(horas), valorProduto, produto.getValorComprado(), formaDePagamento, desconto);
			
		}
		
		//vendaDAO.novaVenda(codProdutos, descricao, LocalDate.now(), dtf.format(horas), valor, formaDePagamento, desconto);
		
		cupom +=  "\nTOTAL..................."+textTotalVenda.getText()+""
				+ "\nTOTAL COM DESCONTO......"+textTotalVendaDesconto.getText()+""
				+ "\nFORMA DE PAGAMENTO......"+formaDePagamento+""
				+ "\n--------------------------------"
				+ "\n";
		
		
		String[] itens = codProdutos.split(";");
		
		for(int i = 0; i < itens.length; i++) {
			if(itens[i] != null) {
				if(!itens[i].equals("0000"))
				estoqueDAO.vendaNoEstoque(itens[i]);
			}
		}
		view.dispose();
		Venda.main(null);
		JOptionPane.showMessageDialog(null,"Venda Finalizada.","Venda finalizada com sucesso!",JOptionPane.INFORMATION_MESSAGE);

		
		Impressao i = new Impressao();
		
		i.imprime(cupom);
	
		
		}	else {
			JOptionPane.showMessageDialog(null,"Adicione algum item antes de finalizar a venda.","Nenhum Item Selecionado",JOptionPane.INFORMATION_MESSAGE);
			
		}
		}
	
	public void buscarCod() {
		view.buscaCod();
	}
	
	public void voltar(Login usuarioLogado) {
		view.dispose();
		Menu.setUsuarioLogado(usuarioLogado);
		Menu.main(null);
	}
	
	public void abrirPelicula(Login usuarioLogado) {
		view.dispose();
		Pelicula.setUsuarioLogado(usuarioLogado);
		Pelicula.main(null);
	}
	
	public void abrirBusca() {
		BuscarProduto.main(null, view);
	}
	
	public void novoServico() {
		NovoServico.main(null, view);
	}
	
	public void inserirCod(String cod) {
		view.getTextCodigo().setText(cod);
	}
	
}
