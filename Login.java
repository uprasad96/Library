import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField pwd;
	public static java.sql.Connection conn;
	public static PreparedStatement pst;
	public static ResultSet rs;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Login() {
		conn=javaconnect.estConn();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 399);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setForeground(new Color(0, 153, 153));
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblLogin.setBounds(196, 13, 165, 49);
		contentPane.add(lblLogin);

		JLabel lblUsername = new JLabel("Username :");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblUsername.setBounds(89, 92, 104, 31);
		contentPane.add(lblUsername);

		JLabel lblPassword = new JLabel("Pin :");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPassword.setBounds(89, 147, 104, 39);
		contentPane.add(lblPassword);

		textField = new JTextField();
		textField.setBounds(196, 95, 179, 27);
		contentPane.add(textField);
		textField.setColumns(10);

		pwd = new JPasswordField();
		pwd.setText("");
		pwd.setBounds(196, 154, 179, 27);
		contentPane.add(pwd);

		JButton btnLogin = new JButton("Sign in");
		btnLogin.setIcon(new ImageIcon("C:\\Users\\Utkarsh Prasad\\Desktop\\JAVA\\LibMS\\iconpack\\login.png"));
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql ="Select * from Account Where Username=? and Pin=?";
				
				try{
					pst=conn.prepareStatement(sql);
					pst.setString(1, textField.getText());
					pst.setString(2, pwd.getText());
					rs=pst.executeQuery();
					if(rs.next()){
						rs.close();
						pst.close();
						
						setVisible(false);
						Loading ob =new Loading(textField.getText());
						ob.setVisible(true);
					}
					else{
						JOptionPane.showMessageDialog(null, "Incorrect Username and Password");
					}
					
				}catch(Exception e2){
					JOptionPane.showMessageDialog(null, e2);
				}finally{
					try{
						rs.close();
						pst.close();
					}catch(Exception e3){
						JOptionPane.showMessageDialog(null, e3);
					}
				}
			}
		});
		btnLogin.setBounds(196, 210, 110, 31);
		contentPane.add(btnLogin);

		JButton btnSignup = new JButton("Sign up");
		btnSignup.setIcon(new ImageIcon("C:\\Users\\Utkarsh Prasad\\Desktop\\JAVA\\LibMS\\iconpack\\signup.png"));
		btnSignup.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Signup ob = new Signup();
				ob.setVisible(true);
			}
		});
		btnSignup.setBounds(318, 210, 110, 31);
		contentPane.add(btnSignup);

		JButton btnForgotPassword = new JButton("Forgot Password");
		btnForgotPassword.setIcon(new ImageIcon("C:\\Users\\Utkarsh Prasad\\Desktop\\JAVA\\LibMS\\iconpack\\cross.png"));
		btnForgotPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Forgot ob = new Forgot();
				ob.setVisible(true);
			}
		});
		btnForgotPassword.setBounds(318, 265, 165, 36);
		contentPane.add(btnForgotPassword);

		JLabel lblTroubleS = new JLabel("Trouble Signing in?");
		lblTroubleS.setForeground(Color.RED);
		lblTroubleS.setBounds(170, 266, 119, 34);
		contentPane.add(lblTroubleS);
		
		JLabel label = new JLabel("");
		label.setBounds(370, 95, 37, 16);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Users\\Utkarsh Prasad\\Desktop\\JAVA\\LibMS\\iconpack\\username.png"));
		label_1.setBounds(387, 92, 56, 16);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon("C:\\Users\\Utkarsh Prasad\\Desktop\\JAVA\\LibMS\\iconpack\\key.png"));
		label_2.setBounds(383, 147, 24, 27);
		contentPane.add(label_2);
	}
}
