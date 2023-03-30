package questao09;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;


import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


import questao08.CriarBanco.*;


public class TelaCadastro extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtIdade;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastro frame = new TelaCadastro();
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
	public TelaCadastro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 372, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setBounds(24, 78, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Idade");
		lblNewLabel_1.setBounds(24, 126, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		txtNome = new JTextField();
		txtNome.setBounds(68, 75, 248, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		txtIdade = new JTextField();
		txtIdade.setColumns(10);
		txtIdade.setBounds(68, 123, 248, 20);
		contentPane.add(txtIdade);
		
		JButton btnCadastrar = new JButton("New button");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Conexao Conexao = new Conexao();
				// Istacia coeexão
				Conexao = Conexao.getInstacia();
				// Connection
				Connection c = Conexao.conectar();

				try {
					String wQuery = "INSERT INTO minha_db (nome,idade) VALUES (?,?);";
					PreparedStatement  stm = c.prepareStatement(wQuery);
					
					stm.setString(1,txtNome.getText());
					stm.setInt(2,Integer.valueOf(txtIdade.getText()));
					
					
					stm.execute();
					JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				Conexao.fecharConnection();
			}
			
		});
		btnCadastrar.setBounds(139, 195, 89, 55);
		contentPane.add(btnCadastrar);
	}
}
