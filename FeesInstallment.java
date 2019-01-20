import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import java.io.*;
import java.util.Calendar;

public class FeesInstallment extends JInternalFrame implements ActionListener,FocusListener,KeyListener
{
	Container cp;
	JLabel lstudid,lsnm,ldt,lcnm,ltcfs1,ltcfs2,linstll1,linstll2,lfp1,lfp2,llf1,llf2,lcpf1,lcpf2,lri1,lri2;
	JTextField tstudid,tsnm,ttcfs1,ttcfs2,tinstll1,tinstll2,tfp1,tfp2,tlf1,tlf2,tcpf1,tcpf2,tri1,tri2;
	JFormattedTextField tdt;
	JButton breset,bupd,bsv,bcls,bdel,bsearch,binstallsearch,bprint;
	JPanel jp1,jp2,jp3,jp4;
	JComboBox cb1;
	JRadioButton r1,r2;
	ButtonGroup bg;
	Dimension dim;
	Connection con;
	
	Font f1=new Font("Cambria",Font.BOLD,14);
	Font f2=new Font("Cambria",Font.BOLD,14);
	
	FeesInstallment()
	{
		cp=getContentPane();
		cp.setLayout(null);
		dim=new Dimension();
		dim=Toolkit.getDefaultToolkit().getScreenSize();
		java.util.Date currDate=new java.util.Date();
		SimpleDateFormat sdf=new SimpleDateFormat("dd"+"/"+"MM"+"/"+"yyyy",Locale.getDefault());
		String d=sdf.format(currDate);
	
		jp1=new JPanel();
		jp1.setBounds(10,10,700,110);
		jp1.setBorder(BorderFactory.createLineBorder(Color.white,1));
		jp1.setBackground(Color.decode("#200000")); 
	
		jp2=new JPanel();
		jp2.setBounds(10,480,700,80);
		jp2.setBorder(BorderFactory.createLineBorder(Color.white,1));
		jp2.setBackground(Color.decode("#200000")); 
	
		jp3=new JPanel();
		jp3.setBounds(10,135,700,165);
		jp3.setBorder(BorderFactory.createLineBorder(Color.white,1));
		jp3.setBackground(Color.decode("#200000")); 
		
		jp4=new JPanel();
		jp4.setBounds(10,315,700,155);
		jp4.setBorder(BorderFactory.createLineBorder(Color.white,1));
		jp4.setBackground(Color.decode("#200000")); 
		
	
		
		/**********************************Labels****************************/
		lstudid=new JLabel("Student  ID: ");   
		lsnm=new JLabel("Student Name: ");
		ldt=new JLabel("Date: ");
		lcnm=new JLabel("Course Name: ");
		ltcfs1=new JLabel("Total Fees: ");
		ltcfs2=new JLabel("Total Fees: ");
		linstll1=new JLabel("No of Installments: ");
		linstll2=new JLabel("No of Installments: ");
		lfp1=new JLabel("Fees Paid: ");
		lfp2=new JLabel("Fees Paid: ");
		llf1=new JLabel("Balance Fees: ");
		llf2=new JLabel("Balance Fees: ");
		lcpf1=new JLabel("Current Pay Fees: ");	
		lcpf2=new JLabel("Current Pay Fees: ");
		lri1=new JLabel("Remaining Installments: ");
		lri2=new JLabel("Remaining Installments: ");
		
		/**********************************Text Fields**************************/
		tsnm=new JTextField(20);
		tstudid=new JTextField(20);
		tdt=new JFormattedTextField();
		ttcfs1=new JTextField(20);
		ttcfs2=new JTextField(20);
		tinstll1=new JTextField(20);
		tinstll2=new JTextField(20);
		tfp1=new JTextField(20);
		tfp2=new JTextField(20);
		tlf1=new JTextField(20);
		tlf2=new JTextField(20);
		tcpf1=new JTextField(20);
		tcpf2=new JTextField(20);
		tri1=new JTextField(20);
		tri2=new JTextField(20);
		
		/************************************Buttons******************************/
		breset=new JButton("RESET");
		bupd=new JButton("Updating The Installments");		
		bsv=new JButton("SAVE");					
		bcls=new JButton("CLOSE");	
		bdel=new JButton("DELETE");
		bsearch=new JButton("SEARCH");
		bprint=new JButton("PRINT");
		binstallsearch=new JButton("Search For Updated Installments");
		/*************************************Radio Button****************************************/
		r1=new JRadioButton("Modular Courses");
		r2=new JRadioButton("Certificate Courses");
		bg=new ButtonGroup();
		bg.add(r1);
		bg.add(r2);

		/**************************************ComboBox****************************************************/
		cb1=new JComboBox();
		cb1.addItem("");
		cb1.addItem("Certificate Course in Information Technology(CCIT)");
		cb1.addItem("Certificate Course in DTP(CCDTP)");	
		cb1.addItem("Certificate Course in C");
		cb1.addItem("Certificate Course in C++");
		cb1.addItem("Certificate Course in Java");
		cb1.addItem("MS Office");
		cb1.addItem("SQL");
		cb1.addItem("HTML");
		cb1.addItem("Corel Draw");
		cb1.addItem("Tally");
		cb1.addItem("Photoshop");
	
		/**********************************************************************************************************************************/
	
		cp.add(lstudid);
		lstudid.setBounds(20,20,80,30);
		lstudid.setFont(f1);
		lstudid.setForeground(Color.decode("#FFFFFF"));
		cp.add(tstudid);
		tstudid.setBounds(130,25,100,22);
		tstudid.setFont(f2);
		tstudid.setForeground(Color.black);
		tstudid.setBorder(BorderFactory.createLineBorder(Color.black,1));

		
		cp.add(ldt);
		ldt.setBounds(330,20,60,30);
		ldt.setFont(f1);
		ldt.setForeground(Color.decode("#FFFFFF"));
		cp.add(tdt);
		tdt.setBounds(390,25,100,22);
		tdt.setFont(f2);
		tdt.setForeground(Color.black);
		tdt.setBorder(BorderFactory.createLineBorder(Color.black,1));
		
		cp.add(lsnm);
		lsnm.setBounds(20,50,150,30);
		lsnm.setFont(f1);
		lsnm.setForeground(Color.decode("#FFFFFF"));
		cp.add(tsnm);
		tsnm.setBounds(130,55,250,22);
		tsnm.setFont(f2);
		tsnm.setForeground(Color.black);
		tsnm.setBorder(BorderFactory.createLineBorder(Color.black,1));
		
		cp.add(lcnm);
		lcnm.setBounds(20,80,150,30);
		lcnm.setFont(f1);
		lcnm.setForeground(Color.decode("#FFFFFF"));
		cp.add(cb1);
		cb1.setBounds(130,85,250,22);
		cb1.setFont(f2);
		cb1.setForeground(Color.black);
		cb1.setBorder(BorderFactory.createLineBorder(Color.black,1));
		
		cp.add(jp1);
		/************************************************************************************/
		cp.add(r1);
		r1.setBounds(20,140,150,30);
		r1.setFont(f1);
		r1.setBackground(Color.decode("#200000"));
		r1.setForeground(Color.decode("#FFFFFF"));
		/************************************************************************************/
		cp.add(ltcfs1);
		ltcfs1.setBounds(100,180,150,30);
		ltcfs1.setFont(f1);
		ltcfs1.setForeground(Color.decode("#FFFFFF"));
		cp.add(ttcfs1);
		ttcfs1.setBounds(215,185,150,22);
		ttcfs1.setFont(f2);
		ttcfs1.setForeground(Color.black);
		ttcfs1.setBorder(BorderFactory.createLineBorder(Color.black,1));
		
		cp.add(linstll1);
		linstll1.setBounds(400,180,150,30);
		linstll1.setFont(f1);
		linstll1.setForeground(Color.decode("#FFFFFF"));
		cp.add(tinstll1);
		tinstll1.setBounds(545,185,150,22);
		tinstll1.setFont(f2);
		tinstll1.setForeground(Color.black);
		tinstll1.setBorder(BorderFactory.createLineBorder(Color.black,1));
	/************************************************************************************/
		cp.add(lfp1);
		lfp1.setBounds(100,220,150,30);
		lfp1.setFont(f1);
		lfp1.setForeground(Color.decode("#FFFFFF"));
		cp.add(tfp1);
		tfp1.setBounds(215,225,150,22);
		tfp1.setFont(f2);
		tfp1.setForeground(Color.black);
		tfp1.setBorder(BorderFactory.createLineBorder(Color.black,1));
		
		cp.add(llf1);
		llf1.setBounds(400,220,150,30);
		llf1.setFont(f1);
		llf1.setForeground(Color.decode("#FFFFFF"));
		cp.add(tlf1);
		tlf1.setBounds(545,225,150,22);
		tlf1.setFont(f2);
		tlf1.setForeground(Color.black);
		tlf1.setBorder(BorderFactory.createLineBorder(Color.black,1));
	/************************************************************************************/
		cp.add(lcpf1);
		lcpf1.setBounds(100,260,150,30);
		lcpf1.setFont(f1);
		lcpf1.setForeground(Color.decode("#FFFFFF"));
		cp.add(tcpf1);
		tcpf1.setBounds(215,265,150,22);
		tcpf1.setFont(f2);
		tcpf1.setForeground(Color.black);
		tcpf1.setBorder(BorderFactory.createLineBorder(Color.black,1));
		
		cp.add(lri1);
		lri1.setBounds(400,260,160,30);
		lri1.setFont(f1);
		lri1.setForeground(Color.decode("#FFFFFF"));
		cp.add(tri1);
		tri1.setBounds(545,265,150,22);
		tri1.setFont(f2);
		tri1.setForeground(Color.black);
		tri1.setBorder(BorderFactory.createLineBorder(Color.black,1));

		cp.add(jp3);
		/**********************************************************************************/
		cp.add(r2);
		r2.setBounds(20,320,150,30);
		r2.setFont(f1);
		r2.setBackground(Color.decode("#200000"));
		r2.setForeground(Color.decode("#FFFFFF"));
		/**********************************************************************************/
		cp.add(ltcfs2);
		ltcfs2.setBounds(95,350,150,30);
		ltcfs2.setFont(f1);
		ltcfs2.setForeground(Color.decode("#FFFFFF"));
		cp.add(ttcfs2);
		ttcfs2.setBounds(215,355,150,22);
		ttcfs2.setFont(f2);
		ttcfs2.setForeground(Color.black);
		ttcfs2.setBorder(BorderFactory.createLineBorder(Color.black,1));
		
		cp.add(linstll2);
		linstll2.setBounds(395,350,150,30);
		linstll2.setFont(f1);
		linstll2.setForeground(Color.decode("#FFFFFF"));
		cp.add(tinstll2);
		tinstll2.setBounds(545,355,150,22);
		tinstll2.setFont(f2);
		tinstll2.setForeground(Color.black);
		tinstll2.setBorder(BorderFactory.createLineBorder(Color.black,1));
		/******************************************************************************************/
		cp.add(lfp2);
		lfp2.setBounds(95,390,150,30);
		lfp2.setFont(f1);
		lfp2.setForeground(Color.decode("#FFFFFF"));
		cp.add(tfp2);
		tfp2.setBounds(215,395,150,22);
		tfp2.setFont(f2);
		tfp2.setForeground(Color.black);
		tfp2.setBorder(BorderFactory.createLineBorder(Color.black,1));
		
		cp.add(llf2);
		llf2.setBounds(395,390,150,30);
		llf2.setFont(f1);
		llf2.setForeground(Color.decode("#FFFFFF"));
		cp.add(tlf2);
		tlf2.setBounds(545,395,150,22);
		tlf2.setFont(f2);
		tlf2.setForeground(Color.black);
		tlf2.setBorder(BorderFactory.createLineBorder(Color.black,1));
		/************************************************************************************/
		cp.add(lcpf2);
		lcpf2.setBounds(95,430,150,30);
		lcpf2.setFont(f1);
		lcpf2.setForeground(Color.decode("#FFFFFF"));
		cp.add(tcpf2);
		tcpf2.setBounds(215,435,150,22);
		tcpf2.setFont(f2);
		tcpf2.setForeground(Color.black);
		tcpf2.setBorder(BorderFactory.createLineBorder(Color.black,1));
		
		cp.add(lri2);
		lri2.setBounds(395,430,160,30);
		lri2.setFont(f1);
		lri2.setForeground(Color.decode("#FFFFFF"));
		cp.add(tri2);
		tri2.setBounds(545,435,150,22);
		tri2.setFont(f2);
		tri2.setForeground(Color.black);
		tri2.setBorder(BorderFactory.createLineBorder(Color.black,1));

		cp.add(jp4);
	
		cp.add(bsv);
		bsv.setBounds(50,490,70,25);
		bsv.setFont(f1);
		bsv.setBorder(BorderFactory.createLineBorder(Color.white,1));
		bsv.setBackground(Color.black);
		bsv.setForeground(Color.red);

		cp.add(breset);	
		breset.setBounds(165,490,70,25);
		breset.setFont(f1);
		breset.setBorder(BorderFactory.createLineBorder(Color.white,1));
		breset.setBackground(Color.black);
		breset.setForeground(Color.red);


		cp.add(bsearch);
		bsearch.setBounds(285,490,70,25);
		bsearch.setFont(f1);
		bsearch.setBorder(BorderFactory.createLineBorder(Color.white,1));
		bsearch.setBackground(Color.black);
		bsearch.setForeground(Color.red);
		
		cp.add(bdel);
		bdel.setBounds(400,490,70,25);
		bdel.setFont(f1);
		bdel.setBorder(BorderFactory.createLineBorder(Color.white,1));
		bdel.setBackground(Color.black);
		bdel.setForeground(Color.red);
		
		cp.add(bcls);		
		bcls.setBounds(510,490,80,25);
		bcls.setFont(f1);
		bcls.setBorder(BorderFactory.createLineBorder(Color.white,1));
		bcls.setBackground(Color.black);
		bcls.setForeground(Color.red);

		cp.add(bupd);
		bupd.setBounds(50,525,265,25);
		bupd.setFont(f1);
		bupd.setBorder(BorderFactory.createLineBorder(Color.white,1));
		bupd.setBackground(Color.black);
		bupd.setForeground(Color.decode("#348017"));

		cp.add(binstallsearch);
		binstallsearch.setBounds(320,525,270,25);
		binstallsearch.setFont(f1);
		binstallsearch.setBorder(BorderFactory.createLineBorder(Color.white,1));
		binstallsearch.setBackground(Color.black);
		binstallsearch.setForeground(Color.decode("#348017"));

		cp.add(bprint);		
		bprint.setBounds(600,490,70,60);
		bprint.setFont(f1);
		bprint.setBorder(BorderFactory.createLineBorder(Color.white,1));
		bprint.setBackground(Color.black);
		bprint.setForeground(Color.white);


		cp.add(jp2);
		
		tdt.setText(""+d);  //Add date into the text field

		bupd.addActionListener(this);
		bsv.addActionListener(this);
		bcls.addActionListener(this);
		breset.addActionListener(this);	
		bdel.addActionListener(this);
		bsearch.addActionListener(this);
		binstallsearch.addActionListener(this);
		bprint.addActionListener(this);

		tlf1.addFocusListener(this);
		tlf2.addFocusListener(this);
		tri1.addFocusListener(this);
		tri2.addFocusListener(this);

		tstudid.addKeyListener(this);
		tsnm.addKeyListener(this);
		ttcfs1.addKeyListener(this);
		ttcfs2.addKeyListener(this);
		tinstll1.addKeyListener(this);
		tinstll2.addKeyListener(this);
		tfp1.addKeyListener(this);
		tfp2.addKeyListener(this);
		tlf1.addKeyListener(this);
		tlf2.addKeyListener(this);
		tcpf1.addKeyListener(this);
		tcpf2.addKeyListener(this);
		tri1.addKeyListener(this);
		tri2.addKeyListener(this);
	
		tstudid.setToolTipText("Please Enter here Student ID to search");
		tcpf1.setToolTipText("Please enter here Current Payment");
		tcpf2.setToolTipText("Please enter here Current Payment");
		tinstll1.setToolTipText("Please select the Installment No");
		tinstll2.setToolTipText("Please select the Installment No");
		
		bupd.setToolTipText("Update the Fees Installment");
		bsv.setToolTipText("Save the Records");
		bcls.setToolTipText("Close form");
		breset.setToolTipText("Clear");
		bdel.setToolTipText("Delete the Records");
		bsearch.setToolTipText("Search the Previous Records");
		binstallsearch.setToolTipText("Search the Previous Fees Installments");
		bprint.setToolTipText("Print the Records");

		setBounds(245,75,(dim.width-300),(dim.height-115)); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setIconifiable(true);
		setClosable(true);	
		setVisible(true);
		setSize(730,605);
		setTitle("Fees Installment");
		cp.setBackground(Color.black);


		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			System.out.println("Driver Loaded!");
		
			con=DriverManager.getConnection("jdbc:odbc:CompDSN");
			System.out.println("Connection Established!");
	
			Statement st1=con.createStatement();
                                   	ResultSet rs1=st1.executeQuery("select * from fees");
                                  	while(rs1.next())
                                 	{
                                   		int no=rs1.getInt(1);
				no++;
                                   		tstudid.setText(""+no);
				//bsearch.setEnabled(true);
				//bsv.setEnabled(true);
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
				String id=JOptionPane.showInputDialog(this,"Please enter Student's ID to search the previous Student's Records");
				ResultSet rs=st.executeQuery("select * from admission where Student_ID="+Integer.parseInt(id));  
				if(rs.next())
				{
					Statement st2=con.createStatement();
                              				ResultSet rs2=st2.executeQuery("select * from fees WHERE Student_ID="+Integer.parseInt(id));			
					while(rs2.next())
					{
						int s2=Integer.parseInt(rs2.getString(8));	
						if(s2!=0)
						{
							JOptionPane.showMessageDialog(this,"You have paid first installment, so plz click Search for updated installments.Thank you!");
							bsearch.setEnabled(false);
							bsv.setEnabled(false);

							tstudid.setText("");
							tdt.setText("");
							tsnm.setText("");  
							cb1.setSelectedIndex(0);
							ttcfs1.setText("");
							tinstll1.setText("");
							tfp1.setText("");
							tlf1.setText("");
							ttcfs2.setText("");
							tinstll2.setText("");
							tfp2.setText("");
							tlf2.setText("");
							tri1.setText("");
							tri2.setText("");
							tcpf1.setText("");
							tcpf2.setText("");
							bg.clearSelection();
							tstudid.requestFocus();

							bsv.setEnabled(false);
							bsearch.setEnabled(false);
							bdel.setEnabled(false);

							return;
						}
					
					}

					int f=0;
					
					tstudid.setText(""+rs.getString(1));
					tsnm.setText(""+rs.getString(2));
					String str1=rs.getString(5);  	//get Course name 
					String str2=rs.getString(4);
								//get Faculty name from database
					if(str2.equals("Modular Courses"))
					{
						r1.setSelected(true);
						
						ttcfs2.setEnabled(false);
						tinstll2.setEnabled(false);	
						tfp2.setEnabled(false);
						tlf2.setEnabled(false);
						tcpf2.setEnabled(false);
						tri2.setEnabled(false);
					
						ttcfs1.setEnabled(true);
						tinstll1.setEnabled(true);	
						tfp1.setEnabled(true);
						tlf1.setEnabled(true);
						tcpf1.setEnabled(true);
						tri1.setEnabled(true);

						tfp1.setText(""+f);

						ttcfs1.setText(""+rs.getString(6));

						if(str1.equals("MS Office"))
							cb1.setSelectedIndex(6);
						else if(str1.equals("SQL"))
							cb1.setSelectedIndex(7);
						else if(str1.equals("HTML"))
							cb1.setSelectedIndex(8);
						else if(str1.equals("Corel Draw"))
							cb1.setSelectedIndex(9);
						else if(str1.equals("Tally"))
							cb1.setSelectedIndex(10);
						else 
							cb1.setSelectedIndex(11);
					}
					else
					{
						r2.setSelected(true);

						ttcfs1.setEnabled(false);
						tinstll1.setEnabled(false);	
						tfp1.setEnabled(false);
						tlf1.setEnabled(false);
						tcpf1.setEnabled(false);
						tri1.setEnabled(false);
				
						ttcfs2.setEnabled(true);
						tinstll2.setEnabled(true);	
						tfp2.setEnabled(true);
						tlf2.setEnabled(true);
						tcpf2.setEnabled(true);
						tri2.setEnabled(true);
				
						tfp2.setText(""+f);

						ttcfs2.setText(""+rs.getString(6));
						if(str1.equals("Certificate course in Information Technology(CCIT)"))
							cb1.setSelectedIndex(1);
						else if(str1.equals("Certificate course in DTP(CCDTP)"))
							cb1.setSelectedIndex(2);
						else if(str1.equals("Certificate course in C"))
							cb1.setSelectedIndex(3);
						else if(str1.equals("Certificate course in C++"))
							cb1.setSelectedIndex(4);
						else
							cb1.setSelectedIndex(5);
					
					}
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Record Not Found........");
				}
			}
			catch(Exception e) {}
		}
		int i1=3,i2=4;
		if(cb1.getSelectedIndex()==1)  //CCIT
		{
			tinstll2.setText(""+i1);
		}
		else if(cb1.getSelectedIndex()==2) //DTP
		{
			tinstll2.setText(""+i1);
		}
		else if(cb1.getSelectedIndex()==3)//C
		{
			tinstll2.setText(""+i1);
		}
		else if(cb1.getSelectedIndex()==4)//C++
		{
			tinstll2.setText(""+i1);
		}
		else if(cb1.getSelectedIndex()==5)//Java
		{
			tinstll2.setText(""+i2);
		}
		else if(cb1.getSelectedIndex()==6)//MSOffice
		{
			tinstll1.setText(""+i1);
		}
		else if(cb1.getSelectedIndex()==7)//SQL
		{
			tinstll1.setText(""+i2);
		}
		else if(cb1.getSelectedIndex()==8)//HTML
		{
			tinstll1.setText(""+i2);
		}
		else if(cb1.getSelectedIndex()==9)//corel draw
		{
			tinstll1.setText(""+i1);
		}
		else if(cb1.getSelectedIndex()==10)//Tally
		{
			tinstll1.setText(""+i1);
		}
		else if(cb1.getSelectedIndex()==11)//photoshop
		{
			tinstll1.setText(""+i1);
		}	

