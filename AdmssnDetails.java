import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import java.util.Calendar;


public class AdmssnDetails extends JInternalFrame implements ActionListener,KeyListener,ItemListener,FocusListener
{
	Container cp;
	JLabel lstudid,lsnm,ldoa,lcn,ltcfs,ladmfs;
	JTextField tstudid,tsnm,ttcfs,tadmfs;
	JFormattedTextField tdoa;
	JButton breset,bupd,bsv,bcls,bdel;
	JRadioButton r1,r2;
	ButtonGroup bg;
	JComboBox cb2,cb3; 
	JPanel jp1,jp2;
	Dimension dim;
	Connection con;
			
	Font f1=new Font("Cambria",Font.BOLD,14);
	Font f2=new Font("Cambria",Font.BOLD,14);
	
	AdmssnDetails()
	{
		cp=getContentPane();
		cp.setLayout(null);
		dim=new Dimension();
		dim=Toolkit.getDefaultToolkit().getScreenSize();
		java.util.Date currDate=new java.util.Date();
		SimpleDateFormat sdf=new SimpleDateFormat("dd"+"/"+"MM"+"/"+"yyyy",Locale.getDefault());
		String d=sdf.format(currDate);

		jp1=new JPanel();
		jp1.setBounds(10,10,570,370);
		jp1.setBorder(BorderFactory.createLineBorder(Color.white,1));
		jp1.setBackground(Color.decode("#200000")); //decode("#F9B7FF")  
	
		jp2=new JPanel();
		jp2.setBounds(10,395,570,55);
		jp2.setBorder(BorderFactory.createLineBorder(Color.white,1));
		jp2.setBackground(Color.decode("#200000")); //decode("#F9B7FF")
		
		/**********************************Labels****************************/
		lstudid=new JLabel("Student ID: ");
		lsnm=new JLabel("Student's Name: ");
		ldoa=new JLabel("Date of Admission: ");
		lcn=new JLabel("Course Name: ");
		ltcfs=new JLabel("Total Course Fees: ");
		ladmfs=new JLabel("Admission Fees: ");
	
		/**********************************Text Fields**************************/
		tstudid=new JTextField(20);
		tsnm=new JTextField(20);
		ttcfs=new JTextField(20);
		tadmfs=new JTextField(20);	
		tdoa=new JFormattedTextField();
	
		/************************************Buttons******************************/
		breset=new JButton("RESET");
		bupd=new JButton("UPDATE");		
		bsv=new JButton("SAVE");					
		bcls=new JButton("CLOSE");	
		bdel=new JButton("DELETE");	
		/*****************************************ComboBox********************************/
		
		cb2=new JComboBox();
		cb2.addItem("");
		cb2.addItem("MS Office");
		cb2.addItem("HTML");
		cb2.addItem("Corel Draw");
		cb2.addItem("Tally");
		cb2.addItem("SQL");
		cb2.addItem("Photoshop");

		cb3=new JComboBox();
		cb3.addItem("");
		cb3.addItem("Certificate course in Information Technology(CCIT)");
		cb3.addItem("Certificate course in DTP(CCDTP)");
		cb3.addItem("Certificate course in C");
		cb3.addItem("Certificate course in C++");
		cb3.addItem("Certificate course in Java");

		/**************************************Radio Button***********************/			
		
		r1=new JRadioButton("Modular Courses: ");
		r2=new JRadioButton("Certificate Courses: ");
		/*********************************************************************************/

		cp.add(lstudid);
		lstudid.setBounds(25,20,80,30);
		lstudid.setFont(f1);
		lstudid.setForeground(Color.decode("#FFFFFF"));
		cp.add(tstudid);
		tstudid.setBounds(150,25,100,22);
		tstudid.setFont(f2);
		tstudid.setForeground(Color.black);
		tstudid.setBorder(BorderFactory.createLineBorder(Color.black,1));
		
		cp.add(lsnm);
		lsnm.setBounds(25,50,150,30);
		lsnm.setFont(f1);
		lsnm.setForeground(Color.decode("#FFFFFF"));
		cp.add(tsnm);
		tsnm.setBounds(150,55,200,22);
		tsnm.setFont(f2);
		tsnm.setForeground(Color.black);
		tsnm.setBorder(BorderFactory.createLineBorder(Color.black,1));
	
		cp.add(ldoa);
		ldoa.setBounds(25,85,150,30);
		ldoa.setFont(f1);
		ldoa.setForeground(Color.decode("#FFFFFF"));
		cp.add(tdoa);
		tdoa.setBounds(150,90,100,22);
		tdoa.setFont(f2);
		tdoa.setForeground(Color.black);
		tdoa.setBorder(BorderFactory.createLineBorder(Color.black,1));
	
		
		cp.add(lcn);
		lcn.setBounds(25,130,90,30);
		lcn.setFont(f1);
		lcn.setForeground(Color.decode("#FFFFFF"));
		cp.add(r1);
		r1.setBounds(55,160,140,30);
		r1.setFont(f1);
		r1.setBackground(Color.decode("#200000"));
		r1.setForeground(Color.decode("#FFFFFF"));
		cp.add(cb2);
		cb2.setBounds(205,165,150,23);
		cb2.setFont(f2);
		cb2.setForeground(Color.black);
		cb2.setBorder(BorderFactory.createLineBorder(Color.black,1));	
		cp.add(r2);
		r2.setBounds(55,210,150,30);
		r2.setFont(f1);
		r2.setBackground(Color.decode("#200000"));
		r2.setForeground(Color.decode("#FFFFFF"));
		cp.add(cb3);
		cb3.setBounds(205,215,330,23);
		cb3.setFont(f2);
		cb3.setForeground(Color.black);
		cb3.setBorder(BorderFactory.createLineBorder(Color.black,1));	
	
		cp.add(ltcfs);
		ltcfs.setBounds(25,260,200,30);	
		ltcfs.setFont(f1);
		ltcfs.setForeground(Color.decode("#FFFFFF"));
		cp.add(ttcfs);
		ttcfs.setBounds(150,265,150,22);
		ttcfs.setFont(f2);
		ttcfs.setForeground(Color.black);
		ttcfs.setBorder(BorderFactory.createLineBorder(Color.black,1));	
	
		cp.add(ladmfs);
		ladmfs.setBounds(25,300,200,30);
		ladmfs.setFont(f1);	
		ladmfs.setForeground(Color.decode("#FFFFFF"));
		cp.add(tadmfs);
		tadmfs.setBounds(150,305,150,22);
		tadmfs.setFont(f2);
		tadmfs.setForeground(Color.black);
		tadmfs.setBorder(BorderFactory.createLineBorder(Color.black,1));	
		cp.add(jp1);
		

		cp.add(bupd);
		bupd.setBounds(40,410,80,25);
		bupd.setFont(f1);
		bupd.setBorder(BorderFactory.createLineBorder(Color.white,1));
		bupd.setBackground(Color.black);
		bupd.setForeground(Color.red);
		

		cp.add(bsv);	
		bsv.setBounds(150,410,70,25);	
		bsv.setFont(f1);
		bsv.setBorder(BorderFactory.createLineBorder(Color.white,1));
		bsv.setBackground(Color.black);
		bsv.setForeground(Color.red);

		cp.add(breset);
		breset.setBounds(250,410,80,25);
		breset.setFont(f1);
		breset.setBorder(BorderFactory.createLineBorder(Color.white,1));
		breset.setBackground(Color.black);
		breset.setForeground(Color.red);

		cp.add(bdel);		
		bdel.setBounds(360,410,80,25);
		bdel.setFont(f1);
		bdel.setBorder(BorderFactory.createLineBorder(Color.white,1));
		bdel.setBackground(Color.black);
		bdel.setForeground(Color.red);

		cp.add(bcls);	
		bcls.setBounds(470,410,80,25);
		bcls.setFont(f1);
		bcls.setBorder(BorderFactory.createLineBorder(Color.white,1));
		bcls.setBackground(Color.black);
		bcls.setForeground(Color.red);


		cp.add(jp2);
	
		tdoa.setText(""+d);  //Add date into the text field
	
		bupd.addActionListener(this);
		bsv.addActionListener(this);
		bcls.addActionListener(this);
		breset.addActionListener(this);	
		bdel.addActionListener(this);

		tstudid.addFocusListener(this);

		cb2.addItemListener(this);
		cb3.addItemListener(this);
	
		 tstudid.addKeyListener(this);
		 tsnm.addKeyListener(this);
		 ttcfs.addKeyListener(this);
		 tadmfs.addKeyListener(this);
	
		bupd.setToolTipText("Update the Records");
		bsv.setToolTipText("Save the Records");
		bcls.setToolTipText("Close form");
		breset.setToolTipText("Clear");
		bdel.setToolTipText("Delete the Records");
	
		
		/*************************************************************************************************/
		
		bg=new ButtonGroup();
		bg.add(r1);
		bg.add(r2);
		
		cp.setBackground(Color.black);//decode("#350000")
		setBounds(245,100,(dim.width-300),(dim.height-115));  
		setDefaultCloseOperation(JInternalFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setIconifiable(true);
		setClosable(true);	
		setVisible(true);
		setSize(600,495);
		setTitle("Admission Details");
		
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			System.out.println("Driver Loaded!");
		
			con=DriverManager.getConnection("jdbc:odbc:CompDSN");
			System.out.println("Connection Established!");
	
			Statement st=con.createStatement();
                                   	ResultSet rs=st.executeQuery("select * from admission");
                                  	while(rs.next())
                                 	{
                                   		int no=rs.getInt(1);
                                   		no++;
                                   		tstudid.setText(""+no);
                                 	}
		}
		catch(Exception e) {}

		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con=DriverManager.getConnection("jdbc:odbc:CompDSN");
			Statement st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		}
		catch(Exception e)
		{
		JOptionPane.showMessageDialog(null," " +e);
		}
	}
	public void itemStateChanged(ItemEvent ie)
	{
		String str=(String)ie.getItem();
		int f1=2700,a=500;
		int f2=5000,b=900;
		int f3=8000;
		int f4=6000;
		int f5=20000;
		int f6=15000;
		if(str=="MS Office")
		{
			ttcfs.setText(""+f1);
			tadmfs.setText(""+a);
		}
		else if(str=="HTML")
		{
			ttcfs.setText(""+f3);
			tadmfs.setText(""+a);
		}
		else if(str=="Corel Draw")
		{
			ttcfs.setText(""+f2);
			tadmfs.setText(""+a);
		}
		else if(str=="Tally")
		{
			ttcfs.setText(""+f4);
			tadmfs.setText(""+a);	
		}
		else if(str=="SQL")
		{
			ttcfs.setText(""+f3);
			tadmfs.setText(""+a);
		}
		else if(str=="Photoshop")
		{
			ttcfs.setText(""+f2);
			tadmfs.setText(""+a);
		}
		else if(str=="Certificate course in Information Technology(CCIT)")
		{
			ttcfs.setText(""+f6);
			tadmfs.setText(""+b);
		}
		else if(str=="Certificate course in DTP(CCDTP)")
		{
			ttcfs.setText(""+f6);
			tadmfs.setText(""+b);
		}
		else if(str=="Certificate course in C")
		{
			ttcfs.setText(""+f6);
			tadmfs.setText(""+b);
		}
		else if(str=="Certificate course in C++")
		{
			ttcfs.setText(""+f6);
			tadmfs.setText(""+b);
		}
		else if(str=="Certificate course in Java")
		{
			ttcfs.setText(""+f5);
			tadmfs.setText(""+b);
		}
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
			if(tdoa.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this,"Please Enter Date of Admission","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			if(ttcfs.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this,"Please Enter Total Course Fees","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(tadmfs.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this,"Please Enter Admission Fees","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}
			try
			{
				PreparedStatement st=con.prepareStatement("insert into admission values(?,?,?,?,?,?,?)");
				st.setString(1,tstudid.getText());
				st.setString(2,tsnm.getText());
				st.setString(3,tdoa.getText());
				if(r1.isSelected()==true)
				{
					st.setString(4,"Modular Courses");
					st.setString(5,(String)cb2.getSelectedItem());
				}
				else
				{
					st.setString(4,"Certificate Courses");
					st.setString(5,(String)cb3.getSelectedItem());
				}		
				st.setString(6,ttcfs.getText());
				st.setString(7,tadmfs.getText());
				st.executeUpdate();
				JOptionPane.showMessageDialog(null,"Admission Details Saved Successfully!");

				tstudid.setText("");
				tsnm.setText("");  
				bg.clearSelection(); 
				cb2.setSelectedIndex(0);
				cb3.setSelectedIndex(0);
				ttcfs.setText("");
				tadmfs.setText("");
				tstudid.requestFocus();
			}
			catch(Exception e) {}
		}
		/***********************************Code for Update the Application***************************/
		if(ae.getSource()==bupd)
		{
				try
				{		
					PreparedStatement st=con.prepareStatement("UPDATE admission set Student_Name=?,Date_of_Admission=?,Faculty=?,Course_Name=?,Total_Course_Fees=?,Total_Adm_Fees=? WHERE Student_ID=?");
					
					st.setString(1,tsnm.getText());
					st.setString(2,tdoa.getText());
					if(r1.isSelected()==true)
					{
						st.setString(3,"Modular Courses");
						st.setString(4,(String)cb2.getSelectedItem());
					}
					else
					{
						st.setString(3,"Certificate Courses");
						st.setString(4,(String)cb3.getSelectedItem());
					}		
					st.setString(5,ttcfs.getText());
					st.setString(6,tadmfs.getText());	
					st.setString(7,tstudid.getText());
					st.executeUpdate();
					JOptionPane.showMessageDialog(null,"Updated!");
			
					tstudid.setText("");
					tsnm.setText("");  
					bg.clearSelection(); 
					cb2.setSelectedIndex(0);
					cb3.setSelectedIndex(0);
					ttcfs.setText("");
					tadmfs.setText("");
					tstudid.requestFocus();
				}
				catch(Exception e) 
				{
					System.out.println("error");
				}
		}
		/**************************************Delete the Application********************************************/
		
		if(ae.getSource()==bdel)
		{
			int res=JOptionPane.showConfirmDialog((Component)null,"Are you sure to delete the Admission Details at Student ID "+Integer.parseInt(tstudid.getText()),"Delete",JOptionPane.YES_NO_OPTION);
			
			if(res==JOptionPane.YES_OPTION)
			{
				try
				{
			
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					System.out.println("Driver Loaded!");
			
					con=DriverManager.getConnection("jdbc:odbc:CompDSN");
					System.out.println("Connection Established!");

					PreparedStatement st=con.prepareStatement("delete from admission where Student_ID= "+Integer.parseInt(tstudid.getText()));
					st.executeUpdate();
					JOptionPane.showMessageDialog(this,"Deleted the Record at Student ID "+(tstudid.getText())+" Successfully!");
				
					tstudid.setText("");
					tsnm.setText("");  
					bg.clearSelection(); 
					cb2.setSelectedIndex(0);
					cb3.setSelectedIndex(0);
					ttcfs.setText("");
					tadmfs.setText("");
					tstudid.requestFocus();
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
			bg.clearSelection(); 
			cb2.setSelectedIndex(0);
			cb3.setSelectedIndex(0);
			ttcfs.setText("");
			tadmfs.setText("");
			tstudid.requestFocus();
		
			try
			{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				System.out.println("Driver Loaded!");
		
				con=DriverManager.getConnection("jdbc:odbc:CompDSN");
				System.out.println("Connection Established!");
	
				Statement st=con.createStatement();
                                   		ResultSet rs=st.executeQuery("select * from admission");
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
						tsnm.setText ("" + rs.getString ("Student_Name"));
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
						JOptionPane.showMessageDialog (this, "Record not Found......");
					}
				}
			}

		}
	}
	public void keyTyped(KeyEvent ke)
	{
		char s=ke.getKeyChar();
		if(ke.getSource()==tdoa)
		{
			if(!(Character.isDigit(s)||s==ke.VK_SLASH||(s==ke.VK_BACK_SPACE)))
			{
				JOptionPane.showMessageDialog(this,"Character are not allowed","Error",JOptionPane.ERROR_MESSAGE);
				ke.consume();
			}
		}
		if(ke.getSource()==ttcfs||ke.getSource()==tstudid||ke.getSource()==tadmfs)
		{
			if(!(Character.isDigit(s)||(s==ke.VK_BACK_SPACE)))
			{
				JOptionPane.showMessageDialog(this,"Character are not allowed","Error",JOptionPane.ERROR_MESSAGE);
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
	
	
	public static void main(String args[])
	{
		AdmssnDetails ad=new AdmssnDetails();
	}
}






