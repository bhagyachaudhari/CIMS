import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import java.text.*;

public class TimeTableSearch extends JInternalFrame implements ActionListener
{
	Container cp;
	JLabel llbno,lday,ltim,lbatchcd,lstaffcd,lstudid;
	JTextField tlbno,tstudid;
	JButton bsearch,bcls,breset;
	JPanel jp1,jp2;
	JComboBox cb1,cb2,cb3,cb4,cb5;
	Dimension dim;
	Connection con;
	Font f1=new Font("Cambria",Font.BOLD,14);
	Font f2=new Font("Cambria",Font.BOLD,14);

	TimeTableSearch()
	{
		cp=getContentPane();
		cp.setLayout(null);
		dim=new Dimension();
		dim=Toolkit.getDefaultToolkit().getScreenSize();

		jp1=new JPanel();
		jp1.setBounds(10,10,510,250);
		//jp1.setBorder(BorderFactory.createTitledBorder("Personal Details"));
		jp1.setBorder(BorderFactory.createLineBorder(Color.white,1));
		jp1.setBackground(Color.decode("#200000")); //decode("#F9B7FF")
	
		jp2=new JPanel();
		jp2.setBounds(10,270,510,45);
		//jp2.setBorder(BorderFactory.createTitledBorder("Personal Details"));
		jp2.setBorder(BorderFactory.createLineBorder(Color.white,1));
		jp2.setBackground(Color.decode("#200000")); //decode("#F9B7FF")
		/***********************************Labels*********************************/
		llbno=new JLabel("Lab No : ");
		lstudid=new JLabel("Student ID : ");
		lday=new JLabel("Day ");
		ltim=new JLabel("Timing : ");
		lbatchcd=new JLabel("Batch Code : ");
		lstaffcd=new JLabel("Staff Code : ");

		/******************************TextField*************************************/
		tlbno=new JTextField(20);
		tstudid=new JTextField(20);
			
		/**********************************Buttons***********************************/
		bsearch=new JButton("SEARCH");					
		bcls=new JButton("CLOSE");	
		breset=new JButton("RESET");	

		cb1=new JComboBox();
		cb1.addItem("");
		cb1.addItem("Monday");
		cb1.addItem("Tuesday");	
		cb1.addItem("Wednsday");
		cb1.addItem("Thursday");
		cb1.addItem("Friday");
		cb1.addItem("Saturday");	
					
		cb2=new JComboBox();
		cb2.addItem("");
		cb2.addItem("8:00AM-9:00AM");
		cb2.addItem("9:00AM-10:00AM");	
		cb2.addItem("10:00AM-11:00AM");
		cb2.addItem("11:00AM-12:00PM");
		cb2.addItem("12:00PM-1:00PM");
		cb2.addItem("1:00PM-2:00PM");
		cb2.addItem("2:00PM-3:00PM");
		cb2.addItem("3:00PM-4:00PM");
		cb2.addItem("4:00PM-5:00PM");
		cb2.addItem("5:00PM-6:00PM");
		cb2.setEditable(true);

		cb4=new JComboBox();
		cb4.addItem("");
		cb4.addItem("A1");
		cb4.addItem("A2");	
		cb4.addItem("B1");
		cb4.addItem("B2");

		cb5=new JComboBox();
		cb5.addItem("");
		cb5.addItem("T1");
		cb5.addItem("T2");	
		cb5.addItem("T3");
		cb5.addItem("T4");
		/****************************************************************************/
		cp.add(lstudid);
		lstudid.setBounds(25,20,80,30);
		lstudid.setFont(f1);
		lstudid.setForeground(Color.decode("#FFFFFF"));
		cp.add(tstudid);
		tstudid.setBounds(135,25,100,22);
		tstudid.setFont(f2);
		tstudid.setForeground(Color.black);
		tstudid.setBorder(BorderFactory.createLineBorder(Color.black,1));
		
		cp.add(llbno);
		llbno.setBounds(25,60,60,30);
		llbno.setFont(f1);
		llbno.setForeground(Color.decode("#FFFFFF"));
		cp.add(tlbno);
		tlbno.setBounds(135,65,100,22);
		tlbno.setFont(f2);
		tlbno.setForeground(Color.black);
		tlbno.setBorder(BorderFactory.createLineBorder(Color.black,1));
		
		cp.add(lday);
		lday.setBounds(25,100,60,30);
		lday.setFont(f1);
		lday.setForeground(Color.decode("#FFFFFF"));
		cp.add(cb1);
		cb1.setBounds(135,105,160,25);
		cb1.setFont(f2);
		cb1.setForeground(Color.black);
		cb1.setBorder(BorderFactory.createLineBorder(Color.black,1));

		cp.add(ltim);
		ltim.setBounds(25,140,150,30);
		ltim.setFont(f1);
		ltim.setForeground(Color.decode("#FFFFFF"));
		cp.add(cb2);
		cb2.setBounds(135,145,160,22);
		cb2.setFont(f2);
		cb2.setForeground(Color.black);
		cb2.setBorder(BorderFactory.createLineBorder(Color.black,1));

		cp.add(lbatchcd);
		lbatchcd.setBounds(25,180,100,30);
		lbatchcd.setFont(f1);
		lbatchcd.setForeground(Color.decode("#FFFFFF"));
		cp.add(cb4);
		cb4.setBounds(135,185,160,22);
		cb4.setFont(f2);
		cb4.setForeground(Color.black);
		cb4.setBorder(BorderFactory.createLineBorder(Color.black,1));
		
		cp.add(lstaffcd);
		lstaffcd.setBounds(25,220,100,30);
		lstaffcd.setFont(f1);
		lstaffcd.setForeground(Color.decode("#FFFFFF"));
		cp.add(cb5);
		cb5.setBounds(135,225,160,22);
		cb5.setFont(f2);
		cb5.setForeground(Color.black);
		cb5.setBorder(BorderFactory.createLineBorder(Color.black,1));
		cp.add(jp1);
	
		
		cp.add(bsearch);
		bsearch.setBounds(100,280,80,25);
		bsearch.setFont(f1);
		bsearch.setBorder(BorderFactory.createLineBorder(Color.white,1));
		bsearch.setBackground(Color.black);
		bsearch.setForeground(Color.white);

		cp.add(breset);	
		breset.setBounds(225,280,80,25);
		breset.setFont(f1);
		breset.setBorder(BorderFactory.createLineBorder(Color.white,1));
		breset.setBackground(Color.black);
		breset.setForeground(Color.red);

		cp.add(bcls);		
		bcls.setBounds(350,280,80,25);
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

		setBounds(245,125,(dim.width-300),(dim.height-115));  //200,80,800,590
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setIconifiable(true);
		setClosable(true);	
		setVisible(true);
		setSize(540,360);
		cp.setBackground(Color.black);//decode("#350000")
		setTitle("Search for Time Table");
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
				ResultSet rs=st.executeQuery("select * from timetable where Student_ID="+Integer.parseInt(s));  //+Integer.parseInt(s)
				if(rs.next())
				{
					
					tstudid.setText(""+rs.getString(1));
					tlbno.setText(""+rs.getString(2));
					cb1.setSelectedItem(rs.getString(3));
					cb2.setSelectedItem(rs.getString(4));
					cb4.setSelectedItem(rs.getString(5));
					cb5.setSelectedItem(rs.getString(6));
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
			tlbno.setText("");  
			cb1.setSelectedIndex(0);
			cb2.setSelectedIndex(0);
			cb4.setSelectedIndex(0);
			cb5.setSelectedIndex(0);
			tstudid.requestFocus();
		}
	}
		
	public static void main(String args[])
	{
		TimeTableSearch tts=new TimeTableSearch();
	}
}



















