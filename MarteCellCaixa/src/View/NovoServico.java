	package View;

	import java.awt.BorderLayout;
	import javax.swing.JButton;
	import javax.swing.JDialog;
	import javax.swing.JPanel;
	import javax.swing.border.EmptyBorder;

	import java.awt.GridLayout;

	import javax.swing.JTextField;
	import java.awt.GridBagLayout;
	import java.awt.GridBagConstraints;
	import java.awt.Insets;
	import java.awt.event.ActionListener;
	import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

	public class NovoServico extends JDialog {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private final JPanel contentPanel = new JPanel();
		private JTextField textBuscar;
		private JTextField textField;
		private JTextField textField_1;
		private JTextField textCliente;
		private JTextField textModelo;

		/**
		 * Launch the application.
		 */
		public static void main(String[] args, Venda view2) {
			try {
				NovoServico dialog = new NovoServico(view2);
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		/**
		 * Create the dialog.
		 */
		public NovoServico(Venda view2) {
			
			setBounds(100, 100, 450, 300);
			setLocationRelativeTo(null);
			getContentPane().setLayout(new BorderLayout());
			contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
			getContentPane().add(contentPanel, BorderLayout.CENTER);
			contentPanel.setLayout(new GridLayout(8, 10, 0, 0));
			{
				JCheckBox chckbxConector = new JCheckBox("CONECTOR DE CARGA");
				contentPanel.add(chckbxConector);
			}
			{
				JCheckBox chckbxNewCheckBox_1 = new JCheckBox("BATERIA");
				contentPanel.add(chckbxNewCheckBox_1);
			}
			{
				JCheckBox chckbxBotoes = new JCheckBox("BOT\u00D5ES");
				contentPanel.add(chckbxBotoes);
			}
			{
				JCheckBox chckbxNewCheckBox_5 = new JCheckBox("CAMERA");
				contentPanel.add(chckbxNewCheckBox_5);
			}
			{
				JCheckBox chckbxMicrofone = new JCheckBox("MICROFONE");
				contentPanel.add(chckbxMicrofone);
			}
			{
				JCheckBox chckbxNewCheckBox_6 = new JCheckBox("TAMPA TRASEIRA");
				contentPanel.add(chckbxNewCheckBox_6);
			}
			{
				JCheckBox chckbxNewCheckBox_7 = new JCheckBox("AUTO-FALANTE");
				contentPanel.add(chckbxNewCheckBox_7);
			}
			{
				JCheckBox chckbxNewCheckBox_8 = new JCheckBox("BANHO QU\u00CDMICO");
				contentPanel.add(chckbxNewCheckBox_8);
			}
			{
				JCheckBox chckbxNewCheckBox = new JCheckBox("FRONTAL");
				contentPanel.add(chckbxNewCheckBox);
			}
			{
				JCheckBox chckbxNewCheckBox_9 = new JCheckBox("OUTROS");
				contentPanel.add(chckbxNewCheckBox_9);
			}
			this.setModal(true);
			{
				JPanel panel = new JPanel();
				getContentPane().add(panel, BorderLayout.NORTH);
				GridBagLayout gbl_panel = new GridBagLayout();
				gbl_panel.columnWidths = new int[]{118, 0, 0};
				gbl_panel.rowHeights = new int[]{0, 0, 0};
				gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
				gbl_panel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
				panel.setLayout(gbl_panel);
				{
					JLabel lblCliente = new JLabel("CLIENTE:");
					GridBagConstraints gbc_lblCliente = new GridBagConstraints();
					gbc_lblCliente.insets = new Insets(0, 0, 5, 5);
					gbc_lblCliente.gridx = 0;
					gbc_lblCliente.gridy = 0;
					panel.add(lblCliente, gbc_lblCliente);
				}
				{
					textCliente = new JTextField();
					GridBagConstraints gbc_textCliente = new GridBagConstraints();
					gbc_textCliente.insets = new Insets(0, 0, 5, 0);
					gbc_textCliente.fill = GridBagConstraints.HORIZONTAL;
					gbc_textCliente.gridx = 1;
					gbc_textCliente.gridy = 0;
					panel.add(textCliente, gbc_textCliente);
					textCliente.setColumns(10);
				}
				{
					JLabel lblModelo = new JLabel("MODELO / DETALHE :");
					GridBagConstraints gbc_lblModelo = new GridBagConstraints();
					gbc_lblModelo.anchor = GridBagConstraints.EAST;
					gbc_lblModelo.insets = new Insets(0, 0, 0, 5);
					gbc_lblModelo.gridx = 0;
					gbc_lblModelo.gridy = 1;
					panel.add(lblModelo, gbc_lblModelo);
				}
				{
					textModelo = new JTextField();
					GridBagConstraints gbc_textModelo = new GridBagConstraints();
					gbc_textModelo.fill = GridBagConstraints.HORIZONTAL;
					gbc_textModelo.gridx = 1;
					gbc_textModelo.gridy = 1;
					panel.add(textModelo, gbc_textModelo);
					textModelo.setColumns(10);
				}
			}
			{
				JPanel buttonPane = new JPanel();
				buttonPane.setBorder(new EmptyBorder(5, 5, 5, 5));
				getContentPane().add(buttonPane, BorderLayout.SOUTH);
				GridBagLayout gbl_buttonPane = new GridBagLayout();
				gbl_buttonPane.columnWidths = new int[]{140, 47, 0, 65, 0};
				gbl_buttonPane.rowHeights = new int[]{0, 0, 23, 0};
				gbl_buttonPane.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
				gbl_buttonPane.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
				buttonPane.setLayout(gbl_buttonPane);
				{
					JLabel lblNewLabel = new JLabel("VALOR INVESTIDO:");
					GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
					gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
					gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
					gbc_lblNewLabel.gridx = 0;
					gbc_lblNewLabel.gridy = 0;
					buttonPane.add(lblNewLabel, gbc_lblNewLabel);
				}
				{
					textField = new JTextField();
					GridBagConstraints gbc_textField = new GridBagConstraints();
					gbc_textField.anchor = GridBagConstraints.WEST;
					gbc_textField.insets = new Insets(0, 0, 5, 5);
					gbc_textField.fill = GridBagConstraints.BOTH;
					gbc_textField.gridx = 1;
					gbc_textField.gridy = 0;
					buttonPane.add(textField, gbc_textField);
					textField.setColumns(10);
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
							}
						});
						{
							JLabel lblNewLabel_2 = new JLabel("SINAL:");
							GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
							gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
							gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
							gbc_lblNewLabel_2.gridx = 0;
							gbc_lblNewLabel_2.gridy = 1;
							buttonPane.add(lblNewLabel_2, gbc_lblNewLabel_2);
						}
						{
							textField_1 = new JTextField();
							textField_1.setColumns(10);
							GridBagConstraints gbc_textField_1 = new GridBagConstraints();
							gbc_textField_1.insets = new Insets(0, 0, 5, 5);
							gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
							gbc_textField_1.gridx = 1;
							gbc_textField_1.gridy = 1;
							buttonPane.add(textField_1, gbc_textField_1);
						}
						{
							JLabel lblNewLabel_1 = new JLabel("VALOR DO SERVI\u00C7O:");
							GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
							gbc_lblNewLabel_1.insets = new Insets(0, 0, 0, 5);
							gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
							gbc_lblNewLabel_1.gridx = 0;
							gbc_lblNewLabel_1.gridy = 2;
							buttonPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
						}
						{
							textBuscar = new JTextField();
							GridBagConstraints gbc_textBuscar = new GridBagConstraints();
							gbc_textBuscar.fill = GridBagConstraints.BOTH;
							gbc_textBuscar.anchor = GridBagConstraints.WEST;
							gbc_textBuscar.insets = new Insets(0, 0, 0, 5);
							gbc_textBuscar.gridx = 1;
							gbc_textBuscar.gridy = 2;
							buttonPane.add(textBuscar, gbc_textBuscar);
							textBuscar.setColumns(10);
						}
						GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
						gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
						gbc_btnNewButton.gridx = 2;
						gbc_btnNewButton.gridy = 2;
						buttonPane.add(btnNewButton, gbc_btnNewButton);
					}
					cancelButton.setActionCommand("Cancel");
					GridBagConstraints gbc_cancelButton = new GridBagConstraints();
					gbc_cancelButton.anchor = GridBagConstraints.NORTHWEST;
					gbc_cancelButton.gridx = 3;
					gbc_cancelButton.gridy = 2;
					buttonPane.add(cancelButton, gbc_cancelButton);
				}
			}
		

	}


}
