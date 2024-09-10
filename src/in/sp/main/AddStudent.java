package in.sp.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class AddStudent extends JFrame implements ActionListener{
	
	JTextField jtid,jtname,jtcity,jtphone,jtage;
	JRadioButton jtmale,jtfemale;
	JComboBox jtclass;
	JButton submit,back;
	
	public AddStudent() {
		// TODO Auto-generated constructor stub
		setLayout(null);
		
		JLabel text=new JLabel("ADD STUDENT");
		text.setBounds(380, 30, 300, 70);
		text.setFont(new Font("Tohoma",Font.BOLD,40));
		text.setForeground(Color.BLUE);
		add(text);
		
		ImageIcon im1=new ImageIcon(ClassLoader.getSystemResource("student.jpg"));
		Image im2=im1.getImage().getScaledInstance(550, 350, Image.SCALE_DEFAULT);
		ImageIcon im3=new ImageIcon(im2);
		JLabel image=new JLabel(im3);
		image.setBounds(500, 125, 550, 350);
		add(image);
		
		
		
		JLabel teacherid=new JLabel("STUDENT ID");
		teacherid.setBounds(80, 100, 150, 30);
		teacherid.setFont(new Font("Tohoma",Font.BOLD,18));
		add(teacherid);
		jtid=new JTextField();
		jtid.setBounds(250, 100, 150, 30);
		add(jtid);
		
		JLabel teachername=new JLabel("STUDENT NAME");
		teachername.setBounds(80, 150, 150, 30);
		teachername.setFont(new Font("Tohoma",Font.BOLD,18));
		add(teachername);
		jtname=new JTextField();
		jtname.setBounds(250, 150, 150, 30);
		add(jtname);
		
		JLabel teacherage=new JLabel("STUDENT AGE");
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
		jtmale=new JRadioButton("MALE");
		jtmale.setBounds(250, 250, 70, 30);
		add(jtmale);
		jtfemale=new JRadioButton("FEMALE");
		jtfemale.setBounds(350, 250, 80, 30);
		add(jtfemale);
		ButtonGroup bGroup=new ButtonGroup();
		bGroup.add(jtmale);
		bGroup.add(jtfemale);
		
		JLabel jlcity=new JLabel("STUDENT CITY");
		jlcity.setBounds(80, 300, 150, 30);
		jlcity.setFont(new Font("Tohoma",Font.BOLD,18));
		add(jlcity);
		jtcity=new JTextField();
		jtcity.setBounds(250, 300, 150, 30);
		add(jtcity);
		
		JLabel Jlclass=new JLabel("CLASS");
		Jlclass.setBounds(80, 350, 150, 30);
		Jlclass.setFont(new Font("Tohoma",Font.BOLD,18));
		add(Jlclass);
		String[] str= {"CLASS I","CLASS II","CLASS III","CLASS IV","CLASS V","CLASS VI","CLASS VII","CLASS VIII","CLASS IX","CLASS X"};
		jtclass=new JComboBox(str);
		jtclass.setForeground(Color.WHITE);
		jtclass.setBackground(Color.BLACK);
		jtclass.setBounds(250, 350, 150, 30);
		add(jtclass);
		
		JLabel phone=new JLabel("CONTACT");
		phone.setBounds(80, 400, 150, 30);
		phone.setFont(new Font("Tohoma",Font.BOLD,18));
		add(phone);
		jtphone=new JTextField();
		jtphone.setBounds(250, 400, 150, 30);
		add(jtphone);
		
		submit=new JButton("SUBMIT");
		submit.setBounds(150, 500, 100, 30);
		submit.addActionListener(this);
		submit.setFocusPainted(false);
		submit.setForeground(Color.WHITE);
		submit.setBackground(Color.BLACK);
		add(submit);
		
		back=new JButton("BACK");
		back.setBounds(350, 500, 100, 30);
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
		
		if(e.getSource()==submit)
		{
			String id=jtid.getText();
			String name=jtname.getText();
			String age=jtage.getText();
			String contact=jtphone.getText();
			String city=jtcity.getText();
			
			String gender=null;
			if(jtmale.isSelected())
			{
				gender="MALE";
			}
			else if(jtfemale.isSelected())
			{
				gender="FEMALE";
			}
			String class1=(String)jtclass.getSelectedItem();
			
			if(id.equals("")) {
				JOptionPane.showMessageDialog(null, "ID Should not be empty");
				return;
						
			}
			else if(name.equals("")) {
				JOptionPane.showMessageDialog(null, "Name Should not be empty");
				return;			
			}
			else if(age.equals("")) {
				JOptionPane.showMessageDialog(null, "AGE Should not be empty");
				return;
						
			}
			else if(gender.equals("")) {
				JOptionPane.showMessageDialog(null, "GENDER Should not be empty");
				return;
						
			}
			else if(class1.equals("")) {
				JOptionPane.showMessageDialog(null, "Salary Should not be empty");
				return;
						
			}
			else if(city.equals("")) {
				JOptionPane.showMessageDialog(null, "city Should not be empty");
				return;
						
			}
			else if(contact.equals("")) {
				JOptionPane.showMessageDialog(null, "Contact Should not be empty");
				return;
						
			}

			
			try {
				JdBcCONNECTION jd=new JdBcCONNECTION();
				String query="insert into student values('"+id+"','"+name+"','"+age+"','"+gender+"','"+city+"','"+class1+"','"+contact+"')";
				jd.st.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "STUDENT ADD SUCCESS FULLY");
				setVisible(false);
				new AddStudent();
				
				
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
			
		}else {
			setVisible(false);
			//new SchoolMenu();
		}
		
	}
	public static void main(String[] args) {
		new AddStudent();
	}
	

}
