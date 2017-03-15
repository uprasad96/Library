import java.awt.BorderLayout;
import java.sql.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;

public class NewBook extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JButton btnAdd;
	private JButton btnBack;
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private JLabel lblAddBook;
	private JLabel label;

	public void close(){
		setVisible(false);
		setVisible(false);
		home ob =new home();
		ob.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public NewBook() {

			
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 571, 474);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Book ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(60, 93, 84, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Book Title");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(60, 152, 104, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblEdition = new JLabel("Edition");
		lblEdition.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEdition.setBounds(376, 256, 56, 16);
		contentPane.add(lblEdition);
		
		JLabel lblPublisher = new JLabel("Publisher");
		lblPublisher.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPublisher.setBounds(60, 256, 84, 16);
		contentPane.add(lblPublisher);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPrice.setBounds(60, 308, 56, 16);
		contentPane.add(lblPrice);
		
		JLabel lblPages = new JLabel("Author");
		lblPages.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPages.setBounds(60, 205, 56, 16);
		contentPane.add(lblPages);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(176, 90, 84, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(176, 149, 174, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(446, 253, 84, 22);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(176, 256, 174, 22);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(176, 305, 116, 22);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(176, 202, 116, 22);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		btnAdd = new JButton("Add");
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addBook();
			}
		});
		btnAdd.setBounds(163, 363, 97, 28);
		contentPane.add(btnAdd);
		
		btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				close();
			}
		});
		btnBack.setBounds(319, 363, 93, 28);
		contentPane.add(btnBack);
		
		lblAddBook = new JLabel("Add Book");
		lblAddBook.setForeground(new Color(0, 153, 153));
		lblAddBook.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblAddBook.setBounds(186, 13, 174, 43);
		contentPane.add(lblAddBook);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Utkarsh Prasad\\Desktop\\JAVA\\LibMS\\img\\Books-icon.png"));
		label.setBounds(387, 46, 135, 144);
		contentPane.add(label);
		

		setBookId();
		
		this.setVisible(true);
	}
	public void addBook(){
		try{
			conn = javaconnect.estConn();
			String sql = "Insert into book values(?,?,?,?,?,?)";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, Integer.parseInt(textField.getText()) );
			stmt.setString(2, textField_1.getText());
			stmt.setInt(3, Integer.parseInt(textField_2.getText()));
			stmt.setString(4, textField_3.getText());
			stmt.setFloat(5, Float.parseFloat(textField_4.getText()));
			stmt.setString(6, textField_5.getText());
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
	public void setBookId(){
		try{
			conn = javaconnect.estConn();
			String sql = "Select max(Book_ID) from book";
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
}
