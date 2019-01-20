import java.awt.*;
import java.io.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;
public class  ResultReport  extends JInternalFrame implements ActionListener 
{
	
	JScrollPane sp;
	JLabel lblnm,lsearch;
	JTextField tsearch;
	JTable table,table1,table2;
	Connection con;
	Dimension dim;
	Container cp=getContentPane();
	JButton print,show,search,close;

	Font f1=new Font("Cambria",Font.BOLD,14);
	Font f2=new Font("Cambria",Font.BOLD,14);
	ResultReport()
	{
		setLayout(null);
		cp.setBackground(Color.decode("#200000"));
		dim=new Dimension();
		dim=Toolkit.getDefaultToolkit().getScreenSize();

		JPanel jp1=new JPanel();
		jp1.setBorder(BorderFactory.createLineBorder(Color.white));
		jp1.setBackground(Color.black);
		jp1.setBounds(20,50,840,435);

		lsearch=new JLabel("Search By ID:");
		lsearch.setForeground(Color.white);
		add(lsearch);
		lsearch.setBounds(100,95,200,30);
		lsearch.setFont(f1);
		tsearch=new JTextField(20);
		tsearch.setFont(f2);
		tsearch.setForeground(Color.black);
		tsearch.setBorder(BorderFactory.createLineBorder(Color.black,1));
		add(tsearch);
		tsearch.setBounds(200,100,100,22);

		print=new JButton("PRINT");
		print.setVisible(true);
		print.setFont(f1);
		print.setBorder(BorderFactory.createLineBorder(Color.white,1));
		print.setForeground(Color.white);
		print.setBackground(Color.decode("#200000"));
		add(print);
		print.setBounds(650,95,80,30);

		show=new JButton("SHOW ALL");
		show.setVisible(true);
		show.setFont(f1);
		show.setBorder(BorderFactory.createLineBorder(Color.white,1));
		show.setForeground(Color.white);
		show.setBackground(Color.decode("#200000"));
		add(show);
		show.setBounds(550,95,80,30);

		search=new JButton("SEARCH");
		search.setVisible(true);
		search.setFont(f1);
		search.setBorder(BorderFactory.createLineBorder(Color.white,1));
		search.setForeground(Color.white);
		search.setBackground(Color.decode("#200000"));
		add(search);
		search.setBounds(350,95,80,30);

		close=new JButton("CLOSE");
		close.setVisible(true);
		close.setFont(f1);
		close.setBorder(BorderFactory.createLineBorder(Color.white,1));
		close.setForeground(Color.white);
		close.setBackground(Color.decode("#200000"));
		add(close);
		close.setBounds(750,95,80,30);

		cp.add(jp1);

		setVisible(true);
		print.addActionListener(this);
		show.addActionListener(this);
		search.addActionListener(this);
		close.addActionListener(this);

		setBounds(255,100,(dim.width-300),(dim.height-115));  
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		setIconifiable(true);
		setClosable(true);	
		setSize(885,540);
		setTitle("Admission Details Report");
	}
	
	public void actionPerformed(ActionEvent e)
	{
		/********************************Code For Close the Window***********************************/
		if(e.getSource()==close)
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
		if(e.getSource()==print)
		{
			JFileChooser jfc11=new JFileChooser();
			int op=jfc11.showSaveDialog(null);
			if(op==JFileChooser.APPROVE_OPTION)
			{
				File f=jfc11.getSelectedFile();
				try
				{
				String s="Computer Institute Management System\n"+"\t"+"\t"+"\t"+"\t"+"\t"+"Admission Details Report\n\n";
				s="\n"+"\t"+"\t"+"\t"+"\t"+s+"\n"+"Student_ID"+" "+"Student_Name"+" "+"Course"+" "+"Seat_No"+" "+"Date"+" "+"Time"+" "+"Center"+" "+"Marks"+" "+"Grade"+" "+"Result"+"\n";
				for(int i=0;i<table.getRowCount();i++)
				{	
					for(int j=0;j<table.getColumnCount();j++)
					{
						s=s+(String)table.getValueAt(i,j);
						s=s+" ";
					}
					s=s+"\n";
				}
				FileOutputStream fis=new FileOutputStream(f);
				byte b[]=s.getBytes();
				fis.write(b);
				fis.close();
				JOptionPane.showMessageDialog(this," Save Successfully");
				}
				catch(Exception es)
				{
					JOptionPane.showMessageDialog(this,es);
				}
			}
		}

		if(e.getSource()==show)
		{
			try
			{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				con=DriverManager.getConnection("jdbc:odbc:CompDSN");
				Statement st=con.createStatement();	
				ResultSet rs=st.executeQuery("select Student_ID,Student_Name,Course_Name,Seat_No,Date_of_Exam,Exam_Time,Exam_Center,Marks,Grade,Result from result");
				ResultSetMetaData rsmd=rs.getMetaData();
				Vector cols=new Vector();
				for(int i=1;i<=rsmd.getColumnCount();i++)
				{
					cols.add(rsmd.getColumnName(i));
				}
				Vector data=new Vector();
				while(rs.next())
				{
					Vector rows=new Vector();
					for(int j=1;j<=rsmd.getColumnCount();j++)
					{
						rows.add(rs.getString(j));						
					}
					data.add(rows);	
				}
				table=new JTable(data,cols);
				table.setBackground(Color.white);
				table.setGridColor(Color.black);
				table.setVisible(true);
				table.setSelectionBackground(Color.decode("#200000"));
				table.setSelectionForeground(Color.white);
				table.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
				table.sizeColumnsToFit(true);
				int v=ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
				int h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS;
				sp=new JScrollPane(table,v,h);	
				sp.setVisible(true);
				add(sp);
				sp.setBounds(40,150,800,300);
				table.setForeground(Color.white);  
				table.setBackground(Color.decode("#200000"));
				
				
			}			
			catch(Exception ee)
			{
				System.out.println(ee);
			}
		}
		if(e.getSource()==search)
		{
			String query="";
				
			try
			{
				int i;
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection con=DriverManager.getConnection("jdbc:odbc:CompDSN");
				Statement st=con.createStatement();
				ResultSet rs=st.executeQuery("select Student_ID,Student_Name,Course_Name,Seat_No,Date_of_Exam,Exam_Time,Exam_Center,Marks,Grade,Result from result where Student_ID="+tsearch.getText());
				ResultSetMetaData rsmd=rs.getMetaData();
				Vector column=new Vector();
				for(i=1;i<=rsmd.getColumnCount();i++)
				{
					column.add(rsmd.getColumnName(i));
				}
				Vector data=new Vector();	
				while(rs.next())
				{
					Vector row=new Vector();
					for(i=1;i<=rsmd.getColumnCount();i++)
					{
						row.add(rs.getString(i));
					}
					data.add(row);
				}
		
				table=new JTable(data,column);
				int v=ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
				int h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS;
				JScrollPane sp2=new JScrollPane(table,v,h);	
				sp2.setVisible(true);
				add(sp2);
				 sp2.setBounds(40,150,800,300);
				table.setForeground(Color.white);
				table.setBackground(Color.decode("#200000"));
			}	
			catch(Exception ex)
			{
				System.out.println(ex);
			}
		}

	}
	public static void main(String args[])
	{
		new  ResultReport();
	}
}