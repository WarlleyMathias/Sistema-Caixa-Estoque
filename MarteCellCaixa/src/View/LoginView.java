package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Control.ControlLogin;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

@SuppressWarnings("serial")
public class LoginView extends JFrame {

	private JPanel contentPane;
	private JTextField textLogin;
	private JPasswordField textSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView frame = new LoginView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginView() {
		
		ControlLogin controlLogin = new ControlLogin(this);
		
		controlLogin.criarTabelaLogin();
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 350);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(30, 50, 30, 50));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(6, 0, 0, 15));
		
		JLabel lblTitulo = new JLabel("MARTE CELL");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setForeground(new Color(255, 69, 0));
		contentPane.add(lblTitulo);
		
		JLabel lblLogin = new JLabel("LOGIN:\r\n");
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setVerticalAlignment(SwingConstants.BOTTOM);
		lblLogin.setForeground(new Color(255, 255, 255));
		contentPane.add(lblLogin);
		
		textLogin = new JTextField();
		contentPane.add(textLogin);
		textLogin.setColumns(10);
		
		JLabel lblSenha = new JLabel("SENHA:");
		lblSenha.setHorizontalAlignment(SwingConstants.CENTER);
		lblSenha.setVerticalAlignment(SwingConstants.BOTTOM);
		lblSenha.setForeground(new Color(255, 255, 255));
		contentPane.add(lblSenha);
		
		JButton btnEntrar = new JButton("ENTRAR");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlLogin.entrar(textLogin, textSenha);
				
			}
		});
		
		textSenha = new JPasswordField();
		contentPane.add(textSenha);
		btnEntrar.setBackground(new Color(255, 69, 0));
		btnEntrar.setForeground(new Color(255, 255, 255));
		contentPane.add(btnEntrar);
	}
}
