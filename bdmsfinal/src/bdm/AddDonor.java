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
import java.awt.event.ActionEvent;

public class AddDonor extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField phone;
	private JTextField email;
	private JTextField address;
	private JTextField city;
	private JTextField did;
	private JTable table;
	private JTextField DOB;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddDonor frame = new AddDonor();
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
	public AddDonor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 866, 516);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel title = new JLabel("Add New Donor");
		title.setFont(new Font("Times New Roman", Font.BOLD, 30));
		title.setBounds(306, 10, 223, 40);
		contentPane.add(title);
		
		JLabel sek_add = new JLabel("New Donor ID");
		sek_add.setFont(new Font("Times New Roman", Font.BOLD, 15));
		sek_add.setBounds(45, 70, 109, 40);
		contentPane.add(sek_add);
		
		JLabel aname = new JLabel("Full Name");
		aname.setFont(new Font("Times New Roman", Font.BOLD, 15));
		aname.setBounds(45, 130, 109, 33);
		contentPane.add(aname);
		
		JLabel email2 = new JLabel("email ID");
		email2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		email2.setBounds(451, 70, 59, 40);
		contentPane.add(email2);
		
		JLabel phno = new JLabel("PhoneNo");
		phno.setFont(new Font("Times New Roman", Font.BOLD, 15));
		phno.setBounds(45, 188, 98, 33);
		contentPane.add(phno);
		
		JLabel gender = new JLabel("Gender");
		gender.setFont(new Font("Times New Roman", Font.BOLD, 15));
		gender.setBounds(45, 248, 71, 22);
		contentPane.add(gender);
		
		JLabel city33 = new JLabel("City");
		city33.setFont(new Font("Times New Roman", Font.BOLD, 15));
		city33.setBounds(451, 193, 63, 22);
		contentPane.add(city33);
		
		JLabel bloodgroup = new JLabel("BloodGroup");
		bloodgroup.setFont(new Font("Times New Roman", Font.BOLD, 15));
		bloodgroup.setBounds(451, 141, 119, 22);
		contentPane.add(bloodgroup);
		
		JLabel Add = new JLabel("Complete Address");
		Add.setFont(new Font("Times New Roman", Font.BOLD, 15));
		Add.setBounds(451, 248, 152, 22);
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
		email.setBounds(567, 70, 212, 31);
		contentPane.add(email);
		email.setColumns(10);
		
		address = new JTextField();
		address.setBounds(451, 289, 294, 85);
		contentPane.add(address);
		address.setColumns(10);
		
		city = new JTextField();
		city.setBounds(567, 188, 143, 27);
		contentPane.add(city);
		city.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		comboBox.setBounds(164, 250, 79, 21);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-"}));
		comboBox_1.setBounds(567, 137, 53, 21);
		contentPane.add(comboBox_1);
		
		did = new JTextField();
		did.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		did.setBounds(164, 79, 35, 22);
		contentPane.add(did);
		did.setColumns(10);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//Class.forName("com.mysql.jdbc.Driver");  
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bdm","root","viggy");  
					PreparedStatement smt=con.prepareStatement("insert into donor(donorId,name,DOB,phoneNo,gender,emailId,bloodGroup,city,address)values(null,?,?,?,?,?,?,?,?)");
					smt.setString(1,name.getText());
					smt.setString(2,DOB.getText());
					smt.setString(3,phone.getText());
					smt.setString(4,(String)comboBox.getSelectedItem());
					smt.setString(5,email.getText());
					smt.setString(6,(String)comboBox_1.getSelectedItem());
					smt.setString(7,city.getText());
					smt.setString(8,address.getText());
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
				new AddDonor().setVisible(true);
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
		
		DOB = new JTextField();
		DOB.setBounds(164, 311, 134, 30);
		contentPane.add(DOB);
		DOB.setColumns(10);
		viewtable();
	}

	private void viewtable() {
		// TODO Auto-generated method stub
		try {
			//Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bdm","root","viggy"); 
			PreparedStatement smt=con.prepareStatement("SELECT auto_increment FROM information_schema.TABLES WHERE TABLE_SCHEMA = \"bdm\" AND TABLE_NAME = \"donor\"");
			ResultSet rs=smt.executeQuery();
			if(rs.next())
			{
				did.setText(rs.getString("auto_increment"));
				
			}
			
		}
		catch(Exception exe)
		{
			
		}
	}
}
