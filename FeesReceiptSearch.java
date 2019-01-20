import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import java.io.*;
import java.util.Calendar;

public class FeesReceiptSearch extends JInternalFrame implements ActionListener
{
	Container cp;
	JLabel lstudid,lrecptno,ldt,lnm,ladd,lcnm,lcash,ldrawn,lrs;
	JTextField tstudid,trecptno,tnm,tdrawn,trs;
	JFormattedTextField tdt;
	JTextArea tadd;
	JButton bsearch,bcls,breset,bprint;
	JComboBox cb1,cb2;
	JScrollPane jsp; 
	JPanel jp1,jp2;
	Connection con;
	Dimension dim;

	Font f1=new Font("Cambria",Font.BOLD,14);
	Font f2=new Font("Cambria",Font.BOLD,14);
	
	FeesReceiptSearch()
	{
		cp=getContentPane();
		cp.setLayout(null);

		dim=new Dimension();
		dim=Toolkit.getDefaultToolkit().getScreenSize();
		
		jp1=new JPanel();
		jp1.setBounds(10,10,570,270);
		//jp1.setBorder(BorderFactory.createTitledBorder("Personal Details"));
		jp1.setBorder(BorderFactory.createLineBorder(Color.white,1));
		jp1.setBackground(Color.decode("#200000")); //decode("#F9B7FF")
	
		jp2=new JPanel();
		jp2.setBounds(10,300,570,45);
		//jp2.setBorder(BorderFactory.createTitledBorder("Personal Details"));
		jp2.setBorder(BorderFactory.createLineBorder(Color.white,1));
		jp2.setBackground(Color.decode("#200000")); //decode("#F9B7FF")
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
		bsearch=new JButton("SEARCH");					
		bcls=new JButton("CLOSE");	
		breset=new JButton("RESET");	
		bprint=new JButton("PRINT");	
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
			
		cp.add(bsearch);
		bsearch.setBounds(70,310,90,25);
		bsearch.setFont(f1);
		bsearch.setBorder(BorderFactory.createLineBorder(Color.white,1));
		bsearch.setBackground(Color.black);
		bsearch.setForeground(Color.white);

		cp.add(bprint);
		bprint.setBounds(190,310,90,25);
		bprint.setFont(f1);
		bprint.setBorder(BorderFactory.createLineBorder(Color.white,1));
		bprint.setBackground(Color.black);
		bprint.setForeground(Color.white);
		
		cp.add(breset);		
		breset.setBounds(310,310,90,25);
		breset.setFont(f1);
		breset.setBorder(BorderFactory.createLineBorder(Color.white,1));
		breset.setBackground(Color.black);
		breset.setForeground(Color.red);

		cp.add(bcls);	
		bcls.setBounds(430,310,90,25);
		bcls.setFont(f1);
		bcls.setBorder(BorderFactory.createLineBorder(Color.white,1));
		bcls.setBackground(Color.black);
		bcls.setForeground(Color.red);
		
		cp.add(jp2);

		bsearch.addActionListener(this);
		bcls.addActionListener(this);
		breset.addActionListener(this);	
		bprint.addActionListener(this);	

		
		bcls.setToolTipText("Close form");
		breset.setToolTipText("Clear");
		bsearch.setToolTipText("Search the Records");
		bprint.setToolTipText("Print the Records");

		cp.setBackground(Color.black);
	
		setBounds(245,145,(dim.width-300),(dim.height-115));  
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setIconifiable(true);
		setClosable(true);	
		setVisible(true);
		setSize(600,390);
		setTitle("Search for Student's Fees Receipt");
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
				String s=JOptionPane.showInputDialog(this,"Please enter Student's ID");
				ResultSet rs=st.executeQuery("select * from receipt where Student_ID="+Integer.parseInt(s));  //+Integer.parseInt(s)
				if(rs.next())
				{
					
					tstudid.setText(""+rs.getString(1));  ////tstudid,trecptno,tnm,cb2,tdrawn,trs,tadd,tdt,cb1
					tdt.setText(""+rs.getString(2));
					trecptno.setText(""+rs.getString(3));
					tnm.setText(""+rs.getString(4));
					tadd.setText(""+rs.getString(5));
					cb2.setSelectedItem(rs.getString(6));
					cb1.setSelectedItem(rs.getString(7));
					tdrawn.setText(""+rs.getString(8));
					trs.setText(""+rs.getString(9));
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
			trecptno.setText("");
			tstudid.setText("");
			cb1.setSelectedIndex(0);   
			cb2.setSelectedIndex(0);   
			tnm.setText("");
			tdrawn.setText("");
			trs.setText("");
			tadd.setText("");
			tdt.setText("");
			tstudid.requestFocus();
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
				
				//String s="\t"+"\t"+"\t"+"Report\n"+"Student_ID"+"\t"+"class"+"\t"+"Date"+"\t"+"Receipt_No"+"\t"+"Student_Name"+"\t"+"Address"+"\t"+"Course_Name"+"By"+"\t"+"Drawn_On"+"\t"+"Rupees"+"\n"+"\t"+"\t"+"\t"+"+tstudid.getText()"+"\t"+"+tdt.getText()"+"\t"+"+trecptno.getText()"+"\t"+"+tnm.getText()"+"\t"+"+tadd.getText()"+"\t"+"+cb2.getSelectedItem()"+"\t"+"+cb1.getSelectedItem()"+"\t"+"+tdrawn.getText()"+"\t"+"+trs.getText()";
				
				//String s="\t"+"\t"+"\t"+"Fees Receipt\n"+"Student_ID"+"\t"+"Date"+"\t"+"Receipt_No"+"\t"+"Student_Name"+"\t"+"Address"+"\t"+"Course_Name"+"\t"+"By"+"\t"+"Drawn_On+"\t"+"Rupees"+"\n"+"\t"+"\t"+"\t"+"+tstudid.getText()"+"\t"+"+tdt.getText()"\t"+"+trecptno.getText()"+"\t"+"+tnm.getText()"+"\t"+"+tadd.getText()"+"\t"+"+cb2.getSelectedItem()"+"\t"+"+cb1.getSelectedItem()"+"\t"+"+tdrawn.getText()"+"\t"+"+trs.getText()";

//String s="<html><head><body><font face=Monotype Corsiva size=7 color=red>Computer Institute Management System</font><br><br><br>"+"<font face=Century size=5 color=blue><center>FEES RECEIPT BILL</font><center>"+"<br><br><hr size=2 color=black><br>"+"<font face=Century size=4 color=green><b>Student ID&nbsp;&nbsp;Date&nbsp;&nbsp;&nbspReceipt_No&nbsp;&nbsp;&nbsp;&nbspStudent_Name&nbsp;&nbsp;&nbsp;&nbspAddress&nbsp;&nbsp;&nbsp;&nbspCourse_Name&nbsp;&nbsp;&nbsp;&nbspBy&nbsp;&nbsp;&nbsp;&nbspDrawn_On&nbsp;&nbsp;&nbsp;&nbspRupees<b>"+"<br><hr size=2 color=black><br>&nbsp;&nbsp;&nbsp;"+tstudid.getText()+"&nbsp;&nbsp;&nbsp;"+tdt.getText()+"&nbsp;&nbsp;&nbsp;"+trecptno.getText()+"&nbsp;&nbsp;&nbsp;"+tnm.getText()+"&nbsp;&nbsp;&nbsp;"+tadd.getText();+"&nbsp;&nbsp;&nbsp;"+cb2.getSelectedItem()+"&nbsp;&nbsp;&nbsp;"+cb1.getSelectedItem()+"&nbsp;&nbsp;&nbsp;"+tdrawn.getText()+"&nbsp;&nbsp;&nbsp;"+trs.getText()+"&nbsp;&nbsp;&nbsp;"+"<br><br><br><hr size=3 color=black><br><br>&nbsp;&nbsp;&nbsp;"+"</body></head></html>";
				
String s="<html><head><body><font face=Monotype Corsiva size=5 color=red><center>Computer Institute Management System</center></font><br><br><br>"+"<font face=Century size=4 color=blue><center>FEES RECEIPT BILL</font><center>"+"<br><br><hr size=2 color=black><br>"+"<font face=Century size=2 color=green><b>Student ID&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Date&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Receipt_No&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Student_Name&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Address&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Course_Name&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;By&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Drawn_On&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Rupees<b>"+"<br><hr size=2 color=black><br>"+tstudid.getText()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+tdt.getText()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+trecptno.getText()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+tnm.getText()+"&nbsp;&nbsp;&nbsp;"+tadd.getText()+"&nbsp;&nbsp;&nbsp;"+cb2.getSelectedItem()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+cb1.getSelectedItem()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+tdrawn.getText()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+trs.getText()+"&nbsp;&nbsp;"+"<br><br><br><hr size=2 color=black><br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Total Fees Paid="+trs.getText()+"<br><br><br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(Authorized Signature)"+"</body></head></html>";
				
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
	public static void main(String args[])
	{
		FeesReceiptSearch frs=new FeesReceiptSearch();
	}
}