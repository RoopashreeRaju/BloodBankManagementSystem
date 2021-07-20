package bdm;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;



import java.awt.Font;
import java.awt.Label;
import java.awt.Window;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class logIn1 extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JTextField pswd;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					logIn1 frame = new logIn1();
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
	public logIn1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 862, 525);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("User Name:");
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 19));
		lblNewLabel.setBounds(334, 148, 127, 39);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password:");
		lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.BOLD, 19));
		lblNewLabel_1.setBounds(334, 212, 117, 39);
		contentPane.add(lblNewLabel_1);
		
		username = new JTextField();
		username.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		username.setBounds(500, 148, 161, 32);
		contentPane.add(username);
		username.setColumns(10);
		
		pswd = new JPasswordField();
		pswd.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
		pswd.setBounds(500, 212, 161, 32);
		contentPane.add(pswd);
		pswd.setColumns(10);
		
		JButton btnNewButton = new JButton("LogIn");
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String user=username.getText();
				String passwd=pswd.getText();
				
				if(user.equals("roopa") && passwd.equals("456"))
				{
					JOptionPane.showMessageDialog(null,  "Login Successful");;
					setVisible(false);
					new Home().setVisible(true);
				}
				else
				JOptionPane.showMessageDialog(null, "Incorrect Username or Password");
			}
		});
		btnNewButton.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		btnNewButton.setBounds(440, 289, 93, 32);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Close");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a=JOptionPane.showConfirmDialog(null, "Do you really want to close the Application ?","Select",JOptionPane.YES_NO_OPTION);
				if(a==0)
					System.exit(0);
			}
		});
		btnNewButton_1.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		btnNewButton_1.setBounds(605, 289, 93, 32);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Krishna\\Downloads\\unnamed.png"));
		lblNewLabel_2.setBounds(54, 56, 376, 357);
		contentPane.add(lblNewLabel_2);
		
	}
}
