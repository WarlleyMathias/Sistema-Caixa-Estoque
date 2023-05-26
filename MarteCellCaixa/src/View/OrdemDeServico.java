package View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JCheckBox;

public class OrdemDeServico extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JCheckBox chckbxNewCheckBox_1;
	private JCheckBox chckbxNewCheckBox_2;
	private JCheckBox chckbxNewCheckBox_3;
	private JCheckBox chckbxNewCheckBox_4;
	private JCheckBox chckbxNewCheckBox_5;
	private JCheckBox chckbxNewCheckBox_6;
	private JCheckBox chckbxNewCheckBox_7;
	private JCheckBox chckbxNewCheckBox_8;
	private JCheckBox chckbxNewCheckBox_9;
	private JCheckBox chckbxNewCheckBox_10;
	private JCheckBox chckbxNewCheckBox_11;
	private JCheckBox chckbxNewCheckBox_12;
	private JCheckBox chckbxNewCheckBox_13;
	private JCheckBox chckbxNewCheckBox_14;
	private JCheckBox chckbxNewCheckBox_15;
	private JCheckBox chckbxNewCheckBox_16;
	private JCheckBox chckbxNewCheckBox_17;
	private JCheckBox chckbxNewCheckBox_18;
	private JCheckBox chckbxNewCheckBox_19;
	private JCheckBox chckbxNewCheckBox_20;
	private JCheckBox chckbxNewCheckBox_21;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			OrdemDeServico dialog = new OrdemDeServico();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public OrdemDeServico() {
		setBounds(100, 100, 450, 800);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(63, 84, 336, 15);
		contentPanel.add(textField);
		textField.setColumns(10);
		{
			textField_1 = new JTextField();
			textField_1.setBounds(90, 103, 309, 15);
			contentPanel.add(textField_1);
			textField_1.setColumns(10);
		}
		{
			textField_2 = new JTextField();
			textField_2.setColumns(10);
			textField_2.setBounds(90, 121, 309, 15);
			contentPanel.add(textField_2);
		}
		{
			textField_3 = new JTextField();
			textField_3.setColumns(10);
			textField_3.setBounds(108, 160, 224, 10);
			contentPanel.add(textField_3);
		}
		{
			textField_4 = new JTextField();
			textField_4.setColumns(10);
			textField_4.setBounds(108, 175, 224, 10);
			contentPanel.add(textField_4);
		}
		{
			textField_5 = new JTextField();
			textField_5.setColumns(10);
			textField_5.setBounds(10, 313, 399, 15);
			contentPanel.add(textField_5);
		}
		{
			textField_6 = new JTextField();
			textField_6.setColumns(10);
			textField_6.setBounds(328, 59, 67, 15);
			contentPanel.add(textField_6);
		}
		{
			textField_7 = new JTextField();
			textField_7.setColumns(10);
			textField_7.setBounds(342, 33, 68, 15);
			contentPanel.add(textField_7);
		}
		{
			textField_8 = new JTextField();
			textField_8.setColumns(10);
			textField_8.setBounds(48, 415, 321, 15);
			contentPanel.add(textField_8);
		}
		{
			textField_9 = new JTextField();
			textField_9.setColumns(10);
			textField_9.setBounds(40, 436, 59, 10);
			contentPanel.add(textField_9);
		}
		{
			textField_10 = new JTextField();
			textField_10.setColumns(10);
			textField_10.setBounds(174, 436, 131, 10);
			contentPanel.add(textField_10);
		}
		{
			textField_11 = new JTextField();
			textField_11.setColumns(10);
			textField_11.setBounds(368, 431, 41, 15);
			contentPanel.add(textField_11);
		}
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("");
		chckbxNewCheckBox.setBounds(180, 191, 19, 14);
		contentPanel.add(chckbxNewCheckBox);
		{
			chckbxNewCheckBox_1 = new JCheckBox("");
			chckbxNewCheckBox_1.setBounds(144, 191, 19, 14);
			contentPanel.add(chckbxNewCheckBox_1);
		}
		{
			chckbxNewCheckBox_2 = new JCheckBox("");
			chckbxNewCheckBox_2.setBounds(174, 208, 19, 14);
			contentPanel.add(chckbxNewCheckBox_2);
		}
		{
			chckbxNewCheckBox_3 = new JCheckBox("");
			chckbxNewCheckBox_3.setBounds(211, 209, 19, 14);
			contentPanel.add(chckbxNewCheckBox_3);
		}
		{
			chckbxNewCheckBox_4 = new JCheckBox("");
			chckbxNewCheckBox_4.setBounds(316, 208, 19, 14);
			contentPanel.add(chckbxNewCheckBox_4);
		}
		{
			chckbxNewCheckBox_5 = new JCheckBox("");
			chckbxNewCheckBox_5.setBounds(355, 208, 19, 14);
			contentPanel.add(chckbxNewCheckBox_5);
		}
		{
			chckbxNewCheckBox_6 = new JCheckBox("");
			chckbxNewCheckBox_6.setBounds(155, 226, 19, 14);
			contentPanel.add(chckbxNewCheckBox_6);
		}
		{
			chckbxNewCheckBox_7 = new JCheckBox("");
			chckbxNewCheckBox_7.setBounds(191, 226, 19, 14);
			contentPanel.add(chckbxNewCheckBox_7);
		}
		{
			chckbxNewCheckBox_8 = new JCheckBox("");
			chckbxNewCheckBox_8.setBounds(305, 226, 19, 14);
			contentPanel.add(chckbxNewCheckBox_8);
		}
		{
			chckbxNewCheckBox_9 = new JCheckBox("");
			chckbxNewCheckBox_9.setBounds(343, 226, 19, 14);
			contentPanel.add(chckbxNewCheckBox_9);
		}
		{
			chckbxNewCheckBox_10 = new JCheckBox("");
			chckbxNewCheckBox_10.setBounds(111, 244, 19, 14);
			contentPanel.add(chckbxNewCheckBox_10);
		}
		{
			chckbxNewCheckBox_11 = new JCheckBox("");
			chckbxNewCheckBox_11.setBounds(147, 243, 19, 14);
			contentPanel.add(chckbxNewCheckBox_11);
		}
		{
			chckbxNewCheckBox_12 = new JCheckBox("");
			chckbxNewCheckBox_12.setBounds(233, 243, 19, 14);
			contentPanel.add(chckbxNewCheckBox_12);
		}
		{
			chckbxNewCheckBox_13 = new JCheckBox("");
			chckbxNewCheckBox_13.setBounds(270, 243, 19, 14);
			contentPanel.add(chckbxNewCheckBox_13);
		}
		{
			chckbxNewCheckBox_14 = new JCheckBox("");
			chckbxNewCheckBox_14.setBounds(101, 260, 19, 14);
			contentPanel.add(chckbxNewCheckBox_14);
		}
		{
			chckbxNewCheckBox_15 = new JCheckBox("");
			chckbxNewCheckBox_15.setBounds(139, 261, 19, 14);
			contentPanel.add(chckbxNewCheckBox_15);
		}
		{
			chckbxNewCheckBox_16 = new JCheckBox("");
			chckbxNewCheckBox_16.setBounds(309, 260, 19, 14);
			contentPanel.add(chckbxNewCheckBox_16);
		}
		{
			chckbxNewCheckBox_17 = new JCheckBox("");
			chckbxNewCheckBox_17.setBounds(346, 260, 19, 14);
			contentPanel.add(chckbxNewCheckBox_17);
		}
		{
			chckbxNewCheckBox_18 = new JCheckBox("");
			chckbxNewCheckBox_18.setBounds(100, 279, 19, 14);
			contentPanel.add(chckbxNewCheckBox_18);
		}
		{
			chckbxNewCheckBox_19 = new JCheckBox("");
			chckbxNewCheckBox_19.setBounds(137, 279, 19, 14);
			contentPanel.add(chckbxNewCheckBox_19);
		}
		{
			chckbxNewCheckBox_20 = new JCheckBox("");
			chckbxNewCheckBox_20.setBounds(276, 278, 19, 14);
			contentPanel.add(chckbxNewCheckBox_20);
		}
		{
			chckbxNewCheckBox_21 = new JCheckBox("");
			chckbxNewCheckBox_21.setBounds(313, 278, 19, 14);
			contentPanel.add(chckbxNewCheckBox_21);
		}
		{
			JLabel lblOS = new JLabel("");
			lblOS.setIcon(new ImageIcon(OrdemDeServico.class.getResource("/Imagens/OS.png")));
			lblOS.setBounds(0, 0, 420, 644);
			contentPanel.add(lblOS);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
