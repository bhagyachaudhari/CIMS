import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import java.util.Calendar;


public class AdmssnSearch extends JInternalFrame implements ActionListener
{
	Container cp;
	JLabel lstudid,lsnm,ldoa,lcn,ltcfs,ladmfs;
	JTextField tstudid,tsnm,ttcfs,tadmfs;
	JFormattedTextField tdoa;
	JButton breset,bcls,bsearch;
	JRadioButton r1,r2;
	ButtonGroup bg;
	JComboBox cb2,cb3; 
	JPanel jp1,jp2;
	Dimension dim;
	Connection con;
			
	Font f1=new Font("Cambria",Font.BOLD,14);
	Font f2=new Font("Cambria",Font.BOLD,14);
	
	AdmssnSearch()
	{
		cp=getContentPane();
		cp.setLayout(null);
		dim=new Dimension();
		dim=Toolkit.getDefaultToolkit().getScreenSize();
	
		jp1=new JPanel();
		jp1.setBounds(10,10,570,370);
		//jp1.setBorder(BorderFactory.createTitledBorder("Personal Details"));
		jp1.setBorder(BorderFactory.createLineBorder(Color.white,1));
		jp1.setBackground(Color.decode("#200000")); //decode("#F9B7FF")
	
		jp2=new JPanel();
		jp2.setBounds(10,395,570,55);
		//jp2.setBorder(BorderFactory.createTitledBorder("Personal Details"));
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
		bcls=new JButton("CLOSE");	
		bsearch=new JButton("SEARCH");	
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

		
		cp.add(bsearch);
		bsearch.setBounds(150,410,80,25);
		bsearch.setFont(f1);
		bsearch.setBorder(BorderFactory.createLineBorder(Color.white,1));
		bsearch.setBackground(Color.black);
		bsearch.setForeground(Color.white);

		cp.add(breset);
		breset.setBounds(250,410,80,25);
		breset.setFont(f1);
		breset.setBorder(BorderFactory.createLineBorder(Color.white,1));
		breset.setBackground(Color.black);
		breset.setForeground(Color.red);

		cp.add(bcls);	
		bcls.setBounds(350,410,80,25);
		bcls.setFont(f1);
		bcls.setBorder(BorderFactory.createLineBorder(Color.white,1));
		bcls.setBackground(Color.black);
		bcls.setForeground(Color.red);


		cp.add(jp2);
		
		bcls.addActionListener(this);
		bsearch.addActionListener(this);
		breset.addActionListener(this);

		bcls.setToolTipText("Close form");
		breset.setToolTipText("Clear");
		bsearch.setToolTipText("Search the Records");
		
		bg=new ButtonGroup();
		bg.add(r1);
		bg.add(r2);

		cp.setBackground(Color.black);//decode("#350000")
		setBounds(245,75,(dim.width-300),(dim.height-115));  //200,80,800,590
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setIconifiable(true);
		setClosable(true);	
		setVisible(true);
		setSize(600,495);
		setTitle("Search for Admission Details");
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
				ResultSet rs=st.executeQuery("SELECT * from admission where Student_ID= "+Integer.parseInt(s));  //+Integer.parseInt(no)
				if(rs.next())
				{
					tstudid.setText(""+rs.getString(1));
					tsnm.setText(""+rs.getString(2));
					tdoa.setText(""+rs.getString(3));
					
					String rb=rs.getString(4);
					String str=rs.getString(5);
					
					if(rb.equals("Modular Courses"))
					{
						
						r1.setSelected(true);
						
						if(str.equals("MS-Office"))
							cb2.setSelectedIndex(1);
						else if(str.equals("HTML"))
							cb2.setSelectedIndex(2);
						else if(str.equals("Corel Draw"))
							cb2.setSelectedIndex(3);
						else if(str.equals("Tally"))
							cb2.setSelectedIndex(4);
						else if(str.equals("SQL"))
							cb2.setSelectedIndex(5);
						else 
							cb2.setSelectedIndex(6);
					}
					else
					{
						r2.setSelected(true);

						if(str.equals("Certificate course in Information Technology(CCIT)"))
							cb3.setSelectedIndex(1);
						else if(str.equals("Certificate course in DTP(CCDTP)"))
							cb3.setSelectedIndex(2);
						else if(str.equals("Certificate course in C"))
							cb3.setSelectedIndex(3);
						else if(str.equals("Certificate course in C++"))
							cb3.setSelectedIndex(4);
						else 
							cb3.setSelectedIndex(5);
					}

					ttcfs.setText(""+rs.getString(6));
					tadmfs.setText(""+rs.getString(7));
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
			tdoa.setText("");
			tsnm.setText("");  
			bg.clearSelection(); 
			cb2.setSelectedIndex(0);
			cb3.setSelectedIndex(0);
			ttcfs.setText("");
			tadmfs.setText("");
		}
	}
	public static void main(String args[])
	{
		AdmssnSearch as=new AdmssnSearch();
	}
}