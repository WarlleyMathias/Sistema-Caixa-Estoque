package View;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Control.ControlMenu;

import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import model.Login;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;

public class Menu extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static Login usuarioLogado = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	public Menu() {
		setBackground(Color.BLACK);
		
		ControlMenu controlMenu = new ControlMenu(this);
		
		
		Toolkit tk = Toolkit.getDefaultToolkit();
	    Dimension d = tk.getScreenSize();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, d.width, d.height);
		this.setExtendedState(MAXIMIZED_BOTH);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1364, 285);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(Color.BLACK);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(Menu.class.getResource("/Imagens/MarteCell.png")));
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setBackground(Color.BLACK);
		lblLogo.setAlignmentX(0.5f);
		panel.add(lblLogo);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 434, 1340, 295);
		contentPane.add(panel_1);
		
		ImageIcon img = new ImageIcon (Menu.class.getResource("/Imagens/venda.png"));
		img.setImage(img.getImage().getScaledInstance(50, 50, 100));
		GridBagConstraints gbc_btnVenda = new GridBagConstraints();
		gbc_btnVenda.fill = GridBagConstraints.BOTH;
		gbc_btnVenda.insets = new Insets(0, 0, 5, 5);
		gbc_btnVenda.gridx = 0;
		gbc_btnVenda.gridy = 1;
		ImageIcon img2 = new ImageIcon (Menu.class.getResource("/Imagens/estoque.png"));
		img2.setImage(img2.getImage().getScaledInstance(50, 50, 100));
		GridBagConstraints gbc_btnEstoque = new GridBagConstraints();
		gbc_btnEstoque.insets = new Insets(0, 0, 5, 0);
		gbc_btnEstoque.fill = GridBagConstraints.BOTH;
		gbc_btnEstoque.gridx = 1;
		gbc_btnEstoque.gridy = 1;
		

		JButton btnVenda = new JButton("Venda");
		btnVenda.setIcon(img);
		btnVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlMenu.abrirVenda(usuarioLogado);
			}
		});
		panel_1.setLayout(new GridLayout(0, 4, 0, 0));
		panel_1.add(btnVenda);
		
		JButton btnEstoque = new JButton("Estoque");
		btnEstoque.setIcon(img2);
		btnEstoque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlMenu.abrirEstoque(usuarioLogado);
			}
		});
		panel_1.add(btnEstoque);
		
		if(usuarioLogado.getRole().equals("ADMIN")) {
		JButton btnRelatorio = new JButton("Relat\u00F3rio");
		ImageIcon img4 = new ImageIcon (Menu.class.getResource("/Imagens/relatorio.png"));
		img4.setImage(img4.getImage().getScaledInstance(50, 50, 100));
		btnRelatorio.setIcon(img4);
		btnRelatorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlMenu.abrirRelatorio(usuarioLogado);
			}
		});
		panel_1.add(btnRelatorio);
		}
		
		if(usuarioLogado.getRole().equals("ADMIN")) {
		JButton btnCadastrarVendedor = new JButton("Cadastrar Vendedor");
		ImageIcon img3 = new ImageIcon (Menu.class.getResource("/Imagens/perfil.png"));
		img3.setImage(img3.getImage().getScaledInstance(50, 50, 100));
		btnCadastrarVendedor.setIcon(img3);
		btnCadastrarVendedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlMenu.cadastrarVendedor();
			}
		});
		panel_1.add(btnCadastrarVendedor);
		}
	}

	public static Login getUsuarioLogado() {
		return usuarioLogado;
	}

	public static void setUsuarioLogado(Login usuarioLogado) {
		Menu.usuarioLogado = usuarioLogado;
	}

}
