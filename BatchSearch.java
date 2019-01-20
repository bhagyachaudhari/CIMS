
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import java.text.*;

public class BatchSearch extends JInternalFrame implements ActionListener
{
	Container cp;
	JLabel lbatchno,lbatchcd,lbatchcap,lbatchstrngth;
	JTextField tbatchno,tbatchcap,tbatchstrngth;
	JButton bsearch,bcls,breset;
	JComboBox cb1;
	JPanel jp1,jp2;
	Connection con;
	Dimension dim;

	Font f1=new Font("Cambria",Font.BOLD,14);
	Font f2=new Font("Cambria",Font.BOLD,14);


	BatchSearch()
	{
		cp=getContentPane();
		cp.setLayout(null);
		dim=new Dimension();
		dim=Toolkit.getDefaultToolkit().getScreenSize();


		jp1=new JPanel();
		jp1.setBounds(10,10,510,150);
		//jp1.setBorder(BorderFactory.createTitledBorder("Personal Details"));
		jp1.setBorder(BorderFactory.createLineBorder(Color.white,1));
		jp1.setBackground(Color.decode("#200000")); //decode("#F9B7FF")
	
		jp2=new JPanel();
		jp2.setBounds(10,170,510,45);
		//jp2.setBorder(BorderFactory.createTitledBorder("Personal Details"));
		jp2.setBorder(BorderFactory.createLineBorder(Color.white,1));
		jp2.setBackground(Color.decode("#200000")); //decode("#F9B7FF")

		/***********************************Labels*********************************/
		lbatchcd=new JLabel("Batch Code: ");
		lbatchno=new JLabel("Batch No: ");
		lbatchcap=new JLabel("Batch Capacity : ");
		lbatchstrngth=new JLabel("Batch Strength : ");

		/******************************TextField*************************************/
		tbatchcap=new JTextField(20);
		tbatchno=new JTextField(20);
		tbatchstrngth=new JTextField(20);
			
		/**********************************Buttons***********************************/
		bsearch=new JButton("SEARCH");					
		bcls=new JButton("CLOSE");	
		breset=new JButton("RESET");	
			
		/****************************************************************************/
		cb1=new JComboBox();
		cb1.addItem("");
		cb1.addItem("A1");
		cb1.addItem("A2");	
		cb1.addItem("B1");
		cb1.addItem("B2");

		cp.add(lbatchno);
		lbatchno.setBounds(25,20,100,30);
		lbatchno.setFont(f1);
		lbatchno.setForeground(Color.decode("#FFFFFF"));
		cp.add(tbatchno);
		tbatchno.setBounds(135,25,100,22);
		tbatchno.setFont(f2);
		tbatchno.setForeground(Color.black);
		tbatchno.setBorder(BorderFactory.createLineBorder(Color.black,1));

		cp.add(lbatchcd);
		lbatchcd.setBounds(25,50,100,30);
		lbatchcd.setFont(f1);
		lbatchcd.setForeground(Color.decode("#FFFFFF"));
		cp.add(cb1);
		cb1.setBounds(135,55,100,22);
		cb1.setFont(f2);
		cb1.setForeground(Color.black);
		cb1.setBorder(BorderFactory.createLineBorder(Color.black,1));
		
		cp.add(lbatchcap);
		lbatchcap.setBounds(25,80,110,30);
		lbatchcap.setFont(f1);
		lbatchcap.setForeground(Color.decode("#FFFFFF"));
		cp.add(tbatchcap);
		tbatchcap.setBounds(135,85,160,22);
		tbatchcap.setFont(f2);
		tbatchcap.setForeground(Color.black);
		tbatchcap.setBorder(BorderFactory.createLineBorder(Color.black,1));

		cp.add(lbatchstrngth);
		lbatchstrngth.setBounds(25,110,150,30);
		lbatchstrngth.setFont(f1);
		lbatchstrngth.setForeground(Color.decode("#FFFFFF"));
		cp.add(tbatchstrngth);
		tbatchstrngth.setBounds(135,115,160,22);
		tbatchstrngth.setFont(f2);
		tbatchstrngth.setForeground(Color.black);
		tbatchstrngth.setBorder(BorderFactory.createLineBorder(Color.black,1));
		cp.add(jp1);


	
		cp.add(bsearch);
		bsearch.setBounds(100,180,80,25);
		bsearch.setFont(f1);
		bsearch.setBorder(BorderFactory.createLineBorder(Color.white,1));
		bsearch.setBackground(Color.black);
		bsearch.setForeground(Color.white);

		cp.add(breset);	
		breset.setBounds(225,180,80,25);
		breset.setFont(f1);
		breset.setBorder(BorderFactory.createLineBorder(Color.white,1));
		breset.setBackground(Color.black);
		breset.setForeground(Color.red);

		cp.add(bcls);		
		bcls.setBounds(350,180,80,25);
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
		
		setBounds(245,145,(dim.width-300),(dim.height-115));  //200,80,800,590
		cp.setBackground(Color.black);//decode("#350000")
		setVisible(true);
		setSize(540,260);
		setResizable(false);
		setIconifiable(true);
		setClosable(true);	
		setTitle("Search for Batch Details");
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
				String s=JOptionPane.showInputDialog(this,"Please enter Batch No");
				ResultSet rs=st.executeQuery("select * from batch where Batch_No="+Integer.parseInt(s));  //+Integer.parseInt(no)
				if(rs.next())
				{
					
					tbatchno.setText(""+rs.getString(1));
					cb1.setSelectedItem(rs.getString(2));
					tbatchcap.setText(""+rs.getString(3)); 
					tbatchstrngth.setText(""+rs.getString(4));
					
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
			tbatchno.setText("");
			cb1.setSelectedIndex(0);
			tbatchcap.setText("");
			tbatchstrngth.setText("");  	
		}
		
	}
	public static void main(String args[])
	{
		BatchSearch bs=new BatchSearch();
	}
}



















