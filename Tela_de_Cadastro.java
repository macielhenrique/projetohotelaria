import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Tela_de_Cadastro extends JFrame {

	private JPanel contentPane;
	private JTextField tfn_quarto;
	private JTextField tfID;
	private JTextField tfAndar;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_de_Cadastro frame = new Tela_de_Cadastro();
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
	public Tela_de_Cadastro() {
		setTitle("cadastro de quartos");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("N\u00B0 do quarto");
		lblNewLabel.setBounds(22, 67, 82, 31);
		contentPane.add(lblNewLabel);
		
		tfn_quarto = new JTextField();
		tfn_quarto.setBounds(22, 96, 75, 20);
		contentPane.add(tfn_quarto);
		tfn_quarto.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Andar");
		lblNewLabel_1.setBounds(26, 127, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("ID");
		lblNewLabel_2.setBounds(26, 11, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		tfID = new JTextField();
		tfID.setEditable(false);
		tfID.setBounds(22, 36, 65, 20);
		contentPane.add(tfID);
		tfID.setColumns(10);
		
		tfAndar = new JTextField();
		tfAndar.setBounds(22, 152, 82, 20);
		contentPane.add(tfAndar);
		tfAndar.setColumns(10);
		
		JButton btcadastrar = new JButton("Cadastrar");
		btcadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Connection con = Conexao.conectar();
					
					String sql = "insert into tbquartos(nquarto,andar) values (?,?)";
					
					PreparedStatement stmt = con.prepareStatement(sql);
					
					stmt.setString(1,tfn_quarto.getText());
					stmt.setString(2,tfAndar.getText());
					
					stmt.execute();
					
					stmt.close();
					con.close();
					
					JOptionPane.showInputDialog("cadastrado com sucesso");
					
					tfn_quarto.setText("");
					tfAndar.setText("");
					
					
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btcadastrar.setBounds(32, 192, 89, 23);
		contentPane.add(btcadastrar);
		
		btnNewButton = new JButton("DELETE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					Connection con = Conexao.conectar();
					
					String sql ="delete from tbquartos where id=? ";
					
					PreparedStatement stmt = con.prepareStatement(sql);
					
					stmt.execute ();
					stmt.close ();
					con.close();
					
					JOptionPane.showInputDialog("deletado com sucesso");
					
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
			}
		});
		btnNewButton.setBounds(257, 192, 89, 23);
		contentPane.add(btnNewButton);
	}
}
