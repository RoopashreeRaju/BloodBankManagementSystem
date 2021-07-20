package bdm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Add extends JFrame {

	private JPanel contentPane;
	private JTextField name1;
	private JTextField phno1;
	private JTextField email1;
	private JTextField address1;
	private JTextField city1;
	private JTextField ssid;
	private JTable table;
	private JTextField DOB1;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add frame = new Add();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
/*Sets the button's text*/ 


	/**
	 * Create the frame.
	 */
	public Add() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 866, 516);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel title = new JLabel("Add New Seeker");
		title.setFont(new Font("Times New Roman", Font.BOLD, 30));
		title.setBounds(306, 10, 223, 40);
		contentPane.add(title);
		
		JLabel sek_add = new JLabel("New Seeker ID");
		sek_add.setFont(new Font("Times New Roman", Font.BOLD, 15));
		sek_add.setBounds(45, 70, 109, 40);
		contentPane.add(sek_add);
		
		JLabel aname = new JLabel("Full Name");
		aname.setFont(new Font("Times New Roman", Font.BOLD, 15));
		aname.setBounds(45, 130, 109, 33);
		contentPane.add(aname);
		
		JLabel email = new JLabel("email ID");
		email.setFont(new Font("Times New Roman", Font.BOLD, 15));
		email.setBounds(451, 70, 59, 40);
		contentPane.add(email);
		
		JLabel phno = new JLabel("PhoneNo");
		phno.setFont(new Font("Times New Roman", Font.BOLD, 15));
		phno.setBounds(45, 188, 98, 33);
		contentPane.add(phno);
		
		JLabel gender = new JLabel("Gender");
		gender.setFont(new Font("Times New Roman", Font.BOLD, 15));
		gender.setBounds(45, 248, 71, 22);
		contentPane.add(gender);
		
		JLabel city = new JLabel("City");
		city.setFont(new Font("Times New Roman", Font.BOLD, 15));
		city.setBounds(461, 152, 63, 22);
		contentPane.add(city);
		
		JLabel Add = new JLabel("Complete Address");
		Add.setFont(new Font("Times New Roman", Font.BOLD, 15));
		Add.setBounds(461, 209, 152, 22);
		contentPane.add(Add);
		
		name1 = new JTextField();
		name1.setBounds(164, 130, 168, 33);
		contentPane.add(name1);
		name1.setColumns(10);
		
		phno1 = new JTextField();
		phno1.setBounds(164, 193, 168, 32);
		contentPane.add(phno1);
		phno1.setColumns(10);
		
		email1 = new JTextField();
		email1.setBounds(567, 70, 212, 31);
		contentPane.add(email1);
		email1.setColumns(10);
		
		address1 = new JTextField();
		address1.setBounds(451, 256, 294, 85);
		contentPane.add(address1);
		address1.setColumns(10);
		
		city1 = new JTextField();
		city1.setBounds(567, 146, 143, 33);
		contentPane.add(city1);
		city1.setColumns(10);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		comboBox.setBounds(164, 250, 79, 21);
		contentPane.add(comboBox);
		
		ssid = new JTextField();
		ssid.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		ssid.setBounds(164, 79, 35, 22);
		contentPane.add(ssid);
		ssid.setColumns(10);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//Class.forName("com.mysql.jdbc.Driver");  
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bdm","root","viggy");  
					PreparedStatement smt=con.prepareStatement("insert into seeker(seekerId,name,DOB,phoneNo,gender,emailId,city,address)values(null,?,?,?,?,?,?,?)");
					smt.setString(1,name1.getText());
					smt.setString(2,DOB1.getText());
					smt.setString(3,phno1.getText());
					smt.setString(4,(String)comboBox.getSelectedItem());
					smt.setString(5,email1.getText());
					smt.setString(6,city1.getText());
					smt.setString(7,address1.getText());
					
					smt.executeUpdate();
					
					con.close();
				}
				catch(Exception exe)
				{
					
				}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnNewButton.setBounds(152, 406, 79, 33);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Reset");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Add().setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnNewButton_1.setBounds(357, 406, 85, 33);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Close");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnNewButton_2.setBounds(567, 406, 85, 33);
		contentPane.add(btnNewButton_2);
		
		JLabel dob = new JLabel("Date Of Birth");
		dob.setFont(new Font("Times New Roman", Font.BOLD, 15));
		dob.setBounds(45, 311, 98, 22);
		contentPane.add(dob);
		
		table = new JTable();
		table.setBounds(174, 325, 0, 0);
		contentPane.add(table);
		
		DOB1 = new JTextField();
		DOB1.setBounds(164, 311, 134, 30);
		contentPane.add(DOB1);
		DOB1.setColumns(10);
		viewId();
	}
private void viewId() {
	// TODO Auto-generated method stub
	try {
		//Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bdm","root","viggy"); 
		PreparedStatement smt=con.prepareStatement("SELECT auto_increment FROM information_schema.TABLES WHERE TABLE_SCHEMA = \"bdm\" AND TABLE_NAME = \"seeker\"");
		ResultSet rs=smt.executeQuery();
		if(rs.next())
		{
			ssid.setText(rs.getString("auto_increment"));
			
		}
		
	}
	catch(Exception exe)
	{
		
	}
}
}
