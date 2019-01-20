import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import java.io.*;

public class Certificate extends JInternalFrame implements ActionListener
{
	Container cp;
	JLabel lstudid,lsnm,lcnm,ldoe,lstno,lexctr,ltmng,lres,lom,lgrd;
	JTextField tstudid,tsnm,tstno,tom,tgrd;
	JFormattedTextField tdoe;
	JTextArea texctr;
	JScrollPane jsp1;
	JButton bsearch,breset,bcls,bprint;
	JRadioButton r1,r2;
	ButtonGroup bg;
	JComboBox cb1,cb3;
	JPanel jp1,jp2;
	Dimension dim;
	Connection con;
	
	Font f1=new Font("Cambria",Font.BOLD,14);
	Font f2=new Font("Cambria",Font.BOLD,14);
	
	Certificate()
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
		bsearch=new JButton("SEARCH");
		breset=new JButton("RESET");					
		bcls=new JButton("CLOSE");	
		bprint=new JButton("PRINT");	
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

		cp.add(bsearch);
		bsearch.setBounds(110,450,70,25);
		bsearch.setFont(f1);
		bsearch.setBorder(BorderFactory.createLineBorder(Color.white,1));
		bsearch.setBackground(Color.black);
		bsearch.setForeground(Color.red);

		cp.add(bprint);	
		bprint.setBounds(210,450,70,25);
		bprint.setFont(f1);
		bprint.setBorder(BorderFactory.createLineBorder(Color.white,1));
		bprint.setBackground(Color.black);
		bprint.setForeground(Color.white);
		

		cp.add(breset);	
		breset.setBounds(310,450,70,25);
		breset.setFont(f1);
		breset.setBorder(BorderFactory.createLineBorder(Color.white,1));
		breset.setBackground(Color.black);
		breset.setForeground(Color.red);


		cp.add(bcls);
		bcls.setBounds(410,450,70,25);
		bcls.setFont(f1);
		bcls.setBorder(BorderFactory.createLineBorder(Color.white,1));
		bcls.setBackground(Color.black);
		bcls.setForeground(Color.red);

		
		cp.add(jp2);
		
		bsearch.addActionListener(this);
		breset.addActionListener(this);
		bcls.addActionListener(this);
		bprint.addActionListener(this);
	
		
		bcls.setToolTipText("Close form");
		breset.setToolTipText("Clear");
		bsearch.setToolTipText("Search the Records");
		bprint.setToolTipText("Print the Records");

		cp.setBackground(Color.black);
		setBounds(245,100,(dim.width-300),(dim.height-115)); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setIconifiable(true);
		setClosable(true);	
		setVisible(true);
		setSize(590,525);
		setTitle("Certificate");
	}
	public void actionPerformed(ActionEvent ae)
	{
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
				String no=JOptionPane.showInputDialog(this,"Please enter Student's ID");
				ResultSet rs=st.executeQuery("select * from result where Student_ID="+Integer.parseInt(no));  //+Integer.parseInt(s)
				if(rs.next())
				{
					tstudid.setText(""+rs.getString(1));
					tsnm.setText(""+rs.getString(2));
					cb1.setSelectedItem(rs.getString(3));
					tstno.setText(""+rs.getString(4));
					tdoe.setText(""+rs.getString(5));
					cb3.setSelectedItem(rs.getString(6));
					texctr.setText(""+rs.getString(7));
					tom.setText(""+rs.getString(8));
					tgrd.setText(""+rs.getString(9));
					
					String str=rs.getString(10);
					if(str.equals("Pass"))
					{
						r1.setSelected(true);
					}
					else
					{
						r2.setSelected(true);
					}
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Record Not Found........");
				}

			}
			catch(Exception e) {}
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
																																																																																
String s="<html><head><body><font face=Cambria size=5 color=red><center><b>CERTIFICATE</b></center></font>"+"<br><br><font face=calibri size=3 color=black><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Student ID : "+tstudid.getText()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Seat No : "+tstno.getText()+"</b></font>"+"<br><hr size=2 color=black><br>"+"<font face=Arial size=4 color=black><b><center>This is to certify that</center></b></font><br><font face=Calibri size=5 color=maroon><b><i><center>"+tsnm.getText()+"</center></i></b></font>"+"<font face=Calibri size=4 color=black><br><p>having successfully completed the prescribed course of studies and having passed the examination with  <b>"+tom.getText()+"</b> percent marks has been awarded the</font>"+"<br><br><font face=Calibri size=4 color=maroon><center><b>"+cb1.getSelectedItem()+"</b></center></font>"+"<font face=Calibri size=4 color=black><p>On behalf of the Government of Maharashtra on Date  <b>"+tdoe.getText()+"</b></font>"+"<br><br><br><br><br><br><br><br><br><br><br><hr size=1 width=200 color=black><br><font face=Calibri size=4 color=black><b><center>(Managing Director Signature)</center></b></font></body></head></html>";
				
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
		}
		
	}
	public static void main(String args[])
	{
		new Certificate();
	}
}