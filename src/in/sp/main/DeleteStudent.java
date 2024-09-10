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

public class DeleteStudent extends JFrame implements ActionListener{
	
	JTextField jtname,jtcity,jtphone,jtage,gender,jtclass;

	JButton check, delete,back;
	Choice jtid;
	
	public DeleteStudent() {
		// TODO Auto-generated constructor stub
		setLayout(null);
		
		JLabel text=new JLabel("DELETE STUDENT");
		text.setBounds(380, 20, 500, 70);
		text.setFont(new Font("Tohoma",Font.BOLD,40));
		text.setForeground(Color.BLUE);
		add(text);
		
		ImageIcon im1=new ImageIcon(ClassLoader.getSystemResource("delete1.jpg"));
		Image im2=im1.getImage().getScaledInstance(550, 350, Image.SCALE_DEFAULT);
		ImageIcon im3=new ImageIcon(im2);
		JLabel image=new JLabel(im3);
		image.setBounds(500, 125, 550, 350);
		add(image);
		
		
		
		JLabel studentid=new JLabel("STUDENT ID");
		studentid.setBounds(80, 100, 150, 30);
		studentid.setFont(new Font("Tohoma",Font.BOLD,18));
		add(studentid);
		jtid=new Choice();
		jtid.setBounds(250, 100, 150, 30);
		add(jtid);
		
		try {
			JdBcCONNECTION jd=new JdBcCONNECTION();
			ResultSet rs = jd.st.executeQuery("select * from student");
			while(rs.next())
			{
				jtid.add(rs.getString("id"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		JLabel studentname=new JLabel("STUDENT NAME");
		studentname.setBounds(80, 150, 150, 30);
		studentname.setFont(new Font("Tohoma",Font.BOLD,18));
		add(studentname);
		jtname=new JTextField();
		jtname.setBounds(250, 150, 150, 30);
		add(jtname);
		
		JLabel studentage=new JLabel("STUDENT AGE");
		studentage.setBounds(80, 200, 150, 30);
		studentage.setFont(new Font("Tohoma",Font.BOLD,18));
		add(studentage);
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
		
		JLabel city=new JLabel("CITY");
		city.setBounds(80, 300, 150, 30);
		city.setFont(new Font("Tohoma",Font.BOLD,18));
		add(city);
		jtcity=new JTextField();
		jtcity.setBounds(250, 300, 150, 30);
		add(jtcity);
		
		JLabel class1=new JLabel("CLASS");
		class1.setBounds(80, 350, 150, 30);
		class1.setFont(new Font("Tohoma",Font.BOLD,18));
		add(class1);
		
		jtclass=new JTextField();
		jtclass.setBounds(250, 350, 150, 30);
		add(jtclass);
		
		JLabel phone=new JLabel("CONTACT");
		phone.setBounds(80, 400, 150, 30);
		phone.setFont(new Font("Tohoma",Font.BOLD,18));
		add(phone);
		jtphone=new JTextField();
		jtphone.setBounds(250, 400, 150, 30);
		add(jtphone);
		
		check=new JButton("CHECK");
		check.setBounds(90, 500, 100, 30);
		check.setFocusPainted(false);
		check.addActionListener(this);
		check.setForeground(Color.WHITE);
		check.setBackground(Color.BLACK);
		add(check);
		
		delete=new JButton("DELETE");
		delete.setBounds(250, 500, 100, 30);
		delete.addActionListener(this);
		delete.setFocusPainted(false);
		delete.setForeground(Color.WHITE);
		delete.setBackground(Color.BLACK);
		add(delete);
		
		back=new JButton("BACK");
		back.setBounds(400, 500, 100, 30);
		back.setFocusPainted(false);
		back.setForeground(Color.WHITE);
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
			String query="select * from student where id='"+id+"'";
			
			try {
				
				JdBcCONNECTION jd2=new JdBcCONNECTION();
				ResultSet rs=jd2.st.executeQuery(query);
				
				 
				while(rs.next())
				{
					String	r=rs.getString("name");
					jtname.setText(r);
					jtage.setText(rs.getString("age"));
					gender.setText(rs.getString("gender"));
					jtcity.setText(rs.getString("city"));
					jtclass.setText(rs.getString("class"));
					jtphone.setText(rs.getString("contact"));
				}
				
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		} else if (e.getSource()==delete) {
			String id2=jtid.getSelectedItem();
					
			
			try {
				JdBcCONNECTION jd2=new JdBcCONNECTION();
				String query2="delete from student  where id='"+id2+"'";
				
				jd2.st.executeUpdate(query2);
				JOptionPane.showMessageDialog(null, "DELETE SuccessFully");
				setVisible(false);
				new DeleteStudent();
				
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
				
			}
			if (id2.equals("")) {
				JOptionPane.showMessageDialog(null, "Id already empty");
				return;
			}
			
		}
		
		
		else {
			setVisible(false);
		//	new SchoolMenu();
		}
	}
	public static void main(String[] args) {
		new DeleteStudent();
	}
	

}
