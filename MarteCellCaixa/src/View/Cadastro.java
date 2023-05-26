package View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Control.ControlCadastro;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.ImageIcon;

public class Cadastro extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textLogin;
	private JPasswordField textSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Cadastro dialog = new Cadastro();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Cadastro() {
		
		ControlCadastro controlCadastro = new ControlCadastro(this);
		
		
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(40, 40, 40, 40));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{172, 172, 0};
		gbl_contentPanel.rowHeights = new int[]{-68, 40, 26, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblNewLabel = new JLabel("");
			ImageIcon img = new ImageIcon(Cadastro.class.getResource("/Imagens/perfil.png"));
			img.setImage(img.getImage().getScaledInstance(80, 80, 100));
			lblNewLabel.setIcon(img);
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.anchor = GridBagConstraints.LINE_START;
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel.gridx = 0;
			gbc_lblNewLabel.gridy = 0;
			contentPanel.add(lblNewLabel, gbc_lblNewLabel);
		}
		{
			JLabel lblLogin = new JLabel("Login:");
			lblLogin.setVerticalAlignment(SwingConstants.BOTTOM);
			GridBagConstraints gbc_lblLogin = new GridBagConstraints();
			gbc_lblLogin.fill = GridBagConstraints.BOTH;
			gbc_lblLogin.insets = new Insets(0, 0, 5, 5);
			gbc_lblLogin.gridx = 0;
			gbc_lblLogin.gridy = 1;
			contentPanel.add(lblLogin, gbc_lblLogin);
		}
		{
			JLabel lblSenha = new JLabel("Senha:");
			lblSenha.setVerticalAlignment(SwingConstants.BOTTOM);
			GridBagConstraints gbc_lblSenha = new GridBagConstraints();
			gbc_lblSenha.fill = GridBagConstraints.BOTH;
			gbc_lblSenha.insets = new Insets(0, 0, 5, 0);
			gbc_lblSenha.gridx = 1;
			gbc_lblSenha.gridy = 1;
			contentPanel.add(lblSenha, gbc_lblSenha);
		}
		{
			textLogin = new JTextField();
			GridBagConstraints gbc_textLogin = new GridBagConstraints();
			gbc_textLogin.fill = GridBagConstraints.BOTH;
			gbc_textLogin.insets = new Insets(0, 0, 0, 5);
			gbc_textLogin.gridx = 0;
			gbc_textLogin.gridy = 2;
			contentPanel.add(textLogin, gbc_textLogin);
			textLogin.setColumns(10);
		}
		{
			textSenha = new JPasswordField();
			GridBagConstraints gbc_textSenha = new GridBagConstraints();
			gbc_textSenha.fill = GridBagConstraints.BOTH;
			gbc_textSenha.gridx = 1;
			gbc_textSenha.gridy = 2;
			contentPanel.add(textSenha, gbc_textSenha);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnSalvar = new JButton("Salvar");
				btnSalvar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						controlCadastro.cadastrarFuncionario(textLogin, textSenha);
					}
				});
				btnSalvar.setActionCommand("OK");
				buttonPane.add(btnSalvar);
				getRootPane().setDefaultButton(btnSalvar);
			}
			{
				JButton cancelButton = new JButton("Cancel");
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
