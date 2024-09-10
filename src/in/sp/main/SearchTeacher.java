package in.sp.main;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;
public class SearchTeacher extends JFrame implements ActionListener{
	
	JTable jtable;
	JButton back;
	 public SearchTeacher() {
		setLayout(null);
			
		
		jtable=new JTable();
		jtable.setBounds(0, 40, 1000, 450);
		add(jtable);
		
		JLabel j1=new JLabel("ID");
		j1.setBounds(5, 10, 100, 20);
		add(j1);
		
		JLabel j2=new JLabel("NAME");
		j2.setBounds(150, 10, 100, 20);
		add(j2);
		
		JLabel j3=new JLabel("AGE");
		j3.setBounds(290, 10, 100, 20);
		add(j3);
		
		JLabel j4=new JLabel("GENDER");
		j4.setBounds(430, 10, 100, 20);
		add(j4);
		
		JLabel j5=new JLabel("SALARY");
		j5.setBounds(570, 10, 100, 20);
		add(j5);
		
		JLabel j6=new JLabel("SUBJECT");
		j6.setBounds(720, 10, 100, 20);
		add(j6);
		
		JLabel j7=new JLabel("CONTACT");
		j7.setBounds(860, 10, 100, 20);
		add(j7);
		
		back=new JButton("BACK");
		back.setBounds(420, 500, 120, 30);
		back.setForeground(Color.WHITE);
		back.setBackground(Color.BLACK);
		back.setFocusPainted(false);
		back.addActionListener(this);
		add(back);
		
		try {
			JdBcCONNECTION jd=new JdBcCONNECTION();
			ResultSet rs=jd.st.executeQuery("select * from teacher");
			jtable.setModel(DbUtils.resultSetToTableModel(rs));
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		
		getContentPane().setBackground(Color.WHITE);
		setBounds(250, 150, 1100, 600);
		setUndecorated(true);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==back)
		{
			setVisible(false);
		//	new SchoolMenu();
		}
		
	}
	public static void main(String[] args) {
		
		new SearchTeacher();
		
	}

}
