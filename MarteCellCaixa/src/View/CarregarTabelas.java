package View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JProgressBar;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.SwingConstants;

public class CarregarTabelas extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static int carregar = 0;


	public static int getCarregar() {
		return carregar;
	}

	public static void setCarregar(int carregar) {
		CarregarTabelas.carregar = carregar;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CarregarTabelas dialog = new CarregarTabelas();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CarregarTabelas() {
		
		setBounds(100, 100, 450, 300);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(0, 1, 0, 0));
		{
			JLabel lblTitulo = new JLabel("CARREGANDO TABELAS");
			lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
			contentPanel.add(lblTitulo);
		}
		{
			JProgressBar progressBar = new JProgressBar();
			contentPanel.add(progressBar);
			
			new Thread() {
				public void run() {
					while(progressBar.getValue()<100) {
						
					progressBar.setValue(carregar);
					try {
						sleep (10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					}
					carregar = 0;
					dispose();
					}	
			}.start();;
		}
	}

}
