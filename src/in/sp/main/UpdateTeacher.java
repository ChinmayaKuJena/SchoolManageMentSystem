package in.sp.main;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class UpdateTeacher extends JFrame implements ActionListener{
	
	JTextField jtname,jtSalary,jtphone,jtage,gender,jtSubject;

	JButton check, update,back;
	Choice jtid;
	
	public UpdateTeacher() {
		// TODO Auto-generated constructor stub
		setLayout(null);
		
		JLabel text=new JLabel("UPDATE TEACHER");
		text.setBounds(380, 20, 500, 70);
		text.setFont(new Font("Tohoma",Font.BOLD,40));
		text.setForeground(Color.BLUE);
		add(text);
		
		ImageIcon im1=new ImageIcon(ClassLoader.getSystemResource("tupdate1.jpg"));
		Image im2=im1.getImage().getScaledInstance(550, 350, Image.SCALE_DEFAULT);
		ImageIcon im3=new ImageIcon(im2);
		JLabel image=new JLabel(im3);
		image.setBounds(500, 125, 550, 350);
		add(image);
		
		
		
		JLabel teacherid=new JLabel("TEACHER ID");
		teacherid.setBounds(80, 100, 150, 30);
		teacherid.setFont(new Font("Tohoma",Font.BOLD,18));
		add(teacherid);
		jtid=new Choice();
		jtid.setBounds(250, 100, 150, 30);
		add(jtid);
		
		try {
			JdBcCONNECTION jd=new JdBcCONNECTION();
			ResultSet rs = jd.st.executeQuery("select * from teacher");
			while(rs.next())
			{
				jtid.add(rs.getString("id"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		JLabel teachername=new JLabel("TEACHER NAME");
		teachername.setBounds(80, 150, 150, 30);
		teachername.setFont(new Font("Tohoma",Font.BOLD,18));
		add(teachername);
		jtname=new JTextField();
		jtname.setBounds(250, 150, 150, 30);
		add(jtname);
		
		JLabel teacherage=new JLabel("TEACHER AGE");
		teacherage.setBounds(80, 200, 150, 30);
		teacherage.setFont(new Font("Tohoma",Font.BOLD,18));
		add(teacherage);
		jtage=new JTextField();
		jtage.setBounds(250, 200, 150, 30);
		add(jtage);
		
		JLabel Tgender=new JLabel("GENDER");
		Tgender.setBounds(80, 250, 150, 30);
		Tgender.setFont(new Font("Tohoma",Font.BOLD,18));
		add(Tgender);
		gender=new JTextField();
		gender.setBounds(250, 250, 150, 30);
		add(gender);
		
		JLabel Salary=new JLabel("SALARY");
		Salary.setBounds(80, 300, 150, 30);
		Salary.setFont(new Font("Tohoma",Font.BOLD,18));
		add(Salary);
		jtSalary=new JTextField();
		jtSalary.setBounds(250, 300, 150, 30);
		add(jtSalary);
		
		JLabel Subject=new JLabel("SUBJECT");
		Subject.setBounds(80, 350, 150, 30);
		Subject.setFont(new Font("Tohoma",Font.BOLD,18));
		add(Subject);
		
		jtSubject=new JTextField();
		jtSubject.setBounds(250, 350, 150, 30);
		add(jtSubject);
		
		JLabel phone=new JLabel("CONTACT");
		phone.setBounds(80, 400, 150, 30);
		phone.setFont(new Font("Tohoma",Font.BOLD,18));
		add(phone);
		jtphone=new JTextField();
		jtphone.setBounds(250, 400, 150, 30);
		add(jtphone);
		
		check=new JButton("CHECK");
		check.setBounds(90, 500, 100, 30);
		check.addActionListener(this);
		check.setFocusPainted(false);
		check.setForeground(Color.WHITE);
		check.setBackground(Color.BLACK);
		add(check);
		
		update=new JButton("UPDATE");
		update.setBounds(250, 500, 100, 30);
		update.addActionListener(this);
		update.setFocusPainted(false);
		update.setForeground(Color.WHITE);
		update.setBackground(Color.BLACK);
		add(update);
		
		back=new JButton("BACK");
		back.setBounds(400, 500, 100, 30);
		back.setForeground(Color.WHITE);
		back.setFocusPainted(false);
		back.setBackground(Color.BLACK);
		back.addActionListener(this);
		add(back);		

		getContentPane().setBackground(Color.WHITE);
		setBounds(250, 150, 1100, 600);
		setUndecorated(true);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==check)
		{
			String id=jtid.getSelectedItem();
			String query="select * from teacher where id='"+id+"'";
			
			try {
				
				JdBcCONNECTION jd2=new JdBcCONNECTION();
				ResultSet rs=jd2.st.executeQuery(query);
				
				 
				while(rs.next())
				{
					String	r=rs.getString("name");
					jtname.setText(r);
					jtage.setText(rs.getString("age"));
					gender.setText(rs.getString("gender"));
					jtSalary.setText(rs.getString("salary"));
					jtSubject.setText(rs.getString("subject"));
					jtphone.setText(rs.getString("contact"));
				}
				
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		} else if (e.getSource()==update) {
			String id=jtid.getSelectedItem();
			String name=jtname.getText();
			String age=jtage.getText();
			String gender1=gender.getText();
			String salary=jtSalary.getText();
			String subject=jtSubject.getText();
			String contact=jtphone.getText();
			
			try {
				JdBcCONNECTION jd2=new JdBcCONNECTION();
				String query2="update teacher set name='"+name+"',age='"+age+"',gender='"+gender1+"',salary='"+salary+"',subject='"+subject+"',contact='"+contact+"' where id='"+id+"'";
				
				jd2.st.executeUpdate(query2);
				JOptionPane.showMessageDialog(null, "Update SuccessFully");
				
				new UpdateTeacher();
				
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
				
			}
		}
		
		else {
			setVisible(false);
	//		new SchoolMenu();
		}
	}
	public static void main(String[] args) {
		new UpdateTeacher();
	}
	

}
