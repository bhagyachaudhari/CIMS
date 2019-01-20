

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener
{
	Dimension dim=Toolkit.getDefaultToolkit().getScreenSize();
	JPanel jp1;

	JLabel lbUser,lbPass,l;
	JTextField txtUser;
	JPasswordField txtPass;
	JButton btnOk,btnCancel;
	Container cp;
	boolean verify;
	
	Font f=new Font("Comic Sans MS",Font.BOLD,20);

	Font f1=new Font("Cambria",Font.BOLD,16);
	Font f2=new Font("Cambria",Font.BOLD,16);
	
	public Login() 
	{
		
		super("The Computer Institute Management System..");
		cp=getContentPane();
		cp.setLayout(null);
		
	
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent we)
			{
				setVisible(false);
				dispose();
				System.exit(0);
			}
			
		});
		
		setLocation(dim.width/2-getWidth()/2,dim.height/2-getHeight()/2);

		jp1=new JPanel();
		jp1.setBounds(15,60,400,180);
		jp1.setBorder(BorderFactory.createTitledBorder("Sign In"));
		jp1.setBorder(BorderFactory.createLineBorder(Color.white,1));	
		jp1.setBackground(Color.decode("#200000")); //decode("#F9B7FF")  

		/***************************************Label*************************************/
		l=new JLabel("* Please Login Your Account *");
		l.setForeground(Color.decode("#FFFFFF"));
		l.setFont(f);
		l.setBounds(69,10,350,50);

		lbUser=new JLabel("Username: ");
		lbUser.setFont(f1);
		lbUser.setForeground(Color.decode("#FFFFFF"));
		lbUser.setBounds(58,80,85,30);
		

		lbPass=new JLabel("Password: ");
		lbPass.setFont(f1);
		lbPass.setForeground(Color.decode("#FFFFFF"));
		lbPass.setBounds(58,120,80,30);
		/***************************************TextField*********************************/
		txtUser=new JTextField(10);
		txtUser.setBounds(180,85,170,25);
		txtUser.setFont(f2);
		txtUser.setForeground(Color.decode("#000000"));
		txtUser.setBorder(BorderFactory.createLineBorder(Color.black,1));

		txtPass=new JPasswordField(10);
		txtPass.setBounds(180,125,170,25);
		txtPass.setFont(f2);
		txtPass.setForeground(Color.decode("#000000"));
		txtPass.setBorder(BorderFactory.createLineBorder(Color.black,1));

		/********************************************Button********************************/
		btnOk=new JButton("OK");
		btnOk.setFont(f1);
		btnOk.setBorder(BorderFactory.createLineBorder(Color.white,1));
		btnOk.setForeground(Color.white);
		btnOk.setBackground(Color.black);
		btnOk.setBounds(58,180,110,25);
		btnOk.addActionListener(this);

		btnCancel=new JButton("Cancel");
		btnCancel.setFont(f1);
		btnCancel.setBorder(BorderFactory.createLineBorder(Color.white,1));
		btnCancel.setForeground(Color.white);
		btnCancel.setBackground(Color.black);
		btnCancel.setBounds(242,180,110,25);
		btnCancel.addActionListener(this);

		cp.add(l);
		cp.add(lbUser);
		cp.add(lbPass);
		cp.add(txtUser);
		cp.add(txtPass);
		cp.add(btnOk);
		cp.add(btnCancel);
		
		cp.add(jp1);

		
		setBounds(450,250,(dim.width-300),(dim.height-115));  //200,80,800,590
		setVisible(true);
		cp.setBackground(Color.black);//decode("#C0C0C0")
		setSize(440,290);
		setResizable(false);
	}
	public void actionPerformed(ActionEvent ae)
	{
		
		if(ae.getSource()==btnOk)
		{
			
			if(txtUser.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this,"Please Enter the Username to Login.");
				txtUser.requestFocus();
			}
			if(txtPass.getText().equals(""))
			{
				JOptionPane.showMessageDialog(null,"Please Enter the Password to Login.");
				txtPass.requestFocus();
			}
			try
			{
				
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				System.out.println("Driver loaded!!");

				Connection con=DriverManager.getConnection("jdbc:odbc:CompDSN");
				//Driver={Microsoft Access Driver(*.mdb)};DBQ=mydatabase1.mdb;DriverID=23}
				System.out.println("Connection established!");
	
				Statement st=con.createStatement();
				ResultSet rs=st.executeQuery("SELECT * from login");
				
				rs.next();
					String s1=rs.getString(1);  //retrives username & password frm  DB table
					String s2=rs.getString(2);

					int pass=s2.length();  //get password frm DB table

					String user=txtUser.getText(); // entered name of user from textfield
					char ch[];
					ch=txtPass.getPassword();  // entered password frm textfield
					int passlen=ch.length;          //total characters in passwords
	
					if(user.equals(s1)&&passlen==pass)
					{
						for(int i=0;i<passlen;i++)
						{
						       if(ch[i]==s2.charAt(i))
						      {
					                                 if(i==passlen-1)
						              {
							JOptionPane.showMessageDialog(this,"Login Successfully!");
							new MainForm();
							setVisible(false);
						              }
						             else
					                                {
							continue;
						              }
						      }
						     if(ch[i]!=s2.charAt(i))
						     {
							JOptionPane.showMessageDialog(this,"Invalid Username and Password!");
							break;
						     }
					                 }
						
					}             
				
					else
					{
						JOptionPane.showMessageDialog(this,"Invalid Username and Password!");
					}
				}
				catch(Exception E)
				{
					JOptionPane.showMessageDialog(this,E);
				}
						
		}
		
		
		if(ae.getSource()==btnCancel)
		{
			int res=JOptionPane.showConfirmDialog((Component)null,"Are you sure to cancel","Cancel",JOptionPane.YES_NO_OPTION);
			if(res==JOptionPane.YES_OPTION)
			{
				setVisible(false);
				dispose();
			}
			else if(res==JOptionPane.NO_OPTION)
			{
			}
		}
	}

	public static void main(String args[])
	{
		new Login();
	}
}


























	
		

