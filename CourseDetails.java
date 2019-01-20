import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import java.text.*;

public class CourseDetails extends JInternalFrame implements ActionListener,ItemListener
{
	Container cp;
	JLabel lstudid,lsnm,lcn,ldur,lcn1,lcn2,ldur1,ldur2,ltcfs;
	JTextField tstudid,tsnm,tcn,tdur,ttcfs;
	JButton breset,bupd,bsv,bcls,bdel,bsearch;
	JRadioButton r1,r2,r3,r4,r5,r6,r7,r8,r9,r10,r11;
	ButtonGroup bg1;
	JComboBox cb1,cb2; 
	JPanel jp1,jp2,jp3,jp4;
	Dimension dim;
	Connection con;

	Font f1=new Font("Cambria",Font.BOLD,14);
	Font f2=new Font("Cambria",Font.BOLD,14);
	
	CourseDetails()
	{
		cp=getContentPane();
		cp.setLayout(null);
		dim=new Dimension();
		dim=Toolkit.getDefaultToolkit().getScreenSize();

		jp1=new JPanel();
		jp1.setBounds(10,10,710,130);
		jp1.setBorder(BorderFactory.createLineBorder(Color.white,1));
		jp1.setBackground(Color.decode("#200000")); 
	
		jp2=new JPanel();
		jp2.setBounds(10,450,710,55);
		jp2.setBorder(BorderFactory.createLineBorder(Color.white,1));
		jp2.setBackground(Color.decode("#200000")); 
		
		jp3=new JPanel();
		jp3.setBounds(10,150,350,230);
		jp3.setBorder(BorderFactory.createLineBorder(Color.white,1));
		jp3.setBackground(Color.decode("#200000")); 

		jp4=new JPanel();
		jp4.setBounds(370,150,350,230);
		jp4.setBorder(BorderFactory.createLineBorder(Color.white,1));
		jp4.setBackground(Color.decode("#200000")); 
		
		/**********************************Labels****************************/
		lstudid=new JLabel("Student ID: ");
		lsnm=new JLabel("Name of Student: ");
		lcn=new JLabel("Course Name: ");
		ldur=new JLabel("Duration: ");
		lcn1=new JLabel("1] Modular Courses: ");
		lcn2=new JLabel("2] Certificate Courses: ");
		ltcfs=new JLabel("Total Course Fees: ");
		
		ldur1=new JLabel("Duration: ");
		ldur2=new JLabel("Duration: ");
		
		/**********************************Text Fields**************************/
		tstudid=new JTextField(20);
		tsnm=new JTextField(20);
		ttcfs=new JTextField(20);
		tcn=new JTextField(20);
		tdur=new JTextField(30);
		
		/************************************Buttons******************************/
		breset=new JButton("RESET");
		bupd=new JButton("UPDATE");		
		bsv=new JButton("SAVE");					
		bcls=new JButton("CLOSE");	
		bdel=new JButton("DELETE");	
		bsearch=new JButton("SEARCH");	
		/*****************************************ComboBox********************************/
		cb1=new JComboBox();
		cb1.addItem("---------Select--------");
		cb1.addItem("4 to 6 Weeks");
		cb1.addItem("3 Months");
		
		cb2=new JComboBox();
		cb2.addItem("---------Select--------");
		cb2.addItem("4 to 6 Weeks");
		cb2.addItem("3 Months");

		/**************************************Radio Button***********************/			
		
		r1=new JRadioButton("Certificate Course in Information Technology(CCIT)");
		r2=new JRadioButton("Certificate Course in DTP(CCDTP)");
		r3=new JRadioButton("Certificate Course in C");
		r4=new JRadioButton("Certificate Courses in C++");
		r5=new JRadioButton("Certificate Course in Java");
		
		r6=new JRadioButton("MS-Office");
		r7=new JRadioButton("SQL");
		r8=new JRadioButton("HTML");
		r9=new JRadioButton("Corel Draw"); 
		r10=new JRadioButton("Tally");
		r11=new JRadioButton("Photoshop");
				
		/**********************************************************************************************************************************/
	
		cp.add(lstudid);
		lstudid.setBounds(20,15,90,30);
		lstudid.setFont(f1);
		lstudid.setForeground(Color.decode("#FFFFFF"));
		cp.add(tstudid);
		tstudid.setBounds(130,20,100,22);
		tstudid.setFont(f2);
		tstudid.setForeground(Color.black);
		tstudid.setBorder(BorderFactory.createLineBorder(Color.black,1));

		
		cp.add(lsnm);
		lsnm.setBounds(20,45,150,30);
		lsnm.setFont(f1);
		lsnm.setForeground(Color.decode("#FFFFFF"));
		cp.add(tsnm);
		tsnm.setBounds(130,50,300,22);
		tsnm.setFont(f2);
		tsnm.setForeground(Color.black);
		tsnm.setBorder(BorderFactory.createLineBorder(Color.black,1));
		
		cp.add(lcn);
		lcn.setBounds(20,75,150,30);
		lcn.setFont(f1);
		lcn.setForeground(Color.decode("#FFFFFF"));
		cp.add(tcn);
		tcn.setBounds(130,80,300,22);
		tcn.setFont(f2);
		tcn.setForeground(Color.black);
		tcn.setBorder(BorderFactory.createLineBorder(Color.black,1));
		
		cp.add(ldur);
		ldur.setBounds(20,105,150,30);
		ldur.setFont(f1);
		ldur.setForeground(Color.decode("#FFFFFF"));
		cp.add(tdur);
		tdur.setBounds(130,110,150,22);
		tdur.setFont(f2);
		tdur.setForeground(Color.black);
		tdur.setBorder(BorderFactory.createLineBorder(Color.black,1));
		
		cp.add(jp1);

		cp.add(lcn1);
		lcn1.setBounds(40,150,130,30);
		lcn1.setFont(f1);
		lcn1.setForeground(Color.decode("#FFFFFF"));

		cp.add(r6);
		r6.setBounds(50,180,100,30);
		r6.setFont(f1);
		r6.setBackground(Color.decode("#200000"));
		r6.setForeground(Color.decode("#FFFFFF"));
		cp.add(r7);
		r7.setBounds(160,180,100,30);
		r7.setFont(f1);
		r7.setBackground(Color.decode("#200000"));
		r7.setForeground(Color.decode("#FFFFFF"));
		cp.add(r8);
		r8.setBounds(50,210,100,30);
		r8.setFont(f1);
		r8.setBackground(Color.decode("#200000"));
		r8.setForeground(Color.decode("#FFFFFF"));
		cp.add(r9);
		r9.setBounds(160,210,100,30);
		r9.setFont(f1);
		r9.setBackground(Color.decode("#200000"));
		r9.setForeground(Color.decode("#FFFFFF"));
		cp.add(r10);
		r10.setBounds(50,240,100,30);
		r10.setFont(f1);
		r10.setBackground(Color.decode("#200000"));
		r10.setForeground(Color.decode("#FFFFFF"));
		cp.add(r11);
		r11.setBounds(160,240,100,30);
		r11.setFont(f1);
		r11.setBackground(Color.decode("#200000"));
		r11.setForeground(Color.decode("#FFFFFF"));
		
		cp.add(ldur1);
		ldur1.setBounds(40,340,80,30);
		ldur1.setFont(f1);
		ldur1.setForeground(Color.decode("#FFFFFF"));
		cp.add(cb1);
		cb1.setBounds(140,340,150,25);
		cb1.setFont(f2);
		cb1.setForeground(Color.black);
		cb1.setBorder(BorderFactory.createLineBorder(Color.black,1));
		
		
		cp.add(jp3);
		

		cp.add(lcn2);
		lcn2.setBounds(380,150,150,30);
		lcn2.setFont(f1);
		lcn2.setForeground(Color.decode("#FFFFFF"));

		cp.add(r1);
		r1.setBounds(390,180,320,30);
		r1.setFont(f1);
		r1.setBackground(Color.decode("#200000"));
		r1.setForeground(Color.decode("#FFFFFF"));

		cp.add(r2);
		r2.setBounds(390,210,260,30);
		r2.setFont(f1);
		r2.setBackground(Color.decode("#200000"));
		r2.setForeground(Color.decode("#FFFFFF"));

		cp.add(r3);
		r3.setBounds(390,240,260,30);
		r3.setFont(f1);
		r3.setBackground(Color.decode("#200000"));
		r3.setForeground(Color.decode("#FFFFFF"));

		cp.add(r4);
		r4.setBounds(390,270,260,30);
		r4.setFont(f1);
		r4.setBackground(Color.decode("#200000"));
		r4.setForeground(Color.decode("#FFFFFF"));

		cp.add(r5);
		r5.setBounds(390,300,260,30);
		r5.setFont(f1);
		r5.setBackground(Color.decode("#200000"));
		r5.setForeground(Color.decode("#FFFFFF"));
		
		cp.add(ldur2);
		ldur2.setBounds(380,340,80,30);
		ldur2.setFont(f1);
		ldur2.setForeground(Color.decode("#FFFFFF"));
		cp.add(cb2);
		cb2.setBounds(470,340,150,25);
		cb2.setFont(f2);
		cb2.setForeground(Color.black);
		cb2.setBorder(BorderFactory.createLineBorder(Color.black,1));

		cp.add(jp4);
		
		cp.add(ltcfs);
		ltcfs.setBounds(20,400,150,30);
		ltcfs.setFont(f1);
		ltcfs.setForeground(Color.decode("#FFFFFF"));
		cp.add(ttcfs);
		ttcfs.setBounds(140,405,150,22);
		ttcfs.setFont(f2);
		ttcfs.setForeground(Color.black);
		ttcfs.setBorder(BorderFactory.createLineBorder(Color.black,1));
		
		
		cp.add(bupd);
		bupd.setBounds(70,465,80,25);
		bupd.setFont(f1);
		bupd.setBorder(BorderFactory.createLineBorder(Color.white,1));
		bupd.setBackground(Color.black);
		bupd.setForeground(Color.red);

		cp.add(bsv);	
		bsv.setBounds(170,465,80,25);
		bsv.setFont(f1);
		bsv.setBorder(BorderFactory.createLineBorder(Color.white,1));
		bsv.setBackground(Color.black);
		bsv.setForeground(Color.red);

		cp.add(bsearch);	
		bsearch.setBounds(270,465,80,25);
		bsearch.setFont(f1);
		bsearch.setBorder(BorderFactory.createLineBorder(Color.white,1));
		bsearch.setBackground(Color.black);
		bsearch.setForeground(Color.red);

		cp.add(breset);
		breset.setBounds(370,465,80,25);
		breset.setFont(f1);
		breset.setBorder(BorderFactory.createLineBorder(Color.white,1));
		breset.setBackground(Color.black);
		breset.setForeground(Color.red);

		
		cp.add(bdel);		
		bdel.setBounds(470,465,80,25);
		bdel.setFont(f1);
		bdel.setBorder(BorderFactory.createLineBorder(Color.white,1));
		bdel.setBackground(Color.black);
		bdel.setForeground(Color.red);


		cp.add(bcls);	
		bcls.setBounds(570,465,80,25);
		bcls.setFont(f1);
		bcls.setBorder(BorderFactory.createLineBorder(Color.white,1));
		bcls.setBackground(Color.black);
		bcls.setForeground(Color.red);


		cp.add(jp2);
		
		bupd.addActionListener(this);
		bsv.addActionListener(this);
		bcls.addActionListener(this);
		breset.addActionListener(this);	
		bdel.addActionListener(this);
		bsearch.addActionListener(this);
	
		bupd.setToolTipText("Update the Records");
		bsv.setToolTipText("Save the Records");
		bcls.setToolTipText("Close form");
		breset.setToolTipText("Clear");
		bdel.setToolTipText("Delete the Records");
		bsearch.setToolTipText("Search the Records");
		

		r1.addActionListener(this);
		r2.addActionListener(this);
		r3.addActionListener(this);
		r4.addActionListener(this);
		r5.addActionListener(this);
		r6.addActionListener(this);
		r7.addActionListener(this);
		r8.addActionListener(this);
		r9.addActionListener(this);
		r10.addActionListener(this);
		r11.addActionListener(this);

		cb1.addItemListener(this);
		cb2.addItemListener(this);

		bg1=new ButtonGroup();
		bg1.add(r6);
		bg1.add(r7);
		bg1.add(r8);
		bg1.add(r9);
		bg1.add(r10);
		bg1.add(r11);
		bg1.add(r1);
		bg1.add(r2);
		bg1.add(r3);
		bg1.add(r4);
		bg1.add(r5);

		setBounds(245,95,(dim.width-300),(dim.height-115));  
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setIconifiable(true);
		setClosable(true);	
		setVisible(true);
		setSize(740,550);
		cp.setBackground(Color.black);
		setTitle("Course Details");


		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			System.out.println("Driver Loaded!");
		
			con=DriverManager.getConnection("jdbc:odbc:CompDSN");
			System.out.println("Connection Established!");
	
			Statement st=con.createStatement();
                                   	ResultSet rs=st.executeQuery("select * from course");
                                  	while(rs.next())
                                 	{
                                   		int no=rs.getInt(1);
                                   		no++;
                                   		tstudid.setText(""+no);
                                 	}
		}
		catch(Exception e) {}

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
				long No;					//Use for Comparing the stud's Id.
				boolean found = false;				//To Confirm the stud's Id Existance.
				
