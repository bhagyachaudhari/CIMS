
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import java.text.*;

public class BatchDetails extends JInternalFrame implements ActionListener
{
	Container cp;
	JLabel lbatchno,lbatchcd,lbatchcap,lbatchstrngth;
	JTextField tbatchno,tbatchcap,tbatchstrngth;
	JButton bsv,bcls,breset,bdel,bupd;
	JComboBox cb1;
	JPanel jp1,jp2;
	Connection con;
	Dimension dim;

	Font f1=new Font("Cambria",Font.BOLD,14);
	Font f2=new Font("Cambria",Font.BOLD,14);

	BatchDetails()
	{
		cp=getContentPane();
		cp.setLayout(null);
		dim=new Dimension();
		dim=Toolkit.getDefaultToolkit().getScreenSize();

		jp1=new JPanel();
		jp1.setBounds(10,10,510,150);
		jp1.setBorder(BorderFactory.createLineBorder(Color.white,1));
		jp1.setBackground(Color.decode("#200000"));
	
		jp2=new JPanel();
		jp2.setBounds(10,170,510,45);
		jp2.setBorder(BorderFactory.createLineBorder(Color.white,1));
		jp2.setBackground(Color.decode("#200000")); 
	

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
		breset=new JButton("RESET");
		bupd=new JButton("UPDATE");		
		bsv=new JButton("SAVE");					
		bcls=new JButton("CLOSE");	
		bdel=new JButton("DELETE");	
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

	
		cp.add(bupd);
		bupd.setBounds(25,180,80,25);
		bupd.setFont(f1);
		bupd.setBorder(BorderFactory.createLineBorder(Color.white,1));
		bupd.setBackground(Color.black);
		bupd.setForeground(Color.red);

		cp.add(bsv);
		bsv.setBounds(125,180,80,25);
		bsv.setFont(f1);
		bsv.setBorder(BorderFactory.createLineBorder(Color.white,1));
		bsv.setBackground(Color.black);
		bsv.setForeground(Color.red);

		cp.add(breset);	
		breset.setBounds(225,180,80,25);
		breset.setFont(f1);
		breset.setBorder(BorderFactory.createLineBorder(Color.white,1));
		breset.setBackground(Color.black);
		breset.setForeground(Color.red);

		cp.add(bdel);	
		bdel.setBounds(325,180,80,25);
		bdel.setFont(f1);
		bdel.setBorder(BorderFactory.createLineBorder(Color.white,1));
		bdel.setBackground(Color.black);
		bdel.setForeground(Color.red);

		cp.add(bcls);		
		bcls.setBounds(425,180,80,25);
		bcls.setFont(f1);
		bcls.setBorder(BorderFactory.createLineBorder(Color.white,1));
		bcls.setBackground(Color.black);
		bcls.setForeground(Color.red);

		cp.add(jp2);

		bsv.addActionListener(this);
		bcls.addActionListener(this);
		breset.addActionListener(this);	
		bupd.addActionListener(this);	
		bdel.addActionListener(this);
		
		bupd.setToolTipText("Update the Records");
		bsv.setToolTipText("Save the Records");
		bcls.setToolTipText("Close form");
		breset.setToolTipText("Clear");
		bdel.setToolTipText("Delete the Records");
		


		setBounds(245,145,(dim.width-300),(dim.height-115));  
		cp.setBackground(Color.black);
		setVisible(true);
		setSize(540,260);
		setResizable(false);
		setIconifiable(true);
		setClosable(true);	
		setTitle("Batch Details");

		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			System.out.println("Driver Loaded!");
		
			con=DriverManager.getConnection("jdbc:odbc:CompDSN");
			System.out.println("Connection Established!");
	
			Statement st=con.createStatement();
                                   	ResultSet rs=st.executeQuery("select * from batch");
                                  	while(rs.next())
                                 	{
                                   		int no=rs.getInt(1);
                                   		no++;
                                   		tbatchno.setText(""+no);	
                             	  	 }
		}
		catch(Exception e) {}

	}
	public void actionPerformed(ActionEvent ae)
	{
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			System.out.println("Driver Loaded!");
			
			con=DriverManager.getConnection("jdbc:odbc:CompDSN");
			System.out.println("Connection Established!");
		}
		catch(Exception e) {}
		
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
			
			try
			{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				System.out.println("Driver Loaded!");
		
				con=DriverManager.getConnection("jdbc:odbc:CompDSN");
				System.out.println("Connection Established!");
	
				Statement st=con.createStatement();
                                   		ResultSet rs=st.executeQuery("select * from batch");
                                  		while(rs.next())
                                 		{
                                   			int no=rs.getInt(1);
                                   			no++;
                                   			tbatchno.setText(""+no);
                                 		}
			}
			catch(Exception e) {}	
		}
		


		/**********************************Code for Saving the Application*********************************/
		
		if(ae.getSource()==bsv)
		{
			try
			{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				System.out.println("Driver Loaded!");
			
				con=DriverManager.getConnection("jdbc:odbc:CompDSN");
				System.out.println("Connection Established!");
			}
			catch(Exception e) {}
			if(tbatchno.getText().equals(""))  
			{
				JOptionPane.showMessageDialog(this,"Please Enter Batch No","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(cb1.getSelectedIndex()==0)
			{
				JOptionPane.showMessageDialog(this,"Please Select Batch Code","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}
		
			if(tbatchcap.getText().equals(""))  
			{
				JOptionPane.showMessageDialog(this,"Please Enter Batch Capacity","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(tbatchstrngth.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this,"Please Enter Batch Strength","Error",JOptionPane.ERROR_MESSAGE);
				return;
			}
			try
			{
				PreparedStatement st=con.prepareStatement("insert into batch values(?,?,?,?)");
				st.setString(1,tbatchno.getText()); 
				st.setString(2,(String)cb1.getSelectedItem());
				st.setString(3,tbatchcap.getText());
				st.setString(4,tbatchstrngth.getText());   
				
				st.executeUpdate();
				JOptionPane.showMessageDialog(null,"Batch Details Saved Successfully!");
			}
			catch(Exception e) {}
		}
		
		
		/***********************************Code for Update the Application***************************/
		
		if(ae.getSource()==bupd)
		{
				try
				{		
					PreparedStatement st=con.prepareStatement("UPDATE batch set Batch_Code=?,Batch_Capacity=?,Batch_Strength=?"+" WHERE Batch_No=?");
					
					st.setString(1,(String)cb1.getSelectedItem()); 
					st.setString(2,tbatchcap.getText());
					st.setString(3,tbatchstrngth.getText()); 
					st.setString(4,tbatchno.getText());   
					st.executeUpdate();
					//System.out.println(s);
					JOptionPane.showMessageDialog(null,"Updated!");
				}
				catch(Exception e) 
				{
					System.out.println("error");
				}	
			}
		
		
			
		/**************************************Delete the Application********************************************/
		
		if(ae.getSource()==bdel)
		{
			int res=JOptionPane.showConfirmDialog((Component)null,"Are you sure to delete the Batch Details of Batch No"+Integer.parseInt(tbatchno.getText()),"Delete",JOptionPane.YES_NO_OPTION);
			
			if(res==JOptionPane.YES_OPTION)
			{
				try
				{
			
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					System.out.println("Driver Loaded!");
			
					con=DriverManager.getConnection("jdbc:odbc:CompDSN");
					System.out.println("Connection Established!");

					PreparedStatement st=con.prepareStatement("delete from batch where Batch_No= "+Integer.parseInt(tbatchno.getText()));
					st.executeUpdate();
					JOptionPane.showMessageDialog(this,"Deleted the Record at Batch No "+(tbatchno.getText())+" Successfully!");
				}
				catch(Exception e) {}
			}
			else if(res==JOptionPane.NO_OPTION)
			{
			}	 
		}

	}
	
	public static void main(String args[])
	{
		BatchDetails bd=new BatchDetails();
	}
}







