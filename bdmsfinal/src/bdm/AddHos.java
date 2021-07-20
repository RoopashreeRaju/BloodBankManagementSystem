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
import java.awt.event.ActionEvent;

public class AddHos extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField phone;
	private JTextField email;
	private JTextField address;
	private JTextField city;
	private JTextField hid;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddHos frame = new AddHos();
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
	public AddHos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 866, 516);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel title = new JLabel("Add New Hospital");
		title.setFont(new Font("Times New Roman", Font.BOLD, 30));
		title.setBounds(306, 10, 297, 40);
		contentPane.add(title);
		
		JLabel sek_add = new JLabel("New Hospital ID");
		sek_add.setFont(new Font("Times New Roman", Font.BOLD, 15));
		sek_add.setBounds(45, 70, 109, 40);
		contentPane.add(sek_add);
		
		JLabel aname = new JLabel("Hospital Name");
		aname.setFont(new Font("Times New Roman", Font.BOLD, 15));
		aname.setBounds(45, 130, 109, 33);
		contentPane.add(aname);
		
		JLabel emailid = new JLabel("email ID");
		emailid.setFont(new Font("Times New Roman", Font.BOLD, 15));
		emailid.setBounds(45, 260, 59, 40);
		contentPane.add(emailid);
		
		JLabel phno = new JLabel("PhoneNo");
		phno.setFont(new Font("Times New Roman", Font.BOLD, 15));
		phno.setBounds(45, 193, 98, 33);
		contentPane.add(phno);
		
		JLabel city2 = new JLabel("City");
		city2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		city2.setBounds(451, 135, 63, 22);
		contentPane.add(city2);
		
		JLabel Add = new JLabel("Complete Address");
		Add.setFont(new Font("Times New Roman", Font.BOLD, 15));
		Add.setBounds(451, 193, 152, 22);
		contentPane.add(Add);
		
		name = new JTextField();
		name.setBounds(164, 130, 168, 33);
		contentPane.add(name);
		name.setColumns(10);
		
		phone = new JTextField();
		phone.setBounds(164, 193, 168, 32);
		contentPane.add(phone);
		phone.setColumns(10);
		
		email = new JTextField();
		email.setBounds(164, 266, 212, 31);
		contentPane.add(email);
		email.setColumns(10);
		
		address = new JTextField();
		address.setBounds(451, 239, 294, 85);
		contentPane.add(address);
		address.setColumns(10);
		
		city = new JTextField();
		city.setBounds(567, 130, 143, 33);
		contentPane.add(city);
		city.setColumns(10);
		
		hid = new JTextField();
		hid.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		hid.setBounds(164, 79, 35, 22);
		contentPane.add(hid);
		hid.setColumns(10);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//Class.forName("com.mysql.jdbc.Driver");  
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bdm","root","viggy");  
					PreparedStatement smt=con.prepareStatement("insert into hospital(hospitalId,hospitalName,phoneNo,emailId,city,address)values(null,?,?,?,?,?)");
					smt.setString(1,name.getText());
					smt.setString(2,phone.getText());
					smt.setString(3,email.getText());
					smt.setString(4,city.getText());
					smt.setString(5,address.getText());
					
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
				new AddHos().setVisible(true);
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
		
		table = new JTable();
		table.setBounds(174, 325, 0, 0);
		contentPane.add(table);
	}
}
