package View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Control.ControlEstoqueAdicionar;
import Configuracao.DecimalField;
import Configuracao.JtextLetras;
import Configuracao.JtextNum;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class EstoqueAdicionar extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textNome;
	private JTextField textQuantidade;
	private JFormattedTextField textValor;
	private JTextField textCod;
	private JFormattedTextField textValorComprado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			EstoqueAdicionar dialog = new EstoqueAdicionar();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public EstoqueAdicionar() {
		setModal(true);
		ControlEstoqueAdicionar controlEstoqueAdicionar = new ControlEstoqueAdicionar(this);
		
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
			JLabel lblValorComprado = new JLabel("Valor Comprado");
			contentPanel.add(lblValorComprado);
		}
		{
			textCod = new JtextNum(4);
			textCod.setToolTipText("");
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
			contentPanel.add(textValorComprado);
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
							controlEstoqueAdicionar.adicionar(textCod, textNome, textQuantidade, textValor, textValorComprado);
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
		}
	}

}
