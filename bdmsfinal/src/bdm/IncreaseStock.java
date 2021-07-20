package bdm;
import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class IncreaseStock extends JFrame {

	private JPanel contentPane;
	private JTextField units;
	private JTable table;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IncreaseStock frame = new IncreaseStock();
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
	public IncreaseStock() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 868, 514);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Stock Increase/ Decrease");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel.setBounds(292, 31, 362, 44);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Blood Group");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1.setBounds(36, 105, 92, 32);
		contentPane.add(lblNewLabel_1);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-"}));
		comboBox.setBounds(180, 105, 55, 28);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_2 = new JLabel("Units");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_2.setBounds(348, 105, 49, 24);
		contentPane.add(lblNewLabel_2);
		
		units = new JTextField();
		units.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		units.setBounds(415, 105, 96, 27);
		contentPane.add(units);
		units.setColumns(10);
		
			
		
		
		JButton increase = new JButton("Increase");
		increase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//String bloodGroup=(String)JComboBox.getSelectedItem();
				try {
					//Class.forName("com.mysql.jdbc.Driver");  
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bdm","root","viggy"); 
					PreparedStatement smt=con.prepareStatement("update stock set units=units+? where bloodGroup=?");
					smt.setString(1,units.getText());
					smt.setString(2,(String)comboBox.getSelectedItem());
					smt.executeUpdate();
					con.close();
					units.setText("");
					viewtable();
				}
				catch(Exception exe)
				{
					
				}
				
			}
		});
		increase.setFont(new Font("Times New Roman", Font.BOLD, 15));
		increase.setBounds(545, 107, 109, 30);
		contentPane.add(increase);
		
		JButton btnNewButton_1 = new JButton("Close");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_1.setBounds(706, 439, 85, 28);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Print");
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_2.setBounds(72, 438, 85, 27);
		contentPane.add(btnNewButton_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 152, 784, 244);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton decrease = new JButton("Decrease");
		decrease.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//Class.forName("com.mysql.jdbc.Driver");  
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bdm","root","viggy"); 
					PreparedStatement smt=con.prepareStatement("update stock set units=units-? where bloodGroup=?");
					smt.setString(1,units.getText());
					smt.setString(2,(String)comboBox.getSelectedItem());
					smt.executeUpdate();
					con.close();
					units.setText("");
					viewtable();
				}
				catch(Exception exe)
				{
					
				}
			}
		});
		decrease.setFont(new Font("Times New Roman", Font.BOLD, 15));
		decrease.setBounds(678, 105, 113, 32);
		contentPane.add(decrease);
		
		viewtable();
	}


	private void viewtable() {
		// TODO Auto-generated method stub
		try
		{
			//Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bdm","root","viggy"); 
			Statement smt=con.createStatement();
			ResultSet rs=smt.executeQuery("select bloodGroup as BloodGroup, units as Units from stock");
			table.setModel(DbUtils.resultSetToTableModel(rs));
		}
		catch(Exception exe)
		{
			
		}
	}
}
