import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import java.text.*;

public class CourseSearch extends JInternalFrame implements ActionListener
{
	Container cp;
	JLabel lstudid,lsnm,lcn,ldur,lcn1,lcn2,ldur1,ldur2,ltcfs;
	JTextField tstudid,tsnm,tcn,tdur,ttcfs;
	JButton breset,bsearch,bcls;
	JRadioButton r1,r2,r3,r4,r5,r6,r7,r8,r9,r10,r11;
	ButtonGroup bg1;
	JComboBox cb1,cb2; 
	JPanel jp1,jp2,jp3,jp4;
	Dimension dim;
	Connection con;

	Font f1=new Font("Cambria",Font.BOLD,14);
	Font f2=new Font("Cambria",Font.BOLD,14);
	
	CourseSearch()
	{
		cp=getContentPane();
		cp.setLayout(null);
		dim=new Dimension();
		dim=Toolkit.getDefaultToolkit().getScreenSize();

		jp1=new JPanel();
		jp1.setBounds(10,10,710,130);
		jp1.setBorder(BorderFactory.createLineBorder(Color.white,1));
		jp1.setBackground(Color.decode("#200000")); //decode("#F9B7FF")
	
		jp2=new JPanel();
		jp2.setBounds(10,450,710,55);
		jp2.setBorder(BorderFactory.createLineBorder(Color.white,1));
		jp2.setBackground(Color.decode("#200000")); //decode("#F9B7FF")
		
		jp3=new JPanel();
		jp3.setBounds(10,150,350,230);
		jp3.setBorder(BorderFactory.createLineBorder(Color.white,1));
		jp3.setBackground(Color.decode("#200000")); //decode("#F9B7FF")

		jp4=new JPanel();
		jp4.setBounds(370,150,350,230);
		jp4.setBorder(BorderFactory.createLineBorder(Color.white,1));
		jp4.setBackground(Color.decode("#200000")); //decode("#F9B7FF")
		
		
		
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
		tdur=new JTextField(20);
		
		/************************************Buttons******************************/
		breset=new JButton("RESET");			
		bcls=new JButton("CLOSE");
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
		
	
		cp.add(bsearch);
		bsearch.setBounds(195,465,80,25);
		bsearch.setFont(f1);
		bsearch.setBorder(BorderFactory.createLineBorder(Color.white,1));
		bsearch.setBackground(Color.black);
		bsearch.setForeground(Color.white);

		cp.add(breset);	
		breset.setBounds(320,465,80,25);
		breset.setFont(f1);
		breset.setBorder(BorderFactory.createLineBorder(Color.white,1));
		breset.setBackground(Color.black);
		breset.setForeground(Color.red);


		cp.add(bcls);
		bcls.setBounds(445,465,80,25);
		bcls.setFont(f1);
		bcls.setBorder(BorderFactory.createLineBorder(Color.white,1));
		bcls.setBackground(Color.black);
		bcls.setForeground(Color.red);

		cp.add(jp2);
		
		bsearch.addActionListener(this);
		bcls.addActionListener(this);
		breset.addActionListener(this);	
		
		bcls.setToolTipText("Close form");
		breset.setToolTipText("Clear");
		bsearch.setToolTipText("Search the Records");

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

		setBounds(245,75,(dim.width-300),(dim.height-115));  //200,80,800,590
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setIconifiable(true);
		setClosable(true);	
		setVisible(true);
		setSize(735,545);
		cp.setBackground(Color.black);//decode("#350000")
		setTitle("Search for Course Details");
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
				ResultSet rs=st.executeQuery("select * from course where Student_ID="+Integer.parseInt(s));  //+Integer.parseInt(no)
				if(rs.next())
				{
					tstudid.setText(""+rs.getString(1));
					tsnm.setText(""+rs.getString(2));
					tcn.setText(""+rs.getString(3));
					tdur.setText(""+rs.getString(4));
					/*String str=rs.getString(5);
					if(cb1.getSelectedIndex()==0 && str.equals("Certificate Course in Information Technology(CCIT)"))
					{
						r1.setSelected(true);
					}
					else if(cb1.getSelectedIndex()==0 && str.equals("Certificate Course in DTP(CCDTP)"))
					{
						r2.setSelected(true);
					}
					else if(cb1.getSelectedIndex()==0 && str.equals("Certificate Course in C"))
					{
						r3.setSelected(true);
					}
					else if(cb1.getSelectedIndex()==0 && str.equals("Certificate Courses in C++"))
					{
						r4.setSelected(true);
					}
					else if(cb1.getSelectedIndex()==0 && str.equals("Certificate Course in Java"))
					{
						r5.setSelected(true);
					}
					else if(cb2.getSelectedIndex()==1 && str.equals("MS-Office"))
					{
						r6.setSelected(true);
					}
					else if(cb2.getSelectedIndex()==1 && str.equals("SQL"))
					{
						r7.setSelected(true);
					}
					else if(cb2.getSelectedIndex()==1 && str.equals("HTML"))
					{
						r8.setSelected(true);
					}
					else if(cb2.getSelectedIndex()==1 && str.equals("Corel Draw"))
					{
						r9.setSelected(true);
					}
					else if(cb2.getSelectedIndex()==1 && str.equals("Tally"))
					{
						r10.setSelected(true);
					}
					else if(cb2.getSelectedIndex()==1 && str.equals("Photoshop"))
					{
						r11.setSelected(true);
					}
					*/
					ttcfs.setText(""+rs.getString(5));
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
			tcn.setText("");  
			bg1.clearSelection();
			cb1.setSelectedIndex(0);
			cb2.setSelectedIndex(0);
			tdur.setText("");
			ttcfs.setText("");
			tstudid.requestFocus();
		}
	}
	public static void main(String args[])
	{
		CourseSearch cs=new  CourseSearch();
	}
}