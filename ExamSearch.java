import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import java.text.*;

public class ExamSearch extends JInternalFrame implements ActionListener
{

	Container cp;
	JLabel lstudid,lcdnm,ldob,lgen,lcnm,lstno,lmos,lexctr,ldoe,lextm;
	JTextField tstudid,tregno,tcdnm,tstno;
	JFormattedTextField tdob,tdoe;
	JTextArea texctr;
	JScrollPane jsp;
	JComboBox cb2,cb3;
	JRadioButton r1,r2,r3,r4;
	JPanel jp1,jp2;
	Dimension dim;
	Connection con;
	
	ButtonGroup bg1,bg2;
	JButton breset,bcls,bsearch;

	Font f1=new Font("Cambria",Font.BOLD,14);
	Font f2=new Font("Cambria",Font.BOLD,14);
	
	ExamSearch()
	{
		cp=getContentPane();
		cp.setLayout(null);
		dim=new Dimension();
		dim=Toolkit.getDefaultToolkit().getScreenSize();

		jp1=new JPanel();
		jp1.setBounds(10,10,560,370);
		jp1.setBorder(BorderFactory.createLineBorder(Color.white,1));
		jp1.setBackground(Color.decode("#200000")); //decode("#F9B7FF")
	
		jp2=new JPanel();
		jp2.setBounds(10,390,560,45);
		jp2.setBorder(BorderFactory.createLineBorder(Color.white,1));
		jp2.setBackground(Color.decode("#200000")); //decode("#F9B7FF")

		/**********************************Labels****************************/
		lstudid=new JLabel("Student ID: ");
		lcdnm=new JLabel("Student's/Candidate's Name: ");
		ldob=new JLabel("Date of Birth: ");
		lgen=new JLabel("Gender: ");
		lcnm=new JLabel("Student appear for the course: ");
		ldoe=new JLabel("Exam Date: ");
		lstno=new JLabel("Candidate's Seat No: ");
		lmos=new JLabel("Mode of Study: ");
		lexctr=new JLabel("Exam Center: ");
		lextm=new JLabel("Exam Time: ");
		
		/**********************************Text Fields**************************/
		tstudid=new JTextField(20);
		tcdnm=new JTextField(20);
		tstno=new JTextField(20);
		tdoe=new JFormattedTextField();
		tdob=new JFormattedTextField();
		texctr=new JTextArea(5,2);
		jsp=new JScrollPane(texctr);
		texctr.setFont(f1);
		texctr.setForeground(Color.black);
		/************************************Buttons******************************/
		breset=new JButton("RESET");
		bsearch=new JButton("SEARCH");						
		bcls=new JButton("CLOSE");
	
		/*************************************************Combo Box*********************************************************/
		cb2=new JComboBox();
		cb2.addItem("");
		cb2.addItem(" 8:00AM-9:00AM");
		cb2.addItem(" 9:00AM-10:00AM");
		cb2.addItem(" 10:00AM-11:00AM");
		cb2.addItem(" 11:00AM-12:00PM");
		cb2.addItem(" 12:00PM-1:00PM");
		cb2.addItem(" 1:00PM-2:00PM");
		cb2.addItem(" 2:00PM-3:00PM");
		cb2.addItem(" 3:00PM-4:00PM");
		cb2.addItem(" 4:00PM-5:00PM");
		cb2.addItem(" 5:00PM-6:00PM");
		cb2.setEditable(true);

		cb3=new JComboBox();
		cb3.addItem("");
		cb3.addItem("Certificate Course in Information Technology(CCIT)");
		cb3.addItem("Certificate Course in DTP(CCDTP)");	
		cb3.addItem("Certificate Course in C");
		cb3.addItem("Certificate Course in C++");
		cb3.addItem("Certificate Course in Java");
		cb3.addItem("MS-Office");
		cb3.addItem("SQL");
		cb3.addItem("HTML");
		cb3.addItem("Corel Draw");
		cb3.addItem("Tally");
		cb3.addItem("Photoshop");
		/*****************************************Radio Button*******************************************/
		r1=new JRadioButton("Male");
		r2=new JRadioButton("Female");
		r3=new JRadioButton("Regular");
		r4=new JRadioButton("Irregular");
		
		
		/***********************************************************************************************************/
		
		cp.add(lstudid);
		lstudid.setBounds(20,10,80,30);
		lstudid.setFont(f1);
		lstudid.setForeground(Color.decode("#FFFFFF"));
		cp.add(tstudid);
		tstudid.setBounds(220,15,100,22);
		tstudid.setFont(f2);
		tstudid.setForeground(Color.black);
		tstudid.setBorder(BorderFactory.createLineBorder(Color.black,1));

		cp.add(lcdnm);
		lcdnm.setBounds(20,40,190,30);
		lcdnm.setFont(f1);
		lcdnm.setForeground(Color.decode("#FFFFFF"));
		cp.add(tcdnm);
		tcdnm.setBounds(220,45,250,22);
		tcdnm.setFont(f2);
		tcdnm.setForeground(Color.black);
		tcdnm.setBorder(BorderFactory.createLineBorder(Color.black,1));

		
		cp.add(ldob);
		ldob.setBounds(20,70,150,30);
		ldob.setFont(f1);
		ldob.setForeground(Color.decode("#FFFFFF"));
		cp.add(tdob);
		tdob.setBounds(220,75,100,22);
		tdob.setFont(f2);
		tdob.setForeground(Color.black);
		tdob.setBorder(BorderFactory.createLineBorder(Color.black,1));

			
		cp.add(lgen);
		lgen.setBounds(20,100,60,30);
		lgen.setFont(f1);
		lgen.setForeground(Color.decode("#FFFFFF"));
		cp.add(r1);
		r1.setBounds(220,105,100,23);
		r1.setFont(f1);
		r1.setBackground(Color.decode("#200000"));
		r1.setForeground(Color.decode("#FFFFFF"));
		cp.add(r2);
		r2.setBounds(320,105,100,23);
		r2.setFont(f1);
		r2.setBackground(Color.decode("#200000"));
		r2.setForeground(Color.decode("#FFFFFF"));

		
		cp.add(lcnm);
		lcnm.setBounds(20,130,200,30);
		lcnm.setFont(f1);
		lcnm.setForeground(Color.decode("#FFFFFF"));
		cp.add(cb3);
		cb3.setBounds(220,135,280,22);
		cb3.setFont(f2);
		cb3.setForeground(Color.black);
		cb3.setBorder(BorderFactory.createLineBorder(Color.black,1));

		
		cp.add(lstno);
		lstno.setBounds(20,160,150,30);
		lstno.setFont(f1);
		lstno.setForeground(Color.decode("#FFFFFF"));
		cp.add(tstno);
		tstno.setBounds(220,165,140,22);
		tstno.setFont(f2);
		tstno.setForeground(Color.black);
		tstno.setBorder(BorderFactory.createLineBorder(Color.black,1));

		
		cp.add(lmos);
		lmos.setBounds(20,190,200,30);
		lmos.setFont(f1);
		lmos.setForeground(Color.decode("#FFFFFF"));
		cp.add(r3);
		r3.setBounds(220,195,100,23);
		r3.setFont(f1);
		r3.setBackground(Color.decode("#200000"));
		r3.setForeground(Color.decode("#FFFFFF"));
		cp.add(r4);
		r4.setBounds(320,195,100,23);
		r4.setFont(f1);
		r4.setBackground(Color.decode("#200000"));
		r4.setForeground(Color.decode("#FFFFFF"));

		
		cp.add(lexctr);
		lexctr.setBounds(20,220,90,30);
		lexctr.setFont(f1);
		lexctr.setForeground(Color.decode("#FFFFFF"));
		cp.add(jsp);
		jsp.setBounds(220,230,140,60);
		jsp.setBorder(BorderFactory.createLineBorder(Color.black,1));

		
		cp.add(ldoe);
		ldoe.setBounds(20,300,150,30);
		ldoe.setFont(f1);
		ldoe.setForeground(Color.decode("#FFFFFF"));
		cp.add(tdoe);
		tdoe.setBounds(220,305,100,22);
		tdoe.setFont(f2);
		tdoe.setForeground(Color.black);
		tdoe.setBorder(BorderFactory.createLineBorder(Color.black,1));

	
		cp.add(lextm);
		lextm.setBounds(20,340,80,30);
		lextm.setFont(f1);
		lextm.setForeground(Color.decode("#FFFFFF"));
		cp.add(cb2);
		cb2.setBounds(220,345,150,23);
		cb2.setFont(f2);
		cb2.setForeground(Color.black);
		cb2.setBorder(BorderFactory.createLineBorder(Color.black,1));

		
		
		cp.add(jp1);
		

		cp.add(bsearch);	
		bsearch.setBounds(150,400,70,25);
		bsearch.setFont(f1);
		bsearch.setBorder(BorderFactory.createLineBorder(Color.white,1));
		bsearch.setBackground(Color.black);
		bsearch.setForeground(Color.white);


		cp.add(breset);
		breset.setBounds(250,400,70,25);
		breset.setFont(f1);
		breset.setBorder(BorderFactory.createLineBorder(Color.white,1));
		breset.setBackground(Color.black);
		breset.setForeground(Color.red);

		cp.add(bcls);	
		bcls.setBounds(350,400,80,25);
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

		bg1=new ButtonGroup();	
		bg1.add(r1);
		bg1.add(r2);
		bg2=new ButtonGroup();	
		bg2.add(r3);
		bg2.add(r4);
	
		setBounds(245,75,(dim.width-300),(dim.height-115));  //200,80,800,590
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setIconifiable(true);
		setClosable(true);	
		setVisible(true);
		setSize(590,475);
		cp.setBackground(Color.black);//decode("#350000")
		setTitle("Search for Exam Details");
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
				ResultSet rs=st.executeQuery("select * from exam where Student_ID="+Integer.parseInt(s));  //+Integer.parseInt(s)
				if(rs.next())
				{
					
					tstudid.setText(""+rs.getString(1));
					tcdnm.setText(""+rs.getString(2));
					tdob.setText(""+rs.getString(3));
					String str1=rs.getString(4);
					if(str1.equals("Male"))
					{
						r1.setSelected(true);
					}
					else
					{
						r2.setSelected(true);
					}
					cb3.setSelectedItem(rs.getString(5));
					tstno.setText(""+rs.getString(6));
					String str2=rs.getString(7);
					if(str2.equals("Regular"))
					{
						r3.setSelected(true);
					}
					else
					{
						r4.setSelected(true);
					}
					texctr.setText(""+rs.getString(8));
					tdoe.setText(""+rs.getString(9));
					cb2.setSelectedItem(rs.getString(10));
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
			tdob.setText("");
			tcdnm.setText("");
			bg1.clearSelection();
			bg2.clearSelection();
			cb2.setSelectedIndex(0);
			cb3.setSelectedIndex(0);
			tstno.setText("");
			texctr.setText("");
			tdoe.setText("");
			tstudid.requestFocus();
		}
		
	}
	public static void main(String args[])
	{
		ExamSearch ed=new ExamSearch();
	}
	
}