				try 
				{
					Statement st=con.createStatement();	
					//SELECT Query to Retrieved the Record.

					String q = "SELECT * FROM admission WHERE Student_ID = " + id + "";
					ResultSet rs = st.executeQuery (q);	//Executing the Query.
					rs.next ();				//Moving towards the Record.
					No = rs.getLong ("Student_ID");		//Storing the Record.
					if (No == id) 
					{			//If Record Found then Display Records.
						found = true;
						tstudid.setText ("" + id);
						tsnm.setText ("" + rs.getString ("Student_Name"));
						tcn.setText ("" + rs.getString ("Course_Name"));
						ttcfs.setText ("" + rs.getString ("Total_Course_Fees"));
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
						tsnm.setText ("");
						tcn.setText ("");
						ttcfs.setText ("");
						JOptionPane.showMessageDialog (this, "Record not Found......");
					}
				}
			}

		}
	}
	
	public void itemStateChanged(ItemEvent ie)
	{
		String str=(String)ie.getItem();
		tdur.setText(str);
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

		if(r6.isSelected()==true)		
		{
			tcn.setText("MS-Office");
		}
		else if(r7.isSelected()==true)
		{
			tcn.setText("SQL");
		}					
		else if(r8.isSelected()==true)
		{
			tcn.setText("HTML");
		}
		else if(r9.isSelected()==true)
		{
			tcn.setText("Corel Draw");
		}
		else if(r10.isSelected()==true)
		{
			tcn.setText("Tally");
		}
		else if(r11.isSelected()==true)
		{
			tcn.setText("Photoshop");
		}
		else if(r1.isSelected()==true)
		{
			tcn.setText("Certificate Course in Information Technology(CCIT)");
		}
		else if(r2.isSelected()==true)
		{
			tcn.setText("Certificate Course in DTP(CCDTP)");
		}
		else if(r3.isSelected()==true)
		{
			tcn.setText("Certificate Course in C");
		}
		else if(r4.isSelected()==true)
		{
			tcn.setText("Certificate Course in C++");
		}
		else if(r5.isSelected()==true)
		{
			tcn.setText("Certificate Course in Java");
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
				JOptionPane.showMessageDialog(this,"Please Enter the Batch Code","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(tsnm.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this,"Please Enter Student's Name","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(tcn.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this,"Please Enter the Course Name","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(tdur.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this,"Please Enter Duration of the Course","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(ttcfs.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this,"Please Enter Total Course Fees","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			try
			{
				PreparedStatement st=con.prepareStatement("INSERT into course values(?,?,?,?,?)");
				st.setString(1,tstudid.getText());
				st.setString(2,tsnm.getText());
				st.setString(3,tcn.getText());
				st.setString(4,tdur.getText());		
				st.setString(5,ttcfs.getText());
				st.executeUpdate();
				JOptionPane.showMessageDialog(null,"Course Details Saved Successfully!");
				tstudid.setText("");
			tsnm.setText("");
			tcn.setText("");  
			bg1.clearSelection();
			cb1.setSelectedIndex(0);
			cb2.setSelectedIndex(0);
			tdur.setText("");
			ttcfs.setText("");
			tstudid.requestFocus();
			}
			catch(Exception e) {}
		}
		/***********************************Code for Update the Application***************************/
		if(ae.getSource()==bupd)
		{
				if(tstudid.getText().equals(""))  
			{
				JOptionPane.showMessageDialog(this,"Please Enter the Batch Code","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(tsnm.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this,"Please Enter Student's Name","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(tcn.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this,"Please Enter the Course Name","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(tdur.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this,"Please Enter Duration of the Course","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(ttcfs.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this,"Please Enter Total Course Fees","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}
				try
				{		
					PreparedStatement st=con.prepareStatement("UPDATE course set Student_Name=?,Course_Name=?,Duration=?,Total_Course_Fees=? "+" WHERE Student_ID= ?");
					st.setString(1,tsnm.getText());
					st.setString(2,tcn.getText());
					st.setString(3,tdur.getText());		
					st.setString(4,ttcfs.getText());
					st.setString(5,tstudid.getText());
					st.executeUpdate();
					//System.out.println(s);
					JOptionPane.showMessageDialog(null,"Updated!");

					tstudid.setText("");
			tsnm.setText("");
			tcn.setText("");  
			bg1.clearSelection();
			cb1.setSelectedIndex(0);
			cb2.setSelectedIndex(0);
			tdur.setText("");
			ttcfs.setText("");
			tstudid.requestFocus();
				}
				catch(Exception e) 
				{
					System.out.println("error");
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
				ResultSet rs=st.executeQuery("select * from admission where Student_ID="+tstudid.getText());  
				if(rs.next())
				{
					tstudid.setText(""+rs.getString(1));
					tsnm.setText(""+rs.getString(2));
					tcn.setText(""+rs.getString(5));
					ttcfs.setText(""+rs.getString(6));
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Record Not Found........");
				}

			}
			catch(Exception e) {}
		}
		
		/**************************************Delete the Application********************************************/
		
		if(ae.getSource()==bdel)
		{
			int res=JOptionPane.showConfirmDialog((Component)null,"Are you sure to delete the Course Details at Student ID "+Integer.parseInt(tstudid.getText()),"Delete",JOptionPane.YES_NO_OPTION);
			
			if(res==JOptionPane.YES_OPTION)
			{
				try
				{
			
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					System.out.println("Driver Loaded!");
			
					con=DriverManager.getConnection("jdbc:odbc:CompDSN");
					System.out.println("Connection Established!");

					PreparedStatement st=con.prepareStatement("delete from course where Student_ID= "+Integer.parseInt(tstudid.getText()));
					st.executeUpdate();
					JOptionPane.showMessageDialog(this,"Deleted the Record at Student_ID "+tstudid.getText()+" Successfully!");
				}
				catch(Exception e) {}
			}
			else if(res==JOptionPane.NO_OPTION)
			{
			}	 
		}

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
			tstudid.setText("");
			tsnm.setText("");
			tcn.setText("");  
			bg1.clearSelection();
			cb1.setSelectedIndex(0);
			cb2.setSelectedIndex(0);
			tdur.setText("");
			ttcfs.setText("");
			tstudid.requestFocus();

			try
			{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				System.out.println("Driver Loaded!");
			
				con=DriverManager.getConnection("jdbc:odbc:CompDSN");
				System.out.println("Connection Established!");
	
				Statement st=con.createStatement();
                                   		ResultSet rs=st.executeQuery("select * from course");
                                  		while(rs.next())
                                 		{
                                   			int no=rs.getInt(1);
                                   			no++;
                                   			tstudid.setText(""+no);
                                 		}
			}
			catch(Exception e) {}

		}
		
	}
	public static void main(String args[])
	{
		CourseDetails cd=new CourseDetails();
	}
}



