package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import modelo.Pessoa;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;

public class TelaCadastro extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtCpf;

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
		setBounds(100, 100, 579, 373);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(29, 47, 72, 21);
		contentPane.add(lblNewLabel);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setForeground(Color.WHITE);
		lblCpf.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblCpf.setBounds(29, 109, 72, 21);
		contentPane.add(lblCpf);
		
		txtNome = new JTextField();
		txtNome.setBounds(175, 47, 278, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		txtCpf = new JFormattedTextField();
		MaskFormatter formatter = null;
		try {
			formatter = new MaskFormatter("###.###.###-##");
		} catch (ParseException e2) {
			e2.printStackTrace();
		}
		JTextField txtCpf = new JFormattedTextField(formatter);
		txtCpf.setColumns(10);
		txtCpf.setBounds(175, 112, 278, 20);
		contentPane.add(txtCpf);
		
		JButton btnCad = new JButton("Cadastrar");
		btnCad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nome = txtNome.getText();
				String cpf = txtCpf.getText();
				
				cpf = cpf.replace(".", ""); // forma feia mas facil
				cpf = cpf.replace("-", "");
				
				long cpfL = Long.valueOf(txtCpf.getText());
				
				Pessoa p = new Pessoa();
				p.setNome(nome);
				p.setCpf(cpfL);
			
		}
		});
		btnCad.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnCad.setBounds(224, 200, 120, 79);
		contentPane.add(btnCad);
	}
}
