import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Forgot extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	public static java.sql.ResultSet rs;
	public static java.sql.PreparedStatement pst;
	public static java.sql.Connection conn;

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Forgot frame = new Forgot();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Forgot() {
		conn=javaconnect.estConn();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 596, 466);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblUsername.setBounds(63, 135, 93, 28);
		contentPane.add(lblUsername);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblName.setBounds(63, 192, 56, 16);
		contentPane.add(lblName);
		
		JLabel lblYourSecurityQuestion = new JLabel("Security question");
		lblYourSecurityQuestion.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblYourSecurityQuestion.setBounds(63, 242, 196, 16);
		contentPane.add(lblYourSecurityQuestion);
		
		JLabel lblAnswer = new JLabel("Answer");
		lblAnswer.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAnswer.setBounds(63, 294, 75, 16);
		contentPane.add(lblAnswer);
		
		JLabel lblYourPassword = new JLabel("Your Pin");
		lblYourPassword.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblYourPassword.setBounds(63, 348, 123, 16);
		contentPane.add(lblYourPassword);
		
		textField = new JTextField();
		textField.setBounds(238, 139, 151, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(238, 190, 151, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setBounds(238, 240, 151, 22);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(238, 292, 151, 22);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setBounds(238, 346, 151, 22);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String uname=textField.getText();
				String sql="Select * from Account Where Username='"+uname+"'";
				
				try{
					pst=conn.prepareStatement(sql);
					rs=pst.executeQuery();
				if(rs.next()){
					textField_1.setText(rs.getString(2));
					textField_2.setText(rs.getString(4));
					rs.close();
					pst.close();
					}
					else{
						JOptionPane.showMessageDialog(null, "Incorrect Username");
					}
				}catch(Exception e1){
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		btnSearch.setBounds(425, 138, 97, 25);
		contentPane.add(btnSearch);
		
		JButton btnRetrieve = new JButton("Retrieve");
		btnRetrieve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String a1=textField.getText();
				String a2=textField_3.getText();
				String sql="Select * from Account Where Answer='"+a2+"'";
				try{
					pst=conn.prepareStatement(sql);
					rs=pst.executeQuery();
					if(rs.next()){
						textField_4.setText(rs.getString(3));
					}
				}catch(Exception e1){
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		btnRetrieve.setBounds(425, 291, 97, 25);
		contentPane.add(btnRetrieve);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(425, 345, 97, 25);
		contentPane.add(btnBack);
		
		JLabel lblForgotPassword = new JLabel("Forgot Password");
		lblForgotPassword.setForeground(new Color(0, 153, 153));
		lblForgotPassword.setFont(new Font("Tahoma", Font.BOLD, 34));
		lblForgotPassword.setBounds(131, 26, 348, 56);
		contentPane.add(lblForgotPassword);
	}
}
