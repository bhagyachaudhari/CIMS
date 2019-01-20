// Program For Changing Password.

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.sql.*;
import java.util.*;
import java.util.EventListener.*;
import java.text.*;

public class ChangePassword extends JInternalFrame implements ActionListener 
{

	//private JPanel pChange = new JPanel();
	private JLabel lbUser, lbPass, lbNew;
	public JTextField txtUser;
	public JPasswordField txtPass, txtNew;
	private JButton btnOk, btnCancel;

	Container cp;
		
	//public String userName;			
	//String user;
		

	ChangePassword () 
	{

		Dimension dim=Toolkit.getDefaultToolkit().getScreenSize();
		cp=getContentPane();
		cp.setLayout(null);

		setLocation(dim.width/2-getWidth()/2,dim.height/2-getHeight()/2);

		lbUser = new JLabel ("Username:");
		lbUser.setForeground (Color.black);
		lbUser.setBounds (20, 20, 115, 25);
	        	lbPass = new JLabel ("Old Password:");
		lbPass.setForeground (Color.black);
        		lbPass.setBounds (20, 55, 115, 25);
	        	lbNew = new JLabel ("New Password:");
		lbNew.setForeground (Color.black);
	        	lbNew.setBounds (20, 90, 115, 25);

		txtUser = new JTextField ();
		txtUser.setBounds (120, 20, 150, 25);
		txtPass = new JPasswordField ();
		txtPass.setBounds (120, 55, 150, 25);
		txtNew = new JPasswordField ();
		txtNew.setBounds (120, 90, 150, 25);

		btnOk = new JButton ("OK");
		btnOk.setBounds (20, 130, 100, 25);
		btnOk.addActionListener (this);
		btnCancel = new JButton ("Cancel");
		btnCancel.setBounds (165, 130, 100, 25);
		btnCancel.addActionListener (this);


		cp.add (lbUser);
		cp.add (lbPass);
		cp.add (lbNew);
		cp.add (txtUser);
		cp.add (txtPass);
		cp.add (txtNew);
		cp.add (btnOk);
		cp.add (btnCancel);
		
		setBounds(450,250,(dim.width-300),(dim.height-115));  //200,80,800,590
		setVisible(true);
		setSize (310,205);
		setTitle("Change Password");
	}

	public void actionPerformed (ActionEvent ae) 
	{

		Object obj = ae.getSource();

		if (obj == btnOk) 
		{		//If OK Button Pressed.
		
			String password = new String (txtPass.getPassword());
			String newpass = new String (txtNew.getPassword());
			String unm =  txtUser.getText();

			if (txtUser.getText().equals ("")) 
			{
				txtUser.requestFocus();
				JOptionPane.showMessageDialog (this, "Username not Provided.");
			}
			else if (password.equals ("")) 
			{
				txtPass.requestFocus();
				JOptionPane.showMessageDialog (this, "Password not Provided.");
			}
			else if (newpass.equals ("")) 
			{
				txtNew.requestFocus();
				JOptionPane.showMessageDialog (this, "Password not Provided.");
			}
			else 
			{
				try
				{
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					System.out.println("Driver loaded!!");

					Connection con=DriverManager.getConnection("jdbc:odbc:CompDSN");
					System.out.println("Connection established!");

					Statement st=con.createStatement();
					
					//String q = "INSERT INTO login(Username, Password) " + "VALUES ('" + txtUser.getText() + "', '"+ password + "')";
	
	
					String q = "UPDATE login SET Password = '" + newpass + "' WHERE Username = '" + unm + "'";


					int result = st.executeUpdate (q);	//Running Query.
					if (result == 1) 
					{			//If Query Successful.
						JOptionPane.showMessageDialog (this, "Password Changed Successfully!");
						txtUser.setText ("");
						txtPass.setText ("");
						txtNew.setText ("");
						txtUser.requestFocus ();
					}
					else 
					{					//If Query Failed.
						JOptionPane.showMessageDialog (this, "Problem while Changing Password.");
						txtUser.setText ("");
						txtPass.setText ("");
						txtNew.setText ("");
						txtUser.requestFocus ();
					}
				}
				catch (SQLException sqlex) 
				{ 
					JOptionPane.showMessageDialog (this, "Problem while Changing Password."); 
					txtUser.setText ("");
					txtPass.setText ("");
					txtNew.setText ("");
					txtUser.requestFocus ();
				}
				catch (ClassNotFoundException cnfe) 
				{ 
					
				}
				
			}

		}		

		if (obj == btnCancel) 
		{		
			setVisible (false);
			dispose();

		}

	}
	public static void main(String args[])
	{
		new ChangePassword();
	}
}
















