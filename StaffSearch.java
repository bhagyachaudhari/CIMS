import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import java.text.*;

public class StaffSearch extends JInternalFrame implements ActionListener
{
	Container cp;
	JLabel lstaffid,lstaffcd,lnm,lgen,lqlf,ladd,lphno,ldes,lfac,lsal;
	JTextField tstaffid,tnm,tqlf,tphno,tdes,tsal;
	JTextArea tadd;
	JButton bsearch,bcls,breset;
	JRadioButton r1,r2;
	JComboBox cb1,cb2;
	ButtonGroup bg;
	JPanel jp1,jp2;
	JScrollPane jsp;
	Connection con;
	Dimension dim;

	Font f1=new Font("Cambria",Font.BOLD,14);
	Font f2=new Font("Cambria",Font.BOLD,14);
	
	StaffSearch()
	{
		cp=getContentPane();
		cp.setLayout(null);
		dim=new Dimension();
		dim=Toolkit.getDefaultToolkit().getScreenSize();

		jp1=new JPanel();
		jp1.setBounds(10,10,560,400);
		//jp1.setBorder(BorderFactory.createTitledBorder("Personal Details"));
		jp1.setBorder(BorderFactory.createLineBorder(Color.white,1));
		jp1.setBackground(Color.decode("#200000")); //decode("#F9B7FF")
	
		jp2=new JPanel();
		jp2.setBounds(10,420,560,45);
		//jp2.setBorder(BorderFactory.createTitledBorder("Personal Details"));
		jp2.setBorder(BorderFactory.createLineBorder(Color.white,1));
		jp2.setBackground(Color.decode("#200000")); //decode("#F9B7FF")
		
		/**********************************Labels****************************/
		lstaffid=new JLabel("Staff ID: ");
		lstaffcd=new JLabel("Staff Code: ");
		lnm=new JLabel("Name: ");
		lgen=new JLabel("Gender: ");
		lqlf=new JLabel("Qualification: ");
		ladd=new JLabel("Address: ");
		lphno=new JLabel("Phon No: ");
		ldes=new JLabel("Designation: ");
		lfac=new JLabel("Faculty: ");
		lsal=new JLabel("Salary: ");
	
		/**********************************Text Fields**************************/
		tstaffid=new JTextField(20);
		tnm=new JTextField(20);
		tqlf=new JTextField(20);
		tphno=new JTextField(20);		
		tdes=new JTextField(20);		
		tsal=new JTextField(20);				
		
		/***********************************Text Area****************************/
		tadd=new JTextArea(20,5);
		jsp=new JScrollPane(tadd);
		tadd.setFont(f2);
		
	
		/************************************Buttons******************************/
		bsearch=new JButton("SEARCH");	
			
		bcls=new JButton("CLOSE");	
		breset=new JButton("RESET");	
		/**************************************Radio Button***********************/			
		
		r1=new JRadioButton("Male");
		r2=new JRadioButton("Female");
	
		cb1=new JComboBox();
		cb1.addItem("");
		cb1.addItem("T1");
		cb1.addItem("T2");	
		cb1.addItem("T3");
		cb1.addItem("T4");

		cb2=new JComboBox();
		cb2.addItem("");
		cb2.addItem("Certificate Courses");
		cb2.addItem("Modular Courses");
		
		cp.add(lstaffid);
		lstaffid.setBounds(25,30,90,30);
		lstaffid.setFont(f1);
		lstaffid.setForeground(Color.decode("#FFFFFF"));
		cp.add(tstaffid);
		tstaffid.setBounds(135,35,100,22);
		tstaffid.setFont(f2);
		tstaffid.setForeground(Color.black);
		tstaffid.setBorder(BorderFactory.createLineBorder(Color.black,1));

		cp.add(lstaffcd);
		lstaffcd.setBounds(25,60,90,30);
		lstaffcd.setFont(f1);
		lstaffcd.setForeground(Color.decode("#FFFFFF"));
		cp.add(cb1);
		cb1.setBounds(135,65,100,22);
		cb1.setFont(f2);
		cb1.setForeground(Color.black);
		cb1.setBorder(BorderFactory.createLineBorder(Color.black,1));

		cp.add(lnm);
		lnm.setBounds(25,90,60,30);
		lnm.setFont(f1);
		lnm.setForeground(Color.decode("#FFFFFF"));
		cp.add(tnm);
		tnm.setBounds(135,95,180,22);
		tnm.setFont(f2);
		tnm.setForeground(Color.black);
		tnm.setBorder(BorderFactory.createLineBorder(Color.black,1));

		cp.add(lgen);
		lgen.setBounds(25,120,60,30);
		lgen.setFont(f1);
		lgen.setForeground(Color.decode("#FFFFFF"));
		cp.add(r1);
		r1.setBounds(135,120,60,30);
		r1.setFont(f1);
		r1.setBackground(Color.decode("#200000"));
		r1.setForeground(Color.decode("#FFFFFF"));
		cp.add(r2);
		r2.setBounds(205,120,100,30);
		r2.setFont(f1);
		r2.setBackground(Color.decode("#200000"));
		r2.setForeground(Color.decode("#FFFFFF"));
		
		cp.add(lqlf);
		lqlf.setBounds(25,150,100,30);
		lqlf.setFont(f1);
		lqlf.setForeground(Color.decode("#FFFFFF"));
		cp.add(tqlf);
		tqlf.setBounds(135,160,180,22);
		tqlf.setFont(f2);
		tqlf.setForeground(Color.black);
		tqlf.setBorder(BorderFactory.createLineBorder(Color.black,1));
		
		cp.add(ladd);
		ladd.setBounds(25,190,60,30);
		ladd.setFont(f1);
		ladd.setForeground(Color.decode("#FFFFFF"));
		cp.add(jsp);
		jsp.setBounds(135,195,180,70);
		jsp.setBorder(BorderFactory.createLineBorder(Color.black,1));
		
					
		cp.add(lphno);
		lphno.setBounds(25,270,90,30);
		lphno.setFont(f1);
		lphno.setForeground(Color.decode("#FFFFFF"));
		cp.add(tphno);
		tphno.setBounds(135,275,150,22);
		tphno.setFont(f2);
		tphno.setForeground(Color.black);
		tphno.setBorder(BorderFactory.createLineBorder(Color.black,1));
				
		cp.add(ldes);
		ldes.setBounds(25,300,90,30);
		ldes.setFont(f1);
		ldes.setForeground(Color.decode("#FFFFFF"));
		cp.add(tdes);
		tdes.setBounds(135,305,180,22);
		tdes.setFont(f2);
		tdes.setForeground(Color.black);
		tdes.setBorder(BorderFactory.createLineBorder(Color.black,1));
			
		cp.add(lfac);
		lfac.setBounds(25,330,90,30);
		lfac.setFont(f1);
		lfac.setForeground(Color.decode("#FFFFFF"));
		cp.add(cb2);
		cb2.setBounds(135,335,180,22);
		cb2.setFont(f2);
		cb2.setForeground(Color.black);
		cb2.setBorder(BorderFactory.createLineBorder(Color.black,1));
	
		cp.add(lsal);
		lsal.setBounds(25,360,90,30);
		lsal.setFont(f1);
		lsal.setForeground(Color.decode("#FFFFFF"));
		cp.add(tsal);
		tsal.setBounds(135,365,180,22);
		tsal.setFont(f2);
		tsal.setForeground(Color.black);
		tsal.setBorder(BorderFactory.createLineBorder(Color.black,1));
		cp.add(jp1);
								
		cp.add(bsearch);
		bsearch.setBounds(135,430,80,25);
		bsearch.setFont(f1);
		bsearch.setBorder(BorderFactory.createLineBorder(Color.white,1));
		bsearch.setBackground(Color.black);
		bsearch.setForeground(Color.white);

		cp.add(breset);	
		breset.setBounds(245,430,80,25);
		breset.setFont(f1);
		breset.setBorder(BorderFactory.createLineBorder(Color.white,1));
		breset.setBackground(Color.black);
		breset.setForeground(Color.red);

		cp.add(bcls);
		bcls.setBounds(355,430,80,25);
		bcls.setFont(f1);
		bcls.setBorder(BorderFactory.createLineBorder(Color.white,1));
		bcls.setBackground(Color.black);
		bcls.setForeground(Color.red);
		
		cp.add(jp2);

		bcls.addActionListener(this);
		breset.addActionListener(this);	
		bsearch.addActionListener(this);
		
		bcls.setToolTipText("Close form");
		breset.setToolTipText("Clear");
		bsearch.setToolTipText("Search the Records");

		bg=new ButtonGroup();
		bg.add(r1);
		bg.add(r2);

		setBounds(245,75,(dim.width-300),(dim.height-115)); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setIconifiable(true);
		setClosable(true);	
		setVisible(true);
		setSize(590,510);
		cp.setBackground(Color.black);
		setVisible(true);
		setSize(590,510);
		setTitle("Search for Staff Details");
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
				String s=JOptionPane.showInputDialog(this,"Please Enter Staff ID");
				ResultSet rs=st.executeQuery("select * from staff where Staff_ID= "+Integer.parseInt(s));  //+Integer.parseInt(s)
				if(rs.next())
				{
					
					tstaffid.setText(""+rs.getString(1));
					cb1.setSelectedItem(rs.getString(2));
					tnm.setText(""+rs.getString(3));
					String str=rs.getString(4);
					if(str.equals("Male"))
					{
						r1.setSelected(true);
					}
					else
					{
						r2.setSelected(true);
					}
					tqlf.setText(""+rs.getString(5));
					tadd.setText(""+rs.getString(6));
					tphno.setText(""+rs.getString(7));
					tdes.setText(""+rs.getString(8));
					cb2.setSelectedItem(rs.getString(9));
					tsal.setText(""+rs.getString(10));
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
			cb1.setSelectedIndex(0); 
			tnm.setText("");
			tqlf.setText("");
			tphno.setText("");
			tdes.setText("");
			cb2.setSelectedIndex(0); 
			tsal.setText("");
			tadd.setText("");
			bg.clearSelection();
			tstaffid.requestFocus();
		}
	}	
	public static void main(String args[])
	{
		StaffSearch sd=new StaffSearch();
	}
}


		
							

		
	
					
		
					
			
					
						

				
	
	
	
	
	
	

	
		
	
		
	
		
		

	
		
	
	
	

				
	

	

		
		
		
		
		
		
		
		
	
		
		
		
		
		
		
		
		
			
	
	
	
	
	
	
	