package View;


import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JTable;

import Configuracao.ProdutoTableModel;
import Control.ControlEstoque;
import model.Login;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

@SuppressWarnings("serial")
public class Estoque extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JPanel panel;
	private JButton btnAdicionar;
	private JButton btnEditar;
	private JButton btnDeletar;
	private JButton btnVoltar;
	private JScrollPane scrollPane;
	private ControlEstoque controlEstoque;
	private ProdutoTableModel ptModel;
	private static Boolean atualiza;
	private JPanel panel_1;
	private JTextField textPesquisar;
	private JButton btnPesquisar;
	private static Login usuarioLogado = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Estoque frame = new Estoque();
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
	public Estoque() {
		controlEstoque = new ControlEstoque(this);
		ptModel = new ProdutoTableModel(usuarioLogado);
		
		controlEstoque.criarEstoque();
		
		Toolkit tk = Toolkit.getDefaultToolkit();
	    Dimension d = tk.getScreenSize();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, d.width, d.height);
		this.setExtendedState(MAXIMIZED_BOTH);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{1353, 0};
		gbl_contentPane.rowHeights = new int[]{100, 531, 45, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblTitulo = new JLabel("MARTE CELL");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 55));
		lblTitulo.setForeground(new Color(255, 69, 0));
		GridBagConstraints gbc_lblTitulo = new GridBagConstraints();
		gbc_lblTitulo.insets = new Insets(0, 0, 5, 0);
		gbc_lblTitulo.gridx = 0;
		gbc_lblTitulo.gridy = 0;
		contentPane.add(lblTitulo, gbc_lblTitulo);
		
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		contentPane.add(scrollPane, gbc_scrollPane);
		
		table = new JTable();
		
		controlEstoque.alimentarTabela(ptModel, table, usuarioLogado);
		
		scrollPane.setViewportView(table);
		
		setAtualiza(false);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new EmptyBorder(20, 20, 20, 20));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 2;
		contentPane.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{1163, 140, 0};
		gbl_panel_1.rowHeights = new int[]{22, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		textPesquisar = new JTextField();
		GridBagConstraints gbc_textPesquisar = new GridBagConstraints();
		gbc_textPesquisar.fill = GridBagConstraints.BOTH;
		gbc_textPesquisar.insets = new Insets(0, 0, 0, 5);
		gbc_textPesquisar.gridx = 0;
		gbc_textPesquisar.gridy = 0;
		panel_1.add(textPesquisar, gbc_textPesquisar);
		textPesquisar.setColumns(10);
		
		btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
				for(int i=0; i < table.getRowCount(); i++) {
					if(textPesquisar.getText().equals(table.getValueAt(i, 0).toString()) ||
							textPesquisar.getText().equals(table.getValueAt(i, 1).toString()) ||
							-1 != table.getValueAt(i, 1).toString().indexOf(textPesquisar.getText())) {
						
						table.addRowSelectionInterval(i, i);
						
					}
				}
			}
		});
		GridBagConstraints gbc_btnPesquisar = new GridBagConstraints();
		gbc_btnPesquisar.fill = GridBagConstraints.BOTH;
		gbc_btnPesquisar.gridx = 1;
		gbc_btnPesquisar.gridy = 0;
		panel_1.add(btnPesquisar, gbc_btnPesquisar);
		
		panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 3;
		contentPane.add(panel, gbc_panel);
		panel.setLayout(new GridLayout(1, 0, 20, 0));
		
		if(usuarioLogado.getRole().equals("ADMIN")) {
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlEstoque.adicionar();
			}
		});
		panel.add(btnAdicionar);
		}
		
		btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlEstoque.editar(table, usuarioLogado);
			}
		});
		panel.add(btnEditar);
		
		if(usuarioLogado.getRole().equals("ADMIN")) {
		btnDeletar = new JButton("Deletar");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlEstoque.deletar(table);
			}
		});
		panel.add(btnDeletar);
		}
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlEstoque.voltar(usuarioLogado);
			}
		});
		panel.add(btnVoltar);
		
		new Thread() {
			public void run() {
				while(table.isEnabled()) {
					if(atualiza == false) {
					}
					else{
						controlEstoque.alimentarTabela(ptModel, table, usuarioLogado);
						setAtualiza(false);
					}
					try {
						sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}.start();;
	}
	
	public void atualizarTabela() {
		controlEstoque.alimentarTabela(ptModel, table, usuarioLogado);
	}

	public static Boolean getAtualiza() {
		return atualiza;
	}

	public static void setAtualiza(Boolean atualiza) {
		Estoque.atualiza = atualiza;
	}

	public static Login getUsuarioLogado() {
		return usuarioLogado;
	}

	public static void setUsuarioLogado(Login usuarioLogado) {
		Estoque.usuarioLogado = usuarioLogado;
	}


}
