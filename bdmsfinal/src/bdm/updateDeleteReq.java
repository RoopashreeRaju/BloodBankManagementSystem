package bdm;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class updateDeleteReq extends JFrame {

	private JPanel contentPane;
	private JTextField sname;
	private JTextField sphone;
	private JTextField sgender;
	private JTextField saddress;
	private JTextField sid;
	private JTextField hid;
	private JTextField hname;
	private JTextField hphone;
	private JTextField haddress;
	private JTextField units;
	private JTextField rid;
	private JTextField bloodGroup;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					updateDeleteReq frame = new updateDeleteReq();
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
	public updateDeleteReq() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 875, 529);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Update/ Delete");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel.setBounds(315, 10, 246, 64);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Seeker ID");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1.setBounds(35, 79, 98, 26);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Hospital ID");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_2.setBounds(457, 84, 85, 21);
		contentPane.add(lblNewLabel_2);
		
		JPanel panel = new JPanel();
		panel.setBounds(32, 130, 360, 255);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Seeker Name");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_3.setBounds(10, 10, 110, 26);
		panel.add(lblNewLabel_3);
		
		sname = new JTextField();
		sname.setBounds(145, 15, 104, 21);
		panel.add(sname);
		sname.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("PhoneNo");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_4.setBounds(10, 60, 88, 21);
		panel.add(lblNewLabel_4);
		
		sphone = new JTextField();
		sphone.setBounds(145, 62, 104, 19);
		panel.add(sphone);
		sphone.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Gender");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_5.setBounds(10, 106, 61, 26);
		panel.add(lblNewLabel_5);
		
		sgender = new JTextField();
		sgender.setBounds(145, 111, 104, 21);
		panel.add(sgender);
		sgender.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Address");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_6.setBounds(10, 158, 71, 21);
		panel.add(lblNewLabel_6);
		
		saddress = new JTextField();
		saddress.setBounds(145, 160, 147, 55);
		panel.add(saddress);
		saddress.setColumns(10);
		
		sid = new JTextField();
		sid.setBounds(123, 84, 68, 19);
		contentPane.add(sid);
		sid.setColumns(10);
		
		hid = new JTextField();
		hid.setBounds(565, 84, 75, 19);
		contentPane.add(hid);
		hid.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(472, 130, 351, 255);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		hname = new JTextField();
		hname.setBounds(186, 10, 96, 19);
		panel_1.add(hname);
		hname.setColumns(10);
		
		hphone = new JTextField();
		hphone.setBounds(186, 61, 96, 19);
		panel_1.add(hphone);
		hphone.setColumns(10);
		
		haddress = new JTextField();
		haddress.setBounds(186, 117, 139, 75);
		panel_1.add(haddress);
		haddress.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Hospital Name");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_7.setBounds(10, 13, 126, 16);
		panel_1.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("PhoneNo");
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_8.setBounds(10, 64, 96, 16);
		panel_1.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Address");
		lblNewLabel_9.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_9.setBounds(10, 120, 76, 16);
		panel_1.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Blood Group");
		lblNewLabel_10.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_10.setBounds(35, 396, 127, 26);
		contentPane.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Units Required");
		lblNewLabel_11.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_11.setBounds(472, 395, 127, 27);
		contentPane.add(lblNewLabel_11);
		
		units = new JTextField();
		units.setBounds(645, 395, 96, 26);
		contentPane.add(units);
		units.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Update");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				
				//Class.forName("com.mysql.jdbc.Driver");  
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bdm","root","viggy");
				PreparedStatement smt=con.prepareStatement("update request set hospitalId=?,bloodGroup=?,units=? where requestId=?");
				smt.setString(1,hid.getText());
				smt.setString(2, bloodGroup.getText());
				smt.setString(3,units.getText());
				smt.setString(4, rid.getText());
				smt.executeUpdate();
				con.close();
				
			}
				catch(Exception exe)
				{
					
				}
			}
		});
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_2.setBounds(58, 461, 85, 21);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Close");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton_3.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_3.setBounds(671, 461, 85, 21);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel_12 = new JLabel("Request ID");
		lblNewLabel_12.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_12.setBounds(35, 36, 92, 22);
		contentPane.add(lblNewLabel_12);
		
		rid = new JTextField();
		rid.setBounds(125, 39, 66, 19);
		contentPane.add(rid);
		rid.setColumns(10);
		
		JButton btnNewButton_4 = new JButton("Search");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//Class.forName("com.mysql.jdbc.Driver");  
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bdm","root","viggy"); 
					PreparedStatement smt=con.prepareStatement("select s.name,s.phoneNo as sphoneNo,s.gender,s.address as saddress,h.hospitalName,h.phoneNo as hphoneNo,h.address as haddress,requestId,r.seekerId,r.hospitalId,bloodGroup,units from seeker s inner join request r on s.seekerId=r.seekerId inner join hospital h on h.hospitalId=r.hospitalId where requestId=?");
					smt.setString(1, rid.getText());
					ResultSet rs=smt.executeQuery();
					if(rs.next()) {
						sid.setText(rs.getString("r.seekerId"));
						sname.setText(rs.getString("s.name"));
						sphone.setText(rs.getString("sphoneNo"));
						sgender.setText(rs.getString("s.gender"));
						saddress.setText(rs.getString("saddress"));
						hid.setText(rs.getString("r.hospitalId"));
						hname.setText(rs.getString("h.hospitalName"));
						hphone.setText(rs.getString("hphoneNo"));
						haddress.setText(rs.getString("haddress"));
						bloodGroup.setText(rs.getString("bloodGroup"));
						units.setText(rs.getString("units"));
								
					}
				}
				catch(Exception exe)
				{
					
				}
			}
		});
		btnNewButton_4.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_4.setBounds(209, 38, 85, 21);
		contentPane.add(btnNewButton_4);
		
		bloodGroup = new JTextField();
		bloodGroup.setBounds(173, 402, 96, 20);
		contentPane.add(bloodGroup);
		bloodGroup.setColumns(10);
		
		JButton btnNewButton = new JButton("Delete");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//Class.forName("com.mysql.jdbc.Driver");  
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bdm","root","viggy"); 
					PreparedStatement smt=con.prepareStatement("delete from request where requestId=?");
					smt.setString(1,rid.getText());
					smt.executeUpdate();
					con.close();

				}
				catch(Exception exe)
				{
					
				}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton.setBounds(372, 461, 85, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Search");
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//Class.forName("com.mysql.jdbc.Driver");  
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bdm","root","viggy"); 
					PreparedStatement smt=con.prepareStatement("select * from hospital where hospitalId=?");
					smt.setString(1,hid.getText());
					ResultSet rs=smt.executeQuery();
					if(rs.next())
					{
						hid.setText(rs.getString("hospitalId"));
						hname.setText(rs.getString("hospitalName"));
						hphone.setText(rs.getString("phoneNo"));
						haddress.setText(rs.getString("address"));
					}
					con.close();
					
				}
				catch(Exception exe)
				{
					System.out.println(exe);
				}
			}
		});
		btnNewButton_1.setBounds(656, 83, 85, 21);
		contentPane.add(btnNewButton_1);
	}
}
