import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

public class home extends JFrame{
	private JPanel contentPane;
	private String username;
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public home() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 683, 453);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWelcome = new JLabel("Administrator");
		lblWelcome.setForeground(new Color(0, 153, 153));
		lblWelcome.setFont(new Font("Tahoma", Font.BOLD, 31));
		lblWelcome.setBounds(246, 39, 262, 46);
		contentPane.add(lblWelcome);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 718, 26);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Options");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmSignOut = new JMenuItem("Sign out");
		mnNewMenu.add(mntmSignOut);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mnNewMenu.add(mntmExit);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mnHelp.add(mntmAbout);
		
		JButton btnNewButton = new JButton("New book");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newBook();				
			}
		});
		btnNewButton.setBounds(58, 304, 119, 25);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Statistics");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(261, 304, 119, 25);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New member");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newMember();
			}
		});
		btnNewButton_2.setBounds(462, 304, 149, 25);
		contentPane.add(btnNewButton_2);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Utkarsh Prasad\\Desktop\\JAVA\\LibMS\\img\\Actions-address-book-new-icon.png"));
		label.setBounds(48, 129, 169, 150);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Users\\Utkarsh Prasad\\Desktop\\JAVA\\LibMS\\img\\statistics-market-icon.png"));
		label_1.setBounds(261, 139, 155, 135);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon("C:\\Users\\Utkarsh Prasad\\Desktop\\JAVA\\LibMS\\img\\Actions-contact-new-icon.png"));
		label_2.setBounds(470, 129, 177, 140);
		contentPane.add(label_2);
		
		this.setVisible(true);
	}
	
	public void newBook(){
		setVisible(false);
		NewBook book = new NewBook();
		book.setVisible(true);
	}
	public void newMember(){
		this.setVisible(false);
		NewMember mem = new NewMember(this);
	}
}
