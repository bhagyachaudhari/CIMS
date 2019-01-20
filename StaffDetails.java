import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import java.util.Calendar;

public class StaffDetails extends JInternalFrame implements ActionListener,KeyListener
{
	Container cp;
	JLabel lstaffid,lstaffcd,lnm,lgen,lqlf,ladd,lphno,ldes,lfac,lsal;
	JTextField tstaffid,tnm,tqlf,tphno,tdes,tsal;
	JTextArea tadd;
	JButton breset,bupd,bsv,bcls,bdel;
	JRadioButton r1,r2;
	JComboBox cb1,cb2;
	ButtonGroup bg;
	JPanel jp1,jp2;
	JScrollPane jsp;
	Connection con;
	Dimension dim;

	Font f1=new Font("Cambria",Font.BOLD,14);
	Font f2=new Font("Cambria",Font.BOLD,14);

	StaffDetails()
	{
		cp=getContentPane();
		cp.setLayout(null);
		dim=new Dimension();
		dim=Toolkit.getDefaultToolkit().getScreenSize();

		jp1=new JPanel();
		jp1.setBounds(10,10,560,400);
		jp1.setBorder(BorderFactory.createLineBorder(Color.white,1));
		jp1.setBackground(Color.decode("#200000")); 
	
		jp2=new JPanel();
		jp2.setBounds(10,420,560,45);
		jp2.setBorder(BorderFactory.createLineBorder(Color.white,1));
		jp2.setBackground(Color.decode("#200000")); 
		
		/**********************************Labels****************************/
		lstaffid=new JLabel("Staff ID: ");
		lstaffcd=new JLabel("Staff Code: ");
		lnm=new JLabel("Name: ");
		lgen=new JLabel("Gender: ");
		lqlf=new JLabel("Qualification: ");
		ladd=new JLabel("Address: ");
		lphno=new JLabel("Phon No: ");
		ldes=new JLabel("Designation: ");
		lfac=new JLabel("Faculty: ");
		lsal=new JLabel("Salary: ");
	
		/**********************************Text Fields**************************/
		tstaffid=new JTextField(20);
		tnm=new JTextField(20);
		tqlf=new JTextField(20);
		tphno=new JTextField(20);		
		tdes=new JTextField(20);		
		tsal=new JTextField(20);				
		
		/***********************************Text Area****************************/
		tadd=new JTextArea(20,5);
		jsp=new JScrollPane(tadd);
		tadd.setFont(f2);
		tadd.setForeground(Color.black);
		
	
		/************************************Buttons******************************/
		breset=new JButton("RESET");
		bupd=new JButton("UPDATE");		
		bsv=new JButton("SAVE");					
		bcls=new JButton("CLOSE");	
		bdel=new JButton("DELETE");	
		/**************************************Radio Button***********************/			
		
		r1=new JRadioButton("Male");
		r2=new JRadioButton("Female");
	
		cb1=new JComboBox();
		cb1.addItem("");
		cb1.addItem("T1");
		cb1.addItem("T2");	
		cb1.addItem("T3");
		cb1.addItem("T4");
		
		cb2=new JComboBox();
		cb2.addItem("");
		cb2.addItem("Certificate Courses");
		cb2.addItem("Modular Courses");
		/***************************************************************************************************/

		cp.add(lstaffid);
		lstaffid.setBounds(25,30,90,30);
		lstaffid.setFont(f1);
		lstaffid.setForeground(Color.decode("#FFFFFF"));
		cp.add(tstaffid);
		tstaffid.setBounds(135,35,100,22);
		tstaffid.setFont(f2);
		tstaffid.setForeground(Color.black);
		tstaffid.setBorder(BorderFactory.createLineBorder(Color.black,1));

		cp.add(lstaffcd);
		lstaffcd.setBounds(25,60,90,30);
		lstaffcd.setFont(f1);
		lstaffcd.setForeground(Color.decode("#FFFFFF"));
		cp.add(cb1);
		cb1.setBounds(135,65,100,22);
		cb1.setFont(f2);
		cb1.setForeground(Color.black);
		cb1.setBorder(BorderFactory.createLineBorder(Color.black,1));

		cp.add(lnm);
		lnm.setBounds(25,90,60,30);
		lnm.setFont(f1);
		lnm.setForeground(Color.decode("#FFFFFF"));
		cp.add(tnm);
		tnm.setBounds(135,95,180,22);
		tnm.setFont(f2);
		tnm.setForeground(Color.black);
		tnm.setBorder(BorderFactory.createLineBorder(Color.black,1));

		cp.add(lgen);
		lgen.setBounds(25,120,60,30);
		lgen.setFont(f1);
		lgen.setForeground(Color.decode("#FFFFFF"));
		cp.add(r1);
		r1.setBounds(135,120,60,30);
		r1.setFont(f1);
		r1.setBackground(Color.decode("#200000"));
		r1.setForeground(Color.decode("#FFFFFF"));
		cp.add(r2);
		r2.setBounds(205,120,100,30);
		r2.setFont(f1);
		r2.setBackground(Color.decode("#200000"));
		r2.setForeground(Color.decode("#FFFFFF"));
		
		cp.add(lqlf);
		lqlf.setBounds(25,150,100,30);
		lqlf.setFont(f1);
		lqlf.setForeground(Color.decode("#FFFFFF"));
		cp.add(tqlf);
		tqlf.setBounds(135,160,180,22);
		tqlf.setFont(f2);
		tqlf.setForeground(Color.black);
		tqlf.setBorder(BorderFactory.createLineBorder(Color.black,1));
		
		cp.add(ladd);
		ladd.setBounds(25,190,60,30);
		ladd.setFont(f1);
		ladd.setForeground(Color.decode("#FFFFFF"));
		cp.add(jsp);
		jsp.setBounds(135,195,180,70);
		jsp.setBorder(BorderFactory.createLineBorder(Color.black,1));
		
					
		cp.add(lphno);
		lphno.setBounds(25,270,90,30);
		lphno.setFont(f1);
		lphno.setForeground(Color.decode("#FFFFFF"));
		cp.add(tphno);
		tphno.setBounds(135,275,150,22);
		tphno.setFont(f2);
		tphno.setForeground(Color.black);
		tphno.setBorder(BorderFactory.createLineBorder(Color.black,1));
				
		cp.add(ldes);
		ldes.setBounds(25,300,90,30);
		ldes.setFont(f1);
		ldes.setForeground(Color.decode("#FFFFFF"));
		cp.add(tdes);
		tdes.setBounds(135,305,180,22);
		tdes.setFont(f2);
		tdes.setForeground(Color.black);
		tdes.setBorder(BorderFactory.createLineBorder(Color.black,1));
			
		cp.add(lfac);
		lfac.setBounds(25,330,90,30);
		lfac.setFont(f1);
		lfac.setForeground(Color.decode("#FFFFFF"));
		cp.add(cb2);
		cb2.setBounds(135,335,180,22);
		cb2.setFont(f2);
		cb2.setForeground(Color.black);
		cb2.setBorder(BorderFactory.createLineBorder(Color.black,1));
	
		cp.add(lsal);
		lsal.setBounds(25,360,90,30);
		lsal.setFont(f1);
		lsal.setForeground(Color.decode("#FFFFFF"));
		cp.add(tsal);
		tsal.setBounds(135,365,180,22);
		tsal.setFont(f2);
		tsal.setForeground(Color.black);
		tsal.setBorder(BorderFactory.createLineBorder(Color.black,1));
		cp.add(jp1);
								
		cp.add(bupd);
		bupd.setBounds(35,430,70,25);
		bupd.setFont(f1);
		bupd.setBorder(BorderFactory.createLineBorder(Color.white,1));
		bupd.setBackground(Color.black);
		bupd.setForeground(Color.red);

		cp.add(bsv);	
		bsv.setBounds(145,430,70,25);
		bsv.setFont(f1);
		bsv.setBorder(BorderFactory.createLineBorder(Color.white,1));
		bsv.setBackground(Color.black);
		bsv.setForeground(Color.red);

		cp.add(breset);
		breset.setBounds(255,430,70,25);
		breset.setFont(f1);
		breset.setBorder(BorderFactory.createLineBorder(Color.white,1));
		breset.setBackground(Color.black);
		breset.setForeground(Color.red);

		
		cp.add(bdel);		
		bdel.setBounds(365,430,70,25);
		bdel.setFont(f1);
		bdel.setBorder(BorderFactory.createLineBorder(Color.white,1));
		bdel.setBackground(Color.black);
		bdel.setForeground(Color.red);


		cp.add(bcls);	
		bcls.setBounds(475,430,70,25);
		bcls.setFont(f1);
		bcls.setBorder(BorderFactory.createLineBorder(Color.white,1));
		bcls.setBackground(Color.black);
		bcls.setForeground(Color.red);

		cp.add(jp2);

		bupd.addActionListener(this);
		bsv.addActionListener(this);
		breset.addActionListener(this);
		bdel.addActionListener(this);
		bcls.addActionListener(this);
	
		tstaffid.addKeyListener(this);
		tnm.addKeyListener(this);
		tqlf.addKeyListener(this);
		tphno.addKeyListener(this);
		tdes.addKeyListener(this);
		tsal.addKeyListener(this);
		
		bupd.setToolTipText("Update the Records");
		bsv.setToolTipText("Save the Records");
		bcls.setToolTipText("Close form");
		breset.setToolTipText("Clear");
		bdel.setToolTipText("Delete the Records");
		
		bg=new ButtonGroup();
		bg.add(r1);
		bg.add(r2);

		setBounds(245,100,(dim.width-300),(dim.height-115)); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setIconifiable(true);
		setClosable(true);	
		setVisible(true);
		setSize(590,510);
		cp.setBackground(Color.black);
		setTitle("Staff Details");

		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			System.out.println("Driver Loaded!");
		
			con=DriverManager.getConnection("jdbc:odbc:CompDSN");
			System.out.println("Connection Established!");
	
			Statement st=con.createStatement();
                                   	ResultSet rs=st.executeQuery("select * from staff");
                                  	while(rs.next())
                                 	{
                                   		int no=rs.getInt(1);
                                   		no++;
                                   		tstaffid.setText(""+no);
                                 	}
		}
		catch(Exception e) {}

	}
	public void actionPerformed(ActionEvent ae)
	{
	
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			System.out.println("Driver Loaded!");
			
			 con=DriverManager.getConnection("jdbc:odbc:CompDSN");
			System.out.println("Connection Established!");
		}
		catch(Exception e) {}
		/********************************Code For Close the Window***********************************/
		if(ae.getSource()==bcls)
		{
			int res=JOptionPane.showConfirmDialog((Component)null,"Are you sure to close?","Close",JOptionPane.YES_NO_OPTION);
			if(res==JOptionPane.YES_OPTION)
			{
				setVisible(false);
				dispose();	
			}
			else if(res==JOptionPane.NO_OPTION)
			{
			}
		}

		
		/***********************************Reset the Form****************************************/
		if(ae.getSource()==breset)
		{
			tstaffid.setText("");
			cb1.setSelectedIndex(0); 
			tnm.setText("");
			tqlf.setText("");
			tphno.setText("");
			tdes.setText("");
			cb2.setSelectedIndex(0); 
			tsal.setText("");
			tadd.setText("");
			bg.clearSelection();
			tstaffid.requestFocus();

			try
			{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				System.out.println("Driver Loaded!");
			
				con=DriverManager.getConnection("jdbc:odbc:CompDSN");
				System.out.println("Connection Established!");
	
				Statement st=con.createStatement();
                                   		ResultSet rs=st.executeQuery("select * from staff");
                                  		while(rs.next())
                                 		{
                                   			int no=rs.getInt(1);
                                   			no++;
                                   			tstaffid.setText(""+no);
                                 		}
			}
			catch(Exception e) {}
		}
		


		/**********************************Code for Saving the Application*********************************/
		
		if(ae.getSource()==bsv)
		{
			try
			{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				System.out.println("Driver Loaded!");
			
				con=DriverManager.getConnection("jdbc:odbc:CompDSN");
				System.out.println("Connection Established!");
			}
			catch(Exception e) {}
			if(tstaffid.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this,"Please Enter Staff ID","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(cb1.getSelectedIndex()==0)
			{
				JOptionPane.showMessageDialog(this,"Please Select Staff Code","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}
		
			if(tnm.getText().equals(""))  
			{
				JOptionPane.showMessageDialog(this,"Please Enter Staff Name","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(tqlf.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this,"Please Enter Qualification","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(tphno.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this,"Please Enter Phone No","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(tdes.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this,"Please Enter Designation","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(cb2.getSelectedIndex()==0)
			{
				JOptionPane.showMessageDialog(this,"Please Select Faculty","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(tsal.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this,"Please Enter Salary","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(r1.isSelected()==false && r2.isSelected()==false)
			{
				JOptionPane.showMessageDialog(this,"Please Select Gender","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(tadd.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this,"Please Enter Address","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}

			try
			{
				PreparedStatement st=con.prepareStatement("insert into staff values(?,?,?,?,?,?,?,?,?,?)");
				st.setString(1,tstaffid.getText());  //tstaffid,tnm,tqlf,tphno,tdes,tfac,tsal,tadd,cb1
				st.setString(2,(String)cb1.getSelectedItem());
				st.setString(3,tnm.getText());
				if(r1.isSelected()==true)
				{
					st.setString(4,"Male");
				}
				else
				{
					st.setString(4,"Female");
				}				

				st.setString(5,tqlf.getText());
				st.setString(6,tadd.getText());
				st.setString(7,tphno.getText());
				st.setString(8,tdes.getText());
				st.setString(9,(String)cb2.getSelectedItem());	
				st.setString(10,tsal.getText());	
				st.executeUpdate();
				JOptionPane.showMessageDialog(null,"Staff Details Saved Successfully!");
				tstaffid.setText("");
				cb1.setSelectedIndex(0); 
				tnm.setText("");
				tqlf.setText("");
				tphno.setText("");
				tdes.setText("");
				cb2.setSelectedIndex(0); 
				tsal.setText("");
				tadd.setText("");
				bg.clearSelection();
				tstaffid.requestFocus();
				try
				{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				System.out.println("Driver Loaded!");
			
				con=DriverManager.getConnection("jdbc:odbc:CompDSN");
				System.out.println("Connection Established!");
	
				Statement st1=con.createStatement();
                                   		ResultSet rs1=st1.executeQuery("select * from staff");
                                  		while(rs1.next())
                                 		{
                                   			int no=rs1.getInt(1);
                                   			no++;
                                   			tstaffid.setText(""+no);
                                 		}
			}
			catch(Exception e) {}
			}
			catch(Exception e) {}
		}
		/***********************************Code for Update the Application***************************/
		if(ae.getSource()==bupd)
		{
			try
			{		
				PreparedStatement st=con.prepareStatement("UPDATE staff set Staff_Code=?,Staff_Name=?,Gender=?,Qualification=?,Address=?,Phone_No=?,Designation=?,Faculty=?,Salary=? WHERE Staff_ID=?");
					
				st.setString(1,(String)cb1.getSelectedItem());						
				st.setString(2,tnm.getText());
				if(r1.isSelected()==true)
				{
					st.setString(3,"Male");
				}
				else
				{
					st.setString(3,"Female");
				}
				st.setString(4,tqlf.getText());
				st.setString(5,tadd.getText());
				st.setString(6,tphno.getText());
				st.setString(7,tdes.getText());
				st.setString(8,(String)cb2.getSelectedItem());	
				st.setString(9,tsal.getText());		
				st.setString(10,tstaffid.getText());

				st.executeUpdate();
				JOptionPane.showMessageDialog(null,"Updated!");
				tstaffid.setText("");
				cb1.setSelectedIndex(0); 
				tnm.setText("");
				tqlf.setText("");
				tphno.setText("");
				tdes.setText("");
				cb2.setSelectedIndex(0); 
				tsal.setText("");
				tadd.setText("");
				bg.clearSelection();
				tstaffid.requestFocus();
				try
				{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				System.out.println("Driver Loaded!");
			
				con=DriverManager.getConnection("jdbc:odbc:CompDSN");
				System.out.println("Connection Established!");
	
				Statement st1=con.createStatement();
                                   		ResultSet rs1=st1.executeQuery("select * from staff");
                                  		while(rs1.next())
                                 		{
                                   			int no=rs1.getInt(1);
                                   			no++;
                                   			tstaffid.setText(""+no);
                                 		}
			}
			catch(Exception e) {}
			}
			catch(Exception e) 
			{
				System.out.println("error");
			}
		}
			
		/**************************************Delete the Application********************************************/
		
		else if(ae.getSource()==bdel)
		{
			int res=JOptionPane.showConfirmDialog((Component)null,"Are you sure to delete the Staff Details at Staff ID "+Integer.parseInt(tstaffid.getText()),"Delete",JOptionPane.YES_NO_OPTION);
			
			if(res==JOptionPane.YES_OPTION)
			{
				try
				{
			
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					System.out.println("Driver Loaded!");
			
					con=DriverManager.getConnection("jdbc:odbc:CompDSN");
					System.out.println("Connection Established!");

					PreparedStatement st=con.prepareStatement("delete from staff where Staff_ID= "+Integer.parseInt(tstaffid.getText()));
					st.executeUpdate();
					JOptionPane.showMessageDialog(this,"Deleted the Record at Staff ID "+(tstaffid.getText())+" Successfully!");
				}
				catch(Exception e) {}
			}
			else if(res==JOptionPane.NO_OPTION)
			{
			}	 
		}
		else
		{
		}

	}
	public void keyTyped(KeyEvent ke)
	{
		char s=ke.getKeyChar();

		if(ke.getSource()==tphno||ke.getSource()==tstaffid||ke.getSource()==tsal)
		{
			if(!(Character.isDigit(s)||(s==ke.VK_BACK_SPACE)))
			{
				JOptionPane.showMessageDialog(this,"Character are not allowed","Error",JOptionPane.ERROR_MESSAGE);
				ke.consume();
			}
		}
		if(ke.getSource()==tnm || ke.getSource()==tadd || ke.getSource()==tqlf ||  ke.getSource()==tdes)
		{
			if(s>47&&s<58)  
			{
				JOptionPane.showMessageDialog(this,"Digits are not allowed","Error",JOptionPane.ERROR_MESSAGE);
				ke.consume();
			}
		}
	}
	
		
	public void keyReleased(KeyEvent ke)
	{
	}
	public void keyPressed(KeyEvent ke)
	{
	}
	
	public static void main(String args[])
	{
		new StaffDetails();
	}
}


		
							

					
		
					
			
					
						

				
	
	
	
	
	
	

	
		
	
		
	
		
		

	
		
	
	
	

				
	

	

		
		
		
		
		
		
		
		
	
		
		
		
		
		
		
		
		
			
	
	
	
	
	
	
	