import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import java.io.*;

public class StaffSalarySearch extends JInternalFrame implements ActionListener
{
	Container cp;
	JLabel lstaffid,ldt,lpayslipno,lstaffnm,lsalary,ladd;
	JTextField tstaffid,tdt,tpayslipno,tstaffnm,tsalary,tadd;
	JButton breset,bsearch,bcls,bprint;
	JPanel jp1,jp2;
	Connection con;
	Dimension dim;
	
	Font f1=new Font("Cambria",Font.BOLD,14);
	Font f2=new Font("Cambria",Font.BOLD,14);
	
	
	StaffSalarySearch()
	{
		cp=getContentPane();
		cp.setLayout(null);
		dim=new Dimension();
		dim=Toolkit.getDefaultToolkit().getScreenSize();
		
		jp1=new JPanel();
		jp1.setBounds(10,10,560,190);
		//jp1.setBorder(BorderFactory.createTitledBorder("Personal Details"));
		jp1.setBorder(BorderFactory.createLineBorder(Color.white,1));
		jp1.setBackground(Color.decode("#200000")); //decode("#F9B7FF")
	
		jp2=new JPanel();
		jp2.setBounds(10,210,560,45);
		//jp2.setBorder(BorderFactory.createTitledBorder("Personal Details"));
		jp2.setBorder(BorderFactory.createLineBorder(Color.white,1));
		jp2.setBackground(Color.decode("#200000")); //decode("#F9B7FF")

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
		bsearch=new JButton("SEARCH");					
		bcls=new JButton("CLOSE");	
		breset=new JButton("RESET");
		bprint=new JButton("PRINT");		

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
								
		cp.add(bsearch);
		bsearch.setBounds(70,220,90,25);
		bsearch.setFont(f1);
		bsearch.setBorder(BorderFactory.createLineBorder(Color.white,1));
		bsearch.setBackground(Color.black);
		bsearch.setForeground(Color.red);

		cp.add(bprint);
		bprint.setBounds(190,220,90,25);
		bprint.setFont(f1);
		bprint.setBorder(BorderFactory.createLineBorder(Color.white,1));
		bprint.setBackground(Color.black);
		bprint.setForeground(Color.white);
		
		cp.add(breset);		
		breset.setBounds(310,220,90,25);
		breset.setFont(f1);
		breset.setBorder(BorderFactory.createLineBorder(Color.white,1));
		breset.setBackground(Color.black);
		breset.setForeground(Color.red);

		cp.add(bcls);	
		bcls.setBounds(430,220,90,25);
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

		
	
		cp.setBackground(Color.black);//decode("#350000")
		setBounds(245,145,(dim.width-300),(dim.height-115)); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setIconifiable(true);
		setClosable(true);	
		setVisible(true);
		setSize(590,300);
		setTitle("Search for Staff Salary Receipt");
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
				String s=JOptionPane.showInputDialog(this,"Please enter Staff ID");
				ResultSet rs=st.executeQuery("select * from salary where Staff_ID="+Integer.parseInt(s));  //+Integer.parseInt(no)
				if(rs.next())
				{
					
					tstaffid.setText(""+rs.getString(1));
					tdt.setText(""+rs.getString(2));
					tpayslipno.setText(""+rs.getString(3));
					tstaffnm.setText(""+rs.getString(4));
					tadd.setText(""+rs.getString(5));
					tsalary.setText(""+rs.getString(6));
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
			tstaffid.setText("");   
			tdt.setText("");
			tpayslipno.setText("");
			tstaffnm.setText("");
			tsalary.setText("");
			tadd.setText("");
			tstaffid.requestFocus();
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

//String s="<html><head><body><font face=Monotype Corsiva size=7 color=red><center>Computer Institute Management System</center></font><br><br><br>"+"<font face=Century size=5 color=blue><center>FEES RECEIPT BILL</font><center>"+"<br><br><hr size=2 color=black><br>"+"<font face=Century size=4 color=green><b>Student ID&nbsp;&nbsp;Date&nbsp;&nbsp;&nbspReceipt_No&nbsp;&nbsp;&nbsp;&nbspStudent_Name&nbsp;&nbsp;&nbsp;&nbspAddress&nbsp;&nbsp;&nbsp;&nbspCourse_Name&nbsp;&nbsp;&nbsp;&nbspBy&nbsp;&nbsp;&nbsp;&nbspDrawn_On&nbsp;&nbsp;&nbsp;&nbspRupees<b>"+"<br><hr size=2 color=black><br>&nbsp;&nbsp;&nbsp;"+tstudid.getText()+"&nbsp;&nbsp;&nbsp;"+tdt.getText()+"&nbsp;&nbsp;&nbsp;"+trecptno.getText()+"&nbsp;&nbsp;&nbsp;"+tnm.getText()+"&nbsp;&nbsp;&nbsp;"+tadd.getText();+"&nbsp;&nbsp;&nbsp;"+cb2.getSelectedItem()+"&nbsp;&nbsp;&nbsp;"+cb1.getSelectedItem()+"&nbsp;&nbsp;&nbsp;"+tdrawn.getText()+"&nbsp;&nbsp;&nbsp;"+trs.getText()+"&nbsp;&nbsp;&nbsp;"+"<br><br><br><hr size=3 color=black><br><br>&nbsp;&nbsp;&nbsp;"+"</body></head></html>";
				
String s="<html><head><body><font face=Monotype Corsiva size=5 color=red><center>Computer Institute Management System</center></font><br><br><br>"+"<font face=Century size=4 color=blue><center>STAFF SALARY REPORT</font><center>"+"<br><br><hr size=2 color=black><br>"+"<font face=Century size=2 color=green><b>Staff ID&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Date&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Payslip No&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Staff Name&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Address&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Salary<b>"+"<br><hr size=2 color=black><br>"+tstaffid.getText()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+tdt.getText()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+tpayslipno.getText()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+tstaffnm.getText()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+tadd.getText()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+tsalary.getText()+"&nbsp;"+"<br><br><br><hr size=2 color=black><br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Total Payment="+tsalary.getText()+"<br><br><br><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(Authorized Signature)"+"</body></head></html>";
				
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
		StaffSalarySearch ssr=new StaffSalarySearch();
	}
}

