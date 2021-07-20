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

public class UpdateDonor extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField phone;
	private JTextField email;
	private JTextField address;
	private JTextField city;
	private JTextField did;
	private JTable table;
	private JTextField DOB;
	private JTextField gender;
	private JTextField bloodGroup;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateDonor frame = new UpdateDonor();
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
	public UpdateDonor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 866, 516);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel title1 = new JLabel("Update/Delete Donor Details");
		title1.setFont(new Font("Times New Roman", Font.BOLD, 30));
		title1.setBounds(257, 10, 395, 40);
		contentPane.add(title1);
		
		JLabel sek_id = new JLabel("Donor ID");
		sek_id.setFont(new Font("Times New Roman", Font.BOLD, 17));
		sek_id.setBounds(243, 70, 109, 40);
		contentPane.add(sek_id);
		
		JLabel aname = new JLabel("Full Name");
		aname.setFont(new Font("Times New Roman", Font.BOLD, 15));
		aname.setBounds(45, 130, 109, 33);
		contentPane.add(aname);
		
		JLabel email1 = new JLabel("email ID");
		email1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		email1.setBounds(45, 360, 59, 40);
		contentPane.add(email1);
		
		JLabel phno = new JLabel("PhoneNo");
		phno.setFont(new Font("Times New Roman", Font.BOLD, 15));
		phno.setBounds(45, 188, 98, 33);
		contentPane.add(phno);
		
		JLabel gender1 = new JLabel("Gender");
		gender1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		gender1.setBounds(45, 248, 71, 22);
		contentPane.add(gender1);
		
		JLabel city1 = new JLabel("City");
		city1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		city1.setBounds(451, 193, 63, 22);
		contentPane.add(city1);
		
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
		email.setBounds(164, 366, 212, 31);
		contentPane.add(email);
		email.setColumns(10);
		
		address = new JTextField();
		address.setBounds(451, 289, 294, 85);
		contentPane.add(address);
		address.setColumns(10);
		
		city = new JTextField();
		city.setBounds(567, 188, 143, 33);
		contentPane.add(city);
		city.setColumns(10);
		
		did = new JTextField();
		did.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		did.setBounds(341, 79, 35, 22);
		contentPane.add(did);
		did.setColumns(10);
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//Class.forName("com.mysql.jdbc.Driver");  
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bdm","root","viggy");  
					PreparedStatement smt=con.prepareStatement("update donor set name=?,DOB=?,phoneNo=?,gender=?,emailId=?,bloodGroup=?,city=?,address=? where donorId=?");
					smt.setString(1,name.getText());
					smt.setString(2,DOB.getText());
					smt.setString(3,phone.getText());
					smt.setString(4,gender.getText());
					smt.setString(5,email.getText());
					smt.setString(6,bloodGroup.getText());
					smt.setString(7,city.getText());
					smt.setString(8,address.getText());
					smt.setString(9,did.getText());
					smt.executeUpdate();
					con.close();
				}
				catch(Exception exe)
				{
					
				}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnNewButton.setBounds(152, 424, 79, 33);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Reset");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new UpdateDonor().setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnNewButton_1.setBounds(291, 424, 85, 33);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Close");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnNewButton_2.setBounds(567, 424, 85, 33);
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
		
		gender = new JTextField();
		gender.setBounds(164, 251, 168, 33);
		contentPane.add(gender);
		gender.setColumns(10);
		
		bloodGroup = new JTextField();
		bloodGroup.setBounds(567, 130, 96, 33);
		contentPane.add(bloodGroup);
		bloodGroup.setColumns(10);
		
		JButton btnNewButton_3S = new JButton("Search");
		btnNewButton_3S.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//Class.forName("com.mysql.jdbc.Driver");  
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bdm","root","viggy"); 
					PreparedStatement smt=con.prepareStatement("select * from donor where donorId=?");
					smt.setString(1,did.getText());
					ResultSet rs=smt.executeQuery();
					if(rs.next())
					{
						did.setText(rs.getString("donorId"));
						name.setText(rs.getString("name"));
						DOB.setText(rs.getString("DOB"));
						phone.setText(rs.getString("phoneNo"));
						gender.setText(rs.getString("DOB"));
						email.setText(rs.getString("emailId"));
						bloodGroup.setText(rs.getString("bloodGroup"));
						city.setText(rs.getString("city"));
						address.setText(rs.getString("address"));
					}
					con.close();
					did.setEditable(false);
				}
				catch(Exception exe)
				{
					System.out.println(exe);
				}
			}
		});
		btnNewButton_3S.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_3S.setBounds(435, 74, 119, 32);
		contentPane.add(btnNewButton_3S);
		
		JButton btnNewButton_3 = new JButton("Delete");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//Class.forName("com.mysql.jdbc.Driver");  
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bdm","root","viggy"); 
					PreparedStatement smt=con.prepareStatement("delete from donor where donorId=?");
					smt.setString(1,did.getText());
					smt.executeUpdate();
					con.close();
				}
				catch(Exception exe)
				{
					
				}
			}
		});
		btnNewButton_3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnNewButton_3.setBounds(435, 424, 85, 33);
		contentPane.add(btnNewButton_3);
	}
}