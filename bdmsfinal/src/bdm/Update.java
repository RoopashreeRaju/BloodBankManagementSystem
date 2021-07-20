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

public class Update extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField phone;
	private JTextField email;
	private JTextField address;
	private JTextField city;
	private JTextField sid;
	private JTable table;
	private JTextField DOB;
	private JTextField gender;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Update frame = new Update();
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
	public Update() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 866, 516);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel title1 = new JLabel("Update Seeker Details");
		title1.setFont(new Font("Times New Roman", Font.BOLD, 30));
		title1.setBounds(257, 10, 315, 40);
		contentPane.add(title1);
		
		JLabel sek_id = new JLabel("Seeker ID");
		sek_id.setFont(new Font("Times New Roman", Font.BOLD, 17));
		sek_id.setBounds(243, 70, 109, 40);
		contentPane.add(sek_id);
		
		JLabel aname = new JLabel("Full Name");
		aname.setFont(new Font("Times New Roman", Font.BOLD, 15));
		aname.setBounds(45, 130, 109, 33);
		contentPane.add(aname);
		
		JLabel email12 = new JLabel("email ID");
		email12.setFont(new Font("Times New Roman", Font.BOLD, 15));
		email12.setBounds(469, 126, 59, 40);
		contentPane.add(email12);
		
		JLabel phno22 = new JLabel("PhoneNo");
		phno22.setFont(new Font("Times New Roman", Font.BOLD, 15));
		phno22.setBounds(45, 188, 98, 33);
		contentPane.add(phno22);
		
		JLabel gendere = new JLabel("Gender");
		gendere.setFont(new Font("Times New Roman", Font.BOLD, 15));
		gendere.setBounds(45, 248, 71, 22);
		contentPane.add(gendere);
		
		JLabel city222 = new JLabel("City");
		city222.setFont(new Font("Times New Roman", Font.BOLD, 15));
		city222.setBounds(469, 193, 63, 22);
		contentPane.add(city222);
		
		JLabel Add = new JLabel("Complete Address");
		Add.setFont(new Font("Times New Roman", Font.BOLD, 15));
		Add.setBounds(469, 255, 152, 22);
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
		email.setBounds(564, 130, 212, 31);
		contentPane.add(email);
		email.setColumns(10);
		
		address = new JTextField();
		address.setBounds(457, 315, 294, 85);
		contentPane.add(address);
		address.setColumns(10);
		
		city = new JTextField();
		city.setBounds(565, 192, 143, 27);
		contentPane.add(city);
		city.setColumns(10);
		
		sid = new JTextField();
		sid.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		sid.setBounds(341, 79, 35, 22);
		contentPane.add(sid);
		sid.setColumns(10);
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//Class.forName("com.mysql.jdbc.Driver");  
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bdm","root","viggy");  
					PreparedStatement smt=con.prepareStatement("update seeker set name=?,DOB=?,phoneNo=?,gender=?,emailId=?,city=?,address=? where seekerId=?");
					smt.setString(1,name.getText());
					smt.setString(2,DOB.getText());
					smt.setString(3,phone.getText());
					smt.setString(4,gender.getText());
					smt.setString(5,email.getText());
					smt.setString(6,city.getText());
					smt.setString(7,address.getText());
					smt.setString(8,sid.getText());
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
				new Update().setVisible(true);
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
		
		JButton btnNewButton_3S = new JButton("Search");
		btnNewButton_3S.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//Class.forName("com.mysql.jdbc.Driver");  
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bdm","root","viggy"); 
					PreparedStatement smt=con.prepareStatement("select * from seeker where seekerId=?");
					smt.setString(1,sid.getText());
					ResultSet rs=smt.executeQuery();
					if(rs.next())
					{
						sid.setText(rs.getString("seekerId"));
						name.setText(rs.getString("name"));
						DOB.setText(rs.getString("DOB"));
						phone.setText(rs.getString("phoneNo"));
						gender.setText(rs.getString("gender"));
						email.setText(rs.getString("emailId"));
						city.setText(rs.getString("city"));
						address.setText(rs.getString("address"));
					}
					con.close();
					sid.setEditable(false);
				}
				catch(Exception exe)
				{
					System.out.println(exe);
				}
			}
		});
		btnNewButton_3S.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_3S.setBounds(435, 74, 97, 32);
		contentPane.add(btnNewButton_3S);
		
		JButton btnNewButton_3 = new JButton("Delete");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//Class.forName("com.mysql.jdbc.Driver");  
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bdm","root","viggy"); 
					PreparedStatement smt=con.prepareStatement("delete from seeker where seekerId=?");
					smt.setString(1,sid.getText());
					smt.executeUpdate();
					con.close();
				}
				catch(Exception exe)
				{
					
				}
			}
		});
		btnNewButton_3.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_3.setBounds(410, 424, 85, 33);
		contentPane.add(btnNewButton_3);
	}
}
