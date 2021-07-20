package bdm;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Home implements ActionListener{
JMenuBar mb;
JMenu donor,search,stock,del,exit;
JMenuItem i1,i2,i4,s1,s2,s4,t1,t2,t3,d1,e1,e2,e4;
private JMenu mnNewMenu_1;
private JMenuItem mntmNewMenuItem_3;

	public Home() {
		JFrame f=new JFrame();
		
		mb=new JMenuBar();
		
		donor =new JMenu("Seeker");
		donor.setFont(new Font("Times New Roman", Font.BOLD, 17));
		i1=new JMenuItem("Add New ");
		i1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		i1.addActionListener(this);
		i2=new JMenuItem("Update/Delete");
		i2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Update().setVisible(true);
			}
		});
		i2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		
		i4=new JMenuItem("View All");
		i4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AllSeekerDetails().setVisible(true);
			}
		});
		i4.setFont(new Font("Times New Roman", Font.BOLD, 15));
		
		
		search =new JMenu("Hospital");
		search.setFont(new Font("Times New Roman", Font.BOLD, 17));
		s1=new JMenuItem("Add");
		s1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddHos().setVisible(true);
			}
		});
		s1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		
		s2=new JMenuItem("Update/Delete");
		s2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UpdateHos().setVisible(true);
			}
		});
		s2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		
		s4=new JMenuItem("View All");
		s4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AllHosDetails().setVisible(true);
			}
		});
		s4.setFont(new Font("Times New Roman", Font.BOLD, 15));
		
		
		stock =new JMenu("Search");
		stock.setFont(new Font("Times New Roman", Font.BOLD, 17));
		t1=new JMenuItem("Location");
		t1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SearchByLocation().setVisible(true);
				
			}
		});
		t1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		
		t2=new JMenuItem("Blood Group");
		t2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SearchByBloodG().setVisible(true);
			}
		});
		t2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		
		
		del =new JMenu("Blood Stock");
		del.setFont(new Font("Times New Roman", Font.BOLD, 17));
		d1=new JMenuItem("Increase/Decrease");
		d1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new IncreaseStock().setVisible(true);
			}
		});
		d1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		
		
		exit =new JMenu("Donor");
		exit.setFont(new Font("Times New Roman", Font.BOLD, 17));
		e1=new JMenuItem("Add");
		e1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddDonor().setVisible(true);
			}
		});
		e1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		
		e2=new JMenuItem("Update/Delete");
		e2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UpdateDonor().setVisible(true);
			}
		});
		e2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		
		e4=new JMenuItem("View All");
		e4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AllDonorDetails().setVisible(true);
			}
		});
		e4.setFont(new Font("Times New Roman", Font.BOLD, 15));
		
		
		exit.add(e1);
		exit.add(e2);
		exit.add(e4);
		
		del.add(d1);
		
		
		stock.add(t1);
		stock.add(t2);
		//stock.add(t3);
		
		donor.add(i1);
		donor.add(i2);
		donor.add(i4);
		
		search.add(s1);
		search.add(s2);
		search.add(s4);
		
		mb.add(donor);
		mb.add(search);
		mb.add(stock);
		mb.add(del);
		
		JMenu mnNewMenu = new JMenu("Request");
		mnNewMenu.setFont(new Font("Times New Roman", Font.BOLD, 17));
		mb.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Add");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new request().setVisible(true);
			}
		});
		mntmNewMenuItem.setFont(new Font("Times New Roman", Font.BOLD, 15));
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Update/Delete");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new updateDeleteReq().setVisible(true);
			}
		});
		mntmNewMenuItem_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("View Requests");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new viewrequest().setVisible(true);
			}
		});
		mntmNewMenuItem_4.setFont(new Font("Times New Roman", Font.BOLD, 15));
		mnNewMenu.add(mntmNewMenuItem_4);
		mb.add(exit);
		
		f.setJMenuBar(mb);
		
		mnNewMenu_1 = new JMenu("Exit");
		
		mnNewMenu_1.setFont(new Font("Times New Roman", Font.BOLD, 17));
		mb.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("LogOut");
		mntmNewMenuItem_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					int a=JOptionPane.showConfirmDialog(null,"Do you really want to logout?","Select",JOptionPane.YES_NO_OPTION);
					if(a==0)
					{
						setVisible(false);
						new logIn1().setVisible(true);
					}
				}
			
		});
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		mntmNewMenuItem_3 = new JMenuItem("Exit");
		mntmNewMenuItem_3.setFont(new Font("Times New Roman", Font.BOLD, 15));
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a=JOptionPane.showConfirmDialog(null,"Do you really want to Close the application?","Select",JOptionPane.YES_NO_OPTION);
				if(a==0)
				{
					System.exit(0);
				}
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_3);
		f.setSize(1535,882);
		f.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Krishna\\Downloads\\wp4323461-blood-donation-wallpapers.png"));
		lblNewLabel.setBounds(0, 0, 1540, 782);
		f.getContentPane().add(lblNewLabel);
		f.setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		new Add().setVisible(true);
		
	}

	public static void main(String[] args) {
		new Home();

	}
	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
