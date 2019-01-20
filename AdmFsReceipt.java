import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import java.util.Calendar;
import java.io.*;

public class FeesReceipt extends JFrame implements ActionListener,FocusListener
{
	Container cp;
	JLabel lstudid,lrecptno,ldt,lnm,ladd,lcnm,lcash,ldrawn,lrs;
	JTextField tstudid,trecptno,tnm,tdrawn,trs;
	JFormattedTextField tdt;
	JTextArea tadd;
	JButton breset,bupd,bsv,bcls,bdel,bprint,bsearch;
	JComboBox cb1,cb2;
	JScrollPane jsp; 
	JPanel jp1,jp2;
	Dimension dim;
	Connection con;

	Font f1=new Font("Cambria",Font.BOLD,14);
	Font f2=new Font("Cambria",Font.BOLD,14);
	
	FeesReceipt()
	{
		cp=getContentPane();
		cp.setLayout(null);

		dim=new Dimension();
		dim=Toolkit.getDefaultToolkit().getScreenSize();
		java.util.Date currDate=new java.util.Date();
		SimpleDateFormat sdf=new SimpleDateFormat("dd"+"/"+"MM"+"/"+"yyyy",Locale.getDefault());
		String d=sdf.format(currDate);
		
		jp1=new JPanel();
		jp1.setBounds(10,10,570,270);
		jp1.setBorder(BorderFactory.createLineBorder(Color.white,1));
		jp1.setBackground(Color.decode("#200000")); 
	
		jp2=new JPanel();
		jp2.setBounds(10,300,570,80);
		jp2.setBorder(BorderFactory.createLineBorder(Color.white,1));
		jp2.setBackground(Color.decode("#200000")); 
		
		/**********************************Labels****************************/
		lrecptno=new JLabel("Reciept No: ");
		lstudid=new JLabel("Student ID: ");
		ldt=new JLabel("Date: ");
		lnm=new JLabel("Recieved from Mr./Mrs./Miss: ");
		ladd=new JLabel("Address: ");
		lcnm=new JLabel("Course Name: ");
		lcash=new JLabel("By Cash/Cheque No: ");
		ldrawn=new JLabel("Drawn on: ");
		lrs=new JLabel("Rupees: ");
	
		/**********************************Text Fields**************************/
		trecptno=new JTextField(20);
		tstudid=new JTextField(20);
		tnm=new JTextField(20);
		tdrawn=new JTextField(20);	
		trs=new JTextField(20);
		tdt=new JFormattedTextField();
		tadd=new JTextArea(10,5);
		jsp=new JScrollPane(tadd);
		tadd.setFont(f2);
	
		/************************************Buttons******************************/
		breset=new JButton("RESET");
		bupd=new JButton("UPDATE");		
		bsv=new JButton("SAVE");					
		bcls=new JButton("CLOSE");	
		bdel=new JButton("DELETE");	
		bprint=new JButton("PRINT");	
		bsearch=new JButton("SEARCH");	
		/******************************************Combo Box**********************************/
		cb1=new JComboBox();
		cb1.addItem("");
		cb1.addItem("By Cash");
		cb1.addItem("By Cheque");

		cb2=new JComboBox();
		cb2.addItem("");
		cb2.addItem("Certificate Course in Information Technology(CCIT)");
		cb2.addItem("Certificate Course in DTP(CCDTP)");	
		cb2.addItem("Certificate Course in C");
		cb2.addItem("Certificate Course in C++");
		cb2.addItem("Certificate Course in Java");
		cb2.addItem("MS-Office");
		cb2.addItem("SQL");
		cb2.addItem("HTML");
		cb2.addItem("Corel Draw");
		cb2.addItem("Tally");
		cb2.addItem("Photoshop");

		
		/***********************************************************************************************/

		cp.add(lstudid);
		lstudid.setBounds(20,15,100,30);
		lstudid.setFont(f1);
		lstudid.setForeground(Color.decode("#FFFFFF"));
		cp.add(tstudid);
		tstudid.setBounds(190,20,100,22);
		tstudid.setFont(f2);
		tstudid.setForeground(Color.black);
		tstudid.setBorder(BorderFactory.createLineBorder(Color.black,1));

		cp.add(ldt);
		ldt.setBounds(380,15,100,30);
		ldt.setFont(f1);
		ldt.setForeground(Color.decode("#FFFFFF"));
		cp.add(tdt);
		tdt.setBounds(460,20,100,22);
		tdt.setFont(f2);
		tdt.setForeground(Color.black);
		tdt.setBorder(BorderFactory.createLineBorder(Color.black,1));
	
		cp.add(lrecptno);
		lrecptno.setBounds(20,45,100,30);
		lrecptno.setFont(f1);
		lrecptno.setForeground(Color.decode("#FFFFFF"));
		cp.add(trecptno);
		trecptno.setBounds(190,50,100,22);
		trecptno.setFont(f2);
		trecptno.setForeground(Color.black);
		trecptno.setBorder(BorderFactory.createLineBorder(Color.black,1));
		
		cp.add(lnm);
		lnm.setBounds(20,75,170,30);
		lnm.setFont(f1);
		lnm.setForeground(Color.decode("#FFFFFF"));
		cp.add(tnm);
		tnm.setBounds(190,80,240,22);
		tnm.setFont(f2);
		tnm.setForeground(Color.black);
		tnm.setBorder(BorderFactory.createLineBorder(Color.black,1));
	
		cp.add(ladd);
		ladd.setBounds(20,105,100,30);
		ladd.setFont(f1);
		ladd.setForeground(Color.decode("#FFFFFF"));
		cp.add(jsp);
		jsp.setBounds(190,110,150,60);
		tadd.setForeground(Color.black);
		jsp.setBorder(BorderFactory.createLineBorder(Color.black,1));

		cp.add(lcnm);
		lcnm.setBounds(20,175,100,30);
		lcnm.setFont(f1);
		lcnm.setForeground(Color.decode("#FFFFFF"));
		cp.add(cb2);
		cb2.setBounds(190,180,230,22);
		cb2.setFont(f2);
		cb2.setForeground(Color.black);
		cb2.setBorder(BorderFactory.createLineBorder(Color.black,1));
		
		cp.add(lcash);
		lcash.setBounds(20,205,130,30);
		lcash.setFont(f1);
		lcash.setForeground(Color.decode("#FFFFFF"));
		cp.add(cb1);
		cb1.setBounds(190,210,150,25);
		cb1.setFont(f2);
		cb1.setForeground(Color.black);
		cb1.setBorder(BorderFactory.createLineBorder(Color.black,1));

		cp.add(ldrawn);
		ldrawn.setBounds(380,205,100,30);
		ldrawn.setFont(f1);
		ldrawn.setForeground(Color.decode("#FFFFFF"));
		cp.add(tdrawn);
		tdrawn.setBounds(460,210,100,22);
		tdrawn.setFont(f2);
		tdrawn.setForeground(Color.black);
		tdrawn.setBorder(BorderFactory.createLineBorder(Color.black,1));
		
		cp.add(lrs);
		lrs.setBounds(20,240,100,30);
		lrs.setFont(f1);
		lrs.setForeground(Color.decode("#FFFFFF"));
		cp.add(trs);
		trs.setBounds(190,245,200,22);
		trs.setFont(f2);
		trs.setForeground(Color.black);
		trs.setBorder(BorderFactory.createLineBorder(Color.black,1));

		cp.add(jp1);

		cp.add(bupd);
		bupd.setBounds(25,310,80,25);
		bupd.setFont(f1);
		bupd.setBorder(BorderFactory.createLineBorder(Color.white,1));
		bupd.setBackground(Color.black);
		bupd.setForeground(Color.red);
			
		cp.add(bsv);	
		bsv.setBounds(125,310,70,25);
		bsv.setFont(f1);
		bsv.setBorder(BorderFactory.createLineBorder(Color.white,1));
		bsv.setBackground(Color.black);
		bsv.setForeground(Color.red);
		
		cp.add(breset);
		breset.setBounds(220,310,70,25);
		breset.setFont(f1);
		breset.setBorder(BorderFactory.createLineBorder(Color.white,1));
		breset.setBackground(Color.black);
		breset.setForeground(Color.red);

		cp.add(bdel);		
		bdel.setBounds(315,310,70,25);
		bdel.setFont(f1);
		bdel.setBorder(BorderFactory.createLineBorder(Color.white,1));
		bdel.setBackground(Color.black);
		bdel.setForeground(Color.red);

		cp.add(bsearch);		
		bsearch.setBounds(405,310,70,25);
		bsearch.setFont(f1);
		bsearch.setBorder(BorderFactory.createLineBorder(Color.white,1));
		bsearch.setBackground(Color.black);
		bsearch.setForeground(Color.white);

		cp.add(bcls);	
		bcls.setBounds(495,310,70,25);
		bcls.setFont(f1);
		bcls.setBorder(BorderFactory.createLineBorder(Color.white,1));
		bcls.setBackground(Color.black);
		bcls.setForeground(Color.red);
		
		cp.add(bprint);	
		bprint.setBounds(268,345,70,25);
		bprint.setFont(f1);
		bprint.setBorder(BorderFactory.createLineBorder(Color.white,1));
		bprint.setBackground(Color.black);
		bprint.setForeground(Color.white);

		cp.add(jp2);

		bupd.addActionListener(this);
		bsv.addActionListener(this);
		breset.addActionListener(this);
		bdel.addActionListener(this);
		bcls.addActionListener(this);
		bprint.addActionListener(this);
		bsearch.addActionListener(this);

		tstudid.addFocusListener(this);
		
		bupd.setToolTipText("Update the Records");
		bsv.setToolTipText("Save the Records");
		bcls.setToolTipText("Close form");
		breset.setToolTipText("Clear");
		bdel.setToolTipText("Delete the Records");
		bsearch.setToolTipText("Search the Records");
		bprint.setToolTipText("Print the Records");

		tdt.setText(""+d);  //Add date into the text field
		setBounds(245,100,(dim.width-300),(dim.height-115)); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		//setIconifiable(true);
		//setClosable(true);	
		setVisible(true);
		setSize(600,425);
		setTitle("Fees Receipt");
		cp.setBackground(Color.black);

		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			System.out.println("Driver Loaded!");
		
			con=DriverManager.getConnection("jdbc:odbc:CompDSN");
			System.out.println("Connection Established!");
	
			Statement st=con.createStatement();
                                   	ResultSet rs=st.executeQuery("select * from receipt");
                                  	while(rs.next())
                                 	{
                                   		int no=rs.getInt(1);
                                   		no++;
                                   		tstudid.setText(""+no);
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
			trecptno.setText("");
			tstudid.setText("");
			cb1.setSelectedIndex(0);   
			cb2.setSelectedIndex(0);   
			tnm.setText("");
			tdrawn.setText("");
			trs.setText("");
			tadd.setText("");
			tstudid.requestFocus();

			try
			{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				System.out.println("Driver Loaded!");
		
				con=DriverManager.getConnection("jdbc:odbc:CompDSN");
				System.out.println("Connection Established!");
	
				Statement st=con.createStatement();
                                   		ResultSet rs=st.executeQuery("select * from receipt");
                                  		while(rs.next())
                                 		{
                                   			int no=rs.getInt(1);
                                   			no++;
                                   			tstudid.setText(""+no);
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
			if(tstudid.getText().equals(""))  
			{
				JOptionPane.showMessageDialog(this,"Please Enter Student ID","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(cb1.getSelectedIndex()==0)
			{
				JOptionPane.showMessageDialog(this,"Please Select Cash/Cheque","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}
		
			if(trecptno.getText().equals(""))  
			{
				JOptionPane.showMessageDialog(this,"Please Enter Receipt No","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(tnm.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this,"Please Enter Name","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(cb2.getSelectedIndex()==0)
			{
				JOptionPane.showMessageDialog(this,"Please Enter Course Name","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(tdrawn.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this,"Please Enter Drawn Date","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(trs.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this,"Please Enter Rupees","Error",JOptionPane.ERROR_MESSAGE);
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
				PreparedStatement st=con.prepareStatement("insert into receipt values(?,?,?,?,?,?,?,?,?)");
				st.setString(1,tstudid.getText()); 
				st.setString(2,tdt.getText());
				st.setString(3,trecptno.getText());
				st.setString(4,tnm.getText());
				st.setString(5,tadd.getText());
				st.setString(6,(String)cb2.getSelectedItem());
				st.setString(7,(String)cb1.getSelectedItem());
				st.setString(8,tdrawn.getText());
				st.setString(9,trs.getText());

				st.executeUpdate();
				JOptionPane.showMessageDialog(null,"Fees Receipt Details Saved Successfully!");
			}
			catch(Exception e) {}
		}
		
		
		/***********************************Code for Update the Application***************************/
		
		if(ae.getSource()==bupd)
		{
				if(tstudid.getText().equals(""))  
			{
				JOptionPane.showMessageDialog(this,"Please Enter Student ID","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(cb1.getSelectedIndex()==0)
			{
				JOptionPane.showMessageDialog(this,"Please Select Cash/Cheque","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}
		
			if(trecptno.getText().equals(""))  
			{
				JOptionPane.showMessageDialog(this,"Please Enter Receipt No","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(tnm.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this,"Please Enter Name","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(cb2.getSelectedIndex()==0)
			{
				JOptionPane.showMessageDialog(this,"Please Enter Course Name","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(tdrawn.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this,"Please Enter Drawn Date","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(trs.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this,"Please Enter Rupees","Error",JOptionPane.ERROR_MESSAGE);
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
					PreparedStatement st=con.prepareStatement("UPDATE receipt set F_Date=?,Receipt_No=?,Student_Name=?,Address=?,Course_Name=?,By_Cash=?,Drawn_On=?,Rupees=? WHERE Student_ID=?");
					
					st.setString(1,tdt.getText());
					st.setString(2,trecptno.getText());
					st.setString(3,tnm.getText());
					st.setString(4,tadd.getText());
					st.setString(5,(String)cb2.getSelectedItem());
					st.setString(6,(String)cb1.getSelectedItem());
					st.setString(7,tdrawn.getText());
					st.setString(8,trs.getText());	
					st.setString(9,tstudid.getText()); 
					st.executeUpdate();
					JOptionPane.showMessageDialog(null,"Updated!");
				}
				catch(Exception e) 
				{
					System.out.println("error");
				}	
		}
		
			
		/**************************************Delete the Application********************************************/
		
		if(ae.getSource()==bdel)
		{
			int res=JOptionPane.showConfirmDialog((Component)null,"Are you sure to delete the Fees Receipt at Student ID "+Integer.parseInt(tstudid.getText()),"Delete",JOptionPane.YES_NO_OPTION);
			
			if(res==JOptionPane.YES_OPTION)
			{
				try
				{
			
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					System.out.println("Driver Loaded!");
			
					con=DriverManager.getConnection("jdbc:odbc:CompDSN");
					System.out.println("Connection Established!");

					PreparedStatement st=con.prepareStatement("delete from receipt where Student_ID= "+Integer.parseInt(tstudid.getText()));
					st.executeUpdate();
					JOptionPane.showMessageDialog(this,"Deleted the Record at Student ID "+(tstudid.getText())+" Successfully!");
				}
				catch(Exception e) {}
			}
			else if(res==JOptionPane.NO_OPTION)
			{
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
				String s=JOptionPane.showInputDialog(this,"Please enter Student's ID");
				ResultSet rs=st.executeQuery("select * from student where Student_ID="+Integer.parseInt(s));  //+Integer.parseInt(s)
				if(rs.next())
				{
					/*
					tstudid.setText(""+rs.getString(1)); 
 					tdt.setText(""+rs.getString(2));
					trecptno.setText(""+rs.getString(3));
					tnm.setText(""+rs.getString(4));
					tadd.setText(""+rs.getString(5));
					cb2.setSelectedItem(rs.getString(6));
					cb1.setSelectedItem(rs.getString(7));
					tdrawn.setText(""+rs.getString(8));
					trs.setText(""+rs.getString(9));*/

					tstudid.setText ("" + rs.getString("Student_Id"));
					tnm.setText ("" + rs.getString ("Student_Name"));
					tadd.setText ("" + rs.getString ("Address"));
					cb2.setSelectedItem(rs.getString ("Course_Name"));
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Record Not Found........");
				}

			}
			catch(Exception e) {}
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
				
String s="<html><head><body><font face=Monotype Corsiva size=5 color=red><center>Computer Institute Management System</center></font><br><br><br>"+"<font face=Century size=4 color=blue><center>FEES RECEIPT</font><center>"+"<br><br><hr size=2 color=black><br>"+"<font face=Arial size=1 color=black><b>Student ID&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Date&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Receipt_No&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Student_Name&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Address&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Course_Name&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;By&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Drawn_On&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Rupees<b>"+"<br><hr size=2 color=black><br>"+"<font face=Arial size=1 color=maroon>"+tstudid.getText()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+tdt.getText()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+trecptno.getText()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+tnm.getText()+"&nbsp;&nbsp;&nbsp;"+tadd.getText()+"&nbsp;&nbsp;&nbsp;"+cb2.getSelectedItem()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+cb1.getSelectedItem()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+tdrawn.getText()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+trs.getText()+"&nbsp;&nbsp;"+"<br><br><br><hr size=2 color=black><br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font face=Arial size=1 color=black>Total Fees Paid="+trs.getText()+"<br><br><br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(Authorized Signature)"+"</body></head></html>";
				
				FileOutputStream fis=new FileOutputStream(f);
				byte b[]=s.getBytes();
			
				fis.write(b);
				fis.close();
			
				JOptionPane.showMessageDialog(this,"Save Success");
	 			}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(this,e);
				}
			}
		}
		
		
		
	}
	public void focusGained (FocusEvent fe) { }

	public void focusLost (FocusEvent fe) 
	{
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			System.out.println("Driver Loaded!");
			
			con=DriverManager.getConnection("jdbc:odbc:CompDSN");
			System.out.println("Connection Established!");
		}
		catch(Exception e) {}

		Object obj = fe.getSource ();

		if (obj == tstudid) 
		{
			if (tstudid.getText().equals ("")) 
			{	//If TextField is Empty.
			}
			else 
			{		
				int id = Integer.parseInt (tstudid.getText ());	//Converting String to Numeric.
				long No;					//Use for Comparing the Book's Id.
				boolean found = false;				//To Confirm the Book's Id Existance.
				
				try 
				{
					Statement st=con.createStatement();	
					//SELECT Query to Retrieved the Record.
					String q = "SELECT * FROM student WHERE Student_ID = " + id + "";
					ResultSet rs = st.executeQuery (q);	//Executing the Query.
					rs.next ();				//Moving towards the Record.
					No = rs.getLong ("Student_ID");		//Storing the Record.
					if (No == id) 
					{			//If Record Found then Display Records.
						found = true;
						tstudid.setText ("" + id);
						tnm.setText ("" + rs.getString ("Student_Name"));
						tadd.setText ("" + rs.getString ("Address"));
						cb2.setSelectedItem(rs.getString ("Course_Name"));
					}
					else 
					{
						found = false;
					}
				}
				catch (SQLException sqlex)
				{
					if (found == false) 
					{
						tstudid.requestFocus ();
						tnm.setText ("");
						tadd.setText ("");
						cb2.setSelectedIndex(0);
					}
				}
			}

		}
	}
	
	public static void main(String args[])
	{
		new FeesReceipt();
	}
}




/*
				String s=JOptionPane.showInputDialog(this,"Please Enter Student ID");
		
				if(tstudid.getText().equals(""))  
				{
					JOptionPane.showMessageDialog(this,"Please Enter Student ID","Error",JOptionPane.ERROR_MESSAGE);
					return;
				}
				if(cb1.getSelectedIndex()==0)
				{
					JOptionPane.showMessageDialog(this,"Please Select Cash/Cheque","Error",JOptionPane.ERROR_MESSAGE);
					return;
				}
		
				if(trecptno.getText().equals(""))  
				{
					JOptionPane.showMessageDialog(this,"Please Enter Receipt No","Error",JOptionPane.ERROR_MESSAGE);
					return;
				}
				if(tnm.getText().equals(""))
				{
					JOptionPane.showMessageDialog(this,"Please Enter Name","Error",JOptionPane.ERROR_MESSAGE);
					return;
				}
				if(cb2.getSelectedIndex()==0)
				{
					JOptionPane.showMessageDialog(this,"Please Enter Course Name","Error",JOptionPane.ERROR_MESSAGE);
					return;
				}
				if(tdrawn.getText().equals(""))
				{
					JOptionPane.showMessageDialog(this,"Please Enter Drawn Date","Error",JOptionPane.ERROR_MESSAGE);
					return;
				}
				if(trs.getText().equals(""))
				{
					JOptionPane.showMessageDialog(this,"Please Enter Rupees","Error",JOptionPane.ERROR_MESSAGE);
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
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					System.out.println("Driver Loaded!");
			
					con=DriverManager.getConnection("jdbc:odbc:CompDSN");
					System.out.println("Connection Established!");

					PreparedStatement st=con.prepareStatement("UPDATE feesreceipt set Date=?,Receipt_No=?,Student_Name=?,Address=?,Course_Name=?,By=?,Drawn_On=?,Rupees=? WHERE Student_ID="+Integer.parseInt(s));
					st.setString(1,tstudid.getText()); //tstudid,trecptno,tnm,cb2,tdrawn,trs,tadd,tdt,cb1
					st.setString(2,tdt.getText());
					st.setString(3,trecptno.getText());
					st.setString(4,tnm.getText());
					st.setString(5,tadd.getText());
					st.setString(6,(String)cb2.getSelectedItem());
					st.setString(7,(String)cb1.getSelectedItem());
					st.setString(8,tdrawn.getText());
					st.setString(9,trs.getText());


					st.executeUpdate();
					JOptionPane.showMessageDialog(this,"Fees Receipt Details Updated Successfully!");
				}
				catch(Exception e) {}
				*/