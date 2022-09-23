package View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Configuracao.DecimalField;
import Configuracao.JtextLetras;
import Configuracao.JtextNum;
import Control.ControlEstoqueEditar;
import model.Login;

@SuppressWarnings("serial")
public class EstoqueEditar extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textNome;
	private JTextField textQuantidade;
	private JFormattedTextField textValor;
	private JTextField textCod;
	private JFormattedTextField textValorComprado;
	private static Login usuarioLogado = null;

	public JFormattedTextField getTextValorComprado() {
		return textValorComprado;
	}

	public void setTextValorComprado(JFormattedTextField textValorComprado) {
		this.textValorComprado = textValorComprado;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			EstoqueEditar dialog = new EstoqueEditar();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public EstoqueEditar() {
		setModal(true);
		ControlEstoqueEditar controlEstoqueEditar = new ControlEstoqueEditar(this);
		
		setBounds(100, 100, 500, 300);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(80, 10, 80, 10));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(2, 0, 10, 0));
		
		
		{
			JLabel lblCod = new JLabel("Cod");
			lblCod.setVerticalAlignment(SwingConstants.BOTTOM);
			contentPanel.add(lblCod);
		}
		{
			JLabel lblNome = new JLabel("Nome");
			lblNome.setVerticalAlignment(SwingConstants.BOTTOM);
			contentPanel.add(lblNome);
		}
		{
			JLabel lblQuantidade = new JLabel("Quantidade");
			lblQuantidade.setVerticalAlignment(SwingConstants.BOTTOM);
			contentPanel.add(lblQuantidade);
		}
		{
			JLabel lblValor = new JLabel("Valor");
			lblValor.setVerticalAlignment(SwingConstants.BOTTOM);
			contentPanel.add(lblValor);
		}
		{
			if(usuarioLogado.getRole().equals("ADMIN")) {
			JLabel lblValorComprado = new JLabel("Valor Comprado");
			contentPanel.add(lblValorComprado);
			}
		}
		{
			textCod = new JtextNum(4);
			textCod.setToolTipText("");
			textCod.setEditable(false);
			contentPanel.add(textCod);
			textCod.setColumns(10);
		}
		{
			textNome =  new JtextLetras(35);
			contentPanel.add(textNome);
			textNome.setColumns(10);
		}
		{
			textQuantidade =  new JtextNum(4);
			contentPanel.add(textQuantidade);
			textQuantidade.setColumns(10);
		}
		{
			textValor = new DecimalField("#,##0.00");
			contentPanel.add(textValor);
			textValor.setColumns(10);
		}
		{
			textValorComprado = new DecimalField("#,##0.00");
			if(usuarioLogado.getRole().equals("ADMIN")) {
			contentPanel.add(textValorComprado);
			}
			textValorComprado.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Salvar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							String textFloat = textValor.getText().replace(".", "").replace(",", ".");
							String textFloat2 = textValorComprado.getText().replace(".", "").replace(",", ".");
							controlEstoqueEditar.editar(textCod.getText(), textNome.getText(),
									Integer.valueOf(textQuantidade.getText()), Float.valueOf(textFloat), Float.valueOf(textFloat2), 
									textCod, textNome, textQuantidade, textValor, textValorComprado);
							dispose();
						}catch(Exception ee) {
							JOptionPane.showInternalMessageDialog(null, "preencha todos os campos!");
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
			{
				if(!usuarioLogado.getRole().equals("ADMIN")) {
					textNome.setEditable(false);
					textValor.setEditable(false);
				}
			}
		}
	}

	public static Login getUsuarioLogado() {
		return usuarioLogado;
	}

	public static void setUsuarioLogado(Login usuarioLogado) {
		EstoqueEditar.usuarioLogado = usuarioLogado;
	}

	public JTextField getTextNome() {
		return textNome;
	}

	public void setTextNome(JTextField textNome) {
		this.textNome = textNome;
	}

	public JTextField getTextQuantidade() {
		return textQuantidade;
	}

	public void setTextQuantidade(JTextField textQuantidade) {
		this.textQuantidade = textQuantidade;
	}

	public JFormattedTextField getTextValor() {
		return textValor;
	}

	public void setTextValor(JFormattedTextField textValor) {
		this.textValor = textValor;
	}

	public JTextField getTextCod() {
		return textCod;
	}

	public void setTextCod(JTextField textCod) {
		this.textCod = textCod;
	}

}