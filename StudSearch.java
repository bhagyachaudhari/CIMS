import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import java.text.*;



public class StudSearch extends JInternalFrame implements ActionListener
{
	Container cp;
	JLabel lstudid,ldoa,lsnm,ladd,lphno,leid,ldob,lgen,lcnm,lqlf;
	JTextField tstudid,tsnm,tphno,teid,tqlf;
	JFormattedTextField tdoa,tdob;
	JTextArea tadd;
	JScrollPane jsp;
	JButton bsearch,bcls,breset;
	JRadioButton rb1,rb2;
	ButtonGroup bg;
	JComboBox cb1;
	JPanel jp1,jp2;
	Connection con;
	Dimension dim;
			
	Font f1=new Font("Cambria",Font.BOLD,14);
	Font f2=new Font("Cambria",Font.BOLD,14);
	
	
	
	StudSearch()		
	{
		cp=getContentPane();
		cp.setLayout(null);
		dim=new Dimension();
		dim=Toolkit.getDefaultToolkit().getScreenSize();
	
		jp1=new JPanel();
		jp1.setBounds(10,10,715,370);
		jp1.setBorder(BorderFactory.createLineBorder(Color.white,1));
		jp1.setBackground(Color.decode("#200000")); 
	
		jp2=new JPanel();
		jp2.setBounds(10,395,715,55);
		jp2.setBorder(BorderFactory.createLineBorder(Color.white,1));
		jp2.setBackground(Color.decode("#200000")); 
		
		/**********************************Labels****************************/
		lstudid=new JLabel("Student ID: ");
		ldoa=new JLabel("Date of Admission: ");
		lsnm=new JLabel("Student's Name: ");
		ladd=new JLabel("Address: ");
		lphno=new JLabel("Phon No: ");
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
	
		/************************************Buttons******************************/
		bsearch=new JButton("SEARCH");	
			
		bcls=new JButton("CLOSE");	
		breset=new JButton("RESET");	

		/****************************************CB**************************************/
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

		/**************************************Radio Button***********************/			
		
		rb1=new JRadioButton("Male");
		rb2=new JRadioButton("Female");

		/******************************************************************************************************/
		
		cp.add(lstudid);
		lstudid.setBounds(25,20,80,30);
		lstudid.setFont(f1);
		lstudid.setForeground(Color.decode("#FFFFFF"));
		cp.add(tstudid);
		tstudid.setBounds(135,25,100,22);
		tstudid.setFont(f2);
		tstudid.setForeground(Color.black);
		tstudid.setBorder(BorderFactory.createLineBorder(Color.black,1));
		
		cp.add(ldoa);
		ldoa.setBounds(385,20,150,30);
		ldoa.setFont(f1);
		ldoa.setForeground(Color.decode("#FFFFFF"));
		cp.add(tdoa);
		tdoa.setBounds(510,25,100,22);
		tdoa.setFont(f2);
		tdoa.setForeground(Color.black);
		tdoa.setBorder(BorderFactory.createLineBorder(Color.black,1));
		
		cp.add(lsnm);
		lsnm.setBounds(25,60,150,30);
		lsnm.setFont(f1);
		lsnm.setForeground(Color.decode("#FFFFFF"));
		cp.add(tsnm);
		tsnm.setBounds(135,65,250,22);
		tsnm.setFont(f2);
		tsnm.setForeground(Color.black);
		tsnm.setBorder(BorderFactory.createLineBorder(Color.black,1));
		
		cp.add(ladd);
		ladd.setBounds(25,100,100,30);
		ladd.setFont(f1);
		ladd.setForeground(Color.decode("#FFFFFF"));
		cp.add(jsp);
		jsp.setBounds(135,110,140,70);
		jsp.setBorder(BorderFactory.createLineBorder(Color.black,1));
		
		cp.add(lphno);
		lphno.setBounds(25,190,80,30);
		lphno.setFont(f1);
		lphno.setForeground(Color.decode("#FFFFFF"));
		cp.add(tphno);
		tphno.setBounds(135,195,140,22);
		tphno.setFont(f2);
		tphno.setForeground(Color.black);
		tphno.setBorder(BorderFactory.createLineBorder(Color.black,1));

		cp.add(leid);
		leid.setBounds(25,220,60,30);
		leid.setFont(f1);
		leid.setForeground(Color.decode("#FFFFFF"));
		cp.add(teid);
		teid.setBounds(135,225,200,22);
		teid.setFont(f2);
		teid.setForeground(Color.black);
		teid.setBorder(BorderFactory.createLineBorder(Color.black,1));

		cp.add(ldob);
		ldob.setBounds(25,250,100,30);
		ldob.setFont(f1);
		ldob.setForeground(Color.decode("#FFFFFF"));
		cp.add(tdob);
		tdob.setBounds(135,255,140,22);
		tdob.setFont(f2);
		tdob.setForeground(Color.black);
		tdob.setBorder(BorderFactory.createLineBorder(Color.black,1));
	
		cp.add(lgen);
		lgen.setBounds(25,280,60,30);
		lgen.setFont(f1);
		lgen.setForeground(Color.decode("#FFFFFF"));
		cp.add(rb1);
		rb1.setBounds(130,280,60,30);
		rb1.setFont(f1);
		rb1.setBackground(Color.decode("#200000"));
		rb1.setForeground(Color.decode("#FFFFFF"));
		cp.add(rb2);
		rb2.setBounds(205,280,80,30);
		rb2.setFont(f1);
		rb2.setBackground(Color.decode("#200000"));
		rb2.setForeground(Color.decode("#FFFFFF"));
		
		cp.add(lcnm);
		lcnm.setBounds(25,310,100,30);
		lcnm.setFont(f1);	
		lcnm.setForeground(Color.decode("#FFFFFF"));
		cp.add(cb1);
		cb1.setBounds(135,315,280,22);
		cb1.setFont(f2);
		cb1.setForeground(Color.black);
		cb1.setBorder(BorderFactory.createLineBorder(Color.black,1));	
	
		cp.add(lqlf);
		lqlf.setBounds(25,340,100,30);	
		lqlf.setFont(f1);
		lqlf.setForeground(Color.decode("#FFFFFF"));
		cp.add(tqlf);
		tqlf.setBounds(135,345,200,22);
		tqlf.setFont(f2);
		tqlf.setForeground(Color.black);
		tqlf.setBorder(BorderFactory.createLineBorder(Color.black,1));
		
		cp.add(jp1);	
	
		cp.add(bsearch);		
		bsearch.setBounds(135,410,80,25);
		bsearch.setFont(f1);
		bsearch.setBorder(BorderFactory.createLineBorder(Color.white,1));
		bsearch.setBackground(Color.black);
		bsearch.setForeground(Color.white);  

		
		cp.add(breset);		
		breset.setBounds(335,410,80,25);
		breset.setFont(f1);
		breset.setBorder(BorderFactory.createLineBorder(Color.white,1));
		breset.setBackground(Color.black);
		breset.setForeground(Color.red);  

		cp.add(bcls);	
		bcls.setBounds(535,410,80,25);	
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
		bg.add(rb1);
		bg.add(rb2);
		
		setBounds(245,75,(dim.width-300),(dim.height-115));  
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		setIconifiable(true);
		setClosable(true);	
		setSize(745,495);
		setTitle("Search for Student Details");
		cp.setBackground(Color.black);
	
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
				ResultSet rs=st.executeQuery("select * from student where Student_ID="+Integer.parseInt(s));  //+Integer.parseInt(no)
				if(rs.next())
				{
					tstudid.setText(""+rs.getString(1));
					tdoa.setText(""+rs.getString(2));
					tsnm.setText(""+rs.getString(3));
					tadd.setText(""+rs.getString(4));
					tphno.setText(""+rs.getString(5));
					teid.setText(""+rs.getString(6));
					tdob.setText(""+rs.getString(7));
					String str=rs.getString(8);
					if(str.equals("Male"))
					{
						rb1.setSelected(true);
					}
					else
					{
						rb2.setSelected(true);
					}
					cb1.setSelectedItem(rs.getString(9));
					tqlf.setText(""+rs.getString(10));
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
			tphno.setText("");
			teid.setText("");
			cb1.setSelectedIndex(0);
			tqlf.setText("");
			tdoa.setText("");
			tdob.setText("");
			tadd.setText("");
			bg.clearSelection();
			tstudid.requestFocus();
		}
	}
	
	public static void main(String args[])
	{
		StudSearch ss=new StudSearch();
	}
	
}