package View;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Configuracao.TableRelatorio;
import Control.ControlRelatorio;
import model.Login;

import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class Relatorio extends JFrame {

	private JPanel contentPane;
	private TableRelatorio trModel;
	private JTable table;
	private JLabel lblDataInicial;
	private JLabel lblDataFinal;
	private JButton btnBuscar;
	private static Login usuarioLogado = null;
	private JButton btnVoltar;
	private JDateChooser dateChooser1;
	private JDateChooser dateChooser2;
	private JPanel panel_2;
	private JLabel lblTotal;
	private JLabel lblTotalValor;
	private JPanel panel_3;
	private JPanel panel_1;
	private JPanel panel_4;
	private JLabel lblTitulo;
	private JPanel panel_5;
	private JLabel lblInvestido;
	private JLabel lblNewLabel_1;
	private JLabel lblTotalLiquido;
	private JLabel lblNewLabel_3;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Relatorio frame = new Relatorio();
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
	public Relatorio() {
		
		trModel = new TableRelatorio();
		
		ControlRelatorio controlRelatorio = new ControlRelatorio(this);
		
		Toolkit tk = Toolkit.getDefaultToolkit();
	    Dimension d = tk.getScreenSize();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setExtendedState(MAXIMIZED_BOTH);
		setBounds(100, 100, d.width, d.height);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		setContentPane(contentPane);
		
		panel_4 = new JPanel();
		panel_4.setBackground(Color.BLACK);
		panel_4.setLayout(new GridLayout(0, 1, 0, 0));
		
		lblTitulo = new JLabel("RELAT\u00D3RIO");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 55));
		lblTitulo.setForeground(new Color(255, 140, 0));
		lblTitulo.setBackground(Color.WHITE);
		panel_4.add(lblTitulo);
		
		panel_1 = new JPanel();
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{350, 1066, 0};
		gbl_panel_1.rowHeights = new int[]{556, 79, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		ImageIcon img = new ImageIcon (Menu.class.getResource("/Imagens/lupa.png"));
		img.setImage(img.getImage().getScaledInstance(20, 20, 100));
		
		panel_3 = new JPanel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.anchor = GridBagConstraints.NORTH;
		gbc_panel_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_3.insets = new Insets(0, 0, 5, 5);
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 0;
		panel_1.add(panel_3, gbc_panel_3);
		panel_3.setBorder(new EmptyBorder(40, 40, 40, 40));
		panel_3.setLayout(new GridLayout(10, 1, 0, 20));
		
		lblDataInicial = new JLabel("Data Inicial");
		panel_3.add(lblDataInicial);
		
		dateChooser1 = new JDateChooser();
		panel_3.add(dateChooser1);
		
		lblDataFinal = new JLabel("DataFinal");
		panel_3.add(lblDataFinal);
		
		dateChooser2 = new JDateChooser();
		panel_3.add(dateChooser2);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setForeground(new Color(255, 255, 255));
		btnBuscar.setBackground(new Color(255, 140, 0));
		panel_3.add(btnBuscar);
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlRelatorio.buscar(trModel, table, dateChooser1, dateChooser2, lblTotalValor);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 1367, GroupLayout.PREFERRED_SIZE)
				.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 1367, GroupLayout.PREFERRED_SIZE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
					.addGap(5)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel.anchor = GridBagConstraints.NORTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 0;
		panel_1.add(panel, gbc_panel);
		panel.setBorder(new EmptyBorder(20, 20, 20, 20));
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{979, 0};
		gbl_panel.rowHeights = new int[]{439, 107, 0};
		gbl_panel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.anchor = GridBagConstraints.NORTH;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		panel.add(scrollPane, gbc_scrollPane);
		
		table = new JTable();
		table.setBackground(Color.WHITE);
		table.setModel(trModel);
		scrollPane.setViewportView(table);
		
		panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(192, 192, 192)));
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 1;
		panel.add(panel_2, gbc_panel_2);
		panel_2.setLayout(new GridLayout(3, 2, 0, 0));
		
		lblTotal = new JLabel("TOTAL:");
		lblTotal.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_2.add(lblTotal);
		
		lblTotalValor = new JLabel("");
		lblTotalValor.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_2.add(lblTotalValor);
		
		lblInvestido = new JLabel("INVESTIDO:");
		lblInvestido.setForeground(new Color(255, 0, 0));
		lblInvestido.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_2.add(lblInvestido);
		
		lblNewLabel_1 = new JLabel("New label");
		panel_2.add(lblNewLabel_1);
		
		lblTotalLiquido = new JLabel("TOTAL LIQUIDO:");
		lblTotalLiquido.setForeground(new Color(0, 255, 0));
		lblTotalLiquido.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_2.add(lblTotalLiquido);
		
		lblNewLabel_3 = new JLabel("New label");
		panel_2.add(lblNewLabel_3);
		
		panel_5 = new JPanel();
		panel_5.setBorder(new EmptyBorder(0, 40, 0, 40));
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_5.insets = new Insets(0, 0, 0, 5);
		gbc_panel_5.gridx = 0;
		gbc_panel_5.gridy = 1;
		panel_1.add(panel_5, gbc_panel_5);
		panel_5.setLayout(new GridLayout(0, 1, 0, 0));
		
		btnVoltar = new JButton("Voltar");
		panel_5.add(btnVoltar);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlRelatorio.voltar(usuarioLogado);
			}
		});
		contentPane.setLayout(gl_contentPane);
	}

	public static Login getUsuarioLogado() {
		return usuarioLogado;
	}

	public static void setUsuarioLogado(Login usuarioLogado) {
		Relatorio.usuarioLogado = usuarioLogado;
	}

}
