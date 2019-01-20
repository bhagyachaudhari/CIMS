import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.text.*;
import java.util.Calendar.*;

class MainForm extends JFrame implements ActionListener
{	
	JMenuBar mb;
	JMenu login, student, staff, search, report, format, help, sss, stfs, bgcolor,resultreprt,feesreprt,stffsalryreprt;
	JMenuItem freceipts,flist,rreceipts,rlist,sreceipts,slist,newUser,maroon1,maroon2,skyblue4,pink4,lightpink4,rosybrown,gray21,gray,marine,black,log,exit,stud,adm,course,fees,exam,result,stff,timetable,batch,studsrch,admsrch,coursesrch,feessrch,examsrch,resultsrch,stffsrch,stffsalrysrch,timetablesrch,batchsrch,feerecptsrch,studreprt,admreprt,examreprt,staffreprt,fsreprt,about;
	JDesktopPane jdp;
	JPanel jp2,timepan;
	JLabel lname,lline,pname,tm,status;
	JButton bstud,badm,bstaff,bcrs,bexam,bres,bfees,btime,bbatch,bclose;
	Dimension dim;
	int hh,mm,ss;
	Container cp;

	Font f1=new Font("Cambria",Font.BOLD,15);
	Font f2=new Font("Monotype Corsiva",Font.BOLD,25);  
	Font f3=new Font("Monotype Corsiva",Font.BOLD,17);  
	
	 
	MainForm()
	{
		cp=getContentPane();
		cp.setLayout(null);

		jdp=new JDesktopPane();
		dim=new Dimension();
		dim=Toolkit.getDefaultToolkit().getScreenSize();
		java.util.Date currDate=new java.util.Date();
		SimpleDateFormat sdf=new SimpleDateFormat("dd MMMM yyyy",Locale.getDefault());
		String d=sdf.format(currDate);
		
		timepan=new JPanel();
		tm=new JLabel("");
		status=new JLabel(d);
		pname=new JLabel("Computer Institute Management System                                                                                                       				          							                                                                                   ");

	
		lname=new JLabel("Microbace Computer Institute");
		lline=new JLabel("_______________________________________________________");
		

		/****************Shortcut Buttons****************/

		setTitle("MICROBACE COMPUTER INSTITUTE");
		bstud=new JButton("STUDENT");
		badm=new JButton("ADMISSIONS");
		bcrs=new JButton("COURSES");
		bexam=new JButton("EXAM");
		bres=new JButton("RESULTS");
		bstaff=new JButton("STAFF");
		bfees=new JButton("FEES");
		btime=new JButton("TIME TABLE");
		bbatch=new JButton("BATCHES");
		bclose=new JButton("CLOSE");
		

		mb=new JMenuBar();
		/****************Menu Bar****************/
		login=new JMenu("Login     ");      
		student=new JMenu("Student     ");
		staff=new JMenu("Staff     ");
		search=new JMenu("Search     ");
		report=new JMenu("Report     ");
		format=new JMenu("Format       ");
		help=new JMenu("Help     ");
		sss=new JMenu("Student          "); 
		stfs=new JMenu("Staff          ");
		resultreprt=new JMenu("Result Reports     ");    
		feesreprt=new JMenu("Fees Receipts         ");
		stffsalryreprt=new JMenu("Staff Salary Reports     ");
		
		/*************ColorMenu*************/
		bgcolor=new JMenu("Background      ");
		gray=new JMenuItem("Gray      ");
		gray21=new JMenuItem("Gray 21     ");
		black=new JMenuItem("Black      ");
		marine=new JMenuItem("Deep Pink 4      ");	
		skyblue4=new JMenuItem("Sky Blue 4      ");
		pink4=new JMenuItem("Pink 4      ");
		lightpink4=new JMenuItem("Light Pink 4      ");
		rosybrown=new JMenuItem("Plum 4      ");
		maroon1=new JMenuItem("Gray 18      ");
		maroon2=new JMenuItem("Maroon      ");
		
		/***************Login Menu****************/	

		log=new JMenuItem("Change Password      ");
		newUser=new JMenuItem("Change User Name     ");
		exit=new JMenuItem("Exit      ");
		

		/*************Student Menu***************/
		stud=new JMenuItem("Student Details           ");
		adm=new JMenuItem("Admission Details           ");
		freceipts=new JMenuItem("Admission Fees Receipts");  
		course=new JMenuItem("Course Details           ");
		fees=new JMenuItem("Fees Details           ");
		exam=new JMenuItem("Exam Details           ");
		result=new JMenuItem("Result Details           ");
		
	

		/*************Staff Menu***************/

		stff=new JMenuItem("Staff Details         ");
		timetable=new JMenuItem("Time Table          ");
		batch=new JMenuItem("Batch Details         ");
		sreceipts=new JMenuItem("Staff Salary Receipts     ");

		/*************Search Menu**************/
		
		studsrch=new JMenuItem("Student Details         "); 	
		admsrch=new JMenuItem("Admission Details         ");
		coursesrch=new JMenuItem("Course Details         ");
		feessrch=new JMenuItem("Fees Details         ");
		examsrch=new JMenuItem("Exam Details         ");
		resultsrch=new JMenuItem("Result Details         ");
		feerecptsrch=new JMenuItem("Admission Fees Receipts         ");
		stffsrch=new JMenuItem("Staff Details         ");
		stffsalrysrch=new JMenuItem("Staff Salary Receipt        ");
		timetablesrch=new JMenuItem("Time Table         ");
		batchsrch=new JMenuItem("Batch Details         ");

		/*************Report Menu**************/
		studreprt=new JMenuItem("Student Details Report     ");
		admreprt=new JMenuItem("Admission Details Report     ");
		examreprt=new JMenuItem("Exam Details Report     ");
		staffreprt=new JMenuItem("Staff Details Report     ");
		fsreprt=new JMenuItem("Fees Installment Report     ");
		rreceipts=new JMenuItem("Certificates     ");
		rlist=new JMenuItem("Report List     ");
		flist=new JMenuItem("Report List     ");
		slist=new JMenuItem("Report List     ");
		/**************Help Menu****************/

		about=new JMenuItem("About             ");
			
		
		login.add(log); 		//adding items to a Login Menu
		log.setAccelerator (KeyStroke.getKeyStroke(KeyEvent.VK_L, Event.CTRL_MASK));
		log.setMnemonic ((int)'L');
		log.setBackground(Color.black);
		log.setForeground(Color.green);
		log.setFont(f3);

		login.addSeparator();

		login.add(newUser);
		newUser.setBackground(Color.black);
		newUser.setForeground(Color.green);
		newUser.setFont(f3);

		login.addSeparator();
		login.add(exit);
		exit.setAccelerator (KeyStroke.getKeyStroke(KeyEvent.VK_X, Event.CTRL_MASK));
		exit.setMnemonic ((int)'X');
		exit.setBackground(Color.black);
		exit.setForeground(Color.green);
		exit.setFont(f3);
		

		student.add(stud);         //adding items to a Student Menu
		stud.setAccelerator (KeyStroke.getKeyStroke(KeyEvent.VK_S, Event.CTRL_MASK));
		stud.setMnemonic ((int)'S');
		stud.setBackground(Color.black);
		stud.setForeground(Color.green);
		stud.setFont(f3);

		student.add(adm);
		adm.setAccelerator (KeyStroke.getKeyStroke(KeyEvent.VK_A, Event.CTRL_MASK));
		adm.setMnemonic ((int)'A');
		adm.setBackground(Color.black);
		adm.setForeground(Color.green);
		adm.setFont(f3);

		student.add(course);
		course.setAccelerator (KeyStroke.getKeyStroke(KeyEvent.VK_C, Event.CTRL_MASK));
		course.setMnemonic ((int)'C');
		course.setBackground(Color.black);
		course.setForeground(Color.green);
		course.setFont(f3);

		student.addSeparator();
		student.add(exam);
		exam.setAccelerator (KeyStroke.getKeyStroke(KeyEvent.VK_E, Event.CTRL_MASK));
		exam.setMnemonic ((int)'E');
		exam.setBackground(Color.black);
		exam.setForeground(Color.green);
		exam.setFont(f3);

		student.add(result);
		result.setAccelerator (KeyStroke.getKeyStroke(KeyEvent.VK_R, Event.CTRL_MASK));
		result.setMnemonic ((int)'R');
		result.setBackground(Color.black);
		result.setForeground(Color.green);
		result.setFont(f3);

		student.addSeparator();
		student.add(fees);
		fees.setAccelerator (KeyStroke.getKeyStroke(KeyEvent.VK_F, Event.CTRL_MASK));
		fees.setMnemonic ((int)'F');
		fees.setBackground(Color.black);
		fees.setForeground(Color.green);
		fees.setFont(f3);

		student.add(freceipts);         //adding items to a Student Menu
		freceipts.setAccelerator (KeyStroke.getKeyStroke(KeyEvent.VK_S, Event.CTRL_MASK));	
		freceipts.setBackground(Color.black);
		freceipts.setForeground(Color.green);
		freceipts.setFont(f3);
		

		staff.add(stff);		 //adding items to a Staff Menu
		stff.setAccelerator (KeyStroke.getKeyStroke(KeyEvent.VK_P, Event.CTRL_MASK));
		stff.setMnemonic ((int)'P');
		stff.setBackground(Color.black);
		stff.setForeground(Color.green);
		stff.setFont(f3);

		staff.addSeparator();
		staff.add(timetable);
		timetable.setAccelerator (KeyStroke.getKeyStroke(KeyEvent.VK_T, Event.CTRL_MASK));
		timetable.setMnemonic ((int)'T');
		timetable.setBackground(Color.black);
		timetable.setForeground(Color.green);
		timetable.setFont(f3);

		staff.addSeparator();
		staff.add(batch);
		batch.setAccelerator (KeyStroke.getKeyStroke(KeyEvent.VK_B, Event.CTRL_MASK));
		batch.setMnemonic ((int)'B');
		batch.setBackground(Color.black);
		batch.setForeground(Color.green);
		batch.setFont(f3);
	
		staff.addSeparator();
		staff.add(sreceipts);         //adding items to a Student Menu
		sreceipts.setAccelerator (KeyStroke.getKeyStroke(KeyEvent.VK_S, Event.CTRL_MASK));
		sreceipts.setBackground(Color.black);
		sreceipts.setForeground(Color.green);
		sreceipts.setFont(f3);


		search.add(sss);				//adding items to a Search Menu
		//sss.setBackground(Color.black);
		sss.setForeground(Color.red);
		sss.setFont(f3);

		sss.add(studsrch);	 
		studsrch.setBackground(Color.black);
		studsrch.setForeground(Color.green);
		studsrch.setFont(f3);

		sss.add(admsrch);
		admsrch.setBackground(Color.black);
		admsrch.setForeground(Color.green);
		admsrch.setFont(f3);

		sss.add(coursesrch);
		coursesrch.setBackground(Color.black);
		coursesrch.setForeground(Color.green);
		coursesrch.setFont(f3);

		sss.addSeparator();

		sss.add(examsrch);
		examsrch.setBackground(Color.black);
		examsrch.setForeground(Color.green);
		examsrch.setFont(f3);

		sss.add(resultsrch);	
		resultsrch.setBackground(Color.black);
		resultsrch.setForeground(Color.green);
		resultsrch.setFont(f3);

		sss.addSeparator();

		sss.add(feessrch);
		feessrch.setBackground(Color.black);
		feessrch.setForeground(Color.green);
		feessrch.setFont(f3);

		sss.add(feerecptsrch);
		feerecptsrch.setBackground(Color.black);
		feerecptsrch.setForeground(Color.green);
		feerecptsrch.setFont(f3);

		search.addSeparator();

		search.add(stfs);	
		//stfs.setBackground(Color.black);
		stfs.setForeground(Color.red);
		stfs.setFont(f3);
	
		stfs.add(stffsrch);
		stffsrch.setBackground(Color.black);
		stffsrch.setForeground(Color.green);
		stffsrch.setFont(f3);

		stfs.addSeparator();

		stfs.add(stffsalrysrch);
		stffsalrysrch.setBackground(Color.black);
		stffsalrysrch.setForeground(Color.green);
		stffsalrysrch.setFont(f3);

		stfs.addSeparator();
		stfs.add(timetablesrch);
		timetablesrch.setBackground(Color.black);
		timetablesrch.setForeground(Color.green);
		timetablesrch.setFont(f3);

		stfs.add(batchsrch);
		batchsrch.setBackground(Color.black);
		batchsrch.setForeground(Color.green);
		batchsrch.setFont(f3);


		report.add(studreprt);
		studreprt.setBackground(Color.black);
		studreprt.setForeground(Color.green);
		studreprt.setFont(f3);

		report.add(admreprt);
		admreprt.setBackground(Color.black);
		admreprt.setForeground(Color.green);
		admreprt.setFont(f3);

		report.addSeparator();

		report.add(examreprt);
		examreprt.setBackground(Color.black);
		examreprt.setForeground(Color.green);
		examreprt.setFont(f3);

		report.add(resultreprt);   
		resultreprt.setBackground(Color.black);
		resultreprt.setForeground(Color.red);
		resultreprt.setFont(f3);
	
		resultreprt.add(rreceipts);
		rreceipts.setBackground(Color.black);
		rreceipts.setForeground(Color.green);
		rreceipts.setFont(f3);

		resultreprt.add(rlist);
		rlist.setBackground(Color.black);
		rlist.setForeground(Color.green);
		rlist.setFont(f3);

		report.addSeparator(); 
		report.add(staffreprt); 
		staffreprt.setBackground(Color.black);
		staffreprt.setForeground(Color.green);
		staffreprt.setFont(f3);
		
		report.addSeparator(); 
		report.add(fsreprt);	
		fsreprt.setBackground(Color.black);
		fsreprt.setForeground(Color.green);
		fsreprt.setFont(f3);

		report.add(feesreprt);  
		feesreprt.setBackground(Color.black);
		feesreprt.setForeground(Color.red);
		feesreprt.setFont(f3);
 
		feesreprt.add(flist);
		flist.setBackground(Color.black);
		flist.setForeground(Color.green);
		flist.setFont(f3);

		report.add(stffsalryreprt);
		stffsalryreprt.setBackground(Color.black);
		stffsalryreprt.setForeground(Color.red);
		stffsalryreprt.setFont(f3);

		stffsalryreprt.add(slist);
		slist.setBackground(Color.black);
		slist.setForeground(Color.green);
		slist.setFont(f3);
		
		format.add(bgcolor);
		bgcolor.setBackground(Color.black);
		bgcolor.setForeground(Color.red);
		bgcolor.setFont(f3);

		bgcolor.add(gray);
		gray.setAccelerator (KeyStroke.getKeyStroke(KeyEvent.VK_1, Event.CTRL_MASK));
		gray.setMnemonic ((int)'1');	
		gray.setBackground(Color.black);
		gray.setForeground(Color.green);
		gray.setFont(f3);
	

		bgcolor.add(gray21);
		gray21.setAccelerator (KeyStroke.getKeyStroke(KeyEvent.VK_2, Event.CTRL_MASK));
		gray21.setMnemonic ((int)'2');	
		gray21.setBackground(Color.black);
		gray21.setForeground(Color.green);
		gray21.setFont(f3);

		bgcolor.add(black);
		black.setAccelerator (KeyStroke.getKeyStroke(KeyEvent.VK_3, Event.CTRL_MASK));
		black.setMnemonic ((int)'B');	
		black.setBackground(Color.black);
		black.setForeground(Color.green);
		black.setFont(f3);

		bgcolor.add(marine);
		marine.setAccelerator (KeyStroke.getKeyStroke(KeyEvent.VK_4, Event.CTRL_MASK));
		marine.setMnemonic ((int)'3');	
		marine.setBackground(Color.black);
		marine.setForeground(Color.green);
		marine.setFont(f3);
				
		bgcolor.add(skyblue4);
		skyblue4.setAccelerator (KeyStroke.getKeyStroke(KeyEvent.VK_5, Event.CTRL_MASK));
		skyblue4.setMnemonic ((int)'4');
		skyblue4.setBackground(Color.black);
		skyblue4.setForeground(Color.green);
		skyblue4.setFont(f3);	

		bgcolor.add(pink4);
		pink4.setAccelerator (KeyStroke.getKeyStroke(KeyEvent.VK_6, Event.CTRL_MASK));
		pink4.setMnemonic ((int)'5');
		pink4.setBackground(Color.black);
		pink4.setForeground(Color.green);
		pink4.setFont(f3);	

		bgcolor.add(lightpink4);
		lightpink4.setAccelerator (KeyStroke.getKeyStroke(KeyEvent.VK_7, Event.CTRL_MASK));
		lightpink4.setMnemonic ((int)'6');
		lightpink4.setBackground(Color.black);
		lightpink4.setForeground(Color.green);
		lightpink4.setFont(f3);	

		bgcolor.add(rosybrown);
		rosybrown.setAccelerator (KeyStroke.getKeyStroke(KeyEvent.VK_8, Event.CTRL_MASK));
		rosybrown.setMnemonic ((int)'7');
		rosybrown.setBackground(Color.black);
		rosybrown.setForeground(Color.green);
		rosybrown.setFont(f3);	

		bgcolor.add(maroon1);
		maroon1.setAccelerator (KeyStroke.getKeyStroke(KeyEvent.VK_9, Event.CTRL_MASK));
		maroon1.setMnemonic ((int)'8');
		maroon1.setBackground(Color.black);
		maroon1.setForeground(Color.green);
		maroon1.setFont(f3);

		bgcolor.add(maroon2);
		maroon2.setAccelerator (KeyStroke.getKeyStroke(KeyEvent.VK_0, Event.CTRL_MASK));
		maroon2.setMnemonic ((int)'9');
		maroon2.setBackground(Color.black);
		maroon2.setForeground(Color.green);
		maroon2.setFont(f3);		
				
		
		help.add(about);
		about.setAccelerator (KeyStroke.getKeyStroke(KeyEvent.VK_H, Event.CTRL_MASK));
		about.setMnemonic ((int)'H');	
		about.setBackground(Color.black);
		about.setForeground(Color.green);
		about.setFont(f3);	
		

		mb.setBackground(Color.black);
		mb.setBorder(BorderFactory.createLineBorder(Color.black,1));
		

		mb.add(login); 		// adding all Menus  to a  MenuBar
		login.setBackground(Color.black);
		login.setForeground(Color.green);
		login.setFont(f3);
		
		mb.add(student);
		student.setBackground(Color.black);
		student.setForeground(Color.green);
		student.setFont(f3);

		mb.add(staff);
		staff.setBackground(Color.black);
		staff.setForeground(Color.green);
		staff.setFont(f3);

		mb.add(search);
		search.setBackground(Color.black);
		search.setForeground(Color.green);
		search.setFont(f3);

		mb.add(report);
		report.setBackground(Color.black);
		report.setForeground(Color.green);
		report.setFont(f3);

		mb.add(format);
		format.setBackground(Color.black);
		format.setForeground(Color.green);
		format.setFont(f3);

		mb.add(help);
		help.setBackground(Color.black);
		help.setForeground(Color.green);
		help.setFont(f3);
		
		bstud.setToolTipText("Student Details Form");
		badm.setToolTipText("Admission Details Form");
		bstaff.setToolTipText("Staff Details Form");
		bcrs.setToolTipText("Course Details Form");
		bexam.setToolTipText("Exam Details Form");
		bres.setToolTipText("Result Details Form");
		bfees.setToolTipText("Fees Details Form");
		btime.setToolTipText("Time Table Details");
		bbatch.setToolTipText("Batch Details");
		bclose.setToolTipText("Close");
	
		cp.add(lname);
		lname.setBounds(250,1,700,40); 
		lname.setForeground(Color.white);
		lname.setFont(f2);

		cp.add(lline);
		lline.setBounds(250,10,900,40); 
		lline.setForeground(Color.white);
		lline.setFont(f2);
		 	 
		cp.add(bstud);			
		bstud.setBounds(0,190,150,50); 
		bstud.setBackground(Color.black);
		bstud.setForeground(Color.red);
		bstud.setFont(f1);
		bstud.setBorder(BorderFactory.createLineBorder(Color.white,1));

		cp.add(badm);
		badm.setBounds(0,240,150,50);
		badm.setBackground(Color.black);
		badm.setForeground(Color.red);
		badm.setFont(f1);
		badm.setBorder(BorderFactory.createLineBorder(Color.white,1));


		cp.add(bstaff);
		bstaff.setBounds(0,290,150,50);
		bstaff.setBackground(Color.black);
		bstaff.setForeground(Color.red);
		bstaff.setFont(f1);
		bstaff.setBorder(BorderFactory.createLineBorder(Color.white,1));

		cp.add(bcrs);
		bcrs.setBounds(0,340,150,50);
		bcrs.setBackground(Color.black);
		bcrs.setForeground(Color.red);
		bcrs.setFont(f1);
		bcrs.setBorder(BorderFactory.createLineBorder(Color.white,1));

		cp.add(bexam);
		bexam.setBounds(0,390,150,50);
		bexam.setBackground(Color.black);
		bexam.setForeground(Color.red);
		bexam.setFont(f1);
		bexam.setBorder(BorderFactory.createLineBorder(Color.white,1));


		cp.add(bres);
		bres.setBounds(0,440,150,50);
		bres.setBackground(Color.black);
		bres.setForeground(Color.red);
		bres.setFont(f1);
		bres.setBorder(BorderFactory.createLineBorder(Color.white,1));

		cp.add(bfees);
		bfees.setBounds(0,490,150,50);
		bfees.setBackground(Color.black);
		bfees.setForeground(Color.red);
		bfees.setFont(f1);
		bfees.setBorder(BorderFactory.createLineBorder(Color.white,1));

		cp.add(btime);
		btime.setBounds(0,540,150,50);
		btime.setBackground(Color.black);
		btime.setForeground(Color.red);
		btime.setFont(f1);
		btime.setBorder(BorderFactory.createLineBorder(Color.white,1));

		cp.add(bbatch);
		bbatch.setBounds(0,590,150,50);
		bbatch.setBackground(Color.black);
		bbatch.setForeground(Color.red);
		bbatch.setFont(f1);
		bbatch.setBorder(BorderFactory.createLineBorder(Color.white,1));


		cp.add(bclose);
		bclose.setBounds(0,640,150,50);
		bclose.setBackground(Color.black);
		bclose.setForeground(Color.red);
		bclose.setFont(f1);
		bclose.setBorder(BorderFactory.createLineBorder(Color.white,1));

		
		log.addActionListener(this);
		newUser.addActionListener(this);
		exit.addActionListener(this);			

		stud.addActionListener(this);
		adm.addActionListener(this);
		course.addActionListener(this);
		fees.addActionListener(this);
		exam.addActionListener(this);
		result.addActionListener(this);

		stff.addActionListener(this);
		timetable.addActionListener(this);
		batch.addActionListener(this);



		studsrch.addActionListener(this);
		admsrch.addActionListener(this);
		coursesrch.addActionListener(this);
		feessrch.addActionListener(this);
		examsrch.addActionListener(this);
		resultsrch.addActionListener(this);
		feerecptsrch.addActionListener(this);

		
		stffsrch.addActionListener(this);
		stffsalrysrch.addActionListener(this);
		timetablesrch.addActionListener(this); 
		batchsrch.addActionListener(this);
		
		feesreprt.addActionListener(this);
		stffsalryreprt.addActionListener(this);
		studreprt.addActionListener(this);  
		admreprt.addActionListener(this);
		examreprt.addActionListener(this);
		resultreprt.addActionListener(this);
		staffreprt.addActionListener(this);
		fsreprt.addActionListener(this);
		
		about.addActionListener(this);
		
		gray.addActionListener(this);
		gray21.addActionListener(this);
		black.addActionListener(this);
		marine.addActionListener(this);   
		skyblue4.addActionListener(this);
		pink4.addActionListener(this);
		lightpink4.addActionListener(this);
		rosybrown.addActionListener(this);
		maroon1.addActionListener(this);
		maroon2.addActionListener(this);
		
		bstud.addActionListener(this);
		badm.addActionListener(this);
		bcrs.addActionListener(this);
		bfees.addActionListener(this);
		bexam.addActionListener(this);
		bstaff.addActionListener(this);
		bbatch.addActionListener(this);
		btime.addActionListener(this);
		bres.addActionListener(this);
		bclose.addActionListener(this);

		rlist.addActionListener(this);
		rreceipts.addActionListener(this);
		flist.addActionListener(this);
		freceipts.addActionListener(this);
		slist.addActionListener(this);
		sreceipts.addActionListener(this);

		/***********Current time & Date**************/

		timepan.setBounds(0,dim.height-78,dim.width,30);
		timepan.add(pname);
		pname.setFont(new Font("Calibri",Font.BOLD,18));
		pname.setForeground(Color.black);
		timepan.add(tm);
		tm.setForeground(Color.black);
		timepan.add(status);
		status.setForeground(Color.black);
		status.setFont(new Font("Calibri",Font.BOLD,17));
		cp.add(timepan);
		timepan.setBorder(BorderFactory.createLineBorder(Color.decode("#000000"),1));
		
		//set code for the current time

		javax.swing.Timer t=new javax.swing.Timer(1000,this);
		t.start();
		

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setJMenuBar(mb);
		setVisible(true);
		cp.setBackground(Color.decode("#200000"));  
		setResizable(false);
		setBounds(0,0,dim.width,dim.height);
	}
	public void actionPerformed(ActionEvent ae)
	{	
		
		//code for the current time
		
		Calendar now=Calendar.getInstance();
		int hh=now.get(Calendar.HOUR);
		int mm=now.get(Calendar.MINUTE);
		int ss=now.get(Calendar.SECOND);
		tm.setText(hh+":"+mm+":"+ss);
		tm.setFont(new Font("Arial Narrow",Font.BOLD,20));
		
		if(ae.getSource()==log)
		{
			setTitle("MICROBACE COMPUTER INSTITUTE<Change Password>");
			cp.add(new ChangePassword());		
		}
		if(ae.getSource()==newUser)
		{
			setTitle("MICROBACE COMPUTER INSTITUTE<New User>");
			cp.add(new NewUser());    //calling New User Login Form
		}
		if(ae.getSource()==exit||ae.getSource()==bclose)
		{
			int res=JOptionPane.showConfirmDialog((Component)null,"Are you sure to Exit?","Close",JOptionPane.YES_NO_OPTION);
			if(res==JOptionPane.YES_OPTION)
			{
				JOptionPane.showMessageDialog(null,"***Thanks For Using Computer Institute Management System***");
				setVisible(false);
			}
			else if(res==JOptionPane.NO_OPTION)
			{
			}
		}
		if(ae.getSource()==bstud||ae.getSource()==stud)
		{
			setTitle("MICROBACE COMPUTER INSTITUTE<Student Details>");
			cp.add(new StudDetails());    //calling StudentDetails form
		}
		if(ae.getSource()==badm||ae.getSource()==adm)
		{
			setTitle("MICROBACE COMPUTER INSTITUTE<Admission Details>");
			cp.add(new AdmssnDetails());    //calling AdmissionDetails form
		}
		if(ae.getSource()==bcrs||ae.getSource()==course)
		{
			setTitle("MICROBACE COMPUTER INSTITUTE<Course Details>");
			cp.add(new CourseDetails());    //calling CourseDetails form
		}
		if(ae.getSource()==bfees||ae.getSource()==fees)
		{
			setTitle("MICROBACE COMPUTER INSTITUTE<FeesDetails>");
			cp.add(new FeesInstallment());    //calling FeesDetails form
		}
		if(ae.getSource()==bexam||ae.getSource()==exam)
		{
			setTitle("MICROBACE COMPUTER INSTITUTE<ExamDetails>");
			cp.add(new ExamDetails());    //calling ExamDetails form
		}
		if(ae.getSource()==bres||ae.getSource()==result)
		{
			setTitle("MICROBACE COMPUTER INSTITUTE<ResultDetails>");
			cp.add(new ResultDetails());    //calling ResultDetails form
		}			
		if(ae.getSource()==bstaff||ae.getSource()==stff)
		{
			setTitle("MICROBACE COMPUTER INSTITUTE<StaffDetails>");
			cp.add(new StaffDetails());    //calling StaffDetails form
		}
		if(ae.getSource()==btime||ae.getSource()==timetable)
		{
			setTitle("MICROBACE COMPUTER INSTITUTE<TimeTable>");
			cp.add(new TimeTable());    //calling TimeTable form	
		}
		if(ae.getSource()==bbatch||ae.getSource()==batch)
		{
			setTitle("MICROBACE COMPUTER INSTITUTE<BatchDetails>");
			cp.add(new BatchDetails());    //calling BatchDetails form	
		}
		if(ae.getSource()==studsrch)
		{
			setTitle("MICROBACE COMPUTER INSTITUTE<Student Search>");
			cp.add(new StudSearch());    
			//calling StudentSearchform	
		}
		if(ae.getSource()==admsrch)
		{
			setTitle("MICROBACE COMPUTER INSTITUTE<Admission Search>");
			cp.add(new AdmssnSearch());	
			//calling AdmissionSearch form	
		}
		if(ae.getSource()==coursesrch)	
		{
			setTitle("MICROBACE COMPUTER INSTITUTE<Course Search>");
			cp.add(new CourseSearch());    //calling CourseSearch form	
		}
		if(ae.getSource()==feessrch)
		{
			setTitle("MICROBACE COMPUTER INSTITUTE<Fees Search>");
			cp.add(new FInstallmentReport());    //calling FeesSearch form	
		}
		if(ae.getSource()==examsrch)	
		{
			setTitle("MICROBACE COMPUTER INSTITUTE<Exam Search>");
			cp.add(new ExamSearch());    //calling ExamSearch form	
		}
		if(ae.getSource()==resultsrch)	
		{
			setTitle("MICROBACE COMPUTER INSTITUTE<Result Search>");
			cp.add(new ResultSearch());    //calling ResultSearch form	
		}
		if(ae.getSource()==stffsrch)
		{
			setTitle("MICROBACE COMPUTER INSTITUTE<Staff Search>");
			cp.add(new StaffSearch());    //calling StaffSearch form	
		}
		if(ae.getSource()==stffsalrysrch)
		{
			setTitle("MICROBACE COMPUTER INSTITUTE<Staff Salary Search>");
			cp.add(new StaffSalarySearch());    //calling StaffSalarySearch form	
		}
		if(ae.getSource()==timetablesrch)
		{
			setTitle("MICROBACE COMPUTER INSTITUTE<Time Table Search>");
			cp.add(new TimeTableSearch());    //calling TimeTableSearch form	
		}
		if(ae.getSource()==batchsrch)	
		{
			setTitle("MICROBACE COMPUTER INSTITUTE<Batch Search>");
			cp.add(new BatchSearch());    //calling BatchSearch form	
		}
		if(ae.getSource()==feerecptsrch)	
		{
			setTitle("MICROBACE COMPUTER INSTITUTE<Fees Receipt Search>");
			cp.add(new FeesReceiptSearch());    //calling FeesReceiptSearch Form
		}
		/**************************Reports*************************/
		if(ae.getSource()==studreprt)	
		{
			setTitle("MICROBACE COMPUTER INSTITUTE<Student Report>");
			cp.add(new StudReport());    //calling StudentDetails Report Form
		}
		if(ae.getSource()==admreprt)	
		{
			setTitle("MICROBACE COMPUTER INSTITUTE<Admission Report>");
			cp.add(new AdmssnReport());    //calling AdmissionDetails Report Form
	
		}
		if(ae.getSource()==examreprt)	
		{
			setTitle("MICROBACE COMPUTER INSTITUTE<Exam Report>");
			cp.add(new ExamReport());   //calling ExamDetails Report Form

		}
			
		if(ae.getSource()==rlist)	
		{
			setTitle("MICROBACE COMPUTER INSTITUTE<Result Report>");
			cp.add(new ResultReport());    //calling ResultDetails Report Form

		}
	
		if(ae.getSource()==rreceipts)	
		{
			setTitle("MICROBACE COMPUTER INSTITUTE<Result Report>");
			cp.add(new Certificate());    //calling ResultDetails Report Form

		}
		
		if(ae.getSource()==staffreprt)	
		{
			setTitle("MICROBACE COMPUTER INSTITUTE<Staff Report>");
			cp.add(new StaffReport());    //calling StaffDetails Report Form

		}
		if(ae.getSource()==fsreprt)	
		{
			setTitle("MICROBACE COMPUTER INSTITUTE<Fees Report>");
			cp.add(new FInstallmentReport());  //calling FeesDetails Report Form
  
		}	
			
		if(ae.getSource()==freceipts)
		{
			setTitle("MICROBACE COMPUTER INSTITUTE<Fees Receipt>");
			cp.add(new FeesReceipt());    //calling FeesReceipt Report
	
		}
		
		if(ae.getSource()==flist)
		{
			setTitle("MICROBACE COMPUTER INSTITUTE<Fees Receipt>");
			cp.add(new FeesReceiptReport());    //calling FeesReceipt Report
	
		}	
		if(ae.getSource()==sreceipts) 	
		{
			setTitle("MICROBACE COMPUTER INSTITUTE<Staff Salary>");
			cp.add(new StaffSalary());    //calling StaffSalary Report	
		}	
		if(ae.getSource()==slist)	
		{
			setTitle("MICROBACE COMPUTER INSTITUTE<Staff Salary>");
			cp.add(new StaffSalaryReport());    //calling StaffSalary Report	
		}
		if(ae.getSource()==gray)
		{
			cp.setBackground(Color.decode("#302226"));      
			lname.setForeground(Color.decode("#FFFFFF")); 
			lline.setForeground(Color.decode("#FFFFFF")); 
		}
		if(ae.getSource()==black)
		{
			cp.setBackground(Color.decode("#000000"));  
		}
		if(ae.getSource()==marine)
		{
			cp.setBackground(Color.decode("#7E354D"));   
		}
		if(ae.getSource()==gray21)
		{
			cp.setBackground(Color.decode("#2B1B17"));   
		}
		if(ae.getSource()==skyblue4)
		{
			cp.setBackground(Color.decode("#41627E"));   
		}
		if(ae.getSource()==pink4)
		{
			cp.setBackground(Color.decode("#7F525D"));   
		}
		if(ae.getSource()==lightpink4)
		{
			cp.setBackground(Color.decode("#7F4E52"));   
		}
		if(ae.getSource()==rosybrown)
		{
			cp.setBackground(Color.decode("#7E587E"));   
			lname.setForeground(Color.decode("#000000")); 
			lline.setForeground(Color.decode("#000000")); 
		}
		if(ae.getSource()==maroon1)
		{
			cp.setBackground(Color.decode("#250517"));   
			lname.setForeground(Color.decode("#FFFFFF")); 
			lline.setForeground(Color.decode("#FFFFFF")); 
		}	
		if(ae.getSource()==maroon2)
		{
			cp.setBackground(Color.decode("#200000"));   
			lname.setForeground(Color.decode("#FFFFFF")); 
			lline.setForeground(Color.decode("#FFFFFF")); 
		}					
		if(ae.getSource()==about)	
		{
			setTitle("MICROBACE COMPUTER INSTITUTE<Help>");
			Help h=new Help("Computer Institute Management System Help","HTML/help.html");
			add(h);
			h.show();
			h.moveToFront();
			h.setBounds(250,50,(dim.width-590),(dim.height-150));
			try
			{
				h.setSelected(true);
			}
			catch(Exception e){}
			
		}
	}
	public static void main(String args[])
	{
		new  MainForm();
	}
}
