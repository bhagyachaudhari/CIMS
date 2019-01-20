import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import java.util.Calendar;


public class StudDetails extends JInternalFrame implements ActionListener,KeyListener
{
	Container cp;
	JLabel lstudid,ldoa,lsnm,ladd,lphno,leid,ldob,lgen,lcnm,lqlf;
	JTextField tstudid,tsnm,tphno,teid,tqlf;
	JFormattedTextField tdoa,tdob;
	JTextArea tadd;
	JScrollPane jsp;
	JButton bupd,bsv,bcls,breset,bdel;
	JRadioButton rb1,rb2;
	JComboBox cb1;
	ButtonGroup bg;
	JPanel jp1,jp2;
	Connection con;
	Dimension dim;
			
	Font f1=new Font("Cambria",Font.BOLD,14);
	Font f2=new Font("Cambria",Font.BOLD,14);
	
	
	StudDetails()		
	{
		
		cp=getContentPane();
		cp.setLayout(null);
		dim=new Dimension();
		dim=Toolkit.getDefaultToolkit().getScreenSize();
		java.util.Date currDate=new java.util.Date();
		SimpleDateFormat sdf=new SimpleDateFormat("dd"+"/"+"MM"+"/"+"yyyy",Locale.getDefault());
		String d=sdf.format(currDate);
		

		jp1=new JPanel();
		jp1.setBounds(20,20,715,370);
		jp1.setBorder(BorderFactory.createLineBorder(Color.white,1));
		jp1.setBackground(Color.decode("#200000")); 
	
		jp2=new JPanel();
		jp2.setBounds(20,405,715,55);
		jp2.setBorder(BorderFactory.createLineBorder(Color.white,1));
		jp2.setBackground(Color.decode("#200000")); 
		
		/**********************************Labels****************************/
		lstudid=new JLabel("Student ID: ");
		ldoa=new JLabel("Date of Admission: ");
		lsnm=new JLabel("Student's Name: ");
		ladd=new JLabel("Address: ");
		lphno=new JLabel("Phone No: ");
		leid=new JLabel("Email Id: ");
		ldob=new JLabel("Date of Birth: ");
		lgen=new JLabel("Gender: ");
		lcnm=new JLabel("Course Name: ");
		lqlf=new JLabel("Qualification: ");
		
		/**********************************Text Fields**************************/
		tstudid=new JTextField(20);
		tsnm=new JTextField(20);
		tphno=new JTextField(20);	
		teid=new JTextField(20);	
		tqlf=new JTextField(20);		
		tdoa=new JFormattedTextField();
		tdob=new JFormattedTextField();
		tadd=new JTextArea(20,5);
		jsp=new JScrollPane(tadd);
		tadd.setFont(f2);
		tadd.setForeground(Color.black);
	
		/************************************Buttons******************************/
		bupd=new JButton("UPDATE");		
		bsv=new JButton("SAVE");					
		bcls=new JButton("CLOSE");	
		breset=new JButton("RESET");	
		bdel=new JButton("DELETE");	


		/**************************************Radio Button***********************/			
		
		rb1=new JRadioButton("Male");
		rb2=new JRadioButton("Female");

		/****************************************ComboBox**************************************/
		cb1=new JComboBox();
		cb1.addItem("");
		cb1.addItem("Certificate Course in Information Technology(CCIT)");
		cb1.addItem("Certificate Course in DTP(CCDTP)");	
		cb1.addItem("Certificate Course in C");
		cb1.addItem("Certificate Course in C++");
		cb1.addItem("Certificate Course in Java");
		cb1.addItem("MS-Office");
		cb1.addItem("SQL");
		cb1.addItem("HTML");
		cb1.addItem("Corel Draw");
		cb1.addItem("Tally");
		cb1.addItem("Photoshop");
		
		
		cp.add(lstudid);
		lstudid.setBounds(30,25,80,30);
		lstudid.setFont(f1);
		lstudid.setForeground(Color.decode("#FFFFFF"));
		cp.add(tstudid);
		tstudid.setBounds(140,30,100,22);
		tstudid.setFont(f2);
		tstudid.setForeground(Color.black);
		tstudid.setBorder(BorderFactory.createLineBorder(Color.black,1));
		
		cp.add(ldoa);
		ldoa.setBounds(390,25,150,30);
		ldoa.setFont(f1);
		ldoa.setForeground(Color.decode("#FFFFFF"));
		cp.add(tdoa);
		tdoa.setBounds(515,30,100,22);
		tdoa.setFont(f2);
		tdoa.setForeground(Color.black);
		tdoa.setBorder(BorderFactory.createLineBorder(Color.black,1));
		
		cp.add(lsnm);
		lsnm.setBounds(30,65,150,30);
		lsnm.setFont(f1);
		lsnm.setForeground(Color.decode("#FFFFFF"));
		cp.add(tsnm);
		tsnm.setBounds(140,70,250,22);
		tsnm.setFont(f2);
		tsnm.setForeground(Color.black);
		tsnm.setBorder(BorderFactory.createLineBorder(Color.black,1));
		
		cp.add(ladd);
		ladd.setBounds(30,105,100,30);
		ladd.setFont(f1);
		ladd.setForeground(Color.decode("#FFFFFF"));
		cp.add(jsp);
		jsp.setBounds(140,110,140,70);
		jsp.setBorder(BorderFactory.createLineBorder(Color.black,1));
		
		cp.add(lphno);
		lphno.setBounds(30,190,80,30);
		lphno.setFont(f1);
		lphno.setForeground(Color.decode("#FFFFFF"));
		cp.add(tphno);
		tphno.setBounds(140,195,140,22);
		tphno.setFont(f2);
		tphno.setForeground(Color.black);
		tphno.setBorder(BorderFactory.createLineBorder(Color.black,1));

		cp.add(leid);
		leid.setBounds(30,220,60,30);
		leid.setFont(f1);
		leid.setForeground(Color.decode("#FFFFFF"));
		cp.add(teid);
		teid.setBounds(140,225,200,22);
		teid.setFont(f2);
		teid.setForeground(Color.black);
		teid.setBorder(BorderFactory.createLineBorder(Color.black,1));

		cp.add(ldob);
		ldob.setBounds(30,255,100,30);
		ldob.setFont(f1);
		ldob.setForeground(Color.decode("#FFFFFF"));
		cp.add(tdob);
		tdob.setBounds(140,260,140,22);
		tdob.setFont(f2);
		tdob.setForeground(Color.black);
		tdob.setBorder(BorderFactory.createLineBorder(Color.black,1));
	
		cp.add(lgen);
		lgen.setBounds(30,285,60,30);
		lgen.setFont(f1);
		lgen.setForeground(Color.decode("#FFFFFF"));
		cp.add(rb1);
		rb1.setBounds(135,285,60,30);
		rb1.setFont(f1);
		rb1.setBackground(Color.decode("#200000"));
		rb1.setForeground(Color.decode("#FFFFFF"));
		cp.add(rb2);
		rb2.setBounds(210,285,80,30);
		rb2.setFont(f1);
		rb2.setBackground(Color.decode("#200000"));
		rb2.setForeground(Color.decode("#FFFFFF"));
		
		cp.add(lcnm);
		lcnm.setBounds(30,315,100,30);
		lcnm.setFont(f1);	
		lcnm.setForeground(Color.decode("#FFFFFF"));
		cp.add(cb1);
		cb1.setBounds(140,320,280,22);
		cb1.setFont(f2);
		cb1.setForeground(Color.black);
		cb1.setBorder(BorderFactory.createLineBorder(Color.black,1));	
	
		cp.add(lqlf);
		lqlf.setBounds(30,345,100,30);	
		lqlf.setFont(f1);
		lqlf.setForeground(Color.decode("#FFFFFF"));
		cp.add(tqlf);
		tqlf.setBounds(140,350,200,22);
		tqlf.setFont(f2);
		tqlf.setForeground(Color.black);
		tqlf.setBorder(BorderFactory.createLineBorder(Color.black,1));
		
		cp.add(jp1);	
	
		cp.add(bupd);
		bupd.setBounds(90,420,80,25);
		bupd.setFont(f1);
		bupd.setBorder(BorderFactory.createLineBorder(Color.white,1));
		bupd.setBackground(Color.black);
		bupd.setForeground(Color.red);  

		cp.add(bsv);	
		bsv.setBounds(210,420,80,25);
		bsv.setFont(f1);
		bsv.setBorder(BorderFactory.createLineBorder(Color.white,1));
		bsv.setBackground(Color.black);
		bsv.setForeground(Color.red);

		cp.add(breset);		
		breset.setBounds(330,420,80,25);
		breset.setFont(f1);
		breset.setBorder(BorderFactory.createLineBorder(Color.white,1));
		breset.setBackground(Color.black);
		breset.setForeground(Color.red);

		cp.add(bdel);		
		bdel.setBounds(450,420,80,25);
		bdel.setFont(f1);
		bdel.setBorder(BorderFactory.createLineBorder(Color.white,1));
		bdel.setBackground(Color.black);
		bdel.setForeground(Color.red);

		cp.add(bcls);	
		bcls.setBounds(570,420,80,25);	
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
	
		tstudid.addKeyListener(this);
		tsnm.addKeyListener(this);
		tphno.addKeyListener(this);
		teid.addKeyListener(this);
		tqlf.addKeyListener(this);
		tadd.addKeyListener(this);
		tdoa.addKeyListener(this);
		tdob.addKeyListener(this);
	
		bupd.setToolTipText("Update the Records");
		bsv.setToolTipText("Save the Records");
		bcls.setToolTipText("Close form");
		breset.setToolTipText("Clear");
		bdel.setToolTipText("Delete the Records");
				
		tstudid.setToolTipText("Please Enter here Student ID");

		bg=new ButtonGroup();
		bg.add(rb1);
		bg.add(rb2);
	
		setBounds(245,100,(dim.width-300),(dim.height-115));  
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		setIconifiable(true);
		setClosable(true);	
		setSize(765,515);
		setTitle("Student Details");
		cp.setBackground(Color.black);

		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			System.out.println("Driver Loaded!");
		
			con=DriverManager.getConnection("jdbc:odbc:CompDSN");
			System.out.println("Connection Established!");
	
			Statement st=con.createStatement();
                                   	ResultSet rs=st.executeQuery("select * from student");
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
			tstudid.setText("");
			tsnm.setText("");
			tphno.setText("");
			teid.setText("");
			cb1.setSelectedIndex(0);
			tqlf.setText("");
			tdob.setText("");
			tadd.setText("");
			bg.clearSelection();
			tstudid.requestFocus();


			try
			{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				System.out.println("Driver Loaded!");
		
				con=DriverManager.getConnection("jdbc:odbc:CompDSN");
				System.out.println("Connection Established!");
	
				Statement st=con.createStatement();
                                   		ResultSet rs=st.executeQuery("select * from student");
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
			if(tdoa.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this,"Please Enter Date","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(tsnm.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this,"Please Enter Student's Name","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(tadd.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this,"Please Enter Address","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(tphno.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this,"Please Enter Phone No","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(tphno.getText().length()>10)
			{
				JOptionPane.showMessageDialog(this,"Please Enter Phone No not greater than 10","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(tphno.getText().length()<10)
			{
				JOptionPane.showMessageDialog(this,"Please Enter Phone No not less than 10","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(teid.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this,"Please Enter Email Id","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(tdob.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this,"Please Enter Date of Birth","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(rb1.isSelected()==false && rb2.isSelected()==false)
			{
				JOptionPane.showMessageDialog(this,"Please Select Gender","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(cb1.getSelectedIndex()==0)
			{
				JOptionPane.showMessageDialog(this,"Please Enter Course Name","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(tqlf.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this,"Please Enter Qualification","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}

			try
			{
				PreparedStatement st=con.prepareStatement("insert into student values(?,?,?,?,?,?,?,?,?,?)");
				st.setString(1,tstudid.getText());
				st.setString(2,tdoa.getText());
				st.setString(3,tsnm.getText());
				st.setString(4,tadd.getText());
				st.setString(5,tphno.getText());
				st.setString(6,teid.getText());
				st.setString(7,tdob.getText());	
				if(rb1.isSelected()==true)
				{
					st.setString(8,"Male");
				}
				else
				{
					st.setString(8,"Female");
				}

				st.setString(9,(String)cb1.getSelectedItem());
				st.setString(10,tqlf.getText());
				st.executeUpdate();
				JOptionPane.showMessageDialog(null,"Student Details Saved Successfully!");
				
				tstudid.setText("");
				tsnm.setText("");
				tphno.setText("");
				teid.setText("");
				cb1.setSelectedIndex(0);
				tqlf.setText("");
				tdob.setText("");
				tadd.setText("");
				bg.clearSelection();
				tstudid.requestFocus();
			}
			catch(Exception e) 
			{
			}
			
			
		}
		
		
		/***********************************Code for Update the Application***************************/
		
		if(ae.getSource()==bupd)
		{
			if(tstudid.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this,"Please Enter Student ID","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(tdoa.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this,"Please Enter Date","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(tsnm.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this,"Please Enter Student's Name","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(tadd.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this,"Please Enter Address","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(tphno.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this,"Please Enter Phone No","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(tphno.getText().length()>10)
			{
				JOptionPane.showMessageDialog(this,"Please Enter Phone No not greater than 10","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(tphno.getText().length()<10)
			{
				JOptionPane.showMessageDialog(this,"Please Enter Phone No not less than 10","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(teid.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this,"Please Enter Email Id","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(tdob.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this,"Please Enter Date of Birth","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(rb1.isSelected()==false && rb2.isSelected()==false)
			{
				JOptionPane.showMessageDialog(this,"Please Select Gender","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(cb1.getSelectedIndex()==0)
			{
				JOptionPane.showMessageDialog(this,"Please Enter Course Name","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(tqlf.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this,"Please Enter Qualification","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}

			try
			{		
				PreparedStatement st=con.prepareStatement("UPDATE student set Date_Of_Adm=?,Student_Name=?,Address=?,Phone_No=?,Email_Id=?,Date_of_Birth=?,Gender=?,Course_Name=?,Qualification=? WHERE Student_ID=?");
				
				st.setString(1,tdoa.getText());
				st.setString(2,tsnm.getText());
				st.setString(3,tadd.getText());
				st.setString(4,tphno.getText());
				st.setString(5,teid.getText());
				st.setString(6,tdob.getText());	
				if(rb1.isSelected()==true)
				{
					st.setString(7,"Male");
				}
				else
				{
					st.setString(7,"Female");
				}
				
				st.setString(8,(String)cb1.getSelectedItem());
				st.setString(9,tqlf.getText());
				st.setString(10,tstudid.getText());
				st.executeUpdate();
				JOptionPane.showMessageDialog(null,"Student Details Updated!");

				tstudid.setText("");
				tsnm.setText("");
				tphno.setText("");
				teid.setText("");
				cb1.setSelectedIndex(0);
				tqlf.setText("");
				tdob.setText("");
				tadd.setText("");
				bg.clearSelection();
				tstudid.requestFocus();
			}
			catch(Exception e)
			{
				System.out.println("error!");
			}
				
		}
		
			
		/**************************************Delete the Application********************************************/
		
		if(ae.getSource()==bdel)
		{
			int res=JOptionPane.showConfirmDialog((Component)null,"Are you sure to delete the Student Details at Student ID "+Integer.parseInt(tstudid.getText()),"Delete",JOptionPane.YES_NO_OPTION);
			
			if(res==JOptionPane.YES_OPTION)
			{
				try
				{
			
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					System.out.println("Driver Loaded!");
			
					con=DriverManager.getConnection("jdbc:odbc:CompDSN");
					System.out.println("Connection Established!");

					PreparedStatement st=con.prepareStatement("delete from student where Student_ID= "+Integer.parseInt(tstudid.getText()));
					st.executeUpdate();
					JOptionPane.showMessageDialog(this,"Deleted the Record at Student ID "+(tstudid.getText())+" Successfully!");

					tstudid.setText("");
					tsnm.setText("");
					tphno.setText("");
					teid.setText("");
					cb1.setSelectedIndex(0);
					tqlf.setText("");
					tdob.setText("");
					tadd.setText("");
					bg.clearSelection();
					tstudid.requestFocus();
				}
				catch(Exception e) {}
			}
			else if(res==JOptionPane.NO_OPTION)
			{
			}	 
		}

	}
	
	public void keyTyped(KeyEvent ke)
	{
		char s=ke.getKeyChar();
		if(ke.getSource()==tdoa || ke.getSource()==tdob)
		{
			if(!(Character.isDigit(s)||s==ke.VK_SLASH||(s==ke.VK_BACK_SPACE)))
			{
				JOptionPane.showMessageDialog(this,"Character are not allowed","Error",JOptionPane.ERROR_MESSAGE);
				ke.consume();
			}
		}
		if(ke.getSource()==tphno||ke.getSource()==tstudid)
		{
			if(!(Character.isDigit(s)||(s==ke.VK_BACK_SPACE)))
			{
				JOptionPane.showMessageDialog(this,"Character are not allowed","Error",JOptionPane.ERROR_MESSAGE);
				ke.consume();
			}
		}
		if(ke.getSource()==tsnm || ke.getSource()==tadd)
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
		StudDetails sd=new StudDetails();
	}
	
}




