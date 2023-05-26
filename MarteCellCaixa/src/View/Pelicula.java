package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Configuracao.PeliculaTableModel;
import Configuracao.ProdutoTableModel;
import Control.ControlPelicula;
import model.Login;

import java.awt.GridLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

public class Pelicula extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private PeliculaTableModel ptModel;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenuItem mntmVoltar;
	private ControlPelicula controlPelicula;
	private JTextField textPesquisar;
	private JButton btnNewButton;
	private static Login usuarioLogado = null;
	private JTable table_1;
	private JScrollPane scrollPane_1;

	public static Login getUsuarioLogado() {
		return usuarioLogado;
	}

	public static void setUsuarioLogado(Login usuarioLogado) {
		Pelicula.usuarioLogado = usuarioLogado;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pelicula frame = new Pelicula();
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
	public Pelicula() {
		
		ptModel = new PeliculaTableModel();
		
		controlPelicula = new ControlPelicula(this);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnNewMenu = new JMenu("Menu");
		menuBar.add(mnNewMenu);
		
		mntmVoltar = new JMenuItem("Voltar");
		mntmVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlPelicula.abrirVenda(usuarioLogado);
			}
		});
		mnNewMenu.add(mntmVoltar);
		
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
		gbl_contentPane.columnWidths = new int[]{0, 0};
		gbl_contentPane.rowHeights = new int[]{172, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 0;
		contentPane.add(panel_1, gbc_panel_1);
		
		JLabel lblNewLabel = new JLabel("PELICULAS");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 80));
		lblNewLabel.setForeground(new Color(255, 140, 0));
		panel_1.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{444, 452, 0};
		gbl_panel.rowHeights = new int[]{399, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 0;
		gbc_scrollPane_1.gridy = 0;
		panel.add(scrollPane_1, gbc_scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{"LARANJA", "1001 ~ 1014"},
				{"PRETO", "1015 ~ 1034"},
				{"VERDE", "1035 ~ 1049"},
				{"AZUL", "1050 ~ 1070"},
				{"PRATEADO ", "1071 ~ 1097"},
			},
			new String[] {
				"COR", "COD."
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.anchor = GridBagConstraints.NORTHWEST;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 0;
		panel.add(scrollPane, gbc_scrollPane);
		
		table = new JTable();
		table.setModel(ptModel);
		table.getColumnModel().getColumn(1).setPreferredWidth(190);
		table.getColumnModel().getColumn(0).setPreferredWidth(5);
		table.getColumnModel().getColumn(2).setPreferredWidth(3);
		scrollPane.setViewportView(table);
		

		
		controlPelicula.carregarTabelas(ptModel, table);
		
		textPesquisar = new JTextField();
		GridBagConstraints gbc_textPesquisar = new GridBagConstraints();
		gbc_textPesquisar.insets = new Insets(0, 0, 5, 0);
		gbc_textPesquisar.fill = GridBagConstraints.HORIZONTAL;
		gbc_textPesquisar.gridx = 1;
		gbc_textPesquisar.gridy = 1;
		panel.add(textPesquisar, gbc_textPesquisar);
		textPesquisar.setColumns(10);
		
		btnNewButton = new JButton("BUSCAR");
		btnNewButton.addActionListener(new ActionListener() {
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
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.anchor = GridBagConstraints.EAST;
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 2;
		panel.add(btnNewButton, gbc_btnNewButton);
	}

}
