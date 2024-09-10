package in.sp.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;



public class SchoolMenu extends JFrame implements ActionListener {
	
	JButton back,teacher,searchTEACHER,updateTEACHER,deleteTeacher,student,searchSTUDENT,updateSTUDENT,deleteSTUDENT;
	SchoolMenu() {
		// TODO Auto-generated constructor stub
		setLayout(null);
		
		JLabel text=new JLabel("SCHOOL STUDENT & TEACHER");
		text.setFont(new Font("Tohoma",Font.BOLD,50));
		text.setForeground(Color.YELLOW);
		text.setBackground(Color.black);
		text.setBounds(370, 10, 1100, 50);
		add(text);
		
		ImageIcon im1=new ImageIcon(ClassLoader.getSystemResource("menu.jpg"));
		Image im2=im1.getImage().getScaledInstance(1550, 820, Image.SCALE_DEFAULT);
		ImageIcon im3=new ImageIcon(im2);
		JLabel image=new JLabel(im3);
		image.setBounds(0, 0, 1550, 820);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		add(image);
		
		ImageIcon img1=new ImageIcon(ClassLoader.getSystemResource("teacher.jpg"));
		Image img2=img1.getImage().getScaledInstance(800, 450, Image.SCALE_DEFAULT);
		ImageIcon img3=new ImageIcon(img2);
		JLabel image1=new JLabel(img3);
		image1.setBounds(370, 170, 800, 450);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		image.add(image1);
		
		//TEACHER
		
		 teacher=new JButton("ADD TEACHER"); 
		 teacher.setBounds(30, 190, 200, 30);
		 teacher.setFocusPainted(false);
		 teacher.setBackground(Color.black);
		 teacher.setForeground(Color.white);
		 teacher.addActionListener(this);
		 image.add(teacher);
			
			 searchTEACHER=new JButton("SEARCH TEACHER");
			 searchTEACHER.setBounds(30, 290, 200, 30);
			 searchTEACHER.setBackground(Color.black);
			 searchTEACHER.setForeground(Color.white);
			 searchTEACHER.addActionListener(this);
			 image.add(searchTEACHER);
			
			
			 updateTEACHER=new JButton("UPDATE TEACHER");
			 updateTEACHER.setBounds(30, 420, 200, 30);
			 updateTEACHER.setBackground(Color.black);
			 updateTEACHER.setForeground(Color.white);
			 updateTEACHER.addActionListener(this);
			 image.add(updateTEACHER);
			
			 deleteTeacher=new JButton("DELETE TEACHER");
			 deleteTeacher.setBounds(30, 540, 200, 30);
			 deleteTeacher.setBackground(Color.black);
			 deleteTeacher.setForeground(Color.white);
			 deleteTeacher.addActionListener(this);
			 image.add(deleteTeacher);
			 
			 //STUDENT
			 
			 student=new JButton("ADD STUDENT"); 
			 student.setBounds(1250, 190, 200, 30);
			 student.setFocusPainted(false);
			 student.setBackground(Color.black);
			 student.setForeground(Color.white);
			 student.addActionListener(this);
			 image.add(student);
				
				 searchSTUDENT=new JButton("SEARCH STUDENT");
				 searchSTUDENT.setBounds(1250, 290, 200, 30);
				 searchSTUDENT.setBackground(Color.black);
				 searchSTUDENT.setForeground(Color.white);
				 searchSTUDENT.addActionListener(this);
				 image.add(searchSTUDENT);
				
				
				 updateSTUDENT=new JButton("UPDATE STUDENT");
				 updateSTUDENT.setBounds(1250, 420, 200, 30);
				 updateSTUDENT.setBackground(Color.black);
				 updateSTUDENT.setForeground(Color.white);
				 updateSTUDENT.addActionListener(this);
				 image.add(updateSTUDENT);
				
				 deleteSTUDENT=new JButton("DELETE STUDENT");
				 deleteSTUDENT.setBounds(1250, 540, 200, 30);
				 deleteSTUDENT.setBackground(Color.black);
				 deleteSTUDENT.setForeground(Color.white);
				 deleteSTUDENT.addActionListener(this);
				 image.add(deleteSTUDENT);
		
		back=new JButton("BACK");
		back.setBounds(1400, 730, 90, 25);
		back.setFocusPainted(false);
		back.setBackground(Color.black);
		back.setForeground(Color.white);
		back.addActionListener(this);
		image.add(back);
		
	
		//setBounds(0, 0, 1550, 820);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		//setUndecorated(true);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//visible on off
//		while(true)
//		{
//			text.setForeground(Color.BLUE);
//			try {
//				Thread.sleep(500);
//			}catch (Exception e) {
//				// TODO: handle exception
//				e.printStackTrace();
//			}
//			text.setForeground(Color.RED);
//			try {
//				Thread.sleep(500);
//			}catch (Exception e) {
//				// TODO: handle exception
//				e.printStackTrace();
//			}
//			text.setForeground(Color.YELLOW);
//			try {
//				Thread.sleep(500);
//			}catch (Exception e) {
//				// TODO: handle exception
//				e.printStackTrace();
//			}
//		}
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==teacher)
		{
			//setVisible(false);
			new AddTeacher();
		}
		else if (e.getSource()==searchTEACHER) {
			//setVisible(false);
			new SearchTeacher();
		}
		else if (e.getSource()==updateTEACHER) {
			//setVisible(false);
			new UpdateTeacher();
		}
		else if (e.getSource()==deleteTeacher) {
			//setVisible(false);
			new DeleteTeacher();
		}
		else if (e.getSource()==student) {
			//setVisible(false);
			new AddStudent();
		}
		else if (e.getSource()==searchSTUDENT) {
			//setVisible(false);
			new SearchStudent();
		}
		else if (e.getSource()==updateSTUDENT) {
			//setVisible(false);
			new UpdateStudent();
		}
		else if (e.getSource()==deleteSTUDENT) {
			//setVisible(false);
			new DeleteStudent();
		}
		
		else if (e.getSource()==back) {
			
	        setVisible(false);
			System.exit(0);	
		}
	}
	public static void main(String...args)
	{
		new SchoolMenu();
	}


}
