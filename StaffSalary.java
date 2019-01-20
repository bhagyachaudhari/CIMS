import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import java.util.Calendar;
import java.io.*;

public class StaffSalary extends JFrame implements ActionListener
{
	Container cp;
	JLabel lstaffid,ldt,lpayslipno,lstaffnm,lsalary,ladd;
	JTextField tstaffid,tdt,tpayslipno,tstaffnm,tsalary,tadd;
	JButton breset,bupd,bsv,bcls,bdel,bprint,bsearch;
	JPanel jp1,jp2;
	Connection con;
	Dimension dim;
	
	Font f1=new Font("Cambria",Font.BOLD,14);
	Font f2=new Font("Cambria",Font.BOLD,14);
	
	StaffSalary()
	{
		cp=getContentPane();
		cp.setLayout(null);
		dim=new Dimension();
		dim=Toolkit.getDefaultToolkit().getScreenSize();
		java.util.Date currDate=new java.util.Date();
		SimpleDateFormat sdf=new SimpleDateFormat("dd"+"/"+"MM"+"/"+"yyyy",Locale.getDefault());
		String d=sdf.format(currDate);
		
		jp1=new JPanel();
		jp1.setBounds(10,10,560,190);
		jp1.setBorder(BorderFactory.createLineBorder(Color.white,1));
		jp1.setBackground(Color.decode("#200000"));
	
		jp2=new JPanel();
		jp2.setBounds(10,210,560,80);
		jp2.setBorder(BorderFactory.createLineBorder(Color.white,1));
		jp2.setBackground(Color.decode("#200000")); 
		
		/**********************************Labels****************************/
		lstaffid=new JLabel("Staff ID: ");     
		ldt=new JLabel("Date: ");
		lpayslipno=new JLabel("Payslip No: ");
		lstaffnm=new JLabel("Staff Name: ");
		ladd=new JLabel("Address: ");
		lsalary=new JLabel("Salary: ");
	
		/**********************************Text Fields**************************/
		tdt=new JTextField(20);
		tstaffid=new JTextField(20);
		tpayslipno=new JTextField(20);	
		tstaffnm=new JTextField(20);	
		tadd=new JTextField(20);		
		tsalary=new JTextField(20);					
	
		/************************************Buttons******************************/
		breset=new JButton("RESET");
		bupd=new JButton("UPDATE");		
		bsv=new JButton("SAVE");					
		bcls=new JButton("CLOSE");	
		bdel=new JButton("DELETE");	
		bprint=new JButton("PRINT");	
		bsearch=new JButton("SEARCH");	
/***************************************************************************************************************************/
		cp.add(lstaffid);
		lstaffid.setBounds(25,30,90,30);
		lstaffid.setFont(f1);
		lstaffid.setForeground(Color.decode("#FFFFFF"));
		cp.add(tstaffid);
		tstaffid.setBounds(135,35,100,22);
		tstaffid.setFont(f2);
		tstaffid.setForeground(Color.black);
		tstaffid.setBorder(BorderFactory.createLineBorder(Color.black,1));

		cp.add(ldt);
		ldt.setBounds(300,30,90,30);
		ldt.setFont(f1);
		ldt.setForeground(Color.decode("#FFFFFF"));
		cp.add(tdt);
		tdt.setBounds(350,35,100,22);
		tdt.setFont(f2);
		tdt.setForeground(Color.black);
		tdt.setBorder(BorderFactory.createLineBorder(Color.black,1));

		cp.add(lpayslipno);
		lpayslipno.setBounds(25,60,100,30);
		lpayslipno.setFont(f1);
		lpayslipno.setForeground(Color.decode("#FFFFFF"));
		cp.add(tpayslipno);
		tpayslipno.setBounds(135,65,100,22);
		tpayslipno.setFont(f2);
		tpayslipno.setForeground(Color.black);
		tpayslipno.setBorder(BorderFactory.createLineBorder(Color.black,1));
	
		cp.add(lstaffnm);
		lstaffnm.setBounds(25,90,100,30);
		lstaffnm.setFont(f1);
		lstaffnm.setForeground(Color.decode("#FFFFFF"));
		cp.add(tstaffnm);
		tstaffnm.setBounds(135,95,250,22);
		tstaffnm.setFont(f2);
		tstaffnm.setForeground(Color.black);
		tstaffnm.setBorder(BorderFactory.createLineBorder(Color.black,1));
		
		cp.add(ladd);
		ladd.setBounds(25,120,60,30);
		ladd.setFont(f1);
		ladd.setForeground(Color.decode("#FFFFFF"));
		cp.add(tadd);
		tadd.setBounds(135,125,250,22);
		tadd.setFont(f2);
		tadd.setForeground(Color.black);
		tadd.setBorder(BorderFactory.createLineBorder(Color.black,1));
		
					
		cp.add(lsalary);
		lsalary.setBounds(25,150,90,30);
		lsalary.setFont(f1);
		lsalary.setForeground(Color.decode("#FFFFFF"));
		cp.add(tsalary);
		tsalary.setBounds(135,155,250,22);
		tsalary.setFont(f2);
		tsalary.setForeground(Color.black);
		tsalary.setBorder(BorderFactory.createLineBorder(Color.black,1));
				
		cp.add(jp1);
								
		cp.add(bupd);
		bupd.setBounds(25,220,80,25);
		bupd.setFont(f1);
		bupd.setBorder(BorderFactory.createLineBorder(Color.white,1));
		bupd.setBackground(Color.black);
		bupd.setForeground(Color.red);
			
		cp.add(bsv);	
		bsv.setBounds(125,220,70,25);
		bsv.setFont(f1);
		bsv.setBorder(BorderFactory.createLineBorder(Color.white,1));
		bsv.setBackground(Color.black);
		bsv.setForeground(Color.red);
		
		cp.add(breset);
		breset.setBounds(220,220,70,25);
		breset.setFont(f1);
		breset.setBorder(BorderFactory.createLineBorder(Color.white,1));
		breset.setBackground(Color.black);
		breset.setForeground(Color.red);

		cp.add(bdel);		
		bdel.setBounds(315,220,70,25);
		bdel.setFont(f1);
		bdel.setBorder(BorderFactory.createLineBorder(Color.white,1));
		bdel.setBackground(Color.black);
		bdel.setForeground(Color.red);

		cp.add(bsearch);		
		bsearch.setBounds(405,220,70,25);
		bsearch.setFont(f1);
		bsearch.setBorder(BorderFactory.createLineBorder(Color.white,1));
		bsearch.setBackground(Color.black);
		bsearch.setForeground(Color.white);

		cp.add(bcls);	
		bcls.setBounds(495,220,70,25);
		bcls.setFont(f1);
		bcls.setBorder(BorderFactory.createLineBorder(Color.white,1));
		bcls.setBackground(Color.black);
		bcls.setForeground(Color.red);
		
		cp.add(bprint);	
		bprint.setBounds(268,255,70,25);
		bprint.setFont(f1);
		bprint.setBorder(BorderFactory.createLineBorder(Color.white,1));
		bprint.setBackground(Color.black);
		bprint.setForeground(Color.white);
		

		cp.add(jp2);
		tdt.setText(""+d);  //Add date into the text field
		
		bsv.addActionListener(this);
		bupd.addActionListener(this);
		breset.addActionListener(this);
		bdel.addActionListener(this);
		bcls.addActionListener(this);
		bprint.addActionListener(this);
		bsearch.addActionListener(this); 
		
		
	
		bupd.setToolTipText("Update the Records");
		bsv.setToolTipText("Save the Records");
		bcls.setToolTipText("Close form");
		breset.setToolTipText("Clear");
		bdel.setToolTipText("Delete the Records");
		bsearch.setToolTipText("Search the Records");
		bprint.setToolTipText("Print the Records");

		cp.setBackground(Color.black);
		setBounds(245,100,(dim.width-300),(dim.height-115));  
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		//setIconifiable(true);
		//setClosable(true);	
		setVisible(true);
		setSize(590,335);
		setTitle("Staff Salary Receipt");

		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			System.out.println("Driver Loaded!");
		
			con=DriverManager.getConnection("jdbc:odbc:CompDSN");
			System.out.println("Connection Established!");
	
			Statement st=con.createStatement();
                                   	ResultSet rs=st.executeQuery("select * from salary");
                                  	while(rs.next())
                                 	{
                                   		int no=rs.getInt(1);
                                   		no++;
                                   		tstaffid.setText(""+no);

				int pno=rs.getInt(3);
                                   		pno++;
                                   		tpayslipno.setText(""+pno);
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
			tpayslipno.setText("");
			tstaffnm.setText("");
			tsalary.setText("");
			tadd.setText("");
			tstaffid.requestFocus();
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
				JOptionPane.showMessageDialog(this,"Please Enter Student ID","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}
		
			if(tpayslipno.getText().equals(""))  
			{
				JOptionPane.showMessageDialog(this,"Please Enter Receipt No","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(tstaffnm.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this,"Please Enter Name","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}

			if(tsalary.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this,"Please Enter Drawn Date","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(tadd.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this,"Please Enter Address","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(tdt.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this,"Please Enter Date","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}

			try
			{
				PreparedStatement st=con.prepareStatement("insert into salary values(?,?,?,?,?,?)");
				st.setString(1,tstaffid.getText());  
				st.setString(2,tdt.getText());
				st.setString(3,tpayslipno.getText()); 
				st.setString(4,tstaffnm.getText());
				st.setString(5,tadd.getText());
				st.setString(6,tsalary.getText());

				st.executeUpdate();
				JOptionPane.showMessageDialog(null,"Staff Salary Details Saved Successfully!");

				tstaffid.setText("");   
				tpayslipno.setText("");
				tstaffnm.setText("");
				tsalary.setText("");
				tadd.setText("");
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

				int pno=rs1.getInt(3);
                                   		pno++;
                                   		tpayslipno.setText(""+pno);
                                 	}
		}
		catch(Exception e) {}
			}
			catch(Exception e) {}
		}
		
		
		/***********************************Code for Update the Application***************************/
		
		if(ae.getSource()==bupd)
		{
				if(tstaffid.getText().equals(""))   
			{
				JOptionPane.showMessageDialog(this,"Please Enter Student ID","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}
		
			if(tpayslipno.getText().equals(""))  
			{
				JOptionPane.showMessageDialog(this,"Please Enter Receipt No","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(tstaffnm.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this,"Please Enter Name","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}

			if(tsalary.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this,"Please Enter Drawn Date","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(tadd.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this,"Please Enter Address","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(tdt.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this,"Please Enter Date","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}
				try
				{		
					
					PreparedStatement st=con.prepareStatement("UPDATE salary set S_Date=?,Payslip_No=?,Staff_Name=?,Address=?,Salary=? WHERE Staff_ID=?");
					
					st.setString(1,tdt.getText());
					st.setString(2,tpayslipno.getText()); 
					st.setString(3,tstaffnm.getText());
					st.setString(4,tadd.getText());
					st.setString(5,tsalary.getText());	
					st.setString(6,tstaffid.getText());  
					st.executeUpdate();
					JOptionPane.showMessageDialog(null,"Updated!");

					tstaffid.setText("");   
					tpayslipno.setText("");
					tstaffnm.setText("");
					tsalary.setText("");
					tadd.setText("");
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

				int pno=rs1.getInt(3);
                                   		pno++;
                                   		tpayslipno.setText(""+pno);
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
		
		if(ae.getSource()==bdel)
		{
			int res=JOptionPane.showConfirmDialog((Component)null,"Are you sure to delete the Staff Salary Details at Staff ID "+Integer.parseInt(tstaffid.getText()),"Delete",JOptionPane.YES_NO_OPTION);
			
			if(res==JOptionPane.YES_OPTION)
			{
				try
				{
			
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					System.out.println("Driver Loaded!");
			
					con=DriverManager.getConnection("jdbc:odbc:CompDSN");
					System.out.println("Connection Established!");

					PreparedStatement st=con.prepareStatement("delete from salary where Staff_ID= "+Integer.parseInt(tstaffid.getText()));
					st.executeUpdate();
					JOptionPane.showMessageDialog(this,"Deleted the Record at Staff ID "+(tstaffid.getText())+" Successfully!");

					tstaffid.setText("");   
					tpayslipno.setText("");
					tstaffnm.setText("");
					tsalary.setText("");
					tadd.setText("");
					tstaffid.requestFocus();
				}
				catch(Exception e) {}
			}
			else if(res==JOptionPane.NO_OPTION)
			{
			}	 
		}
		if(ae.getSource()==bprint)
		{
			JFileChooser jfc=new JFileChooser();
			int op=jfc.showSaveDialog(null);
			
			if(op==JFileChooser.APPROVE_OPTION)
			{
				File f=jfc.getSelectedFile();																																																																			
																																																																								
																																																																																		
				try	
				{
				
String s="<html><head><body><font face=Monotype Corsiva size=5 color=red><center>Computer Institute Management System</center></font><br><br><br>"+"<font face=Century size=4 color=blue><center>STAFF SALARY REPORT</font><center>"+"<br><br><hr size=2 color=black><br>"+"<font face=Arial size=1 color=black><b>Staff ID&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Date&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Payslip No&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Staff Name&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Address&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Salary<b>"+"<br><hr size=2 color=black><br>"+"<font face=Arial size=1 color=maroon>"+tstaffid.getText()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+tdt.getText()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+tpayslipno.getText()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+tstaffnm.getText()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+tadd.getText()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+tsalary.getText()+"&nbsp;"+"<br><br><br><hr size=2 color=black><br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+"<font face=Arial size=1 color=black>Total Payment="+tsalary.getText()+"<br><br><br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(Authorized Signature)"+"</body></head></html>";
				
				FileOutputStream fis=new FileOutputStream(f);																																														
				byte b[]=s.getBytes();
			
				fis.write(b);
				fis.close();
			
				JOptionPane.showMessageDialog(this,"Save Successfully");
	 			}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(this,e);
				}
			}
		}
		/********************************Code For Searching***********************************/
		
		if(ae.getSource()==bsearch)
		{
			try
			{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				System.out.println("Driver Loaded!");
			
				con=DriverManager.getConnection("jdbc:odbc:CompDSN");
				System.out.println("Connection Established!");
		
				Statement st=con.createStatement();
				String s=JOptionPane.showInputDialog(this,"Please enter Staff ID");
				ResultSet rs=st.executeQuery("select * from staff where Staff_ID="+Integer.parseInt(s));  //+Integer.parseInt(no)
				if(rs.next())
				{
					
					tstaffid.setText(""+rs.getString(1));
					tstaffnm.setText(""+rs.getString(3));
					tadd.setText(""+rs.getString(6));
					tsalary.setText(""+rs.getString(10));
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Record Not Found........");
				}

			}
			catch(Exception e) {}
		}
	}
	
	
	
	public static void main(String args[])
	{
		new StaffSalary();
	}
}



		
				