		/**************************************Print the Application********************************************/
		if(ae.getSource()==bprint)
		{
		JFileChooser jfc=new JFileChooser();
			int op=jfc.showSaveDialog(null);
			
			if(op==JFileChooser.APPROVE_OPTION)
			{
				File f=jfc.getSelectedFile();																																																																			
																																																																								
																																																																																		
				try	
				{																																																																															
																																					
String s="<html><head><body><font face=Monotype Corsiva size=5 color=red><center>Computer Institute Management System</center></font><br><br><br>"+"<font face=Century size=4 color=blue><center>FEES INSTALLMENT REPORT</font><center>"+"<br><br><hr size=2 color=black><br>"+"<font face=Arial size=1 color=black><b>Student ID&nbsp;|&nbsp;Date&nbsp;&nbsp;|&nbsp;&nbsp;Student Name&nbsp;|&nbsp;&nbsp;Course Name&nbsp;|&nbsp;Total Fees&nbsp;|&nbsp;No of Installments&nbsp;|&nbsp;Fees Paid&nbsp;|&nbsp;Balance Fees&nbsp;|&nbsp;Current Pay Fees&nbsp;|&nbsp;Remaining Installments<b>"+"<br><hr size=2 color=black><br>"+"<font face=Arial size=1 color=maroon>"+tstudid.getText()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+tdt.getText()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+tsnm.getText()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+cb1.getSelectedItem()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ttcfs1.getText()+"&nbsp;"+ttcfs2.getText()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+tinstll1.getText()+"&nbsp;"+tinstll2.getText()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+tfp1.getText()+"&nbsp;"+tfp2.getText()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+tlf1.getText()+"&nbsp;"+tlf2.getText()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+tcpf1.getText()+"&nbsp;"+tcpf2.getText()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+tri1.getText()+"&nbsp;"+tri2.getText()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+"</body></head></html>";
				
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
			if(tsnm.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this,"Please Enter Student's Name","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(tdt.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this,"Please Enter the Date","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(cb1.getSelectedIndex()==0)
			{
				JOptionPane.showMessageDialog(this,"Please select the Course","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(r1.isSelected()==false && r2.isSelected()==false)
			{
				JOptionPane.showMessageDialog(this,"Please Select Course","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			if(tri1.getText().length()>4||tri2.getText().length()>4)  
			{
				JOptionPane.showMessageDialog(this,"Remaining Installments should not be greater than 4","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(tinstll1.getText().length()>4||tinstll2.getText().length()>4)  
			{
				JOptionPane.showMessageDialog(this,"No of Installments should not be greater than 4","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			try
			{
				PreparedStatement st=con.prepareStatement("insert into fees values(?,?,?,?,?,?,?,?,?,?,?)");
				st.setString(1,tstudid.getText());
				st.setString(2,tdt.getText());
				st.setString(3,tsnm.getText());
				st.setString(4,(String)cb1.getSelectedItem());
				
				if(r1.isSelected()==true)
				{
					st.setString(5,"Modular Courses");
					st.setString(6,ttcfs1.getText());
					st.setString(7,tinstll1.getText());
					st.setString(8,tcpf1.getText());
					st.setString(9,tlf1.getText());
					st.setString(10,tcpf1.getText());
					st.setString(11,tri1.getText());
				}
				else
				{
					st.setString(5,"Certificate Courses");  
					st.setString(6,ttcfs2.getText());
					st.setString(7,tinstll2.getText());
					st.setString(8,tcpf2.getText());
					st.setString(9,tlf2.getText());
					st.setString(10,tcpf2.getText());
					st.setString(11,tri2.getText());
				}		
				st.executeUpdate();
				JOptionPane.showMessageDialog(null,"Fees Details Saved Successfully!");
				tstudid.setText("");
				tdt.setText("");
				tsnm.setText("");  
				cb1.setSelectedIndex(0);
				ttcfs1.setText("");
				tinstll1.setText("");
				tfp1.setText("");
				tlf1.setText("");
				ttcfs2.setText("");
				tinstll2.setText("");
				tfp2.setText("");
				tlf2.setText("");
				tri1.setText("");
				tri2.setText("");
				tcpf1.setText("");
				tcpf2.setText("");
				bg.clearSelection();
				tstudid.requestFocus();

				try
				{
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					System.out.println("Driver Loaded!");
		
					con=DriverManager.getConnection("jdbc:odbc:CompDSN");
					System.out.println("Connection Established!");
	
					Statement st1=con.createStatement();
                                   			ResultSet rs1=st1.executeQuery("select * from fees");
                                  			while(rs1.next())
                                 			{
                                   				int no=rs1.getInt(1);
						no++;
                                   				tstudid.setText(""+no);
                                   			}	
				}
				catch(Exception e) {}

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
			if(tsnm.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this,"Please Enter Student's Name","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(tdt.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this,"Please Enter the Date","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(cb1.getSelectedIndex()==0)
			{
				JOptionPane.showMessageDialog(this,"Please select the Course","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(r1.isSelected()==false && r2.isSelected()==false)
			{
				JOptionPane.showMessageDialog(this,"Please Select Course","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			if(tri1.getText().length()>4||tri2.getText().length()>4)  
			{
				JOptionPane.showMessageDialog(this,"Remaining Installments should not be greater than 4","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(tinstll1.getText().length()>4||tinstll2.getText().length()>4)  
			{
				JOptionPane.showMessageDialog(this,"No of Installments should not be greater than 4","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}
			try
			{		
				PreparedStatement st=con.prepareStatement("UPDATE fees set I_Date=?,Student_Name=?,Course_Name=?,Faculty=?,Total_Fees=?,No_Of_Installments=?,Fees_Paid=?,Balance_Fees=?,Current_Pay_Fees=?,Remaining_Installments=? WHERE Student_ID=?");
					
				st.setString(1,tdt.getText());
				st.setString(2,tsnm.getText());
				st.setString(3,(String)cb1.getSelectedItem());
				
				if(r1.isSelected()==true)
				{
					int b=Integer.parseInt(tlf1.getText());
  					int t=Integer.parseInt(ttcfs1.getText());
				
					int f=Integer.parseInt(tfp1.getText());
					int c=Integer.parseInt(tcpf1.getText());
					int ri=Integer.parseInt(tri1.getText());

					int fp=t-b;
					int tot=f+c;

					st.setString(4,"Modular Courses");
					st.setInt(5,t);
					st.setString(6,tinstll1.getText());
					if(ri==0)
					{
						st.setInt(7,tot);
					}
					else
					{
						st.setInt(7,fp);
					}
					st.setInt(8,b);
					st.setInt(9,c);
					st.setInt(10,ri); 
				}
				else
				{
					int b=Integer.parseInt(tlf2.getText());   
  					int t=Integer.parseInt(ttcfs2.getText());    
					
					int f=Integer.parseInt(tfp2.getText());	
					int c=Integer.parseInt(tcpf2.getText());	
					int ri=Integer.parseInt(tri2.getText());	
					
					int fp=t-b;
					int tot=f+c;

					st.setString(4,"Certificate Courses");
					st.setInt(5,t);
					st.setString(6,tinstll2.getText());
					if(ri==0)
					{
						st.setInt(7,tot);
					}
					else
					{
						st.setInt(7,fp);
					}
					st.setInt(8,b);
					st.setInt(9,c);
					st.setInt(10,ri); 
					
				}
				st.setString(11,tstudid.getText());		
				st.executeUpdate();
				JOptionPane.showMessageDialog(null,"Installments Updated Successfully!");
				tstudid.setText("");
				tdt.setText("");
				tsnm.setText("");  
				cb1.setSelectedIndex(0);
				ttcfs1.setText("");
				tinstll1.setText("");
				tfp1.setText("");
				tlf1.setText("");
				ttcfs2.setText("");
				tinstll2.setText("");
				tfp2.setText("");
				tlf2.setText("");
				tri1.setText("");
				tri2.setText("");
				tcpf1.setText("");
				tcpf2.setText("");
				bg.clearSelection();
				tstudid.requestFocus();
			}
			catch(Exception e) 
			{
				System.out.println("error!");
			}
		}

/*****************************************************Code For Close the Window**************************************************/
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
			tstudid.setText("");
			tdt.setText("");
			tsnm.setText("");  
			cb1.setSelectedIndex(0);
			ttcfs1.setText("");
			tinstll1.setText("");
			tfp1.setText("");
			tlf1.setText("");
			ttcfs2.setText("");
			tinstll2.setText("");
			tfp2.setText("");
			tlf2.setText("");
			tri1.setText("");
			tri2.setText("");
			tcpf1.setText("");
			tcpf2.setText("");
			bg.clearSelection();
			tstudid.requestFocus();

			bsv.setEnabled(true);
			bsearch.setEnabled(true);
			bupd.setEnabled(true);
			binstallsearch.setEnabled(true);
			bdel.setEnabled(true);
		}
		
		/**************************************Delete the Application********************************************/		
		if(ae.getSource()==bdel)
		{
			int res=JOptionPane.showConfirmDialog((Component)null,"Are you sure to delete the Fees Details at Student ID "+Integer.parseInt(tstudid.getText()),"Delete",JOptionPane.YES_NO_OPTION);
			
			if(res==JOptionPane.YES_OPTION)
			{
				try
				{
			
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					System.out.println("Driver Loaded!");
			
					con=DriverManager.getConnection("jdbc:odbc:CompDSN");
					System.out.println("Connection Established!");

					PreparedStatement st=con.prepareStatement("delete from fees where Student_ID= "+Integer.parseInt(tstudid.getText()));
					st.executeUpdate();
					JOptionPane.showMessageDialog(this,"Deleted the Record at Student ID "+(tstudid.getText())+" Successfully!");
					tstudid.setText("");
					tdt.setText("");
					tsnm.setText("");  
					cb1.setSelectedIndex(0);
					ttcfs1.setText("");
					tinstll1.setText("");
					tfp1.setText("");
					tlf1.setText("");
					ttcfs2.setText("");
					tinstll2.setText("");
					tfp2.setText("");
					tlf2.setText("");
					tri1.setText("");
					tri2.setText("");
					tcpf1.setText("");
					tcpf2.setText("");
					bg.clearSelection();
					tstudid.requestFocus();
				}
				catch(Exception e) {}
			}
			else if(res==JOptionPane.NO_OPTION)
			{
			}	 
		}
		if(ae.getSource()==binstallsearch)  
		{
			try
			{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				System.out.println("Driver Loaded!");
			
				con=DriverManager.getConnection("jdbc:odbc:CompDSN");
				System.out.println("Connection Established!");
	
				Statement st=con.createStatement();
				String id=JOptionPane.showInputDialog(this,"Please enter Student's ID to search the previous Installation Records");
				ResultSet rs=st.executeQuery("select * from fees where Student_ID="+Integer.parseInt(id));  
				if(rs.next())
				{
					
					
					tstudid.setText(""+rs.getString(1));
					tdt.setText(""+rs.getString(2));
					tsnm.setText(""+rs.getString(3));
					cb1.setSelectedItem(rs.getString(4));
					
					String str=rs.getString(5);
					if(str.equals("Modular Courses"))
					{
						int b=Integer.parseInt(rs.getString(9));
						int r=Integer.parseInt(rs.getString(11));

						if(b==0)
						{
							JOptionPane.showMessageDialog(this,"You have completed all the Installments.Thank you!");
							tstudid.setText("");
							tdt.setText("");
							tsnm.setText("");  
							cb1.setSelectedIndex(0);
							ttcfs1.setText("");
							tinstll1.setText("");
							tfp1.setText("");
							tlf1.setText("");
							ttcfs2.setText("");
							tinstll2.setText("");
							tfp2.setText("");
							tlf2.setText("");
							tri1.setText("");
							tri2.setText("");
							tcpf1.setText("");
							tcpf2.setText("");
							bg.clearSelection();
							tstudid.requestFocus();

							bsv.setEnabled(false);
							bsearch.setEnabled(false);
							bupd.setEnabled(false);
							binstallsearch.setEnabled(false);
							bdel.setEnabled(false);

							return;
						}
						int ri=r-1;
						r1.setSelected(true);
						ttcfs1.setText(""+rs.getString(6));
						tinstll1.setText(""+rs.getString(7));
						tfp1.setText(""+rs.getString(8));
						//tlf1.setText(""+b);
						tri1.setText(""+ri);
					}

					else
					{
						int b=Integer.parseInt(rs.getString(9));
						int r=Integer.parseInt(rs.getString(11));

						if(b==0)
						{
							JOptionPane.showMessageDialog(this,"You have completed all the Installments.Thank you!");
							tstudid.setText("");
							tdt.setText("");
							tsnm.setText("");  
							cb1.setSelectedIndex(0);
							ttcfs1.setText("");
							tinstll1.setText("");
							tfp1.setText("");
							tlf1.setText("");
							ttcfs2.setText("");
							tinstll2.setText("");
							tfp2.setText("");
							tlf2.setText("");
							tri1.setText("");
							tri2.setText("");
							tcpf1.setText("");
							tcpf2.setText("");
							bg.clearSelection();
							tstudid.requestFocus();

							bsv.setEnabled(false);
							bsearch.setEnabled(false);
							bupd.setEnabled(false);
							binstallsearch.setEnabled(false);
							bdel.setEnabled(false);

							return;
						}
						int ri=r-1;
						r2.setSelected(true);
						ttcfs2.setText(""+rs.getString(6));
						tinstll2.setText(""+rs.getString(7));
						tfp2.setText(""+rs.getString(8));
						//tlf2.setText(""+b);
						tri2.setText(""+ri);	
						
					}
					//bsv.setEnabled(false);
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Record Not Found........");
				}
			}
			catch(Exception e) {}
		}

	}
	/*********************************************Focus Listener*********************************/
	public void focusLost (FocusEvent fe) { }

	public void focusGained (FocusEvent fe) 
	{
		/*************Calculate Remaining No of installments***************************/
		/******************************************For Modular Courses*******************/
		Object obj1 = fe.getSource ();
			
		if(obj1== tri1) 
		{
			int in1;
			in1=Integer.parseInt(tinstll1.getText());
				
			if(in1==4)
			{
				tri1.setText(""+(in1-1));	
			}
			else if(in1==3)
			{
				tri1.setText(""+(in1-1));	
			}
			else if(in1==2)
			{
				tri1.setText(""+(in1-1));	
			}
			else if(in1==1)
			{
				tri1.setText(""+(in1-1));	
			}
			else
			{
				JOptionPane.showMessageDialog(this,"All Installments are Completed","Error",JOptionPane.ERROR_MESSAGE);
				return;	
			}

		}
		/***********************************For Certificate Courses***************************/
		else if(obj1== tri2) 
		{
			int in2;
			in2=Integer.parseInt(tinstll2.getText());
			if(in2==4)
			{
				tri2.setText(""+(in2-1));	
			}
			else if(in2==3)
			{
				tri2.setText(""+(in2-1));		
			}
			else if(in2==2)
			{
				tri2.setText(""+(in2-1));		
			}
			else if(in2==1)
			{
				tri2.setText(""+(in2-1));			
			}
			else 
			{
				JOptionPane.showMessageDialog(this,"All Installments are Completed","Error",JOptionPane.ERROR_MESSAGE);
				return;	
			}
		}
		/*************Calculate Balance Fees***************************/
		/*****************************************For Modular Courses*******************/
		Object obj2 = fe.getSource ();

		if (obj2 == tlf1) 
		{
			int x,y,z,bf;
			x=Integer.parseInt(ttcfs1.getText());
			y=Integer.parseInt(tfp1.getText());
			z=Integer.parseInt(tcpf1.getText());
			bf=x-(y+z);
			tlf1.setText(""+bf);
					
		}	
		/***********************************For Certificate Courses***************************/
		else if(obj2== tlf2) 
		{
			int x,y,z,bf;
			x=Integer.parseInt(ttcfs2.getText());
			y=Integer.parseInt(tfp2.getText());
			z=Integer.parseInt(tcpf2.getText());
			bf=x-(y+z);
			tlf2.setText(""+bf);
		}
	}
	public void keyTyped(KeyEvent ke) 
	{
		char s=ke.getKeyChar();
		if(ke.getSource()==ttcfs1 || ke.getSource()==ttcfs2)
		{
			if(!(Character.isDigit(s)||s==ke.VK_SLASH||(s==ke.VK_BACK_SPACE)))
			{
				JOptionPane.showMessageDialog(this,"Characters are not allowed","Error",JOptionPane.ERROR_MESSAGE);
				ke.consume();
			}
		}
		if(ke.getSource()==tinstll1 || ke.getSource()==tinstll2)
		{
			if(!(Character.isDigit(s)||s==ke.VK_SLASH||(s==ke.VK_BACK_SPACE)))
			{
				JOptionPane.showMessageDialog(this,"Characters are not allowed","Error",JOptionPane.ERROR_MESSAGE);
				ke.consume();
			}
		}
		if(ke.getSource()==tfp1 || ke.getSource()==tfp2)
		{
			if(!(Character.isDigit(s)||s==ke.VK_SLASH||(s==ke.VK_BACK_SPACE)))
			{
				JOptionPane.showMessageDialog(this,"Characters are not allowed","Error",JOptionPane.ERROR_MESSAGE);
				ke.consume();
			}
		}
		if(ke.getSource()==tlf1 || ke.getSource()==tlf2)
		{
			if(!(Character.isDigit(s)||s==ke.VK_SLASH||(s==ke.VK_BACK_SPACE)))
			{
				JOptionPane.showMessageDialog(this,"Characters are not allowed","Error",JOptionPane.ERROR_MESSAGE);
				ke.consume();
			}
		}
		if(ke.getSource()==tcpf1 || ke.getSource()==tcpf2)
		{
			if(!(Character.isDigit(s)||s==ke.VK_SLASH||(s==ke.VK_BACK_SPACE)))
			{
				JOptionPane.showMessageDialog(this,"Characters are not allowed","Error",JOptionPane.ERROR_MESSAGE);
				ke.consume();
			}
		}
		if(ke.getSource()==tri1 || ke.getSource()==tri2)
		{
			if(!(Character.isDigit(s)||s==ke.VK_SLASH||(s==ke.VK_BACK_SPACE)))
			{
				JOptionPane.showMessageDialog(this,"Characters are not allowed","Error",JOptionPane.ERROR_MESSAGE);
				ke.consume();
			}
		}
		if(ke.getSource()==tstudid)
		{
			if(!(Character.isDigit(s)||(s==ke.VK_BACK_SPACE)))
			{
				JOptionPane.showMessageDialog(this,"Characters are not allowed","Error",JOptionPane.ERROR_MESSAGE);
				ke.consume();
			}
		}
		if(ke.getSource()==tsnm)
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
	
	/****************************************************************************************************************************/
	public static void main(String args[])
	{
		new FeesInstallment();
	}
}













