import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.ImageIcon;

public class Signup extends JFrame{

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;
	public static Connection conn;
	public static java.sql.PreparedStatement pst;
	public static void main(String[] args) {
		 
		
	  
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Signup frame = new Signup();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Signup() {
		conn=javaconnect.estConn();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 606, 574);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblName.setBounds(97, 197, 56, 16);
		contentPane.add(lblName);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUsername.setBounds(97, 142, 97, 16);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Security Pin");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPassword.setBounds(97, 257, 97, 16);
		contentPane.add(lblPassword);
		
		JLabel lblYourSecurityQuestion = new JLabel("Security question");
		lblYourSecurityQuestion.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblYourSecurityQuestion.setBounds(97, 308, 175, 16);
		contentPane.add(lblYourSecurityQuestion);
		
		JLabel lblYourSecurityAnswer = new JLabel("Security answer");
		lblYourSecurityAnswer.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblYourSecurityAnswer.setBounds(97, 368, 187, 16);
		contentPane.add(lblYourSecurityAnswer);
		
		textField = new JTextField();
		textField.setBounds(311, 142, 184, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(311, 197, 184, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(311, 257, 184, 22);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(311, 368, 184, 22);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.ITALIC, 13));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"What is your nickname?", "What is your favourite color?", "Which was your first car?", "What is the name of your school?"}));
		comboBox.setToolTipText("Select a question");
		comboBox.setBounds(311, 308, 184, 22);
		contentPane.add(comboBox);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try{
				String sql = "Insert into Account(Username, Name, Pin, Sec_Q, Answer) values (?,?,?,?,?)";
				pst = conn.prepareStatement(sql);
				pst.setString(1, textField.getText());
				pst.setString(2, textField_1.getText());
				pst.setString(3, textField_2.getText());
				pst.setString(4, (String)comboBox.getSelectedItem());
				pst.setString(5, textField_4.getText());
				pst.execute();
				JOptionPane.showMessageDialog(null, "New Account created");
			}catch(Exception e1){
				JOptionPane.showMessageDialog(null, e1);
			}
			}
		});
		btnCreate.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCreate.setBounds(156, 437, 116, 45);
		contentPane.add(btnCreate);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			setVisible(false);
			Login ob =new Login();
			ob.setVisible(true);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnBack.setBounds(311, 437, 109, 45);
		contentPane.add(btnBack);
		
		JLabel lblSignUp = new JLabel("SIGN UP");
		lblSignUp.setForeground(new Color(0, 153, 153));
		lblSignUp.setFont(new Font("Tahoma", Font.BOLD, 34));
		lblSignUp.setBounds(175, 38, 184, 45);
		contentPane.add(lblSignUp);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Utkarsh Prasad\\Desktop\\JAVA\\LibMS\\img\\User-Files-icon.png"));
		label.setBounds(406, 13, 117, 94);
		contentPane.add(label);
	}
}
