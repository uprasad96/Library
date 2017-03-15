import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JProgressBar;
import javax.swing.ImageIcon;

public class Loading extends JFrame implements Runnable {

	private JPanel contentPane;
	private String username;
	private Thread th = null;
	

	/**
	 * Create the frame.
	 */
	JProgressBar progressBar;
	public Loading(String username) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 564, 521);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUssLibrary = new JLabel("Downtown Library 2.0");
		lblUssLibrary.setForeground(new Color(0, 153, 153));
		lblUssLibrary.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblUssLibrary.setBounds(74, 25, 483, 55);
		contentPane.add(lblUssLibrary);
		
		progressBar = new JProgressBar();
		progressBar.setStringPainted(true);
		progressBar.setBounds(138, 132, 264, 22);
		contentPane.add(progressBar);
		
		JLabel lblPleaseWait = new JLabel("Please wait...");
		lblPleaseWait.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPleaseWait.setBounds(221, 188, 110, 16);
		contentPane.add(lblPleaseWait);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Utkarsh Prasad\\Desktop\\JAVA\\LibMS\\img\\loading-book.gif"));
		lblNewLabel.setBounds(158, 217, 244, 205);
		contentPane.add(lblNewLabel);
		
		this.username = username;
		
		th = new Thread(this);
		th.start();
	}
	int presentValue,maxValue;
	public void run(){
		maxValue = progressBar.getMaximum();
		try{
			while(true){
				presentValue = progressBar.getValue();
				if(presentValue == maxValue){
					break;
				}
				progressBar.setValue(presentValue + 1);
				Thread.sleep(10);
			}
			home hm = new home();
			this.dispose();
		}catch(Exception exc){
			JOptionPane.showMessageDialog(null, exc);
		}
	}
}
