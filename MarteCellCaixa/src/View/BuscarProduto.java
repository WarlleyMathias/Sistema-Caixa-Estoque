package View;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.GridLayout;

import Configuracao.ProdutoTableNome;
import Control.ControlBuscarProduto;

import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BuscarProduto extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private JTextField textBuscar;
	private ControlBuscarProduto controlBuscarProduto;
	private ProdutoTableNome ptModel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args, Venda view2) {
		try {
			BuscarProduto dialog = new BuscarProduto(view2);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public BuscarProduto(Venda view2) {
		controlBuscarProduto = new ControlBuscarProduto(this);
		
		ptModel = new ProdutoTableNome();
		
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(0, 1, 0, 0));
		{
			JScrollPane scrollPane = new JScrollPane();
			contentPanel.add(scrollPane);
			{
				table = new JTable();
				table.setModel(ptModel);
				
				scrollPane.setViewportView(table);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			GridBagLayout gbl_buttonPane = new GridBagLayout();
			gbl_buttonPane.columnWidths = new int[]{316, 47, 0, 65, 0};
			gbl_buttonPane.rowHeights = new int[]{23, 0};
			gbl_buttonPane.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			gbl_buttonPane.rowWeights = new double[]{0.0, Double.MIN_VALUE};
			buttonPane.setLayout(gbl_buttonPane);
			{
				textBuscar = new JTextField();
				GridBagConstraints gbc_textBuscar = new GridBagConstraints();
				gbc_textBuscar.fill = GridBagConstraints.BOTH;
				gbc_textBuscar.anchor = GridBagConstraints.WEST;
				gbc_textBuscar.insets = new Insets(0, 0, 0, 5);
				gbc_textBuscar.gridx = 0;
				gbc_textBuscar.gridy = 0;
				buttonPane.add(textBuscar, gbc_textBuscar);
				textBuscar.setColumns(10);
			}
			{
				JButton okButton = new JButton("Buscar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						controlBuscarProduto.buscarProdutosEstoque(textBuscar, ptModel, table);
					}
				});
				okButton.setActionCommand("OK");
				GridBagConstraints gbc_okButton = new GridBagConstraints();
				gbc_okButton.anchor = GridBagConstraints.NORTHWEST;
				gbc_okButton.insets = new Insets(0, 0, 0, 5);
				gbc_okButton.gridx = 1;
				gbc_okButton.gridy = 0;
				buttonPane.add(okButton, gbc_okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				{
					JButton btnNewButton = new JButton("Confirmar");
					btnNewButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							controlBuscarProduto.getProduto(view2, table);
						}
					});
					GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
					gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
					gbc_btnNewButton.gridx = 2;
					gbc_btnNewButton.gridy = 0;
					buttonPane.add(btnNewButton, gbc_btnNewButton);
				}
				cancelButton.setActionCommand("Cancel");
				GridBagConstraints gbc_cancelButton = new GridBagConstraints();
				gbc_cancelButton.anchor = GridBagConstraints.NORTHWEST;
				gbc_cancelButton.gridx = 3;
				gbc_cancelButton.gridy = 0;
				buttonPane.add(cancelButton, gbc_cancelButton);
			}
		}
	}

}
