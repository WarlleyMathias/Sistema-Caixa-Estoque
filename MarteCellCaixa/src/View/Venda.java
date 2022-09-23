package View;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Configuracao.JtextNum;
import Configuracao.ProdutoTableVenda;
import Control.ControlVenda;
import model.Login;

import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.JCheckBox;
import javax.swing.SpinnerNumberModel;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

@SuppressWarnings("serial")
public class Venda extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JtextNum textCodigo;
	private JLabel lblCodigo;
	private JLabel lblQuantidade;
	private JLabel lblTotal;
	private JTextField textTotal;
	private JTable table;
	private JPanel panel_1;
	private JLabel lblTotalVenda;
	private JTextField textTotalVenda;
	private ProdutoTableVenda ptModel;
	private JButton btnAdicionar;
	private JButton btnFinalizarVenda;
	private JPanel panel_2;
	private JLabel lblFormaPgt;
	private JCheckBox chckbxDesconto;
	private JButton btnRemover;
	private JSpinner spinnerQuantidade;
	private JRadioButton rdbtnCartao;
	private JRadioButton rdbtnDinheiro;
	private float total = 0;
	private JLabel lblLogo;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenuItem mntmVoltar;
	private static Login usuarioLogado = null;
	private JLabel lblDescricao;
	private JTextField textDescricao;
	private JPanel panel_3;
	private JButton btnNewButton;

	public static Login getUsuarioLogado() {
		return usuarioLogado;
	}

	public static void setUsuarioLogado(Login usuarioLogado) {
		Venda.usuarioLogado = usuarioLogado;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Venda frame = new Venda();
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
	public Venda() {
		
		ControlVenda controlVenda = new ControlVenda(this);
		
		ptModel = new ProdutoTableVenda();
		
		Toolkit tk = Toolkit.getDefaultToolkit();
	    Dimension d = tk.getScreenSize();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, d.width, d.height);
		this.setExtendedState(MAXIMIZED_BOTH);
		this.setLocationRelativeTo(null);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnNewMenu = new JMenu("Menu");
		menuBar.add(mnNewMenu);
		
		mntmVoltar = new JMenuItem("Voltar");
		mntmVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlVenda.voltar(usuarioLogado);
			}
		});
		mnNewMenu.add(mntmVoltar);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{454, 886, 0};
		gbl_contentPane.rowHeights = new int[]{540, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(40, 40, 40, 40));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		contentPane.add(panel, gbc_panel);
		panel.setLayout(new GridLayout(11, 0, 0, 20));
		
		lblDescricao = new JLabel("Descri\u00E7\u00E3o");
		panel.add(lblDescricao);
		
		textDescricao = new JTextField();
		textDescricao.setEditable(false);
		panel.add(textDescricao);
		textDescricao.setColumns(10);
		
		lblCodigo = new JLabel("Codigo");
		panel.add(lblCodigo);
		
		panel_3 = new JPanel();
		panel.add(panel_3);
		panel_3.setLayout(new GridLayout(0, 2, 0, 0));
		
		textCodigo = new JtextNum(4);
		panel_3.add(textCodigo);
		textCodigo.addKeyListener(new KeyAdapter() {
				public void keyReleased(KeyEvent e) {
					controlVenda.verificaCodigo(table, textCodigo, textTotal, spinnerQuantidade, textDescricao);
				}
				});
		textCodigo.setColumns(10);
		
		btnNewButton = new JButton("Pesquisar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlVenda.abrirBusca();
			}
		});
		panel_3.add(btnNewButton);
		
		lblQuantidade = new JLabel("Quantidade");
		panel.add(lblQuantidade);
		
		spinnerQuantidade = new JSpinner();
		spinnerQuantidade.setModel(new SpinnerNumberModel(0, 0, null, 1));
		spinnerQuantidade.addChangeListener(e -> {
			controlVenda.verificaSpinner(textCodigo, textTotal, spinnerQuantidade);
		});
		panel.add(spinnerQuantidade);
		
		lblTotal = new JLabel("Total");
		panel.add(lblTotal);
		
		textTotal = new JTextField();
		textTotal.setEditable(false);
		panel.add(textTotal);
		textTotal.setColumns(10);
		
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlVenda.adicionar(chckbxDesconto, ptModel, table, Integer.valueOf(spinnerQuantidade.getValue().toString()), textCodigo, textTotal, spinnerQuantidade, total, textTotalVenda);
			}
		});
		panel.add(btnAdicionar);
		
		btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlVenda.remover(spinnerQuantidade, textCodigo, chckbxDesconto, ptModel, table,  table.getSelectedRow(), total, textTotalVenda);
			}
		});
		panel.add(btnRemover);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 0;
		contentPane.add(scrollPane, gbc_scrollPane);
		
		table = new JTable();
		
		table.setModel(ptModel);

		table.setBorder(new EmptyBorder(50, 50, 50, 50));
		scrollPane.setViewportView(table);
		
		panel_2 = new JPanel();
		panel_2.setBorder(new EmptyBorder(0, 40, 0, 40));
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 0, 5);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 1;
		contentPane.add(panel_2, gbc_panel_2);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));
		
		lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(Venda.class.getResource("/Imagens/MarteCell.png")));
		lblLogo.setBounds(panel_2.getBounds());
		panel_2.add(lblLogo);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new EmptyBorder(30, 50, 30, 50));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 1;
		contentPane.add(panel_1, gbc_panel_1);
		panel_1.setLayout(new GridLayout(3, 3, 0, 10));
		
		lblFormaPgt = new JLabel("Forma de Pagamento");
		panel_1.add(lblFormaPgt);
		lblFormaPgt.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblTotalVenda = new JLabel("TOTAL:");
		lblTotalVenda.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblTotalVenda);
		
		textTotalVenda = new JTextField();
		textTotalVenda.setEditable(false);
		panel_1.add(textTotalVenda);
		textTotalVenda.setColumns(10);
		
		rdbtnCartao = new JRadioButton("Cart\u00E3o");
		panel_1.add(rdbtnCartao);
		rdbtnCartao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlVenda.marcarCartao(rdbtnDinheiro, rdbtnCartao, chckbxDesconto, total, textTotalVenda);
			}
		});
		
		btnFinalizarVenda = new JButton("Finalizar Venda");
		btnFinalizarVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlVenda.finalizarVenda(table, textTotalVenda);
			}
		});
		
		chckbxDesconto = new JCheckBox("10% DESCONTO");
		chckbxDesconto.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxDesconto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlVenda.marcarDesconto(table, chckbxDesconto, total, textTotalVenda);
			}
		});
		panel_1.add(chckbxDesconto);
		panel_1.add(btnFinalizarVenda);
		
		rdbtnDinheiro = new JRadioButton("Dinheiro");
		panel_1.add(rdbtnDinheiro);
		rdbtnDinheiro.setSelected(true);
		rdbtnDinheiro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlVenda.marcarDinheiro(rdbtnDinheiro, rdbtnCartao, chckbxDesconto);
			}
		});
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}
	
	public JtextNum getTextCodigo() {
		return textCodigo;
	}

	public void setTextCodigo(JtextNum textCodigo) {
		this.textCodigo = textCodigo;
	}


}
