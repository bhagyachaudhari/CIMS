import javax.swing.*;
import java.awt.*;

public class Start extends JWindow
{
	
JProgressBar jpb=new JProgressBar();
JLabel t1=new JLabel("");
	
JLabel Header=new JLabel("<html><head></head><body><hr size=5><font size=6 color=FF00FF>MICROBACE COMPUTER INSTITUTE MANAGMENT SYSTEM<hr size=5><br><br><b><font size=5 color=#F660AB><center>PLATFORM JAVA</center></font></b></body></html>");
	
	
Container cp=getContentPane();
JLabel name=new JLabel("Developed by: Bhagyashri D. Chaudhari");
JLabel eid=new JLabel("Email Id: bhagyashric1992@gmail.com");
	
JLabel image=new JLabel(new ImageIcon("image/c3.jpg"));
	
Start()
{
cp.setLayout(null);
jpb.setOrientation(JProgressBar.HORIZONTAL);
cp.setBackground(Color.black); 
		
		
jpb.setBorderPainted(true);
jpb.setStringPainted(true);
jpb.setBorder(BorderFactory.createRaisedBevelBorder());
jpb.setFont(new Font("Century gothic",Font.BOLD,25));
jpb.setForeground(Color.decode("#800517")); 
		
cp.add(jpb);
jpb.setBounds(0,570,800,40);
jpb.setBackground(Color.black);
		
cp.add(t1);
t1.setBounds(370,540,450,30);
t1.setFont(new Font("Monotype Corsiva",Font.BOLD,22));
t1.setForeground(Color.white);

cp.add(image);
image.setBounds(250,250,300,200);
		
setVisible(true);
setSize(800,600); 
		
setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - getWidth()) / 2,(Toolkit.getDefaultToolkit().
getScreenSize().height - getHeight()) / 2);
	
cp.add(Header);
Header.setBounds(115,100,565,200);
		
cp.add(name);
name.setBounds(255,420,300,30);
name.setFont(new Font("Comic Sans MS",Font.ITALIC,16));
name.setForeground(Color.decode("#C85A17")); 

cp.add(eid);
eid.setBounds(270,440,300,30);
eid.setFont(new Font("Comic Sans MS",Font.ITALIC,16));
eid.setForeground(Color.decode("#C85A17"));
		
for(int i=1;i<=100;i++)
{
jpb.setValue(i);
if(i==5)
{
t1.setText("Processing of Files...");
}
if(i==30)
{
t1.setText("Loading of include of Files...");
}
if(i==60)
{
t1.setText("Connecting with database...");
}
if(i==80)
{
t1.setText("Loading completed successfully...");
}
if(i==90)
{
t1.setText("Opening Computer Institute Management System...");
}
if(jpb.getValue()==100)
{
setVisible(false);
new Login();     //Calling Login Form
dispose();
}
try
{
Thread.sleep(100);
}
catch(InterruptedException e)
{
}
}
}
public static void main(String args[])
{	
new Start();  //Calling Constructor
}
}
	
	