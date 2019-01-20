import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import java.text.*;
	

public class ResultDetails extends JInternalFrame implements ActionListener,KeyListener,FocusListener
{
	Container cp;
	JLabel lstudid,lsnm,lcnm,ldoe,lstno,lexctr,ltmng,lres,lom,lgrd;
	JTextField tstudid,tsnm,tstno,tom,tgrd;
	JFormattedTextField tdoe;
	JTextArea texctr;
	JScrollPane jsp1;
	JButton breset,bupd,bsv,bcls,bdel,bsearch;
	JRadioButton r1,r2;
	ButtonGroup bg;
	JComboBox cb1,cb3;
	JPanel jp1,jp2;
	Dimension dim;
	Connection con;
	
	Font f1=new Font("Cambria",Font.BOLD,14);
	Font f2=new Font("Cambria",Font.BOLD,14);
	
	ResultDetails()
	{
		cp=getContentPane();
		cp.setLayout(null);
		dim=new Dimension();
		dim=Toolkit.getDefaultToolkit().getScreenSize();
		
		jp1=new JPanel();
		jp1.setBounds(10,10,560,420);
		jp1.setBorder(BorderFactory.createLineBorder(Color.white,1));
		jp1.setBackground(Color.decode("#200000")); 
	
		jp2=new JPanel();
		jp2.setBounds(10,440,560,45);
		jp2.setBorder(BorderFactory.createLineBorder(Color.white,1));
		jp2.setBackground(Color.decode("#200000")); 
		
		
		
		/**********************************Labels****************************/
		lstudid=new JLabel("Student ID: ");
		lsnm=new JLabel("Name of Student: ");
		lcnm=new JLabel("Course Name: ");
		ldoe=new JLabel("Student appear for the exam on: ");
		lstno=new JLabel("Student's Seat No: ");
		lexctr=new JLabel("Exam Center: ");
		ltmng=new JLabel("Exam Timing: ");
		lres=new JLabel("Result: ");
		lom=new JLabel("Marks Obtained: ");
		lgrd=new JLabel("Grade: ");
		
		/**********************************Text Fields**************************/
		tstudid=new JTextField(20);
		tsnm=new JTextField(20);
		tstno=new JTextField(20);
		tom=new JTextField(20);
		tgrd=new JTextField(20);
		tdoe=new JFormattedTextField();
		texctr=new JTextArea(5,20);
		jsp1=new JScrollPane(texctr);
		texctr.setFont(f2);
		texctr.setForeground(Color.black);

		/************************************Buttons******************************/
		breset=new JButton("RESET");
		bupd=new JButton("UPDATE");		
		bsv=new JButton("SAVE");					
		bcls=new JButton("CLOSE");	
		bdel=new JButton("DELETE");	
		bsearch=new JButton("SEARCH");
		/********************************************Radio Button********************************/
		r1=new JRadioButton("Pass");
		r2=new JRadioButton("Fail");
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
		cb1.addItem("MS-Office");
		cb1.addItem("SQL");
		cb1.addItem("HTML");
		cb1.addItem("Corel Draw");
		cb1.addItem("Tally");
		cb1.addItem("Photoshop");
	
	
		cb3=new JComboBox();
		cb3.addItem("");
		cb3.addItem(" 8:00AM-9:00AM");
		cb3.addItem(" 9:00AM-10:00AM");
		cb3.addItem(" 10:00AM-11:00AM");
		cb3.addItem(" 11:00AM-12:00PM");
		cb3.addItem(" 12:00PM-1:00PM");
		cb3.addItem(" 1:00PM-2:00PM");
		cb3.addItem(" 2:00PM-3:00PM");
		cb3.addItem(" 3:00PM-4:00PM");
		cb3.addItem(" 4:00PM-5:00PM");
		cb3.addItem(" 5:00PM-6:00PM");
		cb3.setEditable(true);
				
		
	
		cp.add(lstudid);
		lstudid.setBounds(20,30,80,30);
		lstudid.setFont(f1);
		lstudid.setForeground(Color.decode("#FFFFFF"));
		cp.add(tstudid);
		tstudid.setBounds(230,35,100,22);
		tstudid.setFont(f2);
		tstudid.setForeground(Color.black);
		tstudid.setBorder(BorderFactory.createLineBorder(Color.black,1));

		cp.add(lsnm);
		lsnm.setBounds(20,60,150,30);
		lsnm.setFont(f1);
		lsnm.setForeground(Color.decode("#FFFFFF"));
		cp.add(tsnm);
		tsnm.setBounds(230,65,200,22);
		tsnm.setFont(f2);
		tsnm.setForeground(Color.black);
		tsnm.setBorder(BorderFactory.createLineBorder(Color.black,1));


		cp.add(lcnm);
		lcnm.setBounds(20,90,150,30);
		lcnm.setFont(f1);
		lcnm.setForeground(Color.decode("#FFFFFF"));
		cp.add(cb1);
		cb1.setBounds(230,95,200,22);
		cb1.setFont(f2);
		cb1.setForeground(Color.black);
		cb1.setBorder(BorderFactory.createLineBorder(Color.black,1));


		cp.add(lstno);
		lstno.setBounds(20,120,150,30);
		lstno.setFont(f1);
		lstno.setForeground(Color.decode("#FFFFFF"));
		cp.add(tstno);
		tstno.setBounds(230,125,120,22);
		tstno.setFont(f2);
		tstno.setForeground(Color.black);
		tstno.setBorder(BorderFactory.createLineBorder(Color.black,1));

		
		cp.add(ldoe);
		ldoe.setBounds(20,150,250,30);
		ldoe.setFont(f1);
		ldoe.setForeground(Color.decode("#FFFFFF"));
		cp.add(tdoe);
		tdoe.setBounds(230,153,120,22);
		tdoe.setFont(f2);
		tdoe.setForeground(Color.black);
		tdoe.setBorder(BorderFactory.createLineBorder(Color.black,1));

		cp.add(ltmng);
		ltmng.setBounds(20,180,210,30);
		ltmng.setFont(f1);
		ltmng.setForeground(Color.decode("#FFFFFF"));
		cp.add(cb3);
		cb3.setBounds(230,183,150,22);
		cb3.setFont(f2);
		cb3.setForeground(Color.black);
		cb3.setBorder(BorderFactory.createLineBorder(Color.black,1));

		
		cp.add(lexctr);
		lexctr.setBounds(20,210,150,30);
		lexctr.setFont(f1);
		lexctr.setForeground(Color.decode("#FFFFFF"));
		cp.add(jsp1);
		jsp1.setBounds(230,215,150,70);
		jsp1.setBorder(BorderFactory.createLineBorder(Color.black,1));
	
		cp.add(lom);
		lom.setBounds(20,295,150,30);
		lom.setFont(f1);
		lom.setForeground(Color.decode("#FFFFFF"));
		cp.add(tom);
		tom.setBounds(230,300,150,22);
		tom.setFont(f2);
		tom.setForeground(Color.black);
		tom.setBorder(BorderFactory.createLineBorder(Color.black,1));
		
		cp.add(lgrd);
		lgrd.setBounds(20,330,150,30);
		lgrd.setFont(f1);
		lgrd.setForeground(Color.decode("#FFFFFF"));
		cp.add(tgrd);
		tgrd.setBounds(230,335,150,22);
		tgrd.setFont(f2);
		tgrd.setForeground(Color.black);
		tgrd.setBorder(BorderFactory.createLineBorder(Color.black,1));
		
		cp.add(lres);
		lres.setBounds(20,370,150,30);
		lres.setFont(f1);
		lres.setForeground(Color.decode("#FFFFFF"));	
		cp.add(r1);
		r1.setBounds(230,375,100,22);        
		r1.setFont(f2);
		r1.setBackground(Color.decode("#200000"));
		r1.setForeground(Color.decode("#FFFFFF"));
		cp.add(r2);
		r2.setBounds(350,375,100,22);
		r2.setFont(f2);
		r2.setBackground(Color.decode("#200000"));
		r2.setForeground(Color.decode("#FFFFFF"));
		
		bg=new ButtonGroup();
		bg.add(r1);
		bg.add(r2);

		cp.add(jp1);

		cp.add(bupd);
		bupd.setBounds(20,450,70,25);
		bupd.setFont(f1);
		bupd.setBorder(BorderFactory.createLineBorder(Color.white,1));
		bupd.setBackground(Color.black);
		bupd.setForeground(Color.red);

		cp.add(bsv);	
		bsv.setBounds(110,450,70,25);
		bsv.setFont(f1);
		bsv.setBorder(BorderFactory.createLineBorder(Color.white,1));
		bsv.setBackground(Color.black);
		bsv.setForeground(Color.red);


		cp.add(breset);
		breset.setBounds(200,450,70,25);
		breset.setFont(f1);
		breset.setBorder(BorderFactory.createLineBorder(Color.white,1));
		breset.setBackground(Color.black);
		breset.setForeground(Color.red);
		
		cp.add(bsearch);
		bsearch.setBounds(290,450,70,25);
		bsearch.setFont(f1);
		bsearch.setBorder(BorderFactory.createLineBorder(Color.white,1));
		bsearch.setBackground(Color.black);
		bsearch.setForeground(Color.red);
		
		cp.add(bdel);		
		bdel.setBounds(380,450,80,25);
		bdel.setFont(f1);
		bdel.setBorder(BorderFactory.createLineBorder(Color.white,1));
		bdel.setBackground(Color.black);
		bdel.setForeground(Color.red);

		cp.add(bcls);	
		bcls.setBounds(480,450,80,25);
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

		tom.addFocusListener(this);

		tstudid.addKeyListener(this);
		tsnm.addKeyListener(this);
		tstno.addKeyListener(this);
		tom.addKeyListener(this);
		tgrd.addKeyListener(this);
		tdoe.addKeyListener(this);
		texctr.addKeyListener(this);

		bupd.setToolTipText("Update the Records");
		bsv.setToolTipText("Save the Records");
		bcls.setToolTipText("Close form");
		breset.setToolTipText("Clear");
		bdel.setToolTipText("Delete the Records");
		bsearch.setToolTipText("Search the Records");
		
		setBounds(245,100,(dim.width-300),(dim.height-115)); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setIconifiable(true);
		setClosable(true);	
		setVisible(true);
		setSize(590,525);
		setTitle("Result Details");
		cp.setBackground(Color.black);

		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			System.out.println("Driver Loaded!");
		
			con=DriverManager.getConnection("jdbc:odbc:CompDSN");
			System.out.println("Connection Established!");
	
			Statement st=con.createStatement();
                                   	ResultSet rs=st.executeQuery("select * from result");
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
			if(cb1.getSelectedIndex()==0)
			{
				JOptionPane.showMessageDialog(this,"Please Select Course Name","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(tstno.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this,"Please Enter Exam Seat No","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(tdoe.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this,"Please Enter Date of Exam","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(cb3.getSelectedIndex()==0)
			{
				JOptionPane.showMessageDialog(this,"Please select the Exam Time","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(texctr.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this,"Please Enter Address of Exam Center","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(r1.isSelected()==false && r2.isSelected()==false)
			{
				JOptionPane.showMessageDialog(this,"Please Select the Result","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(tom.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this,"Please Enter Marks","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(tgrd.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this,"Please Enter Grade","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			try
			{
				PreparedStatement st=con.prepareStatement("insert into result values(?,?,?,?,?,?,?,?,?,?)");
				st.setString(1,tstudid.getText());
				st.setString(2,tsnm.getText());
				st.setString(3,(String)cb1.getSelectedItem());	
				st.setString(4,tstno.getText());
				st.setString(5,tdoe.getText());
				st.setString(6,(String)cb3.getSelectedItem());	
				st.setString(7,texctr.getText());
				st.setString(8,tom.getText());
				st.setString(9,tgrd.getText());
				if(r1.isSelected()==true)
				{
					st.setString(10,"Pass");
				}
				else
				{
					st.setString(10,"Fail");
				}

				
				st.executeUpdate();
				JOptionPane.showMessageDialog(null,"Result Details Saved Successfully!");
				tstudid.setText("");
			
			tsnm.setText("");
			cb1.setSelectedIndex(0);
			tstno.setText("");
			tdoe.setText("");  
			cb3.setSelectedIndex(0);
			texctr.setText("");
			tom.setText("");
			tgrd.setText("");
			bg.clearSelection(); 
			tstudid.requestFocus();
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
			if(cb1.getSelectedIndex()==0)
			{
				JOptionPane.showMessageDialog(this,"Please Select Course Name","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(tstno.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this,"Please Enter Exam Seat No","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(tdoe.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this,"Please Enter Date of Exam","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(cb3.getSelectedIndex()==0)
			{
				JOptionPane.showMessageDialog(this,"Please select the Exam Time","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(texctr.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this,"Please Enter Address of Exam Center","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(r1.isSelected()==false && r2.isSelected()==false)
			{
				JOptionPane.showMessageDialog(this,"Please Select the Result","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(tom.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this,"Please Enter Marks","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(tgrd.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this,"Please Enter Grade","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}
			try
			{		
				PreparedStatement st=con.prepareStatement("UPDATE result set Student_Name=?,Course_Name=?,Seat_No=?,Date_of_Exam=?,Exam_Time=?,Exam_Center=?,Marks=?,Grade=?,Result=? WHERE Student_ID=?");
				
				st.setString(1,tsnm.getText());
				st.setString(2,(String)cb1.getSelectedItem());	
				st.setString(3,tstno.getText());
				st.setString(4,tdoe.getText());
				st.setString(5,(String)cb3.getSelectedItem());	
				st.setString(6,texctr.getText());
				st.setString(7,tom.getText());
				st.setString(8,tgrd.getText());
				if(r1.isSelected()==true)
				{
					st.setString(9,"Pass");
				}
				else
				{
					st.setString(9,"Fail");
				}
				st.setString(10,tstudid.getText());
				st.executeUpdate();
				JOptionPane.showMessageDialog(null,"Updated!");

				tstudid.setText("");
		
			tsnm.setText("");
				cb1.setSelectedIndex(0);
			tstno.setText("");
			tdoe.setText("");  
			cb3.setSelectedIndex(0);
			texctr.setText("");
			tom.setText("");
			tgrd.setText("");
			bg.clearSelection(); 
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
				
				ResultSet rs=st.executeQuery("select * from exam where Student_ID="+tstudid.getText());  //+Integer.parseInt(s)
				if(rs.next())
				{
					
					tstudid.setText(""+rs.getString(1));
					tsnm.setText(""+rs.getString(2));
				
					cb1.setSelectedItem(rs.getString(5));  
					tstno.setText(""+rs.getString(6));
				
					texctr.setText(""+rs.getString(8));
					tdoe.setText(""+rs.getString(9));
					cb3.setSelectedItem(rs.getString(10));
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Record Not Found........");
				}

			}
			catch(Exception e) {}
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
			cb1.setSelectedIndex(0);
			tstno.setText("");
			tdoe.setText("");  
			cb3.setSelectedIndex(0);
			texctr.setText("");
			tom.setText("");
			tgrd.setText("");
			bg.clearSelection(); 
			tstudid.requestFocus();


			try
			{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				System.out.println("Driver Loaded!");
		
				con=DriverManager.getConnection("jdbc:odbc:CompDSN");
				System.out.println("Connection Established!");
	
				Statement st=con.createStatement();
                                   		ResultSet rs=st.executeQuery("select * from result");
                                  		while(rs.next())
                                 		{
                                   			int no=rs.getInt(1);
                                   			no++;
                                   			tstudid.setText(""+no);
                                 		}
			}
			catch(Exception e) {}
		}
	
		/**************************************Delete the Application********************************************/
		
		if(ae.getSource()==bdel)
		{
			int res=JOptionPane.showConfirmDialog((Component)null,"Are you sure to delete the Result Details of Student ID = "+Integer.parseInt(tstudid.getText()),"Delete",JOptionPane.YES_NO_OPTION);
			
			if(res==JOptionPane.YES_OPTION)
			{
				try
				{
			
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					System.out.println("Driver Loaded!");
			
					con=DriverManager.getConnection("jdbc:odbc:CompDSN");
					System.out.println("Connection Established!");

					PreparedStatement st=con.prepareStatement("delete from result where Student_ID= "+Integer.parseInt(tstudid.getText()));
					st.executeUpdate();
					JOptionPane.showMessageDialog(this,"Deleted the Record at Student ID = "+tstudid.getText() +" Successfully");
				}
				catch(Exception e) {}
			}
			else if(res==JOptionPane.NO_OPTION)
			{
			}	 
		}
		
	}
	public void focusGained (FocusEvent fe) { }

	public void focusLost (FocusEvent fe) 
	{
		Object obj = fe.getSource ();

		if (obj == tom) 
		{
			if (tom.getText().equals ("")) 
			{	
				JOptionPane.showMessageDialog (this, "Please Enter Marks......");
			}
			else 
			{
				int m1=Integer.parseInt(tom.getText());
				char a='A';
				char b='B';
				char c='C';
				char d='D';
				if(m1>=60)
				{
					tgrd.setText(""+a);
					r1.setSelected(true);
				}
				else if((m1>=45)&&(m1<60))
				{
					tgrd.setText(""+b);
					r1.setSelected(true);
				}			
				else if((m1>=35)&&(m1<45))
				{
					tgrd.setText(""+c);
					r1.setSelected(true);
				}	
				else
				{
					tgrd.setText(""+d);
					r2.setSelected(true);
				}	
			}
		}
	}
	public void keyTyped(KeyEvent ke)
	{
		char s=ke.getKeyChar();
		if(ke.getSource()==tdoe) 
		{
			if(!(Character.isDigit(s)||s==ke.VK_SLASH||(s==ke.VK_BACK_SPACE)))
			{
				JOptionPane.showMessageDialog(this,"Character are not allowed","Error",JOptionPane.ERROR_MESSAGE);
				ke.consume();
			}
		}
		if(ke.getSource()==tstno||ke.getSource()==tstudid||ke.getSource()==tom)
		{
			if(!(Character.isDigit(s)||(s==ke.VK_BACK_SPACE)))
			{
				JOptionPane.showMessageDialog(this,"Character are not allowed","Error",JOptionPane.ERROR_MESSAGE);
				ke.consume();
			}
		}
		if(ke.getSource()==tsnm||ke.getSource()==tgrd||ke.getSource()==texctr)
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
		new  ResultDetails();
	}
}



