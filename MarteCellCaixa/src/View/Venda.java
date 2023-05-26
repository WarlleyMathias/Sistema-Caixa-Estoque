package View;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Configuracao.DecimalField;
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
import javax.swing.border.LineBorder;
import javax.swing.event.AncestorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.Color;
import com.toedter.calendar.JDateChooser;

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
	private JMenuItem mntmPeliculas;
	private JRadioButton rdbtnPix;
	
	ControlVenda controlVenda = new ControlVenda(this);
	private JPanel panel_4;
	private JPanel panel_5;
	private JPanel panel_6;
	private JButton btnNewButton_1;
	private JPanel panel_7;
	private JPanel panel_8;
	private JPanel panel_9;
	private JSpinner spinner;
	private JLabel lblTotalComDesconto;
	private DecimalField textTotalVendaDesconto;
	private JDateChooser dateChooser1;

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
		
		mntmPeliculas = new JMenuItem("Peliculas");
		mntmPeliculas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlVenda.abrirPelicula(usuarioLogado);
			}
		});
		mnNewMenu.add(mntmPeliculas);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{454, 886, 0};
		gbl_contentPane.rowHeights = new int[]{517, 145, 0};
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
		
		lblDescricao = new JLabel("DESCRI\u00C7\u00C3O");
		panel.add(lblDescricao);
		
		textDescricao = new JTextField();
		textDescricao.setEditable(false);
		panel.add(textDescricao);
		textDescricao.setColumns(10);
		
		lblCodigo = new JLabel("CODIGO:");
		panel.add(lblCodigo);
		
		panel_3 = new JPanel();
		panel.add(panel_3);
		panel_3.setLayout(new GridLayout(0, 2, 0, 0));
		
		textCodigo = new JtextNum(100);
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
		
		panel_7 = new JPanel();
		lblQuantidade = new JLabel("QUANTIDADE:");
		panel_7.add(lblQuantidade, "1, 1, fill, fill");
		
		spinnerQuantidade = new JSpinner();
		panel_7.add(spinnerQuantidade, "2, 1, fill, fill");
		spinnerQuantidade.setModel(new SpinnerNumberModel(0, 0, null, 1));
		spinnerQuantidade.addChangeListener(e -> {
			controlVenda.verificaSpinner(textCodigo, textTotal, spinnerQuantidade);
		});
		
		
		panel.add(panel_7);
		panel_7.setLayout(new GridLayout(0, 2, 0, 0));
		
		panel_5 = new JPanel();
		panel.add(panel_5);
		panel_5.setLayout(new GridLayout(0, 2, 0, 0));
		
		lblTotal = new JLabel("TOTAL:");
		panel_5.add(lblTotal);
		
		textTotal = new DecimalField("#,##0.00");
		panel_5.add(textTotal);
		textTotal.setEditable(false);
		textTotal.setColumns(10);
		
		panel_4 = new JPanel();
		panel.add(panel_4);
		panel_4.setLayout(new GridLayout(0, 2, 0, 0));
		
		btnAdicionar = new JButton("Adicionar");
		panel_4.add(btnAdicionar);
		
		btnRemover = new JButton("Remover");
		panel_4.add(btnRemover);
		
		btnNewButton_1 = new JButton("Novo Servi\u00E7o");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlVenda.novoServico();
			}
		});
		panel.add(btnNewButton_1);
		
		dateChooser1 = new JDateChooser();
		panel.add(dateChooser1);
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlVenda.remover(spinnerQuantidade, textCodigo, chckbxDesconto, ptModel, table,  table.getSelectedRow(), total, textTotalVenda, textTotalVendaDesconto, spinner);
			}
		});
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlVenda.adicionar(chckbxDesconto, ptModel, table, Integer.valueOf(spinnerQuantidade.getValue().toString()), textCodigo, textTotal, spinnerQuantidade, total, textTotalVenda, textTotalVendaDesconto, spinner);
			}
		});
		
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
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{369, 293, 0};
		gbl_panel_1.rowHeights = new int[]{96, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		panel_8 = new JPanel();
		panel_8.setBorder(new LineBorder(new Color(0, 0, 0)));
		GridBagConstraints gbc_panel_8 = new GridBagConstraints();
		gbc_panel_8.insets = new Insets(0, 0, 0, 5);
		gbc_panel_8.fill = GridBagConstraints.BOTH;
		gbc_panel_8.gridx = 0;
		gbc_panel_8.gridy = 0;
		panel_1.add(panel_8, gbc_panel_8);
		GridBagLayout gbl_panel_8 = new GridBagLayout();
		gbl_panel_8.columnWidths = new int[]{37, 65, 39, 59, 0};
		gbl_panel_8.rowHeights = new int[]{23, 0};
		gbl_panel_8.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_8.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_8.setLayout(gbl_panel_8);
		
		lblFormaPgt = new JLabel("Forma de Pagamento");
		GridBagConstraints gbc_lblFormaPgt = new GridBagConstraints();
		gbc_lblFormaPgt.anchor = GridBagConstraints.WEST;
		gbc_lblFormaPgt.insets = new Insets(0, 0, 0, 5);
		gbc_lblFormaPgt.gridx = 0;
		gbc_lblFormaPgt.gridy = 0;
		panel_8.add(lblFormaPgt, gbc_lblFormaPgt);
		
		rdbtnDinheiro = new JRadioButton("Dinheiro");
		GridBagConstraints gbc_rdbtnDinheiro = new GridBagConstraints();
		gbc_rdbtnDinheiro.anchor = GridBagConstraints.NORTHWEST;
		gbc_rdbtnDinheiro.insets = new Insets(0, 0, 0, 5);
		gbc_rdbtnDinheiro.gridx = 1;
		gbc_rdbtnDinheiro.gridy = 0;
		panel_8.add(rdbtnDinheiro, gbc_rdbtnDinheiro);
		rdbtnDinheiro.setSelected(true);
		rdbtnDinheiro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlVenda.marcarDinheiro(rdbtnPix, rdbtnDinheiro, rdbtnCartao, chckbxDesconto);
			}
		});
		
		rdbtnPix = new JRadioButton("Pix");
		GridBagConstraints gbc_rdbtnPix = new GridBagConstraints();
		gbc_rdbtnPix.anchor = GridBagConstraints.NORTHWEST;
		gbc_rdbtnPix.insets = new Insets(0, 0, 0, 5);
		gbc_rdbtnPix.gridx = 2;
		gbc_rdbtnPix.gridy = 0;
		panel_8.add(rdbtnPix, gbc_rdbtnPix);
		rdbtnPix.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlVenda.marcarPix(rdbtnPix, rdbtnDinheiro, rdbtnCartao, chckbxDesconto);
			}
		});
		
		rdbtnCartao = new JRadioButton("Cart\u00E3o");
		GridBagConstraints gbc_rdbtnCartao = new GridBagConstraints();
		gbc_rdbtnCartao.anchor = GridBagConstraints.NORTHWEST;
		gbc_rdbtnCartao.gridx = 3;
		gbc_rdbtnCartao.gridy = 0;
		panel_8.add(rdbtnCartao, gbc_rdbtnCartao);
		rdbtnCartao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlVenda.marcarCartao(rdbtnPix, rdbtnDinheiro, rdbtnCartao, chckbxDesconto, total, textTotalVenda);
			}
		});
		
		panel_9 = new JPanel();
		panel_9.setBorder(new LineBorder(new Color(0, 0, 0)));
		GridBagConstraints gbc_panel_9 = new GridBagConstraints();
		gbc_panel_9.fill = GridBagConstraints.BOTH;
		gbc_panel_9.gridx = 1;
		gbc_panel_9.gridy = 0;
		panel_1.add(panel_9, gbc_panel_9);
		GridBagLayout gbl_panel_9 = new GridBagLayout();
		gbl_panel_9.columnWidths = new int[]{0, 107, 36, 86, 0, 0};
		gbl_panel_9.rowHeights = new int[]{0, 23, 0};
		gbl_panel_9.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel_9.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_9.setLayout(gbl_panel_9);
		
		chckbxDesconto = new JCheckBox("DESCONTO %");
		GridBagConstraints gbc_chckbxDesconto = new GridBagConstraints();
		gbc_chckbxDesconto.anchor = GridBagConstraints.NORTHWEST;
		gbc_chckbxDesconto.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxDesconto.gridx = 0;
		gbc_chckbxDesconto.gridy = 0;
		panel_9.add(chckbxDesconto, gbc_chckbxDesconto);
		chckbxDesconto.setHorizontalAlignment(SwingConstants.LEFT);
		chckbxDesconto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlVenda.marcarDesconto(table, chckbxDesconto, spinner, total, textTotalVenda, textTotalVendaDesconto);
			}
		});
		
		lblTotalVenda = new JLabel("TOTAL:");
		GridBagConstraints gbc_lblTotalVenda = new GridBagConstraints();
		gbc_lblTotalVenda.insets = new Insets(0, 0, 5, 5);
		gbc_lblTotalVenda.gridx = 2;
		gbc_lblTotalVenda.gridy = 0;
		panel_9.add(lblTotalVenda, gbc_lblTotalVenda);
		lblTotalVenda.setHorizontalAlignment(SwingConstants.CENTER);
		
		textTotalVenda = new DecimalField("#,##0.00");
		GridBagConstraints gbc_textTotalVenda = new GridBagConstraints();
		gbc_textTotalVenda.fill = GridBagConstraints.HORIZONTAL;
		gbc_textTotalVenda.insets = new Insets(0, 0, 5, 5);
		gbc_textTotalVenda.gridx = 3;
		gbc_textTotalVenda.gridy = 0;
		panel_9.add(textTotalVenda, gbc_textTotalVenda);
		textTotalVenda.setEditable(false);
		textTotalVenda.setColumns(10);
		
		spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(0, 0, 10, 1));
		GridBagConstraints gbc_spinner = new GridBagConstraints();
		gbc_spinner.insets = new Insets(0, 0, 0, 5);
		gbc_spinner.gridx = 0;
		gbc_spinner.gridy = 1;
		spinner.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				controlVenda.marcarDesconto(table, chckbxDesconto,spinner, total, textTotalVenda, textTotalVendaDesconto);
				
			}
		});
		panel_9.add(spinner, gbc_spinner);
		
		lblTotalComDesconto = new JLabel("TOTAL COM DESCONTO:");
		lblTotalComDesconto.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblTotalComDesconto = new GridBagConstraints();
		gbc_lblTotalComDesconto.anchor = GridBagConstraints.EAST;
		gbc_lblTotalComDesconto.insets = new Insets(0, 0, 0, 5);
		gbc_lblTotalComDesconto.gridx = 2;
		gbc_lblTotalComDesconto.gridy = 1;
		panel_9.add(lblTotalComDesconto, gbc_lblTotalComDesconto);
		
		textTotalVendaDesconto = new DecimalField("#,##0.00");
		GridBagConstraints gbc_textTotalVendaDesconto = new GridBagConstraints();
		gbc_textTotalVendaDesconto.insets = new Insets(0, 0, 0, 5);
		gbc_textTotalVendaDesconto.fill = GridBagConstraints.HORIZONTAL;
		gbc_textTotalVendaDesconto.gridx = 3;
		gbc_textTotalVendaDesconto.gridy = 1;
		textTotalVendaDesconto.setEditable(false);
		textTotalVendaDesconto.setColumns(10);
		panel_9.add(textTotalVendaDesconto, gbc_textTotalVendaDesconto);
		
		btnFinalizarVenda = new JButton("Finalizar Venda");
		GridBagConstraints gbc_btnFinalizarVenda = new GridBagConstraints();
		gbc_btnFinalizarVenda.anchor = GridBagConstraints.NORTH;
		gbc_btnFinalizarVenda.gridx = 4;
		gbc_btnFinalizarVenda.gridy = 1;
		panel_9.add(btnFinalizarVenda, gbc_btnFinalizarVenda);
		btnFinalizarVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(dateChooser1.getDate() != null) {
					SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
					
					Date date1 = dateChooser1.getDate();
					LocalDate date = LocalDate.ofInstant(date1.toInstant(), ZoneId.systemDefault());
					
					String strDateChoose1 = formatter.format(date1);
					controlVenda.finalizarVenda(table, textTotalVenda, textTotalVendaDesconto, rdbtnPix, rdbtnDinheiro, rdbtnCartao, chckbxDesconto, spinner, date);
				}else
					controlVenda.finalizarVenda(table, textTotalVenda, textTotalVendaDesconto, rdbtnPix, rdbtnDinheiro, rdbtnCartao, chckbxDesconto, spinner, LocalDate.now());
				
			}
		});
		
		if(!getUsuarioLogado().getName().equals("warlley"))
			dateChooser1.setEnabled(false);
		else
			dateChooser1.setEnabled(true);
		
	}

	public void buscaCod() {
		controlVenda.verificaCodigo(table, textCodigo, textTotal, spinnerQuantidade, textDescricao);
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
