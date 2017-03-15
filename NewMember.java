import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.*;
import java.util.Date;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;

public class NewMember extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JComboBox comboBox;
	private Connection conn;
	private PreparedStatement stmt;
	private home hm;

	

	/**
	 * Create the frame.
	 */
	public NewMember(home hm) {
		this.hm = hm;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 582, 519);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Member ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(76, 142, 184, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblName.setBounds(76, 189, 119, 16);
		contentPane.add(lblName);
		
		JLabel lblMembershipType = new JLabel("Membership Type");
		lblMembershipType.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMembershipType.setBounds(76, 231, 184, 16);
		contentPane.add(lblMembershipType);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEmail.setBounds(76, 278, 119, 16);
		contentPane.add(lblEmail);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPhone.setBounds(76, 327, 119, 16);
		contentPane.add(lblPhone);
		
		textField = new JTextField();
		textField.setBounds(334, 142, 116, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(334, 189, 116, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Normal\t", "Extended"}));
		comboBox.setBounds(334, 231, 116, 22);
		contentPane.add(comboBox);
		
		textField_2 = new JTextField();
		textField_2.setBounds(334, 278, 116, 22);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(334, 327, 116, 22);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addAccount();
			}
		});
		btnAdd.setBounds(153, 388, 104, 34);
		contentPane.add(btnAdd);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				home ob =new home();
				ob.setVisible(true);
			}
		});
		btnBack.setBounds(308, 388, 104, 34);
		contentPane.add(btnBack);
		
		JLabel lblRegisterMember = new JLabel("Register Member");
		lblRegisterMember.setForeground(new Color(0, 153, 153));
		lblRegisterMember.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblRegisterMember.setBounds(129, 51, 295, 43);
		contentPane.add(lblRegisterMember);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Utkarsh Prasad\\Desktop\\JAVA\\LibMS\\img\\Actions-contact-new-icon (1).png"));
		label.setBounds(436, 13, 128, 92);
		contentPane.add(label);
		
		getMemId();
		this.setVisible(true);
	}
	public void getMemId(){
		try{
			conn = javaconnect.estConn();
			String sql = "Select max(Mem_ID) from member";
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			int id = 1;
			while(rs.next()){
				id = rs.getInt(1) + 1;				
			}
			textField.setText(((Integer)id).toString());
			conn.close();
			stmt.close();			
		}catch(Exception exc){
			exc.printStackTrace();
		}finally{
			try{
				if(conn != null)
					conn.close();
				if(stmt != null)
					stmt.close();
			}catch(Exception exc){
				JOptionPane.showMessageDialog(null, exc);
			}
		}
	}
	public void addAccount(){
		try{
			conn = javaconnect.estConn();
			String sql = "Insert into member values(?,?,?,?,?,?)";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, Integer.parseInt(textField.getText()) );
			stmt.setString(2, textField_1.getText());
			stmt.setString(3,comboBox.getSelectedItem().toString());
			stmt.setString(4,textField_2.getText());
			stmt.setString(6, textField_3.getText());
			GregorianCalendar now = new GregorianCalendar();
			String month = getMonth(now.get(GregorianCalendar.MONTH));
			int year = now.get(GregorianCalendar.YEAR) ;
			if("Normal".compareTo(comboBox.getSelectedItem().toString()) == 0){
				year ++;
			}
			else{
				year = year + 2;
			}
			String expiry = month + " " + year;
			stmt.setString(5, expiry);
			stmt.executeUpdate();
			conn.close();
			stmt.close();			
		}catch(Exception exc){
			JOptionPane.showMessageDialog(null, exc);
		}finally{
			try{
				if(conn != null)
					conn.close();
				if(stmt != null)
					stmt.close();
			}catch(Exception exc){
				JOptionPane.showMessageDialog(null, exc);
			}
		}
	}
	public String getMonth(int x){
		switch(x){
			case 0: return "Jan";
			case 1: return "Feb";
			case 2: return "Mar";
			case 3: return "April";
			case 4: return "May";
			case 5: return "Jun";
			case 6: return "Jul";
			case 7: return "Aug";
			case 8: return "Sept";
			case 9: return "Oct";
			case 10: return "Nov";
			case 11: return "Dec";
			default: return "Unknown";
		}
	}
}
