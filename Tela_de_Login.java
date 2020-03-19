import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Tela_de_Login extends JFrame {

	private JPanel contentPane;
	private JTextField tfusuario;
	private JPasswordField tfsenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_de_Login frame = new Tela_de_Login();
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
	public Tela_de_Login() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 277, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setBounds(25, 42, 86, 28);
		contentPane.add(lblNewLabel);
		
		tfusuario = new JTextField();
		tfusuario.setBounds(25, 66, 100, 20);
		contentPane.add(tfusuario);
		tfusuario.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Senha");
		lblNewLabel_1.setBounds(25, 97, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		tfsenha = new JPasswordField();
		tfsenha.setBounds(25, 119, 100, 20);
		contentPane.add(tfsenha);
		
		JButton btentrar = new JButton("Entrar");
		btentrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tfusuario.getText().equals("")|| tfsenha.getText().equals("")) {
					
					JOptionPane.showInputDialog("dados em branco");
			
		}else {
				try {
					Connection con = Conexao.conectar();
					
					String sql = "select *from tblogin where usuario=? and senha=?";
					
					PreparedStatement stmt = con.prepareStatement(sql); 
					
					stmt.setString(1, tfusuario.getText());
					stmt.setString(2, new  String (tfsenha.getPassword() ));
					
					ResultSet rs =  stmt.executeQuery();
					
					if (rs.next()) {
						 Tela_de_Cadastro exibir = new Tela_de_Cadastro() ;
						 exibir.setVisible(true);
						 
						setVisible(false);
					}else {
						JOptionPane.showMessageDialog(null, "usuario nao existe");
					}
					
					stmt.close();
					con.close();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		}
				
			        }
		});
		btentrar.setBounds(25, 185, 89, 23);
		contentPane.add(btentrar);
	}
}
             