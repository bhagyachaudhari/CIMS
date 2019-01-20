// Progrm To Create New User.

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;
import java.text.*;

public class NewUser extends JInternalFrame implements ActionListener 
{

	//private JPanel pNew = new JPanel();
	JLabel lbUser, lbnew;
	JTextField txtUser, txtNew;
	//JPasswordField txtPass;
	JButton btnOk, btnCancel;
			
	Container cp;
	

	NewUser () 
	{
		Dimension dim=Toolkit.getDefaultToolkit().getScreenSize();
		cp=getContentPane();
		cp.setLayout(null);
		//Setting the Form's Labels.

		setLocation(dim.width/2-getWidth()/2,dim.height/2-getHeight()/2);

		lbUser = new JLabel ("Old Username:");
		lbUser.setForeground (Color.black);
		lbUser.setBounds (20, 20, 100, 25);
		lbnew = new JLabel ("New Username:");
		lbnew.setForeground (Color.black);
	    	lbnew.setBounds (20, 55, 100, 25);

		//Setting the Form's TextField & PasswordField.

		txtUser = new JTextField ();
		txtUser.setBounds (120, 20, 150, 25);
		txtNew = new JTextField ();
		txtNew.setBounds (120, 55, 150, 25);

		//Setting the Form's Buttons.

		btnOk = new JButton ("OK");
		btnOk.setBounds (20, 100, 100, 25);
		btnOk.addActionListener (this);

		btnCancel = new JButton ("Cancel");
		btnCancel.setBounds (150, 100, 100, 25);
		btnCancel.addActionListener (this);


		cp.add (lbUser);
		cp.add (lbnew);
		cp.add (txtUser);
		cp.add (txtNew);
		cp.add (btnOk);
		cp.add (btnCancel);
		
		
		//cp.setBackground(Color.black);//decode("#C0C0C0")
		//setResizable(false);
		
		setBounds(450,250,(dim.width-300),(dim.height-115));  //200,80,800,590
		setVisible(true);
		setSize (300,175);
		setTitle("New User Login Form");

	}

	public void actionPerformed (ActionEvent ae) 
	{

		Object obj = ae.getSource();

		if (obj == btnOk) 
		{		//If OK Button Pressed.
		
			//String password = new String (txtPass.getPassword());
			String ou= txtUser.getText();
			String nu= txtNew.getText();

			if (txtUser.getText().equals ("")) 
			{
				txtUser.requestFocus();
				JOptionPane.showMessageDialog (this, "Plz Enter Old Username");
			}
			else if (txtNew.equals ("")) 
			{
				txtNew.requestFocus();
				JOptionPane.showMessageDialog (this, "Plz Enter New Username");
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
					

					String q = "UPDATE login SET Username = '" + nu + "' WHERE Username = '" + ou + "'";

					int result = st.executeUpdate (q);	//Running Query.
					if (result == 1) 
					{			//If Query Successful.
						JOptionPane.showMessageDialog (this, "New User has been Created.");
						txtUser.setText ("");
						txtNew.setText ("");
						txtUser.requestFocus ();
					}
					else 
					{					//If Query Failed.
						JOptionPane.showMessageDialog (this, "Problem while Creating the User.");
						txtUser.setText ("");
						txtNew.setText ("");
						txtUser.requestFocus ();
					}
				}
				catch (SQLException sqlex) 
				{ 
					JOptionPane.showMessageDialog (this, "Problem while Creating the User."); 
					txtUser.setText ("");
					txtNew.setText ("");
					txtUser.requestFocus ();
				}
				catch (ClassNotFoundException cnfe) 
				{ 
					
				}
				
			}

		}		

		if (obj == btnCancel) 
		{		//If Cancel Button Pressed Unload the From.

			setVisible (false);
			dispose();

		}

	}
	public static void main(String args[])
	{
		new NewUser();
	}
}

	