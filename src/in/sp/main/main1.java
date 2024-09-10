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

public class main1 extends JFrame implements ActionListener {
	
	JButton next;
	main1() {
		// TODO Auto-generated constructor stub
		setLayout(null);
		
		JLabel text=new JLabel("WELCOME TO RASIKJEW HIGH SCHOOL");
		text.setFont(new Font("Tohoma",Font.BOLD,50));
		text.setForeground(Color.white);
		text.setBackground(Color.black);
		text.setBounds(250, 10, 1100, 50);
		add(text);
		
		ImageIcon im1=new ImageIcon(ClassLoader.getSystemResource("blurimage.jpg"));
		Image im2=im1.getImage().getScaledInstance(1550, 820, Image.SCALE_DEFAULT);
		ImageIcon im3=new ImageIcon(im2);
		JLabel image=new JLabel(im3);
		image.setBounds(0, 0, 1550, 820);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		add(image);
		
		ImageIcon img1=new ImageIcon(ClassLoader.getSystemResource("school.jpg"));
		Image img2=img1.getImage().getScaledInstance(1200, 650, Image.SCALE_DEFAULT);
		ImageIcon img3=new ImageIcon(img2);
		JLabel image1=new JLabel(img3);
		image1.setBounds(140, 120, 1200, 650);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		image.add(image1);
		
		next=new JButton("NEXT");
		next.setBounds(1400, 730, 90, 25);
		next.setForeground(Color.white);
		next.addActionListener(this);
		next.setBackground(Color.black);
		//next.setBorder(null);
		next.setFocusPainted(false);
		add(next);
			
	
		//setBounds(0, 0, 1550, 820);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		while(true)
		{
			text.setForeground(Color.BLUE);
			text.setBounds(250, 30, 1100, 50);
			try {
				Thread.sleep(500);
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			text.setForeground(Color.RED);
			text.setBounds(250, 10, 1100, 50);
			try {
				Thread.sleep(500);
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			text.setForeground(Color.YELLOW);
			text.setBounds(250, 20, 1100, 50);
			try {
				Thread.sleep(500);
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
			
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==next) {
			setVisible(false);
			new SchoolMenu();
		}
	}
	public static void main(String...args)
	{
		new main1();
	}


}
